package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.x;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int asy;

    @NonNull
    private final com.kwad.sdk.core.adlog.c.a asz;
    private final AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a */
    public static class C0484a extends com.kwad.sdk.core.response.a.a {
        public String asB;
        public int asC;
        public int asD;
        public int asE;
        public int asF;
        public int asG;
        public JSONObject asH;
        public int asJ;
        public int asK;

        @Nullable
        public AdTrackLog asL;
        public String templateId;
        public int asA = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int asI = 0;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.Af()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.asL = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.asL);
            }
            return this.asL;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i10 = this.asA;
            if (i10 != -1) {
                x.putValue(jSONObject, "shield_reason", i10);
            }
            long j10 = this.duration;
            if (j10 != -1) {
                x.putValue(jSONObject, "duration", j10);
            }
            int i11 = this.showLiveStatus;
            if (i11 != -1) {
                x.putValue(jSONObject, "show_live_status", i11);
            }
            int i12 = this.showLiveStyle;
            if (i12 != -1) {
                x.putValue(jSONObject, "show_live_style", i12);
            }
            AdTrackLog adTrackLog = this.asL;
            if (adTrackLog != null) {
                x.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.asH;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.asH.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.asz = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.asy = aVar.asm;
    }

    private void CC() {
        JSONObject jSONObject = this.asz.ati;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        x.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.atP;
        if (i10 >= 0) {
            putBody("adOrder", i10);
        }
        int i11 = aVar.MH;
        if (i11 >= 0) {
            putBody("adInterstitialSource", i11);
        }
        if (!TextUtils.isEmpty(aVar.atn)) {
            putBody("adRenderArea", aVar.atn);
        }
        putBody("adxResult", aVar.adxResult);
        int i12 = aVar.atT;
        if (i12 != 0) {
            putBody("fingerSwipeType", i12);
        }
        int i13 = aVar.atU;
        if (i13 != 0) {
            putBody("fingerSwipeDistance", i13);
        }
        int i14 = aVar.atM;
        if (i14 != -1) {
            putBody("installStatus", i14);
        }
        C0484a c0484a = aVar.MJ;
        if (c0484a != null) {
            putBody("clientExtData", c0484a.toJson().toString());
        }
        String str2 = aVar.atX;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i15 = aVar.ML;
        if (i15 != -1) {
            putBody("triggerType", i15);
        }
        int i16 = aVar.MK;
        if (i16 != 0) {
            putBody("photoSizeStyle", i16);
        }
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.lz;
        if (i10 != 0) {
            putBody("itemClickType", i10);
        }
        if (!TextUtils.isEmpty(aVar.MI)) {
            putBody("payload", aVar.MI);
        }
        int i11 = aVar.atE;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        int i12 = aVar.atP;
        if (i12 >= 0) {
            putBody("adOrder", i12);
        }
        int i13 = aVar.MH;
        if (i13 >= 0) {
            putBody("adInterstitialSource", i13);
        }
        int i14 = aVar.ML;
        if (i14 != -1) {
            putBody("triggerType", i14);
        }
        int i15 = aVar.atW;
        if (i15 != 0) {
            putBody("cardCloseType", i15);
        }
        putBody("adxResult", aVar.adxResult);
        double d10 = aVar.lC;
        if (d10 > l5.c.f27899e) {
            putBody("splashShakeAcceleration", d10);
        }
        if (!TextUtils.isEmpty(aVar.atQ)) {
            putBody("splashInteractionRotateAngle", aVar.atQ);
        }
        int i16 = aVar.atT;
        if (i16 != 0) {
            putBody("fingerSwipeType", i16);
        }
        int i17 = aVar.atU;
        if (i17 != 0) {
            putBody("fingerSwipeDistance", i17);
        }
        long j10 = aVar.f11968xc;
        if (j10 > 0) {
            putBody("playedDuration", j10);
        }
        int i18 = aVar.atO;
        if (i18 > 0) {
            putBody("playedRate", i18);
        }
        String str2 = aVar.atX;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i19 = aVar.atw;
        if (i19 != -1) {
            putBody("retainCodeType", i19);
        }
        C0484a c0484a = aVar.MJ;
        if (c0484a != null) {
            putBody("clientExtData", c0484a.toJson().toString());
        }
        int i20 = aVar.atV;
        if (i20 != 0) {
            putBody("finger_swiper_angle", i20);
        }
        int i21 = aVar.MK;
        if (i21 != 0) {
            putBody("photoSizeStyle", i21);
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.atl;
        if (i10 != 0) {
            putBody("itemCloseType", i10);
        }
        int i11 = aVar.atj;
        if (i11 > 0) {
            putBody("photoPlaySecond", i11);
        }
        int i12 = aVar.atk;
        if (i12 != 0) {
            putBody("awardReceiveStage", i12);
        }
        int i13 = aVar.atm;
        if (i13 != 0) {
            putBody("elementType", i13);
        }
        if (!TextUtils.isEmpty(aVar.MI)) {
            putBody("payload", aVar.MI);
        }
        C0484a c0484a = aVar.MJ;
        if (c0484a != null) {
            putBody("clientExtData", c0484a.toJson().toString());
        }
        int i14 = aVar.atx;
        if (i14 > 0) {
            putBody("deeplinkType", i14);
        }
        if (!TextUtils.isEmpty(aVar.aty)) {
            putBody("deeplinkAppName", aVar.aty);
        }
        int i15 = aVar.atz;
        if (i15 != 0) {
            putBody("deeplinkFailedReason", i15);
        }
        int i16 = aVar.downloadSource;
        if (i16 > 0) {
            putBody("downloadSource", i16);
        }
        int i17 = aVar.atW;
        if (i17 != 0) {
            putBody("cardCloseType", i17);
        }
        int i18 = aVar.atA;
        if (i18 > 0) {
            putBody("isPackageChanged", i18);
        }
        putBody("installedFrom", aVar.atB);
        putBody("isChangedEndcard", aVar.atD);
        int i19 = aVar.atE;
        if (i19 != 0) {
            putBody("adAggPageSource", i19);
        }
        String str2 = aVar.atC;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bm.isNullString(aVar.atG)) {
            putBody("installedPackageName", aVar.atG);
        }
        if (!bm.isNullString(aVar.atF)) {
            putBody("serverPackageName", aVar.atF);
        }
        int i20 = aVar.atI;
        if (i20 > 0) {
            putBody("closeButtonClickTime", i20);
        }
        int i21 = aVar.atH;
        if (i21 > 0) {
            putBody("closeButtonImpressionTime", i21);
        }
        int i22 = aVar.downloadStatus;
        if (i22 >= 0) {
            putBody("downloadStatus", i22);
        }
        long j10 = aVar.atJ;
        if (j10 > 0) {
            putBody("landingPageLoadedDuration", j10);
        }
        long j11 = aVar.Nk;
        if (j11 > 0) {
            putBody("leaveTime", j11);
        }
        long j12 = aVar.atK;
        if (j12 > 0) {
            putBody("adItemClickBackDuration", j12);
        }
        int i23 = aVar.atw;
        if (i23 != -1) {
            putBody("retainCodeType", i23);
        }
        long j13 = aVar.ato;
        if (j13 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j13);
        }
        int i24 = aVar.atp;
        if (i24 >= 0) {
            putBody("impFailReason", i24);
        }
        long j14 = aVar.atq;
        if (j14 > -1) {
            putBody("winEcpm", j14);
        }
        int i25 = aVar.adnType;
        if (i25 > 0) {
            putBody("adnType", i25);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.atr)) {
            putBody("adnAdvertiser", aVar.atr);
        }
        if (!TextUtils.isEmpty(aVar.ats)) {
            putBody("adnTitle", aVar.ats);
        }
        if (!TextUtils.isEmpty(aVar.att)) {
            putBody("adnRequestId", aVar.att);
        }
        if (aVar.atp == 2) {
            putBody("adnShowType", aVar.atu);
            putBody("adnClickType", aVar.atv);
        }
        putBody("downloadCardType", aVar.atN);
        putBody("landingPageType", aVar.Qq);
        int i26 = aVar.MH;
        if (i26 >= 0) {
            putBody("adInterstitialSource", i26);
        }
        int i27 = aVar.atR;
        if (i27 > 0) {
            putBody("downloadInstallType", i27);
        }
        int i28 = aVar.atT;
        if (i28 != 0) {
            putBody("fingerSwipeType", i28);
        }
        int i29 = aVar.atU;
        if (i29 != 0) {
            putBody("fingerSwipeDistance", i29);
        }
        int i30 = aVar.atS;
        if (i30 > 0) {
            putBody("businessSceneType", i30);
        }
        long j15 = aVar.f11968xc;
        if (j15 > 0) {
            putBody("playedDuration", j15);
        }
        int i31 = aVar.atO;
        if (i31 > 0) {
            putBody("playedRate", i31);
        }
        int i32 = aVar.atL;
        if (i32 != -1) {
            putBody("appStorePageType", i32);
        }
        int i33 = aVar.ML;
        if (i33 != -1) {
            putBody("triggerType", i33);
        }
        int i34 = aVar.MK;
        if (i34 != 0) {
            putBody("photoSizeStyle", i34);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        Context context = ServiceProvider.getContext();
        AdInfo eb2 = e.eb(this.mAdTemplate);
        int i10 = this.asy;
        if (i10 == 1) {
            String str = eb2.adBaseInfo.showUrl;
            replaceFirst = ((this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).zU()) ? str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(e.eb(this.mAdTemplate)))) : str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm))).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.asz);
            a(replaceFirst, this.mAdTemplate, this.asz);
        } else if (i10 == 2) {
            replaceFirst = ag.am(context, ag.a(eb2.adBaseInfo.clickUrl, this.asz.lB)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.asz);
            a(replaceFirst, this.mAdTemplate, this.asz);
        } else {
            replaceFirst = eb2.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i10)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.asz);
        }
        CC();
        return replaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i10 = adTemplate.mInitVoiceStatus;
        if (i10 != 0) {
            putBody("initVoiceStatus", i10);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i11 = aVar.atE;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        if (TextUtils.isEmpty(aVar.MI)) {
            return;
        }
        putBody("payload", aVar.MI);
    }
}
