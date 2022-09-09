/**
 * Atividade para componente curricular Inteligência Artificial
 * Busca horizontal e heurística para a resolução do Puzzle8
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Main {

	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle("102345678");
		PuzzleHorizontal resolver = new PuzzleHorizontal(puzzle);
		System.out.println(resolver.resolvePuzzle());
	}

}
