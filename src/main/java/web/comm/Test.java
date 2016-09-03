package web.comm;

import org.codehaus.jackson.map.ObjectMapper;
import org.omg.CORBA.portable.OutputStream;
import org.springframework.aop.support.AopUtils;

import java.io.*;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016-07-16.
 */
public class Test {

    private  static final ObjectMapper object = new ObjectMapper();

    public static void main(java.lang.String[] args)  {
        Test test =new Test();
        System.out.println("aaa");
    }


    public int show(int a,int b) throws IOException {
        int aa= 0;
        try {
            aa = a/b;
        } catch (Exception e) {
            throw new IOException(e);
        }
        return aa;
    }

}
