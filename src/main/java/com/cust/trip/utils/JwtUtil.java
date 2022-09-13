package com.cust.trip.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cust.trip.bean.Manager;
import com.cust.trip.bean.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author GYF
 * @@Data 2022.9.13
 */
@Service
public class JwtUtil {

    public String getToken(Manager manager) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(manager.getManagerAccount()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(manager.getManagerPassword()));
        return token;
    }

}
