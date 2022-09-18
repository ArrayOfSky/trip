package com.cust.trip.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GYF
 * @Data 2022.9.15
 */
@Slf4j
public class JwtUtil {

    private static final String jwtToken = "com.cust.trip";

    public static String createToken(String managerAccount){
        Map<String,Object> claims = new HashMap();
        claims.put("managerAccount",managerAccount);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，秘钥为jwtToken
                .setClaims(claims) // body数据，要唯一
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));// 一天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            log.debug("解开token失败" + e.getMessage());
        }
        return null;

    }

}