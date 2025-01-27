package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ap {

    /* renamed from: a */
    private static final String f5531a = w.p;

    /* renamed from: b */
    private static final String f5532b = "pauseDlByPk";

    /* renamed from: c */
    private static final String f5533c = "resumeDownload";

    /* renamed from: d */
    private static final String f5534d = "getDownloadStatus";

    /* renamed from: f */
    private static ap f5535f;

    /* renamed from: e */
    private aq f5536e;

    private ap(Context context) {
        this.f5536e = aq.a(context, f5531a);
    }

    public static ap a(Context context) {
        if (f5535f == null) {
            synchronized (ap.class) {
                if (f5535f == null) {
                    f5535f = new ap(context);
                }
            }
        }
        return f5535f;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5536e.a(null, f5532b, str);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b2 = this.f5536e.b(null, f5533c, context, jSONObject, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (br.a(context, str)) {
            return 103;
        }
        Object b2 = this.f5536e.b(null, f5534d, str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }
}
