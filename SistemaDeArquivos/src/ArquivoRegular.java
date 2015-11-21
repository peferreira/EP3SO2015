
public class ArquivoRegular extends Arquivo {
	int tamanhoEmBytes;
	byte[] conteudo;
	ArquivoRegular(String nome, String caminho){
		super(nome, caminho);
		
	}
	
	ArquivoRegular(String nome, String caminho, byte[] counteudo){
		super(nome, caminho);
		this.conteudo = conteudo;
		
	}
}
