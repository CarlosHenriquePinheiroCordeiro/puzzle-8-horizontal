import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Classe responsável pela resolução do puzzle pelo A*
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class PuzzleA {

	private Puzzle        puzzle 	           = null;
	private String        estadoDesejado       = "123405678";
	private Puzzle 		  puzzleEstadoDesejado = null;
	
	/**
	 * Resolve o puzzle e retorna o caminho para a resolução
	 * @return
	 */
	public String resolvePuzzle() {
		return resolve(this.puzzle);
	}
	
	/**
	 * Resolve o puzzle pela busca heurística A*
	 * @param puzzle
	 * @return
	 */
	private String resolve(Puzzle puzzle) {
		if (puzzle.getResultadoPuzzle().equals(estadoDesejado)) {
			return puzzle.getAcao();
		}
		puzzle.setFilho(getFilhoHeuristicaPuzzle(puzzle));
		return puzzle.getAcao()+" "+resolve(puzzle.getFilho());
	}
	
	/**
	 * Retorna o filho ideal para expandir de acordo com a heurística
	 * @param puzzle
	 * @return
	 */
	private Puzzle getFilhoHeuristicaPuzzle(Puzzle puzzle) {
		Hashtable<Integer, Puzzle> filhos = new Hashtable<Integer, Puzzle>();
		int[] posicaoLivre = puzzle.getPosicaoLivre();
		int menorHeuristica = 50;
		for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
			Puzzle novoPuzzle = new Puzzle(puzzle.getResultadoPuzzle(), operacoes[2], operacoes[0], operacoes[1]);
			int heuristica = getHeuristica(novoPuzzle);
			filhos.put(heuristica, novoPuzzle);
			if (heuristica < menorHeuristica)
				menorHeuristica = heuristica;
		}
		return filhos.get(menorHeuristica);
	}
	
	/**
	 * Retorna o valor heurístico do puzzle
	 * @param puzzle
	 * @return
	 */
	private int getHeuristica(Puzzle puzzle) {
		return getPecasForaDoLugar(puzzle) + getDistanciaPecas(puzzle);
	}
	
	/**
	 * Retorna a quantidade de peças fora do lugar do puzzle, em comparação ao estado desejado
	 * @param puzzle
	 * @return
	 */
	public int getPecasForaDoLugar(Puzzle puzzle) {
		int fora = 0;
		char[] pecasEstadoDesejado = estadoDesejado.toCharArray();
		char[] pecas 			   = puzzle.getResultadoPuzzle().toCharArray();
		for (int x = 0; x < pecasEstadoDesejado.length; x++) {
			if (pecas[x] != '0' && pecas[x] != pecasEstadoDesejado[x])
				fora++;
		}
		return fora;
	}
	
	/**
	 * Retorna a soma das distâncias de cada peça fora do lugar, até seu ponto final, de acordo com o estado desejado
	 * @param puzzle
	 * @return
	 */
	public int getDistanciaPecas(Puzzle puzzle) {
		int distancia = 0;
		for (String peca : puzzle.getResultadoPuzzle().split("")) {
			if (!peca.equals("0")) {
				distancia += getDistanciaPecaEstadoDesejado(puzzle, Integer.parseInt(peca));
			}
		}
		return distancia;
	}
	
	/**
	 * Retorna a distância estado-objetivo de determinada peça, de acordo com o estado desejado
	 * @param puzzle
	 * @param peca
	 * @return
	 */
	public int getDistanciaPecaEstadoDesejado(Puzzle puzzle, int peca) {
		int[] locPeca 	      = puzzle.getLocalizacaoPeca(peca);
		int[] locPecaDesejado = puzzleEstadoDesejado.getLocalizacaoPeca(peca);
		return Math.abs((locPeca[0] - locPecaDesejado[0]) + (locPeca[1] - locPecaDesejado[1]));
	}
	
	public PuzzleA(Puzzle puzzle) {
		setPuzzle(puzzle);
		puzzleEstadoDesejado = new Puzzle(estadoDesejado);
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	
}