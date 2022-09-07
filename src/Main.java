import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Puzzle estadoDesejado = new Puzzle(1, 2, 3, 4, 0, 5, 6, 7, 8);
		for (int[] op : Operacoes.getInstance().get(EPuzzle.BOTTOM).get(EPuzzle.DIR)) {
			System.out.println(EPuzzle.linhas[op[0]]+" - "+EPuzzle.colunas[op[1]]+" - "+EPuzzle.operacoes[op[2]]);
		}
	}

}
