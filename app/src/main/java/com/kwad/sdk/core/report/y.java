package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bb;
import com.qq.e.comm.pi.IBidding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class y extends com.kwad.sdk.core.network.b {
    int ajV;

    @Nullable
    private final b ajW;

    @Nullable
    private final JSONObject ajX;
    private final AdTemplate mAdTemplate;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String ajZ;
        public int aka;
        public int akb;
        public int akc;
        public JSONObject akd;
        public int ake;
        public String templateId;
        public int ajY = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i2 = this.ajY;
            if (i2 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "shield_reason", i2);
            }
            long j2 = this.duration;
            if (j2 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j2);
            }
            int i3 = this.showLiveStatus;
            if (i3 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_status", i3);
            }
            int i4 = this.showLiveStyle;
            if (i4 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_style", i4);
            }
            JSONObject jSONObject2 = this.akd;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.akd.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long Jm;
        public String Ts;
        public String adnName;
        public int adnType;
        public int aiQ;
        public long akA;
        public long akB;
        public int akF;
        public a akG;
        public int akH;
        public int akI;
        public String akM;
        public int akO;
        public int akP;
        public int akQ;
        public String akT;
        public int akf;
        public int akg;
        public int akh;
        public int aki;
        public String akj;
        public int akp;
        public String akq;
        public int akr;
        public int aks;
        public String aku;
        public int akv;
        public String akw;
        public String akx;
        public int aky;
        public int akz;
        public int downloadSource;
        public int jU;
        public ac.a jW;
        public double jX;
        public long uV;
        public long akk = -1;
        public int akl = -1;
        public long akm = -1;
        public int akn = -1;
        public int ako = 0;
        public String akt = "";
        public int akC = -1;
        public int akD = -1;
        public int akE = 0;
        public int akJ = -1;
        public int akK = -1;
        public int akL = -1;
        public int akN = -1;
        public int adxResult = -1;
        public int akR = -1;
        public int akS = 0;

        public final void a(@Nullable j jVar) {
            if (jVar != null) {
                this.akT = jVar.wZ();
            }
        }

        public final void bx(int i2) {
            if (i2 == 0) {
                this.akP = 1;
            } else if (i2 == 1) {
                this.akP = 2;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.akP = 3;
            }
        }
    }

    y(@NonNull AdTemplate adTemplate, int i2, @Nullable b bVar, @Nullable JSONObject jSONObject) {
        this.mAdTemplate = adTemplate;
        this.ajV = i2;
        this.ajW = bVar;
        this.ajX = jSONObject;
    }

    private void B(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.akJ;
        if (i2 >= 0) {
            putBody("adOrder", i2);
        }
        int i3 = bVar.akK;
        if (i3 >= 0) {
            putBody("adInterstitialSource", i3);
        }
        if (!TextUtils.isEmpty(bVar.akj)) {
            putBody("adRenderArea", bVar.akj);
        }
        int i4 = bVar.akL;
        if (i4 >= 0) {
            putBody("universeSecondAd", i4);
        }
        putBody("adxResult", bVar.adxResult);
        int i5 = bVar.akP;
        if (i5 != 0) {
            putBody("fingerSwipeType", i5);
        }
        int i6 = bVar.akQ;
        if (i6 != 0) {
            putBody("fingerSwipeDistance", i6);
        }
        int i7 = bVar.akD;
        if (i7 != -1) {
            putBody("installStatus", i7);
        }
        a aVar = bVar.akG;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        String str2 = bVar.akT;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i8 = bVar.akR;
        if (i8 != -1) {
            putBody("triggerType", i8);
        }
        int i9 = bVar.ako;
        if (i9 != 0) {
            putBody("photoSizeStyle", i9);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable b bVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i2 = adTemplate.mInitVoiceStatus;
        if (i2 != 0) {
            putBody("initVoiceStatus", i2);
        }
        putBody("ecpmType", this.mAdTemplate.mBidEcpm == 0 ? 2 : 1);
        if (bVar == null) {
            return;
        }
        int i3 = bVar.aiQ;
        if (i3 != 0) {
            putBody("adAggPageSource", i3);
        }
        if (TextUtils.isEmpty(bVar.Ts)) {
            return;
        }
        putBody("payload", bVar.Ts);
    }

    private void b(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.jU;
        if (i2 != 0) {
            putBody("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(bVar.Ts)) {
            putBody("payload", bVar.Ts);
        }
        int i3 = bVar.aiQ;
        if (i3 != 0) {
            putBody("adAggPageSource", i3);
        }
        int i4 = bVar.akJ;
        if (i4 >= 0) {
            putBody("adOrder", i4);
        }
        int i5 = bVar.akK;
        if (i5 >= 0) {
            putBody("adInterstitialSource", i5);
        }
        int i6 = bVar.akR;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = bVar.akS;
        if (i7 != 0) {
            putBody("cardCloseType", i7);
        }
        putBody("adxResult", bVar.adxResult);
        double d2 = bVar.jX;
        if (d2 > 0.0d) {
            putBody("splashShakeAcceleration", d2);
        }
        if (!TextUtils.isEmpty(bVar.akM)) {
            putBody("splashInteractionRotateAngle", bVar.akM);
        }
        int i8 = bVar.akP;
        if (i8 != 0) {
            putBody("fingerSwipeType", i8);
        }
        int i9 = bVar.akQ;
        if (i9 != 0) {
            putBody("fingerSwipeDistance", i9);
        }
        long j2 = bVar.uV;
        if (j2 > 0) {
            putBody("playedDuration", j2);
        }
        int i10 = bVar.akI;
        if (i10 > 0) {
            putBody("playedRate", i10);
        }
        String str2 = bVar.akT;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i11 = bVar.akn;
        if (i11 != -1) {
            putBody("retainCodeType", i11);
        }
        a aVar = bVar.akG;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i12 = bVar.ako;
        if (i12 != 0) {
            putBody("photoSizeStyle", i12);
        }
    }

    private void c(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.akh;
        if (i2 != 0) {
            putBody("itemCloseType", i2);
        }
        int i3 = bVar.akf;
        if (i3 > 0) {
            putBody("photoPlaySecond", i3);
        }
        int i4 = bVar.akg;
        if (i4 != 0) {
            putBody("awardReceiveStage", i4);
        }
        int i5 = bVar.aki;
        if (i5 != 0) {
            putBody("elementType", i5);
        }
        if (!TextUtils.isEmpty(bVar.Ts)) {
            putBody("payload", bVar.Ts);
        }
        a aVar = bVar.akG;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i6 = bVar.akp;
        if (i6 > 0) {
            putBody("deeplinkType", i6);
        }
        if (!TextUtils.isEmpty(bVar.akq)) {
            putBody("deeplinkAppName", bVar.akq);
        }
        int i7 = bVar.akr;
        if (i7 != 0) {
            putBody("deeplinkFailedReason", i7);
        }
        int i8 = bVar.downloadSource;
        if (i8 > 0) {
            putBody("downloadSource", i8);
        }
        int i9 = bVar.akS;
        if (i9 != 0) {
            putBody("cardCloseType", i9);
        }
        int i10 = bVar.aks;
        if (i10 > 0) {
            putBody("isPackageChanged", i10);
        }
        putBody("installedFrom", bVar.akt);
        putBody("isChangedEndcard", bVar.akv);
        int i11 = bVar.aiQ;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        String str2 = bVar.aku;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bb.isNullString(bVar.akx)) {
            putBody("installedPackageName", bVar.akx);
        }
        if (!bb.isNullString(bVar.akw)) {
            putBody("serverPackageName", bVar.akw);
        }
        int i12 = bVar.akz;
        if (i12 > 0) {
            putBody("closeButtonClickTime", i12);
        }
        int i13 = bVar.aky;
        if (i13 > 0) {
            putBody("closeButtonImpressionTime", i13);
        }
        int i14 = bVar.akE;
        if (i14 >= 0) {
            putBody("downloadStatus", i14);
        }
        long j2 = bVar.akA;
        if (j2 > 0) {
            putBody("landingPageLoadedDuration", j2);
        }
        long j3 = bVar.Jm;
        if (j3 > 0) {
            putBody("leaveTime", j3);
        }
        long j4 = bVar.akB;
        if (j4 > 0) {
            putBody("adItemClickBackDuration", j4);
        }
        int i15 = bVar.akn;
        if (i15 != -1) {
            putBody("retainCodeType", i15);
        }
        long j5 = bVar.akk;
        if (j5 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j5);
        }
        int i16 = bVar.akl;
        if (i16 >= 0) {
            putBody("impFailReason", i16);
        }
        long j6 = bVar.akm;
        if (j6 > -1) {
            putBody("winEcpm", j6);
        }
        int i17 = bVar.adnType;
        if (i17 > 0) {
            putBody("adnType", i17);
        }
        if (!TextUtils.isEmpty(bVar.adnName)) {
            putBody("adnName", bVar.adnName);
        }
        putBody("downloadCardType", bVar.akF);
        putBody("landingPageType", bVar.akH);
        int i18 = bVar.akK;
        if (i18 >= 0) {
            putBody("adInterstitialSource", i18);
        }
        int i19 = bVar.akN;
        if (i19 > 0) {
            putBody("downloadInstallType", i19);
        }
        int i20 = bVar.akP;
        if (i20 != 0) {
            putBody("fingerSwipeType", i20);
        }
        int i21 = bVar.akQ;
        if (i21 != 0) {
            putBody("fingerSwipeDistance", i21);
        }
        int i22 = bVar.akO;
        if (i22 > 0) {
            putBody("businessSceneType", i22);
        }
        long j7 = bVar.uV;
        if (j7 > 0) {
            putBody("playedDuration", j7);
        }
        int i23 = bVar.akI;
        if (i23 > 0) {
            putBody("playedRate", i23);
        }
        int i24 = bVar.akC;
        if (i24 != -1) {
            putBody("appStorePageType", i24);
        }
        int i25 = bVar.akR;
        if (i25 != -1) {
            putBody("triggerType", i25);
        }
        int i26 = bVar.ako;
        if (i26 != 0) {
            putBody("photoSizeStyle", i26);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public final int getActionType() {
        return this.ajV;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        String replaceFirst;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int i2 = this.ajV;
        if (i2 == 1) {
            replaceFirst = cb.adBaseInfo.showUrl.replaceFirst("__PR__", (this.mAdTemplate.mBidEcpm == 0 && ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sF()) ? String.valueOf(com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) : String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.ajW);
        } else {
            if (i2 != 2) {
                replaceFirst = cb.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
                c(replaceFirst, this.ajW);
                B(this.ajX);
                return replaceFirst;
            }
            String str = cb.adBaseInfo.clickUrl;
            if (this.ajW != null) {
                ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                str = ac.a(str, this.ajW.jW);
            }
            replaceFirst = ac.ag(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), str).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.ajW);
        }
        a(replaceFirst, this.mAdTemplate, this.ajW);
        B(this.ajX);
        return replaceFirst;
    }

    final List<String> xm() {
        ac.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        b bVar;
        ArrayList arrayList = new ArrayList();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (!cb.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = cb.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.ajV && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (bVar = this.ajW) != null) {
                    aVar = bVar.jW;
                }
                Iterator<String> it2 = adTrackInfo.urls.iterator();
                while (it2.hasNext()) {
                    arrayList.add(ab.a(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), it2.next(), aVar, com.kwad.sdk.core.response.a.a.at(cb)));
                }
            }
        }
        return arrayList;
    }
}
