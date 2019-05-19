package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

// The merge of Knight and Bishop
public class Knightshop extends Piece
{
	public Knightshop(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "B");
	}
	
	
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		// Adding Knight Movement Patterns -------------------------------------
	
		potentialPositions.add(new PiecePosition(currRow + 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow + 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow + 1, currCol - 2));
		
		potentialPositions.add(new PiecePosition(currRow - 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow - 1, currCol - 2));
		
		// Knight end ----------------------------------------------------------
		
		// Adding Bishop movement patterns -------------------------------------
		try {
			piece = arr[currRow + 1][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		// if there is a piece their and it is the same color then don't add
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol + 1));
			potentialPositions.add(new PiecePosition(currRow + 2, currCol + 2));
		}
		
		
		try {
			piece = arr[currRow - 1][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol + 1));
			potentialPositions.add(new PiecePosition(currRow - 2, currCol + 2));
		}
		
		try {
			piece = arr[currRow + 1][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol - 1));
			potentialPositions.add(new PiecePosition(currRow + 2, currCol - 2));
		}
		
		
		try {
			piece = arr[currRow - 1][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null) || (!(piece.icon.equals("_")) && (piece.isWhite == isWhite))) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol - 1));
			potentialPositions.add(new PiecePosition(currRow - 2, currCol - 2));
		}
		
		// Bishop end ----------------------------------------------------------
		
		potentialPositions = removeInvalidPositions(potentialPositions, arr);
		
		return potentialPositions;
	}

	
}
