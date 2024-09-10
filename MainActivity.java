package com.example.camera;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b;
    ImageView iv;
    int CAMERA_REQUEST=1;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.b1);
        iv=(ImageView)findViewById(R.id.iv);
        b.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(i,CAMERA_REQUEST);

           }
        });
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==CAMERA_REQUEST)
        {
            Bitmap bp=(Bitmap)data.getExtras().get("data");
            iv.setImageBitmap(bp);
        }
    }
}