/*
190320 케릭터 6명 참여 설정
깃이되나?
*/
package kof;

public class Main {

	public static void main(String[] args) {
		KOFCtrl kofCtrl = new KOFCtrl();
		// 6명게임 으로 첫 A팀의 3명과 B의 후 3팀으로 나눈다.

		kofCtrl.ready(CharacterList.getCan(), CharacterList.getCheTT(), CharacterList.getIori(), CharacterList.getKyo(),
				CharacterList.getMin(), CharacterList.getMoon());
		kofCtrl.start();
	}
}
