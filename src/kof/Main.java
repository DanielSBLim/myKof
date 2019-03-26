/*
190320 케릭터 6명 참여 설정
*/
package kof;


public class Main {
	
	static int playerATeam = 0;
	static int playerBTeam = 1;
		
	public static void main(String[] args) {
		KOFCtrl kofCtrl = new KOFCtrl();
		
		//6명게임 으로 첫 A팀의 3명과 B의 후 3팀으로 나눈다.

 		Player	 playerA = new Player(playerATeam,CharacterList.getCan());
 				 playerA = new Player(playerATeam,CharacterList.getCheTT());
 				 playerA = new Player(playerATeam,CharacterList.getIori());
 		Player	 playerB = new Player(playerBTeam,CharacterList.getKyo());
 				 playerB = new Player(playerBTeam,CharacterList.getMin());
 				 playerB = new Player(playerBTeam,CharacterList.getMoon());
						
		kofCtrl.ready(playerA.getPlayerTeam1(),playerB.getPlayerTeam2());
		kofCtrl.start();
	}
}