import java.util.ArrayList;


public class Diretorio extends Arquivo {
	ArrayList<Arquivo> listaDeArquivos; 
	
	Diretorio(String nome){
		super(nome);
		listaDeArquivos = new ArrayList<Arquivo>();
	}
	public boolean existeArquivo(String nomeArquivo) {
		for (Arquivo arquivo: listaDeArquivos){
			if(nomeArquivo.equals(arquivo.nome)){
				System.out.println("Diretorio::existeArquivo: Arquivo já existe :"+ arquivo.nome);
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	
	public Arquivo getArquivo(String nomeArquivo) {
		for (Arquivo arquivo: listaDeArquivos){
			if(nomeArquivo.equals(arquivo.nome)){
				return arquivo;
			}
		}
		System.out.println("Diretorio::getArquivo:: falou que o arquivo existia mas nao consegue encontrá-lo");
		return null;
	}
	public void addArquivo(Arquivo newArquivo) {
		listaDeArquivos.add(newArquivo);
	}
}
