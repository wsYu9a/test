package com.martian.mipush;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.heytap.mcssdk.n.i;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.q0;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.martian.mipush.data.PushChannelInfo;
import com.martian.mipush.request.SendPushTokenParams;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static String f14880a = "HUAWEI";

    /* renamed from: b */
    public static String f14881b = "VIVO";

    /* renamed from: c */
    public static String f14882c = "XIAOMI";

    /* renamed from: d */
    public static String f14883d = "OPPO";

    /* renamed from: e */
    private static c f14884e = null;

    /* renamed from: f */
    public static final String f14885f = "com.martian.mipush.c";

    /* renamed from: g */
    public static final int f14886g = 1;

    /* renamed from: h */
    public static final int f14887h = 2;

    /* renamed from: i */
    public static final int f14888i = 3;

    /* renamed from: j */
    private Context f14889j;
    private e k;
    private d l;
    private String n;
    private String o;
    private boolean m = false;
    private boolean p = false;

    /* loaded from: classes4.dex */
    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f14890a;

        /* renamed from: b */
        final /* synthetic */ String f14891b;

        /* renamed from: c */
        final /* synthetic */ String f14892c;

        /* renamed from: d */
        final /* synthetic */ String f14893d;

        /* renamed from: e */
        final /* synthetic */ String f14894e;

        a(final Context val$xiaomiAppKey, final String val$xiaomiAppId, final String val$oppoAppSecret, final String val$oppoAppkey, final String val$context) {
            this.f14890a = val$xiaomiAppKey;
            this.f14891b = val$xiaomiAppId;
            this.f14892c = val$oppoAppSecret;
            this.f14893d = val$oppoAppkey;
            this.f14894e = val$context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (com.martian.mipush.d.g() && l.n()) {
                    c.this.m();
                } else if (com.martian.mipush.d.l()) {
                    c.this.p();
                } else if (com.martian.mipush.d.j() && com.heytap.mcssdk.a.o0(this.f14890a) && !k.p(this.f14891b)) {
                    c.this.o(this.f14891b, this.f14892c);
                } else if (com.martian.mipush.d.i() && l.p()) {
                    c.this.n(this.f14893d, this.f14894e);
                }
            } catch (Exception e2) {
                q0.e("init Push failed, " + e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    class b implements com.heytap.mcssdk.h.c {
        b() {
        }

        @Override // com.heytap.mcssdk.h.c
        public void a(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void b(int i2) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void c(int i2, int i1) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void d(int i2, int i1) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void e(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void f(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void g(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void h(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void i(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void j(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void k(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void l(int i2, String s) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void m(int i2, List<i> list) {
        }

        @Override // com.heytap.mcssdk.h.c
        public void n(int i2, String s) {
            if (i2 == 0) {
                c.this.t(c.f14883d, s);
            }
        }
    }

    /* renamed from: com.martian.mipush.c$c */
    /* loaded from: classes4.dex */
    class C0280c extends com.martian.mipush.e.b {
        C0280c() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            c.this.p = false;
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(Boolean aBoolean) {
            c.this.p = false;
            if (aBoolean == null || !aBoolean.booleanValue()) {
                return;
            }
            h.F().y1(h.f9890i, c.this.o);
            h.F().y1(h.f9889h, c.this.n);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public interface d {
        void a(Context context, String content);

        void b(Context context, String content);

        void c(Context context, String content);
    }

    /* loaded from: classes4.dex */
    private static class e extends Handler {

        /* renamed from: a */
        private final d f14898a;

        /* renamed from: b */
        private final WeakReference<Context> f14899b;

        public e(Context context, d listener) {
            this.f14898a = listener;
            this.f14899b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            d dVar;
            Context context = this.f14899b.get();
            int i2 = msg.what;
            if (i2 == 1) {
                d dVar2 = this.f14898a;
                if (dVar2 != null) {
                    dVar2.b(context, (String) msg.obj);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3 && (dVar = this.f14898a) != null) {
                    dVar.c(context, (String) msg.obj);
                    return;
                }
                return;
            }
            d dVar3 = this.f14898a;
            if (dVar3 != null) {
                dVar3.a(context, (String) msg.obj);
            }
        }
    }

    public static c i() {
        if (f14884e == null) {
            f14884e = new c();
        }
        return f14884e;
    }

    public void m() {
        try {
            Class<?> cls = Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
            Object invoke = cls.getDeclaredMethod("fromContext", Context.class).invoke(cls, this.f14889j);
            if (invoke == null) {
                return;
            }
            String str = (String) invoke.getClass().getDeclaredMethod("getString", String.class).invoke(invoke, "client/app_id");
            Object invoke2 = Class.forName("com.huawei.hms.aaid.HmsInstanceId").getDeclaredMethod("getInstance", Context.class).invoke(cls, this.f14889j);
            if (invoke2 == null) {
                return;
            }
            t(f14880a, (String) invoke2.getClass().getDeclaredMethod("getToken", String.class, String.class).invoke(invoke2, str, "HCM"));
        } catch (Exception e2) {
            q0.e("getToken failed, " + e2);
        }
    }

    public void n(String miAppid, String miAppkey) {
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            cls.getDeclaredMethod("registerPush", Context.class, String.class, String.class).invoke(cls, this.f14889j, miAppid, miAppkey);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public void o(String appkey, String appSecret) {
        com.heytap.mcssdk.a.c0().U(this.f14889j, appkey, appSecret, new b());
    }

    public void p() {
        try {
            PushClient.getInstance(this.f14889j).initialize();
            PushClient.getInstance(this.f14889j).turnOnPush(new IPushActionListener() { // from class: com.martian.mipush.a
                @Override // com.vivo.push.IPushActionListener
                public final void onStateChanged(int i2) {
                    c.q(i2);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void q(int state) {
    }

    public void h(List<PushChannelInfo> pushChannelInfos) {
        if (pushChannelInfos == null || pushChannelInfos.isEmpty() || !l.A()) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) this.f14889j.getSystemService(NotificationManager.class);
        for (PushChannelInfo pushChannelInfo : pushChannelInfos) {
            NotificationChannel notificationChannel = new NotificationChannel(pushChannelInfo.getChannelId(), pushChannelInfo.getChannelName(), 3);
            if (!k.p(pushChannelInfo.getChannelDesc())) {
                notificationChannel.setDescription(pushChannelInfo.getChannelDesc());
            }
            if (!pushChannelInfo.isWithSound()) {
                notificationChannel.setSound(null, null);
                notificationChannel.enableVibration(false);
                notificationChannel.setVibrationPattern(new long[]{0});
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public String j() {
        return this.f14889j.getPackageName();
    }

    public void k(Message msg) {
        e eVar = this.k;
        if (eVar == null || msg == null) {
            return;
        }
        eVar.sendMessage(msg);
    }

    public void l(Context context, String xiaomiAppId, String xiaomiAppKey, String oppoAppkey, String oppoAppSecret, d l) {
        if (this.m) {
            return;
        }
        this.m = true;
        this.l = l;
        this.f14889j = context;
        if (this.k == null) {
            this.k = new e(context, this.l);
        }
        new a(context, oppoAppkey, oppoAppSecret, xiaomiAppId, xiaomiAppKey).start();
    }

    public void r(d l) {
        this.l = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s(boolean manual) {
        if (k.p(this.o) || k.p(this.n) || this.p) {
            return;
        }
        if (!this.o.equalsIgnoreCase(h.F().b0(h.f9890i)) || manual) {
            this.p = true;
            C0280c c0280c = new C0280c();
            ((SendPushTokenParams) c0280c.k()).setPushChannel(this.n);
            ((SendPushTokenParams) c0280c.k()).setRegId(this.o);
            c0280c.j();
        }
    }

    public void t(String pushChannel, String id) {
        this.n = pushChannel;
        this.o = id;
        if (h.F().h1()) {
            s(false);
        }
    }
}
