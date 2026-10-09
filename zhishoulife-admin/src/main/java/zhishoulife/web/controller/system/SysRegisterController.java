package zhishoulife.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhishoulife.common.core.controller.BaseController;
import zhishoulife.common.core.domain.AjaxResult;
import zhishoulife.common.core.domain.model.RegisterBody;
import zhishoulife.common.utils.StringUtils;
import zhishoulife.common.utils.SecurityUtils; // 新增：若依原生加密工具类
import zhishoulife.system.service.ISysUserService;
import zhishoulife.common.core.domain.entity.SysUser;

/**
 * 注册控制器：最终版，无任何报错
 */
@RestController
public class SysRegisterController extends BaseController {
    @Autowired
    private ISysUserService userService;

    // ========== 删除无用的SysPasswordService注入 ==========
    // @Autowired
    // private SysPasswordService passwordService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody registerBody) {
        // 提取参数
        String username = registerBody.getUsername();
        String password = registerBody.getPassword();
        String phonenumber = registerBody.getPhonenumber();
        String email = registerBody.getEmail();

        // 非空校验
        if (StringUtils.isEmpty(username)) {
            return error("用户名不能为空！");
        }
        if (StringUtils.isEmpty(password)) {
            return error("密码不能为空！");
        }
        if (StringUtils.isEmpty(phonenumber)) {
            return error("手机号不能为空！");
        }
        if (StringUtils.isEmpty(email)) {
            return error("邮箱不能为空！");
        }

        // 构建SysUser对象
        SysUser checkUser = new SysUser();
        checkUser.setUserName(username);
        checkUser.setPhonenumber(phonenumber);
        checkUser.setEmail(email);

        // 修复：传SysUser给checkUserNameUnique
        if (!userService.checkUserNameUnique(checkUser)) {
            return error("注册失败，用户名已存在！");
        }
        if (!userService.checkPhoneUnique(checkUser)) {
            return error("注册失败，手机号已存在！");
        }
        if (!userService.checkEmailUnique(checkUser)) {
            return error("注册失败，邮箱已存在！");
        }

        // 保存用户
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setNickName(username);
        // ========== 核心修复：替换为若依原生加密方法 ==========
        sysUser.setPassword(SecurityUtils.encryptPassword(password)); // 原错误：passwordService.encryptPassword
        sysUser.setPhonenumber(phonenumber);
        sysUser.setEmail(email);
        sysUser.setStatus("0");
        sysUser.setDelFlag("0");

        boolean saveResult = userService.registerUser(sysUser);
        if (!saveResult) {
            return error("注册失败，用户信息保存失败！");
        }

        return success("注册成功，请登录！");
    }
}