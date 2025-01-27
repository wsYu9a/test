package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    private final String f8443a;

    /* renamed from: b */
    private final byte[] f8444b;

    /* renamed from: c */
    private final int f8445c;

    /* renamed from: d */
    private l[] f8446d;

    /* renamed from: e */
    private final BarcodeFormat f8447e;

    /* renamed from: f */
    private Map<ResultMetadataType, Object> f8448f;

    /* renamed from: g */
    private final long f8449g;

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, lVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(l[] lVarArr) {
        l[] lVarArr2 = this.f8446d;
        if (lVarArr2 == null) {
            this.f8446d = lVarArr;
            return;
        }
        if (lVarArr == null || lVarArr.length <= 0) {
            return;
        }
        l[] lVarArr3 = new l[lVarArr2.length + lVarArr.length];
        System.arraycopy(lVarArr2, 0, lVarArr3, 0, lVarArr2.length);
        System.arraycopy(lVarArr, 0, lVarArr3, lVarArr2.length, lVarArr.length);
        this.f8446d = lVarArr3;
    }

    public BarcodeFormat b() {
        return this.f8447e;
    }

    public int c() {
        return this.f8445c;
    }

    public byte[] d() {
        return this.f8444b;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.f8448f;
    }

    public l[] f() {
        return this.f8446d;
    }

    public String g() {
        return this.f8443a;
    }

    public long h() {
        return this.f8449g;
    }

    public void i(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f8448f;
            if (map2 == null) {
                this.f8448f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f8448f == null) {
            this.f8448f = new EnumMap(ResultMetadataType.class);
        }
        this.f8448f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f8443a;
    }

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, lVarArr, barcodeFormat, j2);
    }

    public k(String str, byte[] bArr, int i2, l[] lVarArr, BarcodeFormat barcodeFormat, long j2) {
        this.f8443a = str;
        this.f8444b = bArr;
        this.f8445c = i2;
        this.f8446d = lVarArr;
        this.f8447e = barcodeFormat;
        this.f8448f = null;
        this.f8449g = j2;
    }
}
