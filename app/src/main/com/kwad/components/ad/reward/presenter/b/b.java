package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest hn;
    private long iy;

    @Nullable
    private p qG;

    @Nullable
    private View vr;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        public AnonymousClass1() {
        }

        @NonNull
        private static AdLiveEndResultData S(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: cb */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.hn);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return S(str);
        }
    };
    private final com.kwad.components.core.video.l tY = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.ij();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.ik();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            b.this.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.ik();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.b.b$1 */
    public class AnonymousClass1 extends l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> {
        public AnonymousClass1() {
        }

        @NonNull
        private static AdLiveEndResultData S(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: cb */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.hn);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return S(str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.b.b$2 */
    public class AnonymousClass2 extends com.kwad.components.core.video.l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.ij();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.ik();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            b.this.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.ik();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.b.b$3 */
    public class AnonymousClass3 extends o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> {

        /* renamed from: com.kwad.components.ad.reward.presenter.b.b$3$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ AdLiveEndResultData vt;

            public AnonymousClass1(AdLiveEndResultData adLiveEndResultData) {
                adLiveEndResultData = adLiveEndResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (b.this.qG == null) {
                    b bVar = b.this;
                    bVar.qG = new p(bVar.rO);
                }
                b.this.qG.h(b.this.rO.mRootContainer);
                b.this.qG.b(r.V(b.this.rO.mAdTemplate));
                b.this.qG.a(b.this.rO, adLiveEndResultData.mQLivePushEndInfo, b.this.iy);
                b.this.rO.qG = b.this.qG;
                if (b.this.rO.mContext.getResources().getConfiguration().orientation == 2) {
                    b bVar2 = b.this;
                    bVar2.vr = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                } else {
                    b bVar3 = b.this;
                    bVar3.vr = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                }
                b.this.vr.setVisibility(0);
                b.this.hS();
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
            super.onStartRequest(aVar);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndResultData adLiveEndResultData) {
            super.onSuccess(aVar, adLiveEndResultData);
            if (adLiveEndResultData.mQLivePushEndInfo == null) {
                return;
            }
            b.this.rO.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                final /* synthetic */ AdLiveEndResultData vt;

                public AnonymousClass1(AdLiveEndResultData adLiveEndResultData2) {
                    adLiveEndResultData = adLiveEndResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (b.this.qG == null) {
                        b bVar = b.this;
                        bVar.qG = new p(bVar.rO);
                    }
                    b.this.qG.h(b.this.rO.mRootContainer);
                    b.this.qG.b(r.V(b.this.rO.mAdTemplate));
                    b.this.qG.a(b.this.rO, adLiveEndResultData.mQLivePushEndInfo, b.this.iy);
                    b.this.rO.qG = b.this.qG;
                    if (b.this.rO.mContext.getResources().getConfiguration().orientation == 2) {
                        b bVar2 = b.this;
                        bVar2.vr = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                    } else {
                        b bVar3 = b.this;
                        bVar3.vr = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                    }
                    b.this.vr.setVisibility(0);
                    b.this.hS();
                }
            });
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i10, String str) {
            super.onError(aVar, i10, str);
        }
    }

    public void hS() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0484a c0484a = new a.C0484a();
        bVar.cU(24);
        bVar.b(c0484a);
        com.kwad.components.ad.reward.j.b.a(true, this.rO.mAdTemplate, null, bVar);
    }

    public void ij() {
        if (this.hn == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3

            /* renamed from: com.kwad.components.ad.reward.presenter.b.b$3$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ AdLiveEndResultData vt;

                public AnonymousClass1(AdLiveEndResultData adLiveEndResultData2) {
                    adLiveEndResultData = adLiveEndResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (b.this.qG == null) {
                        b bVar = b.this;
                        bVar.qG = new p(bVar.rO);
                    }
                    b.this.qG.h(b.this.rO.mRootContainer);
                    b.this.qG.b(r.V(b.this.rO.mAdTemplate));
                    b.this.qG.a(b.this.rO, adLiveEndResultData.mQLivePushEndInfo, b.this.iy);
                    b.this.rO.qG = b.this.qG;
                    if (b.this.rO.mContext.getResources().getConfiguration().orientation == 2) {
                        b bVar2 = b.this;
                        bVar2.vr = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                    } else {
                        b bVar3 = b.this;
                        bVar3.vr = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                    }
                    b.this.vr.setVisibility(0);
                    b.this.hS();
                }
            }

            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndResultData adLiveEndResultData2) {
                super.onSuccess(aVar, adLiveEndResultData2);
                if (adLiveEndResultData2.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.rO.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    final /* synthetic */ AdLiveEndResultData vt;

                    public AnonymousClass1(AdLiveEndResultData adLiveEndResultData22) {
                        adLiveEndResultData = adLiveEndResultData22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (b.this.qG == null) {
                            b bVar = b.this;
                            bVar.qG = new p(bVar.rO);
                        }
                        b.this.qG.h(b.this.rO.mRootContainer);
                        b.this.qG.b(r.V(b.this.rO.mAdTemplate));
                        b.this.qG.a(b.this.rO, adLiveEndResultData.mQLivePushEndInfo, b.this.iy);
                        b.this.rO.qG = b.this.qG;
                        if (b.this.rO.mContext.getResources().getConfiguration().orientation == 2) {
                            b bVar2 = b.this;
                            bVar2.vr = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b bVar3 = b.this;
                            bVar3.vr = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.vr.setVisibility(0);
                        b.this.hS();
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i10, String str) {
                super.onError(aVar, i10, str);
            }
        });
    }

    public void ik() {
        View view = this.vr;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        com.kwad.components.core.n.a.a.a aVar;
        super.as();
        if (this.rO.f11689qf.kh()) {
            this.rO.f11689qf.a(this.tY);
            String bg2 = com.kwad.sdk.core.response.b.a.bg(e.eb(this.rO.mAdTemplate));
            if (TextUtils.isEmpty(bg2) || (aVar = (com.kwad.components.core.n.a.a.a) d.f(com.kwad.components.core.n.a.a.a.class)) == null) {
                return;
            }
            this.hn = aVar.getAdLiveEndRequest(bg2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.rO.f11689qf.kh()) {
            this.rO.f11689qf.b(this.tY);
        }
    }
}
