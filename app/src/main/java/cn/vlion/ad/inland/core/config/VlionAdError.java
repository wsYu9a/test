package cn.vlion.ad.inland.core.config;

import android.text.TextUtils;
import cn.vlion.ad.inland.core.f;

/* loaded from: classes.dex */
public class VlionAdError {
    public String code;
    public String desc;
    public String itemsErrorInfo;
    public String platformCode;
    public String platformMSG;

    public VlionAdError(int i10, String str) {
        this.code = String.valueOf(i10);
        this.desc = str;
        this.platformCode = "";
        this.platformMSG = "";
        this.itemsErrorInfo = "";
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFullErrorInfo() {
        if (!TextUtils.isEmpty(this.itemsErrorInfo)) {
            StringBuilder a10 = f.a("\ncode[ ");
            a10.append(this.code);
            a10.append(" ]\ndesc[ ");
            a10.append(this.desc);
            a10.append(" ]\ndetail[ ");
            a10.append(this.itemsErrorInfo);
            a10.append(" \n]");
            return a10.toString();
        }
        StringBuilder a11 = f.a("code:[ ");
        a11.append(this.code);
        a11.append(" ]desc:[ ");
        a11.append(this.desc);
        a11.append(" ]platformCode:[ ");
        a11.append(this.platformCode);
        a11.append(" ]platformMSG:[ ");
        a11.append(this.platformMSG);
        a11.append(" ]");
        return a11.toString();
    }

    public String getPlatformCode() {
        return this.platformCode;
    }

    public String getPlatformMSG() {
        return this.platformMSG;
    }

    public String printStackTrace() {
        StringBuilder a10 = f.a("code:[ ");
        a10.append(this.code);
        a10.append(" ]desc:[ ");
        a10.append(this.desc);
        a10.append(" ]platformCode:[ ");
        a10.append(this.platformCode);
        a10.append(" ]platformMSG:[ ");
        a10.append(this.platformMSG);
        a10.append(" ]");
        return a10.toString();
    }

    public String toString() {
        return printStackTrace();
    }

    public VlionAdError(int i10, String str, String str2, String str3) {
        this.code = String.valueOf(i10);
        this.desc = str;
        this.platformCode = str2;
        this.platformMSG = str3;
        this.itemsErrorInfo = "";
    }
}
