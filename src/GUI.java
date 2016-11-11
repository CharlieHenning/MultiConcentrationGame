import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI{
	public int GridSize;
	public JFrame GameWindow;
	
	public GUI(int gridSize){
		this.GridSize = gridSize;
		CreateGameBoard(gridSize);
		//Display Window
		//Draw Letters on grid
			//foreach element in the logic.tiles collection create a new button, start a new line based on grid size
			// I.E. row length = gridsize -1;
		//after time Redraw with numbers on the grid
		
		//EVENTS::
			//User selects tile
				//change tile background to grey, make read only button
			//User selects second tile
				//evaluate if Tile.letter values match, updat display value to letter value.
	}
	
	public void CreateGameBoard(int gridSize)
	{
		GameWindow = new JFrame();
		GameWindow.setTitle("Multi Concentration Game");
		GameWindow.setSize(800, 800);
		
		Dimension minimumSize = new Dimension(800, 800);
		GameWindow.setMinimumSize(minimumSize);
		
		JPanel tileBoard = new JPanel(new GridLayout(gridSize, gridSize));
		
		for(int i = 0; i < (gridSize*gridSize); i++)
		{
			JButton button = CreateTile();
			//Set click event on button to change background and store value
			tileBoard.add(button);
		}
		GameWindow.add(tileBoard);
		GameWindow.setVisible(true);
	}
	
	public JButton CreateTile()
	{
		int counterdeleteme = 1;
		JButton button = new JButton();
		button.setIcon(new ImageIcon("cardicon.png"));
		button.setBorder(new LineBorder(Color.black, 4));
		button.setName("SampleButtonName" + counterdeleteme);
		counterdeleteme++;
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							JButton clickedButton = (JButton)e.getSource();
							//Updating btn color when clicked
							LineBorder btnBrdr = (LineBorder) clickedButton.getBorder();
							Color btnBkgrndClr = btnBrdr.getLineColor();
							if(btnBkgrndClr == Color.black)
							{
								clickedButton.setBorder(new LineBorder(Color.yellow, 4));
							}
							else
								clickedButton.setBorder(new LineBorder(Color.black, 4));
							
							//Need to get btn content and store for comparision
						}
						catch(Exception exec)
						{
							exec.printStackTrace();
						}
					}
				});
		return button;
	}
	

}
