package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class VipLinkParams extends TYBookHttpGetParams {

    @a
    private Boolean isDialog;

    @a
    private Integer method;

    @a
    private Boolean night_mode;

    @a
    private final int hideNaviBar = 1;

    @a
    private int notchHeight = 0;

    @a
    private String source = "";

    @a
    private String sourceName = "";

    @a
    private String sourceId = "";

    public boolean getDialog() {
        Boolean bool = this.isDialog;
        return bool != null && bool.booleanValue();
    }

    public Integer getMethod() {
        return this.method;
    }

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    @Override // com.martian.libcomm.http.requests.b
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

    public void setDialog(Boolean dialog) {
        this.isDialog = dialog;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public void setNight_mode(Boolean night_mode) {
        this.night_mode = night_mode;
    }

    public void setNotchHeight(int notchHeight) {
        this.notchHeight = notchHeight;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
