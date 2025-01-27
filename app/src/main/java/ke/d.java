package ke;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import b7.i;
import ba.l;
import ba.m;
import ba.o;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mipush.data.PushChannelInfo;
import com.martian.mipush.request.SendPushTokenParams;
import com.sigmob.sdk.base.mta.PointCategory;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l9.p0;
import q.a0;
import q.z;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: g */
    public static d f27784g = null;

    /* renamed from: h */
    public static String f27785h = "HUAWEI";

    /* renamed from: i */
    public static String f27786i = "HONOR";

    /* renamed from: j */
    public static String f27787j = "VIVO";

    /* renamed from: k */
    public static String f27788k = "XIAOMI";

    /* renamed from: l */
    public static String f27789l = "OPPO";

    /* renamed from: m */
    public static final int f27790m = 1;

    /* renamed from: n */
    public static final int f27791n = 2;

    /* renamed from: o */
    public static final int f27792o = 3;

    /* renamed from: a */
    public WeakReference<Context> f27793a;

    /* renamed from: b */
    public HandlerC0724d f27794b;

    /* renamed from: c */
    public c f27795c;

    /* renamed from: d */
    public String f27796d;

    /* renamed from: e */
    public String f27797e;

    /* renamed from: f */
    public boolean f27798f = false;

    public interface c {
        void a(Context context, String str);

        void b(Context context, String str);

        void c(Context context, String str);
    }

    /* renamed from: ke.d$d */
    public static class HandlerC0724d extends Handler {

        /* renamed from: a */
        public final c f27801a;

        /* renamed from: b */
        public final WeakReference<Context> f27802b;

        public HandlerC0724d(WeakReference<Context> weakReference, c cVar) {
            this.f27801a = cVar;
            this.f27802b = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            Context context = this.f27802b.get();
            int i10 = message.what;
            if (i10 == 1) {
                c cVar2 = this.f27801a;
                if (cVar2 != null) {
                    cVar2.b(context, (String) message.obj);
                    return;
                }
                return;
            }
            if (i10 != 2) {
                if (i10 == 3 && (cVar = this.f27801a) != null) {
                    cVar.c(context, (String) message.obj);
                    return;
                }
                return;
            }
            c cVar3 = this.f27801a;
            if (cVar3 != null) {
                cVar3.a(context, (String) message.obj);
            }
        }
    }

    public static d h() {
        if (f27784g == null) {
            f27784g = new d();
        }
        return f27784g;
    }

    public final void f(Context context) {
        Object systemService;
        if (m.u()) {
            ArrayList<PushChannelInfo> arrayList = new ArrayList();
            arrayList.add(new PushChannelInfo("tts_notification", ConfigSingleton.D().s("听书"), ConfigSingleton.D().s("显示听书信息，保持听书常驻"), false));
            arrayList.add(new PushChannelInfo("reading_record", ConfigSingleton.D().s("显示最近在读"), ConfigSingleton.D().s("显示最近在读的追更小说"), false));
            arrayList.add(new PushChannelInfo("push_activity", ConfigSingleton.D().s("福利活动通知"), ConfigSingleton.D().s("提现到账、红包活动消息推送"), true));
            arrayList.add(new PushChannelInfo("push_book", ConfigSingleton.D().s("章节更新推送"), ConfigSingleton.D().s("通知提示有更新的追更小说"), true));
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            for (PushChannelInfo pushChannelInfo : arrayList) {
                a0.a();
                NotificationChannel a10 = z.a(pushChannelInfo.getChannelId(), pushChannelInfo.getChannelName(), 3);
                if (!l.q(pushChannelInfo.getChannelDesc())) {
                    a10.setDescription(pushChannelInfo.getChannelDesc());
                }
                if (!pushChannelInfo.isWithSound()) {
                    a10.setSound(null, null);
                    a10.enableVibration(false);
                    a10.setVibrationPattern(new long[]{0});
                }
                notificationManager.createNotificationChannel(a10);
            }
        }
    }

    public final Handler g() {
        if (this.f27794b == null) {
            this.f27794b = new HandlerC0724d(this.f27793a, this.f27795c);
        }
        return this.f27794b;
    }

    public void i(Message message) {
        if (message != null) {
            g().sendMessage(message);
        }
    }

    public void j(Context context, String str, String str2, String str3, String str4, String str5, c cVar) {
        this.f27795c = cVar;
        this.f27793a = new WeakReference<>(context);
        try {
            f(context);
            if (e.c()) {
                l(context, str5);
            } else if (e.j()) {
                o(context);
            } else if (e.g()) {
                n(context, str3, str4);
            } else if (e.e()) {
                m(context, str, str2);
            } else if (e.d()) {
                k(context);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void k(Context context) {
        Boolean bool;
        Object invoke;
        try {
            Class<?> cls = Class.forName("com.hihonor.push.sdk.HonorPushClient");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", null);
            Object invoke2 = declaredMethod.invoke(cls, null);
            if (invoke2 == null || (bool = (Boolean) invoke2.getClass().getDeclaredMethod("checkSupportHonorPush", Context.class).invoke(invoke2, context)) == null || !bool.booleanValue() || (invoke = declaredMethod.invoke(cls, null)) == null) {
                return;
            }
            invoke.getClass().getDeclaredMethod(PointCategory.INIT, Context.class, Boolean.class).invoke(invoke, context, Boolean.TRUE);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void l(Context context, String str) {
        o.d(new Runnable() { // from class: ke.b

            /* renamed from: c */
            public final /* synthetic */ Context f27780c;

            /* renamed from: d */
            public final /* synthetic */ String f27781d;

            public /* synthetic */ b(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.p(context, str);
            }
        });
    }

    public final void m(Context context, String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            cls.getDeclaredMethod("registerPush", Context.class, String.class, String.class).invoke(cls, context, str, str2);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }

    public final void n(Context context, String str, String str2) {
        if (!x6.b.o0(context) || l.q(str)) {
            return;
        }
        x6.b.c0().J(context, str, str2, new a());
    }

    public final void o(Context context) {
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: ke.c

                /* renamed from: b */
                public final /* synthetic */ Context f27783b;

                public /* synthetic */ c(Context context2) {
                    context = context2;
                }

                @Override // com.vivo.push.IPushActionListener
                public final void onStateChanged(int i10) {
                    d.this.q(context, i10);
                }
            });
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ void p(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.huawei.hms.push.HmsMessaging");
            Object invoke = cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, context);
            if (invoke == null) {
                return;
            }
            invoke.getClass().getDeclaredMethod("setAutoInitEnabled", Boolean.TYPE).invoke(invoke, Boolean.TRUE);
            Class<?> cls2 = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
            Object invoke2 = cls2.getDeclaredMethod("getInstance", Context.class).invoke(cls2, context);
            if (invoke2 == null) {
                return;
            }
            p0.b("getToken");
            s(f27785h, (String) invoke2.getClass().getDeclaredMethod("getToken", String.class, String.class).invoke(invoke2, str, "HCM"));
        } catch (Exception e10) {
            p0.b("Exception:" + Arrays.toString(e10.getStackTrace()));
        }
    }

    public final /* synthetic */ void q(Context context, int i10) {
        if (i10 == 0) {
            String regId = PushClient.getInstance(context).getRegId();
            if (l.q(regId)) {
                return;
            }
            s(f27787j, regId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(boolean z10) {
        if (l.q(this.f27797e) || l.q(this.f27796d) || this.f27798f) {
            return;
        }
        if (!this.f27797e.equalsIgnoreCase(ConfigSingleton.D().T(ConfigSingleton.I)) || z10) {
            this.f27798f = true;
            b bVar = new b();
            ((SendPushTokenParams) bVar.k()).setPushChannel(this.f27796d);
            ((SendPushTokenParams) bVar.k()).setRegId(this.f27797e);
            bVar.j();
        }
    }

    public void s(String str, String str2) {
        this.f27796d = str;
        this.f27797e = str2;
        if (ConfigSingleton.D().V0()) {
            r(false);
        }
    }

    public class a implements a7.c {
        public a() {
        }

        @Override // a7.c
        public void n(int i10, String str) {
            if (i10 == 0) {
                d.this.s(d.f27789l, str);
            }
        }

        @Override // a7.c
        public void b(int i10) {
        }

        @Override // a7.c
        public void a(int i10, List<i> list) {
        }

        @Override // a7.c
        public void c(int i10, int i11) {
        }

        @Override // a7.c
        public void d(int i10, int i11) {
        }

        @Override // a7.c
        public void e(int i10, List<i> list) {
        }

        @Override // a7.c
        public void f(int i10, List<i> list) {
        }

        @Override // a7.c
        public void g(int i10, List<i> list) {
        }

        @Override // a7.c
        public void h(int i10, List<i> list) {
        }

        @Override // a7.c
        public void i(int i10, List<i> list) {
        }

        @Override // a7.c
        public void j(int i10, List<i> list) {
        }

        @Override // a7.c
        public void k(int i10, List<i> list) {
        }

        @Override // a7.c
        public void l(int i10, String str) {
        }

        @Override // a7.c
        public void m(int i10, List<i> list) {
        }
    }

    public class b extends le.b {
        public b() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            d.this.f27798f = false;
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(Boolean bool) {
            d.this.f27798f = false;
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            ConfigSingleton.D().j1(ConfigSingleton.I, d.this.f27797e);
            ConfigSingleton.D().j1(ConfigSingleton.H, d.this.f27796d);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
