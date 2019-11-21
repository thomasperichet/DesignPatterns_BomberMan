package Game;

import externals.Map;
import externals.PanelBomberman;

public class ControleurBombermanGame implements InterfaceControleur {
	Game _game;
	ViewCommandBomberman _vc;
	ViewBombermanGame _vbg;
	Map _map;
	PanelBomberman _pb;
	
	public ControleurBombermanGame(Game game) throws Exception {
	
		_game=game;
		_vc = new ViewCommandBomberman(game, this);
		Map map1 = new Map("src/layouts/niveau1.lay");
		_pb = new PanelBomberman(map1);
		_vbg = new ViewBombermanGame(game,this,_pb);
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		_vc.get_jb_pause().setEnabled(false);
		_vc.get_jb_lancer().setEnabled(true);
		_vc.get_jb_pas().setEnabled(true);

		_game.stop();
	}

	@Override
	public void setTime(double time) {
		// TODO Auto-generated method stub
		
	}

}
