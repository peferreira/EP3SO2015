import java.util.Arrays;


public class GerenciadorDeArquivos {
	Diretorio root;
	GeradorArquivoBinario gbinario;
	GerenciadorDaParticao gParticao;
	GerenciadorDeArquivos(){
		root = new Diretorio("root","root");
		gbinario = new GeradorArquivoBinario();
		
	}
	
	
	/*Comandos***********************************************/
	void mount(String caminho){
		gbinario.setCaminhoParticao(caminho);
		gParticao = new GerenciadorDaParticao(gbinario);
		gParticao.inicializa(caminho);
		
		
	}
	
	void cat(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof ArquivoRegular ){
			
			gParticao.leArquivo(arquivo);
			arquivo.setUltimoAcesso();
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Cat::arquivo inexistente: " + arquivo.nome);
		}
	}
	
	void cp(String origem, String destino){
		String delimitadores = "/";
		String[] tokensOrigem = origem.split(delimitadores);
		String[] tokens = destino.split(delimitadores);
		Arquivo arquivo = buscaArquivo(destino, tokens);
		if(arquivo instanceof Diretorio && !arquivo.nome.equals(tokensOrigem[tokensOrigem.length-1])){
			Diretorio dir = (Diretorio) arquivo;
			ArquivoRegular newArquivo = new ArquivoRegular(tokensOrigem[tokensOrigem.length-1],destino);
			dir.addArquivo(newArquivo);
			gParticao.grava(newArquivo, origem);
			System.out.println("Cp::copiado arquivo no sistema de arquivos, no diretorio: " + dir.nome);
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Cp::o nome ja esta sendo utilizado neste diretorio: " + arquivo.nome);

		}
	}
	
	void rm(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);		
		String nomeArquivoASerRemovido = tokens[tokens.length-1];
		tokens = Arrays.copyOf(tokens, tokens.length-1);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof Diretorio){
			Diretorio dir = (Diretorio) arquivo;
			Arquivo a = dir.getArquivo(nomeArquivoASerRemovido);
			if(a != null && a instanceof ArquivoRegular){
				dir.removeArquivo(a);
				gParticao.removeDoBitmap(a.blocoInicial);
			}
			else if(a != null)
				System.out.println("Rm:: "+ a.nome + " nao pode ser removido pois é um diretorio ");
			else
				System.out.println("Rm:: \""+ nomeArquivoASerRemovido + "\" nao pode ser removido pois é inexistente");

		}
		
		
	}
	
	void rmdir(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);		
		String nomeDiretorioASerRemovido = tokens[tokens.length-1];
		tokens = Arrays.copyOf(tokens, tokens.length-1);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof Diretorio){
			Diretorio dir = (Diretorio) arquivo;
			Arquivo a = dir.getArquivo(nomeDiretorioASerRemovido);
			if(a != null && a instanceof Diretorio ){
				dir.removeArquivo(a);
			}
			else if(a != null)
				System.out.println("Rmdir:: "+ a.nome + " nao pode ser removido pois é um arquivo ");
			else
				System.out.println("Rmdir:: \""+ nomeDiretorioASerRemovido + "\" nao pode ser removido pois é inexistente");
		}
		
	}
	
	
	void ls(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof Diretorio && arquivo.nome.equals(tokens[tokens.length-1])){
			Diretorio dir = (Diretorio) arquivo;
			dir.imprimeArquivos(dir);
		}
	}
	
	void touch(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if(arquivo instanceof Diretorio && !arquivo.nome.equals(tokens[tokens.length-1])){
			Diretorio dir = (Diretorio) arquivo;
			ArquivoRegular newArquivo = new ArquivoRegular(tokens[tokens.length-1],caminho);
			
			dir.addArquivo(newArquivo);
			System.out.println("Touch::arquivo adicionado ao diretorio: " + dir.nome);
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Touch::o nome ja esta sendo utilizado neste diretorio: " + arquivo.nome);

		}
	}
	
	
	void mkdir(String caminho){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if((arquivo instanceof Diretorio) && !arquivo.nome.equals(tokens[tokens.length-1])){
			Diretorio dir = (Diretorio) arquivo;
			Diretorio newDir = new Diretorio(tokens[tokens.length-1], caminho);
			
			dir.addArquivo(newDir);
			System.out.println("Mkdir::diretorio "+ newDir.nome+ " adicionado ao diretorio: " + dir.nome);
		}
		else{
			arquivo.setUltimoAcesso();
			System.out.println("Mkdir::o nome ja esta sendo utilizado neste diretorio: " + arquivo.nome);
		}
	}
	
	
	void find(String caminho, String nomeArquivo){
		String delimitadores = "/";
		String[] tokens = caminho.split(delimitadores);
		Arquivo arquivo = buscaArquivo(caminho, tokens);
		if((arquivo instanceof Diretorio)){
			Diretorio dir = (Diretorio) arquivo;
			dir.find(nomeArquivo);
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
