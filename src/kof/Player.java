package kof;

import java.util.ArrayList;
import java.util.Random;


public class Player {

	private Action action;
	private ICharacter character;

	private int hp;
	private int playerTag;
	private int skillRate =	new Random().nextInt(100);	
	private int energyA	= 0;
	private int energyB = 0;

	
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

		//초필살기인가? 아닌가?
		damage = EnergyMaxLethalMax(attacker);
		
		//평타인가 기술인가 
		if(70 > new Random().nextInt(100)) {
		energyCharge(attacker, 0);
			
		//크리인가 아닌가?
		if(attacker.getCriAttackRate() < new Random().nextInt(100)) {
			damage = attacker.getCriAttacDamage();
			Log.println("크리발생");
		} else {
			damage = attacker.getAttackDamage();
		}
		
		} else {
			
			// 기술 1 인가 기술 2 인가 기술 3인가
			// 기술 1 발동 조건
			if(50 > skillRate) {
				energyCharge(attacker, 1);
				Log.println(attacker.getSkill1());
				damage = (int)(attacker.getAttackDamage()*1.2) ;
				
			// 기술 2 발동	
			}else if(30> skillRate){
				energyCharge(attacker, 2);
				Log.println(attacker.getSkill2());
				damage = (int)(attacker.getAttackDamage()*1.4) ;
				
			// 기술 3 발동
			}else {
				energyCharge(attacker, 3);		
				Log.println(attacker.getSkill3());
				damage = (int)(attacker.getAttackDamage()*1.6) ;
				
			}
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
	
	public void energyCharge(Player attack, int selct) {
		if(attack.playerTag == 0 ) {
		
			if (selct == 0){
				energyA+= 5;		
			}
		
			if (selct == 1){
				energyA+= 10;		
			}
		
			if (selct == 2){
				energyA+= 15;		
			}
		
			if (selct == 3){
				energyA+= 20;		
			}
			
		}else {
			
			if (selct == 0){
				energyB+= 5;		
			}
		
			if (selct == 1){
				energyB+= 10;		
			}
		
			if (selct == 2){
				energyB+= 15;		
			}
		
			if (selct == 3){
				energyB+= 20;		
			}
		}
		
		
	}
	

	public String getName() {
		return name;
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
	
	private int EnergyMaxLethalMax(Player attack) {
		
		if(attack.playerTag == 0 && energyA == 100) {
			Log.println(attack.getLethalMax());
			energyA = 0;
			return (int)(attack.getCriAttacDamage()*250);
		}else if(attack.playerTag == 1 && energyB == 100) {
			Log.println(attack.getLethalMax());
			energyB = 0;
			return (int)(attack.getCriAttacDamage()*250);
		}
		return 0;
		
	
	}

	public interface Action {
		void counterattack(int tag);

		void die(int tag);

		void stop();
	}
}
