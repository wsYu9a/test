package com.kwad.components.ad.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.g.c {
    private List<Integer> cI;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private int cW;
    private ai.b cZ;
    private KSRelativeLayout eL;
    private boolean eQ;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.offline.api.kwai.a eU;
    public IAdLivePlayModule eV;
    private a.b eY;
    private OfflineOnAudioConflictListener eZ;
    private ar fB;
    private an fC;
    private WebCardRegisterLiveMessageListener fD;
    private WebCardRegisterLiveShopListener fE;
    private ao.b fI;
    private ao.a fJ;
    private IAdLiveEndRequest fW;
    private AdInfo mAdInfo;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;
    private KsNativeAd.VideoPlayListener mM;
    private final m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mO;
    private int mP;
    private d.a mR;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;
    private ImageView nb;
    private RelativeLayout nc;
    private AdBasePvFrameLayout nd;
    private KSAdVideoPlayConfigImpl ne;

    /* renamed from: com.kwad.components.ad.e.e$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ View fe;

        AnonymousClass1(View view) {
            view2 = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.c(view2);
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$10 */
    final class AnonymousClass10 implements ai.b {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            KsAdWebView ksAdWebView;
            int i2;
            e.this.cW = aVar.status;
            if (e.this.cW != 1) {
                ksAdWebView = e.this.mAdWebView;
                i2 = 8;
            } else {
                ksAdWebView = e.this.mAdWebView;
                i2 = 0;
            }
            ksAdWebView.setVisibility(i2);
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$11 */
    final class AnonymousClass11 implements com.kwad.sdk.core.webview.c.kwai.a {

        /* renamed from: com.kwad.components.ad.e.e$11$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (e.this.mR != null) {
                    e.this.mR.l(e.this.mAdWebView);
                }
            }
        }

        AnonymousClass11() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            int i2 = aVar.TC;
            if (aVar.II) {
                i2 = aVar.TA ? 1 : 2;
            }
            boolean aU = com.kwad.sdk.core.response.a.a.aU(e.this.mAdInfo);
            y.b bVar = new y.b();
            com.kwad.sdk.core.webview.c.a.c cVar = aVar.TD;
            if (cVar != null && !TextUtils.isEmpty(cVar.Ts)) {
                bVar.Ts = aVar.TD.Ts;
            }
            a.C0172a as = new a.C0172a(e.this.getContext()).I(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ao(false).ap(i2).au(aVar.II).as(aU);
            IAdLivePlayModule iAdLivePlayModule = e.this.eV;
            com.kwad.components.core.d.b.a.a(as.q(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.e.e.11.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (e.this.mR != null) {
                        e.this.mR.l(e.this.mAdWebView);
                    }
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$12 */
    final class AnonymousClass12 extends m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
        AnonymousClass12() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bH */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(e.this.fW);
        }

        @NonNull
        private static AdLiveEndCommonResultData t(String str) {
            AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
            adLiveEndCommonResultData.parseJson(new JSONObject(str));
            return adLiveEndCommonResultData;
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
            return t(str);
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {

        /* renamed from: com.kwad.components.ad.e.e$2$1 */
        final class AnonymousClass1 extends p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
            AnonymousClass1() {
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
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                super.onSuccess(aVar, adLiveEndCommonResultData);
                ao.a aVar2 = new ao.a();
                aVar2.status = 9;
                aVar2.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                aVar2.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                aVar2.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                aVar2.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                aVar2.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                aVar2.liveDuration = adLiveEndCommonResultData.liveDuration;
                if (e.this.fI != null) {
                    e.this.fI.a(aVar2);
                } else {
                    e.this.fJ = aVar2;
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayComplete();
            }
            String aY = com.kwad.sdk.core.response.a.a.aY(e.this.mAdInfo);
            if (TextUtils.isEmpty(aY)) {
                return;
            }
            com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
            if (aVar != null) {
                e.this.fW = aVar.getAdLiveEndRequest(aY);
            }
            e.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.e.e.2.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                    super.onError(aVar2, i2, str);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    ao.a aVar22 = new ao.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (e.this.fI != null) {
                        e.this.fI.a(aVar22);
                    } else {
                        e.this.fJ = aVar22;
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayPause();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            e.this.c(j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
            e eVar = e.this;
            eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayResume();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
            e eVar = e.this;
            eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePrepared() {
            super.onLivePrepared();
            com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
            if (e.this.mM != null) {
                e.this.mM.onVideoPlayReady();
            }
            IAdLivePlayModule iAdLivePlayModule = e.this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$3 */
    final class AnonymousClass3 implements OfflineOnAudioConflictListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            IAdLivePlayModule iAdLivePlayModule = e.this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$4 */
    final class AnonymousClass4 implements a.c {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.h.a.c
        public final void bs() {
            e eVar = e.this;
            if (eVar.eV == null) {
                eVar.eV = eVar.bq();
            }
            e eVar2 = e.this;
            eVar2.eV.setAudioEnabled(eVar2.g(eVar2.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$5 */
    final class AnonymousClass5 extends SimpleImageLoadingListener {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$6 */
    final class AnonymousClass6 implements AdLiveMessageListener {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
        public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
            if (e.this.fD != null) {
                e.this.fD.j(list);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$7 */
    final class AnonymousClass7 implements AdLiveShopListener {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
        public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
            if (e.this.fE != null) {
                e.this.fE.a(adLiveShopInfo);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$8 */
    final class AnonymousClass8 implements ao.c {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ao.c
        public final void a(ao.b bVar) {
            e.this.fI = bVar;
            if (e.this.fJ != null) {
                e.this.fI.a(e.this.fJ);
                e.this.fJ = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.e.e$9 */
    final class AnonymousClass9 implements ag.a {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.a
        public final void a(com.kwad.components.core.webview.kwai.b bVar) {
            AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).L(e.this.mAdTemplate).oc());
        }
    }

    public e(@NonNull Context context) {
        super(context);
        this.mO = 0;
        this.mP = 0;
        this.cZ = new ai.b() { // from class: com.kwad.components.ad.e.e.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                KsAdWebView ksAdWebView;
                int i2;
                e.this.cW = aVar.status;
                if (e.this.cW != 1) {
                    ksAdWebView = e.this.mAdWebView;
                    i2 = 8;
                } else {
                    ksAdWebView = e.this.mAdWebView;
                    i2 = 0;
                }
                ksAdWebView.setVisibility(i2);
            }
        };
        this.mNetworking = new m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.e.e.12
            AnonymousClass12() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bH */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.fW);
            }

            @NonNull
            private static AdLiveEndCommonResultData t(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return t(str);
            }
        };
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.e.e.2

            /* renamed from: com.kwad.components.ad.e.e$2$1 */
            final class AnonymousClass1 extends p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                    super.onError(aVar2, i2, str);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    ao.a aVar22 = new ao.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (e.this.fI != null) {
                        e.this.fI.a(aVar22);
                    } else {
                        e.this.fJ = aVar22;
                    }
                }
            }

            AnonymousClass2() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayComplete();
                }
                String aY = com.kwad.sdk.core.response.a.a.aY(e.this.mAdInfo);
                if (TextUtils.isEmpty(aY)) {
                    return;
                }
                com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
                if (aVar != null) {
                    e.this.fW = aVar.getAdLiveEndRequest(aY);
                }
                e.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.e.e.2.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                        super.onError(aVar2, i2, str);
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ao.a aVar22 = new ao.a();
                        aVar22.status = 9;
                        aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (e.this.fI != null) {
                            e.this.fI.a(aVar22);
                        } else {
                            e.this.fJ = aVar22;
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayPause();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                e.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayResume();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.h.a.nC().a(e.this.getCurrentVoiceItem());
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayReady();
                }
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        this.eZ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.e.e.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        initView();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fB = new ar();
        an anVar = new an();
        this.fC = anVar;
        aVar.a(anVar);
        aVar.a(new s(this.cV, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.cV, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new v(this.cV));
        aVar.a(new com.kwad.components.core.webview.jshandler.y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ai(this.cZ, com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)));
        aVar.a(new aq(this.cV, this.mApkDownloadHelper));
        aVar.a(new ac(this.cV));
        aVar.a(this.fB);
        aVar.a(new ag(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.c(this.mO, this.mP));
        this.fE = new WebCardRegisterLiveShopListener();
        this.fD = new WebCardRegisterLiveMessageListener();
        aVar.a(this.fE);
        aVar.a(this.fD);
        aVar.a(new ao(getRegisterLiveListener()));
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = 0;
        bVar2.app = null;
        bVar2.LD = this.nd;
        bVar2.Lc = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.apr = false;
    }

    private void aG() {
        if (com.kwad.sdk.core.response.a.b.br(this.mAdTemplate)) {
            eQ();
        }
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private boolean bE() {
        return this.cW == 1;
    }

    private void bF() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.e.e.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.fD != null) {
                    e.this.fD.j(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.e.e.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.fE != null) {
                    e.this.fE.a(adLiveShopInfo);
                }
            }
        });
    }

    public IAdLivePlayModule bq() {
        br();
        IAdLiveOfflineView view = this.eU.getView(this.mContext, 3);
        this.eT = view;
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(view, ServiceProvider.CB().appId, String.valueOf(com.kwad.sdk.core.response.a.a.bN(this.mAdInfo)));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        View view2 = this.eT.getView();
        this.nc.removeAllViews();
        this.nc.addView(view2);
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.e.1
            final /* synthetic */ View fe;

            AnonymousClass1(View view22) {
                view2 = view22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.this.c(view2);
            }
        });
        bF();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
        }
        return adLivePlayModule;
    }

    private void br() {
        ImageView imageView;
        int i2;
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.nb;
            i2 = 8;
        } else {
            this.nb.setImageDrawable(null);
            KSImageLoader.loadImage(this.nb, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.e.e.5
                AnonymousClass5() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            imageView = this.nb;
            i2 = 0;
        }
        imageView.setVisibility(i2);
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void c(View view) {
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    private void eL() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.mO = nativeAdExtraDataImpl.showLiveStatus;
            this.mP = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void eP() {
        this.mAdWebView.setVisibility(8);
        aF();
        if (bE()) {
            this.mAdWebView.reload();
        } else {
            aG();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void eQ() {
        aI();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().ct(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cU = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cU, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bl(this.mAdTemplate));
    }

    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.h.a.nC();
            if (!com.kwad.components.core.h.a.b(this.eY)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gz()) {
            return !com.kwad.components.core.r.a.aj(this.mContext).pJ() ? com.kwad.components.core.r.a.aj(this.mContext).aL(false) : !com.kwad.components.core.r.a.aj(this.mContext).pI();
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        return this.eQ;
    }

    @NonNull
    private com.kwad.sdk.core.webview.c.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.e.e.11

            /* renamed from: com.kwad.components.ad.e.e$11$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (e.this.mR != null) {
                        e.this.mR.l(e.this.mAdWebView);
                    }
                }
            }

            AnonymousClass11() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                int i2 = aVar.TC;
                if (aVar.II) {
                    i2 = aVar.TA ? 1 : 2;
                }
                boolean aU = com.kwad.sdk.core.response.a.a.aU(e.this.mAdInfo);
                y.b bVar = new y.b();
                com.kwad.sdk.core.webview.c.a.c cVar = aVar.TD;
                if (cVar != null && !TextUtils.isEmpty(cVar.Ts)) {
                    bVar.Ts = aVar.TD.Ts;
                }
                a.C0172a as = new a.C0172a(e.this.getContext()).I(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ao(false).ap(i2).au(aVar.II).as(aU);
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                com.kwad.components.core.d.b.a.a(as.q(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.e.e.11.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (e.this.mR != null) {
                            e.this.mR.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.e.e.4
                AnonymousClass4() {
                }

                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    e eVar = e.this;
                    if (eVar.eV == null) {
                        eVar.eV = eVar.bq();
                    }
                    e eVar2 = e.this;
                    eVar2.eV.setAudioEnabled(eVar2.g(eVar2.mIsAudioEnable), false);
                }
            });
        }
        return this.eY;
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.e.e.9
            AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).L(e.this.mAdTemplate).oc());
            }
        };
    }

    private ao.c getRegisterLiveListener() {
        return new ao.c() { // from class: com.kwad.components.ad.e.e.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ao.c
            public final void a(ao.b bVar) {
                e.this.fI = bVar;
                if (e.this.fJ != null) {
                    e.this.fI.a(e.this.fJ);
                    e.this.fJ = null;
                }
            }
        };
    }

    private void initView() {
        k.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.nd = adBasePvFrameLayout;
        this.nb = (ImageView) adBasePvFrameLayout.findViewById(R.id.ksad_live_bg_img);
        this.eL = (KSRelativeLayout) this.nd.findViewById(R.id.ksad_live_container);
        this.nc = (RelativeLayout) this.nd.findViewById(R.id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.nd.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.eU = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
    }

    public final void a(Context context, AdTemplate adTemplate, @Nullable com.kwad.components.core.d.b.c cVar, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        this.mContext = context;
        this.ne = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.cI = com.kwad.sdk.core.response.a.a.bd(cb);
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
        this.mIsAudioEnable = this.ne.getVideoSoundValue() != 0 ? this.ne.isVideoSoundEnable() : com.kwad.sdk.core.response.a.a.bG(this.mAdInfo);
        eL();
        eP();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.h.a.nC().c(this.eY);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        com.kwad.components.core.h.a.nC().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.eV = bq();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.mViewVisibleHelper.rD();
        this.mViewVisibleHelper.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void onViewDetached() {
        super.onViewDetached();
        this.mViewVisibleHelper.rD();
        this.mViewVisibleHelper.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        com.kwad.components.core.h.a.nC().c(this.eY);
        this.fJ = null;
        this.fI = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mR = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mM = videoPlayListener;
    }
}
