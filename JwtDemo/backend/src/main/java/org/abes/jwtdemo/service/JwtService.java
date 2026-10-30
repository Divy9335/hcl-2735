package org.abes.jwtdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.abes.jwtdemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expireMs;

    public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.expiration-ms}") long expireMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
        this.expireMs = expireMs;
    }

    public String generateToken(String username){
        Date date = new Date();
        return JWT.create().withSubject(username).withIssuedAt(date).withExpiresAt(new Date(date.getTime()+expireMs)).sign(algorithm);
    }

    public String verifyAndGetUsername(String token){
        try {
            return verifier.verify(token).getSubject();
        }catch (Exception e){
            return null;
        }
    }

}
