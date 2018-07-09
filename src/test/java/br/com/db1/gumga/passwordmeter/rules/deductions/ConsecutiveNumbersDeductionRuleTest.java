package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class ConsecutiveNumbersDeductionRuleTest {
	
	private ConsecutiveNumbersDeductionRule consecutiveNumbersDeductionRule = new ConsecutiveNumbersDeductionRule();

	@Test
	public void testPasswordOnlyNumbers() {
		Rate rate = consecutiveNumbersDeductionRule.check("1234567");

		Assert.assertEquals(Long.valueOf(-12l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(6l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = consecutiveNumbersDeductionRule.check("abcdeEOFN123fbasdasdcJHEMdfd458sbasEPKJ@dasdcdfdas");

		Assert.assertEquals(Long.valueOf(-8l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(4l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	} 
}
