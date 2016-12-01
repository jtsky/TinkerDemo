package com.jin.tinkerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

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
        mBtn.setOnClickListener(view -> {
            String patchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tinkersample/patch_signed_7zip.apk";
            File file = new File(patchPath);
            if (file.exists()) {
                Log.v(TAG, "补丁文件存在");
                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patchPath);
            } else {
                Log.v(TAG, "补丁文件不存在");
            }

        });

    }
}
