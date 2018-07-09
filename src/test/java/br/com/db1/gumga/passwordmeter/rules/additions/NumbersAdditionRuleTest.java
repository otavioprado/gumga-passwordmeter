package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class NumbersAdditionRuleTest {
	
	private NumbersAdditionRule numbersAdditionRule = new NumbersAdditionRule();
	
	@Test
	public void testPasswordOnlyOneNumber() {
		Rate rate = numbersAdditionRule.check("222222222");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(9l), rate.getCount());
		Assert.assertTrue(rate.getRequirement());
	}
	
	@Test
	public void testPasswordWithTwoNumbers() {
		Rate rate = numbersAdditionRule.check("111111122222222");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(15l), rate.getCount());
		Assert.assertTrue(rate.getRequirement());
	}
	
	@Test
	public void testPasswordNumbers() {
		Rate rate = numbersAdditionRule.check("12345678a");

		Assert.assertEquals(Long.valueOf(32l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(8l), rate.getCount());
		Assert.assertTrue(rate.getRequirement());
	}
	
	@Test
	public void testPasswordLetters() {
		Rate rate = numbersAdditionRule.check("aaaa");

		Assert.assertEquals(Long.valueOf(0l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(0l), rate.getCount());
		Assert.assertFalse(rate.getRequirement());
	}


}
