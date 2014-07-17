//Alexandra K. Barry
//akbarry@mit.edu
//R09, James Whiting
//Homework 4: TicTacToeGame class 
//8 March 2010

import javax.swing.*;

public class TicTacToeGame {
	public static void main(String[] args) {
		int numX = 		0;
		int numO = 		0;
		int numGames = 	0;
		int turnNumber = 0;

		String input = JOptionPane.showInputDialog("For what n would you like to play Tic Tac Toe? Assume an nxn board.");
		int boardSize = Integer.parseInt(input);
		while (boardSize < 3){
			input = JOptionPane.showInputDialog("Please enter a valid n (n must be at least 3).");
			boardSize = Integer.parseInt(input);
		}

		String input2 = JOptionPane.showInputDialog("How many games must one win to be declared the winner of the series?");
		int numToWin = Integer.parseInt(input2);

		Board gameBoard = new Board(boardSize);
		Mark x = new Mark("X");
		Mark o = new Mark("O");

		int rowChoice = -1;
		int columnChoice = -1;

		String input4;
		String input5;

		//GAME PLAY
		while ((numX < numToWin) && (numO < numToWin)){
			gameBoard.clearBoard();
			while (!gameBoard.isGameOver(x, o)){

				if (turnNumber % 2 == 0) {

					gameBoard.printBoard();
					System.out.println("     Player X's Turn." + "\n" + "\n"  + "\n");

					input4 = JOptionPane.showInputDialog("Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
					rowChoice = Integer.parseInt(input4);
					while ((rowChoice > (boardSize - 1)) || (rowChoice < 0)){
						input4 = JOptionPane.showInputDialog("Invalid entry. Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
						rowChoice = Integer.parseInt(input4);
					}

					input5 = JOptionPane.showInputDialog("Player X: Enter your mark by choosing a position on the board. Enter the column number (0,..." + boardSize + ") of your choice here:");
					columnChoice = Integer.parseInt(input5);
					while ((columnChoice > (boardSize - 1)) || (columnChoice < 0)){
						input5 = JOptionPane.showInputDialog("Invalid entry. Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
						columnChoice = Integer.parseInt(input5);
					}

					if (gameBoard.addMark(rowChoice, columnChoice, x)){
						turnNumber++;
					}else{

						do{
							input4 = JOptionPane.showInputDialog("Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
							rowChoice = Integer.parseInt(input4);

							input5 = JOptionPane.showInputDialog("Player X: Enter your mark by choosing a position on the board. Enter the column number (0,..." + boardSize + ") of your choice here:");
							columnChoice = Integer.parseInt(input5);

						}while (!gameBoard.addMark(rowChoice, columnChoice, x));
						turnNumber++;
					}

					if (gameBoard.hasWon(x)){
						numX++;
						numGames++;
						gameBoard.printBoard();
						System.out.println("\n" + "\n" + "Player X wins!");
						System.out.println("Current tournament statistics:");
						System.out.println("Player X has won " + numX + " games, Player O has won " + numO + " games."  + "\n" + "\n");

					} else if (gameBoard.isDraw()){
						numGames++;
						gameBoard.printBoard();
						System.out.println("\n" + "\n" + "Game is a draw!");
						System.out.println("Current tournament statistics:");
						System.out.println("Player X has won " + numX + " games, Player O has won " + numO + " games."  + "\n" + "\n");
					}

				} else {
					gameBoard.printBoard();
					System.out.println("     Player O's Turn." + "\n" + "\n"  + "\n");

					input4 = JOptionPane.showInputDialog("Player O: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
					rowChoice = Integer.parseInt(input4);
					while ((rowChoice > (boardSize - 1)) || (rowChoice < 0)){
						input4 = JOptionPane.showInputDialog("Invalid entry. Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
						rowChoice = Integer.parseInt(input4);
					}

					input5 = JOptionPane.showInputDialog("Player O: Enter your mark by choosing a position on the board. Enter the column number (0,..." + boardSize + ") of your choice here:");
					columnChoice = Integer.parseInt(input5);
					while ((columnChoice > (boardSize - 1)) || (columnChoice < 0)){
						input5 = JOptionPane.showInputDialog("Invalid entry. Player X: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
						columnChoice = Integer.parseInt(input5);
					}

					if (gameBoard.addMark(rowChoice, columnChoice, o)){
						turnNumber++;
					}else{
						do{
							input4 = JOptionPane.showInputDialog("Player O: Enter your mark by choosing a position on the board. Enter the row number (0,..." + boardSize + ") of your choice here:");
							rowChoice = Integer.parseInt(input4);

							input5 = JOptionPane.showInputDialog("Player O: Enter your mark by choosing a position on the board. Enter the column number (0,..." + boardSize + ") of your choice here:");
							columnChoice = Integer.parseInt(input5);

						}while (!gameBoard.addMark(rowChoice, columnChoice, o));
						turnNumber++;
					}
					if (gameBoard.hasWon(o)){
						numO++;
						numGames++;
						gameBoard.printBoard();
						System.out.println("\n" + "\n" + "Player O wins!");
						System.out.println("Current stats:");
						System.out.println("Player O has won " + numO + " games, Player X has won " + numX + " games."  + "\n" + "\n");
					} else if (gameBoard.isDraw()){
						numGames++;
						gameBoard.printBoard();
						System.out.println("\n" + "\n" + "Game is a draw!");
						System.out.println("Current tournament statistics:");
						System.out.println("Player O has won " + numO + " games, Player X has won " + numX + " games."  + "\n" + "\n");
					}
				} 
			} 
		}

		if (numX == numToWin){
			System.out.println("Player X wins the tournament!");
		}

		if (numO == numToWin){
			System.out.println("Player O wins the tournament!");
		}

	}
}

