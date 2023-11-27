package com.test.Serializable;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Lock;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@Slf4j
@SpringBootTest
public class MyTest_Serializable {

    @Test
    public void test() throws Exception {
        Person person = new Person();
        person.setAge("111");
        person.setName("小王");

        String outPath = "C:\\Users\\chejl\\Desktop\\p.java";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outPath));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(outPath));
        Object temp_obj = objectInputStream.readObject();
        if(temp_obj instanceof Person){
            log.info("persion = {}" , ((Person)temp_obj).toString());
        }else{
            log.info("obejct= {}" , temp_obj.toString());
        }

    }

}
