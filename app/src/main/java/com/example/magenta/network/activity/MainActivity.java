package com.example.magenta.network.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.magenta.network.R;
import com.example.magenta.network.util.NetWorkUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_network_state;
    private Button btn_anim_translate;
    private Button btn_anim_alpha;
    private Button btn_anim_scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_network_state = ((Button) findViewById(R.id.btn_network_state));
        btn_anim_translate = ((Button) findViewById(R.id.btn_anim_translate));
        btn_anim_alpha = ((Button) findViewById(R.id.btn_anim_alpha));
        btn_anim_scale = ((Button) findViewById(R.id.btn_anim_scale));
        btn_network_state.setOnClickListener(this);
        btn_anim_translate.setOnClickListener(this);
        btn_anim_alpha.setOnClickListener(this);
        btn_anim_scale.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_network_state:
                int connectedType = NetWorkUtil.getConnectedType(this);
                switch (connectedType) {
                    case -1:
                        MyUtil.showShortMsg(this, "当前无网络");
                        break;
                    case 0:
                        MyUtil.showShortMsg(this, "当前为移动网络");
                        break;
                    case 1:
                        MyUtil.showShortMsg(this, "当前为无线网络");
                        break;
                }
                break;
        }
    }
}
