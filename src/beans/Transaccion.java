
package beans;

public class Transaccion {
	
	private long id;
	private String fecha;
	private double importe;
	private String origen;
	private String destino;
	
	
	public Transaccion(long id, String fecha, double importe, String origen, String destino) {		
		this.id = id;
		this.fecha = fecha;
		this.importe = importe;
		this.origen = origen;
		this.destino = destino;
	}


	public long getId() {
		return id;
	}


	public String getFecha() {
		return fecha;
	}


	public double getImporte() {
		return importe;
	}


	public String getOrigen() {
		return origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	
}