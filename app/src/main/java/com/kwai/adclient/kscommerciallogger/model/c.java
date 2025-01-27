package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    private final d arC;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    public static class a {
        private final String aYQ;
        private BusinessType aYR;
        private SubBusinessType aYS;
        private d aYT;
        private JSONObject aYU;
        private String aYV;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.aYQ = str;
        }

        public static a Qm() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Qn() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Qo() {
            if (com.kwai.adclient.kscommerciallogger.a.Qd().isDebug()) {
                if (TextUtils.isEmpty(this.aYQ) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aYV)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.Qd().Qf() && !com.kwai.adclient.kscommerciallogger.b.hx(this.aYV)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.aYQ) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aYV)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.Qd().Qf() && !com.kwai.adclient.kscommerciallogger.b.hx(this.aYV)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.Qd().Qe() != null) {
                this.aYU = com.kwai.adclient.kscommerciallogger.a.Qd().Qe();
            }
            return new c(this, (byte) 0);
        }

        public final a hy(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a hz(@NonNull String str) {
            this.aYV = str;
            return this;
        }

        public final a b(BusinessType businessType) {
            this.aYR = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aYS = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aYT = dVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b10) {
        this(aVar);
    }

    public final String Qg() {
        return this.category;
    }

    public final SubBusinessType Qh() {
        return this.subBiz;
    }

    public final d Qi() {
        return this.arC;
    }

    public final JSONObject Qj() {
        return this.msg;
    }

    public final JSONObject Qk() {
        return this.extraParam;
    }

    public final String Ql() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put(x2.b.f31789l, businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put(TTDownloadField.TT_TAG, this.tag);
            d dVar = this.arC;
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
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    private c(a aVar) {
        this.category = aVar.aYQ;
        this.biz = aVar.aYR;
        this.subBiz = aVar.aYS;
        this.tag = aVar.mTag;
        this.arC = aVar.aYT;
        this.extraParam = aVar.aYU;
        this.eventId = aVar.aYV;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }
}
