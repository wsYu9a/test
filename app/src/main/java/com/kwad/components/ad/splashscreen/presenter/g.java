package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class g extends e {

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.g$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (g.this.getActivity() != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                    if (com.kwad.sdk.c.a.a.E(viewGroup) && com.kwad.sdk.c.a.a.aZ(g.this.getActivity()) == viewGroup.getHeight()) {
                        g.this.lw();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void j(View view, int i10) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i10;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i10;
            view.setLayoutParams(layoutParams2);
        }
    }

    private void lv() {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.g.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.c.a.a.E(viewGroup) && com.kwad.sdk.c.a.a.aZ(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.lw();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public void lw() {
        if (getContext() == null) {
            return;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        j(findViewById(com.kwad.components.ad.splashscreen.e.c.z(eb2) ? R.id.ksad_preload_right_container : R.id.ksad_preload_left_container), x(eb2));
        if (com.kwad.components.ad.splashscreen.e.c.z(eb2)) {
            j(findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
            j(findViewById(R.id.ksad_splash_sound), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 32.0f));
            j(findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()));
        }
    }

    private int x(AdInfo adInfo) {
        int a10;
        int statusBarHeight;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            a10 = com.kwad.sdk.c.a.a.a(getActivity(), 32.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        } else {
            a10 = com.kwad.sdk.c.a.a.a(getActivity(), 16.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        }
        return a10 + statusBarHeight;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        lv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
