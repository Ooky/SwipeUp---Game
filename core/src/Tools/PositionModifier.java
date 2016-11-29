package Tools;

public class PositionModifier {

	int[][] returnArray;
	int playerY;
	int playerX;
	int xPos = 0;
	int yPos = 0;
	boolean gameWon = false;
	private PositionModifierListener listener;
	private int[] oldPosition = new int[2];
	private int[] newPosition = new int[2];
	
	public PositionModifier(int[][] arr) {
		returnArray = arr;
		//Get player Position;
		int y = 0;
		for (int[] iter : returnArray) {
			int x = 0;
			for (int xpos : iter) {
				if (xpos == 3) {
					playerY = x;
					playerX = y;
				}
				x++;
			}
			y++;
		}
	}

	public void movePlayerUp() {
		modifier(playerY, true, 1);
	}

	public void movePlayerDown() {
		modifier(playerY, true, -1);
	}
	
	public void movePlayerRight(){
		modifier(playerX, false, 1);
	}
	
	public void movePlayerLeft(){
		modifier(playerX, false, -1);
	}
	
	private void modifier(int startpos, boolean topDown, int iterateModifier){
		boolean collided = false;
		oldPosition[0] = playerX;
		oldPosition[1] = playerY;
		
		returnArray[playerX][playerY] = 0;
		for (int i = startpos; (iterateModifier>0)?(i < (topDown?26:16)):(i >= 0); i+=iterateModifier) {
			if (!collided) {
				switch (topDown?returnArray[playerX][i]:returnArray[i][playerY]) {
					case 1:
						collided = true;
						break;
					case 2:
						collided = true;
						gameWon = true;
						if(topDown){
							playerY=i;
						}else{
							playerX=i;
						}
						break;
					default:
						if(topDown){
							playerY=i;
						}else{
							playerX=i;
						}
						break;
				}
			}
		}		
		newPosition[0] = playerX;
		newPosition[1] = playerY;
		listener.positionModifierChange(oldPosition, newPosition, topDown, iterateModifier);
	}
	
	public void setListener(PositionModifierListener pl){
		listener = pl;
	}
	public boolean getGameWon(){
		return gameWon;
	}
}
