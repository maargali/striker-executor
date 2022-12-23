package com.scb.fuzzer.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.scb.fuzzer.mapper.FuzzerMapper;
import com.scb.fuzzer.model.APIDescMO;
import com.scb.fuzzer.model.APIReqDataMO;
import com.scb.fuzzer.util.DoubleRandoms;
import com.scb.fuzzer.util.IntegerRandoms;
import com.scb.fuzzer.util.Randoms;
import com.scb.fuzzer.util.StringRandoms;

/**
 * Generate random data based on type defined. {@link StringRandoms} to generate
 * random strings. {@link IntegerRandoms} to generate random integer values
 * (both negative and positive values) {@link DoubleRandoms} to generate random
 * double values.
 * 
 * <p>
 * random values are generated based on <i>iterationsize</i> which is passed
 * while initializing the randoms. randoms generate array of values with
 * specified iterationsize. For eg:- if iteration size is 5, then for integer
 * random generates 5 different integer values with base integer as <i>1000</i>.
 * values generated are like -20, 55, 189, 355, 855.
 * 
 * @author 1633686
 */
@Component
public class DataGenerator implements Generator {

	@Autowired
	@Qualifier("stringRandoms")
	private Randoms stringRandoms;

	@Autowired
	@Qualifier("integerRandoms")
	private Randoms integerRandoms;

	@Autowired
	@Qualifier("doubleRandoms")
	private Randoms doubleRandoms;

	@Autowired
	private FuzzerMapper fuzzMapper;

	/**
	 * generate randoms for {@link HttpMethod#POST} as per API specification.
	 * randoms are generated based on data types mentioned in API spec.
	 */
	@Override
	public ArrayList<APIReqDataMO> specGenerate(APIDescMO apiDescMO) {
		ArrayList<APIReqDataMO> apiReqDataMOs = new ArrayList<APIReqDataMO>();
		LinkedHashMap<String, String> datas = (LinkedHashMap<String, String>) apiDescMO.getData();
		Integer[] integerRandoms = new IntegerRandoms.Builder(apiDescMO.getIteration()).build().gererateRandoms();
		System.out.println(Arrays.toString(integerRandoms));
		for (int iterationCount = 0; iterationCount < apiDescMO.getIteration(); iterationCount++) {
			APIReqDataMO apiReqDataMO = fuzzMapper.mapApiDescMOToAPIReqMO(apiDescMO, new APIReqDataMO());
			LinkedHashMap<String, Object> generatedData = new LinkedHashMap<String, Object>();
			for (String key : datas.keySet()) {
				String value = (String) datas.get(key);
				if (value.equalsIgnoreCase("String")) {
					String genStrValue = (String) stringRandoms.gererateRandoms();
					generatedData.put(key, genStrValue);
				} else if (value.equalsIgnoreCase("integer")) {
					generatedData.put(key, (int) integerRandoms[iterationCount]);
				} else if (value.equalsIgnoreCase("double")) {
					generatedData.put(key, (double) doubleRandoms.gererateRandoms());
				}
			}

			apiReqDataMO.setRequestObject(generatedData);
			apiReqDataMOs.add(apiReqDataMO);
		}

		return apiReqDataMOs;
	}

	/**
	 * generate randoms for {@link HttpMethod#GET} method based on param types as
	 * per API spec.for both param types <i>request</i> or <i>path</i>, generation
	 * logic is same.
	 */
	@Override
	public ArrayList<APIReqDataMO> specGenerateForGET(APIDescMO apiDescMO) {
		ArrayList<APIReqDataMO> apiReqDataMOs = new ArrayList<APIReqDataMO>();
		String[] dataTypes = new String[] { (String) apiDescMO.getData() };
		Integer[] integerRandoms = new IntegerRandoms.Builder(apiDescMO.getIteration()).build().gererateRandoms();
		System.out.println(Arrays.toString(integerRandoms));
		for (int iterationCount = 0; iterationCount < apiDescMO.getIteration(); iterationCount++) {
			APIReqDataMO apiReqDataMO = fuzzMapper.mapApiDescMOToAPIReqMO(apiDescMO, new APIReqDataMO());
			Object[] dataParams = new Object[dataTypes.length];
			for (int count = 0; count < dataTypes.length; count++) {
				if (dataTypes[count].equalsIgnoreCase("String")) {
					String genStrValue = (String) stringRandoms.gererateRandoms();
					dataParams[count] = genStrValue;
				} else if (dataTypes[count].equalsIgnoreCase("integer")) {
					int genIntValue = integerRandoms[iterationCount];
					dataParams[count] = genIntValue;
				}
			}
			apiReqDataMO.setParams(dataParams);
			apiReqDataMOs.add(apiReqDataMO);
		}
		return apiReqDataMOs;
	}

	/**
	 * generates randoms values for {@link HttpMethod#GET} not as per API spec.
	 * random values are generated as oppose to datatypes defined in spec. for e.g
	 * :- if datatype mentioned as
	 * <li>1. {@link Integer} then it generates random {@link String} values.
	 * <li>2. {@link String} then it generated random {@link Integer} values.
	 */
	@Override
	public ArrayList<APIReqDataMO> randomGenerateForGET(APIDescMO apiDescMO) {
		ArrayList<APIReqDataMO> apiReqDataMOs = new ArrayList<APIReqDataMO>();
		String[] dataTypes = new String[] { (String) apiDescMO.getData() };
		Integer[] integerRandoms = new IntegerRandoms.Builder(apiDescMO.getIteration()).build().gererateRandoms();
		for (int iterationCount = 0; iterationCount < apiDescMO.getIteration(); iterationCount++) {
			APIReqDataMO apiReqDataMO = fuzzMapper.mapApiDescMOToAPIReqMO(apiDescMO, new APIReqDataMO());
			Object[] dataParams = new Object[dataTypes.length];
			for (int count = 0; count < dataTypes.length; count++) {
				if (dataTypes[count].equalsIgnoreCase("string")) {
					int genIntValue = (int) integerRandoms[iterationCount];
					dataParams[count] = genIntValue;
				} else if (dataTypes[count].equalsIgnoreCase("integer")) {
					String genStrValue = ((String) stringRandoms.gererateRandoms());
					dataParams[count] = genStrValue;
				}
			}
			apiReqDataMO.setParams(dataParams);
			apiReqDataMOs.add(apiReqDataMO);
		}
		return apiReqDataMOs;
	}

	/**
	 * generates randoms values for {@link HttpMethod#POST} not as per API spec.
	 * random values are generated as oppose to datatypes defined in spec. for e.g
	 * :- if datatype mentioned as
	 * <li>1. {@link Integer} then it generates random {@link String} values.
	 * <li>2. {@link String} then it generated random {@link Integer} values.
	 */
	@Override
	public ArrayList<APIReqDataMO> randomGenerate(APIDescMO apiDescMO) {
		ArrayList<APIReqDataMO> apiReqDataMOs = new ArrayList<APIReqDataMO>();
		LinkedHashMap<String, String> dataTypes = (LinkedHashMap<String, String>) apiDescMO.getData();
		Integer[] integerRandoms = new IntegerRandoms.Builder(apiDescMO.getIteration()).build().gererateRandoms();
		for (int iterationCount = 0; iterationCount < apiDescMO.getIteration(); iterationCount++) {
			APIReqDataMO apiReqDataMO = fuzzMapper.mapApiDescMOToAPIReqMO(apiDescMO, new APIReqDataMO());
			LinkedHashMap<String, Object> generatedData = new LinkedHashMap<String, Object>();
			for (String key : dataTypes.keySet()) {
				String value = (String) dataTypes.get(key);
				if (value.equalsIgnoreCase("String")) {
					generatedData.put(key, (int) integerRandoms[iterationCount]);
				} else if (value.equalsIgnoreCase("integer")) {
					String genStrValue = (String) stringRandoms.gererateRandoms();
					generatedData.put(key, genStrValue);
				} else if (value.equalsIgnoreCase("double")) {
					generatedData.put(key, (double) doubleRandoms.gererateRandoms());
				}
			}

			apiReqDataMO.setRequestObject(generatedData);
			apiReqDataMOs.add(apiReqDataMO);
		}

		return apiReqDataMOs;
	}
}
