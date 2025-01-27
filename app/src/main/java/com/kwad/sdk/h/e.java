package com.kwad.sdk.h;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class e implements com.kwad.sdk.h.b {
    public int aNu;
    public b aNv;
    public a aNw;
    public double arO;

    public static class a implements com.kwad.sdk.h.b {
        public List<String> aNx;
        public List<String> aNy;
        public List<String> aNz;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aNx = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    this.aNx.add(optJSONArray.optString(i10));
                }
            }
            this.aNy = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    this.aNy.add(optJSONArray2.optString(i11));
                }
            }
            this.aNz = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                    this.aNz.add(optJSONArray3.optString(i12));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public static class b implements com.kwad.sdk.h.b {
        public static int OK = 1;
        public static int aNA = -1;
        public static int aNB;
        public List<String> aJr;
        public List<String> aJs;
        public List<String> aNC;
        public int aND = aNA;

        public final boolean KL() {
            return this.aND == OK;
        }

        public final void bG(boolean z10) {
            this.aND = z10 ? OK : aNB;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aJr = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    this.aJr.add(optJSONArray.optString(i10));
                }
            }
            this.aJs = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    this.aJs.add(optJSONArray2.optString(i11));
                }
            }
            this.aNC = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                    this.aNC.add(optJSONArray3.optString(i12));
                }
            }
        }

        @Override // com.kwad.sdk.h.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.arO = jSONObject.optDouble(com.sigmob.sdk.base.k.B);
        this.aNu = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aNv = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aNw = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return null;
    }
}
