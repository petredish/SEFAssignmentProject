package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

// The merge of Knight and Rook
public class Knook extends Piece
{
	
	public Knook(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "Q");
	}

	
	
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		// Adding Knight Movement pattern --------------------------------------
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow + 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow + 1, currCol - 2));
		
		potentialPositions.add(new PiecePosition(currRow - 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow - 1, currCol - 2));
		
		// end Knight ----------------------------------------------------------
		
		
		// Adding Rook Movement Pattern ----------------------------------------
		try {
			piece = arr[currRow + 1][currCol];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		// if there is a piece their and it is the same color then don't add
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol));
			potentialPositions.add(new PiecePosition(currRow + 2, currCol));
		}
		
		
		try {
			piece = arr[currRow-1][currCol];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol));
			potentialPositions.add(new PiecePosition(currRow - 2, currCol));
		}
		
		try {
			piece = arr[currRow][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow, currCol + 1));
			potentialPositions.add(new PiecePosition(currRow, currCol + 2));
		}
		
		
		try {
			piece = arr[currRow][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow, currCol - 1));
			potentialPositions.add(new PiecePosition(currRow, currCol - 2));
		}
		// End Rook ------------------------------------------------------------
		
		potentialPositions = removeInvalidPositions(potentialPositions, arr);
		
		return potentialPositions;

	}
}
