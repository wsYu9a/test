package com.kwai.sodler.kwai;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.i;
import java.io.File;

/* loaded from: classes2.dex */
public final class a {

    @Nullable
    private static InterfaceC0247a aJF = null;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static volatile boolean hasInit = false;

    /* renamed from: com.kwai.sodler.kwai.a$1 */
    static class AnonymousClass1<P, R> implements c<P, R> {

        /* renamed from: com.kwai.sodler.kwai.a$1$1 */
        final class RunnableC02461 implements Runnable {
            final /* synthetic */ f aJG;

            RunnableC02461(f fVar) {
                fVar = fVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (fVar.JD()) {
                    i.Jl().a(fVar, 16);
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwai.sodler.kwai.a.c
        public final void d(f fVar) {
            i.Jl().l(fVar);
            a.handler.postDelayed(new Runnable() { // from class: com.kwai.sodler.kwai.a.1.1
                final /* synthetic */ f aJG;

                RunnableC02461(f fVar2) {
                    fVar = fVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (fVar.JD()) {
                        i.Jl().a(fVar, 16);
                    }
                }
            }, fVar2.JC() instanceof PluginError.UpdateError ? 1000L : 0L);
        }
    }

    /* renamed from: com.kwai.sodler.kwai.a$2 */
    static class AnonymousClass2 implements g.a {
        AnonymousClass2() {
        }

        @Override // com.kwai.sodler.lib.a.g.a
        public final void a(f fVar, File file) {
            a.aJF.a(fVar, file);
        }
    }

    /* renamed from: com.kwai.sodler.kwai.a$a */
    public interface InterfaceC0247a {
        void a(f fVar, File file);

        int getMaxRetryCount();

        boolean sp();
    }

    static class b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> extends b.C0248b<P, R> {
        com.kwai.sodler.lib.ext.b<P, R> aJI;
        c<P, R> aJJ;

        protected b(com.kwai.sodler.lib.ext.b<P, R> bVar, c<P, R> cVar) {
            this.aJI = bVar;
            this.aJJ = cVar;
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final void a(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final void a(R r, P p) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, (R) p);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final void a(R r, PluginError pluginError) {
            com.kwai.sodler.lib.a.e("Sodler.helper", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, pluginError);
            }
            c<P, R> cVar = this.aJJ;
            if (cVar != null) {
                cVar.d(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final void b(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.b(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final void c(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.c(r);
            }
        }
    }

    interface c<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {
        void d(R r);
    }

    private static <P extends com.kwai.sodler.lib.a.a, R extends f<P>> void a(Context context, R r, com.kwai.sodler.lib.ext.b<P, R> bVar) {
        init(context);
        r.dm(i.Jl().Jn().getRetryCount());
        r.a(new b(bVar, new c<P, R>() { // from class: com.kwai.sodler.kwai.a.1

            /* renamed from: com.kwai.sodler.kwai.a$1$1 */
            final class RunnableC02461 implements Runnable {
                final /* synthetic */ f aJG;

                RunnableC02461(f fVar2) {
                    fVar = fVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (fVar.JD()) {
                        i.Jl().a(fVar, 16);
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwai.sodler.kwai.a.c
            public final void d(f fVar2) {
                i.Jl().l(fVar2);
                a.handler.postDelayed(new Runnable() { // from class: com.kwai.sodler.kwai.a.1.1
                    final /* synthetic */ f aJG;

                    RunnableC02461(f fVar22) {
                        fVar = fVar22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (fVar.JD()) {
                            i.Jl().a(fVar, 16);
                        }
                    }
                }, fVar22.JC() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        }));
        i.Jl().a(r, 16);
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.a aVar) {
        a(context, new com.kwai.sodler.lib.b.a(bVar), aVar);
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.c cVar) {
        a(context, new com.kwai.sodler.lib.b.c(bVar), cVar);
    }

    public static void a(InterfaceC0247a interfaceC0247a) {
        aJF = interfaceC0247a;
    }

    @Nullable
    public static <T extends com.kwai.sodler.lib.a.a> T ar(Context context, String str) {
        init(context);
        return (T) i.Jl().Jo().fM(str);
    }

    private static synchronized void init(Context context) {
        int i2;
        boolean z;
        synchronized (a.class) {
            if (hasInit) {
                return;
            }
            InterfaceC0247a interfaceC0247a = aJF;
            if (interfaceC0247a != null) {
                i2 = interfaceC0247a.getMaxRetryCount();
                z = aJF.sp();
            } else {
                i2 = 1;
                z = false;
            }
            i.Jl().a(context, new c.a().fY("sodler").dn(i2).bW(false).bX(z).JY());
            if (aJF != null) {
                i.Jl().Jp().a(new g.a() { // from class: com.kwai.sodler.kwai.a.2
                    AnonymousClass2() {
                    }

                    @Override // com.kwai.sodler.lib.a.g.a
                    public final void a(f fVar, File file) {
                        a.aJF.a(fVar, file);
                    }
                });
            }
            hasInit = true;
        }
    }
}
