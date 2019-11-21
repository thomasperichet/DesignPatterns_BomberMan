package Game;

import externals.Map;
import externals.PanelBomberman;

public class ControleurBombermanGame implements InterfaceControleur {
	Game _game;
	//ViewCommand _vc;
	ViewBombermanGame _vbg;
	Map _map;
	PanelBomberman _pb;
	
	public ControleurBombermanGame(Game game) throws Exception {
	
		_game=game;
		//_vc = new ViewCommand(game, this);
		Map map1 = new Map("src/layouts/niveau1.lay");
		_pb = new PanelBomberman(map1);
		_vbg = new ViewBombermanGame(game,this,_pb);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(double time) {
		// TODO Auto-generated method stub
		
	}

}
