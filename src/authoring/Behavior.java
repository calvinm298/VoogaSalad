package authoring;

import java.util.HashSet;
import java.util.Set;

/* 
 * Behavior is a characteristic that is held by a GameObject
 * It includes characteristics such as movable, shoots, can die, etc.
 * 
 * @author: Summer
 */
public class Behavior {
	
	private Set<Property> myProperties;
	private String myName;
	
	public Behavior() {
		myProperties = new HashSet<>();
	}

	public Behavior (String name, Set<Property> properties) {
		myName = name;
		myProperties = new HashSet<Property>();
		myProperties = properties;
	}
	
	/*
	 * adds a property to the Behavior
	 */
	public void addProperty(Property property)  {
		myProperties.add(property);
	}
	
	/*
	 * returns all the properties
	 */
	public Set<Property> getProperties()  {
		return myProperties;
	}
	
	/*
	 * returns all the properties
	 */
	public Property getProperty(String propName)  {
		for(Property p : myProperties) {
			if(p.getName() == propName) {
				return p;
			}
		}
		return null;
	}
	
	/*
	 * returns the name of the Behavior
	 */
	public String getName() {
		return myName;
	}
	
	public String toString() {
		return myName + ": " + myProperties.toString();
	}
	
}
