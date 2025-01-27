package com.oplus.quickgame.sdk.hall.c;

import com.cdo.oaps.ad.OapsWrapper;
import com.oplus.quickgame.sdk.hall.exception.NotContainsKeyException;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends c {
    protected b(Map<String, Object> map) {
        super(map);
    }

    public static b b(Map<String, Object> map) {
        return new b(map);
    }

    public final b b(String str) {
        return (b) super.a("host", str);
    }

    public final String b() {
        try {
            return (String) a("host");
        } catch (NotContainsKeyException unused) {
            return "";
        }
    }

    public final b c(String str) {
        return (b) super.a(OapsWrapper.KEY_PATH, str);
    }

    public final String c() {
        try {
            return (String) a(OapsWrapper.KEY_PATH);
        } catch (NotContainsKeyException unused) {
            return "";
        }
    }

    public final b d(String str) {
        return (b) super.a("scheme", str);
    }

    public final String d() {
        try {
            return (String) a("scheme");
        } catch (NotContainsKeyException unused) {
            return "";
        }
    }
}
