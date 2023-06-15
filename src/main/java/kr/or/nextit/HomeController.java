package kr.or.nextit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final Logger logger
		= LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logger", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.trace("(logger.trace)Welcome home! The client locale is {}.", locale);
		logger.debug("(logger.debug)Welcome home! The client locale is {}.", locale);
		logger.info("(logger.info)Welcome home! The client locale is {}.", locale);
		logger.warn("(logger.warn)Welcome home! The client locale is {}.", locale);
		logger.error("(logger.error)Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		/*
		 request.setAttribute("serverTime", formattedDate );
		 스프링에서는  request.setAttribute() 대신에 model.addAttribute()를 사용합니다.
		 차이점은 request가 더 넓은 범위로 사용가능합니다.ㅣ
		 예를 들면 request는 호출한 해당 view 페이지에서 include 한 페이지에서도 사용가능합니다.
		   
		 */
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
