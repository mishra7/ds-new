package com.ds.tree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.instrument.Instrumentation;

public class TestMain {


    private static Instrumentation instrumentation;

    public static void main(String[] args) throws IOException {
        System.out.println(getObjectSize(new Epmployee()));
    }

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object ser) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(ser);
        oos.close();
        return baos.size();

    }
}

class Epmployee  implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;


}
