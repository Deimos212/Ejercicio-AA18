package spring;

public class Continente {
	
	private String continente;

	public Continente(String continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Continente [continente=" + continente + "]";
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
}
