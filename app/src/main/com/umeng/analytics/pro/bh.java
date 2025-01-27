package com.umeng.analytics.pro;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class bh {
    @SuppressLint({"SuspiciousIndentation"})
    public static be a() {
        String str = Build.BRAND;
        bs.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (br.d()) {
            return new bi();
        }
        if (br.e()) {
            return new bj();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new bq();
        }
        if (str.equalsIgnoreCase(ke.e.f27807e)) {
            return new bp();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase(ke.e.f27809g)) {
            return new bn();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new bk();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new bm();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new bo();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu") || br.a()) {
            return new bl();
        }
        if (br.f()) {
            return new bg();
        }
        return null;
    }
}
