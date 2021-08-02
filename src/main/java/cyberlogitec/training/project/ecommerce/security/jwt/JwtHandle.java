package cyberlogitec.training.project.ecommerce.security.jwt;

import cyberlogitec.training.project.ecommerce.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Component
public class JwtHandle {

    public String generateJwtToken(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(JwtUtils.JWT_DURATION + now.getTime()))
                .signWith(SignatureAlgorithm.HS512, JwtUtils.JWT_SECRET)
                .compact();
    }

    public String getTokenFromRequest(HttpServletRequest request){
        String header = request.getHeader("Authorization");

        if(header != null && header.startsWith("Bearer "))
            return header.substring("Bearer ".length(), header.length());
        return null;
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(JwtUtils.JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}
