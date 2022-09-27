/**
 * Atividade para componente curricular Inteligência Artificial
 * Busca horizontal e heurística para a resolução do Puzzle8
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Main {

	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle("135706824");
		PuzzleA puzzleA = new PuzzleA(puzzle);
		System.out.println(puzzleA.resolvePuzzle());
	}


}