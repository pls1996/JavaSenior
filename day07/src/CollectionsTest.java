/**
 *  Collections：操作Collection、Map的工具类
 *
 *  常用方法：
 *  排序操作：（均为static方法）
 reverse(List)：反转 List 中元素的顺序
 shuffle(List)：对 List 集合元素进行随机排序
 sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

    查找、替换
 Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 Object min(Collection)
 Object min(Collection，Comparator)
 int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 void copy(List dest,List src)：将src中的内容复制到dest中
 boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值


    Collections 类中提供了多个 synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合

 *
 *
 *  面试题：Collection和Collections的区别？
 *  collection：接口
 *  collections：工具类
 *
 * @author pls
 * @create 2020-11-06 17:07
 */
public class CollectionsTest {
}
