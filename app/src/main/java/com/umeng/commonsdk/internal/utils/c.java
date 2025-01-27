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
    private static final String f26215a = "BatteryUtils";

    /* renamed from: b */
    private static boolean f26216b = false;

    /* renamed from: c */
    private static Context f26217c;

    /* renamed from: d */
    private BroadcastReceiver f26218d;

    /* renamed from: com.umeng.commonsdk.internal.utils.c$1 */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                    int i2 = 0;
                    int intExtra = intent.getIntExtra("level", 0);
                    int intExtra2 = intent.getIntExtra("voltage", 0);
                    int intExtra3 = intent.getIntExtra("temperature", 0);
                    int intExtra4 = intent.getIntExtra("status", 0);
                    int i3 = -1;
                    if (intExtra4 != 1) {
                        if (intExtra4 == 2) {
                            i3 = 1;
                        } else if (intExtra4 == 4) {
                            i3 = 0;
                        } else if (intExtra4 == 5) {
                            i3 = 2;
                        }
                    }
                    int intExtra5 = intent.getIntExtra("plugged", 0);
                    if (intExtra5 == 1) {
                        i2 = 1;
                    } else if (intExtra5 == 2) {
                        i2 = 2;
                    }
                    b bVar = new b();
                    bVar.f26209a = intExtra;
                    bVar.f26210b = intExtra2;
                    bVar.f26212d = i3;
                    bVar.f26211c = intExtra3;
                    bVar.f26213e = i2;
                    bVar.f26214f = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f26185h, com.umeng.commonsdk.internal.b.a(c.f26217c).a(), bVar);
                    c.this.c();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(c.f26217c, th);
            }
        }
    }

    private static class a {

        /* renamed from: a */
        private static final c f26220a = new c();

        private a() {
        }
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a(Context context) {
        if (f26217c == null && context != null) {
            f26217c = context.getApplicationContext();
        }
        return a.f26220a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f26217c.registerReceiver(this.f26218d, intentFilter);
            f26216b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26217c, th);
        }
    }

    public synchronized void c() {
        try {
            f26217c.unregisterReceiver(this.f26218d);
            f26216b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26217c, th);
        }
    }

    private c() {
        this.f26218d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i2 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i3 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i3 = 1;
                            } else if (intExtra4 == 4) {
                                i3 = 0;
                            } else if (intExtra4 == 5) {
                                i3 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i2 = 1;
                        } else if (intExtra5 == 2) {
                            i2 = 2;
                        }
                        b bVar = new b();
                        bVar.f26209a = intExtra;
                        bVar.f26210b = intExtra2;
                        bVar.f26212d = i3;
                        bVar.f26211c = intExtra3;
                        bVar.f26213e = i2;
                        bVar.f26214f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f26185h, com.umeng.commonsdk.internal.b.a(c.f26217c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f26217c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f26216b;
    }
}
