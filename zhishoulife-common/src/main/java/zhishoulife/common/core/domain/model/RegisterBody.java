package zhishoulife.common.core.domain.model;

/**
 * 扩展若依原生RegisterBody：保留用户名/密码+新增手机号/邮箱
 */
public class RegisterBody extends LoginBody {
    private String phonenumber;
    private String email;

    // 新增字段getter/setter
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 显式重写用户名/密码getter，确保能拿到值
    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}