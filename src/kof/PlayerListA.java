package kof;
import java.util.ArrayList;

public class PlayerListA {
	private static int PLAYER1 = 0;
	private static int PLAYER2 = 1;
	ArrayList<Player> playerA = new ArrayList<>();
	ArrayList<Player> playerB = new ArrayList<>();
	private Action action;
	
	
	public void setPlayerList1 (ICharacter character1,
								ICharacter character2,
								ICharacter character3) {

		playerA.add(new Player(PLAYER1, character1, action));
		playerA.add(new Player(PLAYER1, character2, action));
		playerA.add(new Player(PLAYER1, character3, action));
	}
		
	public void setPlayerList2 (ICharacter character1,
								ICharacter character2,
								ICharacter character3) {

		playerB.add(new Player(PLAYER2, character1, action));
		playerB.add(new Player(PLAYER2, character2, action));
		playerB.add(new Player(PLAYER2, character3, action));
	}

	public ArrayList<Player> getPlayerTeam1(){
		return playerA;	
	}
	
	public ArrayList<Player> getPlayerTeam2(){
		return playerB;
		
	}
}
