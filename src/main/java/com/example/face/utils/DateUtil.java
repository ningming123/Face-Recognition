package com.example.face.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期格式处理
 *
 * @author 孔垂云
 * @date 2017-05-23
 */
public class DateUtil {
    private static final String defaultDateFormatStr = "yyyy-MM-dd";// 系统默认的格式化字符串
    private static final String defaultTimeFormatStr = "yyyy-MM-dd HH:mm:ss";// 系统默认的格式化字符串
    public static final String defaultMonthFormatStr = "yyyy-MM";// 系统默认的格式化字符串

    /**
     * 日期转字符串
     *
     * @param date
     * @param formatStr 格式化字符串
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        DateFormat df = new SimpleDateFormat(formatStr);
        return df.format(date);
    }

    /**
     * 字符串转换到时间格式
     *
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串 比如 yyyy-MM-dd
     * @return Date 返回转换后的时间
     */
    public static Date stringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 取得系统时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return
     * @author 孔垂云
     * @date 2017-05-23
     */
    public static String getSystemTime() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat(defaultTimeFormatStr);
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * 取得系统日期，格式为yyyy-MM-dd
     *
     * @return
     */
    public static String getSystemDate() {
        String strDate = "";
        SimpleDateFormat df = new SimpleDateFormat(defaultDateFormatStr);
        strDate = df.format(new Date());
        return strDate;
    }

    /**
     * 取得系统时间
     *
     * @return
     */
    public static String getShortSystemTime() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * 取得系统短日期，yyyyMMdd
     *
     * @return
     */
    public static String getShortSystemDate() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * 系统时间加减
     *
     * @param date      当前日期
     * @param dayNum    加减的日期数
     * @param formatStr 格式化字符串
     * @return
     */
    public static String getOperaDate(String date, int dayNum, String formatStr) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(5, dayNum);
        return df.format(gc.getTime());
    }

    /**
     * 系统时间加减，默认日期格式
     *
     * @param date   当前日期
     * @param dayNum 加减的日期数
     * @return
     */
    public static String getOperaDate(String date, int dayNum) {
        return getOperaDate(date, dayNum, defaultDateFormatStr);
    }

    /**
     * 系统月份加减
     *
     * @param date      日期字符串
     * @param monthNum  月份数
     * @param formatStr 格式化字符串
     * @return
     */
    public static String getOperaMonth(String date, int monthNum, String formatStr) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(2, monthNum);
        return df.format(gc.getTime());
    }

    /**
     * 系统月份加减
     *
     * @param date
     * @param monthNum
     * @return
     */
    public static String getOperaMonth(String date, int monthNum) {
        return getOperaMonth(date, monthNum, defaultDateFormatStr);
    }

    /**
     * 取得两个日期的时间差--得到天数差
     *
     * @param date1     日期1
     * @param date2     日期2
     * @param formatStr 格式化字符串
     * @return
     */
    public static int getDateDifference(String date1, String date2, String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        ParsePosition pos = new ParsePosition(0);
        ParsePosition pos1 = new ParsePosition(0);
        Date dt1 = formatter.parse(date1, pos);
        Date dt2 = formatter.parse(date2, pos1);
        int l = (int) ((dt2.getTime() - dt1.getTime()) / (3600 * 24 * 1000));
        return l;
    }

    /**
     * 取得两个日期的时间差，两个都是字符串
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getDateDifference(String date1, String date2) {
        return getDateDifference(date1, date2, defaultDateFormatStr);
    }

    /**
     * 取得两个日期的时间差,两个都是日期型
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getHourDifference(Date date1, Date date2) {
        int l = (int) (date1.getTime() - date2.getTime()) / (3600 * 1000);
        return l;
    }


    /**
     * 取得两个日期的时间差,两个都是日期型
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getMinuteDifference(Date date1, Date date2) {
        int l = (int) (date1.getTime() - date2.getTime()) / (60 * 1000);
        return l;
    }

    /**
     * 取得两个日期的月份差
     *
     * @param date1     日期1
     * @param date2     日期2
     * @param formatStr 格式化字符换
     * @return
     */
    public static int getMonthDifference(String date1, String date2, String formatStr) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 取得两个日期的月份差
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getMonthDifference(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return result;
    }

    /**
     * 取得两个日期的年度差
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getYearDifference(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        return result;
    }

    /**
     * 取得当月最后一天
     *
     * @return
     */
    public static String getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
        cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
        return new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
    }

    /**
     * 取得当月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月初是几号
    }

    /**
     * 取得上个月的第一天
     *
     * @return
     * @author 孔垂云
     * @date 2017-05-23
     */
    public static String getFirstDayOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, -1);// 月份减一，得到上个月的一号
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月初是几号
    }

    /**
     * 取得下个月的最后一天
     *
     * @return
     */
    public static String getLastDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 2);// 月份加一，得到下下个月的一号
        cal.add(Calendar.DATE, -1);// 下下一个月减一为下个月最后一天
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月末是几号
    }

    /**
     * 取得当月最后一天
     *
     * @param date 当前日期
     * @return
     */
    public static String getLastDayOfMonth(String date) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(defaultDateFormatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
        cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
        return df.format(cal.getTime());// 获得月末是几号
    }

    /**
     * 获取某个时间段的所有天数集合(包含起始日期与终止日期)
     *
     * @param starDate
     * @param endDate
     * @return
     */
    public static List<String> getDayList(String starDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat(defaultDateFormatStr);
        List<String> dayList = new ArrayList<String>();
        if (starDate.equals(endDate)) {
            dayList.add(starDate);
        } else if (starDate.compareTo(endDate) < 0) {
            while (starDate.compareTo(endDate) <= 0) {
                dayList.add(starDate);
                long l = stringToDate(starDate, "yyyy-MM-dd").getTime();
                starDate = format.format(l + 3600 * 24 * 1000);
            }
        } else {
            dayList.add(endDate);
        }
        return dayList;
    }

    /**
     * what: 根据字符串日期 求前一天的18点日期和今天的18点日期数组
     *
     * @param dateStr
     * @return
     * @author 刘艳超 created on 2018年2月3日
     */
    public static Object[] get18Dates(String dateStr) {
        String dateStr1 = dateStr + " 18:00:00";
        String dateStr2 = dateStr + " 17:59:59";
        Date date1 = DateUtil.stringToDate(DateUtil.getOperaDate(dateStr1, -1, "yyyy-MM-dd HH:mm:ss"),
                "yyyy-MM-dd HH:mm:ss");
        Date date2 = DateUtil.stringToDate(dateStr2, "yyyy-MM-dd HH:mm:ss");
        Object[] objs = {date1, date2};
        return objs;
    }

    /**
     * what: 根据字符串日期 求前一天的18点日期和今天的18点日期数组
     *
     * @param dateStr
     * @return
     * @author 刘艳超 created on 2018年2月3日
     */
    public static Object[] get18Dates2(String dateStr) {
        String date1 = DateUtil.getOperaDate(dateStr, -1);
        String date2 = dateStr;
        Object[] objs = {date1 + " 18:00:00", date2 + " 17:59:59"};
        return objs;
    }

    /**
     * what: 判断是否是时间格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param resultDate
     * @return
     * @author LiHong created on 2018年2月26日
     */
    public static int dateRegex(String resultDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date ndate = format.parse(resultDate);
            String str = format.format(ndate);
            // success
            if (str.equals(resultDate))
                return 1;
            else
                return 0;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return -1;
        }

    }

    /**系统时间 加减小时
     *
     * @param dateTime
     * @param hourNum
     * @param formatStr
     * @return
     */
    public static String getOperaHour(String dateTime, int hourNum,String formatStr ){
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.HOUR_OF_DAY, hourNum);
        return df.format(gc.getTime());
    }

    /**系统时间 加减小时
     *
     * @param dateTime
     * @param hourNum
     * @return
     */
    public static String getOperaHour(String dateTime, int hourNum){
        return getOperaHour(dateTime,hourNum,defaultTimeFormatStr);
    }

    /**
     * 监控大屏异步后台获取查询时间段开始和截止时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 下标0为开始时间1为结束时间
     */
    public static String[] getDateTime() {
        String[] resultDate = new String[2];
        //开始时间
        String start = "";
        //结束时间
        String end = "";
        //当前日期
        String curDate = DateUtil.getSystemDate();
        //当前完整时间 yyyy-MM-dd HH:mm:ss
        String curDateTime = DateUtil.getSystemTime();
        //上一个日期
        String preDate = DateUtil.getOperaDate(curDate, -1);
        //下一个日期
        String nextDate = DateUtil.getOperaDate(curDate, +1);
        //当前日期的时分秒
        String time = curDateTime.split(" ")[1];//取得时间
        Integer hh = Integer.valueOf(time.split(":")[0]);//小时
        Integer mi = Integer.valueOf(time.split(":")[1]);//分钟
        //判断当前日期的分钟数
        if (30 > mi) {
            //取得上一个时间的30分——当前时间的00分
            if (hh == 0) {
                //0点
                start = preDate + " 23:30:00";
                end = curDate + " 00:00:00";
            } else {
                //不是0点
                if (hh < 10) {
                    start = curDate + " 0" + (hh - 1) + ":30:00";
                    end = curDate + " 0" + hh + ":00:00";
                } else if (hh == 10) {
                    start = curDate + " 0" + (hh - 1) + ":30:00";
                    end = curDate + " " + hh + ":00:00";
                } else {
                    start = curDate + " " + (hh - 1) + ":30:00";
                    end = curDate + " " + hh + ":00:00";
                }
            }
        } else {
            //取得当前小时的00-30
            start = curDate + " " + time.split(":")[0] + ":00:00";
            end = curDate + " " + time.split(":")[0] + ":30:00";
        }
        resultDate[0] = start;
        resultDate[1] = end;
        return resultDate;
    }
    /**
     * 求昨天十八点到当前时间的数组。
     * @return
     */
    public static String[] getDateHourTimes() {
        //当前完整时间 yyyy-MM-dd HH:mm:ss
        String curDateTime = DateUtil.getSystemTime();
        //当前日期的时分秒
        String time = curDateTime.split(" ")[1];//取得时间
        Integer hh = Integer.valueOf(time.split(":")[0]);//小时
        //判断当前日期的分钟数
        if (hh>=18){//今天18点以后到零点
            String[] resultDate = new String[24];
            for (int i=18;i<24;i++){
                resultDate[i-18]=i+"";
            }
            for (int i=0;i<18;i++){
                resultDate[i+6]=i+"";
            }
            return resultDate;
        }else {//今天零点今天当前时间 展示昨天18点到当前时间
            String[] resultDate = new String[6+hh];
            for (int i=18;i<24;i++){
                resultDate[i-18]=i+"";
            }
            for (int i=0;i<hh;i++){
                resultDate[6+i]=i+"";
            }
            return resultDate;
        }
    }
    /**
     * 监控大屏 ，分局分类型 获取startTime和endTime
     * @return
     */
    public static String[] getFjflTimes() {
        //获取当前时间
        String curDateTime = getSystemTime();
        String[] result = new String[2];
        String curDate = curDateTime.split(" ")[0];//取得时间
        String preDate = DateUtil.getOperaDate(curDate, -1);
        String time = curDateTime.split(" ")[1];//取得时间
        Integer hh = Integer.valueOf(time.split(":")[0]);//小时
        String startTime = null;
        String endTime = null;
        if (hh >= 18) {//今天18点以后到零点 展示昨天18点到今天今天18点数据
            startTime = preDate + " 18:00:00";
            endTime = curDate + " 17:59:59";
        }else {//今天零点今天当前时间 展示昨天18点到当前时间
            startTime = preDate + " 18:00:00";
            if (hh==0){
                endTime = preDate + " 23:59:59";
            }else {
                endTime = curDate + " "+((hh-1)<10?"0"+(hh-1):(hh-1))+":59:59";
            }
        }
        result[0]=startTime;
        result[1]=endTime;
        return result;
    }

    /**
     * 获取系统的年月yyyy-MM
     * @return 系统的年月yyyy-MM
     */
    public static String getSystemMonth() {
        String systemMonth = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultMonthFormatStr);
        systemMonth = simpleDateFormat.format(new Date());
        return systemMonth;
    }

    /**
     * 获取一个月的第一天
     * @param month 年月 yyyy-MM
     * @return 该月第一天
     */
    public static String getFirstDayOfMonth(String month) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultMonthFormatStr);
        Date date = null;
        try {
            date = simpleDateFormat.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            cal.setTime(date);
        }
        // 日，设为一号
        cal.set(Calendar.DATE, 1);
        // 获得月初是几号
        return new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
    }

    /**
     * 获取一个月的最后一天
     * @param month 年月 yyyy-MM
     * @return 该月最后一天
     */
    public static String getLastDayOfMonth2(String month) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultMonthFormatStr);
        Date date = null;
        try {
            date = simpleDateFormat.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            cal.setTime(date);
        }
        //下月1号
        cal.add(Calendar.MONTH, 1);
        //减一天，本月最后一天
        cal.add(Calendar.DAY_OF_MONTH, -1);
        // 获得月初是几号
        return new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
    }

    /**
     * 获取上个月 yyyy-MM
     * @return 上个月
     */
    public static String getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        return new SimpleDateFormat(defaultMonthFormatStr).format(calendar.getTime());
    }

    /**
     * 根据年月yyyy-MM，获取本月的日期集合
     * @param month 年月yyyy-MM
     * @return 本月的日期集合
     */
    public static List<String> getDaysList(final String month) {
        List<String> daysList = new ArrayList<>();
        //本月
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat monthFormat = new SimpleDateFormat(defaultMonthFormatStr);
        SimpleDateFormat daysFormat = new SimpleDateFormat(defaultDateFormatStr);
        try {
            calendar.setTime(monthFormat.parse(month));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int thisMonth = calendar.get(Calendar.MONTH);
        //第一天
        calendar.set(Calendar.DATE, 1);
        while (calendar.get(Calendar.MONTH) == thisMonth) {
            daysList.add(daysFormat.format(calendar.getTime()));
            //加一天
            calendar.add(Calendar.DATE, 1);
        }
        return daysList;
    }

    /**
     * @Desc: 根据 年、月 获取对应的月份 的 天数
     * @MethodName: getDaysByYearMonth
     * @Parameters: [year, month]
     * @Return: int
     * @author: 王泽
     * @Date: 2019/3/23 17:35
     */
    public static int getDaysByYearMonth(int year, int month)
    {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * @Desc: 获取系统当前年份
     * @MethodName: getSysYear
     * @Parameters: []
     * @Return: java.lang.String
     * @author: 王泽
     * @Date: 2019/3/23 17:40
     */
    public static int getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return Integer.parseInt(year);
    }

    /**
     * @Desc: 获取系统当前月份
     * @MethodName: getSysMonth
     * @Parameters: []
     * @Return: java.lang.String
     * @author: 王泽
     * @Date: 2019/3/23 17:40
     */
    public static Integer getSysMonth() {
        Calendar date = Calendar.getInstance();
        String month = String.valueOf(date.get(Calendar.MONTH));
        return Integer.parseInt(month) + 1;
    }

    /**
     * @Desc: 获取系统当前日期
     * @MethodName: getSysDay
     * @Parameters: []
     * @Return: java.lang.Integer
     * @author: 王泽
     * @Date: 2019/3/26 10:18
     */
    public static Integer getSysDay(){
        Calendar date = Calendar.getInstance();
        String day = String.valueOf(date.get(Calendar.DATE));
        return Integer.parseInt(day);
    }

    /**
     * @Desc: 计算两个日期的差值
     * @MethodName: getDiffDate
     * @Parameters: [startDate, endDate]
     * @Return: int
     * @author: 王泽
     * @Date: 2019/3/28 9:30
     */
    public static int getDiffDate(String startDate, String endDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = formatter.parse(startDate);
            d2 = formatter.parse(endDate);
        } catch (ParseException e) {
        }
        Long daysBetween = (d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
        return Integer.parseInt(daysBetween.toString());
    }

    public static int getBetweenMonth(String startMonth, String endMonth){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(endMonth));
            aft.setTime(sdf.parse(startMonth));
        } catch (ParseException e) {
        }
        int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        surplus = surplus <= 0 ? 1 : 0;
        return Math.abs(month + result) + surplus;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStamp(String s) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    public static void main(String[] args) {
        // System.out.println(DateUtil.getMonthDifference("2017-05-21",
        // "2017-03-11"));
        //Object[] objs = get18Dates("2018-02-03 18:00:00");
//        System.out.println(dateRegex(""));
        //System.out.println(objs[0] + "------" + objs[1]);
//        String perDate = DateUtil.getOperaDate(DateUtil.getSystemDate(), -1);
//        System.out.println(perDate);
//        System.out.println(getOperaMonth(getSystemMonth(), -1, defaultMonthFormatStr));
        System.out.println(getDaysList("2018-02"));
    }

    /**
     *
     * @Description: 获取本周日期
     * @parameters []
     * @return java.util.List<java.lang.String>
     * @exception
     * @author MSQ
     * @date 2019/6/24 10:22
     * @version 1.0
     * @since java 1.8
     */
    public static List<String> getWeekDay(String format) {
        Calendar cal = Calendar.getInstance();
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(1 == dayWeek){
            cal.add(Calendar.DAY_OF_MONTH , 1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        Date startDate = cal.getTime();
        cal.add(Calendar.DATE, 6);
        Date endDate = cal.getTime();
        return getWeekDay(startDate, endDate, format);
    }

    /**
     *
     * @Description: 获取上周日期
     * @parameters []
     * @return java.util.List<java.lang.String>
     * @exception
     * @author MSQ
     * @date 2019/6/24 10:22
     * @version 1.0
     * @since java 1.8
     */
    public static List<String> getLastWeekDay(String format) {
        Calendar scal = Calendar.getInstance();
        Calendar ecal = Calendar.getInstance();
        int dayOfWek = scal.get(Calendar.DAY_OF_WEEK) - 1;
        int s = 1 - dayOfWek;
        int e = 7 - dayOfWek;
        scal.add(Calendar.DATE, s - 7);
        ecal.add(Calendar.DATE, e - 7);
        return getWeekDay(scal.getTime(), ecal.getTime(), format);
    }

    /**
     *
     * @Description: 判断当前日期是否是今天
     * @parameters [date, format]
     * @return boolean true:是当天，false:不是当天
     * @exception
     * @author MSQ
     * @date 2019/6/25 15:16
     * @version 1.0
     * @since java 1.8
     */
    public static boolean isToday(String date, String format){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currentDay = sdf.format(cal.getTime());
        if(date.equals(currentDay)){
            return true;
        }
        return false;
    }

    /**
     *
     * @Description: 日期与当前天比较
     * @parameters [date, format]
     * @return boolean true:小于等于，false:大于
     * @exception
     * @author MSQ
     * @date 2019/6/25 15:21
     * @version 1.0
     * @since java 1.8
     */
    public static boolean compareToday(String date, String format){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currentDay = sdf.format(cal.getTime());
        if(date.compareTo(currentDay) <= 0){
            return true;
        }
        return false;
    }

    /**
     *
     * @Description: 获取日期间的天数
     * @parameters [startDate, endDate]
     * @return java.util.List<java.lang.String>
     * @exception
     * @author MSQ
     * @date 2019/6/24 10:22
     * @version 1.0
     * @since java 1.8
     */
    private static List<String> getWeekDay(Date startDate, Date endDate, String format){
        List<String> dayList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        dayList.add(sdf.format(startDate));
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        while(endCal.after(startCal)){
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            dayList.add(sdf.format(startCal.getTime()));
        }
        return dayList;
    }

    /**
     *  获取当前时间的小时数
     */
    public static int getHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

}

