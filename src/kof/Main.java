/*
190320 케릭터 6명 참여 설정
*/
package kof;


public class Main {

	
	public static void main(String[] args) {
		KOFCtrl kofCtrl = new KOFCtrl();
		
		//6명게임 으로 첫 A팀의 3명과 B의 후 3팀으로 나눈다.

 		Player	 playerA = new Player(0,
 									CharacterList.getCan(),
 									CharacterList.getCheTT(),
 									CharacterList.getIori());
 		Player	 playerB = new Player(1,
 									CharacterList.getKyo(),
 									CharacterList.getMin(),
									CharacterList.getMoon());
						
		kofCtrl.ready(playerA.getPlayerTeam1(),playerB.getPlayerTeam2());
		kofCtrl.start();
	}
}