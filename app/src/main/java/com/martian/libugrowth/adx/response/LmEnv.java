package com.martian.libugrowth.adx.response;

import java.util.Map;

/* loaded from: classes3.dex */
public class LmEnv {
    private Map<String, String> header;
    private String platform;
    private String ua;

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getUa() {
        return this.ua;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }
}
