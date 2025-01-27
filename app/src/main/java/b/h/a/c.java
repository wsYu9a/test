package b.h.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import b.h.a.d;
import b.h.a.j.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.oplus.log.core.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static boolean f4924a = false;

    /* renamed from: b */
    private static boolean f4925b = false;

    /* renamed from: c */
    private b.h.a.j.c f4926c;

    /* renamed from: d */
    private b.h.a.a.c f4927d;

    /* renamed from: e */
    private i f4928e;

    /* renamed from: f */
    private C0053c f4929f;

    /* renamed from: g */
    private C0053c.C0054c f4930g;

    /* renamed from: h */
    private C0053c.e f4931h;

    /* renamed from: i */
    private b.h.a.h.d f4932i;

    /* renamed from: j */
    private Context f4933j;
    private com.oplus.log.core.c k;

    public static class b {

        /* renamed from: a */
        private b.h.a.d f4934a = new b.h.a.d();

        private String g(Context context, String str) {
            String str2;
            if (b.h.a.e.b.f4967a.isEmpty()) {
                if (TextUtils.isEmpty(b.h.a.e.i.f4990a)) {
                    int myPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
                    String str3 = null;
                    if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            if (next.pid == myPid) {
                                str3 = next.processName;
                                break;
                            }
                        }
                    }
                    b.h.a.e.i.f4990a = str3;
                }
                str2 = b.h.a.e.i.f4990a;
            } else {
                str2 = b.h.a.e.b.f4967a;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str + "/" + str2 + "/";
        }

        public b a(int i2) {
            this.f4934a.b(i2);
            return this;
        }

        public b b(d.b bVar) {
            this.f4934a.c(bVar);
            return this;
        }

        public b c(d.c cVar) {
            this.f4934a.d(cVar);
            return this;
        }

        public b d(b.h.a.j.a aVar) {
            this.f4934a.e(aVar);
            return this;
        }

        public b e(String str) {
            this.f4934a.f(str);
            return this;
        }

        public c f(Context context) {
            if (TextUtils.isEmpty(this.f4934a.o()) || context == null || context.getFilesDir() == null) {
                return null;
            }
            String m = this.f4934a.m();
            if (m == null || m.isEmpty()) {
                this.f4934a.l(g(context, context.getFilesDir().getAbsolutePath()));
            } else {
                this.f4934a.l(g(context, m));
            }
            c cVar = new c();
            cVar.c(context, this.f4934a);
            return cVar;
        }

        public b h(int i2) {
            this.f4934a.h(i2);
            return this;
        }

        public b i(String str) {
            this.f4934a.l(str);
            return this;
        }

        public b j(int i2) {
            this.f4934a.k(i2);
            return this;
        }

        public b k(String str) {
            this.f4934a.i(str);
            this.f4934a.n(str);
            return this;
        }

        public b l(String str) {
            this.f4934a.p(str);
            return this;
        }

        public b m(String str) {
            b.h.a.e.b.f4967a = str;
            return this;
        }
    }

    /* renamed from: b.h.a.c$c */
    public final class C0053c {

        /* renamed from: a */
        public List<d> f4935a;

        /* renamed from: b */
        public Application.ActivityLifecycleCallbacks f4936b = new a();

        /* renamed from: b.h.a.c$c$a */
        final class a implements Application.ActivityLifecycleCallbacks {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                List<d> list = C0053c.this.f4935a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                Iterator<d> it = C0053c.this.f4935a.iterator();
                while (it.hasNext()) {
                    it.next().a(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity) {
                List<d> list = C0053c.this.f4935a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                Iterator<d> it = C0053c.this.f4935a.iterator();
                while (it.hasNext()) {
                    it.next().b(activity);
                }
            }
        }

        /* renamed from: b.h.a.c$c$b */
        public final class b implements d {

            /* renamed from: a */
            static b.h.a.h.d f4938a;

            /* renamed from: b */
            private int f4939b = 0;

            /* renamed from: c */
            private boolean f4940c = false;

            /* renamed from: d */
            private Handler f4941d;

            /* renamed from: b.h.a.c$c$b$a */
            static final class a extends Handler {

                /* renamed from: a */
                private final WeakReference<Activity> f4942a;

                public a(Activity activity) {
                    this.f4942a = new WeakReference<>(activity);
                }

                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    d dVar;
                    Activity activity = this.f4942a.get();
                    if (activity != null) {
                        int i2 = message.what;
                        if (i2 == 123) {
                            Bitmap b2 = b.h.a.e.c.b(activity);
                            if (b2 == null) {
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("activity_name", (String) message.obj);
                            dVar = new d("screenshot", b2, (byte) 4, null, hashMap);
                        } else if (i2 != 124) {
                            return;
                        } else {
                            dVar = new d("Network_Info", b.h.a.e.c.c(), (byte) 4, null, null);
                        }
                        b.f4938a.a(dVar);
                    }
                }
            }

            public b(b.h.a.h.d dVar) {
                f4938a = dVar;
            }

            private void b(boolean z, boolean z2, Context context) {
                if (f4938a == null) {
                    return;
                }
                if (!z) {
                    int i2 = this.f4939b - 1;
                    this.f4939b = i2;
                    if (i2 == 0 || z2) {
                        f4938a.a(new d(com.umeng.analytics.pro.d.aw, "session end", (byte) 4, null, null));
                        return;
                    }
                    return;
                }
                int i3 = this.f4939b;
                this.f4939b = i3 + 1;
                if (i3 != 0 || z2) {
                    return;
                }
                f4938a.a(new d(com.umeng.analytics.pro.d.aw, "session start", (byte) 4, null, null));
                if (this.f4941d == null) {
                    this.f4941d = new a((Activity) context);
                }
                this.f4941d.sendEmptyMessage(124);
            }

            @Override // b.h.a.c.C0053c.d
            public final void a(Context context) {
                if (f4938a == null) {
                    return;
                }
                String simpleName = ((Activity) context).getClass().getSimpleName();
                b(true, this.f4940c, context);
                this.f4940c = false;
                f4938a.a(new d("activity_lifecycle", simpleName + " start ", (byte) 4, null, null));
            }

            @Override // b.h.a.c.C0053c.d
            public final void b(Context context) {
                if (f4938a == null) {
                    return;
                }
                Activity activity = (Activity) context;
                f4938a.a(new d("activity_lifecycle", activity.getClass().getSimpleName() + " stop ", (byte) 4, null, null));
                boolean z = activity.getChangingConfigurations() != 0;
                this.f4940c = z;
                b(false, z, null);
            }
        }

        /* renamed from: b.h.a.c$c$c */
        public final class C0054c implements Thread.UncaughtExceptionHandler {

            /* renamed from: a */
            private Thread.UncaughtExceptionHandler f4943a;

            /* renamed from: b */
            private b.h.a.h.d f4944b;

            public C0054c(b.h.a.h.d dVar) {
                this.f4944b = dVar;
            }

            public final void a(Context context) {
                this.f4943a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                if (this.f4944b == null) {
                    return;
                }
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.close();
                this.f4944b.b(new d("crash_info", stringWriter.toString(), (byte) 5, thread.getName(), null));
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4943a;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        }

        /* renamed from: b.h.a.c$c$d */
        public interface d {
            void a(Context context);

            void b(Context context);
        }

        /* renamed from: b.h.a.c$c$e */
        public final class e extends BroadcastReceiver {

            /* renamed from: a */
            private b.h.a.h.d f4945a;

            /* renamed from: b.h.a.c$c$e$a */
            final class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.f4945a != null) {
                        e.this.f4945a.a(new d("Network_Info", b.h.a.e.c.c(), (byte) 4, null, null));
                    }
                }
            }

            public e(b.h.a.h.d dVar) {
                this.f4945a = dVar;
            }

            public final void b(Context context) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(this, intentFilter);
                } catch (Throwable unused) {
                }
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                new Thread(new a()).start();
            }
        }

        /* renamed from: b.h.a.c$c$f */
        public final class f {

            /* renamed from: a */
            private b.h.a.h.d f4947a;

            public f(b.h.a.h.d dVar) {
                this.f4947a = dVar;
            }

            public final void a(Context context) {
                HashMap hashMap = new HashMap();
                hashMap.put(ExifInterface.TAG_MODEL, Build.PRODUCT);
                hashMap.put("BrandOS_version", b.h.a.e.f.a());
                hashMap.put("SDK_version", Build.VERSION.RELEASE);
                hashMap.put("ROM_version", Build.DISPLAY);
                hashMap.put("RAMSize", String.valueOf(b.h.a.e.e.a().get("MemTotal:")));
                hashMap.put("InternalFreeSpace", String.valueOf(b.h.a.e.c.a(Environment.getDataDirectory()) / 1024));
                hashMap.put("App_version", b.h.a.e.b.f(context));
                hashMap.put("App_versioncode", String.valueOf(b.h.a.e.b.h(context)));
                if (this.f4947a != null) {
                    this.f4947a.a(new d("BASE_INFO", "record_base_info", (byte) 4, null, hashMap));
                }
            }
        }
    }

    public final class d {

        /* renamed from: b */
        public Object f4949b;

        /* renamed from: c */
        public String f4950c;

        /* renamed from: d */
        public byte f4951d;

        /* renamed from: e */
        public String f4952e;

        /* renamed from: f */
        public HashMap<String, String> f4953f;

        /* renamed from: h */
        private Boolean f4955h = null;

        /* renamed from: a */
        public long f4948a = System.currentTimeMillis();

        /* renamed from: g */
        private b.h.a.a.a.a f4954g = null;

        public d(String str, Object obj, byte b2, String str2, HashMap<String, String> hashMap) {
            this.f4949b = obj;
            this.f4952e = str;
            this.f4951d = b2;
            this.f4950c = str2;
            this.f4953f = hashMap;
        }
    }

    private c() {
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static void i(boolean z) {
        f4924a = z;
    }

    public static boolean j() {
        return f4924a;
    }

    public static boolean k() {
        return f4925b;
    }

    public static b l() {
        return new b();
    }

    private void m() {
        C0053c c0053c = new C0053c();
        this.f4929f = c0053c;
        Context context = this.f4933j;
        b.h.a.h.d dVar = this.f4932i;
        if (context != null) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(c0053c.f4936b);
            ArrayList arrayList = new ArrayList();
            c0053c.f4935a = arrayList;
            arrayList.add(new C0053c.b(dVar));
        }
        if (this.f4930g == null) {
            C0053c.C0054c c0054c = new C0053c.C0054c(this.f4932i);
            this.f4930g = c0054c;
            c0054c.a(this.f4933j);
        }
        C0053c.e eVar = new C0053c.e(this.f4932i);
        this.f4931h = eVar;
        eVar.b(this.f4933j);
        new C0053c.f(this.f4932i).a(this.f4933j);
    }

    private void n() {
        C0053c.e eVar = this.f4931h;
        if (eVar != null) {
            try {
                this.f4933j.unregisterReceiver(eVar);
            } catch (Exception e2) {
                if (j()) {
                    e2.printStackTrace();
                }
            }
            this.f4931h = null;
        }
        C0053c c0053c = this.f4929f;
        if (c0053c != null) {
            Context context = this.f4933j;
            if (context != null) {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(c0053c.f4936b);
            }
            this.f4929f = null;
        }
        this.f4933j = null;
    }

    public final b.h.a.b a() {
        i iVar = this.f4928e;
        return iVar != null ? iVar : new i(null);
    }

    public final void b(int i2) {
        i iVar = this.f4928e;
        if (iVar != null) {
            iVar.j(i2);
        }
    }

    public final void c(Context context, b.h.a.d dVar) {
        if (dVar == null) {
            dVar = new b.h.a.d();
        }
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f4933j = applicationContext;
            b.h.a.e.b.c(applicationContext);
        }
        c.a aVar = new c.a();
        aVar.f16122a = dVar.m();
        aVar.f16123b = dVar.o();
        c.a a2 = aVar.a(dVar.u());
        a2.f16129h = dVar.r();
        a2.f16126e = "0123456789012345".getBytes();
        a2.f16127f = "0123456789012345".getBytes();
        com.oplus.log.core.c b2 = a2.b();
        this.k = b2;
        b.h.a.a.c cVar = new b.h.a.a.c(b2);
        this.f4927d = cVar;
        i iVar = new i(cVar);
        this.f4928e = iVar;
        iVar.g(dVar.s());
        this.f4928e.j(dVar.t());
        b.h.a.j.c cVar2 = new b.h.a.j.c(dVar);
        this.f4926c = cVar2;
        cVar2.c(this.f4927d);
        this.f4932i = new b.h.a.h.c(this.f4927d);
        this.f4928e.a("NearX-HLog", "sdk version : 4.0.6");
        m();
    }

    public final void d(c.i iVar) {
        b.h.a.j.c cVar = this.f4926c;
        if (cVar != null) {
            cVar.m(iVar);
        }
    }

    public final void e(String str, String str2, long j2, long j3, boolean z, String str3) {
        if (this.f4926c != null) {
            this.f4926c.j(new c.e(str, j2, j3, z, str2, str3), 0);
        }
    }

    public final void f(String str, String str2, c.g gVar) {
        b.h.a.j.c cVar = this.f4926c;
        if (cVar != null) {
            cVar.u(str, str2, gVar);
        }
    }

    public final void g(boolean z) {
        b.h.a.a.c cVar = this.f4927d;
        if (cVar != null) {
            if (z) {
                cVar.a();
            } else {
                cVar.b(null);
            }
        }
    }

    public final void h() {
        this.f4926c = null;
        this.f4928e = null;
        this.f4932i = null;
        n();
        this.f4927d = null;
    }
}
