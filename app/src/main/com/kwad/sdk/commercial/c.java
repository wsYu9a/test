package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    public com.kwai.adclient.kscommerciallogger.model.d arC;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;
    public double arx = 0.01d;
    public double ary = 1.0d;
    public double arz = 0.001d;
    public BusinessType arA = BusinessType.OTHER;
    public SubBusinessType arB = SubBusinessType.OTHER;

    private c() {
    }

    public static c Cg() {
        return new c();
    }

    public final c N(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final c a(BusinessType businessType) {
        this.arA = businessType;
        return this;
    }

    public final c cB(String str) {
        this.category = str;
        return this;
    }

    public final c cC(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    public final c h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final c i(double d10) {
        this.arx = d10;
        return this;
    }

    public final c j(double d10) {
        this.ary = d10;
        return this;
    }

    public final c k(double d10) {
        this.arz = 0.001d;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.arA + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    public final c u(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final c a(SubBusinessType subBusinessType) {
        this.arB = subBusinessType;
        return this;
    }

    public final c a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.arC = dVar;
        return this;
    }
}
