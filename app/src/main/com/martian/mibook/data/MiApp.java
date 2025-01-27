package com.martian.mibook.data;

import android.text.TextUtils;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class MiApp {
    public String appSizeInMB;
    public List<String> bannerUrls;
    public String baseUrl;
    public String desc;
    public List<String> descImageUrls;
    public List<String> downloadImageUrls;
    public String downloadPattern;
    public String downloadUrl;
    public String homepageUrl;
    public String iconUrl;
    public boolean isInstalled = false;
    public String name;
    public String packageName;
    public String shortDesc;
    public int taskCoins;
    public String taskDesc;

    public String getRandomDownloadImageUrl() {
        return this.downloadImageUrls.get(new Random().nextInt(this.downloadImageUrls.size()));
    }

    public boolean isDownloadImageUrlsValid() {
        List<String> list = this.downloadImageUrls;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isDownloadUrlValid() {
        return !TextUtils.isEmpty(this.downloadUrl);
    }
}
