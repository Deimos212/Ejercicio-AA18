package spring;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
	public static void main (String [] args)
	{
	
		try (
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.generarPaises();
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
	
}
