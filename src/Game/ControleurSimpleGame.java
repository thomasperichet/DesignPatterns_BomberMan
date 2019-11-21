package Game;
public class ControleurSimpleGame implements InterfaceControleur {
	Game _game;
	ViewCommand _vc;
	ViewSimpleGame _vsg;
	
	public ControleurSimpleGame(Game game) {
		
		_game=game;
		_vc = new ViewCommand(game,this);
		_vsg = new ViewSimpleGame(game,this);
		_vc.get_jb_pas().setEnabled(false);
		_vc.get_jb_recommencer().setEnabled(true);
		_vc.get_jb_pause().setEnabled(false);
		_vc.get_jb_lancer().setEnabled(false);

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		_vc.get_jb_pas().setEnabled(true);
		_vc.get_jb_recommencer().setEnabled(false);
		_vc.get_jb_pause().setEnabled(true);
		_vc.get_jb_lancer().setEnabled(true);
		_game.init();


	}

	@Override
	public void step() {
		_vc.get_jb_lancer().setEnabled(true);
		_vc.get_jb_pause().setEnabled(false);
		_game.step();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		_vc.get_jb_lancer().setEnabled(false);
		_vc.get_jb_pause().setEnabled(true);
		_vc.get_jb_pas().setEnabled(false);
		_game.launch();
		
	}

	@Override
	public void stop() {
		_vc.get_jb_pause().setEnabled(false);
		_vc.get_jb_lancer().setEnabled(true);
		_vc.get_jb_pas().setEnabled(true);

		_game.stop();
		
	}

	@Override
	public void setTime(double time) {
		_game._time=(long) time;
	}

}
