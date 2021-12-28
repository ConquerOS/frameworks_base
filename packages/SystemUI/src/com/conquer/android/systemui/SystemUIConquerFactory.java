package com.conquer.android.systemui;

import android.content.Context;

import com.conquer.android.systemui.dagger.DaggerGlobalRootComponentConquer;
import com.conquer.android.systemui.dagger.GlobalRootComponentConquer;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;

public class SystemUIConquerFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerGlobalRootComponentConquer.builder()
                .context(context)
                .build();
    }
}
