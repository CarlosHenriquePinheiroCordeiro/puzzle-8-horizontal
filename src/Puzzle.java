import puzzle_grid.IPuzzle;

/**
 * Classe responsável por representar o Puzzle
 * @author Carlos Henrique Pinheiro Cordeiro
 *
 */
public class Puzzle {

	private IPuzzle Top 		= null;
	private IPuzzle TopLeft 	= null;
	private IPuzzle TopRight 	= null;
	private IPuzzle Mid			= null;
	private IPuzzle MidLeft 	= null;
	private IPuzzle MidRight 	= null;
	private IPuzzle Bottom 		= null;
	private IPuzzle BottomLeft 	= null;
	private IPuzzle BottomRight = null;
	
	public Puzzle() {
		
	}
	
	public IPuzzle getTop() {
		return Top;
	}
	
	public void setTop(IPuzzle top) {
		Top = top;
	}
	
	public IPuzzle getTopLeft() {
		return TopLeft;
	}
	
	public void setTopLeft(IPuzzle topLeft) {
		TopLeft = topLeft;
	}
	
	public IPuzzle getTopRight() {
		return TopRight;
	}
	
	public void setTopRight(IPuzzle topRight) {
		TopRight = topRight;
	}
	
	public IPuzzle getMid() {
		return Mid;
	}
	
	public void setMid(IPuzzle mid) {
		Mid = mid;
	}
	
	public IPuzzle getMidLeft() {
		return MidLeft;
	}
	
	public void setMidLeft(IPuzzle midLeft) {
		MidLeft = midLeft;
	}
	
	public IPuzzle getMidRight() {
		return MidRight;
	}
	
	public void setMidRight(IPuzzle midRight) {
		MidRight = midRight;
	}
	
	public IPuzzle getBottom() {
		return Bottom;
	}
	
	public void setBottom(IPuzzle bottom) {
		Bottom = bottom;
	}
	
	public IPuzzle getBottomLeft() {
		return BottomLeft;
	}
	
	public void setBottomLeft(IPuzzle bottomLeft) {
		BottomLeft = bottomLeft;
	}
	
	public IPuzzle getBottomRight() {
		return BottomRight;
	}
	
	public void setBottomRight(IPuzzle bottomRight) {
		BottomRight = bottomRight;
	}

	
}