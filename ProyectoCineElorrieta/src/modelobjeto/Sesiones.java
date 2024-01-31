package modelobjeto;

public class Sesiones {
private int ID_Sesiones;
private int Hora;
private int Dia;

public Sesiones(int iD_Sesiones, int hora, int dia) {
	super();
	ID_Sesiones = iD_Sesiones;
	Hora = hora;
	Dia = dia;
}
public int getID_Sesiones() {
	return ID_Sesiones;
}
public void setID_Sesiones(int iD_Sesiones) {
	ID_Sesiones = iD_Sesiones;
}
public int getHora() {
	return Hora;
}
public void setHora(int hora) {
	Hora = hora;
}
public int getDia() {
	return Dia;
}
public void setDia(int dia) {
	Dia = dia;
}
@Override
public String toString() {
	return "Sesiones [ID_Sesiones=" + ID_Sesiones + ", Hora=" + Hora + ", Dia=" + Dia + "]";
}


}
