package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class MiddleNumbersOrSymbolsRuleTest {
	private MiddleNumbersSymbolsAdditionRule middleNumbersSymbolsAdditionRule = new MiddleNumbersSymbolsAdditionRule();
	
	@Test
	public void testPasswordOnlyOneLowercaseLetters() {
		Rate rate = middleNumbersSymbolsAdditionRule.check("aaaaaaaaaaaa");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(0l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordOnlyOneInTheMiddle() {
		Rate rate = middleNumbersSymbolsAdditionRule.check("1@1");

		Assert.assertEquals(Long.valueOf(2l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
		Assert.assertTrue(rate.getRequirement());
	}
	
}
