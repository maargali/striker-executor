package com.scb.fuzzer.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.scb.fuzzer.model.APIResponseMO;

@Component
public class FuzzerAPIResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
			APIResponseMO exceptionMO = new APIResponseMO();
			exceptionMO.setStatusCode(httpResponse.getStatusCode());
			exceptionMO.setStatus(httpResponse.getStatusText());
		} else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
				APIResponseMO exceptionMO = new APIResponseMO();
				exceptionMO.setStatusCode(httpResponse.getStatusCode());
				exceptionMO.setStatus(httpResponse.getStatusText());
			}
		}
	}

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
				|| httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}
}
