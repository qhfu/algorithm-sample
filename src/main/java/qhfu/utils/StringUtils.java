package qhfu.utils;

public class StringUtils {

    public static int[] toIntArray(String str, String regex) {
	String[] strArr = str.split(regex);
	int[] res = new int[strArr.length];
	for (int i = 0; i < res.length; i++) {
	    res[i] = Integer.parseInt(strArr[i].trim());
	}
	return res;
    }
}
