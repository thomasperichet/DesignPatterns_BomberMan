package Game;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ViewCommandBomberman extends JFrame implements ActionListener, Observer {
	private Game _game;
	private ControleurBombermanGame _csg;
	
	private JButton _jb_recommencer;
	private JButton _jb_lancer;
	private JButton _jb_pas;
	private JButton _jb_pause;
	private JSlider _js_tour;
	private JLabel  _jl_tour;
	
	public ViewCommandBomberman(Game game, ControleurBombermanGame csg) {
		_game = game;
		_csg = csg;
		_game.registerObserver(this);
		
		JFrame jFrame= new JFrame();
		jFrame.setTitle("Game");
		jFrame.setSize(new Dimension(800, 800));
		Dimension windowSize=jFrame.getSize();
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint=ge.getCenterPoint();
		int dx=centerPoint.x - windowSize.width/ 2 ;
		int dy=centerPoint.y - windowSize.height/ 2-350;
		jFrame.setLocation(dx,dy);
		
		JPanel panGen = new JPanel();
		panGen.setLayout(new GridLayout(2,1));
		
		JPanel panHaut= new JPanel();
		panHaut.setLayout(new GridLayout(1,4));
		
		JPanel panBas = new JPanel();
		panBas.setLayout(new GridLayout(1,2));
		
		JPanel panBasGauche = new JPanel();
		panBasGauche.setLayout(new GridLayout(2,1));
		
		// bouton et icone
		Icon icon_recommencer = new ImageIcon("src/Icones/icon_restart.png");
		 _jb_recommencer = new JButton(icon_recommencer);
		
		Icon icon_lancer = new ImageIcon("src/Icones/icon_run.png");
		 _jb_lancer = new JButton(icon_lancer);
		
		Icon icon_pas = new ImageIcon("src/Icones/icon_step.png");
		 _jb_pas = new JButton(icon_pas);
		
		Icon icon_pause= new ImageIcon("src/Icones/icon_pause.png");
		 _jb_pause = new JButton(icon_pause);
		
		// bas
		 _js_tour = new JSlider(JSlider.HORIZONTAL,1,10,1);

		_js_tour.setMinorTickSpacing(1);  
		_js_tour.setMajorTickSpacing(1);
		_js_tour.setPaintTicks(true);
		_js_tour.setPaintLabels(true);

		
		JLabel jl_slider = new JLabel("Number of turns Per Second",JLabel.CENTER);;
		_jl_tour = new JLabel("Tour : "+_game._turn,JLabel.CENTER);
		
		
		_jb_lancer.addActionListener(this);
		_jb_recommencer.addActionListener(this);
		_jb_pause.addActionListener(this);
		_jb_pas.addActionListener(this);
		_js_tour.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				int tour = _js_tour.getValue();
				_csg.setTime(1000/tour);
			}
			
			
			
		});
		

		
		panHaut.add(_jb_recommencer);
		panHaut.add(_jb_lancer);
		panHaut.add(_jb_pas);
		panHaut.add(_jb_pause);
		
		panBasGauche.add(jl_slider);
		panBasGauche.add(_js_tour);
		panBas.add(panBasGauche);
		panBas.add(_jl_tour);
		
		panGen.add(panHaut);
		panGen.add(panBas);
		jFrame.add(panGen);		
		
		jFrame.setVisible(true);

	}
	
	/**
	 * @return the _jb_recommencer
	 */
	public JButton get_jb_recommencer() {
		return _jb_recommencer;
	}




	/**
	 * @param _jb_recommencer the _jb_recommencer to set
	 */
	public void set_jb_recommencer(JButton _jb_recommencer) {
		this._jb_recommencer = _jb_recommencer;
	}




	/**
	 * @return the _jb_lancer
	 */
	public JButton get_jb_lancer() {
		return _jb_lancer;
	}




	/**
	 * @param _jb_lancer the _jb_lancer to set
	 */
	public void set_jb_lancer(JButton _jb_lancer) {
		this._jb_lancer = _jb_lancer;
	}




	/**
	 * @return the _jb_pas
	 */
	public JButton get_jb_pas() {
		return _jb_pas;
	}




	/**
	 * @param _jb_pas the _jb_pas to set
	 */
	public void set_jb_pas(JButton _jb_pas) {
		this._jb_pas = _jb_pas;
	}




	/**
	 * @return the _jb_pause
	 */
	public JButton get_jb_pause() {
		return _jb_pause;
	}




	/**
	 * @param _jb_pause the _jb_pause to set
	 */
	public void set_jb_pause(JButton _jb_pause) {
		this._jb_pause = _jb_pause;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == _jb_lancer) {
			_csg.run();
		}
		if(source==_jb_recommencer) {
			_csg.start();
		}
		if(source==_jb_pause) {
			_csg.stop();
		}
		if(source==_jb_pas) {
			_csg.step();
		}
		
		
	}



	@Override
	public void update(Observable obs) {
		// TODO Auto-generated method stub
		_jl_tour.setText("Tour : "+_game._turn);

	}


	
}
