package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class ConsecutiveLowercaseLettersDeductionRuleTest {
	private ConsecutiveLowercaseDeductionRule consecutiveLowercaseDeductionRule = new ConsecutiveLowercaseDeductionRule();

	@Test
	public void testPasswordOnlyLowercaseLetters() {
		Rate rate = consecutiveLowercaseDeductionRule.check("abcde");

		Assert.assertEquals(Long.valueOf(-8l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(4l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithAll() {
		Rate rate = consecutiveLowercaseDeductionRule.check("abcdeEOFNfbasdasdcJHEMdfdasbasEPKJ@5dasdcdfdas");

		Assert.assertEquals(Long.valueOf(-56l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(28l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	} 
}
