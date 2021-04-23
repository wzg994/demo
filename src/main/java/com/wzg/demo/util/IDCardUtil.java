package com.wzg.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class IDCardUtil {

    public static void main(String[] args) {
//        IDCardUtil idCardUtil=new IDCardUtil();
//        Scanner scanner=new Scanner(System.in);
//        String line= scanner.nextLine();
//        Boolean ss=isValid(line);
//        System.out.println("通过控制台判断"+ss);
        isValid("350125199804191329");
        int aa=5175+1940-3000-500-300-1000-90-897;
//        System.out.println("余额为"+aa);

        int bb=5175-640-750-3300-1000;
        System.out.println("下个月余额为"+bb);
        double money=5175;
        System.out.println("下个月工资"+money);
        int ccc=5*19+(15*10)+200+(2*80)+100+(40+40+200);//25天
        System.out.println("发工资前要用的钱为"+ccc);
        int ssss=4503-4163;
        int dddd=1583+4333+4163;
        int dddd2=1579+2000;
        double dd4=800+839.43+1000+ccc;
        double sssss=6000/12;
        System.out.println("5月待还"+dd4);
        System.out.println("5月剩余"+(money-dd4));
        System.out.println("负债"+dddd2);
        System.out.println("买电脑分六期"+sssss);
        IDCardUtil.isValid("350125199804191329");
        System.out.println(IDCardUtil.isValid("350125199805201234"));
        System.out.println(IDCardUtil.isValid("350125199805201258"));
        System.out.println(IDCardUtil.isValid("412725200105138656"));
        System.out.println(isValid("350125199804191329"));
    }

    /**
     * <pre>
     * 省、直辖市代码表：
     *   11 : 北京 12 : 天津 13 : 河北  14 : 山西 15 : 内蒙古
     *   21 : 辽宁 22 : 吉林 23 : 黑龙江 31 : 上海 32 : 江苏
     *   33 : 浙江 34 : 安徽 35 : 福建  36 : 江西 37 : 山东
     *   41 : 河南 42 : 湖北 43 : 湖南  44 : 广东 45 : 广西 46 : 海南
     *   50 : 重庆 51 : 四川 52 : 贵州  53 : 云南 54 : 西藏
     *   61 : 陕西 62 : 甘肃 63 : 青海  64 : 宁夏 65 : 新疆
     *   71 : 台湾
     *   81 : 香港 82 : 澳门
     *   91 : 国外
     * </pre>
     */
    final static String CITY_CODE[] = {"11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};

    /**
     * 效验码
     */
    final static char[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 加权因子
     * Math.pow(2, i - 1) % 11
     */
    final static int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 身份证验证
     *
     * @param id 号码内容
     * @return 是否有效
     */
    public final static boolean isValid(String id) {
        if (id == null)
            return false;

        int len = id.length();
        if (len != 15 && len != 18)
            return false;

        //校验区位码
        if (!validCityCode(id.substring(0, 2)))
            return false;

        //校验生日
        if (!validDate(id))
            return false;

        if (len == 15)
            return true;

        //校验位数
        return validParityBit(id);

    }

    /**
     * 检验身份证号码最后一位数
     * @param id
     * @return
     */
    private static boolean validParityBit(String id) {
        char[] cs = id.toUpperCase().toCharArray();
        int power = 0;
        for (int i = 0; i < cs.length; i++) {
            //最后一位可以是X
            if (i == cs.length - 1 && cs[i] == 'X')
                break;

            // 非数字
            if (cs[i] < '0' || cs[i] > '9')
                return false;

            // 加权求和
            if (i < cs.length - 1) {
                power += (cs[i] - '0') * POWER[i];
            }
        }
        return PARITYBIT[power % 11] == cs[cs.length - 1];
    }

    /**
     * 检验日期
     * @param id
     * @return
     */
    private static boolean validDate(String id) {
        try {
            String birth = id.length() == 15 ? "19" + id.substring(6, 12) : id.substring(6, 14);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date birthDate = sdf.parse(birth);
            if (!birth.equals(sdf.format(birthDate)))
                return false;
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 校验城市
     * @param cityCode
     * @return
     */
    private static boolean validCityCode(String cityCode) {
        for (String code : CITY_CODE) {
            if (code.equals(cityCode))
                return true;
        }
        return false;
    }

    /**
     * 将15位的身份证转成18位身份证
     *
     * @param id
     * @return
     */
    final public static String id15To18(String id) {
        if (id == null || id.length() != 15)
            return null;

        if (!isValid(id))
            return null;

        String id17 = id.substring(0, 6) + "19" + id.substring(6);

        int power = 0;
        char[] cs = id17.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] - '0') * POWER[i];
        }

        // 将前17位与第18位校验码拼接
        return id17 + String.valueOf(PARITYBIT[power % 11]);
    }

    /**
     * 生成随机整数
     * <p>
     *
     * @param min
     * @param max
     * @return
     */
    public static int rand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1) % (max - min + 1) + min;
    }

    public final static String generateID() {
        // 地址码
        String body = CITY_CODE[rand(0, CITY_CODE.length - 1)] + "0101";

        // 出生年
        String y = String.valueOf(rand(1950, Calendar.getInstance().get(Calendar.YEAR)));
        String m = String.valueOf(rand(1, 12));
        if (m.length() == 1)
            m = "0" + m;
        String d = String.valueOf(rand(1, 28));
        if (d.length() == 1)
            d = "0" + d;

        String idx = String.valueOf(rand(1, 999));
        if (idx.length() == 1)
            idx = "00" + idx;
        else if (idx.length() == 2)
            idx = "0" + idx;

        body += y + m + d + idx;

        // 累加body部分与位置加权的积
        int power = 0;
        char[] cs = body.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] - '0') * POWER[i];
        }

        // 得出校验码

        return body + String.valueOf(PARITYBIT[power % 11]);
    }
}
