package com.aggmoread.sdk.z.b.j;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.by;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a */
    private String f4612a;

    /* renamed from: b */
    private String f4613b;

    /* renamed from: c */
    private String f4614c;

    /* renamed from: d */
    private String f4615d;

    /* renamed from: g */
    private i f4618g;

    /* renamed from: k */
    private Context f4622k;

    /* renamed from: l */
    private k f4623l;

    /* renamed from: m */
    private int f4624m;

    /* renamed from: e */
    private int f4616e = by.f23697b;

    /* renamed from: f */
    private int f4617f = by.f23697b;

    /* renamed from: h */
    private final Map<String, String> f4619h = new HashMap();

    /* renamed from: i */
    private boolean f4620i = true;

    /* renamed from: j */
    private int f4621j = 3;

    /* renamed from: n */
    private final AtomicBoolean f4625n = new AtomicBoolean(false);

    /* renamed from: o */
    private final p f4626o = p.b();

    public static final class a {

        /* renamed from: a */
        private String f4627a;

        /* renamed from: b */
        private String f4628b;

        /* renamed from: c */
        private int f4629c;

        /* renamed from: d */
        private String f4630d;

        /* renamed from: e */
        private String f4631e;

        /* renamed from: f */
        private int f4632f;

        /* renamed from: g */
        private i f4633g;

        /* renamed from: h */
        private Context f4634h;

        /* renamed from: j */
        private boolean f4636j;

        /* renamed from: k */
        private k f4637k;

        /* renamed from: i */
        private int f4635i = 3;

        /* renamed from: l */
        private int f4638l = 3;

        /* renamed from: m */
        private final Map<String, String> f4639m = new HashMap();

        public a(Context context) {
            this.f4634h = context;
        }

        public a a(int i10) {
            this.f4635i = i10;
            return this;
        }

        public a b(int i10) {
            this.f4638l = i10;
            return this;
        }

        public a c(String str) {
            this.f4628b = str;
            return this;
        }

        public a a(i iVar) {
            this.f4633g = iVar;
            return this;
        }

        public a b(String str) {
            this.f4631e = str;
            return this;
        }

        public a a(k kVar) {
            this.f4637k = kVar;
            return this;
        }

        public a a(String str) {
            this.f4630d = str;
            return this;
        }

        public a a(boolean z10) {
            this.f4636j = z10;
            return this;
        }

        public n a() {
            n nVar = new n();
            if (!TextUtils.isEmpty(this.f4627a)) {
                nVar.f4612a = this.f4627a;
            }
            nVar.f4613b = this.f4628b;
            if (!TextUtils.isEmpty(this.f4631e)) {
                this.f4631e = this.f4631e.replace("apk", "tmp");
            }
            nVar.f4615d = this.f4631e;
            nVar.f4614c = this.f4630d;
            nVar.f4617f = this.f4632f;
            nVar.f4616e = this.f4629c;
            nVar.f4620i = this.f4636j;
            nVar.f4622k = this.f4634h;
            nVar.f4621j = this.f4635i;
            nVar.f4623l = this.f4637k;
            nVar.f4624m = this.f4638l;
            nVar.f4618g = this.f4637k != null ? new m(this.f4633g, this.f4637k) : this.f4633g;
            nVar.f4619h.putAll(this.f4639m);
            return nVar;
        }
    }

    public n() {
        UUID.randomUUID().toString();
    }

    public int b() {
        return this.f4617f;
    }

    public i e() {
        i iVar = this.f4618g;
        return iVar == null ? i.f4593a : iVar;
    }

    public String f() {
        return this.f4615d;
    }

    public Map<String, String> g() {
        return this.f4619h;
    }

    public String h() {
        return this.f4613b;
    }

    public int i() {
        return this.f4621j;
    }

    public int j() {
        return this.f4616e;
    }

    public boolean k() {
        return this.f4625n.get();
    }

    public boolean l() {
        return this.f4620i;
    }

    public void m() {
        com.aggmoread.sdk.z.b.d.c("DownloadRequest", "start enter, isStarted = " + this.f4626o.a());
        this.f4626o.a(this);
    }

    public String toString() {
        return "DownloadRequest{httpUrl='" + this.f4613b + "', filePath='" + this.f4614c + "', fileName='" + this.f4615d + "', readTimout=" + this.f4616e + ", connectionTimeout=" + this.f4617f + ", downloadListener=" + this.f4618g + ", skipIfCached=" + this.f4620i + ", maxRedirect=" + this.f4621j + ", context=" + this.f4622k + ", isCanceled=" + this.f4625n + ", isStarted=" + this.f4626o.a() + '}';
    }

    public Context c() {
        return this.f4622k;
    }

    public String d() {
        return this.f4614c;
    }

    public void a() {
        this.f4626o.c();
        this.f4625n.set(true);
        k kVar = this.f4623l;
        if (kVar != null) {
            kVar.a();
        }
    }
}
