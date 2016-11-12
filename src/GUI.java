import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI {
	// Size of Game Grid, passed via Main class
	public int GridSize;

	// Length of time to show board, static for all board sizes
	public static final int timerDelay = 5000;

	// Global GUI elements
	public JFrame gameWindow;
	public Logic gameLogic;
	public JPanel tileBoard;

	// ArrayList elements
	public ArrayList<ArrayList<Tile>> gameTilesAry;
	public ArrayList<Tile> selectedTilesAry = new ArrayList<Tile>();
	public ArrayList<TileButton<Tile>> tileBtnAry;

	public GUI(int gridSize) {
		this.GridSize = gridSize;
		gameWindow = new JFrame();
		gameWindow.setTitle("Multi Concentration Game");
		gameWindow.setSize(800, 800);

		Dimension minimumSize = new Dimension(800, 800);
		gameWindow.setMinimumSize(minimumSize);

		// Create Main Menu
		gameWindow.setJMenuBar(CreateGameMenu());

		//Welcome Message
		JOptionPane.showMessageDialog(gameWindow, welcomeMessage());

		StartGame();
	}

	// Method to set up game
	public void StartGame() {
		// Create GameBoard
		CreateGameBoard(GridSize);

		ShowCards();
	}

	// Hide cards by setting image
	public void HideCards() {
		for (TileButton<Tile> tileBtn : tileBtnAry) {
			if (!tileBtn.getTile().getMatchFound())
				tileBtn.setIcon(new ImageIcon("cardicon.png"));
			else {
				tileBtn.setBorder(new LineBorder(Color.black, 4));
			}
		}
	}

	// Show cards then hide ones that were not found
	// TODO fix cards not hiding (setIcon null line)
	public void ShowCards() {
		for (TileButton<?> tileBtn : tileBtnAry) {
			tileBtn.setIcon(null);
		}
		gameWindow.revalidate();
		gameWindow.repaint();
		tileBoard.revalidate();
		tileBoard.repaint();

		// Event to hide cards, cannot use Thread.sleep in Swing
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				HideCards();
				Timer time = (Timer) evt.getSource();
				time.stop();
			}
		};
		new Timer(timerDelay, taskPerformer).start();

	}

	public JMenuBar CreateGameMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenuItem newGameMnuItm = new JMenuItem("Restart Game");
		newGameMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (JOptionPane.showConfirmDialog(gameWindow, "Press Yes to restart game", "Confirmation Dialog",
						JOptionPane.YES_NO_OPTION) == 0) {
					gameWindow.remove(tileBoard);
					StartGame();
				}
			}
		});

		JMenuItem exitMnuItm = new JMenuItem("Exit Game");
		exitMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (JOptionPane.showConfirmDialog(gameWindow, "Press Yes to exit game", "Confirmation Dialog",
						JOptionPane.YES_NO_OPTION) == 0)
					System.exit(0);
			}
		});

		JMenuItem confirmCardsMnuItm = new JMenuItem("Confirm Choices");
		confirmCardsMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Comparing tiles stuff, if correct, reveal buttons, reset all
				// other buttons
				if (selectedTilesAry.size() == 2) {
					// Sending selected tiles to logic class for eval
					if (gameLogic.evaluateMatch(selectedTilesAry.get(0), selectedTilesAry.get(1))) {
						for (Tile slctedTle : selectedTilesAry) {
							for (TileButton<?> tileBtn : tileBtnAry) {
								Tile tile = tileBtn.getTile();

								if (tile.ID == slctedTle.ID && tile.Letter == slctedTle.Letter) {
									tileBtn.setBorder(new LineBorder(Color.black, 4));
									tileBtn.getTile().setMatchFound(true);
									tileBtn.setIcon(null);
								}
							}
						}
						CheckGameState();

						// Clear selected tiles
						selectedTilesAry.clear();
					} else {
						JOptionPane.showMessageDialog(gameWindow,
								"Incorrect, we will show cards " + "again briefly then hide the board");
						ShowCards();
					}
				}
			}
		});

		menuBar.add(newGameMnuItm);
		menuBar.add(exitMnuItm);
		menuBar.add(confirmCardsMnuItm);

		return menuBar;
	}

	// Generates GameBoard. Creates new set of cards
	public void CreateGameBoard(int gridSize) {
		// Calling Logic class to get ArrayList of Tiles
		gameLogic = new Logic();

		// Get new list of Tiles
		gameTilesAry = gameLogic.generateGrid(gridSize);

		tileBoard = new JPanel(new GridLayout(gridSize, gridSize));

		// Create new Btn array, used to track items for evaluation methods
		tileBtnAry = new ArrayList<TileButton<Tile>>();

		for (ArrayList<Tile> subAryGameTls : gameTilesAry) {
			for (Tile tile : subAryGameTls) {
				TileButton<Tile> tileBtn = CreateTile(tile);
				// Set click event on button to change background and store
				// value
				tileBtnAry.add(tileBtn);
			}
		}

		// Add buttons from array to JPanel
		for (TileButton<Tile> tileBtn : tileBtnAry)
			tileBoard.add(tileBtn);

		gameWindow.add(tileBoard);
		gameWindow.setVisible(true);
	}

	// Creates single tile for gameboard. Handles TileButton parameters and
	// events
	public TileButton<Tile> CreateTile(Tile tile) {
		TileButton<Tile> tileBtn = new TileButton<Tile>();
		tileBtn.setTile(tile);
		tileBtn.setText(String.valueOf(tile.Letter));
		tileBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		// Default tile border color
		tileBtn.setBorder(new LineBorder(Color.black, 4));

		tileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TileButton<?> clickedBtn = (TileButton<?>) e.getSource();
					Tile tile = clickedBtn.getTile();

					// Verify User is not trying to select tiles when board
					// shown
					if (clickedBtn.getIcon() != null) {
						// Verify tile has not already been "found"
						if (!tile.getMatchFound()) {
							// Updating btn color when clicked
							LineBorder btnBrdr = (LineBorder) clickedBtn.getBorder();
							Color btnBrdrClr = btnBrdr.getLineColor();

							if (btnBrdrClr == Color.black) {
								if (selectedTilesAry.size() < 2) {
									// User selecting new tile, add id to list
									selectedTilesAry.add(tile);
									clickedBtn.setBorder(new LineBorder(Color.yellow, 4));
								}
							} else {
								// User unselecting tile, remove from list
								selectedTilesAry.remove(tile);
								selectedTilesAry.trimToSize();
								clickedBtn.setBorder(new LineBorder(Color.black, 4));
							}
						}
					}
				} catch (Exception exec) {
					exec.printStackTrace();
				}
			}
		});
		return tileBtn;
	}

	// Check if game won by examining tiles
	// If won, return congratulations message and ask to play again
	public void CheckGameState() {
		if (gameLogic.gameFinished(gameTilesAry)) {
			if (JOptionPane.showConfirmDialog(gameWindow,
					"Congratulations, You Win! \n" + "Press Yes to restart game or No to quit", "Confirmation Dialog",
					JOptionPane.YES_NO_OPTION) == 0) {
				gameWindow.remove(tileBoard);
				StartGame();
			} else
				System.exit(0);
		}
	}

	public String welcomeMessage() {
		return "Welcome to the Concentration game! \n" + "The rules are as follows: \n"
				+ "The screen will display a grid of Letters for a short period of time \n"
				+ "and then the screen will clear and the letters of the grid will be replaced with numbers. \n"
				+ "You must remember where the matching numbers are and enter the corresponding numbers, one pair at a time. \n"
				+ "Enter the two numbers on the grid you would like to flip separated by a space I.E.: 2 4 \n"
				+ "If the two places on the grid match the spots will display the letters you found. \n"
				+ "If the two places on the grid you selected do not match the letters will be shown briefly and then the \n"
				+ "grid will be redrawn.\n" + "click OK when you are ready to start!";
	}

}