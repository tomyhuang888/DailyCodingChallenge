import java.util.*;

public class DCP1{

	public static boolean twoNumSum(int[] arr, int k){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			int num = arr[i];
			if(set.contains(k-num)){
				return true;
			}else{
				set.add(num);
			}
		}
		return false;
	}


	public static void main(String[] args){
		int[] arr = {10, 15, 3, 7};
		int k = 17;

		if(twoNumSum(arr, k)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
}