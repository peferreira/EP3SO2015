import java.io.File;


public class BitmapParticao extends Particao {
	 /*bitmap 0 quer dizer que o bloco esta livre*/
	static int inicio = 0;
	static int tamanho = 24000;
	BitmapParticao(GeradorArquivoBinario gBinario, File particao) {
		super(gBinario, inicio, tamanho, particao);
		this.particao = particao;
		
		inicializa();
	}
	public void printBitmap(){
		System.out.println(new String(gBinario.leArquivoBinario(particao, inicio, tamanho)));
	}
	
	void inicializa(){
		
		byte[] bitmap = new byte[tamanho];
		for(int i = 0; i < tamanho; i++){
			bitmap[i] = -128;/*adicionando o valor de livre para todos bitmaps*/
		}
		//System.out.println("inicializa 1 bitmap");
		//printBitmap(bitmap);

		gBinario.escreveArquivo(bitmap, inicio, tamanho);
		//System.out.println("inicializa 2 bitmap");

		//printBitmap(bitmap);


		//gBinario.leRegiao(particao, inicio, tamanho);
	}
	
	void printBitmap(byte[] bitmap){
		for(int k = 0; k < 100; k++){
			System.out.print(" "+ bitmap[k]);
		}
		System.out.println();
	}
	
	int[] getBitsLivres(int numDeBitsLivresPedidos){
		int[] bitsLivres = new int[numDeBitsLivresPedidos];
		int numBitsLivresEncontrados, i;
		i = numBitsLivresEncontrados = 0;
		byte[] bitmap = gBinario.leArquivoBinario(particao, inicio, tamanho);
		
		//printBitmap(bitmap);
		
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bitmap = gBinario.leArquivoBinario(particao, inicio, tamanho);
		System.out.println("imprimindo pela ultima vez");
		//printBitmap(bitmap);

		System.out.println("imprimindo pela ultima vez##################################");

		return bitsLivres;
	}
	
	byte[] atualizaBitmap(int[] bitsLivres, byte[] bitmap) {
		for (int i = 0; i < bitsLivres.length; i++)
			bitmap[bitsLivres[i]] = 127;
		System.out.println("atualiza bitmap");
		//printBitmap(bitmap);

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
