package org.investmentfund.validation;

import java.util.List;

import org.investmentfund.exception.EmptyListException;
import org.investmentfund.fund.model.Fund;

public class ValidationImpl implements Validation {

	@Override
	public void isEmptyFundList(List<Fund> fundList) {
		if(fundList.isEmpty()){
			throw new EmptyListException("Found list is empty");
		}
		
	}

	

	

}
