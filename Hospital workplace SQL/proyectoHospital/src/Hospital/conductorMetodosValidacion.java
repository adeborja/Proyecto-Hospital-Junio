package Hospital;

public class conductorMetodosValidacion {
	public static void main(String[] args){
		
		int codigo = -11;
		String datos = "";
		
		codigo = MetodosValidacion.validarUsuario(945765, "123");
		System.out.println("codigo: "+codigo);
		
		datos = MetodosValidacion.obtenerUsuario(945765);
		System.out.println(datos);
		
	}
}
