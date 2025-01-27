package com.kwad.sdk.crash.online.monitor.kwai;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public double aii;
    public List<String> ase = new ArrayList();
    public List<String> asf = new ArrayList();
    public List<String> asg = new ArrayList();
    public List<String> ash = new ArrayList();
    public List<b> asi = new ArrayList();
    public Map<String, b> asj = new HashMap();
    public int ask;
    public int asl;
    public int asm;

    public final boolean Aa() {
        return (this.asm & 2) != 0;
    }

    public final boolean Ab() {
        return this.asm == 0;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.asi;
        if (list != null) {
            for (b bVar : list) {
                this.asj.put(bVar.appId, bVar);
            }
            this.asi.clear();
        }
    }

    @Nullable
    public final b dP(String str) {
        if (this.asj == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.asj.get(str);
        return bVar == null ? this.asj.get("000000000") : bVar;
    }

    public final boolean zY() {
        return (this.asm & 4) != 0;
    }

    public final boolean zZ() {
        return (this.asm & 1) != 0;
    }
}
