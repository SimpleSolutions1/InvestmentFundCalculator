package org.investmentfund.investmentstyle.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.investmentfund.fund.model.FundType;
import org.investmentfund.fund.model.InvestmentFundPercentage;

public class InvestmentStyle {
	private Map<InvestmentType, List<InvestmentFundPercentage>> investmentStyleMap;

	public List<InvestmentFundPercentage> getInvestmentStyleMap(InvestmentType investmentType) {
		if (this.investmentStyleMap == null || this.investmentStyleMap.isEmpty()) {
			createInvestmentMap();
		}
		return this.investmentStyleMap.get(investmentType);
	}

	
	private void createInvestmentMap() {
		EnumMap<InvestmentType, List<InvestmentFundPercentage>> investmentMap = new EnumMap<>(InvestmentType.class);
		List<InvestmentFundPercentage> agresiveStyleList = new ArrayList<>();
		agresiveStyleList.add(new InvestmentFundPercentage(FundType.POLISH, 40));
		agresiveStyleList.add(new InvestmentFundPercentage(FundType.FOREIGN, 20));
		agresiveStyleList.add(new InvestmentFundPercentage(FundType.MONEY, 40));
		List<InvestmentFundPercentage> safeStyleList = new ArrayList<>();
		safeStyleList.add(new InvestmentFundPercentage(FundType.POLISH, 20));
		safeStyleList.add(new InvestmentFundPercentage(FundType.FOREIGN, 75));
		safeStyleList.add(new InvestmentFundPercentage(FundType.MONEY, 5));
		List<InvestmentFundPercentage> balancedStyleList = new ArrayList<>();
		balancedStyleList.add(new InvestmentFundPercentage(FundType.POLISH, 30));
		balancedStyleList.add(new InvestmentFundPercentage(FundType.FOREIGN, 60));
		balancedStyleList.add(new InvestmentFundPercentage(FundType.MONEY, 10));
		investmentMap.put(InvestmentType.AGRESIVE, agresiveStyleList);
		investmentMap.put(InvestmentType.SAFE, safeStyleList);
		investmentMap.put(InvestmentType.BALANCED, balancedStyleList);
		this.investmentStyleMap = Collections.unmodifiableMap(investmentMap);
	}
	
	
	
}
