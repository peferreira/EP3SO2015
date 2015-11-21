import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Arquivo {
	DateFormat df;
	String nome;
	String caminho;
	Calendar tempoCriado;
	Calendar tempoModificado;
	Calendar ultimoAcesso;
	byte dados[];
	
	Arquivo(String nome, String caminho){
		this.nome = nome;
		this.caminho = caminho;
		df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	}
	
	

	public Arquivo getArquivo(String nomeArquivo) {
		return null;
	}
	public boolean existeArquivo(String nomeArquivo){
		return false;
	}
	public void setUltimoAcesso() {
		this.ultimoAcesso = Calendar.getInstance();
		printInstante(ultimoAcesso);
	}
	public void printInstante(Calendar c){
		System.out.println(df.format(c.getTime()));
	}
}

