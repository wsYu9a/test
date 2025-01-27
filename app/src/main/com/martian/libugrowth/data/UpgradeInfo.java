package com.martian.libugrowth.data;

/* loaded from: classes3.dex */
public class UpgradeInfo {
    private String content;
    private Long createdOn;
    private Boolean force;

    /* renamed from: id, reason: collision with root package name */
    private Integer f13013id;
    private boolean manual;
    private String name;
    private Integer versionCode;
    private String versionName;

    public boolean forceUpgrade() {
        return !isManual() && isForce();
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public Integer getId() {
        return this.f13013id;
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

    public boolean isForce() {
        Boolean bool = this.force;
        return bool != null && bool.booleanValue();
    }

    public boolean isManual() {
        return this.manual;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setForce(boolean z10) {
        this.force = Boolean.valueOf(z10);
    }

    public void setId(Integer num) {
        this.f13013id = num;
    }

    public void setManual(boolean z10) {
        this.manual = z10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVersionCode(Integer num) {
        this.versionCode = num;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
