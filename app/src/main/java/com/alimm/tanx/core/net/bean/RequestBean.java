package com.alimm.tanx.core.net.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestBean extends BaseBean {
    private int cacheOfflineTime;
    private int cacheOnlineTime;
    private Map<String, String> heads;
    private String json;
    private boolean onlyOneNet;
    private boolean overrideError;
    private Map<String, String> params;
    private String tag;
    private int tryAgainCount;
    private String url;

    public static class Builder implements NotConfused {
        private String tag;
        private final boolean onlyOneNet = false;
        private final int tryAgainCount = 3;
        private final int cacheOfflineTime = 0;
        private final int cacheOnlineTime = 0;
        private final boolean overrideError = false;
    }

    public RequestBean build() {
        Builder builder = new Builder();
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.onlyOneNet = builder.onlyOneNet;
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.cacheOnlineTime = builder.cacheOnlineTime;
        this.overrideError = builder.overrideError;
        return this;
    }

    public int getCacheOfflineTime() {
        return this.cacheOfflineTime;
    }

    public int getCacheOnlineTime() {
        return this.cacheOnlineTime;
    }

    public Map<String, String> getHeads() {
        return this.heads;
    }

    public String getJson() {
        return this.json;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getTag() {
        return this.tag;
    }

    public int getTryAgainCount() {
        return this.tryAgainCount;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOnlyOneNet() {
        return this.onlyOneNet;
    }

    public boolean isOverrideError() {
        return this.overrideError;
    }

    public RequestBean setCacheOfflineTime(int i10) {
        this.cacheOfflineTime = i10;
        return this;
    }

    public RequestBean setCacheOnlineTime(int i10) {
        this.cacheOnlineTime = i10;
        return this;
    }

    public RequestBean setHeads(Map<String, String> map) {
        this.heads = map;
        return this;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public RequestBean setOnlyOneNet(boolean z10) {
        this.onlyOneNet = z10;
        return this;
    }

    public RequestBean setOverrideError(boolean z10) {
        this.overrideError = z10;
        return this;
    }

    public RequestBean setParams(Map<String, String> map) {
        this.params = map;
        return this;
    }

    public RequestBean setTag(String str) {
        this.tag = str;
        return this;
    }

    public RequestBean setTryAgainCount(int i10) {
        this.tryAgainCount = i10;
        return this;
    }

    public RequestBean setUrl(String str) {
        this.url = str;
        return this;
    }

    public String toString() {
        return "RequestBean{url='" + this.url + "', heads=" + this.heads + ", params=" + this.params + ", tag='" + this.tag + "', cacheOfflineTime=" + this.cacheOfflineTime + ", cacheOnlineTime=" + this.cacheOnlineTime + ", onlyOneNet=" + this.onlyOneNet + ", tryAgainCount=" + this.tryAgainCount + ", overrideError=" + this.overrideError + ", json='" + this.json + "'} ";
    }
}
