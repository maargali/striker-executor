package com.scb.fuzzer.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scb.fuzzer.generator.Generator;
import com.scb.fuzzer.handler.FuzzerException;
import com.scb.fuzzer.model.APIDescMO;
import com.scb.fuzzer.model.APIReqDataMO;
import com.scb.fuzzer.model.APIResponseMO;

@Component
public class GetAPIIteration implements Iteration {

	@Autowired
	private APIRequestTypeFactory factory;

	@Autowired
	private Generator dataGenerator;

	@Override
	public void specIterate(APIDescMO apiDescMO, int noOfIteration) {
		List<APIReqDataMO> apiReqDataMOs = dataGenerator.specGenerateForGET(apiDescMO);
		
		for (int iterationCount = 0; iterationCount < noOfIteration; iterationCount++) {
			APIResponseMO apiResponseMO = null;
			APIReqDataMO apiReqDataMO = apiReqDataMOs.get(iterationCount);
			APIRestCall apiRestCallBean = factory.createAPIRestCallBean(apiReqDataMO.getRequestType());
			try {
				apiResponseMO = apiRestCallBean.callRestAPI(apiReqDataMO);
			} catch (FuzzerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int iteration = iterationCount + 1;
			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println(
					"-----  Param name  ----------  Param Value  ------------------------------------------------------------");
			System.out.println(
					"----------------------------------------------------------------------------------------");
			Object[] datas = (Object[]) apiReqDataMO.getParams();
			for (Object data : datas) {
				System.out.println(" param  " + data);
			}

			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println("----Iteration " + iteration + " Status code is  " + apiResponseMO.getStatusCode()
					+ "-----------------------");
			System.out.println(
					"----------------------------------------------------------------------------------------");

		}

	}

	@Override
	public void randomIterate(APIDescMO apiDescMO, int noOfIteration) {
		List<APIReqDataMO> apiReqDataMOs = dataGenerator.randomGenerateForGET(apiDescMO);
		for (int iterationCount = 0; iterationCount < noOfIteration; iterationCount++) {
			APIResponseMO apiResponseMO = null;
			APIReqDataMO apiReqDataMO = apiReqDataMOs.get(iterationCount);
			APIRestCall apiRestCallBean = factory.createAPIRestCallBean(apiReqDataMO.getRequestType());
			try {
				apiResponseMO = apiRestCallBean.callRestAPI(apiReqDataMO);
			} catch (FuzzerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int iteration = iterationCount + 1;
			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println(
					"-----  Param name  ----------  Param Value  ------------------------------------------------------------");
			System.out.println(
					"----------------------------------------------------------------------------------------");
			Object[] datas = (Object[]) apiReqDataMO.getParams();
			for (Object data : datas) {
				System.out.println(" param  " + data);
			}

			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println("----Iteration " + iteration + " Status code is  " + apiResponseMO.getStatusCode()
					+ "-----------------------");
			System.out.println(
					"----------------------------------------------------------------------------------------");
		}
	}
}
