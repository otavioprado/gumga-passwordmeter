package br.com.db1.gumga.passwordmeter.service;

@FunctionalInterface
public interface RateCalculatorService {
	public Long calculate(String password);
}
