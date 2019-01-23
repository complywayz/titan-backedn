package com.complywayz.titan.id;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

@Component
public class UnitqIdGenerator
{
    private SecureRandom r = new SecureRandom();


    public String generate()
    {
        try
        {
            MessageDigest  md = MessageDigest.getInstance("SHA-1");

            String s =String.valueOf(new Date().getTime())+"-"+r.nextInt();
            String sha1 = String.format("%040x", new BigInteger(1, md.digest(s.getBytes())));;
            return sha1.substring(0,10);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
