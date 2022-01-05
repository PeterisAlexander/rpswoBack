package com.game.rpswoBack.api;

import java.io.InvalidObjectException;
import java.net.URI;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.game.rpswoBack.entities.UserEntity;
import com.game.rpswoBack.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserAPIController {
	UserService us;
	
	public UserAPIController(UserService us) { this.us = us;}
	
	@GetMapping(value="", produces="application/json")
	public Iterable<UserEntity> getAll() {return us.findAll();}
	
	@GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserEntity> get(@PathVariable int id) {
        try{
            UserEntity u = us.findUser(id);
            return ResponseEntity.ok(u);
        }catch ( Exception e ){
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping(value="" , consumes = "application/json")
    public ResponseEntity<UserEntity> add( @RequestBody UserEntity u ){
        System.out.println( u );
        try{
            us.addUser( u );

            // création de l'url d'accès au nouvel objet => http://localhost:8080/api/User
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( u.getId() ).toUri();

            return ResponseEntity.created( uri ).body(u);

        }catch ( InvalidObjectException e ){
            //return ResponseEntity.badRequest().build();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , e.getMessage() );
        }
    }

    @PutMapping(value="/{id}" , consumes = "application/json")
    public void update( @PathVariable int id , @RequestBody UserEntity u ){
        try{
            us.editUser( id , u );

        }catch ( NoSuchElementException e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "User introuvable" );

        }catch ( InvalidObjectException e ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , e.getMessage() );
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        // Check sur l'existance de la User, si ko => 404 not found
        try{
            UserEntity u = us.findUser(id);
        }catch( Exception e ){
            return ResponseEntity.notFound().build();
        }

        // si on a un problème à ce niveau => sql exception
        try{
            us.delete(id);
            return ResponseEntity.ok(null);
        }catch( Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }
}
