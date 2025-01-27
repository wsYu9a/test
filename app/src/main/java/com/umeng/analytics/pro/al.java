package com.umeng.analytics.pro;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class al {

    /* renamed from: a */
    private String f23405a;

    /* renamed from: e */
    private boolean f23409e = false;

    /* renamed from: d */
    private int f23408d = -1;

    /* renamed from: c */
    private int f23407c = -1;

    /* renamed from: b */
    private int f23406b = -1;

    public al(String str) {
        this.f23405a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f23405a.contains("-")) {
                this.f23408d = Integer.valueOf(this.f23405a).intValue();
                this.f23409e = false;
                return;
            }
            String[] split = this.f23405a.split("-");
            if (split.length == 2) {
                this.f23406b = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                this.f23407c = intValue;
                if (this.f23406b < 1) {
                    this.f23406b = 1;
                }
                if (intValue > 24) {
                    this.f23407c = 24;
                }
            }
            this.f23409e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i10) {
        int i11;
        if (this.f23409e) {
            int i12 = this.f23406b;
            if (i12 != -1 && (i11 = this.f23407c) != -1 && i10 >= i12 && i10 <= i11) {
                return true;
            }
        } else {
            int i13 = this.f23408d;
            if (i13 != -1 && i10 == i13) {
                return true;
            }
        }
        return false;
    }
}
