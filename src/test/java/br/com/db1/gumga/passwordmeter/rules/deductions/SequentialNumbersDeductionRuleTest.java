package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class SequentialNumbersDeductionRuleTest {
	
	private SequentialNumbersDeductionRule sequentialNumbersDeductionRule = new SequentialNumbersDeductionRule();

	@Test
	public void testPasswordOneSequencial() {
		Rate rate = sequentialNumbersDeductionRule.check("123");

		Assert.assertEquals(Long.valueOf(-3l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordOneBigSequencial() {
		Rate rate = sequentialNumbersDeductionRule.check("12345678");

		Assert.assertEquals(Long.valueOf(-18l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(6l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = sequentialNumbersDeductionRule.check("abcdefghi123ABCxyz!@#$%");

		Assert.assertEquals(Long.valueOf(-33l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(11l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}


}
