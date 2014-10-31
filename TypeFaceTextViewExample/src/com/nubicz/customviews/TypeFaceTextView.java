package com.nubicz.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

import com.nubicz.typefacetextview.R;

public class TypeFaceTextView extends TextView{

	public String data = null;
	public Boolean is_animate = true;
	
	public TypeFaceTextView(Context context) {
		super(context);
	}
	
    public TypeFaceTextView(Context context,AttributeSet attrs) {
    	super(context, attrs);
    	init(context,attrs);
	}
    
    public TypeFaceTextView(Context context, AttributeSet attrs, int defStyle){
    	super(context, attrs, defStyle);
    	init(context,attrs);
    }
    
    public void init(Context context,AttributeSet attrs){
    	
    	TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TypeFaceTextView);
    	data = ta.getString(R.styleable.TypeFaceTextView_customFont);
    	is_animate = ta.getBoolean(R.styleable.TypeFaceTextView_typeEffect, false);
    	if((data == null) || (data.length() == 0)){
             ta.recycle();
             return;
    	}  	 
    	Typeface tf =  TypeFaceCache.getFont(getContext(), data);
    	this.setTypeface(tf);
    }
    
	
    
}
