package GameController;

import java.util.ArrayList;
import java.util.List;
import card_game.Deck;
import card_game.Player;
import card_game.PlayingCard;


public class gameController {
	
	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}
	
	Deck deck;
	List<Player> players;
	Player winner;
	View view;
	
	GameState gameState;
	
	public gameController(Deck deck, View view ) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
	}
	public void run() {
		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player (playerName));
			view.showPlayerName(player	s.size(), playerName);
		}
	}
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for (Player player : players) {
				player.addCardToHand(deck.removeTopCard());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}
	public void flipCards() {
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
		
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	void evaluateWinner() {
		Player bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for (Player player : players) {
			boolean newBestPlayer = false;
			if (bestPlayer == null) {
				newBestPlayer = true; 
			} else {
				PlayingCard pc = player.getCard(0);
				int thisRank =pc.getRank().value();
				if (thisRank >= bestRank) {
					if (thisRank > bestRank) {
						newBestPlayer = true;
					} else {
						if (pc.getSuit().value() > bestSuit) {
							newBestPlayer = true;
						}
					}
				}
			}
			
			if (newBestPlayer) {
				bestPlayer = player;
				PlayingCard pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		}
	}
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	void rebuildDeck() {
		for(Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
}
