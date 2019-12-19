package Game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import externals.InfoAgent;
import externals.InfoBomb;
import externals.InfoItem;
import externals.Map;
import externals.PanelBomberman;


@SuppressWarnings("serial")
public class ViewBombermanGame extends JFrame implements Observer  {

	private BombermanGame _bgame;
	private ControleurBombermanGame _cbg;
	private PanelBomberman _pb;
	 
	public ViewBombermanGame(BombermanGame bgame, ControleurBombermanGame cbg, PanelBomberman pb) {
		_bgame=bgame;
		_cbg=cbg;
		_pb=pb;
		_bgame.registerObserver(this);
		Map map = _pb.getMap();
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Bomberman");
		jFrame.setSize(new Dimension(map.getSizeX()*50, map.getSizeY()*50));

		jFrame.add(_pb);

		jFrame.setVisible(true);
	}


	@Override
	public void update(Observable obs) {
		// TODO Auto-generated method stub
		
		ArrayList<InfoAgent> listeIA = new ArrayList<InfoAgent>();
		for (Agent a : _bgame.getListeAgent()) {
			if(a instanceof AgentBomberman) {
				listeIA.add(_bgame.agentBtoInfoA((AgentBomberman) a));
			}
			else if(a instanceof AgentRajion) {
				listeIA.add(_bgame.agentRtoInfoA((AgentRajion) a));

			}
			else if(a instanceof AgentBird) {
				listeIA.add(_bgame.agentBitoInfoA((AgentBird) a));

			}
			else if(a instanceof AgentEnnemi) {
				listeIA.add(_bgame.agentEtoInfoA((AgentEnnemi) a));

			}

		}
		ArrayList<InfoItem> listeII = new ArrayList<InfoItem>();
		ArrayList<InfoBomb> listeIB = _bgame.getListeBombe();
		for (InfoAgent infoAgent : listeIA) {
			System.out.println(infoAgent.getType()+" "+infoAgent.getX()+" "+infoAgent.getY());
		}
		System.out.println("_____________________________");
		

		_pb.setInfoGame(_pb.getMap().getStart_brokable_walls(), listeIA, listeII, listeIB);
		_pb.repaint();

		
		
	}

}
