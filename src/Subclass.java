/**
 * ����� ��� ������ �� ��������
 * 
 * @autor Evgeny Korotaev
 * @version 1
 */
public final class Subclass {
	/**
	 * ������� ��������� ������ �������� �� ��������� ��������� ������
	 * 
	 * @param str ������ � ������� ����� ������
	 * @param sub ��������� ������� ����� ����������
	 * @return true ���� �������� ���������, false �� ���� ��������� �������
	 */
	public static boolean isPrefix(String str, String sub) {
		int m = sub.length();
		int n = str.length();
		int j = 0;
		if (n == 0)
			return false;
		if (m == 0)
			return false;
		while (j < m ) {
			if (sub.charAt(j) == str.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}
		return true;
	}
	/**
	 * ������� ��������� ������ �������� �� ��������� ��������� ������
	 * 
	 * @param str ������ � ������� ����� ������
	 * @param sub ��������� ������� ����� ����������
	 * @return true ���� �������� ���������, false �� ���� ��������� �������
	 */
	public static boolean isSuffix(String str, String sub) {
		int m = sub.length();
		int n = str.length();
		if (n == 0)
			return false;
		if (m == 0)
			return false;
		int k = n - m;
		int j=0;
		while (k < n-1) {
			if (sub.charAt(j) == str.charAt(k)) {
				k++;
				j++;
			} else {
				return false;
			}
		}
		return true;
	}
	/**
	 * ������� ��������� ������ �������� �� ������ ���������� ������
	 * 
	 * @param str ������ � ������� ����� ������
	 * @param sub ��������� ������� ����� ����������
	 * @return true ���� �������� ����������, false �� ���� ��������� �������
	 */
	public static boolean Substring(String str, String sub) {
		int m = sub.length();
		int n = str.length();
		boolean res = false;
		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while ((j < m) && (str.charAt(i + j) == sub.charAt(j))) {
				j++;
			}
			if (j == m) {
				res = true;
			}
		}
		if (res)
			return true;
		else
			return false;
	}
	/**
	 * ������� ��������� ������ �������� �� ������ ���������������������� ������
	 * 
	 * @param str ������ � ������� ����� ������
	 * @param sub ��������� ������� ����� ����������
	 * @param m   ����� ������
	 * @param n   ����� ���������
	 * @return true ���� �������� ����������������������, false �� ���� ���������
	 *         �������
	 */
	public static boolean isSubsequence(String sub, String str, int m, int n) {
		 // Base Cases 
        if (m == 0)  
            return true; 
        if (n == 0)  
            return false; 
              
        // If last characters of two strings are matching 
        if (sub.charAt(m-1) == str.charAt(n-1)) 
            return isSubsequence(sub, str, m-1, n-1); 
  
        // If last characters are not matching 
        return isSubsequence(sub, str, m, n-1); 
	}
}