package br.com.db1.gumga.passwordmeter.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.db1.gumga.passwordmeter.rules.additions.LowercaseLettersAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.additions.MiddleNumbersSymbolsAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.additions.NumberCharactersAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.additions.NumbersAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.additions.SymbolsAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.additions.UppercaseLettersAdditionRule;
import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;
import br.com.db1.gumga.passwordmeter.rules.deductions.ConsecutiveLowercaseDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.ConsecutiveNumbersDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.ConsecutiveUppercaseLettersDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.LettersOnlyDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.NumbersOnlyDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.RepeatCharactersDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.SequentialLettersDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.SequentialNumbersDeductionRule;
import br.com.db1.gumga.passwordmeter.rules.deductions.SequentialSymbolsDeductionRule;
import br.com.db1.gumga.passwordmeter.service.RateCalculatorService;

@Service
public class RateCalculatorImpl implements RateCalculatorService {

	private static final List<Rule> RULES = new ArrayList<>();

	static {
		RULES.addAll(Arrays.asList(
				new LowercaseLettersAdditionRule(),
				new MiddleNumbersSymbolsAdditionRule(),
				new NumberCharactersAdditionRule(),
				new NumbersAdditionRule(),
				new SymbolsAdditionRule(),
				new UppercaseLettersAdditionRule(),
				new ConsecutiveLowercaseDeductionRule(),
				new ConsecutiveNumbersDeductionRule(),
				new ConsecutiveUppercaseLettersDeductionRule(),
				new LettersOnlyDeductionRule(),
				new NumbersOnlyDeductionRule(),
				new RepeatCharactersDeductionRule(),
				new SequentialLettersDeductionRule(),
				new SequentialNumbersDeductionRule(),
				new SequentialSymbolsDeductionRule()
		));
	}
	
	public Long calculate(String password) {
		long requirementCount = 0;
		long totalBonus = 0;
		
		for (Rule rule : RULES) {
			Rate rate = rule.check(password);
			
			if(rate.getRequirement()) {
				requirementCount++;
			}
			
			totalBonus += rate.getBonus();
		}

		return totalBonus + (requirementCount * 2);
	}
}
