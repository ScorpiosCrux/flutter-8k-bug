package com.example.example_8k;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class PlayerViewFactory extends PlatformViewFactory {
    private final MainActivity mainActivity;

    public PlayerViewFactory(MainActivity mainActivity) {
        super(StandardMessageCodec.INSTANCE);
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new PlayerView(context, id, creationParams, mainActivity);
    }
}
