package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.am;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c extends SigmobRequest {

    /* renamed from: a */
    public a f18336a;

    /* renamed from: b */
    public byte[] f18337b;

    public interface a extends Response.ErrorListener {
        void onSuccess(JSONObject jSONObject);
    }

    public c(String str, BidResponse bidResponse, a aVar) {
        super(str, 1, aVar);
        this.f18336a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        String a10 = a(bidResponse);
        if (a10 != null) {
            try {
                this.f18337b = AESUtil.Encrypt(a10.getBytes(), "KGpfzbYsn4T9Jyuq");
            } catch (Exception unused) {
                SigmobLog.e("feedback body bug");
            }
        }
    }

    public final void a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            Object opt = optJSONObject.opt(keys.next());
            if (opt instanceof String) {
                String str2 = (String) opt;
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                    jSONObject.remove(str);
                    try {
                        jSONObject.put(str, encodeToString);
                    } catch (JSONException e10) {
                        throw new RuntimeException(e10);
                    }
                }
            }
        }
    }

    @Override // com.czhj.volley.Request, java.lang.Comparable
    public int compareTo(Object obj) {
        return 0;
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        super.deliverError(volleyError);
        a aVar = this.f18336a;
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(Object obj) {
        a aVar = this.f18336a;
        if (aVar != null) {
            aVar.onSuccess(null);
        }
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        return this.f18337b;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public String getBodyContentType() {
        return am.f6738d;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put(com.kwad.sdk.m.e.TAG, "1");
        }
        return headers;
    }

    public final String a(BidResponse bidResponse) {
        try {
            JSONObject jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse));
            JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f24233j);
            if (optJSONObject != null) {
                a(optJSONObject, com.umeng.analytics.pro.f.X);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(com.sigmob.sdk.base.db.a.f18088a);
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONArray jSONArray = optJSONArray.getJSONObject(i10).getJSONArray("materials");
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                        a(jSONObject2, "html_snippet");
                        a(jSONObject2, "closecard_html_snippet");
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("main_template");
                        if (optJSONObject2 != null) {
                            a(optJSONObject2, com.umeng.analytics.pro.f.X);
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("sub_template");
                        if (optJSONObject3 != null) {
                            a(optJSONObject3, com.umeng.analytics.pro.f.X);
                        }
                    }
                }
            }
            SigmobLog.d("json " + jSONObject);
            return jSONObject.toString();
        } catch (Throwable th2) {
            SigmobLog.e("Serialize error", th2);
            return null;
        }
    }
}
