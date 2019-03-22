/*
190320 dex와 Str 추가
190320 스텟에 따른 행동설정
190320 dex와 Str 전역 변수에 필요 없음
190320 Creative의 min, max제거
190320 필살기와 초필살기 불러오기


*/

package kof;

public class State {
	private String name;
	private int hp;
	private int minDamage;
	private int maxDamage;
	private int criRate;
	private int criDamage;
	private int energy;

	public State(String name, int str, int dex, int hp, String skill1, String skill2, String skill3, String skill4,
			String LethalMax) {
		super();
		this.name = name;
		this.hp = hp * 100;
		this.criRate = (10 + (int) (dex * 0.5));
		this.criDamage = (int) (100 + dex);
		this.minDamage = (int) ((str * 10) - ((str * 10) * 0.1));
		this.maxDamage = (int) ((str * 10) + ((str * 10) * 0.1));
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getCriRate() {
		return criRate;
	}

	public int getCriDamage() {
		return criDamage;
	}

}