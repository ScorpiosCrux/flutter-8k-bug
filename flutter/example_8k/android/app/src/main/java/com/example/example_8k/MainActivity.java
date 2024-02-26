package com.example.example_8k;

import android.view.Surface;

import androidx.annotation.NonNull;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.LoopingMediaSource;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends FlutterActivity{
    private final static String PLATFORM_VIEW_TYPE = "PLAYER_VIEW";
    private final static String VIDEO_URI = "file:///data/data/com.example.example_8k/files/8K_24FPS_H265.mp4";
//    private final static String VIDEO_URI = "file:///data/data/com.example.example_8k/files/8K-60FPS-H265-sync.mp4";


    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory(PLATFORM_VIEW_TYPE, new PlayerViewFactory(this));

    }

    public void onPlatformViewCreated(Surface surface){
        ExoPlayer player = new ExoPlayer.Builder(this.getApplicationContext()).build();
        player.setVideoSurface(surface);
        MediaItem mediaItem = MediaItem.fromUri(VIDEO_URI);
        player.setMediaItem(mediaItem);
        player.setRepeatMode(Player.REPEAT_MODE_ONE);
        player.prepare();
        player.play();
    }
}
