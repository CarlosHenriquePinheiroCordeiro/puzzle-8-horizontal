import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

/**
 * Atividade para componente curricular Inteligência Artificial
 * Busca horizontal e heurística para a resolução do Puzzle8
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Main {

	private JFrame frame;
	private JTextField inicial11;
	private JTextField inicial12;
	private JTextField inicial13;
	private JTextField inicial21;
	private JTextField inicial22;
	private JTextField inicial23;
	private JTextField inicial31;
	private JTextField inicial32;
	private JTextField inicial33;
	private JTextField final11;
	private JTextField final12;
	private JTextField final13;
	private JTextField fina21;
	private JTextField final22;
	private JTextField final23;
	private JTextField final31;
	private JTextField final32;
	private JTextField final33;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puzzle 8");
		lblNewLabel.setBounds(183, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		inicial11 = new JTextField();
		inicial11.setBounds(33, 67, 30, 30);
		frame.getContentPane().add(inicial11);
		inicial11.setColumns(10);
		
		inicial12 = new JTextField();
		inicial12.setColumns(10);
		inicial12.setBounds(69, 67, 30, 30);
		frame.getContentPane().add(inicial12);
		
		inicial13 = new JTextField();
		inicial13.setColumns(10);
		inicial13.setBounds(104, 67, 30, 30);
		frame.getContentPane().add(inicial13);
		
		inicial21 = new JTextField();
		inicial21.setColumns(10);
		inicial21.setBounds(33, 108, 30, 30);
		frame.getContentPane().add(inicial21);
		
		inicial22 = new JTextField();
		inicial22.setColumns(10);
		inicial22.setBounds(69, 108, 30, 30);
		frame.getContentPane().add(inicial22);
		
		inicial23 = new JTextField();
		inicial23.setColumns(10);
		inicial23.setBounds(104, 108, 30, 30);
		frame.getContentPane().add(inicial23);
		
		inicial31 = new JTextField();
		inicial31.setColumns(10);
		inicial31.setBounds(33, 149, 30, 30);
		frame.getContentPane().add(inicial31);
		
		inicial32 = new JTextField();
		inicial32.setColumns(10);
		inicial32.setBounds(69, 149, 30, 30);
		frame.getContentPane().add(inicial32);
		
		inicial33 = new JTextField();
		inicial33.setColumns(10);
		inicial33.setBounds(104, 149, 30, 30);
		frame.getContentPane().add(inicial33);
		
		JRadioButton horizontal = new JRadioButton("Busca Horizontal");
		horizontal.setBounds(6, 220, 109, 23);
		frame.getContentPane().add(horizontal);
		
		JRadioButton heuristica = new JRadioButton("Heurística A*");
		heuristica.setBounds(120, 220, 109, 23);
		frame.getContentPane().add(heuristica);
		
		JLabel metodoBusca = new JLabel("Método de Busca:");
		metodoBusca.setBounds(61, 199, 97, 14);
		frame.getContentPane().add(metodoBusca);
		
		JLabel labelInicial = new JLabel("Informe o estado inicial:");
		labelInicial.setBounds(33, 42, 137, 14);
		frame.getContentPane().add(labelInicial);
		
		final11 = new JTextField();
		final11.setColumns(10);
		final11.setBounds(274, 67, 30, 30);
		frame.getContentPane().add(final11);
		
		final12 = new JTextField();
		final12.setColumns(10);
		final12.setBounds(310, 67, 30, 30);
		frame.getContentPane().add(final12);
		
		final13 = new JTextField();
		final13.setColumns(10);
		final13.setBounds(345, 67, 30, 30);
		frame.getContentPane().add(final13);
		
		fina21 = new JTextField();
		fina21.setColumns(10);
		fina21.setBounds(274, 108, 30, 30);
		frame.getContentPane().add(fina21);
		
		final22 = new JTextField();
		final22.setColumns(10);
		final22.setBounds(310, 108, 30, 30);
		frame.getContentPane().add(final22);
		
		final23 = new JTextField();
		final23.setColumns(10);
		final23.setBounds(345, 108, 30, 30);
		frame.getContentPane().add(final23);
		
		final31 = new JTextField();
		final31.setColumns(10);
		final31.setBounds(274, 149, 30, 30);
		frame.getContentPane().add(final31);
		
		final32 = new JTextField();
		final32.setColumns(10);
		final32.setBounds(310, 149, 30, 30);
		frame.getContentPane().add(final32);
		
		final33 = new JTextField();
		final33.setColumns(10);
		final33.setBounds(345, 149, 30, 30);
		frame.getContentPane().add(final33);
		
		JLabel labelFinal = new JLabel("Informe o estado final:");
		labelFinal.setBounds(274, 42, 137, 14);
		frame.getContentPane().add(labelFinal);
		Puzzle puzzle = new Puzzle("123405678");
//		PuzzleHorizontal puzzleHorizontal = new PuzzleHorizontal(puzzle);
//		System.out.print(puzzleHorizontal.resolvePuzzle());
		PuzzleA puzzleA = new PuzzleA(puzzle);
		System.out.print("A*:"+puzzleA.resolvePuzzle());
	}
}
