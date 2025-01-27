package com.bytedance.pangle.download;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e */
    private static volatile b f6048e;

    /* renamed from: a */
    final Map<String, Long> f6049a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Handler f6050b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public final Map<String, Runnable> f6051c = new ConcurrentHashMap();

    /* renamed from: d */
    final Map<String, Runnable> f6052d = new ConcurrentHashMap();

    /* renamed from: com.bytedance.pangle.download.b$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f6053a;

        public AnonymousClass1(final String str2) {
            str = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<ActivityManager.RunningTaskInfo> runningTasks;
            ComponentName componentName;
            Application appApplication = Zeus.getAppApplication();
            String packageName = appApplication.getPackageName();
            if ((TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) appApplication.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true) {
                b.this.f6050b.postDelayed(this, 1800000L);
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (f6048e == null) {
            synchronized (b.class) {
                if (f6048e == null) {
                    f6048e = new b();
                }
            }
        }
        return f6048e;
    }
}
