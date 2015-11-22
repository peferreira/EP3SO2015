import java.io.File;


public class ArquivosParticao extends Particao {
	static int inicio = (int)1e5;
	static int tamanho = 999*(int)1e6;
	ArquivosParticao(GeradorArquivoBinario gBinario, File particao) {
		super(gBinario, inicio, tamanho, particao);
	}
	
	
	void gravaDados(int[] tabelaFat,int sobraDeBytes, File fileDeOrigem,Arquivo arquivoASerGravado, int[] bitsLivres, int tetoNumDeBlocosDoArquivo){
		byte[] regiaoASerGravada;
		
		for( int i = 0; i < tetoNumDeBlocosDoArquivo;i++){
			if(i == tetoNumDeBlocosDoArquivo-1){
				regiaoASerGravada = gBinario.leArquivoBinario(fileDeOrigem, i*4000, sobraDeBytes);

				gBinario.escreveArquivo(regiaoASerGravada, inicio+bitsLivres[i]*4000, sobraDeBytes );
				



			}
			else{
				regiaoASerGravada = gBinario.leArquivoBinario(fileDeOrigem, i*4000, 4000);
				gBinario.escreveArquivo(regiaoASerGravada, inicio+bitsLivres[i]*4000, 4000);
				tabelaFat[i] = bitsLivres[i+1];
			}
			
		}
		
		
	}
}
