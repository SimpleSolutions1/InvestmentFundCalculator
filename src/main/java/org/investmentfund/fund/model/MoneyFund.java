package org.investmentfund.fund.model;

public class MoneyFund extends Fund{
	public MoneyFund(Long id, String name) {
		super(id, name, FundType.MONEY);
	}
}
