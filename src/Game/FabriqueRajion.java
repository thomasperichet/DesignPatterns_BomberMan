package Game;

import externals.AgentAction;
import externals.ColorAgent;

public class FabriqueRajion extends FabriqueAgent {
	public FabriqueRajion() {}
	@Override
	public Agent creerAgent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible,
			boolean isSick) {
		return new AgentRajion(x,y,agentAction,color,isInvincible,isSick);
	}

}
