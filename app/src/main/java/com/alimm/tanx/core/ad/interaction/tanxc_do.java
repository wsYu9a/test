package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class tanxc_do {
    private AdClickHandler tanxc_do;
    private Map<String, String> tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.interaction.tanxc_do$tanxc_do */
    public static class C0211tanxc_do {
        private static final tanxc_do tanxc_do = new tanxc_do((byte) 0);
    }

    public /* synthetic */ tanxc_do(byte b10) {
        this();
    }

    public static tanxc_do tanxc_do() {
        return C0211tanxc_do.tanxc_do;
    }

    private tanxc_do() {
        this.tanxc_if = new ConcurrentHashMap(16);
        this.tanxc_do = new AdClickHandler();
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z10) {
        tanxc_do(context, adClickInfo, false, z10);
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z10, boolean z11) {
        this.tanxc_if.clear();
        this.tanxc_do.handleClickAndUt(context, adClickInfo, z10, z11);
    }

    public void tanxc_do(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.tanxc_if.put(str, str2);
    }

    public String tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.tanxc_if.remove(str);
        return str;
    }
}
