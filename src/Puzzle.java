import java.lang.reflect.Array;

/**
 * Classe responsável por representar o Puzzle
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Puzzle {

	private int[][] puzzle = new int[3][3];
	
	public Puzzle(int topEsq, int top, int topDir, int midEsq, int mid, int midDir, int bottomEsq, int bottom, int bottomDir) {
		this.puzzle[EPuzzle.TOP][EPuzzle.ESQ] 	 = topEsq;
		this.puzzle[EPuzzle.TOP][EPuzzle.MID]  	 = top;
		this.puzzle[EPuzzle.TOP][EPuzzle.DIR] 	 = topDir;
		this.puzzle[EPuzzle.MID][EPuzzle.ESQ] 	 = midEsq;
		this.puzzle[EPuzzle.MID][EPuzzle.MID] 	 = mid;
		this.puzzle[EPuzzle.MID][EPuzzle.DIR] 	 = midDir;
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.ESQ] = bottomEsq;
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.MID] = bottom;
		this.puzzle[EPuzzle.BOTTOM][EPuzzle.DIR] = bottomDir;
	}
	
	public int[][] getPuzzle() {
		return this.puzzle;
	}
	
	/**
	 * Retorna o resultado do Puzzle
	 * @return
	 */
	public String getResultadoPuzzle() {
		String resultado = "";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
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
	}

	
}