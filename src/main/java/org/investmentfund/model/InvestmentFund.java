package org.investmentfund.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.investmentfund.fund.model.Fund;

public class InvestmentFund {
	private Fund fund;
	private BigDecimal percentage;
	private BigDecimal amount;

	public InvestmentFund(Fund fund, BigDecimal percentage, BigDecimal amount) {
		this.fund = fund;
		this.percentage = percentage;
		this.amount = amount;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Fund getFund() {
		return fund;
	}

	public BigDecimal getPercentage() {
		return percentage.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getAmount() {
		return amount.setScale(2, RoundingMode.HALF_UP);
	}

}
