package com.kwad.components.ad.reward.l;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {

    /* renamed from: zf */
    private boolean f11726zf = false;

    /* renamed from: zg */
    protected String f11727zg;

    /* renamed from: zh */
    protected String f11728zh;

    private boolean jR() {
        return this.f11726zf;
    }

    private void jS() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.f11726zf));
    }

    public boolean isCompleted() {
        return jR();
    }

    public final void jN() {
        if (this.f11726zf) {
            return;
        }
        this.f11726zf = true;
        jS();
    }

    public final void jO() {
        if (this.f11726zf) {
            this.f11726zf = false;
            jS();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jP() {
        return this.f11727zg;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jQ() {
        return this.f11728zh;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f11726zf = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "selfCompleted", this.f11726zf);
        return jSONObject;
    }
}
