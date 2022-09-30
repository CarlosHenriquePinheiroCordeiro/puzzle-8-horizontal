import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Classe responsável por representar o Puzzle
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Puzzle {

	private int[][] puzzle       		= new int[3][3];
	private int[] posicaoLivre   		= null;
	private String resultado     		= null; 
	private String acao 	     		= "";
	private Puzzle pai 			 		= null;
	private Puzzle filho 	     		= null;
	
	/**
	 * Gera um puzzle a partir de um resultado mostrado
	 * @param resultadoPuzzle
	 */
	public Puzzle(String resultadoPuzzle) {
		setNumerosPuzzle(resultadoPuzzle);
	}
	
	/**
	 * Gera um puzzle já realizando alguma operação
	 * @param resultadoPuzzle
	 * @param operacao
	 * @param i
	 * @param j
	 */
	public Puzzle(String resultadoPuzzle, int operacao, int i, int j) {
		setNumerosPuzzle(resultadoPuzzle);
		setAcao(operacao, i, j);
		switch (operacao) {
			case EPuzzle.MOVE_CIMA:
				moveUp(i, j);
				break;
			case EPuzzle.MOVE_BAIXO:
				moveDown(i, j);
				break;
			case EPuzzle.MOVE_ESQ:
				moveEsq(i, j);
				break;
			case EPuzzle.MOVE_DIR:
				moveDir(i, j);
				break;
		}
		this.resultado = geraResultado();
	}
	
	/**
	 * A partir do resultado gera os números do puzzle
	 * @param resultadoPuzzle
	 */
	public void setNumerosPuzzle(String resultadoPuzzle) {
		String[] resultado = resultadoPuzzle.split("");
		this.puzzle[EPuzzle.TOP][EPuzzle.ESQ] 	 = Integer.parseInt(resultado[0]);
		this.puzzle[EPuzzle.TOP][EPuzzle.MID]  	 = Integer.parseInt(resultado[1]);
		this.puzzle[EPuzzle.TOP][EPuzzle.DIR] 	 = Integer.parseInt(resultado[2]);
		this.puzzle[EPuzzle.MID][EPuzzle.ESQ] 	 = Integer.parseInt(resultado[3]);
		this.puzzle[EPuzzle.MID][EPuzzle.MID] 	 = Integer.parseInt(resultado[4]);
		this.puzzle[EPuzzle.MID][EPuzzle.DIR] 	 = Integer.parseInt(resultado[5]);
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.ESQ] = Integer.parseInt(resultado[6]);
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.MID] = Integer.parseInt(resultado[7]);
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.DIR] = Integer.parseInt(resultado[8]);
	}
	
	/**
	 * Retorna o par ordenado da peça desejada do puzzle
	 * @param peca
	 * @return
	 */
	public int[] getLocalizacaoPeca(int peca) {
		int[] localizacao = new int[2];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (puzzle[i][j] == peca) {
					localizacao[0] = i;
					localizacao[1] = j;
					return localizacao;
				}
			}
		}
		return localizacao;
	}
	
	/**
	 * Retorna o resultado do Puzzle
	 * @return
	 */
	public String geraResultado() {
		String resultado = "";
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				resultado += ""+this.puzzle[i][j];
			}
		}
		return resultado;
	}
	
	/**
	 * Retorna o resultado do Puzzle
	 * @return
	 */
	public String getResultadoPuzzle() {
		if (this.resultado == null) {
			this.resultado = geraResultado();
		}
		return this.resultado;
	}

	/**
	 * Retorna a posição livre do puzzle
	 * @return
	 */
	public int[] getPosicaoLivre() {
		if (this.posicaoLivre == null) {
			setPosicaoLivre(achaPosicaoLivre());
		}
		return this.posicaoLivre;
	}
	
	/**
	 * Define a posição livre do puzzle
	 * @param posicaoLivre
	 */
	public void setPosicaoLivre(int[] posicaoLivre) {
		this.posicaoLivre = posicaoLivre;
	}
	
	/**
	 * Procura a posição livre do puzzle
	 * @return
	 */
	public int[] achaPosicaoLivre() {
		int[] posicaoLivre = new int[2];
		int i;
		int j;
		for (i = 0; i <= 2; i++) {
			for (j = 0; j <= 2; j++) {
				if (this.puzzle[i][j] == 0) {
					posicaoLivre[0] = i;
					posicaoLivre[1] = j;
					return posicaoLivre;
				}
			}
		}
		return posicaoLivre;
	}
	
	/**
	 * Move a peça para cima
	 * @param i
	 * @param j
	 */
	public void moveUp(int i, int j) {
		int valor = this.puzzle[i][j];
		this.puzzle[i][j] = 0;
		this.puzzle[i-1][j] = valor;
		int[] posicaoLivre = {i, j};
		setPosicaoLivre(posicaoLivre);
	}
	
	/**
	 * Move a peça para baixo
	 * @param i
	 * @param j
	 */
	public void moveDown(int i, int j) {
		int valor = this.puzzle[i][j];
		this.puzzle[i][j] = 0;
		this.puzzle[i+1][j] = valor;
		int[] posicaoLivre = {i, j};
		setPosicaoLivre(posicaoLivre);
	}
	
	/**
	 * Move a peça para a esquerda
	 * @param i
	 * @param j
	 */
	public void moveEsq(int i, int j) {
		int valor = this.puzzle[i][j];
		this.puzzle[i][j] = 0;
		this.puzzle[i][j-1] = valor;
		int[] posicaoLivre = {i, j};
		setPosicaoLivre(posicaoLivre);
	}
	
	/**
	 * Move a peça para a direita
	 * @param i
	 * @param j
	 */
	public void moveDir(int i, int j) {
		int valor = this.puzzle[i][j];
		this.puzzle[i][j] = 0;
		this.puzzle[i][j+1] = valor;
		int[] posicaoLivre = {i, j};
		setPosicaoLivre(posicaoLivre);
	}

	public int[][] getPuzzle() {
		return this.puzzle;
	}
	
	public void setAcao(int operacao, int i, int j) {
		this.acao = this.puzzle[i][j]+""+EPuzzle.operacoes[operacao];
	}
	
	public String getAcao() {
		return this.acao;
	}

	public Puzzle getPai() {
		return pai;
	}

	public void setPai(Puzzle pai) {
		this.pai = pai;
	}

	public Puzzle getFilho() {
		return filho;
	}

	public void setFilho(Puzzle filho) {
		this.filho = filho;
	}

	public void setPuzzle(int[][] puzzle) {
		this.puzzle = puzzle;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	
}