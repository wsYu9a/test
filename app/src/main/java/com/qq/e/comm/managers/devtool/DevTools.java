package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class DevTools {

    /* renamed from: a */
    private String f24017a;

    public String getDemoGameUrl() {
        String str = this.f24017a;
        this.f24017a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f24017a = str;
        }
    }
}
