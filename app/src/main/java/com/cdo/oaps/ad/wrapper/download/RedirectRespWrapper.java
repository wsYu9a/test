package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.ai;
import java.util.Map;

/* loaded from: classes.dex */
public class RedirectRespWrapper extends ai {
    public static final String KEY_APP_VER_CODE = "";
    public static final String KEY_HIGHTLIGHT = "hlt";
    public static final String KEY_REDIRECT = "rdt";
    public static final String KEY_VERCODE = "vcode";
    public static final String KEY_VERNAME = "vname";

    protected RedirectRespWrapper(Map<String, Object> map) {
        super(map);
    }

    public static RedirectRespWrapper wrapper(Map<String, Object> map) {
        return new RedirectRespWrapper(map);
    }

    public long getAppId() {
        try {
            return getLong(OapsKey.KEY_APP_ID);
        } catch (ag unused) {
            return -1L;
        }
    }

    public String getAppName() {
        try {
            return (String) get("name");
        } catch (ag unused) {
            return "";
        }
    }

    public long getAppSize() {
        try {
            return getLong(OapsKey.KEY_SIZE);
        } catch (ag unused) {
            return -1L;
        }
    }

    public int getHightLight() {
        try {
            return getInt(KEY_HIGHTLIGHT);
        } catch (ag unused) {
            return -1;
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag unused) {
            return "";
        }
    }

    public int getRedirect() {
        try {
            return getInt(KEY_REDIRECT);
        } catch (ag unused) {
            return -1;
        }
    }

    public long getVerId() {
        try {
            return getLong(OapsKey.KEY_VERID);
        } catch (ag unused) {
            return -1L;
        }
    }

    public int getVersionCode() {
        try {
            return getInt(KEY_VERCODE);
        } catch (ag unused) {
            return -1;
        }
    }

    public String getVersionName() {
        try {
            return (String) get(KEY_VERNAME);
        } catch (ag unused) {
            return "";
        }
    }

    public RedirectRespWrapper setAppId(long j2) {
        return (RedirectRespWrapper) set(OapsKey.KEY_APP_ID, Long.valueOf(j2));
    }

    public RedirectRespWrapper setAppName(String str) {
        return (RedirectRespWrapper) set("name", str);
    }

    public RedirectRespWrapper setAppSize(long j2) {
        return (RedirectRespWrapper) set(OapsKey.KEY_SIZE, Long.valueOf(j2));
    }

    public RedirectRespWrapper setHightLight(int i2) {
        return (RedirectRespWrapper) set(KEY_HIGHTLIGHT, Integer.valueOf(i2));
    }

    public RedirectRespWrapper setPkgName(String str) {
        return (RedirectRespWrapper) set("pkg", str);
    }

    public RedirectRespWrapper setRedirect(int i2) {
        return (RedirectRespWrapper) set(KEY_REDIRECT, Integer.valueOf(i2));
    }

    public RedirectRespWrapper setVerId(long j2) {
        return (RedirectRespWrapper) set(OapsKey.KEY_VERID, Long.valueOf(j2));
    }

    public RedirectRespWrapper setVersionCode(int i2) {
        return (RedirectRespWrapper) set(KEY_VERCODE, Integer.valueOf(i2));
    }

    public RedirectRespWrapper setVersionName(String str) {
        return (RedirectRespWrapper) set(KEY_VERNAME, str);
    }
}
