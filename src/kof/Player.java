package kof;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	private Action action;
	private ICharacter character;

	private int hp, maxHp;
	private int playerTag;
	private int skillRate;
	private int energy = 50;

	private String name;

	ArrayList<ICharacter> characterlist;

	public Player(int playerTag, ArrayList<ICharacter> characterlist, Action action) {
		super();
		this.playerTag = playerTag;
		this.characterlist = characterlist;
		this.action = action;
		nextCharater();
	}

	public void attack(final Player attacker) {
		int damage;
		String skillName = "";
		// 초필살기인가? 아닌가?
		if (attacker.energy >= 100) {
			Log.println(attacker.getLethalMax());
			skillName = "@@@@초필살기시전@@@@ " + attacker.getLethalMax();
			attacker.energy = 0;
			damage = (int) (attacker.getAttackDamage() * 2.8);
		} else {
			// 평타인가 기술인가
			if (70 > new Random().nextInt(100)) {
				energyCharge(attacker, 0);

				// 크리인가 아닌가?
				if (attacker.getCriAttackRate() > new Random().nextInt(100)) {
					damage = (int) (attacker.getCriAttacDamage() * 0.01) * attacker.getAttackDamage();
					Log.println("크리발생");
				} else {
					damage = attacker.getAttackDamage();
				}

			} else {

				// 스킬 활률
				skillRate = new Random().nextInt(100);

				// 기술 1 인가 기술 2 인가 기술 3인가
				// 기술 1 발동 조건
				if (50 > skillRate) {
					energyCharge(attacker, 1);
					skillName = attacker.getSkill1();
					damage = (int) (attacker.getAttackDamage() * 1.2);

					// 기술 2 발동
				} else if (80 > skillRate) {
					energyCharge(attacker, 2);
					skillName = attacker.getSkill2();
					damage = (int) (attacker.getAttackDamage() * 1.4);

					// 기술 3 발동
				} else {
					energyCharge(attacker, 3);
					skillName = attacker.getSkill3();
					damage = (int) (attacker.getAttackDamage() * 1.6);

				}
			}

		}

		if (damage == Character.INVALID) {
			action.stop();
			return;
		}
		Log.println(attacker.name + " 가 "+ (skillName.isEmpty() ? "" : skillName + " 으로 ")  + damage + " 으로 공격하였습니다.");

		if (isBlocking()) {
			Log.println(name + "가 공격을 막았습니다.");
		} else {

			if (damage > 0) {
				hp -= damage;
			}
			Log.println(name + " 의 hp가  " + hp + " 가 되었습니다.");
		}
		
		action.printHp(this, attacker);

		if (hp < 0) {

			if (characterlist.isEmpty()) {
				action.die(playerTag);

			} else {
				action.die(playerTag);
				
				//nextCharacter
				nextCharater();
				action.counterattack(playerTag);
			}

		} else {
			action.counterattack(playerTag);
		}
	}


	private void nextCharater() {
		this.character = characterlist.remove(0);
		this.hp = character.getHp();
		this.maxHp = hp;
		this.name = character.getCharacterName();
		
	}

	private void energyCharge(Player attack, int selct) {
			if (selct == 0) {
				energy += 5;
			}

			if (selct == 1) {
				energy += 10;
			}

			if (selct == 2) {
				energy += 15;
			}

			if (selct == 3) {
				energy += 20;
			}

	}

	public int getTag() {
		return playerTag;
	}

	public int getHpp() {
		return (int)((float)hp / (float)maxHp * (float)100);
	}
	
	public String getName() {
		return name;
	}

	public int getCharacterCount() {
		return characterlist.size() + 1;
	}
	
	public String getSkill1() {
		return character.getSkill1();
	}

	public String getSkill2() {
		return character.getSkill2();
	}

	public String getSkill3() {
		return character.getSkill3();
	}

	public String getLethalMax() {
		return character.getLethalMax();
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
		
		void printHp(Player attacker, Player diffender);
	}
}
