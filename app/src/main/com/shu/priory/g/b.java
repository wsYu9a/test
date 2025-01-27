package com.shu.priory.g;

import android.content.Context;
import com.shu.priory.config.AdError;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.Encoder;
import com.shu.priory.utils.e;
import com.shu.priory.utils.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public int f17100a;

    /* renamed from: b */
    public String f17101b;

    /* renamed from: c */
    public String f17102c;

    /* renamed from: d */
    public String f17103d;

    /* renamed from: e */
    public String f17104e;

    /* renamed from: f */
    public a f17105f;

    /* renamed from: g */
    public boolean f17106g;

    /* renamed from: h */
    public JSONObject f17107h;

    /* renamed from: i */
    public JSONObject f17108i;

    /* renamed from: j */
    public JSONObject f17109j;

    /* renamed from: k */
    public JSONArray f17110k;

    /* renamed from: l */
    public String f17111l;

    /* renamed from: m */
    public Context f17112m;

    /* renamed from: n */
    public String f17113n;

    /* renamed from: o */
    private JSONObject f17114o;

    /* renamed from: p */
    private boolean f17115p;

    public b(Context context) {
        this.f17112m = context;
    }

    private String d() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

    public void a() {
        this.f17100a = -1;
        this.f17101b = "";
        this.f17102c = "";
        this.f17103d = "";
        this.f17104e = "";
        this.f17105f = null;
        this.f17106g = false;
        this.f17107h = null;
        this.f17108i = null;
        this.f17115p = false;
    }

    public String b() {
        JSONObject jSONObject = this.f17114o;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean c() {
        return this.f17115p;
    }

    public void a(String str, boolean z10) throws JSONException, AdError {
        JSONObject jSONObject = new JSONObject(str);
        a();
        this.f17100a = jSONObject.optInt("rc");
        this.f17101b = jSONObject.optString("id");
        String optString = jSONObject.optString("bid_id");
        this.f17102c = z10 ? d() : optString;
        this.f17103d = jSONObject.optString(DBDefinition.SEGMENT_INFO);
        this.f17104e = jSONObject.optString("cur");
        this.f17115p = z10;
        if (this.f17100a == 70200) {
            this.f17105f = new a();
            JSONObject optJSONObject = jSONObject.optJSONArray(com.sigmob.sdk.base.db.a.f18088a).optJSONObject(0);
            if (optJSONObject != null) {
                if (z10) {
                    optJSONObject = new JSONObject(optJSONObject.toString().replace(optString, this.f17102c));
                }
                this.f17105f.a(optJSONObject);
            }
        }
        if (jSONObject.has("extra_data_toggle")) {
            boolean optBoolean = jSONObject.optBoolean("extra_data_toggle");
            this.f17106g = optBoolean;
            e.a(this.f17112m, "dataToggle", optBoolean);
        }
        if (jSONObject.has("ext")) {
            this.f17107h = jSONObject.optJSONObject("ext");
        }
        if (jSONObject.has("sjc")) {
            this.f17108i = jSONObject.optJSONObject("sjc");
        }
        if (jSONObject.has("nr_time")) {
            e.a(this.f17112m, "KEY_NR_TIME", jSONObject.optInt("nr_time", 720) * 60000);
        }
        if (jSONObject.has("fusing_time")) {
            e.a(this.f17112m, "KEY_FUSE_TIME", jSONObject.optInt("fusing_time", 800));
        }
        if (jSONObject.has("m_material")) {
            this.f17113n = jSONObject.optString("m_material");
        }
        this.f17109j = jSONObject.optJSONObject("ad_opt_info");
        this.f17110k = jSONObject.optJSONArray("x_targets");
        this.f17111l = jSONObject.optString("x_url");
        this.f17114o = jSONObject;
        e.a(this.f17112m, "sessionID", this.f17102c);
    }

    public void a(byte[] bArr, boolean z10) throws AdError {
        try {
            byte[] decodeData = Encoder.decodeData(bArr);
            if (decodeData != null && decodeData.length != 0) {
                String str = new String(decodeData, "utf-8");
                if (z10) {
                    h.a(SDKConstants.TAG, "response -> " + str);
                }
                JSONObject jSONObject = new JSONObject(str);
                a();
                this.f17100a = jSONObject.optInt("rc");
                this.f17101b = jSONObject.optString("id");
                this.f17102c = jSONObject.optString("bid_id");
                this.f17103d = jSONObject.optString(DBDefinition.SEGMENT_INFO);
                this.f17104e = jSONObject.optString("cur");
                if (this.f17100a == 70200) {
                    this.f17105f = new a();
                    this.f17105f.a(jSONObject.optJSONArray(com.sigmob.sdk.base.db.a.f18088a).getJSONObject(0));
                }
                if (jSONObject.has("extra_data_toggle")) {
                    boolean optBoolean = jSONObject.optBoolean("extra_data_toggle");
                    this.f17106g = optBoolean;
                    e.a(this.f17112m, "dataToggle", optBoolean);
                }
                if (jSONObject.has("ext")) {
                    this.f17107h = jSONObject.optJSONObject("ext");
                }
                if (jSONObject.has("sjc")) {
                    this.f17108i = jSONObject.optJSONObject("sjc");
                }
                this.f17109j = jSONObject.optJSONObject("ad_opt_info");
                this.f17110k = jSONObject.optJSONArray("x_targets");
                this.f17111l = jSONObject.optString("x_url");
                this.f17114o = jSONObject;
                e.a(this.f17112m, "sessionID", this.f17102c);
            }
        } catch (Exception unused) {
            h.d(SDKConstants.TAG, "Invalid response data!");
            throw new AdError(ErrorCode.ERROR_SERVER);
        }
    }
}
