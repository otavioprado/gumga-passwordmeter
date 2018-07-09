package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class RepeatCharactersDeductionRule implements Rule {

	@Override
	public Long check(String password) {
		Long total = 0L;
		List<String> alredyChecked = new ArrayList<>();
		char[] passwordArray = password.toCharArray();
		
		for (int i = 0; i < password.length(); i++) {
			String character = String.valueOf(passwordArray[i]);
			
			if(!alredyChecked.contains(character)) {
				alredyChecked.add(character);
			} else {
				continue;
			}
			
			int count = StringUtils.countOccurrencesOf(password, character);
			
			if(count > 1) {
				total += count;
			}
		}

		return total;
	}

}
