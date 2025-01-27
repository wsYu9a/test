package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class h implements d {
    private static WeakReference<Window> Ma;
    private g LX;
    private b LY;
    private WeakReference<Activity> LZ;
    private ViewGroup pu;
    private boolean pv;
    private final com.kwad.sdk.core.c.c<Activity> yv = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.LZ.get())) {
                h.this.fk();
            }
        }
    };

    /* renamed from: com.kwad.components.core.e.a.h$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.LZ.get())) {
                h.this.fk();
            }
        }
    }

    public void fk() {
        g gVar;
        if (this.pv) {
            return;
        }
        this.pv = true;
        this.LY.fj();
        ViewGroup viewGroup = this.pu;
        if (viewGroup != null && (gVar = this.LX) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.yv);
    }

    public static void oa() {
        WeakReference<Window> weakReference = Ma;
        if (weakReference != null) {
            weakReference.clear();
        }
        Ma = null;
    }

    @Override // com.kwad.components.core.e.a.d
    public final void nS() {
        fk();
    }

    public static void a(Window window) {
        Ma = new WeakReference<>(window);
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        try {
            this.LY = bVar;
            com.kwad.sdk.core.c.b.Fi();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = Ma;
                View findViewById = (weakReference != null ? weakReference.get() : currentActivity.getWindow()).getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.LZ = new WeakReference<>(currentActivity);
                this.LX = new g(m.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.a(this.yv);
                this.pu = (ViewGroup) findViewById;
                this.pu.addView(this.LX, new ViewGroup.LayoutParams(-1, -1));
                bVar.nR();
                return true;
            }
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th2);
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            return false;
        }
    }
}
