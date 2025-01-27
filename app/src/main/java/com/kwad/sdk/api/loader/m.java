package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import com.umeng.analytics.pro.am;
import java.io.File;

/* loaded from: classes2.dex */
final class m {

    static abstract class a<T> implements c<T> {
        c<T> ZY;

        a(c<T> cVar) {
            this.ZY = cVar;
        }
    }

    static class b implements f<a.C0202a> {

        /* renamed from: com.kwad.sdk.api.loader.m$b$1 */
        final class AnonymousClass1 implements f.a {
            final /* synthetic */ c ZZ;
            final /* synthetic */ v aaa;

            AnonymousClass1(c cVar, v vVar) {
                cVar = cVar;
                vVar = vVar;
            }

            @Override // com.kwad.sdk.api.loader.f.a
            @WorkerThread
            public final void a(a.b bVar) {
                new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                if (bVar.tn()) {
                    cVar.b(bVar.Zo);
                } else {
                    new RuntimeException("UpdateData is illegal");
                }
                try {
                    com.kwad.sdk.api.loader.d.an(vVar.getContext()).cancel();
                } catch (Throwable unused) {
                }
            }
        }

        b() {
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, c<a.C0202a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    final /* synthetic */ c ZZ;
                    final /* synthetic */ v aaa;

                    AnonymousClass1(c cVar2, v vVar2) {
                        cVar = cVar2;
                        vVar = vVar2;
                    }

                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.tn()) {
                            cVar.b(bVar.Zo);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.an(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public interface c<T> {
        void b(T t);
    }

    static class d implements f<a.C0202a> {
        f<a.C0202a> aac;

        /* renamed from: com.kwad.sdk.api.loader.m$d$1 */
        final class AnonymousClass1 extends a<a.C0202a> {
            final /* synthetic */ c ZZ;
            final /* synthetic */ v aaa;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(c cVar, v vVar, c cVar2) {
                super(cVar);
                vVar = vVar;
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.api.loader.m.c
            @WorkerThread
            /* renamed from: c */
            public void b(@NonNull a.C0202a c0202a) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = null;
                try {
                    j.a(c0202a);
                    file = com.kwad.sdk.api.loader.h.k(vVar.getContext(), c0202a.sdkVersion);
                    i.b(c0202a.Zl, file);
                    j.a(c0202a, System.currentTimeMillis() - currentTimeMillis);
                    c0202a.Zm = file;
                    cVar.b(c0202a);
                } catch (Throwable th) {
                    j.a(c0202a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                    com.kwad.sdk.api.loader.h.e(file);
                }
            }
        }

        d(f<a.C0202a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, c<a.C0202a> cVar) {
            this.aac.a(vVar, new a<a.C0202a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                final /* synthetic */ c ZZ;
                final /* synthetic */ v aaa;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(c cVar2, v vVar2, c cVar22) {
                    super(cVar22);
                    vVar = vVar2;
                    cVar = cVar22;
                }

                @Override // com.kwad.sdk.api.loader.m.c
                @WorkerThread
                /* renamed from: c */
                public void b(@NonNull a.C0202a c0202a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        j.a(c0202a);
                        file = com.kwad.sdk.api.loader.h.k(vVar.getContext(), c0202a.sdkVersion);
                        i.b(c0202a.Zl, file);
                        j.a(c0202a, System.currentTimeMillis() - currentTimeMillis);
                        c0202a.Zm = file;
                        cVar.b(c0202a);
                    } catch (Throwable th) {
                        j.a(c0202a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.e(file);
                    }
                }
            });
        }
    }

    static class e implements f<Boolean> {
        f<a.C0202a> aac;

        /* renamed from: com.kwad.sdk.api.loader.m$e$1 */
        final class AnonymousClass1 implements c<a.C0202a> {
            final /* synthetic */ c ZZ;
            final /* synthetic */ v aaa;

            AnonymousClass1(v vVar, c cVar) {
                vVar = vVar;
                cVar = cVar;
            }

            private void a(a.C0202a c0202a, int i2, Throwable th) {
                com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                j.b(c0202a, i2, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.api.loader.m.c
            /* renamed from: c */
            public void b(@NonNull a.C0202a c0202a) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    j.b(c0202a);
                    if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), getClass().getClassLoader(), c0202a.Zm.getPath(), c0202a.sdkVersion)) {
                        a(c0202a, 1, new RuntimeException("Apk pre install fail"));
                        return;
                    }
                    com.kwad.sdk.api.loader.g.i(vVar.getContext(), c0202a.sdkVersion);
                    com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                    j.b(c0202a, System.currentTimeMillis() - currentTimeMillis);
                    cVar.b(Boolean.TRUE);
                } catch (Throwable th) {
                    a(c0202a, 2, th);
                }
            }
        }

        e(f<a.C0202a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, c<Boolean> cVar) {
            this.aac.a(vVar, new c<a.C0202a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                final /* synthetic */ c ZZ;
                final /* synthetic */ v aaa;

                AnonymousClass1(v vVar2, c cVar2) {
                    vVar = vVar2;
                    cVar = cVar2;
                }

                private void a(a.C0202a c0202a, int i2, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                    j.b(c0202a, i2, Log.getStackTraceString(th));
                }

                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(@NonNull a.C0202a c0202a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0202a);
                        if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), getClass().getClassLoader(), c0202a.Zm.getPath(), c0202a.sdkVersion)) {
                            a(c0202a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.i(vVar.getContext(), c0202a.sdkVersion);
                        com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                        j.b(c0202a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.b(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0202a, 2, th);
                    }
                }
            });
        }
    }

    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    static class g implements f<a.C0202a> {
        f<a.C0202a> aac;

        /* renamed from: com.kwad.sdk.api.loader.m$g$1 */
        final class AnonymousClass1 extends a<a.C0202a> {
            final /* synthetic */ c ZZ;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(c cVar, c cVar2) {
                super(cVar);
                cVar = cVar2;
            }

            private void a(a.C0202a c0202a, int i2, Throwable th) {
                com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                j.a(c0202a, i2, th.getMessage());
            }

            @Override // com.kwad.sdk.api.loader.m.c
            /* renamed from: c */
            public void b(@NonNull a.C0202a c0202a) {
                try {
                    File file = c0202a.Zm;
                    if (!r.f(file)) {
                        a(c0202a, 1, new RuntimeException("Security checkFileValid fail"));
                    } else if (r.a(file, c0202a.Tf)) {
                        cVar.b(c0202a);
                    } else {
                        a(c0202a, 2, new RuntimeException("Security checkMd5 fail"));
                    }
                } catch (Throwable th) {
                    a(c0202a, 3, th);
                }
            }
        }

        g(f<a.C0202a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, c<a.C0202a> cVar) {
            this.aac.a(vVar, new a<a.C0202a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                final /* synthetic */ c ZZ;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(c cVar2, c cVar22) {
                    super(cVar22);
                    cVar = cVar22;
                }

                private void a(a.C0202a c0202a, int i2, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0202a.Zm);
                    j.a(c0202a, i2, th.getMessage());
                }

                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(@NonNull a.C0202a c0202a) {
                    try {
                        File file = c0202a.Zm;
                        if (!r.f(file)) {
                            a(c0202a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (r.a(file, c0202a.Tf)) {
                            cVar.b(c0202a);
                        } else {
                            a(c0202a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0202a, 3, th);
                    }
                }
            });
        }
    }

    static class h implements f<a.C0202a> {
        f<a.C0202a> aac;

        /* renamed from: com.kwad.sdk.api.loader.m$h$1 */
        final class AnonymousClass1 implements c<a.C0202a> {
            final /* synthetic */ c ZZ;
            final /* synthetic */ v aaa;

            AnonymousClass1(v vVar, c cVar) {
                vVar = vVar;
                cVar = cVar;
            }

            @Override // com.kwad.sdk.api.loader.m.c
            /* renamed from: c */
            public void b(a.C0202a c0202a) {
                String ao = com.kwad.sdk.api.loader.g.ao(vVar.getContext());
                if (TextUtils.isEmpty(ao)) {
                    ao = com.kwad.sdk.api.c.ti().getSDKVersion();
                }
                String str = c0202a.sdkVersion;
                StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                sb.append(ao);
                sb.append("-newVersion");
                sb.append(str);
                t.a(vVar.getContext(), am.aU, c0202a.interval);
                t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                if (c0202a.tm()) {
                    u.au(vVar.getContext());
                    new RuntimeException("DynamicType == -1, curVersion: " + ao);
                    return;
                }
                if (com.kwad.sdk.api.loader.g.q(c0202a.sdkVersion, ao) && c0202a.tl()) {
                    cVar.b(c0202a);
                    return;
                }
                new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0202a.sdkVersion + " currentDynamicVersion:" + ao + " dynamicType:" + c0202a.Zk);
            }
        }

        h(f<a.C0202a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, c<a.C0202a> cVar) {
            this.aac.a(vVar, new c<a.C0202a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                final /* synthetic */ c ZZ;
                final /* synthetic */ v aaa;

                AnonymousClass1(v vVar2, c cVar2) {
                    vVar = vVar2;
                    cVar = cVar2;
                }

                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(a.C0202a c0202a) {
                    String ao = com.kwad.sdk.api.loader.g.ao(vVar.getContext());
                    if (TextUtils.isEmpty(ao)) {
                        ao = com.kwad.sdk.api.c.ti().getSDKVersion();
                    }
                    String str = c0202a.sdkVersion;
                    StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                    sb.append(ao);
                    sb.append("-newVersion");
                    sb.append(str);
                    t.a(vVar.getContext(), am.aU, c0202a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0202a.tm()) {
                        u.au(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + ao);
                        return;
                    }
                    if (com.kwad.sdk.api.loader.g.q(c0202a.sdkVersion, ao) && c0202a.tl()) {
                        cVar.b(c0202a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0202a.sdkVersion + " currentDynamicVersion:" + ao + " dynamicType:" + c0202a.Zk);
                }
            });
        }
    }

    static f<Boolean> tu() {
        return new e(new g(new d(new h(new b()))));
    }
}
