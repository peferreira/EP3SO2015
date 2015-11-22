import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class GeradorArquivoBinario {
	int tamanhoSistemaArquivos = (int) 1e8;
	String caminhoParticao;
	
	GeradorArquivoBinario() {
		
	}

	byte converteIntParaByte(int n) {
		return (byte) (n - 128);
	}
	
	public void setCaminhoParticao(String caminho){
		caminhoParticao = caminho;
	}
	
	
	public byte[] leArquivoBinario(File arquivo,int inicio, int tamanho) {
	    try{
			RandomAccessFile file = new RandomAccessFile(arquivo, "r");
		    file.seek(inicio);
			byte[] fileContent = new byte[tamanho];
	        /*file.read(fileContent);*/
			file.readFully(fileContent);
	        file.close();
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
		try {
			System.out.println(new String(conteudo, "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void escreveArquivo(byte[] arquivoASerAtualizado,int inicio, int tamanho) {

		try {
			RandomAccessFile file = new RandomAccessFile(caminhoParticao, "rw");
			file.seek(inicio);
			file.write(arquivoASerAtualizado);
			file.close();


		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void escreveArquivo(byte[] arquivoASerAtualizado,int inicio, int tamanho, String caminhoArquivo) {

		try {
			RandomAccessFile file = new RandomAccessFile(caminhoArquivo, "rw");
			file.seek(inicio);
			file.write(arquivoASerAtualizado);
			file.close();


		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void leRegiao(File particao,int inicio, int tamanho) {
		byte[] regiao = leArquivoBinario(particao,inicio, tamanho);
		for(int i = 0; i < regiao.length; i++){
			System.out.print(" "+ regiao[i]);
		}
		System.out.println();
	}
	
	
	
}