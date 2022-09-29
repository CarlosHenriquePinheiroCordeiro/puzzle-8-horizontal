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
	public String resolvePuzzle() {
		Puzzle puzzle = visitar.poll();
		if (puzzle.getResultadoPuzzle().equals(this.estadoDesejado))
			return puzzle.getAcao();
		return resolve(puzzle);
	}
	
	/**
	 * Executa a resolução do Puzzle
	 * @param puzzle
	 * @return
	 */
	private String resolve(Puzzle puzzle) {
		String resultadoPuzzle = puzzle.getResultadoPuzzle();
		visitados.add(resultadoPuzzle);
		int[] posicaoLivre = puzzle.getPosicaoLivre();
		for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
			Puzzle novoPuzzle = new Puzzle(resultadoPuzzle, operacoes[2], operacoes[0], operacoes[1]);
			String novoResultado = novoPuzzle.getResultadoPuzzle();
			if (!isVisitado(novoResultado)) {
				novoPuzzle.setPai(puzzle);
				if (novoResultado.equals(estadoDesejado)) {
					return novoPuzzle.getAcao();
				}
				visitados.add(novoResultado);
				visitar.add(novoPuzzle);
			}
		}
		return puzzle.getAcao()+"\n"+resolve(visitar.poll());
	}
	
	/**
	 * Retorna se o resultado do Puzzle já foi encontrado
	 * @param puzzle
	 * @return
	 */
	public boolean isVisitado(String resultadoPuzzle) {
		return visitados.contains(resultadoPuzzle);
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial) {
		visitar.add(puzzleInicial);
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial, String estadoDesejado) {
		visitar.add(puzzleInicial);
		this.estadoDesejado = estadoDesejado;
	}
	
	
}