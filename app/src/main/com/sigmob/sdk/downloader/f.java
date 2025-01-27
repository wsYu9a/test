package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.util.SparseArray;
import com.sigmob.sdk.base.common.g0;
import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class f extends com.sigmob.sdk.downloader.core.a implements Comparable<f> {
    public static final int F = 3;
    public final File A;
    public File B;
    public String C;
    public File D;
    public int E;

    /* renamed from: c */
    public final int f19358c;

    /* renamed from: d */
    public volatile long f19359d;

    /* renamed from: e */
    public final String f19360e;

    /* renamed from: f */
    public final Uri f19361f;

    /* renamed from: g */
    public final Map<String, List<String>> f19362g;

    /* renamed from: h */
    public com.sigmob.sdk.downloader.core.breakpoint.c f19363h;

    /* renamed from: i */
    public final int f19364i;

    /* renamed from: j */
    public final int f19365j;

    /* renamed from: k */
    public final int f19366k;

    /* renamed from: l */
    public final int f19367l;

    /* renamed from: m */
    public final int f19368m;

    /* renamed from: n */
    public final Integer f19369n;

    /* renamed from: o */
    public final Boolean f19370o;

    /* renamed from: p */
    public final boolean f19371p;

    /* renamed from: q */
    public final boolean f19372q;

    /* renamed from: r */
    public final int f19373r;

    /* renamed from: s */
    public volatile com.sigmob.sdk.downloader.c f19374s;

    /* renamed from: t */
    public volatile SparseArray<Object> f19375t;

    /* renamed from: u */
    public Object f19376u;

    /* renamed from: v */
    public final boolean f19377v;

    /* renamed from: w */
    public final AtomicLong f19378w = new AtomicLong();

    /* renamed from: x */
    public final boolean f19379x;

    /* renamed from: y */
    public final g.a f19380y;

    /* renamed from: z */
    public final File f19381z;

    public static class a {

        /* renamed from: q */
        public static final int f19382q = 4096;

        /* renamed from: r */
        public static final int f19383r = 16384;

        /* renamed from: s */
        public static final int f19384s = 65536;

        /* renamed from: t */
        public static final int f19385t = 2000;

        /* renamed from: u */
        public static final boolean f19386u = true;

        /* renamed from: v */
        public static final int f19387v = 1000;

        /* renamed from: w */
        public static final boolean f19388w = true;

        /* renamed from: x */
        public static final boolean f19389x = false;

        /* renamed from: a */
        public final String f19390a;

        /* renamed from: b */
        public final Uri f19391b;

        /* renamed from: c */
        public volatile Map<String, List<String>> f19392c;

        /* renamed from: d */
        public int f19393d;

        /* renamed from: e */
        public int f19394e;

        /* renamed from: f */
        public int f19395f;

        /* renamed from: g */
        public int f19396g;

        /* renamed from: h */
        public int f19397h;

        /* renamed from: i */
        public boolean f19398i;

        /* renamed from: j */
        public int f19399j;

        /* renamed from: k */
        public String f19400k;

        /* renamed from: l */
        public boolean f19401l;

        /* renamed from: m */
        public boolean f19402m;

        /* renamed from: n */
        public Boolean f19403n;

        /* renamed from: o */
        public Integer f19404o;

        /* renamed from: p */
        public Boolean f19405p;

        public a(String str, Uri uri) {
            this.f19394e = 4096;
            this.f19395f = 16384;
            this.f19396g = 65536;
            this.f19397h = 2000;
            this.f19398i = true;
            this.f19399j = 1000;
            this.f19401l = true;
            this.f19402m = false;
            this.f19390a = str;
            this.f19391b = uri;
            if (com.sigmob.sdk.downloader.core.c.c(uri)) {
                this.f19400k = com.sigmob.sdk.downloader.core.c.a(uri);
            }
        }

        public synchronized void a(String str, String str2) {
            try {
                if (this.f19392c == null) {
                    this.f19392c = new HashMap();
                }
                List<String> list = this.f19392c.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f19392c.put(str, list);
                }
                list.add(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public a b(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f19395f = i10;
            return this;
        }

        public a c(int i10) {
            this.f19399j = i10;
            return this;
        }

        public a d(int i10) {
            this.f19393d = i10;
            return this;
        }

        public a e(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f19394e = i10;
            return this;
        }

        public a f(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f19397h = i10;
            return this;
        }

        public a g(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f19396g = i10;
            return this;
        }

        public a(String str, File file) {
            this.f19394e = 4096;
            this.f19395f = 16384;
            this.f19396g = 65536;
            this.f19397h = 2000;
            this.f19398i = true;
            this.f19399j = 1000;
            this.f19401l = true;
            this.f19402m = false;
            this.f19390a = str;
            this.f19391b = Uri.fromFile(file);
        }

        public f a() {
            return new f(this.f19390a, this.f19391b, this.f19393d, this.f19394e, this.f19395f, this.f19396g, this.f19397h, this.f19398i, this.f19399j, this.f19392c, this.f19400k, this.f19401l, this.f19402m, this.f19403n, this.f19404o, this.f19405p);
        }

        public a b(boolean z10) {
            this.f19401l = z10;
            return this;
        }

        public a c(boolean z10) {
            this.f19405p = Boolean.valueOf(z10);
            return this;
        }

        public a d(boolean z10) {
            this.f19402m = z10;
            return this;
        }

        public a(String str, String str2, String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str3)) {
                this.f19403n = Boolean.TRUE;
            } else {
                this.f19400k = str3;
            }
        }

        public a a(boolean z10) {
            this.f19398i = z10;
            return this;
        }

        public a a(int i10) {
            this.f19404o = Integer.valueOf(i10);
            return this;
        }

        public a a(String str) {
            this.f19400k = str;
            return this;
        }

        public a a(Boolean bool) {
            if (!com.sigmob.sdk.downloader.core.c.d(this.f19391b)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.f19403n = bool;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.f19392c = map;
            return this;
        }
    }

    public static class b extends com.sigmob.sdk.downloader.core.a {

        /* renamed from: c */
        public final int f19406c;

        /* renamed from: d */
        public final String f19407d;

        /* renamed from: e */
        public final File f19408e;

        /* renamed from: f */
        public final String f19409f;

        /* renamed from: g */
        public final File f19410g;

        public b(int i10) {
            this.f19406c = i10;
            this.f19407d = "";
            File file = com.sigmob.sdk.downloader.core.a.f18996b;
            this.f19408e = file;
            this.f19409f = null;
            this.f19410g = file;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String a() {
            return this.f19409f;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public int b() {
            return this.f19406c;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public File c() {
            return this.f19410g;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public File d() {
            return this.f19408e;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String e() {
            return this.f19407d;
        }

        public b(int i10, f fVar) {
            this.f19406c = i10;
            this.f19407d = fVar.f19360e;
            this.f19410g = fVar.c();
            this.f19408e = fVar.f19381z;
            this.f19409f = fVar.a();
        }
    }

    public static class c {
        public static long a(f fVar) {
            return fVar.o();
        }

        public static void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            fVar.a(cVar);
        }

        public static void a(f fVar, long j10) {
            fVar.a(j10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x010c, code lost:
    
        if (com.sigmob.sdk.downloader.core.c.a((java.lang.CharSequence) r16) != false) goto L162;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f(java.lang.String r6, android.net.Uri r7, int r8, int r9, int r10, int r11, int r12, boolean r13, int r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15, java.lang.String r16, boolean r17, boolean r18, java.lang.Boolean r19, java.lang.Integer r20, java.lang.Boolean r21) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.f.<init>(java.lang.String, android.net.Uri, int, int, int, int, int, boolean, int, java.util.Map, java.lang.String, boolean, boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean):void");
    }

    public Uri A() {
        return this.f19361f;
    }

    public boolean B() {
        return this.f19372q;
    }

    public boolean C() {
        return this.f19379x;
    }

    public boolean D() {
        return this.f19371p;
    }

    public boolean E() {
        return this.f19377v;
    }

    public synchronized void F() {
        this.f19376u = null;
    }

    public boolean G() {
        int i10 = this.E;
        this.E = i10 + 1;
        if (i10 >= 3) {
            return false;
        }
        g.j().e().a(this);
        return true;
    }

    public a H() {
        return a(this.f19360e, this.f19361f);
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(f fVar) {
        return fVar.r() - r();
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public File d() {
        return this.f19381z;
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String e() {
        return this.f19360e;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.f19358c == this.f19358c) {
            return true;
        }
        return a((com.sigmob.sdk.downloader.core.a) fVar);
    }

    public void f() {
        if (System.currentTimeMillis() - this.f19359d < 500) {
            g0.makeText(com.sigmob.sdk.a.d(), "操作太频繁", 0).show();
        } else {
            this.f19359d = System.currentTimeMillis();
            g.j().e().a((com.sigmob.sdk.downloader.core.a) this);
        }
    }

    public void g() {
        if (System.currentTimeMillis() - this.f19359d < 500) {
            g0.makeText(com.sigmob.sdk.a.d(), "操作太频繁", 0).show();
        } else {
            this.f19359d = System.currentTimeMillis();
            g.j().e().a(this);
        }
    }

    public void h() {
        g.j().e().d(this);
    }

    public int hashCode() {
        return (this.f19360e + this.f19381z.toString() + this.f19380y.a()).hashCode();
    }

    public int i() {
        com.sigmob.sdk.downloader.core.breakpoint.c cVar = this.f19363h;
        if (cVar == null) {
            return 0;
        }
        return cVar.b();
    }

    public File j() {
        String a10 = this.f19380y.a();
        if (a10 == null) {
            return null;
        }
        if (this.B == null) {
            this.B = new File(this.A, a10);
        }
        return this.B;
    }

    public g.a k() {
        return this.f19380y;
    }

    public int l() {
        return this.f19366k;
    }

    public Map<String, List<String>> m() {
        return this.f19362g;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c n() {
        if (this.f19363h == null) {
            this.f19363h = g.j().a().h(this.f19358c);
        }
        return this.f19363h;
    }

    public long o() {
        return this.f19378w.get();
    }

    public com.sigmob.sdk.downloader.c p() {
        return this.f19374s;
    }

    public int q() {
        return this.f19373r;
    }

    public int r() {
        return this.f19364i;
    }

    public int s() {
        return this.f19365j;
    }

    public String t() {
        return this.C;
    }

    public String toString() {
        return super.toString() + "@" + this.f19358c + "@" + this.f19360e + "@" + this.A.toString() + "/" + this.f19380y.a();
    }

    public Integer u() {
        return this.f19369n;
    }

    public Boolean v() {
        return this.f19370o;
    }

    public int w() {
        return this.f19368m;
    }

    public int x() {
        return this.f19367l;
    }

    public Object y() {
        return this.f19376u;
    }

    public File z() {
        String str = this.f19380y.a() + ".tmp";
        if (str == null) {
            return null;
        }
        if (this.D == null) {
            this.D = new File(this.A, str);
        }
        return this.D;
    }

    public synchronized f a(int i10, Object obj) {
        try {
            if (this.f19375t == null) {
                synchronized (this) {
                    try {
                        if (this.f19375t == null) {
                            this.f19375t = new SparseArray<>();
                        }
                    } finally {
                    }
                }
            }
            this.f19375t.put(i10, obj);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    public void b(com.sigmob.sdk.downloader.c cVar) {
        this.f19374s = cVar;
        g.j().e().d(this);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public File c() {
        return this.A;
    }

    public synchronized void d(int i10) {
        if (this.f19375t != null) {
            this.f19375t.remove(i10);
        }
    }

    public static void a(f[] fVarArr) {
        g.j().e().a((com.sigmob.sdk.downloader.core.a[]) fVarArr);
    }

    public static b c(int i10) {
        return new b(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public int b() {
        return this.f19358c;
    }

    public void d(f fVar) {
        this.f19376u = fVar.f19376u;
        this.f19375t = fVar.f19375t;
    }

    public void a(com.sigmob.sdk.downloader.c cVar) {
        this.f19374s = cVar;
        g.j().e().a(this);
    }

    public b b(int i10) {
        return new b(i10, this);
    }

    public void c(com.sigmob.sdk.downloader.c cVar) {
        this.f19374s = cVar;
    }

    public static void a(f[] fVarArr, com.sigmob.sdk.downloader.c cVar) {
        for (f fVar : fVarArr) {
            fVar.f19374s = cVar;
        }
        g.j().e().a(fVarArr);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String a() {
        return this.f19380y.a() + ".tmp";
    }

    public Object a(int i10) {
        if (this.f19375t == null) {
            return null;
        }
        return this.f19375t.get(i10);
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f19363h = cVar;
    }

    public void a(long j10) {
        this.f19378w.set(j10);
    }

    public void a(String str) {
        this.C = str;
    }

    public void a(Object obj) {
        this.f19376u = obj;
    }

    public a a(String str, Uri uri) {
        a b10 = new a(str, uri).d(this.f19364i).e(this.f19365j).b(this.f19366k).g(this.f19367l).f(this.f19368m).a(this.f19372q).c(this.f19373r).a(this.f19362g).b(this.f19371p);
        if (com.sigmob.sdk.downloader.core.c.d(uri) && !new File(uri.getPath()).isFile() && com.sigmob.sdk.downloader.core.c.d(this.f19361f) && this.f19380y.a() != null && !new File(this.f19361f.getPath()).getName().equals(this.f19380y.a())) {
            b10.a(this.f19380y.a());
        }
        return b10;
    }
}
