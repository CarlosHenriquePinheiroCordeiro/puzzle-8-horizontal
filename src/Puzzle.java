import java.util.List;
import java.util.ArrayList;


/**
 * Classe responsável por representar o Puzzle
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Puzzle {

	private int[][] puzzle       = new int[3][3];
	private int[] posicaoLivre   = null;
	private String acao 	     = null;
	private Puzzle f1 			 = null;
	private Puzzle f2 			 = null;
	private Puzzle f3 			 = null;
	private Puzzle f4 			 = null;
	
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
	 * Retorna o resultado do Puzzle
	 * @return
	 */
	public String getResultadoPuzzle() {
		String resultado = "";
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				resultado += ""+this.puzzle[i][j];
			}
		}
		return resultado;
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
		int i = 0;
		int j = 0;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				if (this.puzzle[i][j] == 0) {
					posicaoLivre[0] = i;
					posicaoLivre[1] = j;
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
		return this.acao+"   ";
	}

	public Puzzle getF1() {
		return f1;
	}

	public void setF1(Puzzle f1) {
		this.f1 = f1;
	}

	public Puzzle getF2() {
		return f2;
	}

	public void setF2(Puzzle f2) {
		this.f2 = f2;
	}

	public Puzzle getF3() {
		return f3;
	}

	public void setF3(Puzzle f3) {
		this.f3 = f3;
	}

	public Puzzle getF4() {
		return f4;
	}

	public void setF4(Puzzle f4) {
		this.f4 = f4;
	}

	public void setPuzzle(int[][] puzzle) {
		this.puzzle = puzzle;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	
}