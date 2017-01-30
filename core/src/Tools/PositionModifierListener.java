package Tools;

public interface PositionModifierListener {

	public void positionModifierChange(int[] oldPosition, int[] newPosition, boolean topDown, int positiv, boolean gameWon);
}
