import java.util.List;


public class Simulador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		String[] argumentos;
		String comando;
		GerenciadorDeArquivos gArquivos = new GerenciadorDeArquivos();
		boolean lerComandos = true;
		while(lerComandos){
			prompt.leComandos();
			argumentos = prompt.getArgumentos();
			comando = argumentos[0];		
			
			
			switch (comando) {
				
				case "mkdir":
					gArquivos.mkdir(argumentos[1]);
					System.out.println("Rotina mkdir::");
					break;
				case "mount":
					System.out.println("Rotina mount::");
					break;
				case "cp":
					System.out.println("Rotina cp::");
					break;
				case "rmdir":
					gArquivos.rmdir(argumentos[1]);
					System.out.println("Rotina rmdir::");
					break;
				case "cat":
					System.out.println("Rotina cat::");
					break;
				case "touch":
					System.out.println("Rotina touch::");
					gArquivos.touch(argumentos[1]);
					break;
				case "rm":
					gArquivos.rm(argumentos[1]);
					System.out.println("Rotina rm::");
					break;
				case "ls":
					gArquivos.ls(argumentos[1]);
					System.out.println("Rotina ls::");
					break;
				case "find":
					gArquivos.find(argumentos[1], argumentos[2]);
					System.out.println("Rotina find::");
					break;
				case "df":
					System.out.println("Rotina df::");
					break;
				case "umount":
					System.out.println("Rotina umount::");
					break;
				case "sai":
					System.out.println("Rotina sai::");
					lerComandos = false;
					break;
								
				default:
					break;
			}
			
		
			
		}
		
	}

}
