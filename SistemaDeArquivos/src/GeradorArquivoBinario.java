import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class GeradorArquivoBinario {
	int tamanhoSistemaArquivos = (int) 10e8;
	String caminhoParticao;
	
	GeradorArquivoBinario() {
		
	}

	byte converteIntParaByte(int n) {
		return (byte) (n - 128);
	}
	
	public void setCaminhoParticao(String caminho){
		caminhoParticao = caminho;
	}
	
	public byte[] leArquivoBinario(String filePath) {
		
		File file = new File(filePath);
		FileInputStream fis = null;
		
		try{
			byte[] fileContent = new byte[(int)file.length()];
			fis = new FileInputStream(file);
			fis.read(fileContent);
			fis.close();
			
			
			System.out.println();
			return fileContent;
		}
		catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("LeArquivoBinário:: não encontrou o arquivo ");
			return null;
		}
		
	}
	
	public void printArrayBinario(byte[] conteudo){
		/*for(int i = 0; i < conteudo.length; i++)
			System.out.println(new String(conteudo[i]));*/
		System.out.println(new String(conteudo));
	}

	public byte[] getRegiao(int inicio, int tamanho) {
		byte[] regiao = new byte[tamanho];
		int fim = inicio + tamanho - 1;
		regiao = Arrays.copyOfRange(leArquivoBinario(caminhoParticao), inicio, fim);
		return regiao;
	}

	public void atualizaRegiao(byte[] bitmap, int inicioBitmap) {
		byte[] arquivoASerAtualizado = leArquivoBinario(caminhoParticao);
		if(arquivoASerAtualizado == null || arquivoASerAtualizado.length == 0){
			arquivoASerAtualizado = new byte[tamanhoSistemaArquivos];
		}
		for (int i = 0; i < bitmap.length; i++) {
			arquivoASerAtualizado[inicioBitmap + i] = bitmap[i]; 
		}
		escreveArquivo(arquivoASerAtualizado);
	}
	
	private void escreveArquivo(byte[] arquivoASerAtualizado) {

		File particao = new File(caminhoParticao);

		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(particao);
			fos.write(arquivoASerAtualizado);
			fos.close();

		} catch (Exception e1) {
			e1.printStackTrace();
			}
	}

	public void leRegiao(int inicio, int tamanho) {
		byte[] regiao = getRegiao(inicio, tamanho);
		for(int i = 0; i < regiao.length; i++){
			System.out.print(" "+ regiao[i]);
		}
		System.out.println();
	}
	
	
	
}