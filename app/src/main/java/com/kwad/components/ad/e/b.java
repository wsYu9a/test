package com.kwad.components.ad.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class b {
    private com.kwad.sdk.core.f.d ef;
    private int mA;
    private CopyOnWriteArrayList<C0123b> mz = new CopyOnWriteArrayList<>();

    /* renamed from: com.kwad.components.ad.e.b$1 */
    final class AnonymousClass1 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.e.b$1$1 */
        final class RunnableC01221 implements Runnable {
            RunnableC01221() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                b.this.ef.xD();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d2) {
            if (b.this.mz != null) {
                b.this.e(d2);
                bi.a(new Runnable() { // from class: com.kwad.components.ad.e.b.1.1
                    RunnableC01221() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                        b.this.ef.xD();
                    }
                }, null, 500L);
            }
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bd() {
        }
    }

    static final class a {
        private static final b mD = new b();
    }

    /* renamed from: com.kwad.components.ad.e.b$b */
    public static class C0123b {
        private final c mE;
        private final WeakReference<View> mF;

        public C0123b(c cVar, View view) {
            this.mF = new WeakReference<>(view);
            this.mE = cVar;
        }
    }

    public interface c {
        void f(double d2);
    }

    private void a(float f2, Context context) {
        this.ef = new com.kwad.sdk.core.f.d(f2);
        this.mz = new CopyOnWriteArrayList<>();
        this.ef.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.e.b.1

            /* renamed from: com.kwad.components.ad.e.b$1$1 */
            final class RunnableC01221 implements Runnable {
                RunnableC01221() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                    b.this.ef.xD();
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                if (b.this.mz != null) {
                    b.this.e(d2);
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.e.b.1.1
                        RunnableC01221() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.ef.xD();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ef.e(f2);
        this.ef.aX(context);
    }

    public void e(double d2) {
        CopyOnWriteArrayList<C0123b> copyOnWriteArrayList = this.mz;
        int uF = (int) (com.kwad.sdk.core.config.d.uF() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i2 = Integer.MAX_VALUE;
        Iterator<C0123b> it = copyOnWriteArrayList.iterator();
        C0123b c0123b = null;
        C0123b c0123b2 = null;
        while (it.hasNext()) {
            C0123b next = it.next();
            WeakReference weakReference = next.mF;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bl.o((View) weakReference.get(), uF)) {
                    int i3 = this.mA / 2;
                    int min = Math.min(Math.abs(rect.top - i3), Math.abs(rect.bottom - i3));
                    if (min < i2) {
                        c0123b = next;
                        i2 = min;
                    } else if (min == i2) {
                        c0123b2 = next;
                    }
                }
            }
        }
        if (c0123b != null) {
            if (c0123b2 != null) {
                Rect rect2 = new Rect();
                ((View) c0123b.mF.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c0123b2.mF.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    c0123b = c0123b2;
                }
            }
            c0123b.mE.f(d2);
        }
    }

    public static b eI() {
        return a.mD;
    }

    public final void a(float f2, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.ef == null) {
            this.mA = com.kwad.sdk.c.kwai.a.aw(view.getContext());
            a(f2, view.getContext());
        }
        this.mz.add(new C0123b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0123b> it = this.mz.iterator();
        while (it.hasNext()) {
            C0123b next = it.next();
            if (next.mE == cVar) {
                this.mz.remove(next);
            }
        }
        com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "sShakeItems size " + this.mz.size());
    }
}
