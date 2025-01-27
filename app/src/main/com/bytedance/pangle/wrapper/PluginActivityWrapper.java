package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.i;

@Keep
/* loaded from: classes2.dex */
public class PluginActivityWrapper extends GenerateActivityWrapper {
    private static final int OBJECT_TAG = Integer.MAX_VALUE;

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$1 */
    public class AnonymousClass1 extends com.bytedance.pangle.a {
        public AnonymousClass1() {
        }
    }

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$2 */
    public class AnonymousClass2 extends com.bytedance.pangle.a {

        /* renamed from: a */
        final /* synthetic */ Application f7864a;

        public AnonymousClass2(Application application) {
            appApplication = application;
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity == PluginActivityWrapper.this.mOriginActivity) {
                appApplication.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$3 */
    public class AnonymousClass3 extends com.bytedance.pangle.a {
        public AnonymousClass3() {
        }
    }

    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!activity.isDestroyed()) {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.1
                        public AnonymousClass1() {
                        }
                    });
                } else if (i10 >= 24) {
                    setTag();
                } else {
                    registerApplicationLifecycleCallbacks();
                }
            }
        } catch (Exception unused) {
            registerApplicationLifecycleCallbacks();
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!i.a()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException unused2) {
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException unused3) {
        }
        com.bytedance.pangle.util.a.a(this, activity);
    }

    private void registerApplicationLifecycleCallbacks() {
        Application appApplication = Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2

            /* renamed from: a */
            final /* synthetic */ Application f7864a;

            public AnonymousClass2(Application appApplication2) {
                appApplication = appApplication2;
            }

            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity == PluginActivityWrapper.this.mOriginActivity) {
                    appApplication.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
            public AnonymousClass3() {
            }
        });
    }
}
