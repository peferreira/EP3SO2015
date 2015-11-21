
public class ArquivoRegular extends Arquivo {
	int tamanhoEmBytes;
	ArquivoRegular(String nome, String caminho){
		super(nome, caminho);
		
	}
	
	ArquivoRegular(String nome, String caminho, byte[] dados){
		super(nome, caminho, dados);
		
	}
}
