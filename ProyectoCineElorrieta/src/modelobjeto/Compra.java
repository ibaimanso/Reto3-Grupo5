package modelobjeto;

public class Compra {
	/*
	 * Objeto Compra se añade los IDCompra y DNI_Cliente se alamcenan los demas
	 */
	private int IDCompra;
	private double PrecioTotal;
	private int cantodadEntradas;
	private int descuento;
	private double PrecioDescontado;
	private String DNI_Cliente;

	public Compra(int iDCompra, String dNI_Cliente) {
		IDCompra = iDCompra;
		DNI_Cliente = dNI_Cliente;
	}

	public int getIDCompra() {
		return IDCompra;
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
		IDCompra = iDCompra;
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

}
