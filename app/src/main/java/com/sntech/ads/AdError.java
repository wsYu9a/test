package com.sntech.ads;

import androidx.annotation.Keep;
import nh.b;

@Keep
/* loaded from: classes4.dex */
public class AdError {
    public String code;
    public String desc;
    public String platformCode;
    public String platformMSG;

    public AdError(String str, String str2, String str3, String str4) {
        this.code = str;
        this.desc = str2;
        this.platformCode = str3;
        this.platformMSG = str4;
    }

    @Keep
    public String getCode() {
        return this.code;
    }

    @Keep
    public String getDesc() {
        return this.desc;
    }

    @Keep
    public String getPlatformCode() {
        return this.platformCode;
    }

    @Keep
    public String getPlatformMSG() {
        return this.platformMSG;
    }

    public String toString() {
        StringBuilder a10 = b.a("AdError{code='");
        a10.append(this.code);
        a10.append('\'');
        a10.append(", desc='");
        a10.append(this.desc);
        a10.append('\'');
        a10.append(", platformCode='");
        a10.append(this.platformCode);
        a10.append('\'');
        a10.append(", platformMSG='");
        a10.append(this.platformMSG);
        a10.append('\'');
        a10.append('}');
        return a10.toString();
    }
}
