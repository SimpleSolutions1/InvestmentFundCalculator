package org.investmentfund.fund.model;

public class ForeignFund extends Fund {

	public ForeignFund(Long id, String name) {
		super(id, name, FundType.FOREIGN);
	}

}
