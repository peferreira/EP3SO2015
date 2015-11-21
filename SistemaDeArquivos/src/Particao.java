
public class Particao {
	int tamanho, inicio, fim;
	GeradorArquivoBinario gBinario;
	Particao(GeradorArquivoBinario gBinario,int inicio, int fim){
		this.gBinario = gBinario;
		this.inicio = inicio;
		this.tamanho = tamanho;
		this.fim = inicio + tamanho - 1;
	}
	Particao(GeradorArquivoBinario gBinario){
		this.gBinario = gBinario;
		
	}
	
}
