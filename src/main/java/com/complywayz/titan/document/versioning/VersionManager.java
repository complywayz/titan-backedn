package com.complywayz.titan.document.versioning;

import org.springframework.stereotype.Component;

@Component
public class VersionManager
{
   public int next(String key)
   {
       return 0;
   }
   public String latestKey(String key)
   {
       return null;
   }
   public int latest(String key)
   {
       return 0;
   }
}
