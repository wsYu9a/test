package com.vivo.push.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f25016a;

    /* renamed from: b */
    final /* synthetic */ Map f25017b;

    /* renamed from: c */
    final /* synthetic */ u f25018c;

    public v(u uVar, Context context, Map map) {
        this.f25018c = uVar;
        this.f25016a = context;
        this.f25017b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentName componentName;
        String packageName = this.f25016a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f25016a.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        u.b(intent, this.f25017b);
                        this.f25016a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e10);
        }
        Intent launchIntentForPackage = this.f25016a.getPackageManager().getLaunchIntentForPackage(this.f25016a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        u.b(launchIntentForPackage, this.f25017b);
        this.f25016a.startActivity(launchIntentForPackage);
    }
}
