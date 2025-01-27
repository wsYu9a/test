package com.kwad.components.ad.reward.presenter.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    private IAdLiveEndRequest fW;
    private long gM;

    @Nullable
    private o pp;

    @Nullable
    private View tD;
    private final m<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new m<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.a.b.1
        AnonymousClass1() {
        }

        @NonNull
        private static AdLiveEndResultData Y(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bH */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.fW);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return Y(str);
        }
    };
    private final AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.a.b.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.hO();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.gM = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.hP();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.hP();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.a.b$1 */
    final class AnonymousClass1 extends m<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> {
        AnonymousClass1() {
        }

        @NonNull
        private static AdLiveEndResultData Y(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bH */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.fW);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return Y(str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.a.b$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.hO();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.gM = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.hP();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.hP();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.a.b$3 */
    final class AnonymousClass3 extends p<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> {

        /* renamed from: com.kwad.components.ad.reward.presenter.a.b$3$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ AdLiveEndResultData tF;

            AnonymousClass1(AdLiveEndResultData adLiveEndResultData) {
                adLiveEndResultData = adLiveEndResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.pp == null) {
                    b bVar = b.this;
                    bVar.pp = new o(bVar.qt);
                }
                b.this.pp.f(b.this.qt.mRootContainer);
                b.this.pp.b(v.B(b.this.qt.mAdTemplate));
                b.this.pp.a(b.this.qt, adLiveEndResultData.mQLivePushEndInfo, b.this.gM);
                b.this.qt.pp = b.this.pp;
                b bVar2 = b.this;
                bVar2.tD = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                b.this.tD.setVisibility(0);
                b.this.hy();
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
            super.onStartRequest(aVar);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i2, String str) {
            super.onError(aVar, i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndResultData adLiveEndResultData) {
            super.onSuccess(aVar, adLiveEndResultData);
            if (adLiveEndResultData.mQLivePushEndInfo == null) {
                return;
            }
            b.this.qt.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.a.b.3.1
                final /* synthetic */ AdLiveEndResultData tF;

                AnonymousClass1(AdLiveEndResultData adLiveEndResultData2) {
                    adLiveEndResultData = adLiveEndResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.pp == null) {
                        b bVar = b.this;
                        bVar.pp = new o(bVar.qt);
                    }
                    b.this.pp.f(b.this.qt.mRootContainer);
                    b.this.pp.b(v.B(b.this.qt.mAdTemplate));
                    b.this.pp.a(b.this.qt, adLiveEndResultData.mQLivePushEndInfo, b.this.gM);
                    b.this.qt.pp = b.this.pp;
                    b bVar2 = b.this;
                    bVar2.tD = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                    b.this.tD.setVisibility(0);
                    b.this.hy();
                }
            });
        }
    }

    public void hO() {
        if (this.fW == null) {
            return;
        }
        this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.a.b.3

            /* renamed from: com.kwad.components.ad.reward.presenter.a.b$3$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ AdLiveEndResultData tF;

                AnonymousClass1(AdLiveEndResultData adLiveEndResultData2) {
                    adLiveEndResultData = adLiveEndResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.pp == null) {
                        b bVar = b.this;
                        bVar.pp = new o(bVar.qt);
                    }
                    b.this.pp.f(b.this.qt.mRootContainer);
                    b.this.pp.b(v.B(b.this.qt.mAdTemplate));
                    b.this.pp.a(b.this.qt, adLiveEndResultData.mQLivePushEndInfo, b.this.gM);
                    b.this.qt.pp = b.this.pp;
                    b bVar2 = b.this;
                    bVar2.tD = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                    b.this.tD.setVisibility(0);
                    b.this.hy();
                }
            }

            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i2, String str) {
                super.onError(aVar, i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndResultData adLiveEndResultData2) {
                super.onSuccess(aVar, adLiveEndResultData2);
                if (adLiveEndResultData2.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.qt.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.a.b.3.1
                    final /* synthetic */ AdLiveEndResultData tF;

                    AnonymousClass1(AdLiveEndResultData adLiveEndResultData22) {
                        adLiveEndResultData = adLiveEndResultData22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.pp == null) {
                            b bVar = b.this;
                            bVar.pp = new o(bVar.qt);
                        }
                        b.this.pp.f(b.this.qt.mRootContainer);
                        b.this.pp.b(v.B(b.this.qt.mAdTemplate));
                        b.this.pp.a(b.this.qt, adLiveEndResultData.mQLivePushEndInfo, b.this.gM);
                        b.this.qt.pp = b.this.pp;
                        b bVar2 = b.this;
                        bVar2.tD = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                        b.this.tD.setVisibility(0);
                        b.this.hy();
                    }
                });
            }
        });
    }

    public void hP() {
        View view = this.tD;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hy() {
        i iVar = new i();
        y.a aVar = new y.a();
        iVar.bp(24);
        iVar.a(aVar);
        com.kwad.components.core.r.b.pK().a(this.qt.mAdTemplate, null, iVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        com.kwad.components.core.offline.api.kwai.a aVar;
        super.ar();
        if (this.qt.oN.jF()) {
            this.qt.oN.a(null, this.mAdLivePlayStateListener);
            String aY = com.kwad.sdk.core.response.a.a.aY(d.cb(this.qt.mAdTemplate));
            if (TextUtils.isEmpty(aY) || (aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class)) == null) {
                return;
            }
            this.fW = aVar.getAdLiveEndRequest(aY);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.qt.oN.jF()) {
            this.qt.oN.b(null, this.mAdLivePlayStateListener);
        }
    }
}
