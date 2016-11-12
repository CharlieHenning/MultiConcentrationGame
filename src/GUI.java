import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI{
	public int GridSize;
	public JFrame GameWindow;
	public Logic GameLogic;
	public ArrayList<ArrayList<Tile>> gameTiles;
	public ArrayList<Tile> selectedTiles = new ArrayList<Tile>();
	
	
	public GUI(int gridSize){
		this.GridSize = gridSize;
		GameWindow = new JFrame();
		GameWindow.setTitle("Multi Concentration Game");
		GameWindow.setSize(800, 800);
		
		Dimension minimumSize = new Dimension(800, 800);
		GameWindow.setMinimumSize(minimumSize);
	
		//Calling Logic class to get ArrayList of Tiles
		GameLogic = new Logic();
		
		//Create Main Menu		
		GameWindow.setJMenuBar(CreateGameMenu());
		
		//JOptionPane.showMessageDialog(GameWindow, welcomeMessage());
		
		//Create GameBoard
		CreateGameBoard(gridSize);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HideCards();
		
		//after time Redraw with numbers on the grid
		
		//EVENTS::
			//User selects tile
				//change tile background to grey, make read only button
			//User selects second tile
				//evaluate if Tile.letter values match, updat display value to letter value.
	}
	
	
	//Hide cards by using image and removing button text
	public void HideCards()
	{

	}
	
	//Check if game won by examining tiles 
	//If won, return congratulations message and ask to play again
	public void CheckGameState()
	{
		if(GameLogic.gameFinished(gameTiles))
		{
			if(JOptionPane.showConfirmDialog(GameWindow, "Congratulations, You Win! \n" + "Press Yes to restart game", 
					"Confirmation Dialog", JOptionPane.YES_NO_OPTION) == 0)
			{
				CreateGameBoard(GridSize);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HideCards();
			}
		}
	}
	
	public JMenuBar CreateGameMenu()
	{
		JMenuBar menubar = new JMenuBar();
		
		JMenuItem newGame = new JMenuItem("Restart Game");
		newGame.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						if(JOptionPane.showConfirmDialog(GameWindow, "Press Yes to restart game", 
								"Confirmation Dialog", JOptionPane.YES_NO_OPTION) == 0)
						{
							CreateGameBoard(GridSize);
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							HideCards();
						}
					}
				});
		
		JMenuItem exit = new JMenuItem("Exit Game");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(JOptionPane.showConfirmDialog(GameWindow, "Press Yes to exit game", 
						"Confirmation Dialog", JOptionPane.YES_NO_OPTION) == 0)
					System.exit(0);
			}
		});
		
		JMenuItem confirmCards = new JMenuItem("Confirm Choices");
		confirmCards.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//Comparing tiles stuff, if correct, reveal buttons, reset all other buttons
				if(selectedTiles.size() >2)
				{
					
								CheckGameState();
							
					
				}
				
			}	
		});
		
		menubar.add(newGame);
		menubar.add(exit);
		menubar.add(confirmCards);
		
		return menubar;
	}
	
	//Generates GameBoard.  Creates new set of cards
	public void CreateGameBoard(int gridSize)
	{
		//Get new list of Tiles 
		gameTiles = GameLogic.generateGrid(gridSize);
		
		JPanel tileBoard = new JPanel(new GridLayout(gridSize, gridSize));
				
		for (ArrayList<Tile> subArrayGameTiles: gameTiles)
		{			
			    for (Tile tile : subArrayGameTiles)
			     {
			    	TileButton<Tile> button = CreateTile(tile);
			    	//Set click event on button to change background and store value
			    	tileBoard.add(button);
			     }
		}
		
		GameWindow.add(tileBoard);
		GameWindow.setVisible(true);
	}
	
	//Creates tile for gameboard.  Handles button parameters
	public TileButton<Tile> CreateTile(Tile tile)
	{
		TileButton<Tile> button = new TileButton<Tile>();
		button.setBorder(new LineBorder(Color.black, 4));
		button.setTile(tile);
		button.setText(String.valueOf(tile.Letter));
		
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							TileButton<?> clickedButton = (TileButton<?>)e.getSource();
							Tile btnTile = (Tile) clickedButton.getTile();
							//Updating btn color when clicked
							LineBorder btnBrdr = (LineBorder) clickedButton.getBorder();
							Color btnBrdrClr = btnBrdr.getLineColor();
							
							if(btnBrdrClr == Color.black)
								{
									if(selectedTiles.size()< 2)
									{
										//User selecting new tile, add id to list
										selectedTiles.add(btnTile);
										clickedButton.setBorder(new LineBorder(Color.yellow, 4));						
									}
								}
							else
								{
									//User unselecting tile, remove from list								
									selectedTiles.remove(btnTile);
									selectedTiles.trimToSize();
									clickedButton.setBorder(new LineBorder(Color.black, 4));
								}						
						}
						catch(Exception exec)
						{
							exec.printStackTrace();
						}
					}
				});
		return button;
	}
	
	
	public String welcomeMessage(){
		return "Welcome to the Concentration game! \n"
				+ "The rules are as follows: \n"
				+ "The screen will display a grid of Letters for a short period of time \n"
				+ "and then the screen will clear and the letters of the grid will be replaced with numbers. \n"
				+ "You must remember where the matching numbers are and enter the corresponding numbers, one pair at a time. \n"
				+ "Enter the two numbers on the grid you would like to flip separated by a space I.E.: 2 4 \n"
				+ "If the two places on the grid match the spots will display the letters you found. \n"
				+ "If the two places on the grid you selected do not match the letters will be shown briefly and then the \n"
				+ "grid will be redrawn.\n"
				+ "click OK when you are ready to start!";
	}
	
}