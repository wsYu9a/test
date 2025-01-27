package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
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
    private static HandlerThread f31052a;

    /* renamed from: b */
    private static Handler f31053b;

    /* renamed from: c */
    private static a f31054c = new a();

    static class a implements Runnable {

        /* renamed from: a */
        private Context f31055a;

        /* renamed from: b */
        private String f31056b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f31055a = ContextDelegate.getContext(context);
            aVar.f31056b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a2 = r.a(this.f31055a);
            if (!(a2 != null ? a2.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f31055a.getPackageName() + ": 无网络  by " + this.f31056b);
                p.a(this.f31055a, "触发静态广播:无网络(" + this.f31056b + "," + this.f31055a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f31055a.getPackageName() + ": 执行开始出发动作: " + this.f31056b);
            p.a(this.f31055a, "触发静态广播(" + this.f31056b + "," + this.f31055a.getPackageName() + ")");
            e.a().a(this.f31055a);
            if (ClientConfigManagerImpl.getInstance(this.f31055a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f31055a).initialize();
            } catch (VivoPushException e2) {
                e2.printStackTrace();
                p.a(this.f31055a, " 初始化异常 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f31052a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f31052a = handlerThread;
                handlerThread.start();
                f31053b = new Handler(f31052a.getLooper());
            }
            p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f31053b);
            a.a(f31054c, context2, action);
            f31053b.removeCallbacks(f31054c);
            f31053b.postDelayed(f31054c, 2000L);
        }
    }
}
