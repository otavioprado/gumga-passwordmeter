package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class NumbersOnlyDeductionRuleTest {
	private NumbersOnlyDeductionRule numbersOnlyDeductionRule = new NumbersOnlyDeductionRule();

	@Test
	public void testPasswordOnlyNumbers() {
		Rate rate = numbersOnlyDeductionRule.check("111111111111");

		Assert.assertEquals(Long.valueOf(-12l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(12l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	} 
	
	@Test
	public void testPasswordLettersAndNumbers() {
		Rate rate = numbersOnlyDeductionRule.check("11111111111a");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(0l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}

}
