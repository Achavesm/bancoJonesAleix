/**
 * 
 */
package beans;

import java.util.List;

/**
 * @author iaw39397876
 *
 */
public class Account {
	
	public String iban;
	public Cliente cliente;
	public String dni;
	public double saldo;
	public List<Transaccion> transacciones;

	public Account(String iban, String dni, double saldo) {
		super();
		this.iban = iban;
		this.dni = dni;
		this.saldo = saldo;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Account [iban=%s, cliente=%s, dni=%s, saldo=%s, transacciones=%s]", iban, cliente, dni,
				saldo, transacciones);
	}
	
}