package futuraImplementacion;

import Hospital.ExcepcionHospital;

public class conductorDiscapacidadIMPL {
	public static void main(String[] args){
		
		DiscapacidadIMPL d1 = new DiscapacidadIMPL();
		DiscapacidadIMPL d2 = new DiscapacidadIMPL("Lolico", "Telito", "Malito", 4567);
		
		try{
			d1.setTipo("Malo");
		}
		catch(ExcepcionHospital e){
			//e.printStackTrace();
			System.out.println(e);
		}
		
		try{
			d1.setTipo("Fisica");
		}
		catch(ExcepcionHospital e){
			e.printStackTrace();
		}
		System.out.println(d1.getTipo());
		
		try{
			d1.setClasificacion("Cojera");
		}
		catch(ExcepcionHospital e){
			e.printStackTrace();
		}
		System.out.println(d1.getClasificacion());
		
		d1.setDescripcion("Pata chula");
		System.out.println(d1.getDescripcion());
		
		d1.setNumeroSSPaciente(12345);
		System.out.println(d1.getNumeroSSPaciente());
		
		try{
			d2.setTipo("Sensorial");
		}
		catch(ExcepcionHospital e){
			//e.printStackTrace();
			System.out.println(e);
		}
		System.out.println(d2.getTipo());
		
		try{
			d2.setClasificacion("Tontito");
		}
		catch(ExcepcionHospital e){
			System.out.println(e);
		}
		System.out.println(d2.getClasificacion());
		
		try{
			d2.setClasificacion("auditiva");
		}
		catch(ExcepcionHospital e){
			System.out.println(e);
		}
		System.out.println(d2.getClasificacion());
		
		System.out.println(d1.toString());System.out.println(d2.toString());
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.compareTo(d1));
		System.out.println(d2.compareTo(d1));
	}
}
