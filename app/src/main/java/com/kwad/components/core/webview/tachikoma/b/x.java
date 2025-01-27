package com.kwad.components.core.webview.tachikoma.b;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.sigmob.sdk.base.mta.PointCategory;

@KsJson
/* loaded from: classes3.dex */
public class x extends com.kwad.sdk.core.response.a.a {
    public String adB;
    public int errorCode;
    public String errorReason;
    public int oZ;

    public final boolean isFailed() {
        return TextUtils.equals(p3.e.f29726i, this.adB);
    }

    public final boolean tY() {
        return TextUtils.equals("start", this.adB);
    }

    public final boolean tZ() {
        return TextUtils.equals(PointCategory.END, this.adB);
    }

    public final boolean ua() {
        return TextUtils.equals("progress", this.adB);
    }

    public final int ub() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return 0;
        }
    }
}
