package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.listener.f;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: f */
    public static final String f18966f = "DownloadContext";

    /* renamed from: g */
    public static final Executor f18967g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Serial", false));

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.f[] f18968a;

    /* renamed from: b */
    public volatile boolean f18969b;

    /* renamed from: c */
    public final com.sigmob.sdk.downloader.b f18970c;

    /* renamed from: d */
    public final f f18971d;

    /* renamed from: e */
    public Handler f18972e;

    /* renamed from: com.sigmob.sdk.downloader.a$a */
    public class RunnableC0582a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f18973a;

        /* renamed from: b */
        public final /* synthetic */ com.sigmob.sdk.downloader.c f18974b;

        public RunnableC0582a(List list, com.sigmob.sdk.downloader.c cVar) {
            this.f18973a = list;
            this.f18974b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.sigmob.sdk.downloader.f fVar : this.f18973a) {
                if (!a.this.c()) {
                    a.this.a(fVar.B());
                    return;
                }
                fVar.b(this.f18974b);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f18970c.a(aVar);
        }
    }

    public static class c {

        /* renamed from: a */
        public final a f18977a;

        public c(a aVar) {
            this.f18977a = aVar;
        }

        public c a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.f fVar2) {
            com.sigmob.sdk.downloader.f[] fVarArr = this.f18977a.f18968a;
            for (int i10 = 0; i10 < fVarArr.length; i10++) {
                if (fVarArr[i10] == fVar) {
                    fVarArr[i10] = fVar2;
                }
            }
            return this;
        }
    }

    public static class d {

        /* renamed from: a */
        public final ArrayList<com.sigmob.sdk.downloader.f> f18978a;

        /* renamed from: b */
        public final f f18979b;

        /* renamed from: c */
        public com.sigmob.sdk.downloader.b f18980c;

        public d() {
            this(new f());
        }

        public com.sigmob.sdk.downloader.f a(f.a aVar) {
            if (this.f18979b.f18984a != null) {
                aVar.a(this.f18979b.f18984a);
            }
            if (this.f18979b.f18986c != null) {
                aVar.e(this.f18979b.f18986c.intValue());
            }
            if (this.f18979b.f18987d != null) {
                aVar.b(this.f18979b.f18987d.intValue());
            }
            if (this.f18979b.f18988e != null) {
                aVar.g(this.f18979b.f18988e.intValue());
            }
            if (this.f18979b.f18993j != null) {
                aVar.d(this.f18979b.f18993j.booleanValue());
            }
            if (this.f18979b.f18989f != null) {
                aVar.f(this.f18979b.f18989f.intValue());
            }
            if (this.f18979b.f18990g != null) {
                aVar.a(this.f18979b.f18990g.booleanValue());
            }
            if (this.f18979b.f18991h != null) {
                aVar.c(this.f18979b.f18991h.intValue());
            }
            if (this.f18979b.f18992i != null) {
                aVar.b(this.f18979b.f18992i.booleanValue());
            }
            com.sigmob.sdk.downloader.f a10 = aVar.a();
            if (this.f18979b.f18994k != null) {
                a10.a(this.f18979b.f18994k);
            }
            this.f18978a.add(a10);
            return a10;
        }

        public void b(com.sigmob.sdk.downloader.f fVar) {
            this.f18978a.remove(fVar);
        }

        public d(f fVar) {
            this(fVar, new ArrayList());
        }

        public com.sigmob.sdk.downloader.f a(String str) {
            if (this.f18979b.f18985b != null) {
                return a(new f.a(str, this.f18979b.f18985b).a(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public d(f fVar, ArrayList<com.sigmob.sdk.downloader.f> arrayList) {
            this.f18979b = fVar;
            this.f18978a = arrayList;
        }

        public d a(com.sigmob.sdk.downloader.f fVar) {
            int indexOf = this.f18978a.indexOf(fVar);
            if (indexOf >= 0) {
                this.f18978a.set(indexOf, fVar);
            } else {
                this.f18978a.add(fVar);
            }
            return this;
        }

        public a a() {
            return new a((com.sigmob.sdk.downloader.f[]) this.f18978a.toArray(new com.sigmob.sdk.downloader.f[this.f18978a.size()]), this.f18980c, this.f18979b);
        }

        public d a(com.sigmob.sdk.downloader.b bVar) {
            this.f18980c = bVar;
            return this;
        }

        public void a(int i10) {
            for (com.sigmob.sdk.downloader.f fVar : (List) this.f18978a.clone()) {
                if (fVar.b() == i10) {
                    this.f18978a.remove(fVar);
                }
            }
        }
    }

    public static class e extends com.sigmob.sdk.downloader.core.listener.b {

        /* renamed from: a */
        public final AtomicInteger f18981a;

        /* renamed from: b */
        public final com.sigmob.sdk.downloader.b f18982b;

        /* renamed from: c */
        public final a f18983c;

        public e(a aVar, com.sigmob.sdk.downloader.b bVar, int i10) {
            this.f18981a = new AtomicInteger(i10);
            this.f18982b = bVar;
            this.f18983c = aVar;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar) {
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            int decrementAndGet = this.f18981a.decrementAndGet();
            this.f18982b.a(this.f18983c, fVar, aVar, exc, decrementAndGet);
            if (decrementAndGet <= 0) {
                this.f18982b.a(this.f18983c);
                com.sigmob.sdk.downloader.core.c.a(a.f18966f, "taskEnd and remainCount " + decrementAndGet);
            }
        }
    }

    public static class f {

        /* renamed from: a */
        public Map<String, List<String>> f18984a;

        /* renamed from: b */
        public Uri f18985b;

        /* renamed from: c */
        public Integer f18986c;

        /* renamed from: d */
        public Integer f18987d;

        /* renamed from: e */
        public Integer f18988e;

        /* renamed from: f */
        public Integer f18989f;

        /* renamed from: g */
        public Boolean f18990g;

        /* renamed from: h */
        public Integer f18991h;

        /* renamed from: i */
        public Boolean f18992i;

        /* renamed from: j */
        public Boolean f18993j;

        /* renamed from: k */
        public Object f18994k;

        public boolean l() {
            Boolean bool = this.f18993j;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public d a() {
            return new d(this);
        }

        public Uri b() {
            return this.f18985b;
        }

        public int c() {
            Integer num = this.f18987d;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public Map<String, List<String>> d() {
            return this.f18984a;
        }

        public int e() {
            Integer num = this.f18991h;
            if (num == null) {
                return 1000;
            }
            return num.intValue();
        }

        public int f() {
            Integer num = this.f18986c;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.f18989f;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int h() {
            Integer num = this.f18988e;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public Object i() {
            return this.f18994k;
        }

        public boolean j() {
            Boolean bool = this.f18990g;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean k() {
            Boolean bool = this.f18992i;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public f a(Boolean bool) {
            this.f18990g = bool;
            return this;
        }

        public f b(int i10) {
            this.f18986c = Integer.valueOf(i10);
            return this;
        }

        public f c(int i10) {
            this.f18989f = Integer.valueOf(i10);
            return this;
        }

        public f d(int i10) {
            this.f18988e = Integer.valueOf(i10);
            return this;
        }

        public f a(int i10) {
            this.f18987d = Integer.valueOf(i10);
            return this;
        }

        public f b(Boolean bool) {
            this.f18993j = bool;
            return this;
        }

        public void a(Map<String, List<String>> map) {
            this.f18984a = map;
        }

        public f a(Integer num) {
            this.f18991h = num;
            return this;
        }

        public f a(String str) {
            return a(new File(str));
        }

        public f a(File file) {
            if (file.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.f18985b = Uri.fromFile(file);
            return this;
        }

        public f a(Uri uri) {
            this.f18985b = uri;
            return this;
        }

        public f a(boolean z10) {
            this.f18992i = Boolean.valueOf(z10);
            return this;
        }

        public f a(Object obj) {
            this.f18994k = obj;
            return this;
        }
    }

    public a(com.sigmob.sdk.downloader.f[] fVarArr, com.sigmob.sdk.downloader.b bVar, f fVar) {
        this.f18969b = false;
        this.f18968a = fVarArr;
        this.f18970c = bVar;
        this.f18971d = fVar;
    }

    public com.sigmob.sdk.downloader.f[] b() {
        return this.f18968a;
    }

    public boolean c() {
        return this.f18969b;
    }

    public void d() {
        if (this.f18969b) {
            g.j().e().a((com.sigmob.sdk.downloader.core.a[]) this.f18968a);
        }
        this.f18969b = false;
    }

    public d e() {
        return new d(this.f18971d, new ArrayList(Arrays.asList(this.f18968a))).a(this.f18970c);
    }

    public a(com.sigmob.sdk.downloader.f[] fVarArr, com.sigmob.sdk.downloader.b bVar, f fVar, Handler handler) {
        this(fVarArr, bVar, fVar);
        this.f18972e = handler;
    }

    public void b(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, true);
    }

    public c a() {
        return new c(this);
    }

    public final void a(boolean z10) {
        com.sigmob.sdk.downloader.b bVar = this.f18970c;
        if (bVar == null) {
            return;
        }
        if (!z10) {
            bVar.a(this);
            return;
        }
        if (this.f18972e == null) {
            this.f18972e = new Handler(Looper.getMainLooper());
        }
        this.f18972e.post(new b());
    }

    public void a(Runnable runnable) {
        f18967g.execute(runnable);
    }

    public void a(com.sigmob.sdk.downloader.c cVar, boolean z10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        com.sigmob.sdk.downloader.core.c.a(f18966f, "start " + z10);
        this.f18969b = true;
        if (this.f18970c != null) {
            cVar = new f.a().a(cVar).a(new e(this, this.f18970c, this.f18968a.length)).a();
        }
        if (z10) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.f18968a);
            Collections.sort(arrayList);
            a(new RunnableC0582a(arrayList, cVar));
        } else {
            com.sigmob.sdk.downloader.f.a(this.f18968a, cVar);
        }
        com.sigmob.sdk.downloader.core.c.a(f18966f, "start finish " + z10 + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    public void a(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, false);
    }
}
