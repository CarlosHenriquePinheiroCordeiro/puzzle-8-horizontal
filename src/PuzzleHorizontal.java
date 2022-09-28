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
		return resolve(visitar.poll());
	}
	
	/**
	 * Executa a resolução do Puzzle
	 * @param puzzle
	 * @return
	 */
	private String resolve(Puzzle puzzle) {
		if (!isVisitado(puzzle)) {
			System.out.println(puzzle.getAcao());
			String resultadoPuzzle = puzzle.getResultadoPuzzle();
			visitados.add(resultadoPuzzle);
			if (resultadoPuzzle.equals(estadoDesejado)) {
				return puzzle.getAcao();
			}
			int[] posicaoLivre = puzzle.getPosicaoLivre();
			for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
				Puzzle novoPuzzle = new Puzzle(resultadoPuzzle, operacoes[2], operacoes[0], operacoes[1]);
				if (!isVisitado(novoPuzzle))
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
	public boolean isVisitado(Puzzle puzzle) {
		return visitados.contains(puzzle.getResultadoPuzzle());
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial) {
		visitar.add(puzzleInicial);
	}
	
	
}