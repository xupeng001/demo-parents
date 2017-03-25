package com.example.timer;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.Logger;

public class TimerUtil{
	public static int counttest = 0;
    private static final Logger loger = Logger.getLogger(TimerUtil.class);
    public static void showTimer() {
    	 TimerTask task = new TimerTask() {
            @Override
             public void run() {
            	
             }
         };
         
//	 		设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
//		定制每天的21:09:00执行，
        calendar.set(year, month, day, 23, 59, 59);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        loger.info(date);
//	      	 每天的date时刻执行task，每隔2秒重复执行
//	        timer.schedule(task, 0, 60000);
//	                             每天的date时刻执行task, 仅执行一次
//	        timer.schedule(task, date);
    }
}