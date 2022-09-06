package puzzle_grid;

public interface IPuzzle {

	/**
	 * Move a peça para cima
	 * @return boolean
	 */
	public boolean moveCima();
	
	/**
	 * Move a peça para a esquerda
	 * @return boolean
	 */
	public boolean moveEsquerda();
	
	/**
	 * Move a peça para a direita
	 * @return boolean
	 */
	public boolean moveDireita();
	
	/**
	 * Move a peça para baixo
	 * @return boolean
	 */
	public boolean moveBaixo();
	
	
}