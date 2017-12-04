package com.lmig.gfc.blackjackgame.models;

public class Purse {

	private double money = 100;

	public void removeFromPurse(double bet) {
		money = money - bet;

	}

	public void addtoPurse(double bet) {
		money = money + bet;
	}

	public boolean purseIsEmpty() {
		if (money == 0) {
			return true;
		}

		return false;
	}
}
