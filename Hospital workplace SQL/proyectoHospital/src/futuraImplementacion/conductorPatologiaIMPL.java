package futuraImplementacion;

import Hospital.ExcepcionHospital;

public class conductorPatologiaIMPL {
	public static void main(String[] args){
		
		PatologiaIMPL p1 = new PatologiaIMPL();
		PatologiaIMPL p2 = new PatologiaIMPL("Ese", "Asin", "Raruno", 12345);
		
		try{
			p1.setTipo("Malo");
		}
		catch(ExcepcionHospital e){
			//e.printStackTrace();
			System.out.println(e);
		}
		
		try{
			p1.setTipo("general");
		}
		catch(ExcepcionHospital e){
			System.out.println(e);
		}
		System.out.println(p1.getTipo());
		
		try{
			p1.setClasificacion("Cojera");
		}
		catch(ExcepcionHospital e){
			System.out.println(e);
		}
		
		try{
			p1.setClasificacion("patologico");
		}
		catch(ExcepcionHospital e){
			System.out.println(e);
		}
		System.out.println(p1.getClasificacion());
		
		p1.setNombre("Deficit de aprobacion");
		
		p1.setNumeroSSPaciente(2345);
		
		
		System.out.println(p1.toString());System.out.println(p2.toString());
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p1));
		System.out.println(p2.compareTo(p1));
	}
}
