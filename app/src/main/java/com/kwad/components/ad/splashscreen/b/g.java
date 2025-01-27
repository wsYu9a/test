package com.kwad.components.ad.splashscreen.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class g extends e {

    /* renamed from: com.kwad.components.ad.splashscreen.b.g$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.getActivity() != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                    if (com.kwad.sdk.c.kwai.a.A(viewGroup) && com.kwad.sdk.c.kwai.a.aw(g.this.getActivity()) == viewGroup.getHeight()) {
                        g.this.kN();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void j(View view, int i2) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i2;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i2;
            view.setLayoutParams(layoutParams2);
        }
    }

    private void kM() {
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.g.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.c.kwai.a.A(viewGroup) && com.kwad.sdk.c.kwai.a.aw(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.kN();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public void kN() {
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        int i2 = hVar.Bz;
        if (i2 == 1 || i2 == 0) {
            j(hVar.mRootContainer.findViewById(R.id.ksad_preload_container), kO());
        }
        com.kwad.components.ad.splashscreen.h hVar2 = this.Cg;
        if (hVar2.Bz == 0) {
            j(hVar2.mRootContainer.findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.kwai.a.a(getContext(), 12.0f));
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_splash_sound), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.kwai.a.a(getContext(), 32.0f));
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()));
        }
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            return;
        }
        com.kwad.components.ad.splashscreen.h hVar3 = this.Cg;
        int i3 = hVar3.Bz;
        if (i3 == 2 || i3 == 3) {
            j(hVar3.mRootContainer.findViewById(R.id.ksad_compliance_view), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()));
        }
    }

    private int kO() {
        Activity activity;
        float f2;
        int i2 = this.Cg.Bz;
        if (i2 == 1) {
            activity = getActivity();
            f2 = 16.0f;
        } else {
            if (i2 != 0) {
                return 0;
            }
            activity = getActivity();
            f2 = 32.0f;
        }
        return com.kwad.sdk.c.kwai.a.a(activity, f2) + com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity());
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        kM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
