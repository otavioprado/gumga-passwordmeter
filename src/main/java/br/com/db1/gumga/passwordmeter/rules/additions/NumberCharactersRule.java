package br.com.db1.gumga.passwordmeter.rules.additions;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumberCharactersRule implements Rule {

	@Override
	public Long check(String password) {
		return (long) (password.length() * 4);
	}

}
