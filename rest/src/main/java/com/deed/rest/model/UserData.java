package com.deed.rest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <h1>User</h1>
 * <p>In memory data store for the users.
 * I am making an assumption that users are unique
 * </p>
 * 
 *
 * @author deedsing
 */

@XmlRootElement()
public class UserData {

   public static  Map<String,User> data = new HashMap<String, User>();
  
  
   public Map<String,User> getData() {
	return data;
  }


public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
}
   
}
