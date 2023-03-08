package com.sungjin.jobfair.service;


import com.sungjin.jobfair.command.UserVO;
import io.jsonwebtoken.*;

import java.util.Date;

public class TokenUtils {

    private static final String JWT_SECRET = "secretKey";
    private static final int JWT_EXPIRATION_MS = 604800000;


    public static String generateToken(UserVO vo){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+JWT_EXPIRATION_MS);




        return Jwts.builder()
                .setSubject(vo.getUser_id())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .setClaims(createClaim(vo))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }




    public static String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                        .getBody();

//        System.out.println("id:"+claims.getId());
//        System.out.println("issuer:"+claims.getIssuer());
//        System.out.println("issue:"+claims.getIssuedAt().toString());
        System.out.println("subject:"+claims.getSubject());
//        System.out.println("Audience:"+claims.getAudience());
//        System.out.println("expire:"+claims.getExpiration().toString());
//        System.out.println("userName:"+claims.get("userName"));

        return claims.getSubject();
    }


    private static Claims createClaim(UserVO vo){
        Claims claims = Jwts.claims().setSubject(vo.getUser_id());
        claims.put("user_id",vo.getUser_id());
        claims.put("mg_auth",vo.getMg_auth());
        claims.put("user_name",vo.getUser_name());
        claims.put("user_email",vo.getUser_email());

        return claims;
    }


    // Jwt 토큰 유효성 검사
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature"+ e);
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token"+ e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token"+ e);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token"+ e);
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty."+ e);
        }
        return false;
    }



}