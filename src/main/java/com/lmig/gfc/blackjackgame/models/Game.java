package com.lmig.gfc.blackjackgame.models;

public class Game {

	public boolean tie;

	private boolean playerBusted;

	private boolean dealerBusted;

	private boolean playerWins;

	private boolean dealerWins;

	private boolean isHandOver;

	private Deck deck;

	private Hand playerHand;
	private Hand dealerHand;

	private Purse purse;
	private int currentBet;

	public Game() {
		deck = new Deck();
		deck.shuffle();
		playerHand = new Hand();
		dealerHand = new Hand();
		purse = new Purse();
		playerBusted = false;

	}

	public void deal() {

		playerWins = false;
		dealerWins = false;
		tie = false;
		isHandOver = false;
		playerHand = new Hand();
		dealerHand = new Hand();
		purse.removeFromPurse(currentBet);
		dealerHand.addCard(deck.draw());
		dealerHand.addCard(deck.draw());
		playerHand.addCard(deck.draw());
		playerHand.addCard(deck.draw());
		playerBusted = false;
		playerHand.getTotal();
		dealerHand.getTotal();

		if (dealerHand.isBlackJack() || playerHand.isBlackJack()) {
			determineWinner();

		}
		


	}

	public void determineWinner() {

		isHandOver = true;

		if (dealerHand.isBlackJack()) {
			dealerWins = true;
		}

		if (playerHand.isBlackJack()) {
			playerWins = true;
			purse.addtoPurse(currentBet * 1.5 + currentBet);
		}

		if (dealerHand.getTotal() == playerHand.getTotal()) {
			tie = true;
			purse.addtoPurse(currentBet);
		}

		if (playerBusted) {
			dealerWins = true;

		}

		else if (dealerBusted) {
			playerWins = true;
			purse.addtoPurse(currentBet * 2);

		} else if (playerHand.getTotal() > dealerHand.getTotal()) {
			playerWins = true;
			purse.addtoPurse(currentBet * 2);
		} else if (dealerHand.getTotal() > playerHand.getTotal()) {
			dealerWins = true;
		}

	}

	public void dealer() {
		while (dealerHand.getTotal() < 17) {
			Card card = deck.draw();
			dealerHand.accept(card);
		}

		if (dealerHand.getTotal() > 21) {
			dealerBusted = true;
		}

		determineWinner();
	}

	public void hit() {
		Card card = deck.draw();
		playerHand.accept(card);

		if (playerHand.getTotal() > 21) {
			playerBusted = true;

			determineWinner();
		}

	}

	public Deck getDeck() {
		return deck;

	}
	
	public boolean isGameOver() {
		return purseIsEmpty() || deckIsEmpty();
	}

	public void placeBet(int bet) {
		currentBet = bet;

	}
	
	public boolean deckIsEmpty() {
		return deck.size() == 0;
	}

	
	public boolean purseIsEmpty() {
		return purse.purseIsEmpty();
	}

	public boolean playerBusted() {
		return playerHand.getTotal() > 21;
	}
}
