package com.kwad.components.ad.fullscreen.a;

import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq;
    public int gr;

    public b() {
        this.gq = -1L;
        this.gr = -1;
    }

    public b(long j2, int i2) {
        this.gq = -1L;
        this.gr = -1;
        this.gq = j2;
        this.gr = 1;
    }

    public final boolean e(long j2) {
        if (this.gq > 0 && j2 > 0) {
            try {
                return gp.format(new Date(this.gq)).equals(gp.format(new Date(j2)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public final boolean z(int i2) {
        int i3 = this.gr;
        return i3 > 0 && i3 >= i2;
    }
}
