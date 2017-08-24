
public class Cards {
	
	private Card[] cardSet;
	//代表目前抽到的索引值。
	private int dealIndex; 
	
	public Cards() {
		cardSet = new Card[30];
		newCards();
	}
	
	//重新建立一副新的牌。
	public Cards newCards() {
		for (int i = 0; i < 10; i++) {
			cardSet[i] = new Card(0, i + 1);
			cardSet[i + 10] = new Card(2, i + 1);
			cardSet[i + 20] = new Card(5, i + 1);
		}
		this.dealIndex = 0;
		return this;
	}
	
	//洗牌。
	public void shuffle() {
		Card temp; //暫存要被交換的牌。
		int ranNum; //亂數產生的索引值。
		for (int i = 0; i < 30; i++) {
			ranNum = (int)(Math.random()*29);
			temp = cardSet[i];
			cardSet[i] = cardSet[ranNum];
			cardSet[ranNum] = temp;
		}
	}
	
	//給索引值，抽出一張牌。
	public Card deal(int index) {
		if (index < cardSet.length)
			return cardSet[index];
		else
			return new Card(0, 1);
	}
	
	//若沒有給索引值，抽最上面的排，抽完後抽牌索引值+1。
	public Card deal() {
		return cardSet[dealIndex++];
	}
	

}
