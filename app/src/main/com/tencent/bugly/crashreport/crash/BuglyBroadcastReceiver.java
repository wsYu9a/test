package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;

/* loaded from: classes4.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static BuglyBroadcastReceiver f22369a;

    /* renamed from: c */
    private Context f22371c;

    /* renamed from: d */
    private String f22372d;

    /* renamed from: e */
    private boolean f22373e = true;

    /* renamed from: b */
    private IntentFilter f22370b = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            try {
                if (f22369a == null) {
                    f22369a = new BuglyBroadcastReceiver();
                }
                buglyBroadcastReceiver = f22369a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        try {
            if (!this.f22370b.hasAction(str)) {
                this.f22370b.addAction(str);
            }
            X.a("add action %s", str);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f22371c = context;
        ca.a(new a(this, this));
    }

    public synchronized void unregister(Context context) {
        try {
            X.c(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f22371c = context;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public final synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f22373e) {
                    this.f22373e = false;
                    return true;
                }
                String c10 = com.tencent.bugly.crashreport.common.info.b.c(this.f22371c);
                X.a("is Connect BC " + c10, new Object[0]);
                X.c("network %s changed to %s", "" + this.f22372d, "" + c10);
                if (c10 == null) {
                    this.f22372d = null;
                    return true;
                }
                String str = this.f22372d;
                this.f22372d = c10;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.c b10 = com.tencent.bugly.crashreport.common.strategy.c.b();
                T a10 = T.a();
                com.tencent.bugly.crashreport.common.info.a a11 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (b10 != null && a10 != null && a11 != null) {
                    if (!c10.equals(str) && currentTimeMillis - a10.b(h.f22462a) > 30000) {
                        X.c("try to upload crash on network changed.", new Object[0]);
                        h g10 = h.g();
                        if (g10 != null) {
                            g10.a(0L);
                        }
                        X.c("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.f.f22271i.b();
                    }
                    return true;
                }
                X.e("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
