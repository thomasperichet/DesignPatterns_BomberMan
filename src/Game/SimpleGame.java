package Game;

public class SimpleGame extends Game {

	
	public SimpleGame(int maxtour) {
		super(maxtour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		_chaine="La partie est initialisé";
		System.out.println(_chaine);
	}

	@Override
	public boolean gameContinue() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		_chaine="Game over";
		System.out.println(_chaine);
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		_chaine="Tour "+this._turn+" du jeu en cours";
		System.out.println(_chaine);
		
	}


	

}
