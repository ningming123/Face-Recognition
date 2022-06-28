package com.example.face.utils.string;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户字符串操作
 * 
 * @author kcy
 * 
 */
public class StringUtil {

    /**
     * 判断是否是整数
     * 
     * @param integer
     * @return
     */
    public static boolean isInteger(String integer) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher(integer);
        boolean b = m.matches();
        return b;
    }

    /**
     * 判断是否是正整数
     * 
     * @param integer
     * @return
     */
    public static boolean isInteger2(String integer) {
        Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        Matcher m = p.matcher(integer);
        boolean b = m.matches();
        return b;
    }

    public static String getAdm(String code) {
        if (code.equals("B"))
            return "哈尔滨铁路局";
        else if (code.equals("T"))
            return "沈阳铁路局";
        else if (code.equals("P"))
            return "北京铁路局";
        else if (code.equals("V"))
            return "太原铁路局";
        else if (code.equals("C"))
            return "呼和浩特铁路局";
        else if (code.equals("F"))
            return "郑州铁路局";
        else if (code.equals("N"))
            return "武汉铁路局";
        else if (code.equals("Y"))
            return "西安铁路局";
        else if (code.equals("K"))
            return "济南铁路局";
        else if (code.equals("H"))
            return "上海铁路局";
        else if (code.equals("G"))
            return "南昌铁路局";
        else if (code.equals("Q"))
            return "广铁集团";
        else if (code.equals("Z"))
            return "南宁铁路局";
        else if (code.equals("W"))
            return "成都铁路局";
        else if (code.equals("M"))
            return "昆明铁路局";
        else if (code.equals("J"))
            return "兰州铁路局";
        else if (code.equals("R"))
            return "乌鲁木齐铁路局";
        else if (code.equals("O"))
            return "青藏铁路公司";
        else if (code.equals(""))
            return "";
        else
            return "其他";

    }

    /**
     * 根据报表类型，报表日期取得要显示的报表日期
     * 
     * @param repType
     * @param repDate
     * @return
     */
    public static String getOperaDate(String repType,
                                      String repDate) {
        if (repType.equals("D")) {
            return repDate.substring(0, 4) + "年" + repDate.substring(4, 6) + "月" + repDate.substring(6, 8) + "日";
        } else if (repType.equals("T")) {
            String xun = "";
            String day = repDate.substring(6, 8);
            if (Integer.parseInt(day) <= 10)
                xun = "上旬";
            else if (Integer.parseInt(day) <= 20)
                xun = "中旬";
            else if (Integer.parseInt(day) <= 31)
                xun = "下旬";
            return repDate.substring(0, 4) + "年" + repDate.substring(4, 6) + "月" + xun;
        } else if (repType.equals("M")) {
            return repDate.substring(0, 4) + "年" + repDate.substring(4, 6) + "月";
        } else if (repType.equals("Q")) {
            String month = repDate.substring(4, 6);
            String quarter = "";
            if (month.equals("01") || month.equals("02") || month.equals("03"))
                quarter = "一季度";
            else if (month.equals("04") || month.equals("05") || month.equals("06"))
                quarter = "二季度";
            else if (month.equals("07") || month.equals("08") || month.equals("09"))
                quarter = "三季度";
            else if (month.equals("10") || month.equals("11") || month.equals("12"))
                quarter = "四季度";
            return repDate.substring(0, 4) + "年" + quarter;
        } else if (repType.equals("Y")) {
            return repDate.substring(0, 4) + "年";
        } else
            return "";
    }

    /**
     * 处理报表类型在report_description中的字段
     * 
     * @param kind
     * @return
     */
    public static String dealReportKind(String kind) {
        if (kind.equalsIgnoreCase("D"))
            return "isD=1";
        else if (kind.equalsIgnoreCase("T"))
            return "isT=1";
        else if (kind.equalsIgnoreCase("M"))
            return "isM=1";
        else
            return "";
    }

    /**
     * 根据字段序号取得数据表对应的字段名称
     * 
     * @param id
     * @return
     */
    public static String dealFieldStr(int id) {
        if (id < 10)
            return "data_00" + id;
        else if (id < 100)
            return "data_0" + id;
        else
            return "data_" + id;
    }

    public static String dealFieldStr(String report_name,
                                      int id) {
        if (id < 10)
            return report_name + "_00" + id;
        else if (id < 100)
            return report_name + "_0" + id;
        else
            return report_name + "_" + id;
    }

    /**
     * 把前台传过来的含中文的url字符串转换成标准中文，比如%25E5%258C%2597%25E4%25BA%25AC转换成北京
     */
    public static String decodeUrl(String url) {
        String str = "";
        try {
            str = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 取字符除最后一位的子串，比如 aaa,bbb, 返回aaa,bbb
     * 
     * @param str
     * @return
     */
    public static String subTract(String str) {
        if (str.length() == 0)
            return "";
        else
            return str.substring(0, str.length() - 1);
    }

    /**
     * 判断字符串是null或空
     * 
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        else
            return false;
    }

    /**
     * 把字符串里面的\r\n替换掉，json处理
     * 
     * @param str
     * @return
     */
    public static String dealJsonFormat(String str) {
        str = str.replace("\r", "");
        str = str.replace("\n", "");
        return str;
    }

    /**
     * 把字符串里面的"-"和空格" "替换掉，并截取年月日成八位数日期字符串（18点日期格式），日期处理
     * 
     * @param str
     * @return
     */
    public static String dealDateFormat(String str) {
        str = str.replace("-", "");
        str = str.replace(" ", "");
        str = str.substring(0, 8);
        return str;
    }

    public static boolean checkFileExist(String path) {
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            return true;
        } else
            return false;
    }

    /**
     * 判断字符串不是null或空
     * 
     * @param str
     * @return
     */
    public static boolean isNotNullOrEmpty(String str) {
        if (str != null && !str.equals("") && !str.equals("null"))
            return true;
        else
            return false;
    }

    /**
     * 如果为null不trim
     * 
     * @param str
     * @return
     */
    public static String isNullNoTrim(String str) {
        if (!(str == null)) {

            return str.trim();
        } else {
            return str;
        }
    }

    /**
     * 格式化小数
     * 
     * @param val
     * @param point小数位
     * @return
     */
    public static String formatDouble(String val,
                                      int point) {
        String str = "";
        DecimalFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(point);
        str = nf.format(Double.parseDouble(val));
        return str.replace(",", "");
    }

    /**
     * 格式化小数
     * 
     * @param val
     * @param point小数位
     * @return
     */
    public static double formatDouble(double val,
                                      int point) {
        String str = "";
        DecimalFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(point);
        str = nf.format(val);
        return Double.parseDouble(str.replace(",", ""));
    }

    /**
     * 格式化两位小数
     * 
     * @param val
     * @param point
     * @return
     */
    public static String formatDouble(String val) {
        String str = "";
        DecimalFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(2);
        str = nf.format(Double.parseDouble(val));
        return str.replace(",", "");
    }

    /**
     * 格式化两位小数
     * 
     * @param val
     * @param point
     * @return
     */
    public static double formatDouble(double val) {
        String str = "";
        DecimalFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(2);
        str = nf.format(val);
        return Double.parseDouble(str.replace(",", ""));
    }

    /**
     * 格式化金钱
     * 
     * @param val
     * @param point
     * @return
     */
    public static String formatAmount(double val) {
        NumberFormat nf = new DecimalFormat("#,###.##");
        String str = nf.format(val);
        return str;
    }

    /**
     * 判断是否是ajax请求
     * 
     * @param request
     * @return
     */
    public static boolean checkAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else
            return false;
    }

    /**
     * 把数字补零，比如传入T001，需要处理成T002，如果超出最大长度，返回"";
     * 
     * @param 代码前缀
     * @param code已经存在的最大代码
     * @param 数字长度
     * @return
     */
    public static String addZero(String pre,
                                 String code,
                                 int numLength) {
        String str = "";
        if (StringUtil.isNullOrEmpty(code)) {
            str = pre;
            for (int i = 0; i < numLength - 1; i++) {
                str += "0";
            }
            str += "1";
        } else {
            str = pre;
            int num = Integer.parseInt(code.substring(pre.length(), code.length())) + 1;
            for (int i = 0; i < numLength - String.valueOf(num).length(); i++) {
                str += "0";
            }
            str += num;
        }
        if (str.length() > pre.length() + numLength)
            return "";
        else
            return str;
    }

    /*
     * public static String addZeroByType(String pre, String code) { String str
     * = ""; if (StringUtil.isNullOrEmpty(code)) { str = pre; for (int i = 0; i
     * < numLength - 1; i++) { str += "0"; } str += "1"; } else { str = pre; int
     * num = Integer.parseInt(code.substring(pre.length(), code.length())) + 1;
     * int numLength1 =
     * code.substring(pre.length(),code.length()-String.valueOf(
     * num).length()).length(); for (int i = 0; i < numLength; i++) { str +=
     * "0"; } str += num; } if (str.length() > pre.length() + numLength) return
     * ""; else return str; }
     */
    /**
     * 获取ip地址
     * 
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String szClientIP = request.getHeader("x-forwarded-for");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("WL-Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getRemoteAddr();
        return szClientIP;
    }

    /**
     * 获取物料类型的数字编号，比如T001，就是001
     * 
     * @param protype
     * @return
     */
    public static String getProtypeNum(String protype) {
        if (protype != null && protype.length() >= 4)
            return protype.substring(1, 4);
        else
            return "";
    }

    /**
     * 把输入框内的文字转换成html
     * 
     * @param str
     * @return
     */
    public static String text2Html(String str) {
        if (str == null) {
            return "";
        } else if (str.length() == 0) {
            return "";
        }
        str = str.replaceAll("\n", "<br/>");
        str = str.replaceAll("\r", "<br/>");
        str = str.replaceAll(" ", "&nbsp");
        str = str.replaceAll("\t", "&nbsp&nbsp");
        return str;
    }

    /**
     * 转换提交的中文参数 ，只有当url中含有中文时才需要转换，ajax提交的param带中文不需要转换
     * 
     * @param value
     * @return
     */
    public static String decodeParam(String value) {
        String str = "";
        if (value == null)
            return "";
        else {
            try {
                str = URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    /**
     * 数字补齐
     * 
     * @param num
     * @param length 结果字符串总长度
     * @param pre true-前补零 false-后补零
     * @return
     */
    public static String paddingZero(int num,
                                     int length,
                                     boolean pre) {
        String numStr = num + "";
        if (numStr.length() >= length)
            return numStr;

        if (pre) { // 前补零
            for (int i = 0, len = length - numStr.length(); i < len; i++) {
                numStr = "0" + numStr;
            }
        } else {
            for (int i = 0, len = length - numStr.length(); i < len; i++) {
                numStr = numStr + "0";
            }
        }

        return numStr;
    }

    /**
     * 同 paddingZero(int num, int length, boolean pre),默认前补零
     * 
     * @param num
     * @param length
     * @return
     */
    public static String paddingZero(int num,
                                     int length) {
        return paddingZero(num, length, true);
    }

    /**
     * 取到当前机器的IP地址
     * 
     * @return
     */
    public static String getIp() {
        String hostIp = null;
        if (hostIp == null) {
            List<String> ips = new ArrayList<String>();
            Enumeration<NetworkInterface> netInterfaces = null;
            try {
                netInterfaces = NetworkInterface.getNetworkInterfaces();
                while (netInterfaces.hasMoreElements()) {
                    NetworkInterface netInterface = netInterfaces.nextElement();
                    Enumeration<InetAddress> inteAddresses = netInterface.getInetAddresses();
                    while (inteAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inteAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                            ips.add(inetAddress.getHostAddress());
                        }
                    }
                }
            } catch (SocketException ex) {
                ex.printStackTrace();
            }
            hostIp = collectionToDelimitedString(ips, ",");
        }
        return hostIp;
    }

    private static String collectionToDelimitedString(Collection<String> coll,
                                                      String delim) {
        if (coll == null || coll.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    /**
     * 过滤null 并返回string字符串
     * 
     * @param str
     * @return
     */
    public static String NullToStirng(Object str) {
        if (str != null) {
            return str.toString();
        } else {
            return "";
        }

    }

    /**
     * 过滤null 并返回string字符串
     * 
     * @param str
     * @return
     */
    public static Double NullToZero(Object str) {
        if (str != null && !str.toString().equals("")) {
            return Double.valueOf(str.toString());
        } else {
            return Double.valueOf(0);
        }

    }

    /**
     * 如果为null不trim
     * 
     * @param str
     * @return
     */
    public static String isNull(String str) {
        if (!(str == null)) {

            return str.trim();
        } else {
            return "";
        }
    }

    /**
     * 
     * 功能描述: list转String "'a','b','c'"
     * 
     * @param list
     * @param separator
     * @return 
     * String 
     * @version 1.0.0 
     * @since 1.0.0 
     * @author LuXin 
     * Date:   2018年8月31日 下午8:36:11
     */
    public static String joinWithSemicolon(List<?> list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, lsize = list.size(); i < lsize; i++) {
            sb.append("'").append(list.get(i)).append("'");
            if (i < lsize - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
