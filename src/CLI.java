import java.util.ArrayList;

public class CLI {
	public int GridSize;
	public  ArrayList<ArrayList<Tile>> gameGrid;
	public Logic logicClass;
	
	public CLI(int gridSize){
		this.GridSize = gridSize;
		 logicClass = new Logic();
		gameGrid = logicClass.generateGrid(gridSize);
		
		
	}
	
}
