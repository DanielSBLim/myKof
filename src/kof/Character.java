/*
190320 Dex,Str 추가

*/


package kof;

import java.util.Random;

public class Character implements ICharacter {
	public static int INVALID = -999; 
	public State state;
	
	public Character(State state) {
		super();
		this.state = state;
	}

	private int getDamageCalc(int minDamage, int maxDamage) {
		if(minDamage > maxDamage) {
			Log.print("최소공격력이 최대공격력보다 높습니다.");
			return INVALID;
		}
		return minDamage + new Random().nextInt(maxDamage - minDamage);
	}

	@Override
	public int getAttackDamage() {
		return getDamageCalc(state.getMinDamage(), state.getMaxDamage());
	}
	@Override
	public int getCriRate() {
		return state.getCriRate();
	}
	@Override
	public int getCriDamage() {
		return state.getCriDamage();
		
	}
	
	
	

	@Override
	public String getCharacterName() {
		return state.getName();
	}

	@Override
	public int getHp() {
		return state.getHp();
	}

}
