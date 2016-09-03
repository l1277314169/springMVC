package web.service.impl;

import web.service.Laoshi;
import web.service.Student;

/**
 * Created by Administrator on 2016-07-31.
 */
public class Test extends Student implements  Laoshi {
    @Override
    public void ect() {
        System.out.println("ect");

    }

    @Override
    public void show() {
        System.out.println("student");
    }

    public static void main(String[] args) {
        Test a=new Test();
        a.ect();
    }
}
