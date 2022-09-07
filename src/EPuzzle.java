/**
 * Enumerado para o Puzzle
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public interface EPuzzle {
	
	public static final int ESQ 	= 0;
	public static final int MID 	= 1;
	public static final int DIR 	= 2;
	public static final int TOP 	= 0;
	public static final int BOTTOM 	= 2;
	
	public static final int MOVE_CIMA  = 0;
	public static final int MOVE_BAIXO = 1;
	public static final int MOVE_ESQ   = 2;
	public static final int MOVE_DIR   = 3;
	
	public static final String[] operacoes = {
		"CIMA", "BAIXO", "ESQUERDA", "DIREITA"	
	};
	
	public static final String[] linhas = {
			"Primeira Linha", "Segunda Linha", "Terceira Linha"
	};
	
	public static final String[] colunas = {
			"Primeira Coluna", "Segunda Coluna", "Terceira Coluna"
	};
	
	
}