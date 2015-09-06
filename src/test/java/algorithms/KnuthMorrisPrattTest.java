package algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class KnuthMorrisPrattTest {

	private KnuthMorrisPratt knuthMorrisPratt;

	@Before
	public void setUp() {
		this.knuthMorrisPratt = new KnuthMorrisPratt();
	}

	@Test
	public void testMatch() {
		assertThat(this.knuthMorrisPratt.match("abcd", "cd")).isTrue();
		assertThat(this.knuthMorrisPratt.match("abcd", "a")).isTrue();
		assertThat(this.knuthMorrisPratt.match("abcd", "c")).isTrue();
		assertThat(this.knuthMorrisPratt.match("abcd", "d")).isTrue();
		assertThat(this.knuthMorrisPratt.match("abcd", "abcd")).isTrue();
		assertThat(this.knuthMorrisPratt.match("aaaaa", "aaa")).isTrue();

		assertThat(this.knuthMorrisPratt.match("abcd", "abcde")).isFalse();
		assertThat(this.knuthMorrisPratt.match("abcd", "ac")).isFalse();
	}
}
