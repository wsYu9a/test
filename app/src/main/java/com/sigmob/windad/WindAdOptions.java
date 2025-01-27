package com.sigmob.windad;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class WindAdOptions {

    /* renamed from: a */
    public String f20866a;

    /* renamed from: b */
    public String f20867b;

    /* renamed from: c */
    public HashMap<String, String> f20868c;

    /* renamed from: d */
    public WindCustomController f20869d;

    public WindAdOptions(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f20866a = str.trim();
        }
        this.f20867b = str2;
    }

    public String getAppId() {
        return this.f20866a;
    }

    public String getAppKey() {
        return this.f20867b;
    }

    public WindCustomController getCustomController() {
        return this.f20869d;
    }

    public HashMap<String, String> getExtData() {
        return this.f20868c;
    }

    public WindAdOptions setCustomController(WindCustomController windCustomController) {
        this.f20869d = windCustomController;
        return this;
    }

    public WindAdOptions setExtData(HashMap<String, String> hashMap) {
        this.f20868c = hashMap;
        return this;
    }
}
