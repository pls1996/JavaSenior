import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8中新日期时间API
 * LocalDate\LocalTime\LocalDateTime
 * 创建对象：1\LocalDateTime.now()
 *          2\LocalDateTime.of(year, month, day, hour,min, sec);
 *
 * @author pls
 * @create 2020-11-03 13:35
 */
public class JDK8_DateTest {

    @Test//偏移量(JDK8之前)
    public void test1(){
        Date date1 = new Date(2020-1900,9-1,8);
        System.out.println(date1);//Tue Sep 08 00:00:00 CST 2020
    }

    @Test//JDK8及之后
    public void test2(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 3, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx():获取相关属性
        System.out.println(localDateTime1.getDayOfMonth());

        //withXxx():(体现不可变性)设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);//2020-11-03T14:01:36.554
        System.out.println(localDateTime2);//2020-11-22T14:01:36.554

        //plusXxx():(体现不可变性)在目前基础上增加
        //minuXxx():减
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    @Test
    public void test3(){
        //DateTimeFormatter:格式化或解析日期、时间，类似于SimpleDateFormat
        //预定义的标准格式。如：
        //1、ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;//实例化
        LocalDateTime localDateTime = LocalDateTime.now();//当前日期-->字符串
        String str = formatter.format(localDateTime);//字符串格式化

        System.out.println(localDateTime);//格式化前
        System.out.println(str);//格式化后
        TemporalAccessor parse = formatter.parse(str);//解析：字符串-->日期
        System.out.println(parse);
        System.out.println("*************");

        //2、本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)

        //3、自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)**********************！！！重点！！！
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str1 = formatter1.format(LocalDateTime.now());//格式化
        System.out.println(str1);//2020-11-03 02:46:53

        TemporalAccessor t1 = formatter1.parse("2020-11-03 02:46:53");//解析
        System.out.println(t1);
    }




}
