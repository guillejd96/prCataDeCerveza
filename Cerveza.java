

public class Cerveza {

	private String nombre;
	private double aroma,sabor,apariencia,cuerpo,media;

	public Cerveza(String n,double a,double s,double ap,double c){
		nombre=n;
		aroma=a;
		apariencia=ap;
		sabor=s;
		cuerpo=c;
		double aux = aroma+apariencia+sabor+cuerpo;
		media=aux/4;
	}

	public Cerveza(String s){
		nombre=s;
		aroma=sabor=cuerpo=apariencia=0;
	}

	public String getNombre() {
		return nombre;
	}

	public double getAroma() {
		return aroma;
	}

	public double getApariencia() {
		return apariencia;
	}

	public double getCuerpo() {
		return cuerpo;
	}

	public double getMedia() {
		return media;
	}

	public double getSabor(){
		return sabor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAroma(double aroma) {
		this.aroma = aroma;
	}

	public void setApariencia(double apariencia) {
		this.apariencia = apariencia;
	}

	public void setCuerpo(double cuerpo) {
		this.cuerpo = cuerpo;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public void setSabor(double sabor){
		this.sabor=sabor;
	}

	public String toString(){
		return nombre;
	}

	public String show(){
		StringBuilder sb = new StringBuilder();
		sb.append(nombre.toUpperCase()+"\n");
		sb.append("Apariencia: "+apariencia+"\n");
		sb.append("Aroma: "+aroma+"\n");
		sb.append("Sabor: "+sabor+"\n");
		sb.append("Cuerpo: "+cuerpo+"\n");
		sb.append("Media total: "+media+"\n");
		return sb.toString();
	}


}
