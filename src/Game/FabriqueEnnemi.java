package Game;

import externals.AgentAction;
import externals.ColorAgent;

public class FabriqueEnnemi extends FabriqueAgent {
	public FabriqueEnnemi() {}
	@Override
	public Agent creerAgent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible,
			boolean isSick) {
		// TODO Auto-generated method stub
		return new AgentEnnemi(x,y,agentAction,color,isInvincible,isSick);
	}

}
