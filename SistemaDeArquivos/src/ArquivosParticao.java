import java.io.File;


public class ArquivosParticao extends Particao {
	static int inicio = (int)1e5;
	static int tamanho = 999*(int)1e6;
	ArquivosParticao(GeradorArquivoBinario gBinario, File particao) {
		super(gBinario, inicio, tamanho, particao);
	}
	
	
}
