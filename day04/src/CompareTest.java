import org.junit.Test;

import java.util.Arrays;

/**
 * 一、Java中的对象，正常情况下，只能进行比较：== 或 ！=，不能使用 < 或 >，但是在实际开发中，我们需要对多个对象
 *      进行排序，即：比较对象的大小。
 *      使用comparable或comparator接口实现。
 * 二、comparable接口的使用：自然排序
 * 三、comparator接口的使用：定制排序
 *
 *
 * @author pls
 * @create 2020-11-03 15:06
 */
public class CompareTest {

    @Test
    public void test1(){
        String[] arr = new String[]{"AA","BB","MM","GG","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
