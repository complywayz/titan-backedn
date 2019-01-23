package com.complywayz.titan.id;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UnitqIdGeneratorTests {



    private UnitqIdGenerator generator = new UnitqIdGenerator();

    /**
     * TEST Generate
     */
    @Test
    public void generate()
    {
        //WHEN
        String id = generator.generate();
        System.out.println(id);
        //THEN
        assertNotNull("id is null",id);

    }
    @Test
    public void generateMultiple()
    {


        //GIVEN
        ExecutorService exe = Executors.newFixedThreadPool(10);
        Set<String> all = new HashSet<>();
        List<Future<String>> fs = new ArrayList<>();


        //WHEN
        for(long i=0;i < 1000000;i++)
        {
            fs.add(exe.submit(()->{
                return generator.generate();
            }));
        }
        for(Future<String> f : fs)
        {
            try
            {
                if (all.contains(f.get()))
                {
                    System.out.println("duplicate id:"+f.get());
                }
                all.add(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //THEN
        assertEquals("duplicate hash generated",1000000,all.size());

    }
}