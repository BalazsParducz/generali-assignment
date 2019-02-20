package com.generali.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.generali.soap.services.TimeService;

@WebService(serviceName = "TimeService")
@Service("timeServiceEndpoint")
public class TimeServiceEndpoint {

	@Autowired
	private TimeService timeService;

	@SuppressWarnings("restriction")
	@WebMethod
	public String provideTime() throws DatatypeConfigurationException {
		return timeService.getTime().toString();
	}

}
