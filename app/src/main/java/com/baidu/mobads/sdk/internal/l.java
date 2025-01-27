package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public enum l {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);


    /* renamed from: j, reason: collision with root package name */
    String f7221j;

    /* renamed from: k, reason: collision with root package name */
    int f7222k;

    l(String str, int i10) {
        this.f7221j = str;
        this.f7222k = i10;
    }

    public String b() {
        return this.f7221j;
    }

    public int c() {
        return this.f7222k;
    }

    public static l b(String str) {
        for (l lVar : values()) {
            if (lVar != null && TextUtils.isEmpty(lVar.f7221j) && lVar.f7221j.equals(str)) {
                return lVar;
            }
        }
        return null;
    }
}
