package com.heima.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * JWT工具类
 *
 * @author cjw
 */
@Data
@Component
@Slf4j
public class JwtUtils implements Serializable {
    private static final long serialVersionUID = -1792669714667920425L;

    /**
     * 过期时间：7天，s为单位
     */
    private static long expire = 604800;

    /**
     * 安全认证
     */
    private static String secret = "abcdefghabcdefghabcdefghabcdefgh";

    /**
     * 请求头信息
     */
    private static String header = "Authorization";

    /**
     * 生成jwt
     *
     * @param userName
     * @return
     */
    public String generateToken(String userName) {
        Date nowDate = new Date();
        // 7天过期
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);
        return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(userName).setIssuedAt(nowDate).setExpiration(expireDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 解析jwt
     *
     * @param jwt
     * @return
     */
    public Claims getClaimsByToken(String jwt) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            log.error("解析jwt失败,异常:", e);
            return null;
        }
    }

    // 判断JWT是否过期
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
