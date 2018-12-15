package com.example.apple.app1;

import android.app.Activity;
import android.net.Uri;//Uri 代表要操作的数据，Android上可用的每种资源 - 图像、视频片段等都可以用Uri来表示
import android.os.Bundle;//Bundle主要用于传递数据
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends Activity implements View.OnTouchListener {
    private VideoView videoView;
    private  String uri="rtsp://192.168.123.47/a.mkv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//导入一个布局
        videoView = (VideoView) findViewById(R.id.videoView);
        //findViewById()获取在布局中定义了的元素，返回的是一个View对象，需要向下转型
        MediaController mediaController = new MediaController(this);

        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.setOnTouchListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null){
            videoView.suspend();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {//实现onTouch接口

        switch (view.getId()){
            case R.id.videoView:

                Toast.makeText(MainActivity.this,"ddd",Toast.LENGTH_LONG).show();

                break;
        }

        return false;
    }
}
