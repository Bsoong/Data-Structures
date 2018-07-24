import java.util.Arrays;

public class Midterm {
public int[] array1;
public int[] array2;
public static int[] union(int[] arr1, int[] arr2) {
	int[] arr3 = new int[arr1.length + arr2.length];
	for(int i = 0, j = 0, k = 0; i< arr3.length; i++) {
		if(i < arr1.length) {
			arr3[i] = arr1[j];
			j++;		
		} else {
			arr3[i] = arr2[k];
			k++;
		}
	}
	return arr3;
}
public static void main(String[] args) {
	int array1[] = {1,2,3};
	int array2[] = {3,4,5};
	union(array1, array2);
	int [] arr3 = union(array1, array2);
	System.out.println(Arrays.toString(arr3));
}
}