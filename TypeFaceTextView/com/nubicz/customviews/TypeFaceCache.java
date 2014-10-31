package com.nubicz.customviews;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;


public class TypeFaceCache {
	
  public static HashMap<String,Typeface> pCache = null;
  
  public static Typeface getFont(Context context,String path){
	  if(pCache == null){
		  pCache = new HashMap<String, Typeface>();
	  }
	  if(pCache.get(path) == null){
		  
	  }
	  Typeface.createFromAsset(context.getAssets(),path);
  }
}
