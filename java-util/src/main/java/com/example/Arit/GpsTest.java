package com.example.Arit;


import org.apache.log4j.Logger;


/**
 * 类GpsTest.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年3月25日 上午10:34:12
 */
public class GpsTest {
	private static final Logger loger = Logger.getLogger(GpsTest.class);
	private static double EARTH_RADIUS = 6378.137;
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}

	public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
	{
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;
	   double b = rad(lng1) - rad(lng2);
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.asin(a/2),2) + 
	    Math.acos(radLat1)*Math.acos(radLat2)*Math.pow(Math.asin(b/2),2)));
	   s = s * EARTH_RADIUS;
	   s = Math.round(s * 10000) / 10000;
	   return s;
	}
	
	public static void main(String[] args) {
		loger.info(GetDistance(31.109052, 121.057021, 31, 121));
		loger.info(GetDistance(30.895843, 121.163020, 31, 121));
		loger.info(GetDistance(31.146046, 121.111506, 31, 121));
		loger.info(GetDistance(31.146120, 121.111502, 31, 121));
		loger.info(GetDistance(31.233234,121.491909,31,121));
	}
}
