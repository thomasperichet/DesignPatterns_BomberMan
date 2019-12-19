package Game;

import externals.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ViewCommand vc = new ViewCommand();

		//SimpleGame sg1 = new SimpleGame(50);
		@SuppressWarnings("unused")
		Map map1;
		try {
			map1 = new Map("src/layouts/niveau2.lay");
			BombermanGame bg = new BombermanGame(1000,map1);
			try {
				ControleurBombermanGame cbg = new ControleurBombermanGame(bg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		/*
		SimpleGame sg1 = new SimpleGame(50);
		ControleurSimpleGame csg = new ControleurSimpleGame(sg1);
		*/
		
		/*
		sg1.init();
		sg1.run();
		sg1.step();
		*/
		
	}

}
