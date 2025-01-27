package t5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a */
    public final String f30720a;

    /* renamed from: b */
    public final byte[] f30721b;

    /* renamed from: c */
    public final int f30722c;

    /* renamed from: d */
    public l[] f30723d;

    /* renamed from: e */
    public final BarcodeFormat f30724e;

    /* renamed from: f */
    public Map<ResultMetadataType, Object> f30725f;

    /* renamed from: g */
    public final long f30726g;

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, lVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(l[] lVarArr) {
        l[] lVarArr2 = this.f30723d;
        if (lVarArr2 == null) {
            this.f30723d = lVarArr;
            return;
        }
        if (lVarArr == null || lVarArr.length <= 0) {
            return;
        }
        l[] lVarArr3 = new l[lVarArr2.length + lVarArr.length];
        System.arraycopy(lVarArr2, 0, lVarArr3, 0, lVarArr2.length);
        System.arraycopy(lVarArr, 0, lVarArr3, lVarArr2.length, lVarArr.length);
        this.f30723d = lVarArr3;
    }

    public BarcodeFormat b() {
        return this.f30724e;
    }

    public int c() {
        return this.f30722c;
    }

    public byte[] d() {
        return this.f30721b;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.f30725f;
    }

    public l[] f() {
        return this.f30723d;
    }

    public String g() {
        return this.f30720a;
    }

    public long h() {
        return this.f30726g;
    }

    public void i(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f30725f;
            if (map2 == null) {
                this.f30725f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f30725f == null) {
            this.f30725f = new EnumMap(ResultMetadataType.class);
        }
        this.f30725f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f30720a;
    }

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, lVarArr, barcodeFormat, j10);
    }

    public k(String str, byte[] bArr, int i10, l[] lVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f30720a = str;
        this.f30721b = bArr;
        this.f30722c = i10;
        this.f30723d = lVarArr;
        this.f30724e = barcodeFormat;
        this.f30725f = null;
        this.f30726g = j10;
    }
}
