package com.holddie.design.pattern.p2structure.s11flyweight.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

	public ChessBoard() {
		init();
	}

	private void init() {
		chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
		chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 0, 0));
	}

	public void move(int chessPieceId, int positionX, int positionY) {
		// ...
	}
}
