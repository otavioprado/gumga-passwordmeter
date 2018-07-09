package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class LettersOnlyDeductionRuleTest {
	private LettersOnlyDeductionRule lettersOnlyDeductionRule = new LettersOnlyDeductionRule();

	@Test
	public void testPasswordOnlyLetters() {
		Rate rate = lettersOnlyDeductionRule.check("aaaaaaaaaaaa");

		Assert.assertEquals(Long.valueOf(-12l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(12l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	} 
	
	@Test
	public void testPasswordLettersAndNumbers() {
		Rate rate = lettersOnlyDeductionRule.check("aaaaaaaaaaaa1");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(0l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}

}
