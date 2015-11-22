import java.io.File;


public class BitmapParticao extends Particao {
	 /*bitmap 0 quer dizer que o bloco esta livre*/
	static int inicio = 100;
	static int tamanho = 24000;
	BitmapParticao(GeradorArquivoBinario gBinario, File particao) {
		super(gBinario, inicio, tamanho, particao);
		this.particao = particao;
		
		inicializa();
	}
	
	
	void inicializa(){
		
		byte[] bitmap = new byte[tamanho];
		for(int i = 0; i < tamanho; i++){
			bitmap[i] = -128;/*adicionando o valor de livre para todos bitmaps*/
		}
		gBinario.escreveArquivo(bitmap, inicio, tamanho);
		//gBinario.leRegiao(particao, inicio, tamanho);
	}
	
	int[] getBitsLivres(int numDeBitsLivresPedidos){
		int[] bitsLivres = new int[numDeBitsLivresPedidos];
		int numBitsLivresEncontrados, i;
		i = numBitsLivresEncontrados = 0;
		byte[] bitmap = gBinario.leArquivoBinario(particao, inicio, tamanho);
		
		while(i < tamanho && numBitsLivresEncontrados < numDeBitsLivresPedidos){
			if(bitmap[i] == -128){
				bitsLivres[numBitsLivresEncontrados++] = i;
			}
			i++;
		}
		if(numBitsLivresEncontrados < numDeBitsLivresPedidos)
			return null;
		
		bitmap = atualizaBitmap(bitsLivres, bitmap);
		gBinario.escreveArquivo(bitmap, inicio, tamanho);
		
		return bitsLivres;
	}
	
	byte[] atualizaBitmap(int[] bitsLivres, byte[] bitmap) {
		for (int i = 0; i < bitsLivres.length; i++)
			bitmap[bitsLivres[i]] = 127;
		return bitmap;
	}
	
	void limpaArquivoDoBitmap(int blocoInicial, int[] tabelaFat){
		
		byte[] bitmap = gBinario.leArquivoBinario(particao, inicio, tamanho);
		int bloco = blocoInicial;
		while(bloco != -1){
			bitmap[bloco] = -128;
			bloco = tabelaFat[bloco];
		}
		gBinario.escreveArquivo(bitmap, inicio, tamanho);
	}
	
}