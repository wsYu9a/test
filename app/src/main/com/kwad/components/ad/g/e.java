package com.kwad.components.ad.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.g.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.y;
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
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.h.c {

    /* renamed from: ci */
    private List<Integer> f11537ci;

    /* renamed from: cn */
    private boolean f11538cn;
    private OfflineOnAudioConflictListener cy;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11539dh;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11540ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11541eb;

    /* renamed from: ec */
    private int f11542ec;

    /* renamed from: eh */
    private ar.b f11543eh;
    private bd gS;
    private ay gT;
    private WebCardRegisterLiveMessageListener gU;
    private WebCardRegisterLiveShopListener gV;
    private az.b gZ;

    /* renamed from: gg */
    private KSRelativeLayout f11544gg;
    private IAdLiveOfflineView gm;
    private com.kwad.components.core.n.a.a.a gn;
    public IAdLivePlayModule go;
    private a.b gr;
    private final AdLivePlayStateListener gs;

    /* renamed from: ha */
    private az.a f11545ha;
    private IAdLiveEndRequest hn;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private KsNativeAd.VideoPlayListener nG;
    private int nI;
    private int nJ;
    private d.a nN;
    private ImageView nX;
    private RelativeLayout nY;
    private AdBasePvFrameLayout nZ;

    /* renamed from: oa */
    private KSAdVideoPlayConfigImpl f11546oa;

    /* renamed from: com.kwad.components.ad.g.e$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ View gv;

        public AnonymousClass1(View view) {
            view = view;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            e.this.d(view);
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$10 */
    public class AnonymousClass10 implements ar.b {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            e.this.f11542ec = aVar.status;
            if (e.this.f11542ec != 1) {
                e.this.mAdWebView.setVisibility(8);
            } else {
                e.this.mAdWebView.setVisibility(0);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$11 */
    public class AnonymousClass11 implements com.kwad.sdk.core.webview.d.a.a {

        /* renamed from: com.kwad.components.ad.g.e$11$1 */
        public class AnonymousClass1 implements a.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (e.this.nN != null) {
                    e.this.nN.l(e.this.mAdWebView);
                }
            }
        }

        public AnonymousClass11() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            int i10 = aVar.aap;
            if (aVar.Ms) {
                i10 = aVar.aan ? 1 : 2;
            }
            boolean bc2 = com.kwad.sdk.core.response.b.a.bc(e.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.d dVar = aVar.aaq;
            String str = (dVar == null || TextUtils.isEmpty(dVar.MI)) ? "" : aVar.aaq.MI;
            a.C0427a at = new a.C0427a(e.this.getContext()).au(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ap(false).ao(i10).av(aVar.Ms).at(bc2);
            IAdLivePlayModule iAdLivePlayModule = e.this.go;
            com.kwad.components.core.e.d.a.a(at.v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ai(str).ar(true).a(new a.b() { // from class: com.kwad.components.ad.g.e.11.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (e.this.nN != null) {
                        e.this.nN.l(e.this.mAdWebView);
                    }
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$12 */
    public class AnonymousClass12 extends l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
        public AnonymousClass12() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: cb */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(e.this.hn);
        }

        @NonNull
        private static AdLiveEndCommonResultData r(String str) {
            AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
            adLiveEndCommonResultData.parseJson(new JSONObject(str));
            return adLiveEndCommonResultData;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
            return r(str);
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$2 */
    public class AnonymousClass2 extends AdLivePlayStateListenerAdapter {

        /* renamed from: com.kwad.components.ad.g.e$2$1 */
        public class AnonymousClass1 extends o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                super.onSuccess(aVar, adLiveEndCommonResultData);
                az.a aVar2 = new az.a();
                aVar2.status = 9;
                aVar2.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                aVar2.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                aVar2.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                aVar2.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                aVar2.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                aVar2.liveDuration = adLiveEndCommonResultData.liveDuration;
                if (e.this.gZ != null) {
                    e.this.gZ.a(aVar2);
                } else {
                    e.this.f11545ha = aVar2;
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i10, String str) {
                super.onError(aVar, i10, str);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayComplete();
            }
            String bg2 = com.kwad.sdk.core.response.b.a.bg(e.this.mAdInfo);
            if (TextUtils.isEmpty(bg2)) {
                return;
            }
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                e.this.hn = aVar.getAdLiveEndRequest(bg2);
            }
            e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.g.e.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    az.a aVar22 = new az.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (e.this.gZ != null) {
                        e.this.gZ.a(aVar22);
                    } else {
                        e.this.f11545ha = aVar22;
                    }
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                    super.onError(aVar2, i10, str);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            try {
                e.this.nG.onVideoPlayPause();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j10) {
            super.onLivePlayProgress(j10);
            e.this.c(j10);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
            e eVar = e.this;
            eVar.go.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
            try {
                e.this.nG.onVideoPlayResume();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
            e eVar = e.this;
            eVar.go.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
            if (e.this.nG != null) {
                e.this.nG.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePrepared() {
            super.onLivePrepared();
            com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
            try {
                e.this.nG.onVideoPlayReady();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
            IAdLivePlayModule iAdLivePlayModule = e.this.go;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$3 */
    public class AnonymousClass3 implements OfflineOnAudioConflictListener {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            IAdLivePlayModule iAdLivePlayModule = e.this.go;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$4 */
    public class AnonymousClass4 implements a.c {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.j.a.c
        public final void bM() {
            e eVar = e.this;
            if (eVar.go == null) {
                eVar.go = eVar.bK();
            }
            e eVar2 = e.this;
            IAdLivePlayModule iAdLivePlayModule = eVar2.go;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(eVar2.h(eVar2.mIsAudioEnable), false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$5 */
    public class AnonymousClass5 extends SimpleImageLoadingListener {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$6 */
    public class AnonymousClass6 implements AdLiveMessageListener {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
        public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
            if (e.this.gU != null) {
                e.this.gU.n(list);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$7 */
    public class AnonymousClass7 implements AdLiveShopListener {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
        public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
            if (e.this.gV != null) {
                e.this.gV.a(adLiveShopInfo);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$8 */
    public class AnonymousClass8 implements az.c {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.az.c
        public final void a(az.b bVar) {
            e.this.gZ = bVar;
            if (e.this.f11545ha != null) {
                e.this.gZ.a(e.this.f11545ha);
                e.this.f11545ha = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.e$9 */
    public class AnonymousClass9 implements ap.a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void a(com.kwad.components.core.webview.a.b bVar) {
            AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aw(e.this.mAdTemplate).qa());
        }
    }

    public e(@NonNull Context context) {
        super(context);
        this.nI = 0;
        this.nJ = 0;
        this.f11543eh = new ar.b() { // from class: com.kwad.components.ad.g.e.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar) {
                e.this.f11542ec = aVar.status;
                if (e.this.f11542ec != 1) {
                    e.this.mAdWebView.setVisibility(8);
                } else {
                    e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.g.e.12
            public AnonymousClass12() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: cb */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.hn);
            }

            @NonNull
            private static AdLiveEndCommonResultData r(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return r(str);
            }
        };
        this.gs = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.g.e.2

            /* renamed from: com.kwad.components.ad.g.e$2$1 */
            public class AnonymousClass1 extends o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    az.a aVar22 = new az.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (e.this.gZ != null) {
                        e.this.gZ.a(aVar22);
                    } else {
                        e.this.f11545ha = aVar22;
                    }
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                    super.onError(aVar2, i10, str);
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayComplete();
                }
                String bg2 = com.kwad.sdk.core.response.b.a.bg(e.this.mAdInfo);
                if (TextUtils.isEmpty(bg2)) {
                    return;
                }
                com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
                if (aVar != null) {
                    e.this.hn = aVar.getAdLiveEndRequest(bg2);
                }
                e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.g.e.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        az.a aVar22 = new az.a();
                        aVar22.status = 9;
                        aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (e.this.gZ != null) {
                            e.this.gZ.a(aVar22);
                        } else {
                            e.this.f11545ha = aVar22;
                        }
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                        super.onError(aVar2, i10, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    e.this.nG.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j10) {
                super.onLivePlayProgress(j10);
                e.this.c(j10);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.go.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                try {
                    e.this.nG.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.go.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                if (e.this.nG != null) {
                    e.this.nG.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.j.a.pv().a(e.this.getCurrentVoiceItem());
                try {
                    e.this.nG.onVideoPlayReady();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
                IAdLivePlayModule iAdLivePlayModule = e.this.go;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        this.cy = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.g.e.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = e.this.go;
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

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11541eb = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11541eb;
        bVar2.mScreenOrientation = 0;
        bVar2.aIc = null;
        bVar2.QI = this.nZ;
        bVar2.Qc = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.aIe = false;
    }

    private void aX() {
        if (com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate)) {
            eN();
        }
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11540ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11540ea = null;
        }
    }

    public IAdLivePlayModule bK() {
        bL();
        IAdLiveOfflineView a10 = com.kwad.components.ad.k.b.a(this.gn, this.mContext, 3);
        this.gm = a10;
        if (a10 == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.gn.getAdLivePlayModule(a10, ServiceProvider.MB().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cn(this.mAdInfo)), com.kwad.sdk.core.response.b.a.co(this.mAdInfo), com.kwad.sdk.core.response.b.a.cp(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.gs);
        View view = this.gm.getView();
        this.nY.removeAllViews();
        this.nY.addView(view);
        bt.postOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.g.e.1
            final /* synthetic */ View gv;

            public AnonymousClass1(View view2) {
                view = view2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                e.this.d(view);
            }
        });
        bX();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.av(this.mContext).a(this.cy);
        }
        return adLivePlayModule;
    }

    private void bL() {
        String url = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.nX.setVisibility(8);
            return;
        }
        this.nX.setImageDrawable(null);
        KSImageLoader.loadImage(this.nX, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.g.e.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
        this.nX.setVisibility(0);
    }

    private boolean bW() {
        return this.f11542ec == 1;
    }

    private void bX() {
        this.gm.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.g.e.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.gU != null) {
                    e.this.gU.n(list);
                }
            }
        });
        this.gm.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.g.e.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.gV != null) {
                    e.this.gV.a(adLiveShopInfo);
                }
            }
        });
    }

    private void eJ() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.nI = nativeAdExtraDataImpl.showLiveStatus;
            this.nJ = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void eM() {
        this.mAdWebView.setVisibility(8);
        aW();
        if (bW()) {
            this.mAdWebView.reload();
        } else {
            aX();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void eN() {
        aZ();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().ex(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.f11540ea = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.f11540ea, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cQ(this.mAdTemplate));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.g.e.11

            /* renamed from: com.kwad.components.ad.g.e$11$1 */
            public class AnonymousClass1 implements a.b {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (e.this.nN != null) {
                        e.this.nN.l(e.this.mAdWebView);
                    }
                }
            }

            public AnonymousClass11() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                int i10 = aVar.aap;
                if (aVar.Ms) {
                    i10 = aVar.aan ? 1 : 2;
                }
                boolean bc2 = com.kwad.sdk.core.response.b.a.bc(e.this.mAdInfo);
                com.kwad.sdk.core.webview.d.b.d dVar = aVar.aaq;
                String str = (dVar == null || TextUtils.isEmpty(dVar.MI)) ? "" : aVar.aaq.MI;
                a.C0427a at = new a.C0427a(e.this.getContext()).au(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ap(false).ao(i10).av(aVar.Ms).at(bc2);
                IAdLivePlayModule iAdLivePlayModule = e.this.go;
                com.kwad.components.core.e.d.a.a(at.v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ai(str).ar(true).a(new a.b() { // from class: com.kwad.components.ad.g.e.11.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (e.this.nN != null) {
                            e.this.nN.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    public a.b getCurrentVoiceItem() {
        if (this.gr == null) {
            this.gr = new a.b(new a.c() { // from class: com.kwad.components.ad.g.e.4
                public AnonymousClass4() {
                }

                @Override // com.kwad.components.core.j.a.c
                public final void bM() {
                    e eVar = e.this;
                    if (eVar.go == null) {
                        eVar.go = eVar.bK();
                    }
                    e eVar2 = e.this;
                    IAdLivePlayModule iAdLivePlayModule = eVar2.go;
                    if (iAdLivePlayModule != null) {
                        iAdLivePlayModule.setAudioEnabled(eVar2.h(eVar2.mIsAudioEnable), false);
                    }
                }
            });
        }
        return this.gr;
    }

    private ap.a getOpenNewPageListener() {
        return new ap.a() { // from class: com.kwad.components.ad.g.e.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aw(e.this.mAdTemplate).qa());
            }
        };
    }

    private az.c getRegisterLiveListener() {
        return new az.c() { // from class: com.kwad.components.ad.g.e.8
            public AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.az.c
            public final void a(az.b bVar) {
                e.this.gZ = bVar;
                if (e.this.f11545ha != null) {
                    e.this.gZ.a(e.this.f11545ha);
                    e.this.f11545ha = null;
                }
            }
        };
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.nZ = adBasePvFrameLayout;
        this.nX = (ImageView) adBasePvFrameLayout.findViewById(R.id.ksad_live_bg_img);
        this.f11544gg = (KSRelativeLayout) this.nZ.findViewById(R.id.ksad_live_container);
        this.nY = (RelativeLayout) this.nZ.findViewById(R.id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.nZ.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.gn = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void Z() {
        super.Z();
        this.f11539dh.uE();
        this.f11539dh.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void aa() {
        super.aa();
        this.f11539dh.uE();
        this.f11539dh.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.go;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.go = null;
        }
        com.kwad.components.core.j.a.pv().c(this.gr);
        this.f11545ha = null;
        this.gZ = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.gm;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.gm = null;
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.go;
        if (iAdLivePlayModule == null) {
            this.go = bK();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        IAdLivePlayModule iAdLivePlayModule = this.go;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.pv().c(this.gr);
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.nN = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.nG = videoPlayListener;
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11537ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11537ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void d(View view) {
        int width = this.f11544gg.getWidth();
        int height = this.f11544gg.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    public boolean h(boolean z10) {
        if (!z10) {
            return false;
        }
        if (this.gr != null) {
            com.kwad.components.core.j.a.pv();
            if (!com.kwad.components.core.j.a.b(this.gr)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gN()) {
            return !com.kwad.components.core.s.a.av(this.mContext).sb() ? com.kwad.components.core.s.a.av(this.mContext).aO(false) : !com.kwad.components.core.s.a.av(this.mContext).sa();
        }
        if (!this.f11538cn) {
            this.f11538cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        return this.f11538cn;
    }

    public final void a(Context context, AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.mAdInfo = eb2;
        this.mContext = context;
        this.f11546oa = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.f11537ci = com.kwad.sdk.core.response.b.a.bo(eb2);
        this.f11539dh = new com.kwad.components.core.widget.a.b(getParent() == null ? this : (View) getParent(), 30);
        if (this.f11546oa.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.f11546oa.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo);
        }
        eJ();
        eM();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.gS = new bd();
        ay ayVar = new ay();
        this.gT = ayVar;
        aVar.a(ayVar);
        aVar.a(new ab(this.f11541eb, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        aVar.a(new y(this.f11541eb, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new ae(this.f11541eb));
        aVar.a(new ah(this.f11541eb));
        aVar.a(new ad(this.f11541eb));
        aVar.a(new ar(this.f11543eh, com.kwad.sdk.core.response.b.b.cO(this.mAdTemplate)));
        aVar.a(new bb(this.f11541eb, this.mApkDownloadHelper));
        aVar.a(new al(this.f11541eb));
        aVar.b(new n(this.f11541eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.f11541eb));
        aVar.a(this.gS);
        aVar.a(new ap(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.f(this.nI, this.nJ));
        this.gV = new WebCardRegisterLiveShopListener();
        this.gU = new WebCardRegisterLiveMessageListener();
        aVar.a(this.gV);
        aVar.a(this.gU);
        aVar.a(new az(getRegisterLiveListener()));
    }
}
