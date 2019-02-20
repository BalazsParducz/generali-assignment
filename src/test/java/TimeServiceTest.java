
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.generali.soap.services.*;

import static org.junit.Assert.assertEquals;


public class TimeServiceTest {
	
	
	private TimeService timeService;
	
	@Before
	public void init() {
		timeService = new TimeService();
		timeService.setTimeZone("America/New_York");
	}
	
	@Test
	public void testTimeZone() throws DatatypeConfigurationException {
		XMLGregorianCalendar timeFromService = timeService.getTime();
					
		Instant nowUtc = Instant.now();
		ZonedDateTime testTime = ZonedDateTime.ofInstant(nowUtc, ZoneId.of("America/New_York"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					
	    assertEquals(formatter.format(testTime), timeFromService.getHour()+":"+timeFromService.getMinute());
	}	
}