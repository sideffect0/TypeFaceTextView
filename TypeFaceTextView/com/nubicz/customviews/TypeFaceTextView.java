package com.nubicz.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nubicz.typefacetextview.R;

public class TypeFaceTextView extends TextView{

	public String data = null;
	public Boolean is_animate = false;
	public Integer mDelay = 500;
	private int mIndex = 0;
	public CharSequence mText = "";
	
	private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };
    
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
    	mDelay = ta.getInteger(R.styleable.TypeFaceTextView_typeEffectDelay,500);
    	final ScrollView sv = new ScrollView(context);
    	
    	if((data == null) || (data.length() == 0)){
             ta.recycle();
             return;
    	}  	 
    	Typeface tf =  TypeFaceCache.getFont(getContext(), data);
    	this.setTypeface(tf);
    	//Set for animation
    	if(is_animate){
    		animateText();
    	}
    }
    
    public void animateText(){
    	mText = getText();
    	mIndex = 0;
    	setText("");
    	mHandler.removeCallbacks(characterAdder);
    	mHandler.postDelayed(characterAdder, mDelay);
    }
    
    public void setTypeface(String path){
    	Typeface tf =  TypeFaceCache.getFont(getContext(), path);
    	this.setTypeface(tf);
    }
    
	
    
}
