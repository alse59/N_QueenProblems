public class N_QueenProblems {
	//Nの数を指定する
	private static final int N = 8;

	private static final boolean SUCCESS = true;
	private static final boolean FAILURE = false;
	private static final boolean FREE = true;
	private static final boolean NOT_FREE = false;
	private static int[] pos = new int[N];
	private static boolean[] col = new boolean[N];
	private static boolean[] upwd = new boolean[2*N-1];
	private static boolean[] downwd = new boolean[2*N-1];

	//検索メソッド
	public static boolean search(int i) {
		for (int k = 0; k < N; k++) {
			if (col[k] == FREE && upwd[i+k] == FREE && downwd[N-1+i-k] == FREE) {
				//クイーンを配置する
				pos[i] = k;
				col[k] = NOT_FREE;
				upwd[i+k] = NOT_FREE;
				downwd[N-1+i-k] = NOT_FREE;
				if (i == N-1) {
					return SUCCESS;
				} else {
					if (search(i+1)) {
						return SUCCESS;
					} else {
						// クイーンを取り除く
						pos[i] = 0;
						col[k] = FREE;
						upwd[i+k] = FREE;
						downwd[7+i-k] = FREE;
					}
				}
			}
		}
		//クイーンが配置できる列が見つからなかった
		return FAILURE;
	}

	//メインメソッド
	public static void main(String[] args) {
		for (int i = 0;i < N; i++) {
			pos[i] = 0;
		}
		for (int i = 0;i < N;i++) {
			col[i] = FREE;
		}
		for (int i = 0;i < 2*N-1;i++) {
			upwd[i] = FREE;
			downwd[i] = FREE;
		}
		if ( search(0) == SUCCESS) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}
	}
}