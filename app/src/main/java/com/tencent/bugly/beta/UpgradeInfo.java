package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0878x;
import com.tencent.bugly.proguard.C0879y;

/* loaded from: classes4.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;

    /* renamed from: id */
    public String f22070id;
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

    public UpgradeInfo(B b10) {
        this.f22070id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (b10 != null) {
            this.f22070id = b10.f22570r;
            this.title = b10.f22558f;
            this.newFeature = b10.f22559g;
            this.publishTime = b10.f22560h;
            this.publishType = b10.f22561i;
            this.upgradeType = b10.f22564l;
            this.popTimes = b10.f22565m;
            this.popInterval = b10.f22566n;
            C0879y c0879y = b10.f22562j;
            this.versionCode = c0879y.f22897d;
            this.versionName = c0879y.f22898e;
            this.apkMd5 = c0879y.f22903j;
            C0878x c0878x = b10.f22563k;
            this.apkUrl = c0878x.f22890c;
            this.fileSize = c0878x.f22892e;
            this.imageUrl = b10.f22569q.get("IMG_title");
            this.updateType = b10.f22573u;
        }
    }
}
