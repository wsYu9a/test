package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f24523a = "BatteryUtils";

    /* renamed from: b */
    private static boolean f24524b = false;

    /* renamed from: c */
    private static Context f24525c;

    /* renamed from: d */
    private BroadcastReceiver f24526d;

    /* renamed from: com.umeng.commonsdk.internal.utils.c$1 */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                    int i10 = 0;
                    int intExtra = intent.getIntExtra("level", 0);
                    int intExtra2 = intent.getIntExtra("voltage", 0);
                    int intExtra3 = intent.getIntExtra("temperature", 0);
                    int intExtra4 = intent.getIntExtra("status", 0);
                    int i11 = -1;
                    if (intExtra4 != 1) {
                        if (intExtra4 == 2) {
                            i11 = 1;
                        } else if (intExtra4 == 4) {
                            i11 = 0;
                        } else if (intExtra4 == 5) {
                            i11 = 2;
                        }
                    }
                    int intExtra5 = intent.getIntExtra("plugged", 0);
                    if (intExtra5 == 1) {
                        i10 = 1;
                    } else if (intExtra5 == 2) {
                        i10 = 2;
                    }
                    b bVar = new b();
                    bVar.f24517a = intExtra;
                    bVar.f24518b = intExtra2;
                    bVar.f24520d = i11;
                    bVar.f24519c = intExtra3;
                    bVar.f24521e = i10;
                    bVar.f24522f = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24472h, com.umeng.commonsdk.internal.b.a(c.f24525c).a(), bVar);
                    c.this.c();
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(c.f24525c, th2);
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private static final c f24528a = new c();

        private a() {
        }
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a(Context context) {
        if (f24525c == null && context != null) {
            f24525c = context.getApplicationContext();
        }
        return a.f24528a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f24525c.registerReceiver(this.f24526d, intentFilter);
            f24524b = true;
        } finally {
        }
    }

    public synchronized void c() {
        try {
            f24525c.unregisterReceiver(this.f24526d);
            f24524b = false;
        } finally {
        }
    }

    private c() {
        this.f24526d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i10 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i11 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i11 = 1;
                            } else if (intExtra4 == 4) {
                                i11 = 0;
                            } else if (intExtra4 == 5) {
                                i11 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i10 = 1;
                        } else if (intExtra5 == 2) {
                            i10 = 2;
                        }
                        b bVar = new b();
                        bVar.f24517a = intExtra;
                        bVar.f24518b = intExtra2;
                        bVar.f24520d = i11;
                        bVar.f24519c = intExtra3;
                        bVar.f24521e = i10;
                        bVar.f24522f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24472h, com.umeng.commonsdk.internal.b.a(c.f24525c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(c.f24525c, th2);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f24524b;
    }
}
