package com.martian.libugrowth.data;

/* loaded from: classes.dex */
public class UpgradeInfo {
    private String content;
    private Long createdOn;
    private Integer id;
    private String name;
    private Integer versionCode;
    private String versionName;

    public String getContent() {
        return this.content;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
