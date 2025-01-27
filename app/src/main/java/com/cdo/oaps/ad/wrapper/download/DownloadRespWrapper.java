package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.ai;
import java.util.Map;

/* loaded from: classes.dex */
public class DownloadRespWrapper extends ai {

    /* renamed from: a */
    private static final String f6589a = "dl_st";

    /* renamed from: c */
    private static final String f6590c = "dl_tlen";

    /* renamed from: d */
    private static final String f6591d = "dl_perc";

    /* renamed from: e */
    private static final String f6592e = "dl_sp";

    /* renamed from: f */
    private static final String f6593f = "dl_error_code";

    protected DownloadRespWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadRespWrapper wrapper(Map<String, Object> map) {
        return new DownloadRespWrapper(map);
    }

    public int getErrorCode() {
        try {
            return getInt(f6593f);
        } catch (ag unused) {
            return -1;
        }
    }

    public float getPercent() {
        try {
            return getFloat(f6591d);
        } catch (ag unused) {
            return -1.0f;
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag unused) {
            return "";
        }
    }

    public long getSpeed() {
        try {
            return getLong(f6592e);
        } catch (ag unused) {
            return -1L;
        }
    }

    public int getStatus() {
        try {
            return getInt(f6589a);
        } catch (ag unused) {
            return -1;
        }
    }

    public long getTotalLength() {
        try {
            return getLong(f6590c);
        } catch (ag unused) {
            return -1L;
        }
    }

    public DownloadRespWrapper setErrorCode(int i2) {
        return (DownloadRespWrapper) set(f6593f, Integer.valueOf(i2));
    }

    public DownloadRespWrapper setPercent(float f2) {
        return (DownloadRespWrapper) set(f6591d, Float.valueOf(f2));
    }

    public DownloadRespWrapper setPkgName(String str) {
        return (DownloadRespWrapper) set("pkg", str);
    }

    public DownloadRespWrapper setSpeed(long j2) {
        return (DownloadRespWrapper) set(f6592e, Long.valueOf(j2));
    }

    public DownloadRespWrapper setStatus(int i2) {
        return (DownloadRespWrapper) set(f6589a, Integer.valueOf(i2));
    }

    public DownloadRespWrapper setTotalLength(long j2) {
        return (DownloadRespWrapper) set(f6590c, Long.valueOf(j2));
    }
}
