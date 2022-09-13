package spring;

public class Pais extends Continente{
	
	// Handled as Strings since we don't require them for any operation and are only going to be used as such
	private String nombrePais;
	private String capital;
	private String habitantes;
	private String clima;
	private String salario;
	
	public Pais(String nombrePais, String continente, String capital, String habitantes, String clima, String salario) {
		super(continente);
		this.nombrePais = nombrePais;
		this.capital = capital;
		this.habitantes = habitantes;
		this.clima = clima;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Pais [nombrePais=" + nombrePais + ", capital=" + capital + ", habitantes=" + habitantes + ", clima="
				+ clima + ", salario=" + salario + ", continente=" + getContinente() + "]";
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

}