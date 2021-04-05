package online.devupgrade.sezon2.configs;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import online.devupgrade.sezon2.dto.LoginCredentials;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

public class JwtAuth extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginCredentials authRequest = getLoginCredentials(request);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    authRequest.getLogin(),
                    authRequest.getPassword(),
                    authRequest.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
            );
            setDetails(request, token);
            return this.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static LoginCredentials getLoginCredentials(HttpServletRequest request) throws IOException {
        if(request.getInputStream().markSupported()) {
            request.getInputStream().reset();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(request.getInputStream(), baos);
        byte[] bytes = baos.toByteArray();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
        return objectMapper.readValue(bytes, LoginCredentials.class);
    }


}
