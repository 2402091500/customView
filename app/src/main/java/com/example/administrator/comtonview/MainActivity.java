package com.example.administrator.comtonview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.tipbar)
    Topbar tipbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tipbar.setOnTopberClickListener(new Topbar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"点击了左边的button",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"点击了右边的button",Toast.LENGTH_SHORT).show();

            }
        });

       tipbar.left_right_visible(true,true);
    }
}
