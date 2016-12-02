package com.jin.tinkerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.jin.tinkerdemo.patchserver.TinkerServerManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //mTv.setText("old");
        //mTv.setText("再次修复");
        mTv.setText("new");//修复后的bug
        mBtn.setOnClickListener(v -> TinkerServerManager.checkTinkerUpdate(true));


    }
}
