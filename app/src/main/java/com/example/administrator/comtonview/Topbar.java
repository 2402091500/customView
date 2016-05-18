package com.example.administrator.comtonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xml.sax.Attributes;

/**
 * Created by Administrator on 2016/5/18.
 */
public class Topbar extends RelativeLayout {

    private Button leftButton,rightButton;
    private TextView tvTitle;

    private  int leftTextColor;
    private Drawable leftBackground;
    private  String leftTxt;

    private  int rightTextColor;
    private Drawable rightBackground;
    private String rightTxt;

    private  float titleTextSize;
    private int titleTextColor;
    private  String titles;

    private  topbarClickListener listener;
    public interface  topbarClickListener{
        public void leftClick();
        public void rightClick();
    }

    public void setOnTopberClickListener(topbarClickListener listener){
        this.listener=listener;
    }
    private  LayoutParams leftParams,rightParams,titleParams;

    @SuppressLint("NewApi")
    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);

        leftTextColor=ta.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground=ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftTxt=ta.getString(R.styleable.Topbar_leftTxt);

        rightTextColor=ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground=ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightTxt=ta.getString(R.styleable.Topbar_rightTxt);

       titleTextSize=ta.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColor=ta.getColor(R.styleable.Topbar_titileTextColor,0);
       titles=ta.getString(R.styleable.Topbar_titles);

        ta.recycle();
        leftButton=new Button(context);
        rightButton=new Button(context);
        tvTitle=new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftTxt);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        
        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightTxt);

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(titles);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(getResources().getColor(R.color.titel_color));

        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        addView(leftButton,leftParams);
        
        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        addView(rightButton,rightParams);
        
        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        addView(tvTitle,titleParams);
    }


}
