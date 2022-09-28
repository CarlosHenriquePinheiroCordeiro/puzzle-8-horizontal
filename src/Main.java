/**
 * Atividade para componente curricular Inteligência Artificial
 * Busca horizontal e heurística para a resolução do Puzzle8
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Main {

	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle("123405678");
//		PuzzleHorizontal puzzleHorizontal = new PuzzleHorizontal(puzzle);
//		System.out.print(puzzleHorizontal.resolvePuzzle());
		PuzzleA puzzleA = new PuzzleA(puzzle);
		System.out.print("A*:"+puzzleA.resolvePuzzle());
	}


}