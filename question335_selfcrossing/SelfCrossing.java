package zhang.algorithm.leetcode.question335_selfcrossing;

public class SelfCrossing {
	public boolean isSelfCrossing(int[] x){
		for(int i=3; i<x.length; i++){
			if(x[i]>=x[i-2] && x[i-1]<=x[i-3]){
				return true;
			}
			if(i>=4 && x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]){
				return true;
			}
			if(i>=5 && x[i-2]>x[i-4] && x[i-1]<x[i-3] && x[i]+x[i-4]>=x[i-2] && x[i-1]+x[i-5]>=x[i-3]){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		int x[] = {2, 1, 1, 2};
		SelfCrossing test = new SelfCrossing();
		System.out.println(""+test.isSelfCrossing(x));
	}
}
