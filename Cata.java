import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Cata {

	public String nombre;
	public ArrayList<Persona> lista; // Almacena todas las personas con sus resultados
	public ArrayList<Cerveza> cervezas; // Almacena todas las cervezas
	public ArrayList<Cerveza> resultados; // Almacena todas las medias de cada cerveza
	public HashMap<String, Cerveza> ganadores,perdedores;

	public Cata(String s,ArrayList<Persona> p) throws Exception{
		nombre=s;
		lista=p;
		resultados = new ArrayList<>();
		getCervezas();
		getResultados();
		ganadores = takeResultsMax();
		perdedores = takeResultsMin();
	}

	public void getCervezas() throws FileNotFoundException{
		ImportarCata ic = new ImportarCata();
		cervezas = ic.importarCervezas("Guille.txt", 10);
	}

	public String resultados(){
		StringBuilder sb = new StringBuilder();
		for(Cerveza c: resultados){
			sb.append(c.show());
		}
		return sb.toString();
	}

	public String personas(){
		StringBuilder sb = new StringBuilder();
		for(Persona p: lista){
			sb.append(p.toString());
		}
		return sb.toString();
	}

	public String showResults() throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append(nombre.toUpperCase()+"\n");
		sb.append("------------------------------\n");
		Cerveza c = ganadores.get("Media");
		sb.append("Mejor cerveza: "+c.getNombre()+"\n");
		sb.append("Nota media: "+c.getMedia()+"\n");
		c = ganadores.get("Sabor");
		sb.append("Mejor cerveza por sabor: "+c.getNombre()+"\n");
		sb.append("Nota media: "+c.getSabor()+"\n");
		c = ganadores.get("Apariencia");
		sb.append("Mejor cerveza por apariencia: "+c.getNombre()+"\n");
		sb.append("Nota media: "+c.getApariencia()+"\n");
		c = ganadores.get("Aroma");
		sb.append("Mejor cerveza por Aroma: "+c.getNombre()+"\n");
		sb.append("Nota media: "+c.getAroma()+"\n");
		c = ganadores.get("Cuerpo");
		sb.append("Mejor cerveza por cuerpo: "+c.getNombre()+"\n");
		sb.append("Nota media: "+c.getCuerpo()+"\n");
		sb.append("------------------------------\n");
		sb.append(resultados());
		return sb.toString();
	}

	public HashMap<String, Cerveza> takeResultsMax() throws Exception{
		HashMap<String, Cerveza> aux = new HashMap<>();
		Cerveza cMedia = maxMedia();
		Cerveza cAroma = maxAroma();
		Cerveza cApariencia = maxApariencia();
		Cerveza cSabor = maxSabor();
		Cerveza cCuerpo = maxCuerpo();
		aux.put("Media",cMedia);
		aux.put("Aroma", cAroma);
		aux.put("Sabor", cSabor);
		aux.put("Apariencia",cApariencia);
		aux.put("Cuerpo", cCuerpo);
		return aux;
	}

	public HashMap<String, Cerveza> takeResultsMin() {
		HashMap<String, Cerveza> aux = new HashMap<>();
		Cerveza cMedia = minMedia();
		Cerveza cAroma = minAroma();
		Cerveza cApariencia = minApariencia();
		Cerveza cSabor = minSabor();
		Cerveza cCuerpo = minCuerpo();
		aux.put("Media",cMedia);
		aux.put("Aroma", cAroma);
		aux.put("Sabor", cSabor);
		aux.put("Apariencia",cApariencia);
		aux.put("Cuerpo", cCuerpo);
		return aux;
	}

	public Cerveza maxMedia(){
		Cerveza aux = new Cerveza("aux");
		for(Cerveza c : resultados){
			if(aux.getMedia()<c.getMedia()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza minMedia(){
		Cerveza aux = new Cerveza("aux");
		aux.setMedia(Integer.MAX_VALUE);
		for(Cerveza c : resultados){
			if(aux.getMedia()>c.getMedia()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza maxAroma(){
		Cerveza aux = new Cerveza("aux");
		for(Cerveza c : resultados){
			if(aux.getAroma()<c.getAroma()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza minAroma(){
		Cerveza aux = new Cerveza("aux");
		aux.setAroma(Integer.MAX_VALUE);
		for(Cerveza c : resultados){
			if(aux.getAroma()>c.getAroma()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza maxApariencia(){
		Cerveza aux = new Cerveza("aux");
		for(Cerveza c : resultados){
			if(aux.getApariencia()<c.getApariencia()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza minApariencia(){
		Cerveza aux = new Cerveza("aux");
		aux.setApariencia(Integer.MAX_VALUE);
		for(Cerveza c : resultados){
			if(aux.getApariencia()>c.getApariencia()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza maxCuerpo(){
		Cerveza aux = new Cerveza("aux");
		for(Cerveza c : resultados){
			if(aux.getCuerpo()<c.getCuerpo()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza minCuerpo(){
		Cerveza aux = new Cerveza("aux");
		aux.setCuerpo(Integer.MAX_VALUE);
		for(Cerveza c : resultados){
			if(aux.getCuerpo()>c.getCuerpo()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza maxSabor(){
		Cerveza aux = new Cerveza("aux");
		for(Cerveza c : resultados){
			if(aux.getSabor()<c.getSabor()){
				aux=c;
			}
		}
		return aux;
	}

	public Cerveza minSabor(){
		Cerveza aux = new Cerveza("aux");
		aux.setSabor(Integer.MAX_VALUE);
		for(Cerveza c : resultados){
			if(aux.getSabor()>c.getSabor()){
				aux=c;
			}
		}
		return aux;
	}

	public void getResultados() throws Exception{
		for(Cerveza c : cervezas){
			Cerveza aux = new Cerveza(c.getNombre());
			aux.setMedia(getMediaTotal(aux.getNombre()));
			aux.setSabor(getMediaSabor(aux.getNombre()));
			aux.setApariencia(getMediaApariencia(aux.getNombre()));
			aux.setAroma(getMediaAroma(aux.getNombre()));
			aux.setCuerpo(getMediaCuerpo(aux.getNombre()));
			resultados.add(aux);
		}
	}

	public double getMediaTotal(String s) throws Exception{
		double media=0;
		int cont=0;
		for(Persona p : lista){
			Cerveza aux = p.buscarCerveza(s);
			if(aux.getMedia()>0){
				media+=aux.getMedia();
				cont++;
			}
		}
		media/=cont;
		return truncateDecimal(media, 4).doubleValue();
	}

	public double getMediaApariencia(String s) throws Exception{
		double media=0;
		int cont=0;
		for(Persona p : lista){
			Cerveza aux = p.buscarCerveza(s);
			if(aux.getApariencia()>0){
				media+=aux.getApariencia();
				cont++;
			}
		}
		media/=cont;
		return truncateDecimal(media, 4).doubleValue();
	}

	public double getMediaAroma(String s) throws Exception{
		double media=0;
		int cont=0;
		for(Persona p : lista){
			Cerveza aux = p.buscarCerveza(s);
			if(aux.getAroma()>0){
				media+=aux.getAroma();
				cont++;
			}
		}
		media/=cont;
		return truncateDecimal(media, 4).doubleValue();
	}

	public double getMediaCuerpo(String s) throws Exception{
		double media=0;
		int cont=0;
		for(Persona p : lista){
			Cerveza aux = p.buscarCerveza(s);
			if(aux.getCuerpo()>0){
				media+=aux.getCuerpo();
				cont++;	
			}
		}
		media/=cont;
		return truncateDecimal(media, 4).doubleValue();
	}

	public double getMediaSabor(String s) throws Exception{
		double media=0;
		int cont=0;
		for(Persona p : lista){
			Cerveza aux = p.buscarCerveza(s);
			if(aux.getSabor()>0){
				media+=aux.getSabor();
				cont++;	
			}
		}
		media/=cont;
		return truncateDecimal(media, 4).doubleValue();
	}

	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
		if ( x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}

}
