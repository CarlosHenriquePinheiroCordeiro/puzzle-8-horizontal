import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class PuzzleHorizontal {
	
	private List<String>  resultados     = new ArrayList<String>();
	private List<Puzzle>  visitados      = new ArrayList<Puzzle>();
	private Queue<Puzzle> visitar 		 = new LinkedList<Puzzle>();
	private String 		  estadoDesejado = "123405678";
	
	/**
	 * Dá início a resolução do Puzzle
	 * @return
	 */
	public String resolvePuzzle() {
		return resolve(visitar.peek());
	}
	
	/**
	 * Executa a resolução do Puzzle
	 * @param puzzle
	 * @return
	 */
	private String resolve(Puzzle puzzle) {
		if (!isVisitado(puzzle)) {
			String resultadoPuzzle = puzzle.getResultadoPuzzle();
			System.out.println("Ação: "+puzzle.getAcao()+" - Resultado: "+resultadoPuzzle);
			resultados.add(resultadoPuzzle);
			if (resultadoPuzzle == estadoDesejado) {
				return puzzle.getAcao();
			}
			int[] posicaoLivre = puzzle.getPosicaoLivre();
			for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
				Puzzle novoPuzzle = new Puzzle(resultadoPuzzle, operacoes[2], operacoes[0], operacoes[1]);
				visitar.add(novoPuzzle);
			}
		}
		Puzzle proximo = visitar.poll();
		return proximo.getAcao()+"\n"+resolve(proximo);
	}
	
	/**
	 * Retorna se o resultado do Puzzle já foi encontrado
	 * @param puzzle
	 * @return
	 */
	public boolean isVisitado(Puzzle puzzle) {
		return resultados.contains(puzzle.getResultadoPuzzle());
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial) {
		visitar.add(puzzleInicial);
	}
	
	
}