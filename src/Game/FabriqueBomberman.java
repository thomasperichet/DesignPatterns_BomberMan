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
public class FabriqueBomberman extends FabriqueAgent {

	public FabriqueBomberman() {}
	@Override
	public Agent creerAgent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible,boolean isSick) {
		// TODO Auto-generated method stub
		return new AgentBomberman(x,y,agentAction,color,isInvincible,isSick);
	}

}
