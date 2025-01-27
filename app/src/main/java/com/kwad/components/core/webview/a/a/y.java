package com.kwad.components.core.webview.a.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class y extends com.kwad.sdk.core.response.kwai.a {
    public String Vp;
    public int errorCode;
    public String errorReason;
    public int nZ;

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.util.g.f5460a, this.Vp);
    }

    public final boolean rg() {
        return TextUtils.equals("start", this.Vp);
    }

    public final boolean rh() {
        return TextUtils.equals("end", this.Vp);
    }

    public final boolean ri() {
        return TextUtils.equals(NotificationCompat.CATEGORY_PROGRESS, this.Vp);
    }

    public final int rj() {
        String str = this.errorReason;
        if (str != null) {
            return (int) Long.parseLong(str);
        }
        return 0;
    }
}
