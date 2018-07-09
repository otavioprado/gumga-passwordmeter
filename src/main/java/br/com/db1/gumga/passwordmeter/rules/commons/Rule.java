package br.com.db1.gumga.passwordmeter.rules.commons;

public interface Rule {
	
	/**
	 * Checks the number of points added or reduced based
	 * on the password rule being used
	 * 
	 * @param password to be checked
	 * @return calculated points (rate) for current rule
	 */
	Rate check(String password);
}
