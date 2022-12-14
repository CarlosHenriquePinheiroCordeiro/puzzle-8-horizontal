import java.util.List;
import java.util.ArrayList;

public class Operacoes {

	private static List<ArrayList<ArrayList<int[]>>> operacoes = null;
	
	private Operacoes() {}
	
	/**
	 * Retorna a instância das operações possíveis
	 * @return
	 */
	public static List<ArrayList<ArrayList<int[]>>> getInstance() {
		if (operacoes == null) {
			operacoes = new ArrayList<ArrayList<ArrayList<int[]>>>();
			buildOperacoes();
		}
		return operacoes;
	}
	
	/**
	 * Constrói as operações possíveis, com base na posição livre do tabuleiro
	 */
	private static void buildOperacoes() {
		buildOperacoesTop();
		buildOperacoesMid();
		buildOperacoesBottom();
	}
	
	/**
	 * Constrói as operações possíveis da primeira linha do tabuleiro, com base na posição livre
	 */
	private static void buildOperacoesTop() {
		ArrayList<ArrayList<int[]>> ops = new ArrayList<ArrayList<int[]>>();
		ops.add(addOperacoes1x1());
		ops.add(addOperacoes1x2());
		ops.add(addOperacoes1x3());
		operacoes.add(ops);
	}
	
	/**
	 * Operações para quando a posição livre é 1x1
	 */
	private static ArrayList<int[]> addOperacoes1x1() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 1x2
	 */
	private static ArrayList<int[]> addOperacoes1x2() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 1x3
	 */
	private static ArrayList<int[]> addOperacoes1x3() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Constrói as operações possíveis da segunda linha do tabuleiro, com base na posição livre
	 */
	private static void buildOperacoesMid() {
		ArrayList<ArrayList<int[]>> ops = new ArrayList<ArrayList<int[]>>();
		ops.add(addOperacoes2x1());
		ops.add(addOperacoes2x2());
		ops.add(addOperacoes2x3());
		operacoes.add(ops);
	}
	
	/**
	 * Operações para quando a posição livre é 2x1
	 */
	private static ArrayList<int[]> addOperacoes2x1() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 2x2
	 */
	private static ArrayList<int[]> addOperacoes2x2() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 2x3
	 */
	private static ArrayList<int[]> addOperacoes2x3() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.TOP;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_CIMA;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Constrói as operações possíveis da terceira linha do tabuleiro, com base na posição livre
	 */
	private static void buildOperacoesBottom() {
		ArrayList<ArrayList<int[]>> ops = new ArrayList<ArrayList<int[]>>();
		ops.add(addOperacoes3x1());
		ops.add(addOperacoes3x2());
		ops.add(addOperacoes3x3());
		operacoes.add(ops);
	}
	
	/**
	 * Operações para quando a posição livre é 3x1
	 */
	private static ArrayList<int[]> addOperacoes3x1() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);

		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 3x2
	 */
	private static ArrayList<int[]> addOperacoes3x2() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.ESQ;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);
		
		operacao = new int[3]; 
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_ESQ;
		ops.add(operacao);
		
		return ops;
	}
	
	/**
	 * Operações para quando a posição livre é 3x3
	 */
	private static ArrayList<int[]> addOperacoes3x3() {
		ArrayList<int[]> ops = new ArrayList<int[]>();
		
		int[] operacao = new int[3]; 
		operacao[0] = EPuzzle.MID;
		operacao[1] = EPuzzle.DIR;
		operacao[2] = EPuzzle.MOVE_BAIXO;
		ops.add(operacao);
		
		operacao = new int[3];
		operacao[0] = EPuzzle.BOTTOM;
		operacao[1] = EPuzzle.MID;
		operacao[2] = EPuzzle.MOVE_DIR;
		ops.add(operacao);

		return ops;
	}
	
	
}
