package com.kwad.components.core.page.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a extends Presenter {
    private int QA;
    private FeedVideoView QB;

    /* renamed from: com.kwad.components.core.page.c.a$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ com.kwad.components.core.page.recycle.e QC;
        final /* synthetic */ AdInfo tK;

        public AnonymousClass1(AdInfo adInfo, com.kwad.components.core.page.recycle.e eVar) {
            eb2 = adInfo;
            eVar = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
                    if (eVar.MA != null) {
                        com.kwad.components.core.e.d.a.a(new a.C0427a(a.this.getActivity()).ap(false).aq(false).au(true).au(eVar.adTemplate).as(false));
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.QB.getTouchCoords());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.Sd;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Sd.getAdapter().getPageSize() <= 1) {
                    return;
                }
                eVar.Sd.scrollToPosition(1);
                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.QB.getTouchCoords());
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.kwad.components.core.page.recycle.e QC;
        final /* synthetic */ AdInfo tK;

        public AnonymousClass2(AdInfo adInfo, com.kwad.components.core.page.recycle.e eVar) {
            eb2 = adInfo;
            eVar = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
                    if (eVar.MA != null) {
                        com.kwad.components.core.e.d.a.a(new a.C0427a(a.this.getActivity()).ap(false).aq(false).au(true).au(eVar.adTemplate).as(false));
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.QB.getTouchCoords());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.Sd;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Sd.getAdapter().getPageSize() <= 1) {
                    return;
                }
                eVar.Sd.scrollToPosition(1);
                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.QB.getTouchCoords());
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a$3 */
    public class AnonymousClass3 implements FeedVideoView.a {
        final /* synthetic */ com.kwad.components.core.page.recycle.e QC;

        public AnonymousClass3(com.kwad.components.core.page.recycle.e eVar) {
            eVar = eVar;
        }

        @Override // com.kwad.components.core.widget.FeedVideoView.a
        public final void qf() {
            RecyclerView recyclerView = eVar.Sd;
            if (recyclerView != null) {
                a.this.QA = recyclerView.computeVerticalScrollOffset();
            }
        }

        @Override // com.kwad.components.core.widget.FeedVideoView.a
        public final void qg() {
            RecyclerView recyclerView = eVar.Sd;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(a.this.QA);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Lj();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.QB = feedVideoView;
        feedVideoView.c(com.kwad.sdk.core.response.b.c.dM(eVar.adTemplate));
        this.QB.a(build, eVar.MA);
        this.QB.setVisibility(0);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(eVar.adTemplate);
        this.QB.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            final /* synthetic */ com.kwad.components.core.page.recycle.e QC;
            final /* synthetic */ AdInfo tK;

            public AnonymousClass1(AdInfo eb22, com.kwad.components.core.page.recycle.e eVar2) {
                eb2 = eb22;
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
                        if (eVar.MA != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0427a(a.this.getActivity()).ap(false).aq(false).au(true).au(eVar.adTemplate).as(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.QB.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.Sd;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Sd.getAdapter().getPageSize() <= 1) {
                        return;
                    }
                    eVar.Sd.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.QB.getTouchCoords());
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aq(eb22)) {
            this.QB.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                final /* synthetic */ com.kwad.components.core.page.recycle.e QC;
                final /* synthetic */ AdInfo tK;

                public AnonymousClass2(AdInfo eb22, com.kwad.components.core.page.recycle.e eVar2) {
                    eb2 = eb22;
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
                            if (eVar.MA != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0427a(a.this.getActivity()).ap(false).aq(false).au(true).au(eVar.adTemplate).as(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.QB.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = eVar.Sd;
                        if (recyclerView == null || recyclerView.getAdapter() == null || eVar.Sd.getAdapter().getPageSize() <= 1) {
                            return;
                        }
                        eVar.Sd.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.QB.getTouchCoords());
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }
            });
        }
        this.QB.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            final /* synthetic */ com.kwad.components.core.page.recycle.e QC;

            public AnonymousClass3(com.kwad.components.core.page.recycle.e eVar2) {
                eVar = eVar2;
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void qf() {
                RecyclerView recyclerView = eVar.Sd;
                if (recyclerView != null) {
                    a.this.QA = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void qg() {
                RecyclerView recyclerView = eVar.Sd;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.QA);
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
        this.QB.release();
    }
}
