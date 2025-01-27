package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.l.a {
    private static AtomicBoolean arg = new AtomicBoolean(false);
    public static volatile Message arh;
    private HandlerC0480a are = new HandlerC0480a((byte) 0);
    private Messenger arf = new Messenger(this.are);

    /* renamed from: com.kwad.sdk.collector.b.a$1 */
    public class AnonymousClass1 implements d.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void cx(String str) {
            c.e("RemoteService", "onLoadError: " + str);
            a.arg.set(false);
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void onLoaded() {
            c.d("RemoteService", "onLoaded");
            a.arg.set(true);
            if (a.arh != null) {
                a.this.are.handleMessage(a.arh);
                a.arh = null;
            }
        }
    }

    /* renamed from: com.kwad.sdk.collector.b.a$a */
    public static class HandlerC0480a extends Handler {
        private WeakReference<Service> arj;

        /* renamed from: com.kwad.sdk.collector.b.a$a$1 */
        public class AnonymousClass1 implements g.b {
            final /* synthetic */ Bundle ark;
            final /* synthetic */ Messenger arl;

            public AnonymousClass1(Bundle bundle, Messenger messenger) {
                bundle = bundle;
                messenger = messenger;
            }

            @Override // com.kwad.sdk.utils.g.b
            public final void u(List<b> list) {
                c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                if (list != null && !list.isEmpty()) {
                    c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                    JSONArray K = g.a.K(list);
                    String jSONArray = K != null ? K.toString() : null;
                    c.d("RemoteService", "resultJson :" + jSONArray);
                    if (jSONArray != null) {
                        AppStatusRules MD = g.MD();
                        ArrayList<AppStatusRules.Strategy> allStrategy = MD != null ? MD.getAllStrategy() : null;
                        String jSONArray2 = allStrategy != null ? x.N(allStrategy).toString() : null;
                        bundle.putString("resultJson", jSONArray);
                        bundle.putString("allStrategyJson", jSONArray2);
                    }
                }
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 101;
                    obtain.setData(bundle);
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
                if (list == null || list.isEmpty()) {
                    return;
                }
                Iterator<b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().destroy();
                }
            }
        }

        private HandlerC0480a() {
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.arj = new WeakReference<>(service);
            } else {
                this.arj = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.arj;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.Cc().get()) {
                c.d("RemoteService", "save buffered message");
                a.arh = Message.obtain(message);
                return;
            }
            Messenger messenger = message.replyTo;
            int i10 = message.what;
            c.d("RemoteService", "handleMessage what: " + i10);
            if (i10 != 100) {
                return;
            }
            g.a(service, new g.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                final /* synthetic */ Bundle ark;
                final /* synthetic */ Messenger arl;

                public AnonymousClass1(Bundle bundle, Messenger messenger2) {
                    bundle = bundle;
                    messenger = messenger2;
                }

                @Override // com.kwad.sdk.utils.g.b
                public final void u(List<b> list) {
                    c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray K = g.a.K(list);
                        String jSONArray = K != null ? K.toString() : null;
                        c.d("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules MD = g.MD();
                            ArrayList<AppStatusRules.Strategy> allStrategy = MD != null ? MD.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? x.N(allStrategy).toString() : null;
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", jSONArray2);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }

        public /* synthetic */ HandlerC0480a(byte b10) {
            this();
        }
    }

    public static AtomicBoolean Cc() {
        return arg;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e10) {
            c.printStackTrace(e10);
        }
    }

    private static boolean bf(Context context) {
        String processName = av.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.arf.getBinder();
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(av.getProcessName(service.getApplicationContext()));
            } catch (Exception e10) {
                c.d("RemoteService", "WebView has already been initialized " + e10.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + av.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            arg.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void cx(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.arg.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.arg.set(true);
                    if (a.arh != null) {
                        a.this.are.handleMessage(a.arh);
                        a.arh = null;
                    }
                }
            });
        }
        this.are.a(service);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        c.d("RemoteService", "onDestroy");
        this.are.a(null);
        if (bf(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }
}
