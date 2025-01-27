package com.kwad.components.core.proxy.launchdialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.launchdialog.f;
import com.kwad.components.core.proxy.n;
import com.kwad.sdk.utils.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class b implements n {
    private static long Ts = 7000;
    private DetectEventType Tt;

    @Nullable
    private WeakReference<com.kwad.components.core.proxy.a> Tu;

    @NonNull
    private List<f> Tv = new ArrayList();
    private a Tw = new a(this, (byte) 0);
    private boolean started = false;

    /* renamed from: com.kwad.components.core.proxy.launchdialog.b$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.Tw.l(b.this.rc());
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "DETECT_TIMEOUT call: " + b.this.Tt);
            b.this.stop();
        }
    }

    public class a implements e {
        private e Ty;
        private boolean Tz;

        private a() {
            this.Tz = false;
        }

        private void rd() {
            this.Tz = true;
        }

        public void stop() {
            rd();
            this.Ty = null;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void j(com.kwad.components.core.proxy.a aVar) {
            e eVar = this.Ty;
            if (eVar == null) {
                return;
            }
            eVar.j(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void k(com.kwad.components.core.proxy.a aVar) {
            e eVar;
            if (this.Tz || (eVar = this.Ty) == null) {
                return;
            }
            eVar.k(aVar);
            rd();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void l(com.kwad.components.core.proxy.a aVar) {
            e eVar;
            if (this.Tz || (eVar = this.Ty) == null) {
                return;
            }
            eVar.l(aVar);
            rd();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void m(com.kwad.components.core.proxy.a aVar) {
            e eVar;
            if (this.Tz || (eVar = this.Ty) == null) {
                return;
            }
            eVar.m(aVar);
            rd();
        }

        public /* synthetic */ a(b bVar, byte b10) {
            this();
        }
    }

    public b(DetectEventType detectEventType, com.kwad.components.core.proxy.a aVar, f... fVarArr) {
        this.Tt = detectEventType;
        this.Tu = new WeakReference<>(aVar);
        this.Tv.addAll(Arrays.asList(fVarArr));
    }

    private c qY() {
        com.kwad.components.core.proxy.a aVar;
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Tu;
        if (weakReference == null || weakReference.get() == null || (aVar = this.Tu.get()) == null) {
            return null;
        }
        return aVar.qY();
    }

    private boolean rb() {
        if (this.Tv.size() != 0) {
            return false;
        }
        this.Tw.k(rc());
        return true;
    }

    public com.kwad.components.core.proxy.a rc() {
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Tu;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onPause: " + aVar.getPageName() + " , type:" + this.Tt);
        if (this.started) {
            a(qY());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onStop: " + aVar.getPageName() + " , type:" + this.Tt);
        if (this.started) {
            a(qY());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(qY());
        }
    }

    @Override // com.kwad.components.core.proxy.n
    public final boolean g(com.kwad.components.core.proxy.a aVar) {
        WeakReference<com.kwad.components.core.proxy.a> weakReference;
        if (aVar == null || (weakReference = this.Tu) == null || weakReference.get() == null) {
            return false;
        }
        return this.Tu.get().equals(aVar);
    }

    public final void start() {
        this.started = true;
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call: " + this.Tt);
        bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.proxy.launchdialog.b.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.Tw.l(b.this.rc());
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DETECT_TIMEOUT call: " + b.this.Tt);
                b.this.stop();
            }
        }, Ts);
        c qY = qY();
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call current: " + qY + this.Tt);
        a(qY);
    }

    public final void stop() {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "stop call: " + this.Tt);
        this.Tw.stop();
        this.started = false;
    }

    public final void a(e eVar) {
        this.Tw.Ty = eVar;
    }

    public final boolean b(DetectEventType detectEventType) {
        return detectEventType != null && detectEventType.equals(this.Tt);
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "LifecycleSequence onResume: " + aVar.getPageName() + " , type:" + this.Tt);
        if (this.started) {
            a(qY());
        }
    }

    private void a(c cVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch event: " + cVar);
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Tu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.Tv.size() == 0) {
            this.Tw.k(rc());
            return;
        }
        f fVar = this.Tv.get(0);
        if (fVar instanceof f.a) {
            if (this.Tv.size() < 2) {
                this.Tw.m(rc());
                return;
            }
            f fVar2 = this.Tv.get(1);
            if (!(fVar2 instanceof f.b)) {
                this.Tw.m(rc());
                return;
            }
            c qX = this.Tu.get().qX();
            f.b bVar = (f.b) fVar2;
            long rf2 = qX.rf();
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch last: " + qX);
            f.a aVar = (f.a) fVar;
            if (aVar.F(rf2) && bVar.b(cVar.re())) {
                this.Tv.remove(fVar);
                this.Tv.remove(fVar2);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove first: " + fVar + this.Tt);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove second: " + fVar2 + this.Tt);
                if (rb()) {
                    return;
                }
                this.Tw.j(rc());
                return;
            }
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem not match two: " + aVar.F(rf2) + ", " + bVar.b(cVar.re()));
            this.Tw.m(rc());
            return;
        }
        if (fVar instanceof f.b) {
            if (((f.b) fVar).b(cVar.re())) {
                this.Tv.remove(fVar);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "PageEventItem remove: " + fVar);
                if (rb()) {
                    return;
                }
                this.Tw.j(rc());
                return;
            }
            this.Tw.m(rc());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(qY());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(qY());
        }
    }
}
