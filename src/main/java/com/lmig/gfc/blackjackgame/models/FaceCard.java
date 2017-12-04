package com.lmig.gfc.blackjackgame.models;

public class FaceCard extends Card {

	private Face face; 

	public FaceCard(Suits suit, Face face) {
		super(suit);
		this.face = face;
	}

	@Override
	public String getFace() {
		return face.toString();
	}

	@Override
	public int getValue() {
		return 10;
	}

}
