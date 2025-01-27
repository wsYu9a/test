package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat hX = new SimpleDateFormat("yyyy-MM-dd");
    public long hY;
    public int hZ;

    public b() {
        this.hY = -1L;
        this.hZ = -1;
    }

    public final boolean f(long j10) {
        if (this.hY > 0 && j10 > 0) {
            try {
                return hX.format(new Date(this.hY)).equals(hX.format(new Date(j10)));
            } catch (Exception e10) {
                c.printStackTraceOnly(e10);
            }
        }
        return false;
    }

    public final boolean w(int i10) {
        int i11 = this.hZ;
        return i11 > 0 && i11 >= i10;
    }

    public b(long j10, int i10) {
        this.hY = j10;
        this.hZ = 1;
    }
}
