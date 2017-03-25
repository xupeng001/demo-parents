package com.example.Arit;
/**
 * Create Date : 2012-11-01
 */


import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class ArithUtil {

	/**
	 * 计算折扣：前一个数为分子，后一个数为分母
	 * @param d1
	 * @param d2
	 * @return
	 */
    public static double div(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * ************************************************************************
     * 功    能：提供精确的加法运算
     * 入口参数：d1：被加数 d2：加数
     * 出口参数：
     * 返    回：double型： 两个参数的和
     * 修改备注：
     * ************************************************************************
     */
    public static double add(String d1, String d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }
    public static double add(double d1, double d2) {
        return add(Double.toString(d1), Double.toString(d2));
    }
    
    /**
     * 提供精确的减法运算
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 精确指定小数位数
     * @param d
     * @param scale
     * @return
     */
    public static double round(double d, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(d));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 精确乘法运算
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 个位数及小数点后有大于0的数时，进位到10位上
     * @param price
     * @return
     */
    public static String arithNumber(String price) {
		String[] ss = price.split("[.]");
		String intNumVal1 = ss[0];
		String intNumVal2 = ss[1];
		//小数点后面的数大于0
		if (Integer.parseInt(intNumVal2)>0) {
			intNumVal1 = ""+(Integer.parseInt(intNumVal1)+1);
		}
		String num = "";
		if (intNumVal1.length()>1){
			String leftNumber = intNumVal1.substring(0, (intNumVal1.length()-1));
			String lastNumber = ""+intNumVal1.charAt(intNumVal1.length()-1);
			//整数部分的最后一位数大于0
			if (Integer.parseInt(lastNumber)>0) {
				leftNumber = ((Integer.parseInt(leftNumber)+1)+"0");
			} else {
				leftNumber += "0";
			}
			num = leftNumber;
		} else {
			num = intNumVal1;
		}
		return num;
	}
	
	/**
	 * 将数据取整，直接去除小数据点后的小数
	 * @param price
	 * @return
	 */
    public static String getIntegerData(Double price) {
    	return getIntegerData(price.toString());
    }
    public static String getIntegerData(String price) {
		String data = "0";
		if (StringUtils.isEmpty(price)) {
			return data;
		}
		data = price.split("[.]")[0];
		return data;
	}
	
	/**
	 * 做降价处理，已做四舍五入
	 * @param price
	 * @return
	 */
    public static String getSalesPricePercentage(String price, String decimal) {
    	return getSalesPricePercentage(price, Double.parseDouble(decimal));
    }
    public static String getSalesPricePercentage(String price, Double decimal) {
		Double db = round(mul(new Double(price), sub(1D,decimal)),2);
		/**************/
		return arithNumber(db.toString());
		/**************
		String[] ss = db.toString().split("[.]");
		Integer temp = 0;
		if (Integer.parseInt(ss[1])>=50){
			temp = Integer.parseInt(ss[0])+1;
		} else {
			temp = Integer.parseInt(ss[0]);
		}
		return temp.toString();
		/**************/
	}
		
	/**
	 * 计算票面折扣，票面价格除Y舱价格，然后取整，此值仅在客户端做显示用
	 * @param fprice
	 * @param yPrice
	 * @return
	 */
	public static String resetDiscountCalculation(String fprice, String yPrice) {
		String result = "100";
		if ("0".equals(fprice) || "0".equals(yPrice)
				|| new Double(fprice)>new Double(yPrice)){
			return result;
		}
		String[] ss = discountCalculation(fprice, yPrice).split("[.]");
		int data = Integer.parseInt(ss[1]);
		if (data < 50) {
			result = ss[0];
		} else {
			result = ""+(Integer.parseInt(ss[0]) + 1);
		}
		return result;
	}
	
	/**
	 * 计算折扣:折扣=票面价除以Y舱票面价，4舍5入
	 * @param fprice
	 * @param yPrice
	 * @return
	 */
	public static String discountCalculation(String fprice, String yPrice) {
		Double result = ArithUtil.div(new Double(fprice), new Double(yPrice));
		result = ArithUtil.round(result*100, 2);
		return result.toString();
	}

	public static void main(String[] args) {
		Double db = round(mul(new Double("1300"), sub(1D,0.21)),2);
		System.out.println(db);
		Double db1 = round(mul(new Double("1300"), sub(1D,div(Double.parseDouble("21"), 100D))),2);
		System.out.println(db1);
		/**************
		//Double d = ArithUtil.sub(Double.parseDouble("95"), ((0.03D*100)));
		//System.out.println(getIntegerData(d.toString()));
		System.out.println(div(85, 100D));
		System.out.println(getSalesPricePercentage("1000", div(5.4, 100D)));
		
		System.out.println(resetDiscountCalculation("850", "1130"));
		System.out.println(getIntegerData(0.6D*100));
		/**************/
		
		System.out.println(getIntegerData(mul(1110, div(50,100))));
	}
}
