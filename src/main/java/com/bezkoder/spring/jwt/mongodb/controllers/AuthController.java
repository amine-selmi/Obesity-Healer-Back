package com.bezkoder.spring.jwt.mongodb.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bezkoder.spring.jwt.mongodb.models.*;
import com.bezkoder.spring.jwt.mongodb.payload.request.*;
import com.bezkoder.spring.jwt.mongodb.repository.ChirurgienRepository;
import com.bezkoder.spring.jwt.mongodb.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jwt.mongodb.payload.response.JwtResponse;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.RoleRepository;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import com.bezkoder.spring.jwt.mongodb.security.jwt.JwtUtils;
import com.bezkoder.spring.jwt.mongodb.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ChirurgienRepository chirurgienRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	public static String currentUserUsername ;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		currentUserUsername = userDetails.getUsername() ;
		System.out.println("username current user : " + currentUserUsername);

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, SignupRequestChirurgien signupRequestChirurgien) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		String strRole = signUpRequest.getRoles();


		if (strRole == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			//roles.add(userRole);
		} else {

				switch (strRole) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						//roles.add(adminRole);
						strRole = "ROLE_ADMIN";
						break;

					case "chirurgien":
						Role chirurgienRole = roleRepository.findByName(ERole.ROLE_CHIRURGIEN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						//roles.add(chirurgienRole);
						strRole = "ROLE_CHIRURGIEN";
						Chirurgien ch = new Chirurgien();
						ch.setUsername(signupRequestChirurgien.getUsername());
						ch.setEmail(signupRequestChirurgien.getEmail());
						ch.setPassword(signupRequestChirurgien.getPassword());
						ch.setCivilite(signupRequestChirurgien.getCivilite());
						ch.setAdresseAdomicile(signupRequestChirurgien.getAdresseAdomicile());
						ch.setNumTelAdomicile(signupRequestChirurgien.getNumTelAdomicile());
						//roles.add(chirurgienRole);
						ch.setRoles(chirurgienRole);
						chirurgienRepository.save(ch);
						System.out.println("chirurgien !!!!" + signupRequestChirurgien.getUsername());

						break;

//					case "personnel":
//						Role personnelRole = roleRepository.findByName(ERole.ROLE_PERSONNEL)
//								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//						//roles.add(personnelRole);

						//break;

					case "medecin":
						Role medecinRole = roleRepository.findByName(ERole.ROLE_MEDECIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						//roles.add(medecinRole);

						break;

					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_PATIENT)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						//roles.add(userRole);
				}
			}


		//user.setRoles(strRole);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

/*	ResponseEntity<> verifUser (String username , String email ){
		MessageResponse msg = new MessageResponse() ;
		if (userRepository.existsByUsername(username)) {
			msg = "Error: Username is already taken!";
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(email)) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
	}*/
	//register Admin
	@PostMapping("/signup/admin")
	ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signupRequest) {
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		String strRoles = signupRequest.getRoles();
		User admin = new User();

		admin.setNom(signupRequest.getNom());
		admin.setPrenom(signupRequest.getPrenom());
		admin.setUsername(signupRequest.getUsername());
		admin.setEmail(signupRequest.getEmail());
		admin.setPassword(encoder.encode(signupRequest.getPassword()));


		Role adminRole =  roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

		admin.setRoles(adminRole);
		userRepository.save(admin);
		String s= adminRole.toString();
		System.out.println("role is: "+s);



		return ResponseEntity.ok(new MessageResponse("Admin "+admin.getUsername()+ " registered successfully!"));
	}

//register chirurgien
	@PostMapping("/signup/chirurgien")
	ResponseEntity<?> registerChirurgien(@Valid @RequestBody SignupRequestChirurgien signupRequestChirurgien) {
		if (userRepository.existsByUsername(signupRequestChirurgien.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signupRequestChirurgien.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		String strRoles = signupRequestChirurgien.getRoles();
		Chirurgien ch = new Chirurgien();

			ch.setNom(signupRequestChirurgien.getNom());
			ch.setPrenom(signupRequestChirurgien.getPrenom());
			ch.setUsername(signupRequestChirurgien.getUsername());
			ch.setEmail(signupRequestChirurgien.getEmail());
			ch.setPassword(encoder.encode(signupRequestChirurgien.getPassword()));
			ch.setCivilite(signupRequestChirurgien.getCivilite());
			ch.setAdresseAdomicile(signupRequestChirurgien.getAdresseAdomicile());
			ch.setDiscipline(signupRequestChirurgien.getDiscipline());
			ch.setLieuxConsultation(signupRequestChirurgien.getLieuxConsultation());
			ch.setLieuxInterventionChirurgicale(signupRequestChirurgien.getLieuxInterventionChirurgicale());
			ch.setNumTelAdomicile(signupRequestChirurgien.getNumTelAdomicile());
			ch.setNumTelPersonnel(signupRequestChirurgien.getNumTelPersonnel());
			ch.setNumeroRPS(signupRequestChirurgien.getNumeroRPS());

		Role chirurgienRole = roleRepository.findByName(ERole.ROLE_CHIRURGIEN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

			ch.setRoles(chirurgienRole);
			chirurgienRepository.save(ch);
			String s= chirurgienRole.toString();
			System.out.println("role is: "+s);
			userRepository.save(ch);


		return ResponseEntity.ok(new MessageResponse("Chirurgien "+ch.getUsername()+ " registered successfully!"));
	}
//Register patient
	@PostMapping("/signup/patient")
	@PreAuthorize("hasRole('CHIRURGIEN')")
	ResponseEntity<?> registerPatient(@Valid @RequestBody SignupRequestPatient requestPatient) {
		if (userRepository.existsByUsername(requestPatient.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(requestPatient.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		//String strRoles = requestPatient.getRoles();
		Patient patient = new Patient();
		patient.setNom(requestPatient.getNom());
		patient.setPrenom(requestPatient.getPrenom());
		patient.setUsername(requestPatient.getUsername());
		patient.setEmail(requestPatient.getEmail());
		patient.setPassword(encoder.encode(requestPatient.getPassword()));
		patient.setTaille(requestPatient.getTaille());
		patient.setPoids(requestPatient.getPoids());
		patient.setChirurgienUsername(requestPatient.getChirurgienUsername());
		Role patientRole = roleRepository.findByName(ERole.ROLE_PATIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		//roles.add(patientRole);
		patient.setRoles(patientRole);
		String s= patientRole.toString();
		patientRepository.save(patient);
		System.out.println("role is: "+s);
		userRepository.save(patient);
		return ResponseEntity.ok(new MessageResponse("patient "+patient.getUsername()+ " registered successfully!"));
	}
	//Register personnel
	@PostMapping("/signup/personnel")
	@PreAuthorize("hasRole('CHIRURGIEN')")
	ResponseEntity<?> registerPersonnel(@Valid @RequestBody SignupRequestPersonnel signupRequestPersonnel) {
		if (userRepository.existsByUsername(signupRequestPersonnel.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(signupRequestPersonnel.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		String strRoles = signupRequestPersonnel.getRoles();
		Personnel personnel = new Personnel();
		personnel.setNom(signupRequestPersonnel.getNom());
		personnel.setPrenom(signupRequestPersonnel.getPrenom());
		personnel.setUsername(signupRequestPersonnel.getUsername());
		personnel.setEmail(signupRequestPersonnel.getEmail());
		personnel.setPassword(encoder.encode(signupRequestPersonnel.getPassword()));
		personnel.setDiscipline(signupRequestPersonnel.getDiscipline());

		Role personnelRole = roleRepository.findByName(ERole.ROLE_PERSONNEL)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		personnel.setRoles(personnelRole);
		String s= personnelRole.getName().name();
		System.out.println("role is: "+s);
		userRepository.save(personnel);
		return ResponseEntity.ok(new MessageResponse("Personnel de santé "+personnel.getUsername()+ " registered successfully!"));
	}
	//Register medecin
	@PostMapping("/signup/medecin")
	@PreAuthorize("hasRole('CHIRURGIEN')")
	ResponseEntity<?> registerMedecin(@Valid @RequestBody SignupRequestMedecin signupRequestMedecin) {
		if (userRepository.existsByUsername(signupRequestMedecin.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(signupRequestMedecin.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		String strRoles = signupRequestMedecin.getRoles();
		Medecin medecin = new Medecin();
		medecin.setNom(signupRequestMedecin.getNom());
		medecin.setPrenom(signupRequestMedecin.getPrenom());
		medecin.setUsername(signupRequestMedecin.getUsername());
		medecin.setEmail(signupRequestMedecin.getEmail());
		medecin.setPassword(encoder.encode(signupRequestMedecin.getPassword()));
		medecin.setDiscipline(signupRequestMedecin.getDiscipline());
		medecin.setNumeroRPS(signupRequestMedecin.getNumeroRPS());
		medecin.setLieuxConsultation(signupRequestMedecin.getLieuxConsultation());



		Role medecinRole =roleRepository.findByName(ERole.ROLE_MEDECIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		//roles.add(patientRole);
		medecin.setRoles(medecinRole);
		String s= medecinRole.toString();
		//patientRepository.save(patient);
		System.out.println("role is: "+s);
		userRepository.save(medecin);
		return ResponseEntity.ok(new MessageResponse("Medecin "+medecin.getUsername()+ " registered successfully!"));
	}


}
