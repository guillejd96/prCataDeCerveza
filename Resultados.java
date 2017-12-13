import java.math.BigDecimal;
import java.util.ArrayList;

public class Resultados {

	private Cata cata;
	private Cerveza mejorCervezaMedia,peorCervezaMedia;
	private Cerveza mejorCervezaSabor,peorCervezaSabor;
	private Cerveza mejorCervezaAroma,peorCervezaAroma;
	private Cerveza mejorCervezaApariencia,peorCervezaApariencia;
	private Cerveza mejorCervezaCuerpo,peorCervezaCuerpo;
	private Persona mejorJuezMedia,peorJuezMedia;
	private Persona mejorJuezSabor,peorJuezSabor;
	private Persona mejorJuezAroma,peorJuezAroma;
	private Persona mejorJuezApariencia,peorJuezApariencia;
	private Persona mejorJuezCuerpo,peorJuezCuerpo;

	public Resultados(Cata c) throws Exception{
		cata=c;
		mejorCervezaMedia = getMejorCervezaMedia();
		peorCervezaMedia = getPeorCervezaMedia();
		mejorCervezaSabor = getMejorCervezaSabor();
		peorCervezaSabor = getPeorCervezaSabor();
		mejorCervezaAroma = getMejorCervezaAroma();
		peorCervezaAroma = getPeorCervezaAroma();
		mejorCervezaApariencia = getMejorCervezaApariencia();
		peorCervezaApariencia = getPeorCervezaApariencia();
		mejorCervezaCuerpo = getMejorCervezaCuerpo();
		peorCervezaCuerpo = getPeorCervezaCuerpo();
		mejorJuezMedia = getMejorJuezMedia();
		peorJuezMedia = getPeorJuezMedia();
		mejorJuezSabor = getMejorJuezSabor();
		peorJuezSabor = getPeorJuezSabor();
		mejorJuezAroma = getMejorJuezAroma();
		peorJuezAroma = getPeorJuezAroma();
		mejorJuezApariencia = getMejorJuezApariencia();
		peorJuezApariencia = getPeorJuezApariencia();
		mejorJuezCuerpo = getMejorJuezCuerpo();
		peorJuezCuerpo = getPeorJuezCuerpo();
	}

	public String showAllResults(){
		StringBuilder sb = new StringBuilder();
		sb.append("RESULTADOS DE "+cata.nombre.toUpperCase()+"\n");
		sb.append("-------------------------------------------\n");
		sb.append("CERVEZAS\n");
		sb.append("-------------------------------------------\n");
		sb.append("Mejor cerveza de media: "+mejorCervezaMedia.getNombre()+"\n");
		sb.append("Peor cerveza de media: "+peorCervezaMedia.getNombre()+"\n");
		sb.append("Mejor cerveza por apariencia: "+mejorCervezaApariencia.getNombre()+"\n");
		sb.append("Peor cerveza por apariencia: "+peorCervezaApariencia.getNombre()+"\n");
		sb.append("Mejor cerveza por aroma: "+mejorCervezaAroma.getNombre()+"\n");
		sb.append("Peor cerveza por aroma: "+peorCervezaAroma.getNombre()+"\n");
		sb.append("Mejor cerveza por sabor: "+mejorCervezaSabor.getNombre()+"\n");
		sb.append("Peor cerveza por sabor: "+peorCervezaSabor.getNombre()+"\n");
		sb.append("Mejor cerveza por cuerpo: "+mejorCervezaCuerpo.getNombre()+"\n");
		sb.append("Peor cerveza por cuerpo: "+peorCervezaCuerpo.getNombre()+"\n");
		sb.append("-------------------------------------------\n");
		sb.append("JUECES\n");
		sb.append("-------------------------------------------\n");
		sb.append("Mejor juez de media: "+mejorJuezMedia.getNombre()+"\n");
		sb.append("Peor juez de media: "+peorJuezMedia.getNombre()+"\n");
		sb.append("Mejor juez por apariencia: "+mejorJuezApariencia.getNombre()+"\n");
		sb.append("Peor juez por apariencia: "+peorJuezApariencia.getNombre()+"\n");
		sb.append("Mejor juez por aroma: "+mejorJuezAroma.getNombre()+"\n");
		sb.append("Peor juez por aroma: "+peorJuezAroma.getNombre()+"\n");
		sb.append("Mejor juez por sabor: "+mejorJuezSabor.getNombre()+"\n");
		sb.append("Peor juez por sabor: "+peorJuezSabor.getNombre()+"\n");
		sb.append("Mejor juez por cuerpo: "+mejorJuezCuerpo.getNombre()+"\n");
		sb.append("Peor juez por cuerpo: "+peorJuezCuerpo.getNombre()+"\n");
		sb.append("-------------------------------------------\n");
		return sb.toString();
	}

	public Persona getMejorJuezMedia() throws Exception{
		Persona mejorJuez = new Persona("aux");
		double min=Integer.MAX_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getMedia()-buscarCerveza(c.getNombre()).getMedia();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(min>aux){
				min=aux;
				mejorJuez=p;
			}
		}
		return mejorJuez;
	}

	public Persona getPeorJuezMedia() throws Exception{
		Persona peorJuez = new Persona("aux");
		double max=Integer.MIN_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getMedia()-buscarCerveza(c.getNombre()).getMedia();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(max<aux) {
				max=aux;
				peorJuez=p;
			}
		}
		return peorJuez;
	}


	public Cerveza getMejorCervezaMedia() {
		return cata.ganadores.get("Media");
	}

	public Cerveza getPeorCervezaMedia() {
		return cata.perdedores.get("Media");
	}

	public Cerveza getMejorCervezaSabor() {
		return cata.ganadores.get("Sabor");
	}

	public Cerveza getPeorCervezaSabor() {
		return cata.perdedores.get("Sabor");
	}

	public Cerveza getMejorCervezaAroma() {
		return cata.ganadores.get("Aroma");
	}

	public Cerveza getPeorCervezaAroma() {
		return cata.perdedores.get("Aroma");
	}

	public Cerveza getMejorCervezaApariencia() {
		return cata.ganadores.get("Apariencia");
	}

	public Cerveza getPeorCervezaApariencia() {
		return cata.perdedores.get("Apariencia");
	}

	public Cerveza getMejorCervezaCuerpo() {
		return cata.ganadores.get("Cuerpo");
	}

	public Cerveza getPeorCervezaCuerpo() {
		return cata.perdedores.get("Cuerpo");
	}

	public Persona getMejorJuezSabor() throws Exception {
		Persona mejorJuezSabor = new Persona("aux");
		double min=Integer.MAX_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getSabor()-buscarCerveza(c.getNombre()).getSabor();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(min>aux){
				min=aux;
				mejorJuezSabor=p;
			}
		}
		return mejorJuezSabor;
	}

	public Persona getPeorJuezSabor() throws Exception {
		Persona peorJuezSabor = new Persona("aux");
		double max=Integer.MIN_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getSabor()-buscarCerveza(c.getNombre()).getSabor();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(max<aux) {
				max=aux;
				peorJuezSabor=p;
			}
		}
		return peorJuezSabor;
	}

	public Persona getMejorJuezAroma() throws Exception {
		Persona mejorJuezAroma = new Persona("aux");
		double min=Integer.MAX_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getAroma()-buscarCerveza(c.getNombre()).getAroma();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(min>aux){
				min=aux;
				mejorJuezAroma=p;
			}
		}
		return mejorJuezAroma;
	}

	public Persona getPeorJuezAroma() throws Exception {
		Persona peorJuezAroma = new Persona("aux");
		double max=Integer.MIN_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getAroma()-buscarCerveza(c.getNombre()).getAroma();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(max<aux) {
				max=aux;
				peorJuezAroma=p;
			}
		}
		return peorJuezAroma;
	}

	public Persona getMejorJuezApariencia() throws Exception {
		Persona mejorJuezApariencia = new Persona("aux");
		double min=Integer.MAX_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getApariencia()-buscarCerveza(c.getNombre()).getApariencia();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(min>aux){
				min=aux;
				mejorJuezApariencia=p;
			}
		}
		return mejorJuezApariencia;
	}

	public Persona getPeorJuezApariencia() throws Exception {
		Persona peorJuezApariencia = new Persona("aux");
		double max=Integer.MIN_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getApariencia()-buscarCerveza(c.getNombre()).getApariencia();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(max<aux) {
				max=aux;
				peorJuezApariencia=p;
			}
		}
		return peorJuezApariencia;
	}

	public Persona getMejorJuezCuerpo() throws Exception {
		Persona mejorJuezCuerpo = new Persona("aux");
		double min=Integer.MAX_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getCuerpo()-buscarCerveza(c.getNombre()).getCuerpo();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(min>aux){
				min=aux;
				mejorJuezCuerpo=p;
			}
		}
		return mejorJuezCuerpo;
	}

	public Persona getPeorJuezCuerpo() throws Exception {
		Persona peorJuezCuerpo = new Persona("aux");
		double max=Integer.MIN_VALUE;
		for(Persona p : cata.lista){
			ArrayList<Cerveza> cs = p.getLista();
			double aux = 0;
			for(Cerveza c : cs){
				double i = c.getCuerpo()-buscarCerveza(c.getNombre()).getCuerpo();
				if(i<0) i*=(-1);
				aux+=i;
			}
			aux/=cata.cervezas.size();
			if(max<aux) {
				max=aux;
				peorJuezCuerpo=p;
			}
		}
		return peorJuezCuerpo;
	}

	private Cerveza buscarCerveza(String n) throws Exception{
		for(Cerveza c : cata.resultados){
			if(c.getNombre().equals(n)) return c;
		}
		throw new Exception("buscarCerveza: No se encontro la cerveza "+n+" en "+cata.nombre);
	}

	@SuppressWarnings("unused")
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
		if ( x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}
}
