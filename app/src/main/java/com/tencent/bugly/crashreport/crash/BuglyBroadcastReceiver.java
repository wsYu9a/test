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
    private static BuglyBroadcastReceiver f24782a;

    /* renamed from: c */
    private Context f24784c;

    /* renamed from: d */
    private String f24785d;

    /* renamed from: e */
    private boolean f24786e = true;

    /* renamed from: b */
    private IntentFilter f24783b = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f24782a == null) {
                f24782a = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f24782a;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f24783b.hasAction(str)) {
            this.f24783b.addAction(str);
        }
        X.a("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f24784c = context;
        ca.a(new a(this, this));
    }

    public synchronized void unregister(Context context) {
        try {
            X.c(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f24784c = context;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    protected final synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f24786e) {
                    this.f24786e = false;
                    return true;
                }
                String c2 = com.tencent.bugly.crashreport.common.info.b.c(this.f24784c);
                X.a("is Connect BC " + c2, new Object[0]);
                X.c("network %s changed to %s", "" + this.f24785d, "" + c2);
                if (c2 == null) {
                    this.f24785d = null;
                    return true;
                }
                String str = this.f24785d;
                this.f24785d = c2;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.c b2 = com.tencent.bugly.crashreport.common.strategy.c.b();
                T a2 = T.a();
                com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (b2 != null && a2 != null && a3 != null) {
                    if (!c2.equals(str) && currentTimeMillis - a2.b(h.f24855a) > 30000) {
                        X.c("try to upload crash on network changed.", new Object[0]);
                        h g2 = h.g();
                        if (g2 != null) {
                            g2.a(0L);
                        }
                        X.c("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.f.f24740i.b();
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
