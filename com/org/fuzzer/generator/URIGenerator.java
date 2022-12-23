package com.scb.fuzzer.generator;

import org.springframework.stereotype.Component;

import com.scb.fuzzer.factory.APIRestType;
import com.scb.fuzzer.model.APIReqDataMO;

@Component
public class URIGenerator {

	public static String getAPIURL(APIReqDataMO apiModel) {
		String URI = apiModel.getRestAPIURL();

		if (apiModel.getRequestType().equals(APIRestType.GET)) {
			switch (apiModel.getParamType().getValue()) {
			case 1:

				for (Object param : apiModel.getParams()) {
					URI = URI + "/" + param;
				}
				break;
			case 2:
				for (Object param : apiModel.getParams()) {
					URI = URI + "?" + param;
				}
				break;
			default:
				break;
			}

		} else if (apiModel.getRequestType().equals(APIRestType.POST)) {

		}

		return URI;
	}
}
