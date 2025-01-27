package com.kwad.components.ad.g;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class b {
    private com.kwad.sdk.core.f.d fv;
    private CopyOnWriteArrayList<C0374b> nt = new CopyOnWriteArrayList<>();
    private int nu;

    /* renamed from: com.kwad.components.ad.g.b$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.g.b$1$1 */
        public class C03731 extends bd {
            public C03731() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                b.this.fv.Hb();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d10) {
            if (b.this.nt != null) {
                b.this.e(d10);
                bt.a(new bd() { // from class: com.kwad.components.ad.g.b.1.1
                    public C03731() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                        b.this.fv.Hb();
                    }
                }, null, 500L);
            }
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bw() {
        }
    }

    public static final class a {
        private static final b nx = new b();
    }

    /* renamed from: com.kwad.components.ad.g.b$b */
    public static class C0374b {
        private final c ny;
        private final WeakReference<View> nz;

        public C0374b(c cVar, View view) {
            this.nz = new WeakReference<>(view);
            this.ny = cVar;
        }
    }

    public interface c {
        void f(double d10);
    }

    public void e(double d10) {
        CopyOnWriteArrayList<C0374b> copyOnWriteArrayList = this.nt;
        int DL = (int) (com.kwad.sdk.core.config.d.DL() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<C0374b> it = copyOnWriteArrayList.iterator();
        C0374b c0374b = null;
        C0374b c0374b2 = null;
        int i10 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            C0374b next = it.next();
            WeakReference weakReference = next.nz;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bw.o((View) weakReference.get(), DL)) {
                    int i11 = this.nu / 2;
                    int min = Math.min(Math.abs(rect.top - i11), Math.abs(rect.bottom - i11));
                    if (min < i10) {
                        c0374b = next;
                        i10 = min;
                    } else if (min == i10) {
                        c0374b2 = next;
                    }
                }
            }
        }
        if (c0374b != null) {
            if (c0374b2 != null) {
                Rect rect2 = new Rect();
                ((View) c0374b.nz.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c0374b2.nz.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    c0374b = c0374b2;
                }
            }
            c0374b.ny.f(d10);
        }
    }

    public static b eG() {
        return a.nx;
    }

    public final void a(float f10, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.fv == null) {
            this.nu = com.kwad.sdk.c.a.a.aZ(view.getContext());
            a(f10, view.getContext());
        }
        this.nt.add(new C0374b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0374b> it = this.nt.iterator();
        while (it.hasNext()) {
            C0374b next = it.next();
            if (next.ny == cVar) {
                this.nt.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdShakeManager", "sShakeItems size " + this.nt.size());
    }

    private void a(float f10, Context context) {
        this.fv = new com.kwad.sdk.core.f.d(f10);
        this.nt = new CopyOnWriteArrayList<>();
        this.fv.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.g.b.1

            /* renamed from: com.kwad.components.ad.g.b$1$1 */
            public class C03731 extends bd {
                public C03731() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                    b.this.fv.Hb();
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.f.b
            public final void a(double d10) {
                if (b.this.nt != null) {
                    b.this.e(d10);
                    bt.a(new bd() { // from class: com.kwad.components.ad.g.b.1.1
                        public C03731() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.fv.Hb();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bw() {
            }
        });
        this.fv.g(f10);
        this.fv.bz(context);
    }
}
