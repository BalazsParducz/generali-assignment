package com.generali.soap.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

//@Service("timeService")
public class TimeService {
	
	private static final Logger logger = LogManager.getLogger(TimeService.class);
	
	private String timeZone;
	
    private XMLGregorianCalendar typeConverter(ZonedDateTime zonedDateTime) throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return xmlGregorianCalendar;
    }

	public XMLGregorianCalendar getTime() throws DatatypeConfigurationException {
		Instant nowUtc = Instant.now();
        ZoneId zone = ZoneId.of(timeZone);
        ZonedDateTime time = ZonedDateTime.ofInstant(nowUtc, zone);
        logger.info("A time request has been made at " + time.toString());
        return typeConverter(time);
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	

}
