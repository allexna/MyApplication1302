package com.example.myapplication1302;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mCatSound,mDogSound;
    private int mStreamID;
    private OnClickListener onClickListener;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSoundPool=new SoundPool(4, AudioManager.STREAM_MUSIC,100);
        mSoundPool.load(this,R.raw.cat,1);
        mSoundPool.load(this,R.raw.dog,2);
        ImageButton catImageButton=findViewById(R.id.imageButtonCat);
        catImageButton.setOnClickListener(onClickListener);
        ImageButton dogImageButton=findViewById(R.id.imageButtonDog);
        dogImageButton.setOnClickListener(onClickListener);
        OnClickListener onClickListener=new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId())
                {case R.id.imageButtonCat:
                    playSound(mCatSound);
                    break;
                    case R.id.imageButtonDog:
                        playSound(mDogSound);
                        break;
                }

            }
        };
        private void createSoundPool(){
            AudioAttributes attributes=new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            mSoundPool=new SoundPool.Builder()
                    .setAudioAttributes(attributes).build();
        }

        private int playSound(int sound){
            if(sound>0){
                mStreamID=mSoundPool.play(sound,1,1,1,0,1);
            }
            return mStreamID;
        }

        private void int loadSound(String fileName){
            AssetFileDescriptor afd;
            return mSoundPool.load(afd,1);
        }
      /*  createSoundPool();
        mAssetManager=getAssets();
        mCatSound=loadSound("cat.mp3");
        mDogSound=loadSound("dog.mp3");
        ImageButton catImageButton=findViewById(R.id.imageButtonCat);
        catImageButton.setOnClickListener(onClickListener);
        ImageButton dogImageButton=findViewById(R.id.imageButtonDog);
        dogImageButton.setOnClickListener(onClickListener);
        OnClickListener onClickListener=new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId())
                {case R.id.imageButtonCat:
                    playSound(mCatSound);
                    break;
                    case R.id.imageButtonDog:
                        playSound(mDogSound);
                        break;
                }

            }
        };


        private void createSoundPool(){
            AudioAttributes attributes=new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            mSoundPool=new SoundPool.Builder()
                    .setAudioAttributes(attributes).build();
        }
        private void int loadSound(String fileName){
            AssetFileDescriptor afd;
            return mSoundPool.load(afd,1);
        }

    }*/
}
}
