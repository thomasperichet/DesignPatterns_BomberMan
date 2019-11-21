/**
 * 
 */
package Game;

import externals.AgentAction;
import externals.ColorAgent;

/**
 * @author etudiant
 *
 */
public abstract class FabriqueAgent {

	public FabriqueAgent() {}
	public abstract Agent creerAgent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible,
			boolean isSick);
}
