package kof;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	private Action action;
	private ICharacter character;

	private int hp;
	private int playerTag;

	private String name;

	ArrayList<ICharacter> characterlist;

	public Player(int playerTag,  ArrayList<ICharacter> characterlist,  Action action) {
		super();
		this.playerTag = playerTag;
		this.characterlist = characterlist;
		this.character = characterlist.remove(0);
		this.hp = character.getHp();
		this.name = character.getCharacterName();
		this.action = action;
	}

	public void attack(final Player attacker) {
		int damage;

		if (attacker.getCriAttackRate() < new Random().nextInt(100)) {
			damage = attacker.getCriAttacDamage();
			Log.println("크리발생");
		} else {
			damage = attacker.getAttackDamage();
		}

		if (damage == Character.INVALID) {
			action.stop();
			return;
		}
		Log.println(attacker.name + " 가 " + damage + " 으로 공격하였습니다.");

		if (isBlocking()) {
			Log.println(name + "가 공격을 막았습니다.");
		} else {

			if (damage > 0) {
				hp -= damage;
			}
			Log.println(name + " 의 hp가  " + hp + " 가 되었습니다.");
		}

		if (hp < 0) {
			
			if(characterlist.size() == 0) {
				action.die(playerTag);
			} else {
				teamChange();
				action.counterattack(playerTag);
			}
				
		} else {
			action.counterattack(playerTag);
		}
	}
	
	public void teamChange () {
			this.character = characterlist.remove(0);
			this.hp = character.getHp();
			this.name = character.getCharacterName();
	}

	public String getName() {
		return name;
	}

	private int getAttackDamage() {
		return character.getAttackDamage();
	}

	private int getCriAttackRate() {
		return character.getCriRate();
	}

	private int getCriAttacDamage() {
		return character.getCriDamage();
	}

	private boolean isBlocking() {
		return new Random().nextBoolean();
	}

	public interface Action {
		void counterattack(int tag);

		void die(int tag);

		void stop();
	}
}
