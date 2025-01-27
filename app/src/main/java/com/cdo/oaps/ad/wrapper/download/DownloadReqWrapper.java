package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class DownloadReqWrapper extends ResourceWrapper {
    public static final int TYPE_CANCEL = 3;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_PAUSE = 2;
    public static final int TYPE_QUERY = 4;
    public static final int TYPE_REGISTER_OBSERVER = 5;
    public static final int TYPE_RESERVE = 7;
    public static final int TYPE_UNREGISTER_OBSERVER = 6;

    /* renamed from: a */
    private static final String f6585a = "dtp";

    /* renamed from: c */
    private static final String f6586c = "dsp";

    /* renamed from: d */
    private static final String f6587d = "dada";

    /* renamed from: e */
    private static final String f6588e = "dmc";

    protected DownloadReqWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadReqWrapper wrapper(Map<String, Object> map) {
        return new DownloadReqWrapper(map);
    }

    public boolean getAutoDelApk() {
        try {
            return 1 == getInt(f6587d);
        } catch (ag unused) {
            return true;
        }
    }

    public int getDownloadMaxCount() {
        try {
            return getInt(f6588e);
        } catch (ag unused) {
            return 2;
        }
    }

    public int getDownloadType() {
        try {
            return getInt(f6585a);
        } catch (ag unused) {
            return -1;
        }
    }

    public String getSaveDir() {
        try {
            return (String) get(f6586c);
        } catch (ag unused) {
            return "";
        }
    }

    public DownloadReqWrapper setAutoDelApk(boolean z) {
        return (DownloadReqWrapper) set(f6587d, Integer.valueOf(z ? 1 : 0));
    }

    public DownloadReqWrapper setDownloadMaxCount(int i2) {
        return (DownloadReqWrapper) set(f6588e, Integer.valueOf(i2));
    }

    public DownloadReqWrapper setDownloadType(int i2) {
        return (DownloadReqWrapper) set(f6585a, Integer.valueOf(i2));
    }

    public DownloadReqWrapper setSaveDir(String str) {
        return (DownloadReqWrapper) set(f6586c, str);
    }
}
