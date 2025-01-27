package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import com.umeng.analytics.pro.bt;
import java.io.File;
import java.util.Objects;

/* loaded from: classes3.dex */
final class o {

    public static abstract class a<T> implements c<T> {
        c<T> aqv;

        public a(c<T> cVar) {
            this.aqv = cVar;
        }
    }

    public static class b implements f<a.C0477a> {

        /* renamed from: com.kwad.sdk.api.loader.o$b$1 */
        public class AnonymousClass1 implements h.a {
            final /* synthetic */ c aqw;
            final /* synthetic */ w aqx;

            public AnonymousClass1(c cVar, w wVar) {
                cVar = cVar;
                wVar = wVar;
            }

            @Override // com.kwad.sdk.api.loader.h.a
            @WorkerThread
            public final void a(a.b bVar) {
                Objects.toString(bVar);
                if (bVar.Bw()) {
                    cVar.i(bVar.apu);
                } else {
                    new RuntimeException("UpdateData is illegal");
                }
                try {
                    com.kwad.sdk.api.loader.f.aP(wVar.getContext()).cancel();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.sdk.api.loader.o.f
        public final void a(w wVar, c<a.C0477a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(wVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.o.b.1
                    final /* synthetic */ c aqw;
                    final /* synthetic */ w aqx;

                    public AnonymousClass1(c cVar2, w wVar2) {
                        cVar = cVar2;
                        wVar = wVar2;
                    }

                    @Override // com.kwad.sdk.api.loader.h.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.Bw()) {
                            cVar.i(bVar.apu);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.aP(wVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public interface c<T> {
        void i(T t10);
    }

    public static class d implements f<a.C0477a> {
        f<a.C0477a> aqz;

        /* renamed from: com.kwad.sdk.api.loader.o$d$1 */
        public class AnonymousClass1 extends a<a.C0477a> {
            final /* synthetic */ c aqw;
            final /* synthetic */ w aqx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(c cVar, w wVar, c cVar2) {
                super(cVar);
                wVar = wVar;
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.api.loader.o.c
            @WorkerThread
            /* renamed from: c */
            public void i(@NonNull a.C0477a c0477a) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = null;
                try {
                    l.a(c0477a);
                    file = j.r(wVar.getContext(), c0477a.sdkVersion);
                    k.c(c0477a.apr, file);
                    l.a(c0477a, System.currentTimeMillis() - currentTimeMillis);
                    c0477a.aps = file;
                    cVar.i(c0477a);
                } catch (Throwable th2) {
                    l.a(c0477a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th2));
                    j.j(file);
                }
            }
        }

        public d(f<a.C0477a> fVar) {
            this.aqz = fVar;
        }

        @Override // com.kwad.sdk.api.loader.o.f
        public final void a(w wVar, c<a.C0477a> cVar) {
            this.aqz.a(wVar, new a<a.C0477a>(cVar) { // from class: com.kwad.sdk.api.loader.o.d.1
                final /* synthetic */ c aqw;
                final /* synthetic */ w aqx;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(c cVar2, w wVar2, c cVar22) {
                    super(cVar22);
                    wVar = wVar2;
                    cVar = cVar22;
                }

                @Override // com.kwad.sdk.api.loader.o.c
                @WorkerThread
                /* renamed from: c */
                public void i(@NonNull a.C0477a c0477a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        l.a(c0477a);
                        file = j.r(wVar.getContext(), c0477a.sdkVersion);
                        k.c(c0477a.apr, file);
                        l.a(c0477a, System.currentTimeMillis() - currentTimeMillis);
                        c0477a.aps = file;
                        cVar.i(c0477a);
                    } catch (Throwable th2) {
                        l.a(c0477a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th2));
                        j.j(file);
                    }
                }
            });
        }
    }

    public static class e implements f<Boolean> {
        f<a.C0477a> aqz;

        /* renamed from: com.kwad.sdk.api.loader.o$e$1 */
        public class AnonymousClass1 implements c<a.C0477a> {
            final /* synthetic */ c aqw;
            final /* synthetic */ w aqx;

            public AnonymousClass1(w wVar, c cVar) {
                wVar = wVar;
                cVar = cVar;
            }

            private void a(a.C0477a c0477a, int i10, Throwable th2) {
                j.j(c0477a.aps);
                l.b(c0477a, i10, Log.getStackTraceString(th2));
            }

            @Override // com.kwad.sdk.api.loader.o.c
            /* renamed from: c */
            public void i(@NonNull a.C0477a c0477a) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    l.b(c0477a);
                    if (!com.kwad.sdk.api.loader.d.a(wVar.getContext(), AnonymousClass1.class.getClassLoader(), c0477a.aps.getPath(), c0477a.sdkVersion)) {
                        a(c0477a, 1, new RuntimeException("Apk pre install fail"));
                        return;
                    }
                    i.p(wVar.getContext(), c0477a.sdkVersion);
                    j.j(c0477a.aps);
                    l.b(c0477a, System.currentTimeMillis() - currentTimeMillis);
                    cVar.i(Boolean.TRUE);
                } catch (Throwable th2) {
                    a(c0477a, 2, th2);
                }
            }
        }

        public e(f<a.C0477a> fVar) {
            this.aqz = fVar;
        }

        @Override // com.kwad.sdk.api.loader.o.f
        public final void a(w wVar, c<Boolean> cVar) {
            this.aqz.a(wVar, new c<a.C0477a>() { // from class: com.kwad.sdk.api.loader.o.e.1
                final /* synthetic */ c aqw;
                final /* synthetic */ w aqx;

                public AnonymousClass1(w wVar2, c cVar2) {
                    wVar = wVar2;
                    cVar = cVar2;
                }

                private void a(a.C0477a c0477a, int i10, Throwable th2) {
                    j.j(c0477a.aps);
                    l.b(c0477a, i10, Log.getStackTraceString(th2));
                }

                @Override // com.kwad.sdk.api.loader.o.c
                /* renamed from: c */
                public void i(@NonNull a.C0477a c0477a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0477a);
                        if (!com.kwad.sdk.api.loader.d.a(wVar.getContext(), AnonymousClass1.class.getClassLoader(), c0477a.aps.getPath(), c0477a.sdkVersion)) {
                            a(c0477a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.p(wVar.getContext(), c0477a.sdkVersion);
                        j.j(c0477a.aps);
                        l.b(c0477a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.i(Boolean.TRUE);
                    } catch (Throwable th2) {
                        a(c0477a, 2, th2);
                    }
                }
            });
        }
    }

    public interface f<T> {
        void a(w wVar, c<T> cVar);
    }

    public static class g implements f<a.C0477a> {
        f<a.C0477a> aqz;

        /* renamed from: com.kwad.sdk.api.loader.o$g$1 */
        public class AnonymousClass1 extends a<a.C0477a> {
            final /* synthetic */ c aqw;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(c cVar, c cVar2) {
                super(cVar);
                cVar = cVar2;
            }

            private void a(a.C0477a c0477a, int i10, Throwable th2) {
                j.j(c0477a.aps);
                l.a(c0477a, i10, th2.getMessage());
            }

            @Override // com.kwad.sdk.api.loader.o.c
            /* renamed from: c */
            public void i(@NonNull a.C0477a c0477a) {
                try {
                    File file = c0477a.aps;
                    if (!t.k(file)) {
                        a(c0477a, 1, new RuntimeException("Security checkFileValid fail"));
                    } else if (t.a(file, c0477a.md5)) {
                        cVar.i(c0477a);
                    } else {
                        a(c0477a, 2, new RuntimeException("Security checkMd5 fail"));
                    }
                } catch (Throwable th2) {
                    a(c0477a, 3, th2);
                }
            }
        }

        public g(f<a.C0477a> fVar) {
            this.aqz = fVar;
        }

        @Override // com.kwad.sdk.api.loader.o.f
        public final void a(w wVar, c<a.C0477a> cVar) {
            this.aqz.a(wVar, new a<a.C0477a>(cVar) { // from class: com.kwad.sdk.api.loader.o.g.1
                final /* synthetic */ c aqw;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(c cVar2, c cVar22) {
                    super(cVar22);
                    cVar = cVar22;
                }

                private void a(a.C0477a c0477a, int i10, Throwable th2) {
                    j.j(c0477a.aps);
                    l.a(c0477a, i10, th2.getMessage());
                }

                @Override // com.kwad.sdk.api.loader.o.c
                /* renamed from: c */
                public void i(@NonNull a.C0477a c0477a) {
                    try {
                        File file = c0477a.aps;
                        if (!t.k(file)) {
                            a(c0477a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (t.a(file, c0477a.md5)) {
                            cVar.i(c0477a);
                        } else {
                            a(c0477a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th2) {
                        a(c0477a, 3, th2);
                    }
                }
            });
        }
    }

    public static class h implements f<a.C0477a> {
        f<a.C0477a> aqz;

        /* renamed from: com.kwad.sdk.api.loader.o$h$1 */
        public class AnonymousClass1 implements c<a.C0477a> {
            final /* synthetic */ c aqw;
            final /* synthetic */ w aqx;

            public AnonymousClass1(w wVar, c cVar) {
                wVar = wVar;
                cVar = cVar;
            }

            @Override // com.kwad.sdk.api.loader.o.c
            /* renamed from: c */
            public void i(a.C0477a c0477a) {
                String aQ = i.aQ(wVar.getContext());
                if (TextUtils.isEmpty(aQ)) {
                    aQ = com.kwad.sdk.api.c.Bp().getSDKVersion();
                }
                String str = c0477a.sdkVersion;
                com.kwad.sdk.api.loader.b.a(wVar.getContext(), bt.f23596ba, c0477a.interval);
                com.kwad.sdk.api.loader.b.a(wVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                if (c0477a.Bv()) {
                    v.aW(wVar.getContext());
                    new RuntimeException("DynamicType == -1, curVersion: " + aQ);
                    return;
                }
                if (i.K(c0477a.sdkVersion, aQ) && c0477a.Bu()) {
                    cVar.i(c0477a);
                    return;
                }
                new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0477a.sdkVersion + " currentDynamicVersion:" + aQ + " dynamicType:" + c0477a.apq);
            }
        }

        public h(f<a.C0477a> fVar) {
            this.aqz = fVar;
        }

        @Override // com.kwad.sdk.api.loader.o.f
        public final void a(w wVar, c<a.C0477a> cVar) {
            this.aqz.a(wVar, new c<a.C0477a>() { // from class: com.kwad.sdk.api.loader.o.h.1
                final /* synthetic */ c aqw;
                final /* synthetic */ w aqx;

                public AnonymousClass1(w wVar2, c cVar2) {
                    wVar = wVar2;
                    cVar = cVar2;
                }

                @Override // com.kwad.sdk.api.loader.o.c
                /* renamed from: c */
                public void i(a.C0477a c0477a) {
                    String aQ = i.aQ(wVar.getContext());
                    if (TextUtils.isEmpty(aQ)) {
                        aQ = com.kwad.sdk.api.c.Bp().getSDKVersion();
                    }
                    String str = c0477a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(wVar.getContext(), bt.f23596ba, c0477a.interval);
                    com.kwad.sdk.api.loader.b.a(wVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0477a.Bv()) {
                        v.aW(wVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + aQ);
                        return;
                    }
                    if (i.K(c0477a.sdkVersion, aQ) && c0477a.Bu()) {
                        cVar.i(c0477a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0477a.sdkVersion + " currentDynamicVersion:" + aQ + " dynamicType:" + c0477a.apq);
                }
            });
        }
    }

    public static f<Boolean> BF() {
        return new e(new g(new d(new h(new b()))));
    }
}
