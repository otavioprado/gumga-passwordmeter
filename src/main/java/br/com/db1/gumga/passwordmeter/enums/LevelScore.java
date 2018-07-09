package br.com.db1.gumga.passwordmeter.enums;

public enum LevelScore {
	TOO_SHORT("Too Short"), VERY_WEAK("Very Weak"), WEAK("Weak"), GOOD("Good"), STRONG("Strong"), VERY_STRONG(
			"Very Strong");

	private LevelScore(String description) {
		this.description = description;
	}

	private String description;

	public static LevelScore byScore(Long score) {
		if (score > 0 && score < 20) {
			return VERY_WEAK;
		} else if (score >= 20 && score < 40) {
			return WEAK;
		} else if (score >= 40 && score < 60) {
			return GOOD;
		} else if (score >= 60 && score < 80) {
			return STRONG;
		} else if (score >= 80) {
			return VERY_STRONG;
		}
		return TOO_SHORT;
	}

	public String getDescription() {
		return description;
	}
}
