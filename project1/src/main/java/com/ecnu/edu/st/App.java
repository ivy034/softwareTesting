package com.ecnu.edu.st;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
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
        for (Clock clock:clockList){
            System.out.println(clock.getCity()+"："+clock.getTime());
        }

    }
}
