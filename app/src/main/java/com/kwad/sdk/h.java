package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: classes3.dex */
public final class h {
    public static String bZ(String str) {
        return str + "/rest/e/system/speed";
    }

    public static String ze() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.Fz().W("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return str;
    }

    public static String zf() {
        return ze() + "/rest/e/v3/open/univ";
    }

    public static String zg() {
        return ze() + "/rest/e/v4/open/univ";
    }

    public static String zh() {
        return ze() + "/rest/e/v4/open/univ/bidding";
    }

    public static String zi() {
        return ze() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String zj() {
        return ze() + "/rest/e/v3/open/logBatch";
    }

    public static String zk() {
        return ze() + "/rest/e/v3/open/config";
    }

    public static String zl() {
        return ze() + "/rest/e/v3/open/callback";
    }

    public static String zm() {
        return ze() + "/rest/e/v3/open/crashLog";
    }

    public static String zn() {
        return ze() + "/rest/e/v3/open/appCheck";
    }

    public static String zo() {
        return ze() + "/rest/e/v3/open/collect";
    }

    public static String zp() {
        return ze() + "/rest/e/v3/open/checkReward";
    }

    public static String zq() {
        return ze() + "/rest/e/v3/open/rewardFraudVerify";
    }

    public static String zr() {
        return ze() + "/rest/e/v3/open/kwaiGeoLocation";
    }

    public static String zs() {
        return ze() + "/rest/e/v3/open/getMiMarketUrl";
    }

    public static String zt() {
        return "https://style-browse-openapi.test.gifshow.com//rest/e/internal/adBrowse";
    }
}
