package algorithms;

/**
 * Knuth-Morris-Pratt algorithm
 * 
 * @author Lukasz Antkowiak (lukasz.patryk.antkowiak(at)gmail.com)
 *
 */
public class KnuthMorrisPratt {

	public boolean match(final String text, final String pattern) {
		final int[] prefix = computePrefixFunction(pattern);
		int q = 0;
		final int n = text.length();
		final int m = pattern.length();

		for (int i = 0; i < n; i++) {
			while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
				q = prefix[q];
			}
			if (pattern.charAt(q) == text.charAt(i)) {
				q++;
			}
			if (q == m) {
				return true;
			}
		}

		return false;
	}

	private static int[] computePrefixFunction(final String pattern) {
		int j = -1;

		final int m = pattern.length();

		final int[] prefixFunction = new int[m + 1];

		prefixFunction[0] = j;
		for (int i = 0; i < m;) {
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = prefixFunction[j];
			}
			prefixFunction[++i] = ++j;
		}
		return prefixFunction;
	}
}
