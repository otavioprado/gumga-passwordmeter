package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class SequentialLettersDeductionRuleTest {
	
	private SequentialLettersDeductionRule sequentialLettersDeductionRule = new SequentialLettersDeductionRule();

	@Test
	public void testPasswordOneSequencial() {
		Rate rate = sequentialLettersDeductionRule.check("abc");

		Assert.assertEquals(Long.valueOf(-3l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordOneBigSequencial() {
		Rate rate = sequentialLettersDeductionRule.check("abcdefghi");

		Assert.assertEquals(Long.valueOf(-21l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(7l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = sequentialLettersDeductionRule.check("abcdefghi123ABCxyz!@#$%");

		Assert.assertEquals(Long.valueOf(-33l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(11l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}


}
