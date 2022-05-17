package br.com.connemat.sysmat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.format.WebConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.support.DefaultFormattingConversionService;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootTest
public class TestDateConversionService {

	@Autowired
	@Qualifier("conversionService")
	private DefaultFormattingConversionService conversionService;
	
	@Autowired
	private WebConversionService mvcConversionService;
	
	public TestDateConversionService() {
	}

	@Test
	void  testConversionServiceLocalDateAndLocalDateTime() {
		assertNotNull(conversionService);
		LocalDate localDate= conversionService.convert("10/10/2011", LocalDate.class);
		assertNotNull(localDate);
		assertTrue(localDate.getDayOfMonth() == 10);
		assertTrue(localDate.getMonthValue() == 10);
		assertTrue(localDate.getYear() == 2011);
		LocalDateTime localDateTime = conversionService.convert("10/10/2011 12:20:50", LocalDateTime.class);
		assertNotNull(localDateTime);
		assertTrue(localDateTime.getDayOfMonth() == 10);
		assertTrue(localDateTime.getMonthValue() == 10);
		assertTrue(localDateTime.getYear() == 2011);
		assertTrue(localDateTime.getHour() == 12);
		assertTrue(localDateTime.getMinute() == 20);
		assertTrue(localDateTime.getSecond() == 50);
		
		LocalDate webLocalDate= mvcConversionService.convert("2021-02-19", LocalDate.class);
		assertNotNull(webLocalDate);
		assertTrue(webLocalDate.getDayOfMonth() == 19);
		assertTrue(webLocalDate.getMonthValue() == 02);
		assertTrue(webLocalDate.getYear() == 2021);
		
		LocalDate localDateNow = LocalDate.now();
		String dateString = conversionService.convert(localDateNow, String.class);
		assertNotNull(dateString);
		System.err.println(dateString);
		
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		String dateTimeString = mvcConversionService.convert(localDateTimeNow, String.class);
		assertNotNull(dateTimeString);
		System.err.println(dateTimeString);
	}
}
