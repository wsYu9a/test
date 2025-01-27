package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ BuglyBroadcastReceiver f22400a;

    /* renamed from: b */
    final /* synthetic */ BuglyBroadcastReceiver f22401b;

    public a(BuglyBroadcastReceiver buglyBroadcastReceiver, BuglyBroadcastReceiver buglyBroadcastReceiver2) {
        this.f22401b = buglyBroadcastReceiver;
        this.f22400a = buglyBroadcastReceiver2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        Context context;
        BuglyBroadcastReceiver buglyBroadcastReceiver2;
        IntentFilter intentFilter;
        try {
            buglyBroadcastReceiver = BuglyBroadcastReceiver.f22369a;
            X.c(buglyBroadcastReceiver.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (this.f22400a) {
                context = this.f22401b.f22371c;
                buglyBroadcastReceiver2 = BuglyBroadcastReceiver.f22369a;
                intentFilter = this.f22401b.f22370b;
                context.registerReceiver(buglyBroadcastReceiver2, intentFilter, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
