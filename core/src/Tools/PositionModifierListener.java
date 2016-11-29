/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author mike
 */
public interface PositionModifierListener {
	public void positionModifierChange(int[] oldPosition, int[] newPosition, boolean topDown, int positiv);
}
