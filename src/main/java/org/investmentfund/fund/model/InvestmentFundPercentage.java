package org.investmentfund.fund.model;

public class InvestmentFundPercentage {
	private FundType fundType;
	private int percent;
	public InvestmentFundPercentage(FundType fundType, int percent) {
		this.fundType = fundType;
		this.percent = percent;
	}

	public FundType getFundType() {
		return fundType;
	}

	public int getPercent() {
		return percent;
	}
	

}
