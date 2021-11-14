package com.edu.utez.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.edu.utez.DTO.JwtDTO;
import com.edu.utez.DTO.LoginUsuario;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Service.UsuarioService;
import com.edu.utez.enums.RolNombre;
import com.edu.utez.jwt.JwtProvider;

import javax.validation.Valid;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private UsuarioService usuarioService;
	@PostMapping("/auth/login")
	public ResponseEntity<JwtDTO> responseEntity(@Valid @RequestBody LoginUsuario loginUsuario, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity("Datos incompletos",HttpStatus.BAD_REQUEST);
		}
		try {
				
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginUsuario.getUsername(),loginUsuario.getPassword())
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtProvider.generateToken(authentication);
			UserDetails details = (UserDetails) authentication.getPrincipal();
			JwtDTO dto = new JwtDTO(token,details.getUsername(),details.getAuthorities());
			return new ResponseEntity(dto,HttpStatus.OK);
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			return new ResponseEntity("Usuario y/o contraseña incorrectos",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/auth/register/{rol}")
	public ResponseEntity<?> saveUser(@Valid @RequestBody Usuario user,@PathVariable("rol") RolNombre rol){
		
		return ResponseEntity.ok(usuarioService.save(user, rol));
	}
	

}
