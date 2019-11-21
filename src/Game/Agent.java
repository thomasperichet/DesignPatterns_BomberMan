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
public abstract class Agent {
	private int x;
	private int y;
	private AgentAction agentAction;
	private ColorAgent color;
	
	private boolean isInvincible;
	private boolean isSick;
	
	public Agent(int x, int y, AgentAction agentAction, ColorAgent color, boolean isInvincible, boolean isSick) {
		this.x=x;
		this.y=y;
		this.agentAction = agentAction;
		this.color = color;
		
		this.isInvincible = isInvincible;
		this.isSick = isSick;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the agentAction
	 */
	public AgentAction getAgentAction() {
		return agentAction;
	}

	/**
	 * @param agentAction the agentAction to set
	 */
	public void setAgentAction(AgentAction agentAction) {
		this.agentAction = agentAction;
	}

	/**
	 * @return the color
	 */
	public ColorAgent getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(ColorAgent color) {
		this.color = color;
	}

	/**
	 * @return the isInvincible
	 */
	public boolean isInvincible() {
		return isInvincible;
	}

	/**
	 * @param isInvincible the isInvincible to set
	 */
	public void setInvincible(boolean isInvincible) {
		this.isInvincible = isInvincible;
	}

	/**
	 * @return the isSick
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * @param isSick the isSick to set
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
}
