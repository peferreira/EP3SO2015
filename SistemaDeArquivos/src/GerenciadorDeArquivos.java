
public class GerenciadorDeArquivos {
	Diretorio root;
	
	GerenciadorDeArquivos(){
		root = new Diretorio("root");
	}
	
	void cp(String origem, String destino){
		
	}
	/*Comandos***********************************************/
	void touch(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof Diretorio){
			Diretorio dir = (Diretorio) arquivo;
			ArquivoRegular newArquivo = new ArquivoRegular(tokens[tokens.length-1]);
			
			dir.addArquivo(newArquivo);
			System.out.println("Touch::arquivo adicionado ao diretorio: " + dir.nome);
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Touch::arquivo ja existe: " + arquivo.nome);

		}
	}
	
	
	void mkdir(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if((arquivo instanceof Diretorio) && !arquivo.nome.equals(tokens[tokens.length-1])){
			Diretorio dir = (Diretorio) arquivo;
			Diretorio newDir = new Diretorio(tokens[tokens.length-1]);
			
			dir.addArquivo(newDir);
			System.out.println("Mkdir::diretorio adicionado ao diretorio: " + dir.nome);
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Mkdir::diretorio ja existe: " + arquivo.nome);
		}
	}
	/*********************************************************/
	void imprimeVetorStrings(String[] s){
		for(int i = 0; i < s.length; i++){
			System.out.print(s[i]+ " ");
		}
		System.out.println();
	}
	
	Arquivo buscaArquivo(String caminho, String[] tokens){
		Arquivo arq = root;
		for(int i = 0; i < tokens.length-1; i++){
			if(arq.existeArquivo(tokens[i+1])){
				arq = arq.getArquivo(tokens[i+1]);
			}
			else if(i < tokens.length-2){
				/*caminho invalido*/
				System.out.println("Busca Arquivo:: caminho inválido");
				return null;
			}
			else if(i == tokens.length-2){/*esta no diretorio certo mas nao existe o arquivo*/
				return arq;
			}
		}
		return arq;
	}
	
	
	
}
