package com.game.rpswoBack.service;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.game.rpswoBack.entities.UserEntity;
import com.game.rpswoBack.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository ur;
	
	public UserService(UserRepository ur) { this.ur = ur;}
	
	public Iterable<UserEntity> findAll() { return ur.findAll();}
	
	public UserEntity findUser(int id) { return ur.findById(id).get();}
	
	public static boolean validate(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
	
	private void checkUser( UserEntity u ) throws InvalidObjectException {

        if( u.getUsername().length() <= 2  ){
            throw new InvalidObjectException("Nom invalide");
        }

        if( u.getEmail().length() <= 5 || !validate( u.getEmail() ) ){
            throw new InvalidObjectException("Email du client invalide");
        }

    }
	
	public void addUser( UserEntity u ) throws InvalidObjectException {
        checkUser(u);
        ur.save(u);
    }
	
	public void editUser( int id , UserEntity u) throws InvalidObjectException , NoSuchElementException {
        checkUser(u);
        try{
            UserEntity uExistante = ur.findById(id).get();

            uExistante.setUsername( u.getUsername() );
            uExistante.setEmail( u.getEmail() );
            uExistante.setPassword( u.getPassword() );
            //uExistante.setImage( c.getImage() );
            ur.save( uExistante );

        }catch ( NoSuchElementException e ){
            throw e;
        }
    }

    public void delete(int id) {
        ur.deleteById(id);
    }
}
