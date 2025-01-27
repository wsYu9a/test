package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class VipLinkParams extends TYBookHttpGetParams {

    @a
    private Boolean isDialog;

    @a
    private Integer method;

    @a
    private Boolean night_mode;

    @a
    private int hideNaviBar = 1;

    @a
    private int notchHeight = 0;

    @a
    private String source = "";

    @a
    private String sourceName = "";

    @a
    private String sourceId = "";

    @a
    private Boolean enableGuest = Boolean.TRUE;

    public boolean getDialog() {
        Boolean bool = this.isDialog;
        return bool != null && bool.booleanValue();
    }

    public boolean getEnableGuest() {
        Boolean bool = this.enableGuest;
        return bool != null && bool.booleanValue();
    }

    public int getHideNaviBar() {
        return this.hideNaviBar;
    }

    public Integer getMethod() {
        return this.method;
    }

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "vip";
    }

    public String getSource() {
        return this.source;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setDialog(Boolean bool) {
        this.isDialog = bool;
    }

    public void setEnableGuest(Boolean bool) {
        this.enableGuest = bool;
    }

    public void setHideNaviBar(int i10) {
        this.hideNaviBar = i10;
    }

    public void setMethod(Integer num) {
        this.method = num;
    }

    public void setNight_mode(Boolean bool) {
        this.night_mode = bool;
    }

    public void setNotchHeight(int i10) {
        this.notchHeight = i10;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
