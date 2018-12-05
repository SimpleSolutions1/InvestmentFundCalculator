package org.investmentfund.validation;

import java.util.List;

import org.investmentfund.fund.model.Fund;

public interface Validation {

	void isEmptyFundList(List<Fund> fundList);
}
