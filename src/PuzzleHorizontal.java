import java.util.ArrayList;
import java.util.List;

public class PuzzleHorizontal {
	
	private List<String> visitados 	    = null;
	private List<Puzzle> visitar 	    = null;
	private String 		 estadoDesejado = "123405678";
	
	/**
	 * Dá início a resolução do Puzzle
	 * @return
	 */
	public String resolvePuzzle() {
		return resolve(visitar.get(0));
	}
	
	/**
	 * Executa a resolução do Puzzle
	 * @param puzzle
	 * @return
	 */
	private String resolve(Puzzle puzzle) {
		if (!isVisitado(puzzle)) {
			String resultadoPuzzle = puzzle.getResultadoPuzzle();
			visitados.add(resultadoPuzzle);
			Puzzle proximo = visitar.get(0);
			visitar.remove(0);
			if (resultadoPuzzle == estadoDesejado) {
				return puzzle.getAcao();
			}
			int[] posicaoLivre = puzzle.getPosicaoLivre();
			for (int[] operacoes : Operacoes.getInstance().get(posicaoLivre[0]).get(posicaoLivre[1])) {
				Puzzle novoPuzzle = new Puzzle(resultadoPuzzle, operacoes[2], operacoes[0], operacoes[1]);
				visitar.add(novoPuzzle);
			}
			resolve(proximo);
		}
		return null;
	}
	
	/**
	 * Retorna se o resultado do Puzzle já foi encontrado
	 * @param puzzle
	 * @return
	 */
	public boolean isVisitado(Puzzle puzzle) {
		return getVisitados().contains(puzzle.getResultadoPuzzle());
	}
	
	public PuzzleHorizontal(Puzzle puzzleInicial) {
		getVisitar().add(puzzleInicial);
	}
	
	public List<String> getVisitados() {
		if (this.visitados == null) {
			this.visitados = new ArrayList<String>();
		}
		return this.visitados;
	}
	
	public void setVisitados(List<String> visitados) {
		this.visitados = visitados;
	}
	
	public List<Puzzle> getVisitar() {
		if (this.visitar == null) {
			this.visitar = new ArrayList<Puzzle>();
		}
		return this.visitar;
	}
	
	public void setVisitar(List<Puzzle> visitar) {
		this.visitar = visitar;
	}
	
	public String getEstadoDesejado() {
		return estadoDesejado;
	}
	
	public void setEstadoDesejado(String estadoDesejado) {
		this.estadoDesejado = estadoDesejado;
	}
	
	
}