package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.security;

import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Model.User;
import PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Services.serviceImpl.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

	public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		User user =null;
		try {
			 user = new ObjectMapper().readValue(request.getInputStream(), User.class);
		} catch (IOException e) {
			System.out.println("request mal formed");
		}
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		UserDetailsImpl user= (UserDetailsImpl) authResult.getPrincipal();
		JwtUtil.generateTokenInHttpHeader(user, response);
	}
}
