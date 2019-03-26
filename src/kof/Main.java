/*
190320 케릭터 6명 참여 설정
*/
package kof;

import java.util.ArrayList;

public class Main {
	
	static int playerATeam = 0;
	static int playerBTeam = 1;
		
	public static void main(String[] args) {
		KOFCtrl kofCtrl = new KOFCtrl();
		
		ArrayList<ICharacter> playerATeam = new ArrayList<>();
		ArrayList<ICharacter> playerBTeam = new ArrayList<>();
			
		playerATeam.add(CharacterList.getSira());
		playerATeam.add(CharacterList.getCheTT());
		playerATeam.add(CharacterList.getIori());

		playerBTeam.add(CharacterList.getKyo());
		playerBTeam.add(CharacterList.getMin());
		playerBTeam.add(CharacterList.getMoon());
						
		kofCtrl.ready(playerATeam, playerBTeam);
		kofCtrl.start();
	}
}