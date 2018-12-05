package org.investmentfund.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.investmentfund.fund.model.Fund;
import org.investmentfund.fund.model.FundType;
import org.investmentfund.fund.model.InvestmentFundPercentage;
import org.investmentfund.investmentstyle.model.InvestmentStyle;
import org.investmentfund.investmentstyle.model.InvestmentType;
import org.investmentfund.model.InvestmentFund;
import org.investmentfund.validation.ValidationImpl;

public class InvestmentFundCalculatorImpl implements InvestmentFundCalculator {
	private InvestmentType investmentType;
	private BigDecimal amount;
	private List<Fund> fundList;
	private InvestmentStyle investmentStyle;
	private BigDecimal remainder;
	private List<InvestmentFund> investmentFundList = new ArrayList<>();
	private ValidationImpl validation;

	public InvestmentFundCalculatorImpl(InvestmentType investmentType, BigDecimal amount, List<Fund> fundList) {
		this.validation = new ValidationImpl();
		validation.isEmptyFundList(fundList);
		this.investmentType = investmentType;
		this.amount = amount;
		this.fundList = fundList;
		this.investmentStyle = new InvestmentStyle();

	}

	
	
	public void calculate() {
		List<InvestmentFundPercentage> investmentFundPercentageList = this.investmentStyle
				.getInvestmentStyleMap(this.investmentType);
		BigDecimal remainderPart;
		this.remainder = this.amount;
		for (InvestmentFundPercentage investmentFund : investmentFundPercentageList) {
			BigDecimal amoutForFundType = countAmountForFundType(investmentFund);
			remainderPart = countReminderForFundType(investmentFund);
			amoutForFundType = amoutForFundType.subtract(remainderPart);
			calculateAmountForSingleFund(investmentFund.getFundType(), amoutForFundType.doubleValue());
			this.remainder = this.remainder.subtract(amoutForFundType);
		}


	}

	private void calculateAmountForSingleFund(FundType fundType, double amoutForFundType) {
		BigDecimal fundAmount;
		BigDecimal percentage;
		List<Fund> foundTypeList = this.fundList.stream().filter(fund -> fund.getFundType().equals(fundType))
				.collect(Collectors.toList());
		int foundTypeListSize = foundTypeList.size();
		for (Fund fund : foundTypeList) {
			if (foundTypeList.get(0).equals(fund)) {
				fundAmount = countFundAmountWithRemainder(amoutForFundType, foundTypeListSize);
				percentage = countPercentage(fundAmount.doubleValue(), this.amount.doubleValue());
				this.investmentFundList.add(new InvestmentFund(fund, percentage, fundAmount));
			} else {
				fundAmount = countFundAmount(amoutForFundType, foundTypeListSize);
				percentage = countPercentage(fundAmount.doubleValue(), this.amount.doubleValue());
				this.investmentFundList.add(new InvestmentFund(fund, percentage, fundAmount));
			}
		}
	}
	
	private BigDecimal countAmountForFundType(InvestmentFundPercentage investmentFund) {
		return BigDecimal.valueOf(((this.amount.doubleValue() * investmentFund.getPercent()) / 100));
	}

	private BigDecimal countReminderForFundType(InvestmentFundPercentage investmentFund) {
		return BigDecimal.valueOf(((this.amount.doubleValue() * investmentFund.getPercent()) % 100.0) / 100.0).setScale(2);	
	}

	private BigDecimal countFundAmount(double foundAmount, int size) {
		return BigDecimal.valueOf(foundAmount / size).setScale(0,RoundingMode.DOWN);
	}

	private BigDecimal countFundAmountWithRemainder(double foundAmount, int size) {
		return countFundAmount(foundAmount, size).add(countRemainerForFundAmount(foundAmount, size)).setScale(0, RoundingMode.DOWN);
	}
	
	private BigDecimal countRemainerForFundAmount(double foundAmount, int size){
		return BigDecimal.valueOf((foundAmount % size)).setScale(0,RoundingMode.DOWN);
	}
	private BigDecimal countPercentage(double fundTypeAmount, double amount) {
		return BigDecimal.valueOf((fundTypeAmount / amount) * 100);
	}
	public BigDecimal getRemainder() {
		return remainder;
	}

	public List<InvestmentFund> getInvestmentFundList() {
		return investmentFundList;
	}

}
