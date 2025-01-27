package kg;

import android.os.Handler;
import android.os.Looper;
import com.tanx.exposer.achieve.AdMonitorType;
import hg.d;

/* loaded from: classes4.dex */
public class b implements kg.a {

    /* renamed from: a */
    public kg.a f27814a;

    /* renamed from: b */
    public Handler f27815b;

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f27816b;

        /* renamed from: c */
        public final /* synthetic */ AdMonitorType f27817c;

        /* renamed from: d */
        public final /* synthetic */ d f27818d;

        public a(String str, AdMonitorType adMonitorType, d dVar) {
            this.f27816b = str;
            this.f27817c = adMonitorType;
            this.f27818d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f27814a != null) {
                b.this.f27814a.tanxc_do(this.f27816b, this.f27817c, this.f27818d);
            }
        }
    }

    /* renamed from: kg.b$b */
    public class RunnableC0725b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ int f27820b;

        /* renamed from: c */
        public final /* synthetic */ String f27821c;

        /* renamed from: d */
        public final /* synthetic */ String f27822d;

        /* renamed from: e */
        public final /* synthetic */ AdMonitorType f27823e;

        /* renamed from: f */
        public final /* synthetic */ d f27824f;

        public RunnableC0725b(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
            this.f27820b = i10;
            this.f27821c = str;
            this.f27822d = str2;
            this.f27823e = adMonitorType;
            this.f27824f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f27814a != null) {
                b.this.f27814a.tanxc_do(this.f27820b, this.f27821c, this.f27822d, this.f27823e, this.f27824f);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ int f27826b;

        /* renamed from: c */
        public final /* synthetic */ String f27827c;

        /* renamed from: d */
        public final /* synthetic */ String f27828d;

        /* renamed from: e */
        public final /* synthetic */ AdMonitorType f27829e;

        /* renamed from: f */
        public final /* synthetic */ d f27830f;

        public c(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
            this.f27826b = i10;
            this.f27827c = str;
            this.f27828d = str2;
            this.f27829e = adMonitorType;
            this.f27830f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f27814a != null) {
                b.this.f27814a.tanxc_if(this.f27826b, this.f27827c, this.f27828d, this.f27829e, this.f27830f);
            }
        }
    }

    public void b(kg.a aVar) {
        this.f27814a = aVar;
    }

    public final synchronized Handler c() {
        try {
            if (this.f27815b == null) {
                this.f27815b = new Handler(tanxc_do());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f27815b;
    }

    @Override // kg.a
    public Looper tanxc_do() {
        kg.a aVar = this.f27814a;
        return (aVar == null || aVar.tanxc_do() == null) ? Looper.myLooper() : this.f27814a.tanxc_do();
    }

    @Override // kg.a
    public void tanxc_if(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
        if (this.f27814a != null) {
            c().post(new c(i10, str, str2, adMonitorType, dVar));
        }
    }

    @Override // kg.a
    public void tanxc_do(String str, AdMonitorType adMonitorType, d dVar) {
        if (this.f27814a != null) {
            c().post(new a(str, adMonitorType, dVar));
        }
    }

    @Override // kg.a
    public void tanxc_do(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
        if (this.f27814a != null) {
            c().post(new RunnableC0725b(i10, str, str2, adMonitorType, dVar));
        }
    }
}
