import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		ImportarCata ic = new ImportarCata();

		ArrayList<Persona> p = new ArrayList<>();
		p.add(ic.importarArchivo("Guille.txt", 10));
		p.add(ic.importarArchivo("Carlos.txt", 10));
		p.add(ic.importarArchivo("Enrique.txt", 10));
		p.add(ic.importarArchivo("German.txt", 10));
		p.add(ic.importarArchivo("Javi.txt", 10));
		p.add(ic.importarArchivo("Juan.txt", 10));
		p.add(ic.importarArchivo("Pablo.txt", 10));
		p.add(ic.importarArchivo("Ruben.txt", 10));

		Cata cata = new Cata("I CATA DE CERVEZA IMPRESENTABLE", p);
		System.out.println(cata.showResults());
		
	}

}
