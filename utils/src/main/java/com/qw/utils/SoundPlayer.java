package com.qw.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;


import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * SoundPlayer.play(getActivity().getAssets().openFd("pet.mp3"));
 */
public class SoundPlayer {
    private static SoundPool mSoundPool;

    public static int play(Context context, int resId) {
        if (mSoundPool == null) {
            initSoundPool();
        }

        int soundId = mSoundPool.load(context, resId, 0);
        mSoundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            mSoundPool.play(sampleId, 1.0F, 1.0F, 0, 0, 1.0F);
        });

        return soundId;
    }

    public static int play(AssetFileDescriptor afd) {
        if (mSoundPool == null) {
            initSoundPool();
        }
        int soundId = mSoundPool.load(afd, 0);
        mSoundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            mSoundPool.play(sampleId, 1.0F, 1.0F, 0, 0, 1.0F);
        });
        return soundId;
    }

    public static void pause(int soundId) {
        if (mSoundPool != null && soundId > 0) {
            mSoundPool.pause(soundId);
        }
    }

    public static void release() {
        if (mSoundPool != null) {
            mSoundPool.release();
        }
    }

    private static void initSoundPool() {
        if (SDK_INT >= LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
    }
}