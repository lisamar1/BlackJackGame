package com.lmig.gfc.blackjackgame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<Card>();

		public Deck() {

		AceCard heart = new AceCard(Suits.HEARTS);
		cards.add(heart);

		AceCard clubs = new AceCard(Suits.CLUBS);
		cards.add(clubs);

		AceCard diamonds = new AceCard(Suits.DIAMONDS);
		cards.add(diamonds);

		AceCard spades = new AceCard(Suits.SPADES);
		cards.add(spades);

		int[] cardValue = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i : cardValue) {

			// cards.add(new NumberCard(some suit, some number));
			cards.add(new NumberCard(Suits.CLUBS, i));
			cards.add(new NumberCard(Suits.DIAMONDS, i));
			cards.add(new NumberCard(Suits.HEARTS, i));
			cards.add(new NumberCard(Suits.SPADES, i));

		}
		Face[] facePres = { Face.Jack, Face.Queen, Face.King };

		for (Face face : facePres) {

			cards.add(new FaceCard(Suits.CLUBS, face));
			cards.add(new FaceCard(Suits.DIAMONDS, face));
			cards.add(new FaceCard(Suits.HEARTS, face));
			cards.add(new FaceCard(Suits.SPADES, face));

		}

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public int size() {
		return cards.size();
		
	}

	public List<Card> getCards() {
		return cards;
	}

	public Card draw() {
		Card card = cards.remove(0);
		return card; 
	}

	public Object dealCard() {
		return cards;
	}

	
	}