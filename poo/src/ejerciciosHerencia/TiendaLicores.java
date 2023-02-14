package ejerciciosHerencia;

public class TiendaLicores extends Tienda{
	@Override
	public void bienvenida() {
		super.bienvenida();
		System.out.println("Si eres menor de 18 años, fuera de aquí");
	}
}
