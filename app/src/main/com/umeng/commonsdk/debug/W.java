package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: classes4.dex */
public class W implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.w(str, str2);
    }
}
