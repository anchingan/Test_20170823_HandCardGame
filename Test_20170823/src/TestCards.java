/*
 * 第二次評測上機考
 * 2017-08-23
 */

import java.util.Scanner;

public class TestCards {

	public static void main(String[] args) {
		//建立Scanner物件以讀取使用者輸入的參數。
		Scanner scanner = new Scanner(System.in);
		
		//建立Player型態的物件player及computer以代表玩家及電腦。
		Player player = new Player(), computer = new Player();
		//建立新的牌組用於遊戲當中。
		Cards card = new Cards();
		//記錄遊戲目前的回合數、進行狀態及輸入值。
		int round = 0, status = 0, input;
		
		System.out.print("開始遊戲(y/n)？");
		while (status != -1) {
			switch (status) {
			case 0:
				String inputString = scanner.next();
				if (inputString.equalsIgnoreCase("y") == true)
					status = 1;
				else if (inputString.equalsIgnoreCase("n") == true)
					status = -1;
				else
					System.out.println("輸入錯誤！");
				break;
			//新遊戲開始。
			case 1:
				round = 1;
				player = new Player();
				computer = new Player();
				card.newCards().shuffle();
				status++;
				System.out.println("開始洗牌…");
				break;
			//遊戲回合。	
			case 2:
				System.out.printf("\n進行第%d回合:\n", round);
				//各發5張手牌。
				for (int i = 0; i < 5; i++) {
					player.addCards(card.deal(), i);
					computer.addCards(card.deal(), i);
				}
				System.out.println("電腦得5張手牌，玩家得5張手牌。\n"
						+ "你的牌為：");
				for (int i = 0; i < 5; i++) 
					player.showHandCards(i).printCard();
				System.out.println("");
				status++;
				break;
			case 3:
				System.out.print("你的選擇? 1)調整手牌順序, 2)亮牌:");
				input = scanner.nextInt();
				if (input == 1)
					status++;
				else if (input == 2)
					status+= 2;
				else
					System.out.println("輸入錯誤！");
				break;
			//調整手牌。
			case 4:
				System.out.print("輸入你要交換的兩張牌（牌的編號為0到4）:");
				int input1 = scanner.nextInt(), input2 = scanner.nextInt();
				if (input1 < 0 || input1 > 4 || input2 < 0 || input2 > 4)
					System.out.println("輸入錯誤！");
				else {
					player.switchCards(input1, input2);
					System.out.println("你的牌為：");
					for (int i = 0; i < 5; i++) 
						player.showHandCards(i).printCard();
					System.out.println("");
				}
				status--;
				break;
			case 5:
				System.out.printf("%S%10s\n", "電腦","玩家");
				int result;
				//計算對戰結果並印出。
				for (int i = 0; i < 5; i++) {
					computer.showHandCards(i).printCard();
					System.out.print("-> ");
					player.showHandCards(i).printCard();
					result = Card.compare(computer.showHandCards(i), player.showHandCards(i));
					if (result == 0)
						System.out.print("平手\n");
					else if (result > 0) {
						System.out.printf("電腦勝，得%d點\n", result);
						computer.addScore(result);
					}
					else {
						result = result * (-1);
						System.out.printf("玩家勝，得%d點\n", result);
						player.addScore(result);
					}
				}
				
				System.out.printf("電腦得到%d點，你得到%d點。\n", computer.getScore(), player.getScore());
				if (round == 3) {
					int scoreComputer = computer.getScore(), scorePlayer = player.getScore();
					if (scoreComputer > scorePlayer)
						System.out.println("電腦獲勝！");
					else if (scoreComputer < scorePlayer)
						System.out.println("你獲勝了！");
					else
						System.out.println("平手！");
					System.out.print("再玩一次(y/n)?");
					status = 0;
				}
				else {
					round++;
					status = 2;
				}
				break;
			}
		}
		System.out.println("遊戲結束！");
		
		

	}

}
