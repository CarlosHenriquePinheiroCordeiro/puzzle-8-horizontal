import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class PuzzleHorizontal {
	
	private List<String>  visitados      = new ArrayList<String>();
	private Queue<Puzzle> visitar 		 = new LinkedList<Puzzle>();
	private String 		  estadoDesejado = "123456780";
	
	/**
	 * Dá início a resolução do Puzzle
	 * @return
	 */
	public Puzzle resolvePuzzle() {
		Puzzle puzzle = visitar.poll();
		if (puzzle.getResultadoPuzzle().equals(this.estadoDesejado))
			return puzzle;
		return resolve(puzzle);
	}
	
	/**
	 * Executa a resolução do Puzzle
	 * @param puzzle
	 * @return
	 */
	private Puzzle resolve(Puzzle puzzle) {
		String resultadoPuzzle = puzzle.getResultadoPuzzle();
		visitados.add(resultadoPuzzle);
		int[] posicaoLivre = puzzle.getPosicaoLivre();
		int filhos = 0;
	    Queue<Puzzle> descendentes = new LinkedList<Puzzle>();
		for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
			Puzzle novoPuzzle = new Puzzle(resultadoPuzzle, operacoes[2], operacoes[0], operacoes[1]);
			if (!isVisitado(novoPuzzle)) {
				filhos++;
				descendentes.add(novoPuzzle);
				visitados.add(novoPuzzle.getResultadoPuzzle());
				visitar.add(novoPuzzle);
			}
		}
		for (int x = 0; x < filhos; x++) {
			Puzzle filho = descendentes.poll();
			if (filho.getResultadoPuzzle().equals(estadoDesejado)) {
				return filho;
			}
		}
		puzzle.setFilho(resolve(visitar.poll()));
		return puzzle;
	}
	
	/**
	 * Retorna se o resultado do Puzzle já foi encontrado
	 * @param puzzle
	 * @return
	 */
	public boolean isVisitado(Puzzle puzzle) {
		return visitados.contains(puzzle.getResultadoPuzzle());
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial) {
		visitar.add(puzzleInicial);
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial, String estadoDesejado) {
		visitar.add(puzzleInicial);
		this.estadoDesejado = estadoDesejado;
	}
	
	
}