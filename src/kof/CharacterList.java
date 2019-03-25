/*
 190320 캐릭터 10개으로 변경

 190320 필요없는 최대 대미지와 최소대미지 제거 
 190320 필살기와 초필살기 기입
 
 */
package kof;


public class CharacterList {
	
	public static Character getSira() {
		State state = new State("Sira", 50,50,50,
				CharacterSkill.siraSkill(1),CharacterSkill.siraSkill(2),
				CharacterSkill.siraSkill(3),CharacterSkill.siraSkill(4),CharacterSkill.siraSkill(5));					
		return new Character(state);
	}
	
	public static Character getCheTT() {
		State state = new State("CheTT", 80,40,30,
				CharacterSkill.CheTTSkill(1),CharacterSkill.CheTTSkill(2),
				CharacterSkill.CheTTSkill(3),CharacterSkill.CheTTSkill(4),CharacterSkill.CheTTSkill(5));	
		
		return new Character(state);
	}
	
	public static Character getMoon() {
		State state = new State("Moon",60,50,40,
				CharacterSkill.MoonSkill(1),CharacterSkill.MoonSkill(2),
				CharacterSkill.MoonSkill(3),CharacterSkill.MoonSkill(4),CharacterSkill.MoonSkill(5));
		return new Character(state);
	}
	
	public static Character getReona() {
		State state = new State("Reona",100,30,20,
				CharacterSkill.ReonaSkill(1),CharacterSkill.ReonaSkill(2),
				CharacterSkill.ReonaSkill(3),CharacterSkill.ReonaSkill(4),CharacterSkill.ReonaSkill(5));
		return new Character(state);
	}
	
	public static Character getKyo() {
		State state = new State("Kyo", 100,20,30,
				CharacterSkill.KyoSkill(1),CharacterSkill.KyoSkill(2),
				CharacterSkill.KyoSkill(3),CharacterSkill.KyoSkill(4),CharacterSkill.KyoSkill(5));
		return new Character(state);
	}
	
	public static Character getCan() {
		State state = new State("Can", 100,30,20,
				CharacterSkill.CanSkill(1),CharacterSkill.CanSkill(2),
				CharacterSkill.CanSkill(3),CharacterSkill.CanSkill(4),CharacterSkill.CanSkill(5));
		return new Character(state);
	}
	
	public static Character getSin() {
		State state = new State("Sin",20,30, 100,
				CharacterSkill.SinSkill(1),CharacterSkill.SinSkill(2),
				CharacterSkill.SinSkill(3),CharacterSkill.SinSkill(4),CharacterSkill.SinSkill(5));
		return new Character(state);
	}
	
	public static Character getIori() {
		State state = new State("Iori", 100, 20,30,
				CharacterSkill.IoriSkill(1),CharacterSkill.IoriSkill(2),
				CharacterSkill.IoriSkill(3),CharacterSkill.IoriSkill(4),CharacterSkill.IoriSkill(5));
		return new Character(state);
	}

	public static Character getMystery() {
		Double strRanDouble = Math.random();
		int strRan	= 1+(int)(strRanDouble*100);
		Double dexRanDouble = Math.random();
		int dexRan	= 1+(int)(dexRanDouble*100);
		Double hpRanDouble = Math.random();
		int hpRan	= 1+(int)(hpRanDouble*100);
		State state = new State("Mystery",strRan,dexRan,hpRan,
				CharacterSkill.MysterySkill(1),CharacterSkill.MysterySkill(2),
				CharacterSkill.MysterySkill(3),CharacterSkill.MysterySkill(4),CharacterSkill.MysterySkill(5));
		return new Character(state);
	}
	
	public static Character getMin() {
		State state = new State("Min",30,20, 100,
				CharacterSkill.MinSkill(1),CharacterSkill.MinSkill(2),
				CharacterSkill.MinSkill(3),CharacterSkill.MinSkill(4),CharacterSkill.MinSkill(5));
		return new Character(state);
	}
	
}
