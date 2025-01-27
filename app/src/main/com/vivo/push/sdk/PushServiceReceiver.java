package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.sigmob.sdk.base.common.y;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.p;
import com.vivo.push.util.r;

/* loaded from: classes4.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static HandlerThread f25088a;

    /* renamed from: b */
    private static Handler f25089b;

    /* renamed from: c */
    private static a f25090c = new a();

    public static class a implements Runnable {

        /* renamed from: a */
        private Context f25091a;

        /* renamed from: b */
        private String f25092b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f25091a = ContextDelegate.getContext(context);
            aVar.f25092b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a10 = r.a(this.f25091a);
            if (!(a10 != null ? a10.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f25091a.getPackageName() + ": 无网络  by " + this.f25092b);
                p.a(this.f25091a, "触发静态广播:无网络(" + this.f25092b + "," + this.f25091a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f25091a.getPackageName() + ": 执行开始出发动作: " + this.f25092b);
            p.a(this.f25091a, "触发静态广播(" + this.f25092b + "," + this.f25091a.getPackageName() + ")");
            e.a().a(this.f25091a);
            if (ClientConfigManagerImpl.getInstance(this.f25091a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f25091a).initialize();
            } catch (VivoPushException e10) {
                e10.printStackTrace();
                p.a(this.f25091a, " 初始化异常 error= " + e10.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f25088a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f25088a = handlerThread;
                handlerThread.start();
                f25089b = new Handler(f25088a.getLooper());
            }
            p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f25089b);
            a.a(f25090c, context2, action);
            f25089b.removeCallbacks(f25090c);
            f25089b.postDelayed(f25090c, y.f.f18076n);
        }
    }
}
