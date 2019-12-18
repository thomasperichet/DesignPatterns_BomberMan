package Game;

import java.util.ArrayList;

import externals.AgentAction;
import externals.InfoAgent;
import externals.Map;

public class BombermanGame extends Game {
	Map _map;
	ArrayList<AgentBomberman> _listeAB;
	public BombermanGame(int maxtour, Map map) {
		super(maxtour);
		// TODO Auto-generated constructor stub
		_map=map;
		_listeAB = new ArrayList<AgentBomberman>();
	}

	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		FabriqueBomberman fb = new FabriqueBomberman();
		for (InfoAgent ia : _map.getStart_agents()) {
			if(ia.getType()=='B') {
				AgentBomberman ab = (AgentBomberman) fb.creerAgent(ia.getX(), ia.getY(), ia.getAgentAction(), 
						ia.getColor(), ia.isInvincible(), ia.isSick());
				_listeAB.add(ab);
				System.out.println(ia.getX()+" "+ia.getY());
			}
		}
	}

	@Override
	public boolean gameContinue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		for (InfoAgent ia : _map.getStart_agents()) {
			if(ia.getType()=='B') {
				ia.setX(ia.getX()+1);
				System.out.println(ia.getX()+" "+ia.getY());
			}
		
		}	
	}

}
