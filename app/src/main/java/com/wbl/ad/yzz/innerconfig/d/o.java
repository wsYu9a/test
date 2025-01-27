package com.wbl.ad.yzz.innerconfig.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a */
    public volatile int f32855a = -1;

    /* renamed from: b */
    public final Object f32856b = new Object();

    /* renamed from: c */
    public final String f32857c;

    /* renamed from: d */
    public final String f32858d;

    public o(String str) {
        if (str == null) {
            this.f32857c = "";
        } else {
            this.f32857c = str;
        }
        if (TextUtils.isEmpty(str)) {
            this.f32858d = "key_app_section";
            return;
        }
        this.f32858d = "key_app_section" + this.f32857c;
    }

    public int a(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13309, this, context);
    }

    public int b(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13312, this, context);
    }

    public final int c(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13311, this, context);
    }

    public final int d(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13306, this, context);
    }
}
