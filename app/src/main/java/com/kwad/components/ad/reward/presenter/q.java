package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class q extends b {

    /* renamed from: uf */
    private float f11855uf;

    /* renamed from: uh */
    private r f11856uh;
    private KsToastView uo;
    private Runnable ur;
    private boolean up = false;
    private boolean uq = false;
    private boolean us = false;

    /* renamed from: ui */
    private boolean f11857ui = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            q.this.uo.setVisibility(8);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.q$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            q.this.uo.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.q$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q.a(q.this, true);
            q.this.uo.setVisibility(8);
            com.kwad.components.ad.reward.a.fr().a(PlayableSource.PENDANT_CLICK_AUTO);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.q$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (q.this.us) {
                return;
            }
            if (q.this.uo != null) {
                q.this.uo.setVisibility(8);
            }
            com.kwad.components.ad.reward.a.fr().a(PlayableSource.PENDANT_AUTO);
        }
    }

    public q(r rVar) {
        this.f11856uh = rVar;
    }

    private synchronized void hS() {
        if (this.f11857ui) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.rO.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(192).aq(this.rO.f11689qf.getPlayDuration()));
        this.f11857ui = true;
    }

    private void hX() {
        this.ur = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.us) {
                    return;
                }
                if (q.this.uo != null) {
                    q.this.uo.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.fr().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hY() {
        bt.c(this.ur);
        this.ur = null;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.uo == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.uo = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                public AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.uo.setVisibility(8);
                    com.kwad.components.ad.reward.a.fr().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.rO.b(this.mPlayEndPageListener);
    }

    public final void hV() {
        if (this.uq) {
            return;
        }
        hS();
        this.uq = true;
        this.uo.setVisibility(0);
        this.uo.V(3);
        hX();
        bt.a(this.ur, null, 3000L);
    }

    public final void hW() {
        this.uq = false;
        this.uo.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11855uf = com.kwad.components.ad.reward.a.b.gQ();
        this.up = com.kwad.components.ad.reward.a.b.gR() && com.kwad.components.ad.reward.a.b.gS();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hY();
        this.rO.c(this.mPlayEndPageListener);
    }

    public static /* synthetic */ boolean a(q qVar, boolean z10) {
        qVar.us = true;
        return true;
    }
}
