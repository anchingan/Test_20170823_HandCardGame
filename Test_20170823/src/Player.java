
public class Player {
	//Card型態的陣列用以儲存目前的手牌。
	private Card[] handCards;
	private int score;
	
	public Player() {
		this.handCards = new Card[5];
		this.score = 0;
	}
	
	public Card showHandCards(int index) {
		if (index > 4 || index < 0)
			return new Card(0, 1);
		else
			return handCards[index];
	}
	
	//將(抽到的)牌加到目前的手牌當中。
	public void addCards(Card newCard, int index) {
		if (index >= 0 && index < 5)
			handCards[index] = newCard;
		else
			System.out.println("輸入編號超過範圍！");
	}
	public void switchCards(int index1, int index2) {
		if (index1 < 0 || index1 > 4 || index2 < 0 || index2 > 4)
			System.out.println("輸入編號超過範圍！");
		else if (index1 == index2)
			;
		else {
			Card temp;
			temp = handCards[index1];
			handCards[index1] = handCards[index2];
			handCards[index2] = temp;
		}
			
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore(int plus) {
		if (plus >= 0)
			this.score += plus;
	}

}
