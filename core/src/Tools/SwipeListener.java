package Tools;

public interface SwipeListener {
	public static enum direction{UP,DOWN,LEFT,RIGHT}
	public void swipeDetected(SwipeListener.direction direction);
}
