package br.com.db1.gumga.passwordmeter.rules.commons;

public class Rate {
	private Long count;
	private Long bonus;
	private Boolean requirement;
	
	public Rate() {
		
	}
	
	public Rate(Long count, Long bonus, Boolean requirement) {
		this.count = count;
		this.bonus = bonus;
		this.requirement = requirement;
	}

	public Long getCount() {
		return count;
	}

	public Long getBonus() {
		return bonus;
	}

	public Boolean getRequirement() {
		return requirement;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}

	public void setRequirement(Boolean requirement) {
		this.requirement = requirement;
	}
	
}
