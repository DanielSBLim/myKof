package kof;


import java.util.Random;

public class Player extends PlayerListA{
	
	private Action action;
	private ICharacter character;
	
	private int hp;
	private int playerTag;
	
	private String name;
	
	public Player(int playerTag, ICharacter character, Action action) {
		super();
		this.playerTag = playerTag;
		this.character = character;
		this.hp = character.getHp();
		this.name = character.getCharacterName();
		this.action = action;
	}
	

	public void attack(Player attacker) {
		int damage;
		
		if(attacker.getCriAttackRate() < new Random().nextInt(100)) {
			damage = attacker.getCriAttacDamage();
			Log.println("크리발생");
		}else {
			damage = attacker.getAttackDamage();
		}
		
		if (damage == Character.INVALID) {
			action.stop();
			return;
		}
		Log.println(attacker.name + " 가 " + damage + " 으로 공격하였습니다.");
		
		if (isBlocking()) {
			Log.println(name + "가 공격을 막았습니다.");
		}else{
			
				if (damage > 0) {
				hp -= damage;
			}
			Log.println(name + " 의 hp가  " + hp + " 가 되었습니다.");
		}

		if (hp < 0) {
			action.die(playerTag);
		}else{
			System.out.println("오류 시작");
			action.counterattack(playerTag);
		}
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
	


	

}
