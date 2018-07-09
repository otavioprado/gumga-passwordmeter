package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class RepeatCharactersDeductionRuleTest {
	
	private RepeatCharactersDeductionRule repeatCharactersDeductionRule = new RepeatCharactersDeductionRule();

	@Test
	public void testPasswordOnlyLetters() {
		Rate rate = repeatCharactersDeductionRule.check("aaa");

		Assert.assertEquals(Long.valueOf(-14l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(3l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithTwoLetters() {
		Rate rate = repeatCharactersDeductionRule.check("aaab");

		Assert.assertEquals(Long.valueOf(-11l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(3l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = repeatCharactersDeductionRule.check("aaab@!*&$75194njab");

		Assert.assertEquals(Long.valueOf(-1l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(6l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}

}
