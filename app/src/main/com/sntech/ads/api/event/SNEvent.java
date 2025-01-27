package com.sntech.ads.api.event;

import androidx.annotation.Keep;
import com.anythink.core.api.ATAdInfo;
import com.martian.ads.ad.AdConfig;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;
import java.util.Map;
import ke.e;

@Keep
/* loaded from: classes4.dex */
public class SNEvent {
    private static Map<Integer, AdPlatform> sIdPlatform;

    @Keep
    public enum AdEvent {
        SHOW(AdConfig.Type.SHOW),
        CLICK(AdConfig.Type.CLICK),
        CLICK_CREATIVE("CLICK_CREATIVE"),
        DOWNLOAD(AdConfig.Type.DOWNLOAD),
        INSTALL(AdConfig.Type.INSTALL),
        SHOW_COMPLETE("SHOW_COMPLETE"),
        AD_CLOSE("AD_CLOSE"),
        AD_ERROR("AD_ERROR"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdEvent(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    @Keep
    public enum AdPlatform {
        FACEBOOK(GlobalSetting.FACEBOOK_SDK_WRAPPER),
        ADMOB(GlobalSetting.ADMOB_SDK_WRAPPER),
        INMOBI("INMOBI"),
        FLURRY("FLURRY"),
        APPLOVIN(GlobalSetting.APPLOVIN_SDK_WRAPPER),
        MOPUB("MOPUB"),
        CHARTBOOST("CHARTBOOST"),
        TAPJOY("TAPJOY"),
        IRONSOURCE("IRONSOURCE"),
        UNITY("UNITY"),
        VUNGLE("VUNGLE"),
        ADCOLONY("ADCOLONY"),
        JOOMOB("JOOMOB"),
        ONEWAY("ONEWAY"),
        JINSHANYUN("JINSHANYUN"),
        APPNEXT("APPNEXT"),
        NEND("NEND"),
        MAIO("MAIO"),
        STARTAPP("STARTAPP"),
        SUPERAWESOME("SUPERAWESOME"),
        MYTARGET("MYTARGET"),
        MYOFFER("MYOFFER"),
        OGURY("OGURY"),
        FYBER("FYBER"),
        HUAWEI(e.f27804b),
        HELIUM("HELIUM"),
        KIDOZ("KIDOZ"),
        PANGLE("PANGLE"),
        CSJ(AdConfig.UnionType.CSJ),
        YLH("YLH"),
        BQT(AdConfig.UnionType.BQT),
        KUAISHOU("KUAISHOU"),
        SIGMOB(AdConfig.UnionType.SIGMOB),
        MTG("MTG"),
        YKY("YKY"),
        GROMORE("GROMORE"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdPlatform(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    @Keep
    public enum AdType {
        FEED("FEED"),
        DRAW_FEED("DRAW_FEED"),
        NATIVE("NATIVE"),
        BANNER("BANNER"),
        INTERSTITIAL("INTERSTITIAL"),
        SPLASH("SPLASH"),
        REWARD_VIDEO("REWARD_VIDEO"),
        FULL_SCREEN_VIDEO("FULL_SCREEN_VIDEO"),
        EXPRESS_SPLASH("EXPRESS_SPLASH"),
        EXPRESS_NATIVE("EXPRESS_NATIVE"),
        EXPRESS_FEED("EXPRESS_FEED"),
        EXPRESS_DRAW_FEED("EXPRESS_DRAW_FEED"),
        EXPRESS_BANNER("EXPRESS_BANNER"),
        EXPRESS_BANNER_FEED("EXPRESS_BANNER_FEED"),
        EXPRESS_REWARD_VIDEO("EXPRESS_REWARD_VIDEO"),
        EXPRESS_FULL_SCREEN_VIDEO("EXPRESS_FULL_SCREEN_VIDEO"),
        EXPRESS_INTERSTITIAL("EXPRESS_INTERSTITIAL"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdType(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    @Keep
    public enum EventSource {
        POLLING("polling"),
        OFFICIAL("official");

        private String name;

        EventSource(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    @Keep
    public enum UserEvent {
        REGISTER("REGISTER"),
        LOGIN("LOGIN");

        private String name;

        UserEvent(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    @Keep
    public enum WithdrawChannel {
        ALIPAY("ALIPAY"),
        WECHAT("WECHAT");

        private String name;

        WithdrawChannel(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sIdPlatform = hashMap;
        hashMap.put(1, AdPlatform.FACEBOOK);
        sIdPlatform.put(2, AdPlatform.ADMOB);
        sIdPlatform.put(3, AdPlatform.INMOBI);
        sIdPlatform.put(4, AdPlatform.FLURRY);
        sIdPlatform.put(5, AdPlatform.APPLOVIN);
        sIdPlatform.put(6, AdPlatform.MTG);
        sIdPlatform.put(7, AdPlatform.MOPUB);
        sIdPlatform.put(8, AdPlatform.YLH);
        sIdPlatform.put(9, AdPlatform.CHARTBOOST);
        sIdPlatform.put(10, AdPlatform.TAPJOY);
        sIdPlatform.put(11, AdPlatform.IRONSOURCE);
        sIdPlatform.put(12, AdPlatform.UNITY);
        sIdPlatform.put(13, AdPlatform.VUNGLE);
        sIdPlatform.put(14, AdPlatform.ADCOLONY);
        sIdPlatform.put(15, AdPlatform.CSJ);
        sIdPlatform.put(16, AdPlatform.JOOMOB);
        sIdPlatform.put(17, AdPlatform.ONEWAY);
        sIdPlatform.put(19, AdPlatform.JINSHANYUN);
        sIdPlatform.put(21, AdPlatform.APPNEXT);
        sIdPlatform.put(22, AdPlatform.BQT);
        sIdPlatform.put(23, AdPlatform.NEND);
        sIdPlatform.put(24, AdPlatform.MAIO);
        sIdPlatform.put(25, AdPlatform.STARTAPP);
        sIdPlatform.put(26, AdPlatform.SUPERAWESOME);
        sIdPlatform.put(28, AdPlatform.KUAISHOU);
        sIdPlatform.put(29, AdPlatform.SIGMOB);
        sIdPlatform.put(32, AdPlatform.MYTARGET);
        sIdPlatform.put(35, AdPlatform.MYOFFER);
        sIdPlatform.put(36, AdPlatform.OGURY);
        sIdPlatform.put(37, AdPlatform.FYBER);
        sIdPlatform.put(39, AdPlatform.HUAWEI);
        sIdPlatform.put(40, AdPlatform.HELIUM);
        sIdPlatform.put(45, AdPlatform.KIDOZ);
        sIdPlatform.put(46, AdPlatform.GROMORE);
        sIdPlatform.put(50, AdPlatform.PANGLE);
        sIdPlatform.put(51, AdPlatform.YKY);
    }

    @Keep
    public static String getTopOnRealAdId(ATAdInfo aTAdInfo) {
        return aTAdInfo == null ? "" : aTAdInfo.getNetworkPlacementId();
    }

    @Keep
    public static AdPlatform getTopOnRealAdPlatform(int i10) {
        AdPlatform adPlatform = sIdPlatform.get(Integer.valueOf(i10));
        return adPlatform == null ? AdPlatform.UNKNOWN : adPlatform;
    }

    @Keep
    public static AdPlatform getTopOnRealAdPlatform(ATAdInfo aTAdInfo) {
        return aTAdInfo == null ? AdPlatform.UNKNOWN : getTopOnRealAdPlatform(aTAdInfo.getNetworkFirmId());
    }
}
