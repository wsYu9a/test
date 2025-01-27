package com.kwad.components.ad.splashscreen.local;

import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public Map<Long, Integer> BT;
    public String BU;
    public long gq;

    public a() {
        this.gq = -1L;
        this.BT = new HashMap();
    }

    public a(long j2, long j3, int i2) {
        this.gq = -1L;
        HashMap hashMap = new HashMap();
        this.BT = hashMap;
        this.gq = j2;
        hashMap.put(Long.valueOf(j3), 1);
    }

    public final boolean a(long j2, int i2) {
        return this.BT.get(Long.valueOf(j2)) != null && this.BT.get(Long.valueOf(j2)).intValue() >= i2;
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
}
