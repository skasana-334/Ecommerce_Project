package com.Car_Rental.Car_RentalService.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

public class JwtValidator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
String jwt=request.getHeader(JwtConstant.JwtHeader);
if(jwt!=null){
    jwt=jwt.substring(7);
    try{
        SecretKey key= Keys.hmacShaKeyFor(JwtConstant.SecretKey.getBytes());
        //claims will hold the payload and statement about user.
        Claims claims=Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
       //these are email and authories assigned to user
        String email=String.valueOf(claims.get("email"));
        String authorities=String.valueOf(claims.get("authorities"));
        List<GrantedAuthority>auths= AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
        Authentication auth=new UsernamePasswordAuthenticationToken(email,null,auths);
        SecurityContextHolder.getContext().setAuthentication(auth);
    } catch (Exception e) {
throw new BadCredentialsException("bhai kya kr rha h tu");
    }
}
filterChain.doFilter(request,response);
    }
}
