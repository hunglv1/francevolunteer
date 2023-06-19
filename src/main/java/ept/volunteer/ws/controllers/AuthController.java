package ept.volunteer.ws.controllers;

import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.UserLogin;
import ept.volunteer.ws.requestpayload.request.LoginRequest;
import ept.volunteer.ws.requestpayload.response.LoginResponse;
import ept.volunteer.ws.requestpayload.response.MessageResponse;
import ept.volunteer.ws.responsitory.UserLoginRepository;
import ept.volunteer.ws.security.JwtUtils;
import ept.volunteer.ws.security.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/frvol/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserLoginRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (Exception exception) {
            logger.error("Exception exception: {}", exception.getMessage());
        }

        // return error if authentication was failed
        if (authentication == null)
            return ResponseEntity.ok(new LoginResponse(loginRequest.getEmail(), Constant.BLANK,
                    Constant.RESPONSE_MESSAGE_SIGNIN_NOT_OK, Constant.RESPONSE_CODE_401));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new LoginResponse(userDetails.getEmail(), jwt, Constant.RESPONSE_MESSAGE_OK,
                Constant.RESPONSE_CODE_200));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody LoginRequest loginRequest) {

        if (Boolean.TRUE.equals(userRepository.existsByEmail(loginRequest.getEmail()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!", "501"));
        }

        // Create new user's account
        UserLogin user = new UserLogin(loginRequest.getUserName(), loginRequest.getEmail(),
                encoder.encode(loginRequest.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!", "200"));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> registerAdminUser(@Valid @RequestBody LoginRequest loginRequest) {

        if (Boolean.TRUE.equals(userRepository.existsByEmail(loginRequest.getEmail()))) {
            return ResponseEntity.ok(new LoginResponse(loginRequest.getEmail(), Constant.BLANK,
                    Constant.RESPONSE_MESSAGE_EMAIL_EXIST, Constant.RESPONSE_CODE_501));
        }

        // Create new admin's account
        UserLogin user = new UserLogin(loginRequest.getUserName(), loginRequest.getEmail(),
                encoder.encode(loginRequest.getPassword()));

        try {
            userRepository.save(user);
        } catch(Exception exception) {
            logger.error("Exception exception: {}", exception.getMessage());
        }

        String jwt = jwtUtils.generateJwtTokenFromEmail(loginRequest.getEmail());
        return ResponseEntity.ok(new LoginResponse(loginRequest.getEmail(), jwt, Constant.RESPONSE_MESSAGE_OK,
                Constant.RESPONSE_CODE_200));
    }
}