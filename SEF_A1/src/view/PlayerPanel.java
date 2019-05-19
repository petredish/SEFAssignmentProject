package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.interfaces.ChessGameEngine;

public class PlayerPanel extends JPanel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea playerOneUsername, playerOneScore, playerTwoUsername, playerTwoScore, playerOneColor, playerTwoColor;
	private JPanel playerOne, playerTwo;
	private ChessGameEngine gameEngine;
	
	
	public PlayerPanel(ChessGameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(200, 150));
		setBorder(BorderFactory.createBevelBorder(1));

		setUp();
	}

	public void setUp()
	{

		Font myFont = new Font("Arial", Font.BOLD, 20);
		
		playerOne = new JPanel();
		playerOne.setFont(myFont);
		playerOne.setBorder(BorderFactory.createTitledBorder("Player One"));
		playerOne.setLayout(new GridLayout(8,1));
		add(playerOne);
		
		playerOneUsername = new JTextArea(gameEngine.getPlayerOne().getPlayerUserName());
		playerOneUsername.setEditable(false);
		playerOneUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerOneScore = new JTextArea("0");
		playerOneScore.setFont(myFont);
		playerOneScore.setEditable(false);
		playerOneScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerOneColor = new JTextArea("Black");
		playerOneColor.setBorder(BorderFactory.createTitledBorder("Color"));
		playerOneColor.setEditable(false);
		
		playerOne.add(new JPanel());
		playerOne.add(new JPanel());		
		playerOne.add(playerOneUsername);
		playerOne.add(playerOneColor);
		playerOne.add(playerOneScore);
		playerOne.add(new JPanel());
		
		
		
		playerTwo = new JPanel();
		playerTwo.setFont(myFont);
		playerTwo.setBorder(BorderFactory.createTitledBorder("Player Two"));
		playerTwo.setLayout(new GridLayout(8,1));
		add(playerTwo);
		
		playerTwoUsername = new JTextArea(gameEngine.getPlayerTwo().getPlayerUserName());
		playerTwoUsername.setEditable(false);
		playerTwoUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerTwoScore = new JTextArea("0");
		playerTwoScore.setFont(myFont);
		playerTwoScore.setEditable(false);
		playerTwoScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerTwoColor = new JTextArea("White");
		playerTwoColor.setBorder(BorderFactory.createTitledBorder("Color"));
		playerTwoColor.setEditable(false);
	
		
		playerTwo.add(new JPanel());
		playerTwo.add(new JPanel());	
		playerTwo.add(playerTwoUsername);
		playerTwo.add(playerTwoColor);
		playerTwo.add(playerTwoScore);
		playerTwo.add(new JPanel());
			
	}

	public void updateScore() {
		playerOneScore.setText( String.valueOf(gameEngine.getPlayerOne().getPoints()));
		playerTwoScore.setText( String.valueOf(gameEngine.getPlayerTwo().getPoints()));
	}

}

