//Alexandra K. Barry
//akbarry@mit.edu
//R09, James Whiting
//Homework 4: Board class
//8 March 2010

public class Board {
	private int size;
	private Mark board[][];
	private int numberOfMarks = 0;

	public Board(int n){
		size = n;
		board = new Mark[size][size];
	}
	
	public void clearBoard(){
		board = new Mark[size][size];
		numberOfMarks = 0;
	}
	
	public boolean addMark(int i, int j, Mark m){
		if (board[i][j] == null){
			board[i][j] = m;
			numberOfMarks++;
			return (true);
		} else {
			return (false);
		}
	}
	
	public boolean hasWon(Mark m){
		//check rows
		int rowCount;
		for (int i = 0; i < size; i++){
			rowCount = 0;
			for (int j = 0; j < size; j++){
				if (board[i][j] == m){
					rowCount++;
				}
			}
			if (rowCount == size){
				return true;
			}
		}

		//check columns
		int columnCount;
		for (int j = 0; j < size; j++){
			columnCount = 0;
			for (int i = 0; i < size; i++){
				if (board[i][j] == m){
					columnCount++;
				}
			}
			if (columnCount == size){
				return true;
			}
		}

		//check diagonals
		int diagonal1Count = 0;
		for (int i = 0; i < size; i++){
			if (board[i][i] == m){
				diagonal1Count++;
			}
			if (diagonal1Count == size){
				return true;
			}
		}

		int diagonal2Count = 0;
		for (int i = 0; i < size; i++){
			if (board[i][size - i - 1] == m){
				diagonal2Count++;
			}
			if (diagonal2Count == size){
				return true;
			}
		}
		return false;
	}

	public boolean isDraw(){
		if (numberOfMarks == size*size){
			return (true);
		}else{
			return (false);
		}
	}


	public boolean isGameOver(Mark x, Mark o){
		if (hasWon(x)){
			return true;
		}else if (hasWon(o)){
			return true;
		}else if (isDraw()){
			return true;
		}else{
			return false;
		}
	}

	public void printBoard(){
		System.out.print("  ");
		for (int l = 0; l < size; l++){
			System.out.print("    " + l + "   ");
		}
		System.out.println("\n");
		for (int i = 0; i < (size-1); i++) {
			System.out.print(i + "     ");
			for (int j = 0; j < (size-1); j++){
				if (board[i][j] != null){
					System.out.print(board[i][j].toString() + "   :   ");
				} else {
					System.out.print("    :   ");
				}
			}

			if (board[i][size-1] != null){
				System.out.println(board[i][size-1].toString());	
			} else {
				System.out.println();
			}

			System.out.print("   ");
			for (int k = 0; k < size; k++){
				System.out.print("........");
			}
			System.out.println();
		}
		System.out.print((size-1) + "     ");
		for (int j = 0; j < (size-1); j++){
			if (board[size-1][j] != null){
				System.out.print(board[size-1][j].toString() + "   :   ");
			} else {
				System.out.print("    :   ");
			}
		}
		if (board[size-1][size-1] != null){
			System.out.print(board[size-1][size-1].toString());	
		}

	}

}




