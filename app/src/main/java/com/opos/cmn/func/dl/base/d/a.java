package com.opos.cmn.func.dl.base.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d */
    private static final String f17302d = "a";

    /* renamed from: e */
    private static volatile a f17303e;

    /* renamed from: a */
    public Context f17304a;

    /* renamed from: b */
    public BroadcastReceiver f17305b;

    /* renamed from: c */
    public List<c> f17306c = new ArrayList();

    /* renamed from: f */
    private Handler f17307f = new HandlerC0391a();

    /* renamed from: com.opos.cmn.func.dl.base.d.a$a */
    final class HandlerC0391a extends Handler {
        public HandlerC0391a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.opos.cmn.an.f.a.b(a.f17302d, "mList size=" + a.this.f17306c.size());
            int i2 = message.what;
            if (i2 == 0) {
                Iterator it = a.this.f17306c.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).b();
                }
            } else if (i2 == 1) {
                Iterator it2 = a.this.f17306c.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).a();
                }
            } else {
                if (i2 != 2) {
                    return;
                }
                Iterator it3 = a.this.f17306c.iterator();
                while (it3.hasNext()) {
                    ((c) it3.next()).c();
                }
            }
        }
    }

    final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo;
            com.opos.cmn.an.f.a.b(a.f17302d, "NetWorkReceiver onReceive");
            ConnectivityManager connectivityManager = (ConnectivityManager) a.this.f17304a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                a.a(a.this, 2);
                return;
            }
            int type = activeNetworkInfo.getType();
            boolean z = type == 0;
            boolean z2 = type == 1;
            if (z) {
                a.a(a.this, 1);
            } else if (z2) {
                a.a(a.this, 0);
            }
            com.opos.cmn.an.f.a.b(a.f17302d, "download net change to type:".concat(String.valueOf(type)));
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    private a(Context context) {
        this.f17304a = context;
    }

    public static a a(Context context) {
        if (f17303e == null) {
            synchronized (a.class) {
                if (f17303e == null) {
                    f17303e = new a(context);
                }
            }
        }
        return f17303e;
    }

    static /* synthetic */ void a(a aVar, int i2) {
        aVar.a();
        aVar.f17307f.sendEmptyMessageDelayed(i2, 3000L);
    }

    public final void a() {
        this.f17307f.removeCallbacksAndMessages(null);
    }
}
