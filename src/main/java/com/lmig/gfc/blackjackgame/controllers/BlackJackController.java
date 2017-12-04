package com.lmig.gfc.blackjackgame.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjackgame.models.AceCard;
import com.lmig.gfc.blackjackgame.models.Card;
import com.lmig.gfc.blackjackgame.models.Deck;
import com.lmig.gfc.blackjackgame.models.Game;
import com.lmig.gfc.blackjackgame.models.Hand;
import com.lmig.gfc.blackjackgame.models.NumberCard;
import com.lmig.gfc.blackjackgame.models.Suits;

@Controller

public class BlackJackController {

	private Game game;

	public BlackJackController() {
		game = new Game();
	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {
		game = new Game();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");
		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		ModelAndView mv = new ModelAndView();
		try {
			game.placeBet(bet);
			game.deal();
		} catch (IndexOutOfBoundsException ioobe) {
		}
		mv.setViewName("redirect:/play");
		return mv;
	}

	@PostMapping("/hit")
	public ModelAndView handleHit() {
		ModelAndView mv = new ModelAndView();
		try {
			game.hit();
		} catch (IndexOutOfBoundsException ioobe) {
		}

		if (game.playerBusted()) {
			mv.setViewName("redirect:/summary");
		} else {
			mv.setViewName("redirect:/play");
		}
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		mv.addObject("game", game);
		return mv;
	}

	@GetMapping("/summary")
	public ModelAndView showSummaryScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("summary");
		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/stand")
	public ModelAndView handleStand() {
		ModelAndView mv = new ModelAndView();
		try {
			game.dealer();
		} catch (IndexOutOfBoundsException ioobe) {
		}
		mv.setViewName("redirect:/summary");
		return mv;
	}

	@PostMapping("/newHand")
	public ModelAndView newhand() {
		ModelAndView mv = new ModelAndView();
		try {
			game.deal();
		} catch (IndexOutOfBoundsException ioobe) {
		}
		mv.setViewName("redirect:/play");
		return mv;
	}

	@PostMapping("/restartGame")
	public ModelAndView restartgame() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/tie")
	public ModelAndView gametie() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
}
