package com.vivo.push.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f30989a;

    /* renamed from: b */
    final /* synthetic */ Map f30990b;

    /* renamed from: c */
    final /* synthetic */ u f30991c;

    v(u uVar, Context context, Map map) {
        this.f30991c = uVar;
        this.f30989a = context;
        this.f30990b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f30989a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f30989a.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        u.b(intent, this.f30990b);
                        this.f30989a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f30989a.getPackageManager().getLaunchIntentForPackage(this.f30989a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        u.b(launchIntentForPackage, this.f30990b);
        this.f30989a.startActivity(launchIntentForPackage);
    }
}
