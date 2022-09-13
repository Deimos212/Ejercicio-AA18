package spring;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Usuario implements MuestraUsuario{
	
	// Simulates a random ID, further IDs will be automatically 1 more than the previous
	private static int idCount = ThreadLocalRandom.current().nextInt(0, 10000);
	private int id;
	private String nombre;
	private String fechaLogin;
	private Lambda obtainFecha = () -> {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String fecha = sdf.format(dateObj);
		return fecha;
        };
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.id = idCount;
		idCount++;
		this.fechaLogin = obtainFecha.obtainFecha();
	}


	@Override
	public String muestraUsuario() {
		return "\n\nInformacion obtenida para el usuario " + getNombre() +" con ID " + getId() + " el " + getFechaLogin();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaLogin=" + fechaLogin + "]";
	}

	public static int getIdCount() {
		return idCount;
	}

	public static void setIdCount(int idCount) {
		Usuario.idCount = idCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(String fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	
}
