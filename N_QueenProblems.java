import java.util.List;
import java.util.ArrayList;

public class N_QueenProblems {
	private static final boolean SUCCESS = true;
	private static final boolean FAILURE = false;
	private static final boolean FREE = true;
	private static final boolean NOT_FREE = false;
	private static final int N = 8;
	private static int[] pos = new int[8];
	private static boolean[] col = new boolean[8];
	private static boolean[] upwd = new boolean[15];
	private static boolean[] downwd = new boolean[15];
	public static boolean search(int i) {
		for (int k = 0; k < N; k++) {
			System.out.println(i);
			if (col[k] == FREE && upwd[i+k] == FREE && downwd[7+i-k] == FREE) {
				//クイーンを配置する
				pos[i] = k;
				System.out.println("pos=" + pos[i]);
				col[k] = NOT_FREE;
				upwd[i+k] = NOT_FREE;
				downwd[7+i-k] = NOT_FREE;
				if (i == 7) {
					return SUCCESS;
				} else {
					if (search(i+1)) {
						return SUCCESS;
					} else {
						// クイーンを取り除く
						pos[i] = 0;
						col[k] = FREE;
						upwd[i+k-1] = FREE;
						downwd[7+i-k] = FREE;
					}
				}
			}
		}

		//クイーンが配置できる列が見つからなかった
		return FAILURE;
	}
	public static void main(String[] args) {
		for (int i = 0;i < 8; i++) {
			pos[i] = 0;
		}
		for (int i = 0;i < 8;i++) {
			col[i] = FREE;
			upwd[i] = FREE;
			downwd[i] = FREE;
		}
		if ( search(0) == SUCCESS) {
			System.out.println("成功");
		}
	}
}