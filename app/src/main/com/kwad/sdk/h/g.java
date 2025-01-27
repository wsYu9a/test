package com.kwad.sdk.h;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g {
    private String aCD;
    private String aDA;
    private String aDB;
    private JSONObject aNE;
    private boolean aNF;
    private Map<String, String> aiT;
    private String appId;
    private JSONObject asR;
    private String axi;
    private String axj;
    private String sdkVersion;

    private g() {
    }

    public static g KM() {
        return new g();
    }

    public final JSONObject KN() {
        return this.aNE;
    }

    public final boolean KO() {
        return this.aNF;
    }

    public final String KP() {
        return this.aCD;
    }

    public final JSONObject KQ() {
        return this.asR;
    }

    public final g bH(boolean z10) {
        this.aNF = z10;
        return this;
    }

    public final g ge(String str) {
        this.appId = str;
        return this;
    }

    public final String getAndroidId() {
        return this.aDA;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.aDB;
    }

    public final String getImei() {
        return this.axi;
    }

    public final String getOaid() {
        return this.axj;
    }

    public final Map<String, String> getRequestHeader() {
        return this.aiT;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g gf(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gg(String str) {
        this.axj = str;
        return this;
    }

    public final g gh(String str) {
        this.aDB = str;
        return this;
    }

    public final g gi(String str) {
        this.aDA = str;
        return this;
    }

    public final g gj(String str) {
        this.axi = str;
        return this;
    }

    public final g gk(String str) {
        this.aCD = str;
        return this;
    }

    public final g h(Map<String, String> map) {
        this.aiT = map;
        return this;
    }

    public final g m(JSONObject jSONObject) {
        this.aNE = jSONObject;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.asR = jSONObject;
        return this;
    }
}
