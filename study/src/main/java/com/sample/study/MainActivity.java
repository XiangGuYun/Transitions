package com.sample.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    Button btn;
    ViewGroup container;
    private boolean hasRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn = findViewById(R.id.btn);
        container = findViewById(R.id.container);

        TransUtils.visibleTrans(btn, tv2, container);
        TransUtils.colorTrans(btn, tv2, container);
        TransUtils.textTrans(container, tv2, "HELLO　WORLD", "LIKE HER DREAM");

    }



}
