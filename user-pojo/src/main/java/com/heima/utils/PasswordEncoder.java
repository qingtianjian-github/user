package com.heima.utils;

import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密解密
 */
@NoArgsConstructor
public class PasswordEncoder extends BCryptPasswordEncoder {
    private static final long serialVersionUID = -2457336092754584769L;

    //判断从前端接收的密码与数据库中的密码是否一致
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // 接收到的前端的密码
        String pwd = rawPassword.toString();
        // 进行rsa解密
        try {
            //todo：待处理
            pwd = RsaUtils.decryptByPrivateKey("key", pwd);
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
        if (encodedPassword != null && !encodedPassword.isEmpty()) {
            return BCrypt.checkpw(pwd, encodedPassword);
        } else {
            return false;
        }
    }
}
