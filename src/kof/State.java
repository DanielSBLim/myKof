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
	private String skill1; 
	private String skill2; 
	private String skill3; 
	private String skill4; 
	private String LethalMax; 
	
	
	private int con;
	private int str;
	private int dex;


	
	public State(String name, int str, int dex, int con, 
				String skill1,String skill2,String skill3,
				String skill4,String LethalMax) {
		super();
		this.name 		= name;
		this.str 		= str;
		this.dex 		= dex;
		this.con 		= con;
		
		this.skill1 	= skill1;
		this.skill2 	= skill2;
		this.skill3 	= skill3;
		this.skill4 	= skill4;
		this.LethalMax 	= LethalMax;
		
	}


	public String getName() {
		return name;
	}
	
	public int getStr() {
		return str;
	}
	
	public int getDex() {
		return dex;
	}

	public int getCon() {
		return con;
	}
	
	public String getStateSkill1() {
		return skill1;
	}
	
	public String getStateSkill2() {
		return skill2;
	}
	
	public String getStateSkill3() {
		return skill3;
	}
	
	public String getStateSkill4() {
		return skill4;
	}
	
	public String getStateLethalMax() {
		return LethalMax;
	}
	

}