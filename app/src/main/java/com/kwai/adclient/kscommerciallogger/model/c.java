package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    private final d aiD;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    public static class a {
        private BusinessType aEC;
        private SubBusinessType aED;
        private d aEE;
        private JSONObject aEF;
        private final String mCategory;
        private String mEventId;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.mCategory = str;
        }

        public static a Gc() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Gd() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final c Ge() {
            if (com.kwai.adclient.kscommerciallogger.a.FS().isDebug()) {
                if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.FS().FU() && !com.kwai.adclient.kscommerciallogger.b.fe(this.mEventId)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.FS().FU() && !com.kwai.adclient.kscommerciallogger.b.fe(this.mEventId)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.FS().FT() != null) {
                this.aEF = com.kwai.adclient.kscommerciallogger.a.FS().FT();
            }
            return new c(this, (byte) 0);
        }

        public final a P(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aED = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aEE = dVar;
            return this;
        }

        public final a c(BusinessType businessType) {
            this.aEC = businessType;
            return this;
        }

        public final a ff(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a fg(@NonNull String str) {
            this.mEventId = str;
            return this;
        }
    }

    private c(a aVar) {
        this.category = aVar.mCategory;
        this.biz = aVar.aEC;
        this.subBiz = aVar.aED;
        this.tag = aVar.mTag;
        this.aiD = aVar.aEE;
        this.extraParam = aVar.aEF;
        this.eventId = aVar.mEventId;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    public final String FV() {
        return this.category;
    }

    public final BusinessType FW() {
        return this.biz;
    }

    public final SubBusinessType FX() {
        return this.subBiz;
    }

    public final d FY() {
        return this.aiD;
    }

    public final JSONObject FZ() {
        return this.msg;
    }

    public final JSONObject Ga() {
        return this.extraParam;
    }

    public final String Gb() {
        return this.eventId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.aiD;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
