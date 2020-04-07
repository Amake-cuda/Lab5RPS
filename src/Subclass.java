/**
 * Класс для работы со строками
 * 
 * @autor Evgeny Korotaev
 * @version 1
 */
public final class Subclass {
	/**
	 * Функция получения ответа является ли подстрока префиксом строки
	 * 
	 * @param str Строка в которой будут искать
	 * @param sub Подстрока которую будут определять
	 * @return true если является префиксом, false во всех остальных случаях
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
	 * Функция получения ответа является ли подстрока суффиксом строки
	 * 
	 * @param str Строка в которой будут искать
	 * @param sub Подстрока которую будут определять
	 * @return true если является суффиксом, false во всех остальных случаях
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
	 * Функция получения ответа является ли строка подстрокой строки
	 * 
	 * @param str Строка в которой будут искать
	 * @param sub Подстрока которую будут определять
	 * @return true если является подстрокой, false во всех остальных случаях
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
	 * Функция получения ответа является ли строка подпоследовательностью строки
	 * 
	 * @param str Строка в которой будут искать
	 * @param sub Подстрока которую будут определять
	 * @param m   Длина строки
	 * @param n   Длина подстроки
	 * @return true если является подпоследовательностью, false во всех остальных
	 *         случаях
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