package br.com.db1.gumga.passwordmeter.rules.additions;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;

public class SymbolsAdditionRuleTest {
	private SymbolsAdditionRule symbolsAdditionRule = new SymbolsAdditionRule();

	@Test
	public void testPasswordWithOnlyOneSymbol() {
		Rate rate = symbolsAdditionRule.check("!");

		Assert.assertEquals(Long.valueOf(6l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(1l), rate.getCount());
	}

	@Test
	public void testPasswordWithTwoSymbol() {
		Rate rate = symbolsAdditionRule.check("!@");

		Assert.assertEquals(Long.valueOf(12l), rate.getBonus());
		Assert.assertEquals(Long.valueOf(2l), rate.getCount());
	}

	@Test
	public void testPasswordWithManySymbols() {
		Rate rate = symbolsAdditionRule.check("*&¨#$&5t1)&#(@6489");
		
		Assert.assertEquals(Long.valueOf(66l),rate.getBonus());
		Assert.assertEquals(Long.valueOf(11l),rate.getCount());
	}
}
