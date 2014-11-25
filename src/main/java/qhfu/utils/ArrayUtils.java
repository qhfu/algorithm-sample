package qhfu.utils;

public final class ArrayUtils {

    public static boolean isArrayInc(int[] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
	    if (arr[i] > arr[i + 1]) {
		return false;
	    }
	}
	return true;
    }
}
