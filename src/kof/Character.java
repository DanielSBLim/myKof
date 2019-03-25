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
	
	private int maxDamage(int str) {
		return (int)((str*10)+((str*10)*0.1));
	}
	
	private int minDamage(int str) {
		return (int)((str*10)-((str*10)*0.1));
	}
	
	private int criRate(int dex) {
		return (10 +(int)(dex *0.5));
	}
	
	private int CriDamage(int dex) {
		return (int)(100 + dex);
	}
	
	private int hp(int con) {
		return con*100;
	}
	
	@Override
	public int getAttackDamage() {
		return getDamageCalc(minDamage(state.getStr()),maxDamage(state.getStr()));
	}
	
	@Override
	public int getCriRate() {
		return criRate(state.getDex());
	}

	@Override
	public int getCriDamage() {
		return CriDamage(state.getDex());
		
	}
	
	@Override
	public int getHp() {
		return hp(state.getCon());
	}
	

	@Override
	public String getCharacterName() {
		return state.getName();
	}
}
