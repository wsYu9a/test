package com.shu.priory.i;

import android.content.Context;
import com.shu.priory.conn.VideoDataRef;
import com.shu.priory.download.DialogListener;
import com.shu.priory.param.AdParam;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends VideoDataRef {
    public b(Context context, com.shu.priory.g.b bVar, AdParam adParam, DialogListener dialogListener) {
        super(context, bVar, adParam, dialogListener);
    }

    @Override // com.shu.priory.conn.VideoDataRef
    public int getDuration() {
        JSONObject jSONObject;
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || (jSONObject = aVar.f17083j) == null || !jSONObject.has("duration")) {
            return 0;
        }
        return this.mAdData.f17083j.optInt("duration");
    }

    @Override // com.shu.priory.conn.VideoDataRef
    public int getHeight() {
        JSONObject jSONObject;
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || (jSONObject = aVar.f17083j) == null || !jSONObject.has("height")) {
            return 0;
        }
        return this.mAdData.f17083j.optInt("height");
    }

    @Override // com.shu.priory.conn.VideoDataRef
    public int getWidth() {
        JSONObject jSONObject;
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || (jSONObject = aVar.f17083j) == null || !jSONObject.has("width")) {
            return 0;
        }
        return this.mAdData.f17083j.optInt("width");
    }
}
