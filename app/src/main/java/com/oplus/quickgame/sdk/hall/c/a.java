package com.oplus.quickgame.sdk.hall.c;

import com.oplus.quickgame.sdk.hall.exception.NotContainsKeyException;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends b {
    protected a(Map<String, Object> map) {
        super(map);
    }

    public static a b(Map<String, Object> map) {
        return new a(map);
    }

    public final a a(String str, String str2) {
        Object obj;
        try {
            obj = a(str);
        } catch (NotContainsKeyException e2) {
            e2.printStackTrace();
            obj = null;
        }
        a(str2, obj);
        e(str);
        return this;
    }

    public final a e(String str) {
        this.f16264a.get().remove(str);
        return this;
    }
}
