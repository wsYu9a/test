package com.martian.appwall.response;

/* loaded from: classes3.dex */
public class MartianApp {
    private String downloadUrl;
    private String iconUrl;
    private String name;
    private String packageName;
    private String posterUrl;
    private Integer sizeInMB;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPosterUrl() {
        return this.posterUrl;
    }

    public int getSizeInMB() {
        Integer num = this.sizeInMB;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public void setSizeInMB(Integer num) {
        this.sizeInMB = num;
    }
}
