import java.util.ArrayList;


public class Persona {

	private String nombre;
	private ArrayList<Cerveza> lista;

	public Persona (String s){
		nombre=s;
		lista= new ArrayList<>();
	}

	public Persona(){
		lista= new ArrayList<>();
	}

	public void addCerveza(Cerveza c){
		lista.add(c);
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Cerveza> getLista() {
		return lista;
	}

	public Cerveza buscarCerveza(String s) throws Exception{
		for(Cerveza c : lista){
			if(c.getNombre().equals(s)){
				return c;
			}
		}
		throw new Exception("buscarCerveza: No se encontro la cerveza "+s+" en "+nombre);
	}

	public void setNombre(String n){
		this.nombre=n;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(nombre.toUpperCase()+"\n---------------------------------------\n");
		sb.append("NOTAS\n");
		sb.append("---------------------------------------\n");
		for(Cerveza c : lista){
			sb.append(c.show());
		}
		sb.append("---------------------------------------\n");
		return sb.toString();
	}

}
