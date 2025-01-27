package com.martian.appwall.response;

/* loaded from: classes2.dex */
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

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setSizeInMB(Integer sizeInMB) {
        this.sizeInMB = sizeInMB;
    }
}
