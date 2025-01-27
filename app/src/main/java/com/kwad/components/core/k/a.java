package com.kwad.components.core.k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Os = new SimpleDateFormat("yyyy-MM-dd");
    public int Ot;
    public long Ou;

    public final boolean j(int i10, int i11) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i10 + ", forceActiveThreshold: " + i11);
        if (this.Ou <= 0) {
            px();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = Os.format(new Date(this.Ou));
        String format2 = Os.format(new Date(currentTimeMillis));
        c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.Ot = 0;
            px();
            return true;
        }
        long j10 = this.Ou + (i10 * 3600000);
        c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j10 + ", currentActiveCount: " + this.Ot);
        if (j10 >= currentTimeMillis || this.Ot > i11) {
            return false;
        }
        px();
        return true;
    }

    public final void px() {
        this.Ou = System.currentTimeMillis();
        this.Ot++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Ou + ", currentActiveCount " + this.Ot);
    }
}
