package br.com.db1.gumga.passwordmeter.dto;

import java.util.Objects;

import br.com.db1.gumga.passwordmeter.enums.LevelScore;

public class PasswordMeterResponse {
	private Long score;
	private LevelScore levelScore;
	
	public PasswordMeterResponse() {
		
	}
	
	public PasswordMeterResponse(Long score, LevelScore levelScore) {
		this.score = score;
		this.levelScore = levelScore;
	}

	public Long getScore() {
		return score;
	}

	public LevelScore getLevelScore() {
		return levelScore;
	}

	public String getDescription() {
		return levelScore.getDescription();
	}

	public PasswordMeterResponse(LevelScore levelScore, Long score) {
		this.levelScore = levelScore;
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PasswordMeterResponse that = (PasswordMeterResponse) o;
		return Objects.equals(score, that.score) && levelScore == that.levelScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(score, levelScore);
	}
}
