package com.lmig.gfc.blackjackgame.models;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private boolean isBlackJack;

	private ArrayList<Card> cards;

	public Hand() {

		isBlackJack = false;

		cards = new ArrayList<Card>(); // enables hand to hold cards

	}

	public void accept(Card card) {
		cards.add(card);

	}

	public List<Card> getCards() {
		return cards;
	}

	public int getTotal() {
		int ace = 0;
		int sum = 0;
		for (Card card : cards) {
			if (card.getValue() == 11) {
				ace = ace + 1;
			}
		
			sum += card.getValue();
		}
		if (cards.size() == 2 && sum == 21) {
			isBlackJack = true;
		}

		while (sum > 21 && ace > 0) {
			sum = sum - 10;
			ace = ace - 1;
			

		}

		{

		}

		return sum;
	}

	public void addCard(Card dealCard) {
		cards.add(dealCard);
	}

	public void clearHand() {
		cards.clear();
	}

	public boolean isBlackJack() {
		return isBlackJack;
	}
}