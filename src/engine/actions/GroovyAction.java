package engine.actions;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import engine.GameElement;
import engine.events.elementevents.CollisionEvent;
import engine.events.elementevents.ElementEvent;
import engine.groovy.GroovyEngine;
import engine.groovy.GroovyException;
import engine.groovy.GroovyExecutor;

public class GroovyAction implements Action {
	
	private String content;
	
	public GroovyAction() {
		
	}
	
	public GroovyAction(String executionContent) {
		this();
		content = executionContent;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public void act(ElementEvent e, GameElement ge) {
		ScriptEngine engine = GroovyEngine.returnScriptEngine();
		engine.put(ge.getIdentifier(), ge);
		if (e instanceof CollisionEvent) {
			CollisionEvent ce = (CollisionEvent) e;
			engine.put(ce.getOtherElement(ge).getIdentifier(), ce.getOtherElement(ge));
		}
		execute(content, engine);
	}
	
	private Object execute(String script, ScriptEngine eng) {
		try {
			return eng.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
			throw new GroovyException("cannot evaluate groovy expression");
		}
	}

	public void setContent(String newContent) {
		content = newContent;
	}
	
	public GroovyAction clone() {
		GroovyAction er = new GroovyAction();
		er.setContent(this.getContent());
		return er;
	}
	
	public String toString() {
		return content;
	}
}
