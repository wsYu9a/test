package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: classes.dex */
public class SqlWrapper extends BaseWrapper {
    public static final String KEY_DATA = "bkd";

    /* renamed from: a */
    private static final String f6582a = "bkd_md5";

    /* renamed from: c */
    private static final String f6583c = "sql_rs";

    protected SqlWrapper(Map<String, Object> map) {
        super(map);
    }

    public static SqlWrapper wrapper(Map<String, Object> map) {
        return new SqlWrapper(map);
    }

    public byte[] getData() {
        try {
            return (byte[]) get(KEY_DATA);
        } catch (ag unused) {
            return null;
        }
    }

    public String getDataMd5() {
        try {
            return (String) get(f6582a);
        } catch (ag unused) {
            return "";
        }
    }

    public String getResult() {
        try {
            return (String) get(f6583c);
        } catch (ag unused) {
            return "";
        }
    }

    public SqlWrapper setData(byte[] bArr) {
        return (SqlWrapper) set(KEY_DATA, bArr);
    }

    public SqlWrapper setDataMd5(String str) {
        return (SqlWrapper) set(f6582a, str);
    }

    public SqlWrapper setResult(String str) {
        return (SqlWrapper) set(f6583c, str);
    }
}
