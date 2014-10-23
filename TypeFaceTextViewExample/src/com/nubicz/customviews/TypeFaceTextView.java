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
	
	public TypeFaceTextView(Context context) {
		super(context);
	}
	
    public TypeFaceTextView(Context context,AttributeSet attrs) {
    	super(context, attrs);
    	TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TypeFaceTextView);
    	data = ta.getString(R.styleable.TypeFaceTextView_typeface);
    	init(context,data);
	}
    
    public TypeFaceTextView(Context context, AttributeSet attrs, int defStyle){
    	super(context, attrs, defStyle);
    	TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TypeFaceTextView);
    	data = ta.getString(R.styleable.TypeFaceTextView_typeface);
    	init(context,data);
    }
    
    public void init(Context context,String data){
    	Typeface tf =  Typeface.createFromAsset(context.getAssets(),data);
    	this.setTypeface(tf);
    }
    
	
    
}
