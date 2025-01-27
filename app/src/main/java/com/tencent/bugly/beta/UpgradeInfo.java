package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0919x;
import com.tencent.bugly.proguard.C0920y;

/* loaded from: classes4.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    public String id;
    public String imageUrl;
    public String newFeature;
    public long popInterval;
    public int popTimes;
    public long publishTime;
    public int publishType;
    public String title;
    public int updateType;
    public int upgradeType;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(B b2) {
        this.id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (b2 != null) {
            this.id = b2.r;
            this.title = b2.f24928f;
            this.newFeature = b2.f24929g;
            this.publishTime = b2.f24930h;
            this.publishType = b2.f24931i;
            this.upgradeType = b2.l;
            this.popTimes = b2.m;
            this.popInterval = b2.n;
            C0920y c0920y = b2.f24932j;
            this.versionCode = c0920y.f25185d;
            this.versionName = c0920y.f25186e;
            this.apkMd5 = c0920y.f25191j;
            C0919x c0919x = b2.k;
            this.apkUrl = c0919x.f25178c;
            this.fileSize = c0919x.f25180e;
            this.imageUrl = b2.q.get("IMG_title");
            this.updateType = b2.u;
        }
    }
}
