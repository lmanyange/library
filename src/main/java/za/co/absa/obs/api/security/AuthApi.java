package za.co.absa.obs.api.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.absa.obs.control.security.AuthController;
import za.co.absa.obs.model.security.JwtResponse;
import za.co.absa.obs.model.security.LoginRequest;
import za.co.absa.obs.model.security.MessageResponse;
import za.co.absa.obs.model.security.SignupRequest;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthApi {
    private final AuthController authController;

    public AuthApi(AuthController authController) {
        this.authController = authController;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authController.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return authController.registerUser(signUpRequest);
    }
}
