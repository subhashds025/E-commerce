package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmkey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry.time}")
    private int timmer;

   private Algorithm algorithm;

   private String USER_Email="useremail";


   @PostConstruct
    public PostConstruct getAlgorithm() throws UnsupportedEncodingException {
       algorithm=Algorithm.HMAC256(algorithmkey);
       return null;
   }

   public String getToken(Users user){
     return JWT.create()
             .withClaim(USER_Email,user.getEmail())
             .withExpiresAt(new Date(System.currentTimeMillis()+timmer))
             .withIssuer(issuer)
             .sign(algorithm);
   }

}
