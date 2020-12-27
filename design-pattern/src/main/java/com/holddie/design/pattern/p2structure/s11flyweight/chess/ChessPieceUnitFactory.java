package com.holddie.design.pattern.p2structure.s11flyweight.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceUnitFactory {

	private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

	static {
		pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
		pieces.put(2, new ChessPieceUnit(2, "马", ChessPieceUnit.Color.BLACK));
	}

	public static ChessPieceUnit getChessPiece(int chessPieceId) {
		return pieces.get(chessPieceId);
	}

}
