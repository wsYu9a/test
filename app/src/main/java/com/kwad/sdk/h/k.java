package com.kwad.sdk.h;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class k implements b {
    public JSONObject aNU = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject KN = h.KR().KV().KN();
        Iterator<String> keys = KN.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c.a(KN, next, KN.opt(next));
        }
        c.putValue(this.aNU, "customKey", str);
        c.putValue(this.aNU, "customValue", str2);
        c.putValue(this.aNU, o3.a.f29032k, iVar.aNR);
        c.putValue(this.aNU, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return this.aNU;
    }

    @NonNull
    public final String toString() {
        return this.aNU.toString();
    }
}
