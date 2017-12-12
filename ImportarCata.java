import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportarCata {

	public ImportarCata(){

	}

	public Persona importarArchivo(String n,int nCervezas) throws FileNotFoundException{
		Persona aux = new Persona();
		Scanner s = new Scanner(new File(n));
		aux.setNombre(s.next());
		s.nextLine();
		for(int i=0;i<nCervezas;i++){
			Scanner sC = new Scanner(s.nextLine());
			String nombreCerveza = sC.next();
			double apariencia = (double) sC.nextDouble();
			double aroma = (double) sC.nextDouble();
			double sabor = (double) sC.nextDouble();
			double cuerpo = (double) sC.nextDouble();
			aux.addCerveza(new Cerveza(nombreCerveza, aroma, sabor, apariencia, cuerpo));
			sC.close();
		}
		s.close();
		return aux;
	}

	public ArrayList<Cerveza> importarCervezas(String n,int nCervezas) throws FileNotFoundException{
		ArrayList<Cerveza> cervezas = new ArrayList<>();
		Scanner s = new Scanner(new File(n));
		s.nextLine();
		for(int i=0;i<nCervezas;i++){
			String nombre = s.next();
			s.nextLine();
			Cerveza aux = new Cerveza(nombre);
			cervezas.add(aux);
		}
		s.close();
		return cervezas;
	}
}
