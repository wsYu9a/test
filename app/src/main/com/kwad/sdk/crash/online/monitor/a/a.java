package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aLn = new ArrayList();
    public List<String> aLo = new ArrayList();
    public List<String> aLp = new ArrayList();
    public List<String> aLq = new ArrayList();
    public List<b> aLr = new ArrayList();
    public Map<String, b> aLs = new HashMap();
    public int aLt;
    public int aLu;
    public int aLv;
    public double arO;

    public final boolean JJ() {
        return (this.aLv & 4) != 0;
    }

    public final boolean JK() {
        return (this.aLv & 1) != 0;
    }

    public final boolean JL() {
        return (this.aLv & 2) != 0;
    }

    public final boolean JM() {
        return this.aLv == 0;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aLr;
        if (list != null) {
            for (b bVar : list) {
                this.aLs.put(bVar.appId, bVar);
            }
            this.aLr.clear();
        }
    }

    @Nullable
    public final b fQ(String str) {
        if (this.aLs == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.aLs.get(str);
        return bVar == null ? this.aLs.get("000000000") : bVar;
    }
}
