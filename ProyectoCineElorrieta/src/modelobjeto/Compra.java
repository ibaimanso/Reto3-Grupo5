package modelobjeto;

import java.util.Objects;

public class Compra {
	/*
	 * Objeto Compra se añade los IDCompra y DNI_Cliente se alamcenan los demas
	 */
	private int iDCompra;
	private double PrecioTotal;
	private int cantodadEntradas;
	private int descuento;
	private double PrecioDescontado;
	private String DNI_Cliente;

	public Compra(int iDCompra, String dNI_Cliente) {
		this.iDCompra = iDCompra;
		this.DNI_Cliente = dNI_Cliente;
	}

	public int getIDCompra() {
		return iDCompra;
	}

	public double getPrecioTotal() {
		return PrecioTotal;
	}

	public int getCantodadEntradas() {
		return cantodadEntradas;
	}

	public int getDescuento() {
		return descuento;
	}

	public double getPrecioDescontado() {
		return PrecioDescontado;
	}

	public String getDNI_Cliente() {
		return DNI_Cliente;
	}

	public void setIDCompra(int iDCompra) {
		iDCompra = iDCompra;
	}

	public void setPrecioTotal(double precioTotal) {
		PrecioTotal = precioTotal;
	}

	public void setCantodadEntradas(int cantodadEntradas) {
		this.cantodadEntradas = cantodadEntradas;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setPrecioDescontado(double precioDescontado) {
		PrecioDescontado = precioDescontado;
	}

	public void setDNI_Cliente(String dNI_Cliente) {
		DNI_Cliente = dNI_Cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI_Cliente, iDCompra, PrecioDescontado, PrecioTotal, cantodadEntradas, descuento);
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
		return Objects.equals(DNI_Cliente, other.DNI_Cliente) && iDCompra == other.iDCompra
				&& Double.doubleToLongBits(PrecioDescontado) == Double.doubleToLongBits(other.PrecioDescontado)
				&& Double.doubleToLongBits(PrecioTotal) == Double.doubleToLongBits(other.PrecioTotal)
				&& cantodadEntradas == other.cantodadEntradas && descuento == other.descuento;
	}

}
