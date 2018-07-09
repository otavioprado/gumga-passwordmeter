package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class UppercaseLettersAdditionRuleTest {
	
	private UppercaseLettersAdditionRule uppercaseLettersAdditionRule = new UppercaseLettersAdditionRule();
	
	@Test
	public void testPasswordOnlyOneUppercaseLetters() {
		Rate rate = uppercaseLettersAdditionRule.check("AAAAAAAAA");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(9l), rate.getCount());
	}
	
	@Test
	public void testPasswordWithTwoUppercaseLetters() {
		Rate rate = uppercaseLettersAdditionRule.check("AAAAAAAABBBBBBB");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(15l), rate.getCount());
	}
	
	@Test
	public void testPasswordUppercaseLetters() {
		Rate rate = uppercaseLettersAdditionRule.check("AAAAAABBBBB1");

		Assert.assertEquals(Long.valueOf(2l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(11l), rate.getCount());
	}
	
	@Test
	public void testPasswordUppercaseWithLowerLetters() {
		Rate rate = uppercaseLettersAdditionRule.check("AAAAAABBBBB1bbbbbcccc");

		Assert.assertEquals(Long.valueOf(20l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(11l), rate.getCount());
	}

}
