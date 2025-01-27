package com.kwad.components.core.page.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes2.dex */
public final class a extends Presenter {
    private int Lv;
    private FeedVideoView Lw;

    /* renamed from: com.kwad.components.core.page.a.a$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;
        final /* synthetic */ AdInfo rX;

        AnonymousClass1(AdInfo adInfo, com.kwad.components.core.page.recycle.e eVar) {
            cb = adInfo;
            eVar = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                if (eVar.IM != null) {
                    com.kwad.components.core.d.b.a.a(new a.C0172a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
                    return;
                }
                return;
            }
            RecyclerView recyclerView = eVar.MS;
            if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                return;
            }
            eVar.MS.scrollToPosition(1);
            com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
        }
    }

    /* renamed from: com.kwad.components.core.page.a.a$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;
        final /* synthetic */ AdInfo rX;

        AnonymousClass2(AdInfo adInfo, com.kwad.components.core.page.recycle.e eVar) {
            cb = adInfo;
            eVar = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                if (eVar.IM != null) {
                    com.kwad.components.core.d.b.a.a(new a.C0172a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
                    return;
                }
                return;
            }
            RecyclerView recyclerView = eVar.MS;
            if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                return;
            }
            eVar.MS.scrollToPosition(1);
            com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
        }
    }

    /* renamed from: com.kwad.components.core.page.a.a$3 */
    final class AnonymousClass3 implements FeedVideoView.a {
        final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;

        AnonymousClass3(com.kwad.components.core.page.recycle.e eVar) {
            eVar = eVar;
        }

        @Override // com.kwad.components.core.widget.FeedVideoView.a
        public final void oh() {
            RecyclerView recyclerView = eVar.MS;
            if (recyclerView != null) {
                a.this.Lv = recyclerView.computeVerticalScrollOffset();
            }
        }

        @Override // com.kwad.components.core.widget.FeedVideoView.a
        public final void oi() {
            RecyclerView recyclerView = eVar.MS;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(a.this.Lv);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Bh();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Lw = feedVideoView;
        feedVideoView.bindView(eVar.adTemplate);
        this.Lw.a(build, eVar.IM);
        this.Lw.setVisibility(0);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(eVar.adTemplate);
        this.Lw.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.1
            final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;
            final /* synthetic */ AdInfo rX;

            AnonymousClass1(AdInfo cb2, com.kwad.components.core.page.recycle.e eVar2) {
                cb = cb2;
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                    if (eVar.IM != null) {
                        com.kwad.components.core.d.b.a.a(new a.C0172a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.MS;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.MS.scrollToPosition(1);
                com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
            }
        });
        if (com.kwad.sdk.core.response.a.a.ah(cb2)) {
            this.Lw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.2
                final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;
                final /* synthetic */ AdInfo rX;

                AnonymousClass2(AdInfo cb2, com.kwad.components.core.page.recycle.e eVar2) {
                    cb = cb2;
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                        if (eVar.IM != null) {
                            com.kwad.components.core.d.b.a.a(new a.C0172a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                            com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.MS;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.MS.scrollToPosition(1);
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
                }
            });
        }
        this.Lw.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.a.a.3
            final /* synthetic */ com.kwad.components.core.page.recycle.e Lx;

            AnonymousClass3(com.kwad.components.core.page.recycle.e eVar2) {
                eVar = eVar2;
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oh() {
                RecyclerView recyclerView = eVar.MS;
                if (recyclerView != null) {
                    a.this.Lv = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oi() {
                RecyclerView recyclerView = eVar.MS;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.Lv);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Lw.release();
    }
}
