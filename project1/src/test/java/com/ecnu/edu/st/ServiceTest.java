package com.ecnu.edu.st;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

	@Test
	void setClockTimeTest(){
		List<Clock> clockList=new ArrayList<>();
		Clock clockBeijing=new Clock();
		clockBeijing.setCity("Beijing");
		clockBeijing.setJetLag(8.0);

		Clock clockMoscow=new Clock();
		clockMoscow.setCity("Moscow");
		clockMoscow.setJetLag(4.0);

		Clock clockLondon=new Clock();
		clockLondon.setCity("London");
		clockLondon.setJetLag(0.0);

		Clock clockSydney=new Clock();
		clockSydney.setCity("Sydney");
		clockSydney.setJetLag(10.0);

		Clock clockNewYork=new Clock();
		clockNewYork.setCity("NewYork");
		clockNewYork.setJetLag(-5.0);

		clockList.add(clockBeijing);
		clockList.add(clockMoscow);
		clockList.add(clockLondon);
		clockList.add(clockSydney);
		clockList.add(clockNewYork);
		//构造时传入phoneTime和酒店与utc时差（北京时间:utc+8）
		Service hotelService=new Service(LocalDateTime.now(),8.0);
		hotelService.setClockTime(clockList);

		String resTime1 = clockList.get(0).getTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
		String rightTime1="201909252005";

		String resTime2 = clockList.get(1).getTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
		String rightTime2="201909251605";

		String resTime3 = clockList.get(2).getTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
		String rightTime3="201909251205";

		String resTime4 = clockList.get(3).getTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
		String rightTime4="201909252205";

		String resTime5 = clockList.get(4).getTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
		String rightTime5="201909250705";




		assertAll(()->assertEquals(rightTime1,resTime1,"北京时间设置错误"),
				()->assertEquals(rightTime2,resTime2,"莫斯科时间设置错误"),
				()->assertEquals(rightTime3,resTime3,"伦敦时间设置错误"),
				()->assertEquals(rightTime4,resTime4,"悉尼时间设置错误"),
				()->assertEquals(rightTime5,resTime5,"纽约时间设置错误"));

	}
}
