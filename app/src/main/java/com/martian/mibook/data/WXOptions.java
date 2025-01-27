package com.martian.mibook.data;

import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes3.dex */
public class WXOptions {
    public boolean forceShare = true;
    public int vipCoins = 30;
    public boolean enableApps7 = false;
    public final boolean enableXiaoziSdk = true;
    public boolean enableWeixinPay = true;
    public boolean enableVIP2 = false;
    public boolean enableTuiaShare = true;
    public boolean allTuiaShare = true;
    public String shareLink = "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook";
    public final String miShareLink = "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook";
    public String qihuDownloadUrl = "http://shouji.360.cn/360safe/101000386/360MobileSafe.apk";
    public String alipayDownloadUrl = "http://openbox.mobilem.360.cn/index/d/sid/1939";
    public String wxRedpaperKey = "[微信红包]";
    public String qqRedpaperKey = "[QQ红包]";
    public String momoRedpaperNotificationKey = "";
    public String gdtAppId = "1104916951";
    public String gdtSplashId = "1000807711658918";
    public String gdtInterteristalId = "4010209781655969";
    public boolean enableInviteLink = true;
    public String phoneInviteDomain = "fhbtt.com";
    public String withdrawWxAppid = "wx77ca111229d15864";

    public boolean getEnableXiaoziSdk() {
        return true;
    }

    public String getShareLink() {
        if (!MiConfigSingleton.V3().M4.k()) {
            return "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook";
        }
        return "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook&uid=" + MiConfigSingleton.V3().M4.h().getUid();
    }
}
