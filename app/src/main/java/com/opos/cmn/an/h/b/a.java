package com.opos.cmn.an.h.b;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static AudioManager f16526a;

    public static AudioManager a(Context context) {
        if (f16526a == null && context != null) {
            f16526a = (AudioManager) context.getApplicationContext().getSystemService("audio");
        }
        return f16526a;
    }

    public static int b(Context context) {
        int i2;
        AudioManager a2;
        try {
            a2 = a(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("AudioMgrTool", "", e2);
        }
        if (a2 != null) {
            i2 = a2.getStreamVolume(3);
            com.opos.cmn.an.f.a.b("AudioMgrTool", "getMusicCurrentVolume=" + i2);
            return i2;
        }
        i2 = 0;
        com.opos.cmn.an.f.a.b("AudioMgrTool", "getMusicCurrentVolume=" + i2);
        return i2;
    }
}
