package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: c */
    public static final String f19127c = "CallbackDispatcher";

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.c f19128a;

    /* renamed from: b */
    public final Handler f19129b;

    /* renamed from: com.sigmob.sdk.downloader.core.dispatcher.a$a */
    public class RunnableC0586a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Collection f19130a;

        /* renamed from: b */
        public final /* synthetic */ Exception f19131b;

        public RunnableC0586a(Collection collection, Exception exc) {
            this.f19130a = collection;
            this.f19131b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f19130a) {
                com.sigmob.sdk.downloader.c p10 = fVar.p();
                if (p10 != null) {
                    p10.a(fVar, com.sigmob.sdk.downloader.core.cause.a.ERROR, this.f19131b);
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Collection f19133a;

        /* renamed from: b */
        public final /* synthetic */ Collection f19134b;

        /* renamed from: c */
        public final /* synthetic */ Collection f19135c;

        public b(Collection collection, Collection collection2, Collection collection3) {
            this.f19133a = collection;
            this.f19134b = collection2;
            this.f19135c = collection3;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f19133a) {
                com.sigmob.sdk.downloader.c p10 = fVar.p();
                if (p10 != null) {
                    p10.a(fVar, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                }
            }
            for (f fVar2 : this.f19134b) {
                com.sigmob.sdk.downloader.c p11 = fVar2.p();
                if (p11 != null) {
                    p11.a(fVar2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                }
            }
            for (f fVar3 : this.f19135c) {
                com.sigmob.sdk.downloader.c p12 = fVar3.p();
                if (p12 != null) {
                    p12.a(fVar3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Collection f19137a;

        public c(Collection collection) {
            this.f19137a = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f19137a) {
                com.sigmob.sdk.downloader.c p10 = fVar.p();
                if (p10 != null) {
                    p10.a(fVar, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                }
            }
        }
    }

    public static class d implements com.sigmob.sdk.downloader.c {

        /* renamed from: a */
        public final Handler f19139a;

        /* renamed from: com.sigmob.sdk.downloader.core.dispatcher.a$d$a */
        public class RunnableC0587a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19140a;

            /* renamed from: b */
            public final /* synthetic */ int f19141b;

            /* renamed from: c */
            public final /* synthetic */ long f19142c;

            public RunnableC0587a(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
                this.f19140a = fVar;
                this.f19141b = i10;
                this.f19142c = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19140a.p();
                if (p10 != null) {
                    p10.d(this.f19140a, this.f19141b, this.f19142c);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19144a;

            /* renamed from: b */
            public final /* synthetic */ com.sigmob.sdk.downloader.core.cause.a f19145b;

            /* renamed from: c */
            public final /* synthetic */ Exception f19146c;

            public b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
                this.f19144a = fVar;
                this.f19145b = aVar;
                this.f19146c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19144a.p();
                if (p10 != null) {
                    p10.a(this.f19144a, this.f19145b, this.f19146c);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19148a;

            public c(com.sigmob.sdk.downloader.f fVar) {
                this.f19148a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19148a.p();
                if (p10 != null) {
                    p10.a(this.f19148a);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.downloader.core.dispatcher.a$d$d */
        public class RunnableC0588d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19150a;

            /* renamed from: b */
            public final /* synthetic */ Map f19151b;

            public RunnableC0588d(com.sigmob.sdk.downloader.f fVar, Map map) {
                this.f19150a = fVar;
                this.f19151b = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19150a.p();
                if (p10 != null) {
                    p10.a(this.f19150a, this.f19151b);
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19153a;

            /* renamed from: b */
            public final /* synthetic */ int f19154b;

            /* renamed from: c */
            public final /* synthetic */ Map f19155c;

            public e(com.sigmob.sdk.downloader.f fVar, int i10, Map map) {
                this.f19153a = fVar;
                this.f19154b = i10;
                this.f19155c = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19153a.p();
                if (p10 != null) {
                    p10.b(this.f19153a, this.f19154b, this.f19155c);
                }
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19157a;

            /* renamed from: b */
            public final /* synthetic */ com.sigmob.sdk.downloader.core.breakpoint.c f19158b;

            /* renamed from: c */
            public final /* synthetic */ com.sigmob.sdk.downloader.core.cause.b f19159c;

            public f(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
                this.f19157a = fVar;
                this.f19158b = cVar;
                this.f19159c = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19157a.p();
                if (p10 != null) {
                    p10.a(this.f19157a, this.f19158b, this.f19159c);
                }
            }
        }

        public class g implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19161a;

            /* renamed from: b */
            public final /* synthetic */ com.sigmob.sdk.downloader.core.breakpoint.c f19162b;

            public g(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
                this.f19161a = fVar;
                this.f19162b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19161a.p();
                if (p10 != null) {
                    p10.a(this.f19161a, this.f19162b);
                }
            }
        }

        public class h implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19164a;

            /* renamed from: b */
            public final /* synthetic */ int f19165b;

            /* renamed from: c */
            public final /* synthetic */ Map f19166c;

            public h(com.sigmob.sdk.downloader.f fVar, int i10, Map map) {
                this.f19164a = fVar;
                this.f19165b = i10;
                this.f19166c = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19164a.p();
                if (p10 != null) {
                    p10.a(this.f19164a, this.f19165b, this.f19166c);
                }
            }
        }

        public class i implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19168a;

            /* renamed from: b */
            public final /* synthetic */ int f19169b;

            /* renamed from: c */
            public final /* synthetic */ int f19170c;

            /* renamed from: d */
            public final /* synthetic */ Map f19171d;

            public i(com.sigmob.sdk.downloader.f fVar, int i10, int i11, Map map) {
                this.f19168a = fVar;
                this.f19169b = i10;
                this.f19170c = i11;
                this.f19171d = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19168a.p();
                if (p10 != null) {
                    p10.a(this.f19168a, this.f19169b, this.f19170c, this.f19171d);
                }
            }
        }

        public class j implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19173a;

            /* renamed from: b */
            public final /* synthetic */ int f19174b;

            /* renamed from: c */
            public final /* synthetic */ long f19175c;

            public j(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
                this.f19173a = fVar;
                this.f19174b = i10;
                this.f19175c = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19173a.p();
                if (p10 != null) {
                    p10.a(this.f19173a, this.f19174b, this.f19175c);
                }
            }
        }

        public class k implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f19177a;

            /* renamed from: b */
            public final /* synthetic */ int f19178b;

            /* renamed from: c */
            public final /* synthetic */ long f19179c;

            public k(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
                this.f19177a = fVar;
                this.f19178b = i10;
                this.f19179c = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.downloader.c p10 = this.f19177a.p();
                if (p10 != null) {
                    p10.b(this.f19177a, this.f19178b, this.f19179c);
                }
            }
        }

        public d(Handler handler) {
            this.f19139a = handler;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, int i10, int i11, Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "<----- finish connection task(" + fVar.b() + ") block(" + i10 + ") code[" + i11 + "]" + map);
            if (fVar.B()) {
                this.f19139a.post(new i(fVar, i10, i11, map));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, i10, i11, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "<----- finish trial task(" + fVar.b() + ") code[" + i10 + "]" + map);
            if (fVar.B()) {
                this.f19139a.post(new e(fVar, i10, map));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.b(fVar, i10, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void d(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "fetchEnd: " + fVar.b());
            if (fVar.B()) {
                this.f19139a.post(new RunnableC0587a(fVar, i10, j10));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.d(fVar, i10, j10);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "-----> start connection task(" + fVar.b() + ") block(" + i10 + ") " + map);
            if (fVar.B()) {
                this.f19139a.post(new h(fVar, i10, map));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, i10, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
            if (fVar.q() > 0) {
                f.c.a(fVar, SystemClock.uptimeMillis());
            }
            if (fVar.B()) {
                this.f19139a.post(new k(fVar, i10, j10));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.b(fVar, i10, j10);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "-----> start trial task(" + fVar.b() + ") " + map);
            if (fVar.B()) {
                this.f19139a.post(new RunnableC0588d(fVar, map));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, map);
            }
        }

        public void b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
            com.sigmob.sdk.downloader.d g10 = com.sigmob.sdk.downloader.g.j().g();
            if (g10 != null) {
                g10.a(fVar, cVar, bVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "downloadFromBeginning: " + fVar.b());
            b(fVar, cVar, bVar);
            if (fVar.B()) {
                this.f19139a.post(new f(fVar, cVar, bVar));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, cVar, bVar);
            }
        }

        public void b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            com.sigmob.sdk.downloader.d g10 = com.sigmob.sdk.downloader.g.j().g();
            if (g10 != null) {
                g10.a(fVar, cVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "downloadFromBreakpoint: " + fVar.b());
            b(fVar, cVar);
            if (fVar.B()) {
                this.f19139a.post(new g(fVar, cVar));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, cVar);
            }
        }

        public void b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            com.sigmob.sdk.downloader.d g10 = com.sigmob.sdk.downloader.g.j().g();
            if (g10 != null) {
                g10.a(fVar, aVar, exc);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "fetchStart: " + fVar.b());
            if (fVar.B()) {
                this.f19139a.post(new j(fVar, i10, j10));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, i10, j10);
            }
        }

        public void b(com.sigmob.sdk.downloader.f fVar) {
            com.sigmob.sdk.downloader.d g10 = com.sigmob.sdk.downloader.g.j().g();
            if (g10 != null) {
                g10.a(fVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            if (aVar == com.sigmob.sdk.downloader.core.cause.a.ERROR) {
                com.sigmob.sdk.downloader.core.c.a(a.f19127c, "taskEnd: " + fVar.b() + " " + aVar + " " + exc);
            }
            b(fVar, aVar, exc);
            if (fVar.B()) {
                this.f19139a.post(new b(fVar, aVar, exc));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar, aVar, exc);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(com.sigmob.sdk.downloader.f fVar) {
            com.sigmob.sdk.downloader.core.c.a(a.f19127c, "taskStart: " + fVar.b());
            b(fVar);
            if (fVar.B()) {
                this.f19139a.post(new c(fVar));
                return;
            }
            com.sigmob.sdk.downloader.c p10 = fVar.p();
            if (p10 != null) {
                p10.a(fVar);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f19129b = handler;
        this.f19128a = new d(handler);
    }

    public com.sigmob.sdk.downloader.c a() {
        return this.f19128a;
    }

    public a(Handler handler, com.sigmob.sdk.downloader.c cVar) {
        this.f19129b = handler;
        this.f19128a = cVar;
    }

    public void a(Collection<f> collection, Collection<f> collection2, Collection<f> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.a(f19127c, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
        if (collection.size() > 0) {
            Iterator<f> it = collection.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!next.B()) {
                    com.sigmob.sdk.downloader.c p10 = next.p();
                    if (p10 != null) {
                        p10.a(next, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                    }
                    it.remove();
                }
            }
        }
        if (collection2.size() > 0) {
            Iterator<f> it2 = collection2.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (!next2.B()) {
                    com.sigmob.sdk.downloader.c p11 = next2.p();
                    if (p11 != null) {
                        p11.a(next2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                    it2.remove();
                }
            }
        }
        if (collection3.size() > 0) {
            Iterator<f> it3 = collection3.iterator();
            while (it3.hasNext()) {
                f next3 = it3.next();
                if (!next3.B()) {
                    com.sigmob.sdk.downloader.c p12 = next3.p();
                    if (p12 != null) {
                        p12.a(next3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    it3.remove();
                }
            }
        }
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        this.f19129b.post(new b(collection, collection2, collection3));
    }

    public void a(Collection<f> collection) {
        if (collection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.a(f19127c, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.B()) {
                com.sigmob.sdk.downloader.c p10 = next.p();
                if (p10 != null) {
                    p10.a(next, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                }
                it.remove();
            }
        }
        this.f19129b.post(new c(collection));
    }

    public void a(Collection<f> collection, Exception exc) {
        if (collection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.a(f19127c, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.B()) {
                com.sigmob.sdk.downloader.c p10 = next.p();
                if (p10 != null) {
                    p10.a(next, com.sigmob.sdk.downloader.core.cause.a.ERROR, exc);
                }
                it.remove();
            }
        }
        this.f19129b.post(new RunnableC0586a(collection, exc));
    }

    public boolean a(f fVar) {
        long q10 = fVar.q();
        return q10 <= 0 || SystemClock.uptimeMillis() - f.c.a(fVar) >= q10;
    }
}
