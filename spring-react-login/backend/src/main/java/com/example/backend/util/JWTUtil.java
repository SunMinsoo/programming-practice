package com.example.backend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JWTUtil {

    private static final SecretKey secretKey;
    private static final Long accessTokenExpiresIn;     // 토큰 만료
    private static final Long refreshToeknExpiresIn;    // 리프레쉬 토큰 만료

    static {
        String secretKeyString = "himmynameisnothing";
        secretKey = new SecretKeySpec(secretKeyString.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());

        accessTokenExpiresIn = 3600L * 1000;    // 1시간
        refreshToeknExpiresIn = 604800L * 1000; // 7일
    }

    /**
     * JWT 토큰 유효 여부 메서드
     */
    public static Boolean isValid(String token, Boolean isAccess) {
        // try를 한 이유는 시간을 잡을 때 만료된 것일 때 자동으로 예외처리를 진행
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String type = claims.get("type", String.class);
            if (type == null) {
                return false;
            }
            if (isAccess && !type.equals("access")) {
                return false;
            }
            if (!isAccess && !type.equals("refresh")) {
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // JWT 클레임 username 파싱
    public static String getUsername(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("sub", String.class);
    }

    // JWT 클레임 username 파싱
    public static String getRole(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", String.class);
    }

    /**
     * JWT(Access/Refesh) 토큰 생성 메서드
     * isAccess : Access 토큰 vs Refresh 토큰 인지 결정
     */
    public static String createJWT(String username, String role, Boolean isAccess) {

        long now = System.currentTimeMillis();
        long expire = isAccess ? accessTokenExpiresIn : refreshToeknExpiresIn;
        String type = isAccess ? "access" : "refresh";

        return Jwts.builder()
                .claim("sub", username)
                .claim("role", role)
                .claim("type", type)
                .issuedAt(new Date(now))
                .expiration(new Date(now + expire))
                .signWith(secretKey)
                .compact();
    }
}
