package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class NumberCharactersAdditionRuleTest {
	
	private NumberCharactersAdditionRule numberCharactersAdditionRule = new NumberCharactersAdditionRule();
	
	@Test
	public void testPasswordOnlyOneNumberCharacter() {
		Rate rate = numberCharactersAdditionRule.check("2");

		Assert.assertEquals(Long.valueOf(4l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithTwoNumberCharacter() {
		Rate rate = numberCharactersAdditionRule.check("21");

		Assert.assertEquals(Long.valueOf(8l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(2l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithEightNumberCharacter() {
		Rate rate = numberCharactersAdditionRule.check("12345678");

		Assert.assertEquals(Long.valueOf(32l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(8l), rate.getCount());
		Assert.assertTrue(rate.getRequirement());
	}

}
