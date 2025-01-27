package ph;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import nk.l;
import org.json.JSONException;
import org.json.JSONObject;
import ph.g;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: e */
    public static final String f29890e;

    /* renamed from: f */
    public static d f29891f;

    /* renamed from: b */
    public ScheduledFuture f29893b;

    /* renamed from: c */
    public Object f29894c = new Object();

    /* renamed from: d */
    public int f29895d = 0;

    /* renamed from: a */
    public final ScheduledExecutorService f29892a = Executors.newScheduledThreadPool(1, new fh.c("pool_c_r"));

    static {
        StringBuilder a10 = nh.b.a("CC.");
        a10.append(d.class.getSimpleName());
        f29890e = a10.toString();
    }

    public static void g() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        Log.i("Risk", "Exit!!!");
        Process.killProcess(Process.myPid());
    }

    public final synchronized void c() {
        if (this.f29893b != null) {
            return;
        }
        this.f29893b = this.f29892a.scheduleAtFixedRate(new Runnable() { // from class: ph.b
            public /* synthetic */ b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.e();
            }
        }, 0L, 1L, TimeUnit.MINUTES);
    }

    public final void d(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            f();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("riskUser", true);
                jSONObject.put("counter", this.f29895d);
                jSONObject.put(o3.a.f29032k, System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            l.c().u("RISK_USER_CHECKED", jSONObject);
            this.f29893b.cancel(false);
            this.f29893b = null;
        }
        synchronized (this.f29894c) {
            this.f29894c.notify();
        }
    }

    public final /* synthetic */ void e() {
        if (g.c()) {
            Log.d(f29890e, "check risk");
        }
        this.f29895d++;
        g.a(new g.a() { // from class: ph.c
            public /* synthetic */ c() {
            }

            @Override // ph.g.a
            public final void a(Object obj) {
                d.this.d(obj);
            }
        });
        synchronized (this.f29894c) {
            try {
                this.f29894c.wait();
            } catch (InterruptedException e10) {
                if (g.c()) {
                    Log.e(f29890e, "exception: " + e10);
                    e10.printStackTrace();
                }
            }
        }
    }

    public final void f() {
        new Thread(new Runnable() { // from class: ph.a
            @Override // java.lang.Runnable
            public final void run() {
                d.g();
            }
        }).start();
    }
}
