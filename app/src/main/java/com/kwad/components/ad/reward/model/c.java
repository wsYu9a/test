package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.internal.api.e;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean hG = com.kwad.components.ad.reward.a.b.gY();

    @Nullable
    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (com.kwad.sdk.core.config.d.Eh()) {
            ksVideoPlayConfig = e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData d10 = f.nt().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (d10 == null) {
                return null;
            }
            return a(d10, intExtra, ksVideoPlayConfig);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!com.kwad.sdk.core.config.d.Eh() && com.kwad.sdk.core.response.b.e.er(adTemplate) < 0) {
            File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(com.kwad.sdk.core.response.b.a.K(adInfo));
            if (ca2 == null || !ca2.exists()) {
                return false;
            }
        }
        return true;
    }

    public final AdInfo ce() {
        return this.mAdInfo;
    }

    public final boolean cf() {
        return com.kwad.sdk.core.response.b.e.en(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean hD() {
        return com.kwad.sdk.core.response.b.e.k(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(ce()));
    }

    public final boolean hE() {
        return com.kwad.sdk.core.response.b.e.J(getAdTemplate());
    }

    public final AdResultData hF() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig hG() {
        return this.mVideoPlayConfig;
    }

    public final int hH() {
        return this.rewardType;
    }

    public final JSONObject hI() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo hJ() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    @Nullable
    private static c a(AdResultData adResultData, int i10, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        if (o10 == null) {
            com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(o10);
        if (!c(o10, eb2)) {
            return null;
        }
        boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
        o10.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            x.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = o10;
        cVar.mAdInfo = eb2;
        cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
        cVar.rewardType = i10;
        return cVar;
    }
}
