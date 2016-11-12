import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class GUILogic {

	public static final int gameBoardHorzSize = 800;
	public static final int gameBoardVertSize = 800;

	/*
	 * / Hide cards by setting card image
	 */
	public void HideCards(ArrayList<TileButton<Tile>> tileBtnAry) {
		for (TileButton<Tile> tileBtn : tileBtnAry) {
			if (!tileBtn.getTile().getMatchFound())
				tileBtn.setIcon(new ImageIcon("cardicon.png"));
			else {
				tileBtn.setBorder(new LineBorder(Color.black, 4));
			}
		}
	}

	/*
	 * /Remove Card Images so Tile letters are viewable
	 */
	public void RemoveTileImages(ArrayList<TileButton<Tile>> tileBtnAry) {
		for (TileButton<?> tileBtn : tileBtnAry) {
			tileBtn.setIcon(null);
		}
	}

	/*
	 * Sets all initial formatting for TileButtons
	 */
	public TileButton<Tile> SetTileFormatting(Tile tile) {
		TileButton<Tile> tileBtn = new TileButton<Tile>();
		tileBtn.setTile(tile);
		tileBtn.setText(String.valueOf(tile.Letter));
		tileBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		// Default tile border color
		tileBtn.setBorder(new LineBorder(Color.black, 4));

		return tileBtn;

	}

	/*
	 * Set all initial formatting for GameWindow
	 */
	public JFrame GetGameWindowFormatting() {
		JFrame gameWindow = new JFrame();
		gameWindow.setTitle("Multi Concentration Game");
		gameWindow.setSize(gameBoardHorzSize, gameBoardVertSize);

		Dimension minimumSize = new Dimension(gameBoardHorzSize, gameBoardVertSize);
		gameWindow.setMinimumSize(minimumSize);

		return gameWindow;
	}
}
