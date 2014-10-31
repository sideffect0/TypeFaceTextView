package com.nubicz.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.nubicz.typefacetextview.R;

public class TypeFaceTextView extends TextView{

	public String data = null;
	public Boolean is_animate = false;
	public Integer mDelay = 500;
	private int mIndex = 0;
	public CharSequence mText = "";
	protected AlphaAnimation fadeIn = null; 
	protected AlphaAnimation fadeOut = null;
	protected AnimationSet animation;
	
	private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
            if(mIndex == mText.length()){
            	mHandler.postDelayed(animationAdder, mDelay);
            }
        }
    };
    
    private Runnable animationAdder = new Runnable() {
		
		@Override
		public void run() {
        	setAnimation(animation);			
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
    	
    	fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
    	fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ; 
    	
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);
    	mHandler.removeCallbacks(characterAdder);
    	mHandler.postDelayed(characterAdder, mDelay);
    	animation = new AnimationSet(false);
    	animation.addAnimation(fadeIn);
    	animation.addAnimation(fadeOut);
    }
    
    public void setTypeface(String path){
    	Typeface tf =  TypeFaceCache.getFont(getContext(), path);
    	this.setTypeface(tf);
    }
    
	
    
}
