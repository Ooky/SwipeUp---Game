package Tools;

public final class LevelGenerator {

	private static int[][] arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];

	public static int[][] generateLevel(int level) {
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
		//SETUP
		if (level == 1) {
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][5] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][5] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[14][20] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][22] = 3;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][0] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[2][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][0] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][0] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][0] = 5;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[8][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][0] = 5;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][0] = 5;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][0] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][0] = 5;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][24] = 5;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][24] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[8][24] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][24] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][24] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][15] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][15] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][15] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][15] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][25] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][1] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][2] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][3] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][1] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][1] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][2] = 4;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][3] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][6] = 2;
		} else {

			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][25] = 3;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][23] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[2][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[14][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][25] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[14][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][24] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[8][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][22] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][20] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][20] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[2][20] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][20] = 1;
			arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][21] = 2;
		}
		return arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady;
	}
}
