package com.conquer.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import com.conquer.android.systemui.keyguard.KeyguardSliceProviderConquer;
import com.conquer.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        DefaultComponentBinder.class,
        DependencyProvider.class,
        SystemUIBinder.class,
        SystemUIModule.class,
        SystemUIConquerModule.class})
public interface SysUIComponentConquer extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentConquer build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(KeyguardSliceProviderConquer keyguardSliceProviderConquer);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
