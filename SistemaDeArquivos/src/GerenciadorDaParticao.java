
public class GerenciadorDaParticao {
	
	BitmapParticao bitmap;
	
	
	GeradorArquivoBinario gBinario;
	
	GerenciadorDaParticao(GeradorArquivoBinario gBinario){
		this.gBinario = gBinario;
		
	}
	
	void inicializa(){
		bitmap = new BitmapParticao(gBinario);		
	}
	
	
	
}
