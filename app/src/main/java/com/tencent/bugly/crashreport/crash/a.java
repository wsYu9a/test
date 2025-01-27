package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ BuglyBroadcastReceiver f24797a;

    /* renamed from: b */
    final /* synthetic */ BuglyBroadcastReceiver f24798b;

    a(BuglyBroadcastReceiver buglyBroadcastReceiver, BuglyBroadcastReceiver buglyBroadcastReceiver2) {
        this.f24798b = buglyBroadcastReceiver;
        this.f24797a = buglyBroadcastReceiver2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        Context context;
        BuglyBroadcastReceiver buglyBroadcastReceiver2;
        IntentFilter intentFilter;
        try {
            buglyBroadcastReceiver = BuglyBroadcastReceiver.f24782a;
            X.c(buglyBroadcastReceiver.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (this.f24797a) {
                context = this.f24798b.f24784c;
                buglyBroadcastReceiver2 = BuglyBroadcastReceiver.f24782a;
                intentFilter = this.f24798b.f24783b;
                context.registerReceiver(buglyBroadcastReceiver2, intentFilter, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
