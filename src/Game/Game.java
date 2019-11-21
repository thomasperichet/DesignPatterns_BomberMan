package Game;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Runnable, Observable{
	protected int _turn;
	protected int _maxtour;
	protected boolean _isrunning;
	protected Thread _thread;
	protected long _time;
	protected String _chaine;
	protected List<Observer> _observers = new ArrayList<>();
	
	public Game(int maxtour) {
		_maxtour=maxtour;
	}
	public void init() {
		_turn=0;
		_isrunning=true;
		_time=1000;
		initializeGame();
		notifyObserver();

	}
	public void step() {
		_turn++;
		if(gameContinue()==false || _turn>=_maxtour) {
			gameOver();
			_isrunning=false;
		}
		else {
			takeTurn();
		}
		notifyObserver();

	}
	public void run() {
		while(_isrunning==true) {
			step();
			try {
				Thread.sleep(_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyObserver();

	}
	public void stop() {
		_isrunning=false;
		notifyObserver();

	}
	public void launch() {
		_isrunning=true;
		_thread = new Thread(this);
		_thread.start();
		notifyObserver();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		_observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		_observers.remove(observer);

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _observers.size(); i++) {
			_observers.get(i).update(this);
		}
	}
	
	// méthodes abstraites
	public abstract void initializeGame();
	public abstract boolean gameContinue();
	public abstract void gameOver();
	public abstract void takeTurn();
}
