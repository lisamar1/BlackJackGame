package com.lmig.gfc.blackjackgame.models;

public class AceCard extends Card {

	public AceCard(Suits suit) {
		super(suit);
	}

	@Override
	public String getFace() {
		return "A";
	}

	@Override
	public int getValue() {
		return 11;
	}
	

	

}
