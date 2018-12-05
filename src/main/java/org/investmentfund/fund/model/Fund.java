package org.investmentfund.fund.model;

public abstract class Fund {
	private Long id;
	private String name;
	private FundType fundType;

	public Fund(Long id, String name, FundType fundType) {
		this.id = id;
		this.name = name;
		this.fundType = fundType;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public FundType getFundType() {
		return fundType;
	}

}
