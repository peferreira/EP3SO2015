import java.io.File;


public class Particao {
	int tamanho, inicio, fim;
	File particao;
	GeradorArquivoBinario gBinario;
	Particao(GeradorArquivoBinario gBinario,int inicio, int fim , File particao){
		this.gBinario = gBinario;
		this.inicio = inicio;
		this.tamanho = tamanho;
		this.fim = inicio + tamanho - 1;
		this.particao = particao;
	}
	Particao(GeradorArquivoBinario gBinario){
		this.gBinario = gBinario;
		
	}
	
}
