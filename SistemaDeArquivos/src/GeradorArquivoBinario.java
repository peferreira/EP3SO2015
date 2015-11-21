import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


public class GeradorArquivoBinario {

	
	
	GeradorArquivoBinario() {
		
	}

	byte converteIntParaByte(int n) {
		return (byte) (n - 128);
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
			return null;
		}
		
	}
	
	public void printArrayBinario(byte[] conteudo){
		for(int i = 0; i < conteudo.length; i++)
			System.out.println(conteudo[i]);
	}
	
	
	
}