package Game;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ViewCommand vc = new ViewCommand();

		//SimpleGame sg1 = new SimpleGame(50);
		@SuppressWarnings("unused")
		//ControleurSimpleGame csg = new ControleurSimpleGame(sg1);
		

		BombermanGame bg = new BombermanGame(50);
		
		try {
			ControleurBombermanGame cbg = new ControleurBombermanGame(bg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		sg1.init();
		sg1.run();
		sg1.step();
		*/
		
	}

}
