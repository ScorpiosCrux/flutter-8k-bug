package com.example.example_8k;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlayer;

import java.util.Map;

import io.flutter.plugin.platform.PlatformView;

public class PlayerView implements PlatformView {
    private final SurfaceView integratedSurfaceView;
    private final MainActivity mainActivity;

    PlayerView(
            @NonNull Context context,
            int id,
            @Nullable Map<String, Object> creationParams,
            MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.integratedSurfaceView = new SurfaceView(context);
        addCallback();


        // The following is the hack to display 8K resolution without the Flutter Engine.
//        mainActivity.runOnUiThread(() -> {
//            ViewGroup vg = (ViewGroup) mainActivity.getWindow().getDecorView();
//            vg.addView(integratedSurfaceView);
//        });

    }

    @Nullable
    @Override
    public View getView() {
        return this.integratedSurfaceView;
    }

    @Override
    public void dispose() {}

    private void addCallback() {
        this.integratedSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            }

            // This covers when the Surface is created as well, but also covers the fact
            // when the surface changes (e.g. rotation) .
            // Note i1 and i2 contains the surface size created.
            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
                // Retrieve the created Surface
                mainActivity.onPlatformViewCreated(surfaceHolder.getSurface());
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            }
        });
    }
}
