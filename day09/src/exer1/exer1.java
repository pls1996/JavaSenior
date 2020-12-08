package exer1;

import org.junit.Test;

import java.io.*;

/**
 * @author pls
 * @create 2020-11-08 20:26
 */
public class exer1 {

    @Test
    public void test2() {
        FileInputStream bis = null;
        FileOutputStream bos = null;
        try {
            bis = new FileInputStream(new File("小阿七_那女孩对我说_secret.jpg"));
            bos = new FileOutputStream(new File("小阿七_那女孩对我说_unsecret.jpg"));

            byte[] buff = new byte[20];
            int len = 0;
            while ((len = bis.read(buff)) != -1) {

                for (int i = 0; i < len; i++) {         //解密
                    buff[i] = (byte) (buff[i] ^ 5);
                }

                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        FileInputStream bis = null;
        FileOutputStream bos = null;
        try {
            bis = new FileInputStream(new File("小阿七_那女孩对我说_4.jpg"));
            bos = new FileOutputStream(new File("小阿七_那女孩对我说_secret.jpg"));

            byte[] buff = new byte[20];
            int len;
            while ((len = bis.read(buff)) != -1) {

                for (int i = 0; i < len; i++) {         //加密
                    buff[i] = (byte) (buff[i] ^ 5);
                }

                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
