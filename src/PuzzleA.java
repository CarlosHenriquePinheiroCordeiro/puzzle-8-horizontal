import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 * Classe responsável pela resolução do puzzle pelo A*
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class PuzzleA {

	private Puzzle        puzzle 	           = null;
	private String        estadoDesejado       = "123456780";
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
		if (puzzle.getFilho() == null) {
			puzzle.setFilho(getFilhoHeuristicaPuzzle(puzzle));
		}
		Main.caminho.add(puzzle.getFilho());
		return puzzle.getAcao()+"\n"+resolve(puzzle.getFilho());
	}
	
	/**
	 * Retorna o filho ideal para expandir de acordo com a heurística
	 * @param puzzle
	 * @return
	 */
	private Puzzle getFilhoHeuristicaPuzzle(Puzzle puzzle) {
		Hashtable<Integer, List<Puzzle>> filhos = getDescendentesPorHeuristica(puzzle);
		List<Integer> keys = Collections.list(filhos.keys());
		Collections.sort(keys);
		return getMenorFilhoHeuristica(filhos.get(keys.get(0)));
	}
	
	/**
	 * Retorna o melhor filho de acordo com a heurística, inclusive em caso de empate heurístico
	 * @param empate
	 * @return
	 */
	private Puzzle getMenorFilhoHeuristica(List<Puzzle> empate) {
		if (empate.size() == 1) {
			return empate.get(0);
		}
		Hashtable<Integer, Puzzle>       filhosEmpate   = new Hashtable<Integer, Puzzle>();
		Hashtable<Integer, List<Puzzle>> melhoresFilhos = new Hashtable<Integer, List<Puzzle>>();
		for (Puzzle filho : empate) {
			Hashtable<Integer, List<Puzzle>> filhos = getDescendentesPorHeuristica(filho);
			List<Integer> keys = Collections.list(filhos.keys());
			Collections.sort(keys);
			filhosEmpate.put(keys.get(0), filho);
			melhoresFilhos.put(keys.get(0), filhos.get(keys.get(0)));
		}
		List<Integer> keys = Collections.list(filhosEmpate.keys());
		Collections.sort(keys);
		filhosEmpate.get(keys.get(0)).setFilho(getMenorFilhoHeuristica(melhoresFilhos.get(keys.get(0))));
		return filhosEmpate.get(keys.get(0));
	}
	
	/**
	 * Filtra os melhores filhos para um desempate, para evitar o loop de "vai e volta" de operações
	 * @param melhoresFilhos
	 * @return
	 */
	private Hashtable<Integer, List<Puzzle>> filtraMelhoresFilhos(Hashtable<Integer, List<Puzzle>> melhoresFilhos) {
		for (int chave : Collections.list(melhoresFilhos.keys())) {
			int tamanho = melhoresFilhos.get(chave).size();
			for (int i = 0; i < tamanho; i++) {
				if (melhoresFilhos.get(chave).get(i).getResultadoPuzzle().equals(melhoresFilhos.get(chave).get(i).getPai().getPai().getResultadoPuzzle())) {
					melhoresFilhos.get(chave).remove(i);
				}
			}
			if (melhoresFilhos.get(chave).isEmpty()) {
				melhoresFilhos.remove(chave);
			}
		}
		return melhoresFilhos;
	}
	
	/**
	 * Retorna os descentendes classificados por heurística
	 * @param puzzle
	 * @return
	 */
	private Hashtable<Integer, List<Puzzle>> getDescendentesPorHeuristica(Puzzle puzzle) {
		Hashtable<Integer, List<Puzzle>> filhos = new Hashtable<Integer, List<Puzzle>>();
		int[] posicaoLivre = puzzle.getPosicaoLivre();
		for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
			Puzzle novoPuzzle = new Puzzle(puzzle.getResultadoPuzzle(), operacoes[2], operacoes[0], operacoes[1]);
			novoPuzzle.setPai(puzzle);
			int heuristica = getHeuristica(novoPuzzle);
			if (novoPuzzle.getPai().getPai() != null) {
				if (novoPuzzle.getResultadoPuzzle().equals(novoPuzzle.getPai().getPai().getResultadoPuzzle())) {
					continue;
				}
			}
			if (filhos.containsKey(heuristica)) {
				filhos.get(heuristica).add(novoPuzzle);
			} else {
				List<Puzzle> novo = new ArrayList<Puzzle>();
				novo.add(novoPuzzle);
				filhos.put(heuristica, novo);
			}
			
		}
		return filhos;
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
		return Math.abs(locPeca[0] - locPecaDesejado[0]) + Math.abs(locPeca[1] - locPecaDesejado[1]);
	}
	
	public PuzzleA(Puzzle puzzle) {
		setPuzzle(puzzle);
		puzzleEstadoDesejado = new Puzzle(estadoDesejado);
	}
	
	public PuzzleA(Puzzle puzzle, String estadoDesejado) {
		setPuzzle(puzzle);
		puzzleEstadoDesejado = new Puzzle(estadoDesejado);
		this.estadoDesejado = estadoDesejado;
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	
}