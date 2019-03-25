/*
190320 1:1에서 3:3 으로 번경 
 우왕 깃이다
 */
package kof;

import java.util.ArrayList;
import java.util.Random;

public class KOFCtrl {

	private static int PLAYER1 = 0;
	private static int PLAYER2 = 1;
	public int i,j = 0;

	private int turn = 0;
	private boolean isPlaying = false;
	
	private ArrayList<Player> player1 = new ArrayList<>();
	private ArrayList<Player> player2 = new ArrayList<>();
	
	public void ready(	ICharacter character1,
						ICharacter character2,
						ICharacter character3,
						ICharacter character4,
						ICharacter character5,
						ICharacter character6) {
		
		player1.add(new Player(PLAYER1, character1, action));
		player1.add(new Player(PLAYER1, character3, action));
		player1.add(new Player(PLAYER1, character5, action));		
		player2.add(new Player(PLAYER2, character2, action));
		player2.add(new Player(PLAYER2, character4, action));
		player2.add(new Player(PLAYER2, character6, action));
	}

	public void start() {
		if (player1 == null || player2 == null) {
			Log.warning("캐릭터가 준비되지 않았습니다.");
			return;
		}
		turn = 0;
		isPlaying = true;

		if (fitstAttack() == PLAYER1) {
			attack(player1.get(i), player2.get(j));
		} else {
			attack(player2.get(j), player1.get(i));
		}
	}

	private int fitstAttack() {
		return new Random().nextInt(1);
	}

	private void attack(Player attacker, Player defencer) {
		Log.println("---------" + ++turn + "turn-----------");
		defencer.attack(attacker);
	}

	private void result(String winner, String defeater) {
		Log.println(winner + "가 승리했습니다.");
		Log.println(defeater + "가 패배했습니다.");
	}

	private boolean checkPlaying() {
		if (!isPlaying) {
			Log.warning("경기가 중단되었습니다.");
		}
		return isPlaying;
	}
	
	private void stop() {
		isPlaying = false;
		checkPlaying();
	}
	
	private Player.Action action = new Player.Action() {

		@Override
		public void counterattack(int tag) {
			if (!checkPlaying()) {
				return;
			}

			if (tag == PLAYER1) {
				attack(player1.get(i), player2.get(j));
			} else if (tag == PLAYER2) {
				attack(player2.get(j), player1.get(i));
			}
		}

		@Override
		public void die(int tag) {
			if (!checkPlaying()) {
				return;
			}

			if (tag == PLAYER1) {
				result(player2.get(j).getName(), player1.get(i).getName());
				if(i<2) {
					i++;
					counterattack(tag);
					
				}
			} else if (tag == PLAYER2) {
				result(player1.get(i).getName(), player2.get(j).getName());
				if(j<2) {
					j++;
					counterattack(tag);
					}
				
			}
		}

		@Override
		public void stop() {
			KOFCtrl.this.stop();
		}
	};
}
