package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* loaded from: classes4.dex */
public class ae implements z {

    /* renamed from: a */
    private static final int f25640a = 1;

    /* renamed from: b */
    private OpenDeviceId f25641b;

    /* renamed from: c */
    private boolean f25642c = false;

    /* renamed from: d */
    private boolean f25643d = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f25642c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.f25641b = openDeviceId;
            this.f25643d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f25642c = true;
        }
        al.a("getOAID", "isSupported", Boolean.valueOf(this.f25643d));
        if (this.f25643d && this.f25641b.c()) {
            return this.f25641b.a();
        }
        return null;
    }
}
