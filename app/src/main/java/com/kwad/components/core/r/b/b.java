package com.kwad.components.core.r.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.R;
import com.kwad.sdk.components.n;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public final class b extends Presenter {
    private FrameLayout Vr;
    private com.kwad.components.core.r.a.b Vu;
    private n Vx;

    /* renamed from: com.kwad.components.core.r.b.b$1 */
    public class AnonymousClass1 implements com.kwad.components.core.l.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void c(f fVar) {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(f fVar) {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gj() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void gk() {
            if (b.this.Vu.Vk != null) {
                b.this.Vu.Vk.callbackDismiss();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.Vu = (com.kwad.components.core.r.a.b) Lj();
        this.Vr = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.Vx = this.Vu.Vl.a(null);
        this.Vu.Ov.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void c(f fVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(f fVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void gj() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void gk() {
                if (b.this.Vu.Vk != null) {
                    b.this.Vu.Vk.callbackDismiss();
                }
            }
        });
        if (this.Vx == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.Vx.getView();
            view.setLayoutParams(layoutParams);
            this.Vr.addView(view);
            this.Vx.bindActivity(getActivity());
            this.Vx.render();
        }
    }

    public final boolean onBackPressed() {
        n nVar = this.Vx;
        return nVar != null && nVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
