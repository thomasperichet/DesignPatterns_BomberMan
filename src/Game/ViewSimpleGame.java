package Game;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ViewSimpleGame extends JFrame implements Observer {
	private Game _game;
	private JTextArea _tour;
	private ControleurSimpleGame _csg;
	
	public ViewSimpleGame(Game game, ControleurSimpleGame csg) {
		_game = game;
		_csg = csg;
		_game.registerObserver(this);
		JFrame jFrame= new JFrame();
		jFrame.setTitle("Game");
		jFrame.setSize(new Dimension(800, 800));
		_tour = new JTextArea("Debut \n");
		_tour.setEditable(false);
		jFrame.add(_tour);
		Dimension windowSize=jFrame.getSize();
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint=ge.getCenterPoint();
		int dx=centerPoint.x - windowSize.width/ 2 ;
		int dy=centerPoint.y - windowSize.height/ 2-350;
		jFrame.setLocation(dx,dy);
		jFrame.setVisible(true);
		
		
	}

	@Override
	public void update(Observable obs) {
		_tour.append(_game._chaine+"\n");
	}
}
