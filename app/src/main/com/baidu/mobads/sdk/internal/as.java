package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class as {

    /* renamed from: a */
    private static final String f6780a = z.f7387o;

    /* renamed from: b */
    private static final String f6781b = "pauseDlByPk";

    /* renamed from: c */
    private static final String f6782c = "cancelDlByPk";

    /* renamed from: d */
    private static final String f6783d = "resumeDownload";

    /* renamed from: e */
    private static final String f6784e = "getDownloadStatus";

    /* renamed from: g */
    private static as f6785g;

    /* renamed from: f */
    private at f6786f;

    private as(Context context) {
        this.f6786f = at.a(context, f6780a);
    }

    public static as a(Context context) {
        if (f6785g == null) {
            synchronized (as.class) {
                try {
                    if (f6785g == null) {
                        f6785g = new as(context);
                    }
                } finally {
                }
            }
        }
        return f6785g;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6786f.a(null, f6782c, str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6786f.a(null, f6781b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b10 = this.f6786f.b(null, f6783d, context, jSONObject, str, str2);
            if (b10 instanceof Boolean) {
                return ((Boolean) b10).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bu.a(context, str)) {
            return 103;
        }
        Object b10 = this.f6786f.b(null, f6784e, str);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return -1;
    }
}
