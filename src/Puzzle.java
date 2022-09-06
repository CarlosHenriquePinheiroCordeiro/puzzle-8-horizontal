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
	 * Se permitido, move a peça para cima
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public boolean moveUp(int i, int j) {
		if (i - 1 >= 0 || this.puzzle[i-1][j] == 0) {
			int valor = this.puzzle[i][j];
			this.puzzle[i][j] = 0;
			this.puzzle[i-1][j] = valor;
			return true;
		}
		return false;
	}
	
	/**
	 * Se permitido, move a peça para baixo
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public boolean moveDown(int i, int j) {
		if (i + 1 <= 2 || this.puzzle[i+1][j] == 0) {
			int valor = this.puzzle[i][j];
			this.puzzle[i][j] = 0;
			this.puzzle[i+1][j] = valor;
		}
		return false;
	}
	
	/**
	 * Se permitido, move a peça para a esquerda
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public boolean moveEsq(int i, int j) {
		if (j - 1 >= 0 || this.puzzle[i][j-1] == 0) {
			int valor = this.puzzle[i][j];
			this.puzzle[i][j] = 0;
			this.puzzle[i][j-1] = valor;
		}
		return false;
	}
	
	/**
	 * Se permitido, move a peça para a direita
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public boolean moveDir(int i, int j) {
		if (j + 1 <= 2 || this.puzzle[i][j+1] == 0) {
			int valor = this.puzzle[i][j];
			this.puzzle[i][j] = 0;
			this.puzzle[i][j+1] = valor;
		}
		return false;
	}

	
}