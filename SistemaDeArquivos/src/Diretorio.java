import java.util.ArrayList;


public class Diretorio extends Arquivo {
	ArrayList<Arquivo> listaDeArquivos; 
	
	Diretorio(String nome, String caminho){
		super(nome, caminho);
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
		System.out.println("Diretorio::getArquivo:: retornou nulo");
		return null;
	}
	public void addArquivo(Arquivo newArquivo) {
		listaDeArquivos.add(newArquivo);
	}
	
	public void removeArquivo(Arquivo arq){
		listaDeArquivos.remove(arq);
	}
	
	public void imprimeArquivos(Diretorio dir){
		for(Arquivo arq: listaDeArquivos){
			if(arq instanceof Diretorio){
				System.out.println(arq.nome+"/");
			}
			else{
				System.out.println(arq.nome);

			}
		}
	}
	
	public void find(String nomeArquivo){
		for(Arquivo arq: listaDeArquivos){
			
			if(arq instanceof ArquivoRegular){
				if (arq.nome.equals(nomeArquivo)){
					System.out.println(arq.caminho);
				}
			}
			if(arq instanceof Diretorio){
				Diretorio dir = (Diretorio)arq;
				dir.find(nomeArquivo);
			}
		}
	}
}
