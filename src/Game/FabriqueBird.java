package Game;

import externals.AgentAction;
import externals.ColorAgent;

public class FabriqueBird extends FabriqueAgent{
	public FabriqueBird() {}

	@Override
	public Agent creerAgent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible,
			boolean isSick) {
		// TODO Auto-generated method stub
		return new AgentBird(x,y,agentAction,color,isInvincible,isSick);
	}

}
