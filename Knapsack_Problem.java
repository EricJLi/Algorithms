import java.util.Scanner;

public class Knapsack_Problem {
	
	/*
	 * 		Solution to the classic 0/1 knapsack problem
	 */
	
	public static int itemCount;
	public static int maxWeight;
	
	public static int[] weight;
	public static int[] value;
	
	public static int[][] f;
	
	public static int max(int a, int b){
		if (a > b) return a;
		return b;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		itemCount = scan.nextInt();
		maxWeight = scan.nextInt();
		
		weight = new int[itemCount];
		value = new int[itemCount];
		
		f = new int[maxWeight][itemCount];
		
		for (int i=0; i<itemCount; i++){
			weight[i] = scan.nextInt();
			value[i] = scan.nextInt();
		}
		
		scan.close();
		
		for (int i=0; i<itemCount; i++){
			for (int j=0; j<maxWeight; j++){
				if (weight[i] > j){
					if (i == 0){
						f[j][i] = 0;
					} else {
						f[j][i] = f[j][i - 1];
					}
				} else {
					if (i == 0){
						f[j][i] = value[i];
					} else {
						f[j][i] = max(f[j][i - 1], f[j - weight[i]][i - 1] + value[i]);
					}
				}
			}
		}
		
		
		
		System.out.println(f[maxWeight - 1][itemCount - 1]);
	}
}