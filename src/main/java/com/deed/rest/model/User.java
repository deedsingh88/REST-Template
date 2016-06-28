package com.deed.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <h1>User</h1>
 * <p>This object contains user information</p>
 * 
 *
 * @author deedsing
 */

@XmlRootElement()
public class User {

   public User() {
		
	}

private String username;
   private String firstname;
   private String lastname;
   
   public User(String username ,String firstname,String lastname){
	   this.username=username;
	   this.firstname=firstname;
	   this.lastname=lastname;
   }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
}
   
}
