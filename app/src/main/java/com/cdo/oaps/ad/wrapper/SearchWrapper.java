package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: classes.dex */
public class SearchWrapper extends BaseWrapper {

    /* renamed from: a */
    private String f6578a;

    /* renamed from: c */
    private String f6579c;

    /* renamed from: d */
    private String f6580d;

    /* renamed from: e */
    private String f6581e;

    protected SearchWrapper(Map<String, Object> map) {
        super(map);
        this.f6578a = "sfl";
        this.f6579c = "shi";
        this.f6580d = "sfr";
        this.f6581e = "sfi";
    }

    public static SearchWrapper wrapper(Map<String, Object> map) {
        return new SearchWrapper(map);
    }

    public boolean getAutoDown() {
        try {
            return getBoolean("ad");
        } catch (ag unused) {
            return false;
        }
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
        } catch (ag unused) {
            return "";
        }
    }

    public String getKeyword() {
        try {
            return (String) get(OapsKey.KEY_KEYWORD);
        } catch (ag unused) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFlag() {
        try {
            return (String) get(this.f6578a);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFrom() {
        try {
            return (String) get(this.f6580d);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFromId() {
        try {
            return (String) get(this.f6581e);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchHint() {
        try {
            return (String) get(this.f6579c);
        } catch (ag unused) {
            return "";
        }
    }

    public String getTraceId() {
        try {
            return (String) get("traceId");
        } catch (ag unused) {
            return "";
        }
    }

    public SearchWrapper setAutoDown(boolean z) {
        return (SearchWrapper) set("ad", Boolean.valueOf(z));
    }

    public SearchWrapper setChannelPkg(String str) {
        return (SearchWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public SearchWrapper setKeyword(String str) {
        return (SearchWrapper) set(OapsKey.KEY_KEYWORD, str);
    }

    public SearchWrapper setPkgName(String str) {
        return (SearchWrapper) set("pkg", str);
    }

    public SearchWrapper setSearchFlag(String str) {
        return (SearchWrapper) set(this.f6578a, str);
    }

    public SearchWrapper setSearchFrom(String str) {
        return (SearchWrapper) set(this.f6580d, str);
    }

    public SearchWrapper setSearchFromId(String str) {
        return (SearchWrapper) set(this.f6581e, str);
    }

    public SearchWrapper setSearchHint(String str) {
        return (SearchWrapper) set(this.f6579c, str);
    }

    public ResourceWrapper setTraceId(String str) {
        return (ResourceWrapper) set("traceId", str);
    }
}
