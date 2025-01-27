package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: classes4.dex */
public class bk implements be {

    /* renamed from: a */
    private static final int f23571a = 1;

    /* renamed from: b */
    private OpenDeviceId f23572b;

    /* renamed from: c */
    private boolean f23573c = false;

    /* renamed from: d */
    private boolean f23574d = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f23573c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.f23572b = openDeviceId;
            this.f23574d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f23573c = true;
        }
        bs.a("getOAID", "isSupported", Boolean.valueOf(this.f23574d));
        if (this.f23574d && this.f23572b.c()) {
            return this.f23572b.a();
        }
        return null;
    }
}
