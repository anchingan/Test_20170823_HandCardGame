
public class Card {

	private int suit, point;
	
	public Card(int suit, int point) {
		if (suit == 2 || suit == 5 || suit == 0)
			this.suit = suit;
		else
			this.suit = 0;
		if (point > 0 && point < 11)
			this.point = point;
		else
			this.point = 1;
	}
	
	//印出牌的花色及點數。
	public void printCard() {
		String[] suitPrint = new String[6];
		suitPrint[0] = "石頭";
		suitPrint[2] = "剪刀";
		suitPrint[5] = "布";
		
		System.out.printf("%2S %2d ", suitPrint[this.suit], this.point);
	}
	
	//比較兩張牌勝負，若平手傳回0，a勝利傳回正值得分，b勝利傳回負值得分。
	public static int compare(Card a, Card b) {
		int result;
		if (a.suit == b.suit) 
			result = 0;
		else if (a.suit < b.suit) {
			if (b.suit == 5 && a.suit == 0)
				result = 0 - a.point;
			else
				result = b.point;
		}
		else {
			if (a.suit == 5 && b.suit == 0)
				result = b.point;
			else
				result = 0 - a.point;
		}
		
		return result;
	}

}
