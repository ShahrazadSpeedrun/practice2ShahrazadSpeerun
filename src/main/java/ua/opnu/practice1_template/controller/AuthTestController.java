package ua.opnu.practice1_template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class AuthTestController {

    @GetMapping("/jwt")
    public ResponseEntity<String> testJwt(Authentication authentication) {
        return ResponseEntity.ok("✅ Access granted via JWT! Hello, " + authentication.getName());
    }

    // http://localhost:8080/api/test/oauth http://localhost:8080/oauth2/authorization/github
    @GetMapping("/oauth")
    public ResponseEntity<String> testOauth(Authentication authentication) {
        return ResponseEntity.ok("🌐 Access granted via OAuth2! Welcome, " + authentication.getName());
    }
}
