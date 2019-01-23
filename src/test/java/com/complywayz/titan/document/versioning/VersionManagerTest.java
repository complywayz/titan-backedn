package com.complywayz.titan.document.versioning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VersionManagerTest {

    @Autowired
    private VersionManager manager;

    @Test
    public void next()
    {
        //GIVEN
        String key = "VTEST/temp/my";

        //WHEN
        int i = manager.next(key);
        assertEquals("wrong next value",2,i);
    }

    @Test
    public void latestKey()
    {
        //GIVEN
        String key = "VTEST/temp/my";

        //WHEN
        int i = manager.latest(key);
        assertEquals("wrong last key",2,i);

    }
}