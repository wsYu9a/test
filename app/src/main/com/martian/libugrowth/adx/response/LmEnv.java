package com.martian.libugrowth.adx.response;

import java.util.Map;

/* loaded from: classes3.dex */
public class LmEnv {
    private Map<String, String> header;
    private String platform;

    /* renamed from: ua, reason: collision with root package name */
    private String f13010ua;

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getUa() {
        return this.f13010ua;
    }

    public void setHeader(Map<String, String> map) {
        this.header = map;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setUa(String str) {
        this.f13010ua = str;
    }
}
