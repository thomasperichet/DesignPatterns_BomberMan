package externals;

import Game.AgentBomberman;

public class InfoBomb {
	
	private int x;
	private int y;
	private int range;
	private AgentBomberman ab;
	StateBomb stateBomb;

	public InfoBomb(int x, int y, int range, StateBomb stateBomb, AgentBomberman ab) {
		this.x=x;
		this.y=y;
		this.range=range;
		this.stateBomb = stateBomb;
		this.ab=ab;
	}


	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public StateBomb getStateBomb() {
		return stateBomb;
	}



	public void setStateBomb(StateBomb stateBomb) {
		this.stateBomb = stateBomb;
	}



	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}

	public void nextState() {
		System.out.println("Next state");
		switch (this.stateBomb) {
		case Step1:
			this.stateBomb=StateBomb.Step2;
			break;
		case Step2:
			this.stateBomb=StateBomb.Step3;
			break;
		default:
			this.stateBomb=StateBomb.Boom;
			break;
		}
	}
	public AgentBomberman getAgentBomberman() {return ab;}
	
}
	