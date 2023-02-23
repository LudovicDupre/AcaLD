package card_game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<PlayingCard> cards;

	public Deck() {
		cards = new ArrayList<PlayingCard>();
		for (Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				System.out.println("Creating card ["+rank+"]["+suit+"]");
				cards.add(new PlayingCard(rank, suit));
			}
		}
		shuffle();
	}

	public void shuffle() {
		Random random = new Random();
		for  (int i=0; i< cards.size(); ++i) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}

	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}

	public List<PlayingCard> getCards() {
		return cards;
	}
}
