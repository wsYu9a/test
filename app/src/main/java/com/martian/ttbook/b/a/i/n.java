package com.martian.ttbook.b.a.i;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ic.dm.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    private String f15011a;

    /* renamed from: b */
    private String f15012b;

    /* renamed from: c */
    private String f15013c;

    /* renamed from: d */
    private String f15014d;

    /* renamed from: g */
    private i f15017g;
    private Context k;
    private k l;
    private int m;

    /* renamed from: e */
    private int f15015e = Constants.DEFAULT_READ_TIMEOUT;

    /* renamed from: f */
    private int f15016f = Constants.DEFAULT_READ_TIMEOUT;

    /* renamed from: h */
    private final Map<String, String> f15018h = new HashMap();

    /* renamed from: i */
    private boolean f15019i = true;

    /* renamed from: j */
    private int f15020j = 3;
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final p o = p.d();

    public static final class a {

        /* renamed from: a */
        private String f15021a;

        /* renamed from: b */
        private String f15022b;

        /* renamed from: c */
        private int f15023c;

        /* renamed from: d */
        private String f15024d;

        /* renamed from: e */
        private String f15025e;

        /* renamed from: f */
        private int f15026f;

        /* renamed from: g */
        private i f15027g;

        /* renamed from: h */
        private Context f15028h;

        /* renamed from: j */
        private boolean f15030j;
        private k k;

        /* renamed from: i */
        private int f15029i = 3;
        private int l = 3;
        private final Map<String, String> m = new HashMap();

        public a(Context context) {
            this.f15028h = context;
        }

        public a a(int i2) {
            this.f15029i = i2;
            return this;
        }

        public a b(i iVar) {
            this.f15027g = iVar;
            return this;
        }

        public a c(k kVar) {
            this.k = kVar;
            return this;
        }

        public a d(String str) {
            this.f15024d = str;
            return this;
        }

        public a e(boolean z) {
            this.f15030j = z;
            return this;
        }

        public n f() {
            n nVar = new n();
            if (!TextUtils.isEmpty(this.f15021a)) {
                nVar.f15011a = this.f15021a;
            }
            nVar.f15012b = this.f15022b;
            if (!TextUtils.isEmpty(this.f15025e)) {
                this.f15025e = this.f15025e.replace("apk", "tmp");
            }
            nVar.f15014d = this.f15025e;
            nVar.f15013c = this.f15024d;
            nVar.f15016f = this.f15026f;
            nVar.f15015e = this.f15023c;
            nVar.f15019i = this.f15030j;
            nVar.k = this.f15028h;
            nVar.f15020j = this.f15029i;
            nVar.l = this.k;
            nVar.m = this.l;
            nVar.f15017g = this.k != null ? new m(this.f15027g, this.k) : this.f15027g;
            nVar.f15018h.putAll(this.m);
            return nVar;
        }

        public a g(int i2) {
            this.l = i2;
            return this;
        }

        public a h(String str) {
            this.f15025e = str;
            return this;
        }

        public a i(String str) {
            this.f15022b = str;
            return this;
        }
    }

    public n() {
        UUID.randomUUID().toString();
    }

    public int a() {
        return this.f15016f;
    }

    public Context j() {
        return this.k;
    }

    public String m() {
        return this.f15013c;
    }

    public i p() {
        i iVar = this.f15017g;
        return iVar == null ? i.f14992a : iVar;
    }

    public String r() {
        return this.f15014d;
    }

    public Map<String, String> s() {
        return this.f15018h;
    }

    public String t() {
        return this.f15012b;
    }

    public String toString() {
        return "DownloadRequest{httpUrl='" + this.f15012b + "', filePath='" + this.f15013c + "', fileName='" + this.f15014d + "', readTimout=" + this.f15015e + ", connectionTimeout=" + this.f15016f + ", downloadListener=" + this.f15017g + ", skipIfCached=" + this.f15019i + ", maxRedirect=" + this.f15020j + ", context=" + this.k + ", isCanceled=" + this.n + ", isStarted=" + this.o.c() + '}';
    }

    public int u() {
        return this.f15020j;
    }

    public int v() {
        return this.f15015e;
    }

    public boolean w() {
        return this.n.get();
    }

    public boolean x() {
        return this.f15019i;
    }

    public void y() {
        b.d.e.c.a.d.k("DownloadRequest", "start enter, isStarted = " + this.o.c());
        this.o.a(this);
    }
}
