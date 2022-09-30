import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;


import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

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
	private JLabel lblInsiraNo;
	public static List<Puzzle> caminho = new ArrayList<Puzzle>();
	public static int nodosVisitados   = 0;
	public static int nodosGerados 	   = 0;

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
		frame.setBounds(100, 100, 430, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puzzle 8");
		lblNewLabel.setBounds(190, 16, 50, 14);
		frame.getContentPane().add(lblNewLabel);
		
		inicial11 = new JTextField();
		inicial11.setBounds(33, 67, 30, 30);
		frame.getContentPane().add(inicial11);
		inicial11.setColumns(1);
		
		inicial12 = new JTextField();
		inicial12.setColumns(1);
		inicial12.setBounds(69, 67, 30, 30);
		frame.getContentPane().add(inicial12);
		
		inicial13 = new JTextField();
		inicial13.setColumns(1);
		inicial13.setBounds(104, 67, 30, 30);
		frame.getContentPane().add(inicial13);
		
		inicial21 = new JTextField();
		inicial21.setColumns(1);
		inicial21.setBounds(33, 108, 30, 30);
		frame.getContentPane().add(inicial21);
		
		inicial22 = new JTextField();
		inicial22.setColumns(1);
		inicial22.setBounds(69, 108, 30, 30);
		frame.getContentPane().add(inicial22);
		
		inicial23 = new JTextField();
		inicial23.setColumns(1);
		inicial23.setBounds(104, 108, 30, 30);
		frame.getContentPane().add(inicial23);
		
		inicial31 = new JTextField();
		inicial31.setColumns(1);
		inicial31.setBounds(33, 149, 30, 30);
		frame.getContentPane().add(inicial31);
		
		inicial32 = new JTextField();
		inicial32.setColumns(1);
		inicial32.setBounds(69, 149, 30, 30);
		frame.getContentPane().add(inicial32);
		
		inicial33 = new JTextField();
		inicial33.setColumns(1);
		inicial33.setBounds(104, 149, 30, 30);
		frame.getContentPane().add(inicial33);
		
		JRadioButton horizontal = new JRadioButton("Busca Horizontal");
		horizontal.setBounds(33, 211, 125, 23);
		frame.getContentPane().add(horizontal);
		
		JRadioButton heuristica = new JRadioButton("Heurística A*");
		heuristica.setBounds(33, 237, 109, 23);
		frame.getContentPane().add(heuristica);
		
		horizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (horizontal.isSelected()) {
					heuristica.setSelected(false);
				}
			}
		});
		
		heuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heuristica.isSelected()) {
					horizontal.setSelected(false);
				}
			}
		});
		
		JLabel metodoBusca = new JLabel("Método de Busca:");
		metodoBusca.setBounds(33, 190, 105, 14);
		frame.getContentPane().add(metodoBusca);
		
		JLabel labelInicial = new JLabel("Informe o estado inicial:");
		labelInicial.setBounds(33, 30, 137, 14);
		frame.getContentPane().add(labelInicial);
		
		final11 = new JTextField();
		final11.setText("1");
		final11.setEnabled(false);
		final11.setColumns(1);
		final11.setBounds(274, 67, 30, 30);
		frame.getContentPane().add(final11);
		
		final12 = new JTextField();
		final12.setText("2");
		final12.setEnabled(false);
		final12.setColumns(1);
		final12.setBounds(310, 67, 30, 30);
		frame.getContentPane().add(final12);
		
		final13 = new JTextField();
		final13.setText("3");
		final13.setEnabled(false);
		final13.setColumns(1);
		final13.setBounds(345, 67, 30, 30);
		frame.getContentPane().add(final13);
		
		fina21 = new JTextField();
		fina21.setText("4");
		fina21.setEnabled(false);
		fina21.setColumns(1);
		fina21.setBounds(274, 108, 30, 30);
		frame.getContentPane().add(fina21);
		
		final22 = new JTextField();
		final22.setText("5");
		final22.setEnabled(false);
		final22.setColumns(1);
		final22.setBounds(310, 108, 30, 30);
		frame.getContentPane().add(final22);
		
		final23 = new JTextField();
		final23.setText("6");
		final23.setEnabled(false);
		final23.setColumns(1);
		final23.setBounds(345, 108, 30, 30);
		frame.getContentPane().add(final23);
		
		final31 = new JTextField();
		final31.setText("7");
		final31.setEnabled(false);
		final31.setColumns(1);
		final31.setBounds(274, 149, 30, 30);
		frame.getContentPane().add(final31);
		
		final32 = new JTextField();
		final32.setText("8");
		final32.setEnabled(false);
		final32.setColumns(1);
		final32.setBounds(310, 149, 30, 30);
		frame.getContentPane().add(final32);
		
		final33 = new JTextField();
		final33.setText("0");
		final33.setEnabled(false);
		final33.setColumns(1);
		final33.setBounds(345, 149, 30, 30);
		frame.getContentPane().add(final33);
		
		JLabel labelFinal = new JLabel("Estado Final");
		labelFinal.setBounds(274, 42, 137, 14);
		frame.getContentPane().add(labelFinal);
		
		JButton resolver = new JButton("Resolver");
		resolver.setBounds(274, 220, 101, 23);
		frame.getContentPane().add(resolver);
		
		lblInsiraNo = new JLabel("Insira 0 no espaço vazio!");
		lblInsiraNo.setBounds(33, 48, 140, 14);
		frame.getContentPane().add(lblInsiraNo);
		resolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String estadoInicial = inicial11.getText()+inicial12.getText()+inicial13.getText()
										  +inicial21.getText()+inicial22.getText()+inicial23.getText()
										  +inicial31.getText()+inicial32.getText()+inicial33.getText();
					Puzzle puzzle = new Puzzle(estadoInicial);
					if (horizontal.isSelected()) {
						PuzzleHorizontal ph = new PuzzleHorizontal(puzzle);
						long tempoInicial = System.currentTimeMillis();
						ph.resolvePuzzle();
						long tempoFinal = System.currentTimeMillis();
						Puzzle nodoFinal = caminho.get(0);
						inicial11.setText(""+nodoFinal.getPuzzle()[0][0]);
						inicial12.setText(""+nodoFinal.getPuzzle()[0][1]);
						inicial13.setText(""+nodoFinal.getPuzzle()[0][2]);
						inicial21.setText(""+nodoFinal.getPuzzle()[1][0]);
						inicial22.setText(""+nodoFinal.getPuzzle()[1][1]);
						inicial23.setText(""+nodoFinal.getPuzzle()[1][2]);
						inicial31.setText(""+nodoFinal.getPuzzle()[2][0]);
						inicial32.setText(""+nodoFinal.getPuzzle()[2][1]);
						inicial33.setText(""+nodoFinal.getPuzzle()[2][2]);
						Deque<String> caminho = new ArrayDeque<String>();
						do {
							caminho.add(nodoFinal.getAcao());
							nodoFinal = nodoFinal.getPai();
						} while (nodoFinal != null);
						System.out.print("Busca Horizontal: Nodos Gerados - "+nodosGerados+" | Nodos Visitados: "+nodosVisitados+" | Tempo de execução: "+(tempoFinal-tempoInicial)+"ms\n");
						System.out.print("Caminho da resolução:");
						while (caminho.size() != 0) {
							System.out.print(caminho.pollLast()+"\n");
						}
					}
					if (heuristica.isSelected()) {
						PuzzleA pa = new PuzzleA(puzzle);
						long tempoInicial = System.currentTimeMillis();
						pa.resolvePuzzle();
						long tempoFinal = System.currentTimeMillis();
						System.out.print("Heurísitca A*: Nodos Gerados - "+nodosGerados+" | Nodos Visitados: "+nodosVisitados+" | Tempo de execução: "+(tempoFinal-tempoInicial)+"ms\n");
						System.out.print("Caminho da resolução:");
			 			for (Puzzle passo : caminho) {
			 				System.out.print("\n"+passo.getAcao());
							inicial11.setText(""+passo.getPuzzle()[0][0]);
							inicial12.setText(""+passo.getPuzzle()[0][1]);
							inicial13.setText(""+passo.getPuzzle()[0][2]);
							inicial21.setText(""+passo.getPuzzle()[1][0]);
							inicial22.setText(""+passo.getPuzzle()[1][1]);
							inicial23.setText(""+passo.getPuzzle()[1][2]);
							inicial31.setText(""+passo.getPuzzle()[2][0]);
							inicial32.setText(""+passo.getPuzzle()[2][1]);
							inicial33.setText(""+passo.getPuzzle()[2][2]);
						}
					}
					caminho.clear();
					nodosGerados   = 0;
					nodosVisitados = 0;
				} catch (Exception ex) {
					ex.printStackTrace();
					caminho.clear();
					nodosGerados   = 0;
					nodosVisitados = 0;
				}
			}
		});
		
	}
}
