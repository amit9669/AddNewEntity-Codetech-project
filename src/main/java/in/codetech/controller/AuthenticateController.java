package in.codetech.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.config.JwtUtils;
import in.codetech.model.JwtRequest;
import in.codetech.model.JwtResponse;
import in.codetech.model.User;
import in.codetech.serviceImpl.UserDetailsServiceImpl;

@RestController
@ControllerAdvice
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;

	// generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			// throw new Exception("User not found ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		///// authenticate

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception {

//		Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//	
//		if(token == null) {
//			 
//		}
//		//return (ResponseEntity<Object>)token; 
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {

			throw new Exception("USER DISABLED " + e.getMessage());

		} catch (BadCredentialsException e) {

			throw new Exception("Invalid Credentials " + e.getMessage());

		}

	}

	// return the details of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {

		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));

	}
}

//private ResponseEntity<?> authenticate(String username, String password) throws Exception {
//	
//	Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//	if (token == null) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	}
//	return (ResponseEntity<?>)token;
