package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.*;
import com.bezkoder.spring.jwt.mongodb.repository.PatientRepository;
import com.bezkoder.spring.jwt.mongodb.repository.RoleRepository;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/patient")
	@PreAuthorize("hasRole('PATIENT') or hasRole('CHIRURGIEN')")
	public String userAccess() {
		return "patient Content.";
	}

	@GetMapping("/chirurgien")
	@PreAuthorize("hasRole('CHIRURGIEN')")
	public String moderatorAccess() {
		return "chirurgien Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('CHIRURGIEN')")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}


	//get user by username
//	@GetMapping("/patients/{username}")
//	@PreAuthorize("hasRole('CHIRURGIEN')")
//	public Optional<User> getUserByUsername(@PathVariable String username) {
//		return userService.getUserByUsername(username);
//	}

	@GetMapping("/user/{id}")
	//@PreAuthorize("hasRole('CHIRURGIEN')")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		Optional<User> user =userService.getUserById(id);
		if (user.isPresent()){
			return new ResponseEntity<>(user.get() ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}


	@PutMapping("/patient/{id}")
	public ResponseEntity<User> UpdatePatient(@PathVariable String id, @RequestBody Patient patient){

		Optional<User> userToUpdate = userService.getUserById(id);
		if (userToUpdate.isPresent()){
			Patient _user = (Patient) userToUpdate.get();
			_user.setNom(patient.getNom());
			_user.setPrenom(patient.getPrenom());
			_user.setNumTel(patient.getNumTel());
			_user.setPoids(patient.getPoids());
			_user.setTaille(patient.getTaille());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/chirurgien/{id}")
	public ResponseEntity<User> UpdateChirurgien(@PathVariable String id, @RequestBody Chirurgien chirurgien){

		Optional<User> userToUpdate = userService.getUserById(id);
		if (userToUpdate.isPresent()){
			Chirurgien _user = (Chirurgien) userToUpdate.get();
			_user.setNom(chirurgien.getNom());
			_user.setPrenom(chirurgien.getPrenom());
			_user.setNumTel(chirurgien.getNumTel());
			_user.setNumTelAdomicile(chirurgien.getNumTelAdomicile());
			_user.setNumTelPersonnel(chirurgien.getNumTelPersonnel());
			_user.setNumeroRPS(chirurgien.getNumeroRPS());
			_user.setCivilite(chirurgien.getCivilite());
			_user.setDiscipline(chirurgien.getDiscipline());
			_user.setLieuxConsultation(chirurgien.getLieuxConsultation());
			_user.setLieuxInterventionChirurgicale(chirurgien.getLieuxInterventionChirurgicale());
			_user.setAdresseAdomicile(chirurgien.getAdresseAdomicile());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/medecin/{id}")
	public ResponseEntity<User> UpdateDoctor(@PathVariable String id, @RequestBody Medecin medecin){

		Optional<User> userToUpdate = userService.getUserById(id);
		if (userToUpdate.isPresent()){
			Medecin _user = (Medecin) userToUpdate.get();
			_user.setNom(medecin.getNom());
			_user.setPrenom(medecin.getPrenom());
			_user.setNumTel(medecin.getNumTel());
			_user.setNumeroRPS(medecin.getNumeroRPS());
			_user.setDiscipline(medecin.getDiscipline());
			_user.setLieuxConsultation(medecin.getLieuxConsultation());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/personnel/{id}")
	public ResponseEntity<User> UpdatePersonnel(@PathVariable String id, @RequestBody Personnel personnel){

		Optional<User> userToUpdate = userService.getUserById(id);
		if (userToUpdate.isPresent()){
			Personnel _user = (Personnel) userToUpdate.get();
			_user.setNom(personnel.getNom());
			_user.setPrenom(personnel.getPrenom());
			_user.setNumTel(personnel.getNumTel());
			_user.setDiscipline(personnel.getDiscipline());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@PutMapping("/patient/{id}")
//	public ResponseEntity<User> UpdateUser(@PathVariable String id,@RequestBody User user){
//
//		Optional<User> userToUpdate = userService.getUserById(id);
//		if (userToUpdate.isPresent()){
//			User _user = userToUpdate.get();
//			_user.setNom(user.getNom());
//			_user.setPrenom(user.getPrenom());
//			_user.setNumTel(user.getNumTel());
//
//			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> DeleteUser(@PathVariable String id) {
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* get list patient */
	@GetMapping("/patients")
	//@PreAuthorize("hasRole('CHIRURGIEN')")
	public List<User> getAllPatients() {
		Role theRole = roleRepository.findByName(ERole.ROLE_PATIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		String rolePatient = theRole.getName().name();
		String idRolePatient = theRole.getId();
		System.out.println("role name : " + rolePatient + " id role : " + idRolePatient);
		return userService.getUsersByRole(idRolePatient);
	}

	/* get list chirurgien */
	@GetMapping("/chirurgiens")
	//@PreAuthorize("hasRole('CHIRURGIEN')")
	public List<User> getAllChirurgiens() {
		Role theRole = roleRepository.findByName(ERole.ROLE_CHIRURGIEN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		String roleChirurgien = theRole.getName().name();
		String idRoleChirurgien = theRole.getId();
		System.out.println("role name : " + roleChirurgien + " id role : " + idRoleChirurgien);
		return userService.getUsersByRole(idRoleChirurgien);
	}
	/* get list medecin */
	@GetMapping("/doctors")
	//@PreAuthorize("hasRole('CHIRURGIEN')")
	public List<User> getAllDoctors() {
		Role theRole = roleRepository.findByName(ERole.ROLE_MEDECIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		String role = theRole.getName().name();
		String id = theRole.getId();
		System.out.println("role name : " + role + " id role : " + id);
		return userService.getUsersByRole(id);
	}

	/* get list personnel */
	@GetMapping("/personnels")
	//@PreAuthorize("hasRole('CHIRURGIEN')")
	public List<User> getAllPersonnels() {
		Role theRole = roleRepository.findByName(ERole.ROLE_PERSONNEL)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		String role = theRole.getName().name();
		String id = theRole.getId();
		System.out.println("role name : " + role + " id role : " + id);
		return userService.getUsersByRole(id);
	}

	}

