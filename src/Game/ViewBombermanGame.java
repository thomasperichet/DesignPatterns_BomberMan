package Game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import externals.Map;
import externals.PanelBomberman;


@SuppressWarnings("serial")
public class ViewBombermanGame extends JFrame implements Observer  {

	private Game _game;
	private ControleurBombermanGame _cbg;
	private PanelBomberman _pb;
	
	public ViewBombermanGame(Game game, ControleurBombermanGame cbg, PanelBomberman pb) {
		_game=game;
		_cbg=cbg;
		_pb=pb;
		Map map = pb.getMap();
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Bomberman");
		jFrame.setSize(new Dimension(map.getSizeX()*50, map.getSizeY()*50));
		jFrame.add(_pb);
		
		
		jFrame.setVisible(true);
	}


	@Override
	public void update(Observable obs) {
		// TODO Auto-generated method stub
		
	}

}
