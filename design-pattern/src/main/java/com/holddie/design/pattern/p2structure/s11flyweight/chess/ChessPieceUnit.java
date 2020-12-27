package com.holddie.design.pattern.p2structure.s11flyweight.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChessPieceUnit {
	private int id;
	private String text;
	private Color color;

	public static enum Color {
		/**
		 * red black
		 */
		RED,
		BLACK
	}
}
