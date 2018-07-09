package br.com.db1.gumga.passwordmeter.rules.deductions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class SequentialSymbolsDeductionRuleTest {
	
	private SequentialNumbersDeductionRule sequentialNumbersDeductionRule = new SequentialNumbersDeductionRule();

	@Test
	public void testPasswordOneSequencial() {
		Rate rate = sequentialNumbersDeductionRule.check("#$%");

		Assert.assertEquals(Long.valueOf(-3l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}


}
