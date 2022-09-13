package spring;

import java.nio.file.Files;
import java.nio.file.Path;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspectos 
{
	@Before("execution(* generarPaises())")
	public void logBefore()
	{
		boolean exists = Files.exists(Path.of("INFO_PAISES.txt"));
		if (exists) {
			System.out.println("Se ha detectado un archivo válido.");
			System.out.println("Se va a proceder a diversificar los datos del mismo.");
		} else {
			System.out.println("No se ha encontrado el fichero necesario.");
		}
	}
	
	@After("execution(* generarPaises())")
	public void logAfter()
	{
		Usuario user = Servicio.user;
		if (user != null) {
			System.out.println("\nSe ha completado el proceso, que tenga un buen resto del día, Sr/a " + user.getNombre()+".");
		} else {
			System.out.println("\nSe ha completado el proceso en modo anónimo. Terminando el programa.");
		}
	}
	
}