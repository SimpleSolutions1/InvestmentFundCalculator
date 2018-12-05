package org.innvestmentfund.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.investmentfund.calculator.InvestmentFundCalculatorImpl;
import org.investmentfund.exception.EmptyListException;
import org.investmentfund.fund.model.ForeignFund;
import org.investmentfund.fund.model.Fund;
import org.investmentfund.fund.model.MoneyFund;
import org.investmentfund.fund.model.PolishFund;
import org.investmentfund.investmentstyle.model.InvestmentType;
import org.junit.Assert;
import org.junit.Test;


public class InvestmentFundCalculatorTest {


	@Test
	public void whenSimpleSafeStyleFundAnd10000AmountThenCalculationWithoutRemainder(){
	//When
		List<Fund> fundList = Arrays.asList(new PolishFund(1L, "Fundusz Polski 1"), //
				new PolishFund(2L, "Fundusz Polski 2"), //
				new ForeignFund(3L, "Fundusz Zagraniczny 1"), //
				new ForeignFund(4L, "Fundusz Zagraniczny 2"), //
				new ForeignFund(5L, "Fundusz Zagraniczny 3"), //
				new MoneyFund(6L, "Fundusz Pieniezny 1"));
		BigDecimal amount = BigDecimal.valueOf(10000);
		//Given
		InvestmentFundCalculatorImpl calculator = new InvestmentFundCalculatorImpl(InvestmentType.SAFE, amount, fundList);
		calculator.calculate();
		//Then
		Assert.assertEquals(6, calculator.getInvestmentFundList().size());
		Assert.assertEquals(BigDecimal.valueOf(1000).setScale(2),calculator.getInvestmentFundList().get(0).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(1000).setScale(2),calculator.getInvestmentFundList().get(1).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(2).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(3).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(4).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(500).setScale(2),calculator.getInvestmentFundList().get(5).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(10).setScale(2),calculator.getInvestmentFundList().get(0).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(10).setScale(2),calculator.getInvestmentFundList().get(1).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(2).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(3).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(4).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(5).setScale(2),calculator.getInvestmentFundList().get(5).getPercentage());
		Assert.assertEquals(BigDecimal.ZERO.setScale(2),calculator.getRemainder());
	}
	
	@Test
	public void whenSimpleSafeStyleFundAnd10001AmountThenCalculationWithRemainder(){
	//When
		List<Fund> fundList = Arrays.asList(new PolishFund(1L, "Fundusz Polski 1"), //
				new PolishFund(2L, "Fundusz Polski 2"), //
				new ForeignFund(3L, "Fundusz Zagraniczny 1"), //
				new ForeignFund(4L, "Fundusz Zagraniczny 2"), //
				new ForeignFund(5L, "Fundusz Zagraniczny 3"), //
				new MoneyFund(6L, "Fundusz Pieniezny 1"));
		BigDecimal amount = BigDecimal.valueOf(10001);
		//Given
		InvestmentFundCalculatorImpl calculator = new InvestmentFundCalculatorImpl(InvestmentType.SAFE, amount, fundList);
		calculator.calculate();
		//Then
		Assert.assertEquals(6, calculator.getInvestmentFundList().size());
		Assert.assertEquals(BigDecimal.valueOf(1000).setScale(2),calculator.getInvestmentFundList().get(0).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(1000).setScale(2),calculator.getInvestmentFundList().get(1).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(2).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(3).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(2500).setScale(2),calculator.getInvestmentFundList().get(4).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(500).setScale(2),calculator.getInvestmentFundList().get(5).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(10).setScale(2),calculator.getInvestmentFundList().get(0).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(10).setScale(2),calculator.getInvestmentFundList().get(1).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(2).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(3).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(25).setScale(2),calculator.getInvestmentFundList().get(4).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(5).setScale(2),calculator.getInvestmentFundList().get(5).getPercentage());
		Assert.assertEquals(BigDecimal.ONE.setScale(2),calculator.getRemainder());
	}
	
	@Test
	public void whenSafeStyleFundWithRemiderOnFoundAnd10000AmountThenCalculationWithoutRemainder(){
	//When
		List<Fund> fundList = Arrays.asList(new PolishFund(1L, "Fundusz Polski 1"), //
				new PolishFund(2L, "Fundusz Polski 2"), //
				new PolishFund(3L, "Fundusz Zagraniczny 1"), //
				new ForeignFund(4L, "Fundusz Zagraniczny 2"), //
				new ForeignFund(5L, "Fundusz Zagraniczny 3"), //
				new MoneyFund(6L, "Fundusz Pieniezny 1"));
		BigDecimal amount = BigDecimal.valueOf(10000);
		//Given
		InvestmentFundCalculatorImpl calculator = new InvestmentFundCalculatorImpl(InvestmentType.SAFE, amount, fundList);
		calculator.calculate();
		//Then
		Assert.assertEquals(6, calculator.getInvestmentFundList().size());
		Assert.assertEquals(BigDecimal.valueOf(668).setScale(2),calculator.getInvestmentFundList().get(0).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(666).setScale(2),calculator.getInvestmentFundList().get(1).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(666).setScale(2),calculator.getInvestmentFundList().get(2).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(3750).setScale(2),calculator.getInvestmentFundList().get(3).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(3750).setScale(2),calculator.getInvestmentFundList().get(4).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(500).setScale(2),calculator.getInvestmentFundList().get(5).getAmount());
		Assert.assertEquals(BigDecimal.valueOf(6.68),calculator.getInvestmentFundList().get(0).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(6.66),calculator.getInvestmentFundList().get(1).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(6.66),calculator.getInvestmentFundList().get(2).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(37.50).setScale(2),calculator.getInvestmentFundList().get(3).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(37.50).setScale(2),calculator.getInvestmentFundList().get(4).getPercentage());
		Assert.assertEquals(BigDecimal.valueOf(5).setScale(2),calculator.getInvestmentFundList().get(5).getPercentage());
		Assert.assertEquals(BigDecimal.ZERO.setScale(2),calculator.getRemainder());
	}
	
	@Test(expected = EmptyListException.class)
	public void whenFundListIsEmpty_ThenException(){
		//When
		List<Fund> fundList = Collections.EMPTY_LIST;
		BigDecimal amount = BigDecimal.valueOf(10000);
		InvestmentFundCalculatorImpl calculator = new InvestmentFundCalculatorImpl(InvestmentType.SAFE, amount, fundList);
	}
}
