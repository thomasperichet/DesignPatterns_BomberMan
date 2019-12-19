package Game;

import externals.Map;
import externals.PanelBomberman;

public class ControleurBombermanGame implements InterfaceControleur {
	BombermanGame _bgame;
	ViewCommandBomberman _vc;
	ViewBombermanGame _vbg;
	Map _map;
	PanelBomberman _pb;
	
	public ControleurBombermanGame(BombermanGame bgame) throws Exception {
	
		_bgame=bgame;
		_vc = new ViewCommandBomberman(bgame, this);
		Map map1 = _bgame.getMap();
		_pb = new PanelBomberman(map1);
		_vbg = new ViewBombermanGame(bgame,this,_pb,_vc);
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
		_bgame.init();

	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		_vc.get_jb_lancer().setEnabled(true);
		_vc.get_jb_pause().setEnabled(false);
		_bgame.step();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		_vc.get_jb_lancer().setEnabled(false);
		_vc.get_jb_pause().setEnabled(true);
		_vc.get_jb_pas().setEnabled(false);
		_bgame.launch();


	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		_vc.get_jb_pause().setEnabled(false);
		_vc.get_jb_lancer().setEnabled(true);
		_vc.get_jb_pas().setEnabled(true);
		_vc.get_jb_recommencer().setEnabled(true);

		_bgame.stop();
	}

	@Override
	public void setTime(double time) {
		// TODO Auto-generated method stub
		_bgame._time=(long) time;

	}

}
