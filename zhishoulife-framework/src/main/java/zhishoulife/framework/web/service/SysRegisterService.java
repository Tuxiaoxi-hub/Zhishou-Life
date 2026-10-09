package zhishoulife.framework.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhishoulife.common.constant.CacheConstants;
import zhishoulife.common.constant.Constants;
import zhishoulife.common.constant.UserConstants;
import zhishoulife.common.core.domain.entity.SysUser;
import zhishoulife.common.core.domain.model.RegisterBody;
import zhishoulife.common.core.redis.RedisCache;
import zhishoulife.common.exception.user.CaptchaException;
import zhishoulife.common.exception.user.CaptchaExpireException;
import zhishoulife.common.utils.DateUtils;
import zhishoulife.common.utils.MessageUtils;
import zhishoulife.common.utils.SecurityUtils;
import zhishoulife.common.utils.StringUtils;
import zhishoulife.framework.manager.AsyncManager;
import zhishoulife.framework.manager.factory.AsyncFactory;
import zhishoulife.system.service.ISysConfigService;
import zhishoulife.system.service.ISysUserService;

/**
 * 注册校验方法（扩展版：新增手机号/邮箱处理，基于原版修改）
 *
 * @author ruoyi
 */
@Component
public class SysRegisterService
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 注册（新增手机号/邮箱校验+入库）
     */
    public String register(RegisterBody registerBody)
    {
        String msg = "", username = registerBody.getUsername(), password = registerBody.getPassword();
        // ========== 新增：获取手机号/邮箱 ==========
        String phonenumber = registerBody.getPhonenumber();
        String email = registerBody.getEmail();

        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        // ========== 新增：赋值手机号/邮箱到SysUser ==========
        sysUser.setPhonenumber(phonenumber);
        sysUser.setEmail(email);

        // 验证码开关（原版逻辑保留）
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        if (captchaEnabled)
        {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }

        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        // ========== 新增：手机号/邮箱非空校验 ==========
        else if (StringUtils.isEmpty(phonenumber))
        {
            msg = "手机号不能为空";
        }
        else if (StringUtils.isEmpty(email))
        {
            msg = "邮箱不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        }
        else if (!userService.checkUserNameUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        }
        // ========== 新增：手机号/邮箱唯一校验 ==========
        else if (!userService.checkPhoneUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，手机号已存在";
        }
        else if (!userService.checkEmailUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，邮箱已存在";
        }
        else
        {
            sysUser.setNickName(username);
            sysUser.setPwdUpdateDate(DateUtils.getNowDate());
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            // 手机号/邮箱已提前赋值，registerUser会自动入库
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag)
            {
                msg = "注册失败,请联系系统管理人员";
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 校验验证码（原版逻辑完全保留，未做任何修改）
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}