package authoring;

/*
 * Event response is an action that occurs in response to an event trigger
 * has a name and a string of content 
 * 
 * @author: Summer
 */
public class EventResponse {
	
	private String myName;
	private String myContent;

	public EventResponse() {
		
	}
	
	/*
	 * returns name of event response
	 */
	public String getName() {
		return myName;
	}
	
	/*
	 * sets the name of the event response to name
	 */
	public void setName(String name) {
		myName = name;
	}
	
	/*
	 * sets the content of the event response to content
	 */
	public void setMyContent(String content) {
		myContent = content;
	}
	
	/*
	 * returns the content of the event response
	 */
	public String getMyContent() {
		return myContent;
	}
	
	public String toString() {
		return getName();
	}
		
}
