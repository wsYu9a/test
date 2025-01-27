package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import com.oplus.quickgame.sdk.hall.Constant;

/* loaded from: classes.dex */
public enum i {
    NEWS("news", 0),
    IMAGE(MiConfigSingleton.u0, 1),
    VIDEO("video", 2),
    TOPIC(Constant.Param.TOPIC, 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);


    /* renamed from: j, reason: collision with root package name */
    String f5827j;
    int k;

    i(String str, int i2) {
        this.f5827j = str;
        this.k = i2;
    }

    public String b() {
        return this.f5827j;
    }

    public int c() {
        return this.k;
    }

    public static i b(String str) {
        for (i iVar : values()) {
            if (iVar != null && TextUtils.isEmpty(iVar.f5827j) && iVar.f5827j.equals(str)) {
                return iVar;
            }
        }
        return null;
    }
}
