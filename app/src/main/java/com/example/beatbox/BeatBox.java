package com.example.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";

    private AssetManager mAsset;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAsset = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundsNames;
        try {
            soundsNames = mAsset.list(SOUND_FOLDER);
            Log.i(TAG, "Found " +soundsNames.length + " sounds");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            e.printStackTrace();
            soundsNames = new String[0];
        }

        for (String filename: soundsNames){
            String assetPath = SOUND_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
