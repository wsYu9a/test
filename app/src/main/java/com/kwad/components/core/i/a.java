package com.kwad.components.core.i;

import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat JQ = new SimpleDateFormat("yyyy-MM-dd");
    public int JR;
    public long JS;

    public final boolean h(int i2, int i3) {
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i2 + ", forceActiveThreshold: " + i3);
        if (this.JS <= 0) {
            nE();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = JQ.format(new Date(this.JS));
        String format2 = JQ.format(new Date(currentTimeMillis));
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.JR = 0;
            nE();
            return true;
        }
        long j2 = this.JS + (i2 * 60 * 60 * 1000);
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j2 + ", currentActiveCount: " + this.JR);
        if (j2 >= currentTimeMillis || this.JR > i3) {
            return false;
        }
        nE();
        return true;
    }

    public final void nE() {
        this.JS = System.currentTimeMillis();
        this.JR++;
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.JS + ", currentActiveCount " + this.JR);
    }
}
