import java.io.BufferedReader;
import java.util.Scanner;

public class Prompt {
	
	BufferedReader br;
	Scanner sc;
	String arquivoEntrada;
	String comandoLido;
	String[] args;
	String[] tokens;
	Prompt() {
		br = null;
		sc = new Scanner(System.in);
	}
	
	void setComandoLido(String comandoLido){
		this.comandoLido = comandoLido;
	}
	
	void setArgumentos(String []args){
		this.args = args;
	}
	public String getComandoLido(){
		return this.comandoLido;
	}
	
	void parserComando(String comandoLido){
		tokens = comandoLido.split(" ");
		setArgumentos(tokens);
	}
	
	void leComandos() {
		System.out.print("[ep3]:");
		comandoLido = sc.nextLine();
		parserComando(comandoLido);
		comandoLido = args[0];
		
	}

	public String[] getArgumentos() {
		return args;
	}

}
