package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class ConsecutiveUppercaseLettersDeductionRuleTest {
	
	private ConsecutiveUppercaseLettersDeductionRule consecutiveUppercaseLettersDeductionRule = new ConsecutiveUppercaseLettersDeductionRule();

	@Test
	public void testPasswordOnlyUppercaseLetters() {
		Rate rate = consecutiveUppercaseLettersDeductionRule.check("ABCDE");

		Assert.assertEquals(Long.valueOf(-8l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(4l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = consecutiveUppercaseLettersDeductionRule.check("ABCDEFbasdasdCDFDASbasdasdCDFDAS212");

		Assert.assertEquals(Long.valueOf(-30l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(15l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	} 
}
