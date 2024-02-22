package modelobjeto;

import java.util.Objects;

public class Compra {
	/*
	 * Objeto Compra se añade los IDCompra y DNI_Cliente se alamcenan los demas
	 */
	private int iDCompra;
	private double precioTotal;
	private int cantodadEntradas;
	private int descuento;
	private double precioDescontado;
	private String dNI_Cliente;

	public Compra(int iDCompra, String dNI_Cliente) {
		this.iDCompra = iDCompra;
		this.dNI_Cliente = dNI_Cliente;
	}

	public int getIDCompra() {
		return iDCompra;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public int getCantodadEntradas() {
		return cantodadEntradas;
	}

	public int getDescuento() {
		return descuento;
	}

	public double getPrecioDescontado() {
		return precioDescontado;
	}

	public String getDNI_Cliente() {
		return dNI_Cliente;
	}

	public void setIDCompra(int iDCompra) {
		this.iDCompra = iDCompra;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setCantodadEntradas(int cantodadEntradas) {
		this.cantodadEntradas = cantodadEntradas;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setPrecioDescontado(double precioDescontado) {
		this.precioDescontado = precioDescontado;
	}

	public void setDNI_Cliente(String dNI_Cliente) {
		this.dNI_Cliente = dNI_Cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dNI_Cliente, iDCompra, precioDescontado, precioTotal, cantodadEntradas, descuento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(dNI_Cliente, other.dNI_Cliente) && iDCompra == other.iDCompra
				&& Double.doubleToLongBits(precioDescontado) == Double.doubleToLongBits(other.precioDescontado)
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal)
				&& cantodadEntradas == other.cantodadEntradas && descuento == other.descuento;
	}

}
