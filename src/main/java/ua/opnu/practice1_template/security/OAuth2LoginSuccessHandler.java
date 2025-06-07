package ua.opnu.practice1_template.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ua.opnu.practice1_template.entity.User;
import ua.opnu.practice1_template.repository.UserRepository;
import ua.opnu.practice1_template.service.JwtService;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired private UserRepository userRepository;
    @Autowired private JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUsername(email); // Or generate unique name
                    newUser.setEmail(email);
                    newUser.setPassword(""); // No password
                    newUser.setProvider("google");
                    return userRepository.save(newUser);
                });

        String token = jwtService.generateToken(user.getUsername());
        response.sendRedirect("/login/success?token=" + token); // Or expose via frontend
    }
}

