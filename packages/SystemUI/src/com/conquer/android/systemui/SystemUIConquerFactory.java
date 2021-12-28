package com.conquer.android.systemui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;

import com.conquer.android.systemui.dagger.DaggerGlobalRootComponentConquer;
import com.conquer.android.systemui.dagger.GlobalRootComponentConquer;
import com.conquer.android.systemui.dagger.SysUIComponentConquer;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;
import com.android.systemui.screenshot.ScreenshotNotificationSmartActionsProvider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class SystemUIConquerFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerGlobalRootComponentConquer.builder()
                .context(context)
                .build();
    }

    @Override
    public void init(Context context, boolean fromTest) throws ExecutionException, InterruptedException {
        super.init(context, fromTest);
        if (shouldInitializeComponents()) {
            ((SysUIComponentConquer) getSysUIComponent()).createKeyguardSmartspaceController();
        }
    }
}
