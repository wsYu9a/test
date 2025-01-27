package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class p implements com.kwad.sdk.core.webview.b.a {
    private boolean dontShowDialog;
    private List<com.kwad.components.core.d.b.c> mApkDownloadHelperList;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;
    private int mClickActionSource;
    private final boolean mNeedReport;

    @Nullable
    private DialogInterface.OnDismissListener mTaskDismissListener;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;

    /* renamed from: com.kwad.components.core.webview.jshandler.p$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

        /* renamed from: com.kwad.components.core.webview.jshandler.p$1$1 */
        final class C01921 implements a.b {
            C01921() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                p.this.onAdClickListen();
                if (p.this.mWebCardClickListener != null) {
                    p.this.mWebCardClickListener.onAdClicked(aVar);
                }
            }
        }

        AnonymousClass1(com.kwad.sdk.core.webview.c.a.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdTemplate adTemplate;
            TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
            com.kwad.sdk.core.webview.b bVar = p.this.mBridgeContext;
            if (bVar.aps) {
                if (aVar.creativeId >= 0) {
                    List<AdTemplate> yT = bVar.yT();
                    com.kwad.sdk.core.webview.c.a.a aVar = aVar;
                    adTemplate = com.kwad.sdk.core.response.a.d.a(yT, aVar.creativeId, aVar.adStyle);
                } else {
                    adTemplate = bVar.getAdTemplate();
                    aVar.creativeId = com.kwad.sdk.core.response.a.d.cl(adTemplate);
                    aVar.adStyle = com.kwad.sdk.core.response.a.d.bW(adTemplate);
                }
                com.kwad.components.core.d.b.c apkDownloadHelper = p.this.getApkDownloadHelper(aVar.creativeId);
                if (p.this.mTaskDismissListener != null && apkDownloadHelper != null) {
                    apkDownloadHelper.setOnDismissListener(p.this.mTaskDismissListener);
                }
                String str = null;
                if (!TextUtils.isEmpty(aVar.IY)) {
                    try {
                        str = com.kwad.components.core.d.kwai.a.o(Long.parseLong(aVar.IY));
                    } catch (Exception unused) {
                        str = aVar.IY;
                    }
                } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                    str = tKAdLiveShopItemInfo.itemId;
                }
                p.this.afterHandleAdClick(com.kwad.components.core.d.b.a.a(new a.C0172a(p.this.mBridgeContext.LD.getContext()).I(adTemplate).b(apkDownloadHelper).ap(str).ao(p.this.enablePauseByActionbar(aVar)).ap(p.this.dontShowDialog).d(p.this.mBridgeContext.mReportExtData).ap(aVar.TC).an(aVar.aqo).ao(aVar.jU).aq(p.this.mNeedReport || aVar.IQ).ar(p.this.mClickActionSource).a(p.this.getClientParams(aVar, adTemplate)).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.p.1.1
                    C01921() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        p.this.onAdClickListen();
                        if (p.this.mWebCardClickListener != null) {
                            p.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                })));
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.p$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

        AnonymousClass2(com.kwad.sdk.core.webview.c.a.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (p.this.mWebCardClickListener != null) {
                p.this.mWebCardClickListener.onAdClicked(aVar);
            }
        }
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, 0, false);
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, int i2) {
        this(bVar, cVar, aVar, false, i2, false);
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, int i2, boolean z) {
        this(bVar, cVar, aVar, false, i2, z);
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false);
        this.mTaskDismissListener = onDismissListener;
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z, int i2, boolean z2) {
        this.dontShowDialog = false;
        this.mApkDownloadHelperList = new ArrayList();
        this.dontShowDialog = z;
        this.mBridgeContext = bVar;
        this.mClickActionSource = i2;
        if (cVar != null) {
            cVar.as(1);
            this.mApkDownloadHelperList.add(cVar);
        }
        this.mWebCardClickListener = aVar;
        this.mNeedReport = z2;
    }

    public p(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.d.b.c> list, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, null, aVar, false, 0, false);
        if (list != null) {
            this.mApkDownloadHelperList.addAll(list);
        }
    }

    public boolean enablePauseByActionbar(com.kwad.sdk.core.webview.c.a.a aVar) {
        return aVar.TC == 1;
    }

    private boolean isInterstitialAd(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bW(adTemplate) == 13;
    }

    protected void afterHandleAdClick(int i2) {
    }

    @Nullable
    protected com.kwad.components.core.d.b.c getApkDownloadHelper(long j2) {
        List<com.kwad.components.core.d.b.c> list = this.mApkDownloadHelperList;
        if (list == null) {
            return null;
        }
        if (j2 < 0 && list.size() == 1) {
            return this.mApkDownloadHelperList.get(0);
        }
        for (com.kwad.components.core.d.b.c cVar : this.mApkDownloadHelperList) {
            if (com.kwad.sdk.core.response.a.d.cl(cVar.nj()) == j2) {
                return cVar;
            }
        }
        return null;
    }

    @NonNull
    protected y.b getClientParams(com.kwad.sdk.core.webview.c.a.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.c.a.c cVar;
        int i2;
        y.b bVar = new y.b();
        com.kwad.sdk.core.webview.c.a.c cVar2 = aVar.TD;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.Ts)) {
            bVar.Ts = aVar.TD.Ts;
        }
        com.kwad.sdk.core.webview.c.a.c cVar3 = aVar.TD;
        if (cVar3 != null && (i2 = cVar3.aqp) != 0) {
            bVar.akR = i2;
        }
        if (!isInterstitialAd(adTemplate) || (cVar = aVar.TD) == null || cVar.aqq == null) {
            com.kwad.sdk.widget.e eVar = this.mBridgeContext.app;
            if (eVar != null) {
                bVar.jW = eVar.getTouchCoords();
            }
        } else {
            ac.a aVar2 = new ac.a();
            com.kwad.sdk.core.webview.c.a.b bVar2 = aVar.TD.aqq;
            aVar2.g((float) bVar2.x, (float) bVar2.y);
            com.kwad.sdk.core.webview.c.a.b bVar3 = aVar.TD.aqq;
            aVar2.f((float) bVar3.x, (float) bVar3.y);
            com.kwad.sdk.core.webview.c.a.b bVar4 = aVar.TD.aqq;
            aVar2.u(bVar4.width, bVar4.height);
            bVar.jW = aVar2;
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        Runnable anonymousClass2;
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (!this.mBridgeContext.apr) {
            if (this.mWebCardClickListener != null) {
                anonymousClass2 = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.p.2
                    final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

                    AnonymousClass2(com.kwad.sdk.core.webview.c.a.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (p.this.mWebCardClickListener != null) {
                            p.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        anonymousClass2 = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.p.1
            final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

            /* renamed from: com.kwad.components.core.webview.jshandler.p$1$1 */
            final class C01921 implements a.b {
                C01921() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    p.this.onAdClickListen();
                    if (p.this.mWebCardClickListener != null) {
                        p.this.mWebCardClickListener.onAdClicked(aVar);
                    }
                }
            }

            AnonymousClass1(com.kwad.sdk.core.webview.c.a.a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdTemplate adTemplate;
                TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                com.kwad.sdk.core.webview.b bVar = p.this.mBridgeContext;
                if (bVar.aps) {
                    if (aVar.creativeId >= 0) {
                        List<AdTemplate> yT = bVar.yT();
                        com.kwad.sdk.core.webview.c.a.a aVar2 = aVar;
                        adTemplate = com.kwad.sdk.core.response.a.d.a(yT, aVar2.creativeId, aVar2.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                        aVar.creativeId = com.kwad.sdk.core.response.a.d.cl(adTemplate);
                        aVar.adStyle = com.kwad.sdk.core.response.a.d.bW(adTemplate);
                    }
                    com.kwad.components.core.d.b.c apkDownloadHelper = p.this.getApkDownloadHelper(aVar.creativeId);
                    if (p.this.mTaskDismissListener != null && apkDownloadHelper != null) {
                        apkDownloadHelper.setOnDismissListener(p.this.mTaskDismissListener);
                    }
                    String str2 = null;
                    if (!TextUtils.isEmpty(aVar.IY)) {
                        try {
                            str2 = com.kwad.components.core.d.kwai.a.o(Long.parseLong(aVar.IY));
                        } catch (Exception unused) {
                            str2 = aVar.IY;
                        }
                    } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                        str2 = tKAdLiveShopItemInfo.itemId;
                    }
                    p.this.afterHandleAdClick(com.kwad.components.core.d.b.a.a(new a.C0172a(p.this.mBridgeContext.LD.getContext()).I(adTemplate).b(apkDownloadHelper).ap(str2).ao(p.this.enablePauseByActionbar(aVar)).ap(p.this.dontShowDialog).d(p.this.mBridgeContext.mReportExtData).ap(aVar.TC).an(aVar.aqo).ao(aVar.jU).aq(p.this.mNeedReport || aVar.IQ).ar(p.this.mClickActionSource).a(p.this.getClientParams(aVar, adTemplate)).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.p.1.1
                        C01921() {
                        }

                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            p.this.onAdClickListen();
                            if (p.this.mWebCardClickListener != null) {
                                p.this.mWebCardClickListener.onAdClicked(aVar);
                            }
                        }
                    })));
                }
            }
        };
        bi.runOnUiThread(anonymousClass2);
        cVar.a(null);
    }

    protected void onAdClickListen() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.mWebCardClickListener = null;
    }
}
