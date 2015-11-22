JCC = javac
JFLAGS = -g

default: GeradorArquivoBinario.class Arquivo.class ArquivoRegular.class Diretorio.class Particao.class ArquivosParticao.class BitmapParticao.class GerenciadorDaParticao.class GerenciadorDeArquivos.class Prompt.class Simulador.class

GeradorArquivoBinario.class: GeradorArquivoBinario.java
	$(JCC) $(JFLAGS) GeradorArquivoBinario.java

Arquivo.class: Arquivo.java
	$(JCC) $(JFLAGS) Arquivo.java

ArquivoRegular.class: ArquivoRegular.java Arquivo.java
	$(JCC) $(JFLAGS) ArquivoRegular.java

Diretorio.class: Diretorio.java Arquivo.java
	$(JCC) $(JFLAGS) Diretorio.java

Particao.class: Particao.java
	$(JCC) $(JFLAGS) Particao.java

ArquivosParticao.class: ArquivosParticao.java Particao.java
	$(JCC) $(JFLAGS) ArquivosParticao.java

BitmapParticao.class: BitmapParticao.java Particao.java
	$(JCC) $(JFLAGS) BitmapParticao.java

GerenciadorDaParticao.class: GerenciadorDaParticao.java
	$(JCC) $(JFLAGS) GerenciadorDaParticao.java

GerenciadorDeArquivos.class: GerenciadorDeArquivos.java
	$(JCC) $(JFLAGS) GerenciadorDeArquivos.java

Prompt.class: Prompt.java
	$(JCC) $(JFLAGS) Prompt.java

Simulador.class: Simulador.java
	$(JCC) $(JFLAGS) Simulador.java

clean: 
	$(RM) *.class
