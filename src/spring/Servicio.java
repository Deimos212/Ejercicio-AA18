package spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
	ArrayList<Pais> paises = new ArrayList<Pais>();
	static Usuario user;

	public void generarPaises() {

		// Registro
		System.out.println("\n\tRegistro");
		Scanner inicio = new Scanner(System.in);
		System.out.print("Nombre: ");
		String username = inicio.nextLine();
		user = new Usuario(username);
		inicio.close();
		System.out.println("Identificado correctamente como " + username + ", ID: " + user.getId());

		try {
			Scanner sc = new Scanner(new File("INFO_PAISES.txt"), "UTF-8");
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] split = linea.split(":");

				String nombre;
				String continente;
				String capital;
				String habitantes;
				String clima;
				String salario;

				if (split[0].equals("PAIS")) {
					nombre = split[1];
					continente = (sc.nextLine().split(":"))[1].trim();
					capital = (sc.nextLine().split(":"))[1].trim();
					habitantes = (sc.nextLine().split(":"))[1].trim();
					clima = (sc.nextLine().split(":"))[1].trim();
					salario = (sc.nextLine().split(":"))[1].trim();

					paises.add(new Pais(nombre, continente, capital, habitantes, clima, salario));
				} else {
					System.out.println("Error en la lectura del archivo, el formato no es válido.");
				}
			}
			
			for (Pais pais : paises) {
				try {
					StringBuilder sb = new StringBuilder("PAIS: " + pais.getNombrePais());
					sb.append("\nContinente: " + pais.getContinente());
					sb.append("\nCapital: " + pais.getCapital());
					sb.append("\nHabitantes: " + pais.getHabitantes());
					sb.append("\nClima predominante: " + pais.getClima());
					sb.append("\nSalario Minimo: " + pais.getSalario());
					sb.append(user.muestraUsuario());
					Files.write(Paths.get(pais.getNombrePais()+".txt"), Arrays.asList(sb.toString()), StandardCharsets.UTF_8);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void runLambda() {
	}

}