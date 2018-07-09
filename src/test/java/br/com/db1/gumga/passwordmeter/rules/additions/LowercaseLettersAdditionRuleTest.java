package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class LowercaseLettersAdditionRuleTest {
	
	private LowercaseLettersAdditionRule lowercaseLettersAdditionRule = new LowercaseLettersAdditionRule();
	
	@Test
	public void testPasswordOnlyOneLowercaseLetters() {
		Rate rate = lowercaseLettersAdditionRule.check("aaaaaaaaaaaa");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(12l), rate.getCount());
	}
	
	@Test
	public void testPasswordWithTwoLowercaseLetters() {
		Rate rate = lowercaseLettersAdditionRule.check("aaaaaaaaaaaabbbbbbbbb");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(21l), rate.getCount());
	}
	
	@Test
	public void testPasswordLowercaseLetters() {
		Rate rate = lowercaseLettersAdditionRule.check("aaaaaaaaaaaabbbbbbbbb1");

		Assert.assertEquals(Long.valueOf(2l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(21l), rate.getCount());
	}

}
