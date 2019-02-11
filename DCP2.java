public class DCP2{

	public static int[] divide(int[] arr){
		int total = 1;
		for(int i = 0; i < arr.length; i++){
			total *= arr[i];
		}

		int[] newArr = new int[arr.length];
		for(int j = 0; j < arr.length; j++){
			newArr[j] = total / arr[j];
		}

		return newArr;
	}

	public static int[] noDivide(int[] arr){
		int[] leftArr = new int[arr.length];
		int[] rightArr = new int[arr.length];

		leftArr[0] = 1;
		for(int i = 1 ; i < arr.length; i++){
			//leftArr[i] = 1;
			leftArr[i] = leftArr[i-1] * arr[i-1];
		}
		rightArr[arr.length-1] = 1;
		for(int j = arr.length-2; j >= 0; j--){
			rightArr[j] = rightArr[j+1] * arr[j+1];
		}
		int[] newArr = new int[arr.length];
		for(int k = 0; k < arr.length; k++){
			newArr[k] = leftArr[k]*rightArr[k];
		}
		return newArr;
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr2 = {3, 2, 1};

		int[] newArr = divide(arr);
		for(int i = 0; i < newArr.length; i++){
			System.out.println(newArr[i]);
		}
		
		int[] newArr2 = noDivide(arr);
		for(int i = 0; i < newArr2.length; i++){
			System.out.println(newArr2[i]);
		}
	}
}