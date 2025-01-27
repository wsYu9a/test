package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: classes.dex */
public class ResourceWrapper extends IDWrapper {
    protected ResourceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static ResourceWrapper wrapper(Map<String, Object> map) {
        return new ResourceWrapper(map);
    }

    public String getAdContent() {
        try {
            return (String) get(OapsKey.KEY_ADCONTENT);
        } catch (ag unused) {
            return "";
        }
    }

    public int getAdId() {
        try {
            return getInt(OapsKey.KEY_ADID);
        } catch (ag unused) {
            return -1;
        }
    }

    public String getAdPos() {
        try {
            return (String) get(OapsKey.KEY_ADPOS);
        } catch (ag unused) {
            return "";
        }
    }

    public boolean getAutoDown() {
        try {
            return getBoolean(OapsKey.KEY_AUTO_DOWN);
        } catch (ag unused) {
            return false;
        }
    }

    public String getCaller() {
        try {
            return (String) get(OapsKey.KEY_CALLER);
        } catch (ag unused) {
            return "";
        }
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
        } catch (ag unused) {
            return "";
        }
    }

    public String getDlDesc() {
        try {
            return (String) get(OapsKey.KEY_DL_DESC);
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

    public String getReference() {
        try {
            return (String) get(OapsKey.KEY_REF);
        } catch (ag unused) {
            return "";
        }
    }

    public String getStyle() {
        try {
            return (String) get(OapsKey.KEY_STYLE);
        } catch (ag unused) {
            return "";
        }
    }

    public String getToken() {
        try {
            return (String) get(OapsKey.KEY_TOKEN);
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

    public ResourceWrapper setAdContent(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_ADCONTENT, str);
    }

    public ResourceWrapper setAdId(int i2) {
        return (ResourceWrapper) set(OapsKey.KEY_ADID, Integer.valueOf(i2));
    }

    public ResourceWrapper setAdPos(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_ADPOS, str);
    }

    public ResourceWrapper setAutoDown(boolean z) {
        return (ResourceWrapper) set(OapsKey.KEY_AUTO_DOWN, Boolean.valueOf(z));
    }

    public ResourceWrapper setCaller(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_CALLER, str);
    }

    public ResourceWrapper setChannelPkg(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public ResourceWrapper setDlDesc(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_DL_DESC, str);
    }

    public ResourceWrapper setPkgName(String str) {
        return (ResourceWrapper) set("pkg", str);
    }

    public ResourceWrapper setReference(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_REF, str);
    }

    public ResourceWrapper setStyle(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_STYLE, str);
    }

    public ResourceWrapper setToken(String str) {
        return (ResourceWrapper) set(OapsKey.KEY_TOKEN, str);
    }

    public ResourceWrapper setTraceId(String str) {
        return (ResourceWrapper) set("traceId", str);
    }
}
