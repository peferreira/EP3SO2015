import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class GerenciadorDaParticao {
	
	BitmapParticao bitmap;
	ArquivosParticao arquivos;
	File arquivoParticao;
	GeradorArquivoBinario gBinario;
	int tamanhoFat = 24000;
	int[] tabelaFat;	
	GerenciadorDaParticao(GeradorArquivoBinario gBinario){
		this.gBinario = gBinario;
		
	}
	
	void inicializa(String caminho){
		arquivoParticao = new File(caminho);
		bitmap = new BitmapParticao(gBinario, arquivoParticao);	
		arquivos = new ArquivosParticao(gBinario, arquivoParticao);
		tabelaFat = new int[tamanhoFat];
		inicializaTabelaFat();
	}
	
	void inicializaTabelaFat(){
		for(int i = 0 ; i < tabelaFat.length; i++){
			tabelaFat[i] = -1;
		}
	}
	void grava(Arquivo arquivoASerGravado, String origem){
		File fileDeOrigem = new File(origem);
		
		long tamanhoArquivo = fileDeOrigem.length();
		double numDeBlocosDoArquivo = (double)tamanhoArquivo/4000.0;
		int sobraDeBytes =  ((int)tamanhoArquivo%4000);
		int tetoNumDeBlocosDoArquivo = (int)Math.ceil(numDeBlocosDoArquivo);
		int[] bitsLivres = bitmap.getBitsLivres(tetoNumDeBlocosDoArquivo);
		arquivoASerGravado.setBlocoInicial(bitsLivres[0]);
		byte[] regiaoASerGravada;
		
		for( int i = 0; i < tetoNumDeBlocosDoArquivo;i++){
			if(i == tetoNumDeBlocosDoArquivo-1){
				regiaoASerGravada = gBinario.leArquivoBinario(fileDeOrigem, i*4000, sobraDeBytes);
				gBinario.escreveArquivo(regiaoASerGravada, bitsLivres[i]*4000, sobraDeBytes );
			}
			else{
				regiaoASerGravada = gBinario.leArquivoBinario(fileDeOrigem, i*4000, 4000);
				gBinario.escreveArquivo(regiaoASerGravada, bitsLivres[i]*4000, 4000);
				tabelaFat[i] = bitsLivres[i+1];
			}
			
		}

		//leArquivo(bitsLivres);

	}
	
	
	void leArquivo(int[] posicaoBlocos){
		for(int i=0; i < posicaoBlocos.length; i++){
			gBinario.printArrayBinario(gBinario.leArquivoBinario(arquivoParticao,posicaoBlocos[i]*4000, 4000));
		}
		
	}
	
	void leArquivo(Arquivo arquivo){
		int bloco = arquivo.blocoInicial;
		while(bloco != -1){
			gBinario.printArrayBinario(gBinario.leArquivoBinario(arquivoParticao,bloco*4000, 4000));
			bloco = tabelaFat[bloco];
		}
		
	}
}
