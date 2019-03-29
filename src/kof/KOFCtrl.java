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

	private int turn = 0;

	private boolean isPlaying = false;

	private Player player1, player2;

	public void ready(ArrayList<ICharacter> playerA, ArrayList<ICharacter> playerB) {
		player1 = new Player(PLAYER1, playerA, action);
		player2 = new Player(PLAYER2, playerB, action);

	}

	public void start() {
		if (player1 == null || player2 == null) {
			Log.warning("캐릭터가 준비되지 않았습니다.");
			return;
		}
		turn = 0;
		isPlaying = true;

		if (fitstAttack() == PLAYER1) {
			attack(player1, player2);
		} else {
			attack(player2, player1);
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

	public Player.Action action = new Player.Action() {

		@Override
		public void counterattack(int tag) {
			if (!checkPlaying()) {
				return;
			}

			if (tag == PLAYER1) {
				attack(player1, player2);
			} else if (tag == PLAYER2) {
				attack(player2, player1);
			}
		}

		@Override
		public void die(int tag) {

			if (!checkPlaying()) {
				return;
			}

			if (tag == PLAYER1) {
				result(player2.getName(), player1.getName());

			} else if (tag == PLAYER2) {
				result(player1.getName(), player2.getName());
			}
		}

		@Override
		public void stop() {
			KOFCtrl.this.stop();
		}
	};

}
