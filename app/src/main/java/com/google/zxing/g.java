package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.a0;
import com.google.zxing.oned.t;
import java.util.Map;

/* loaded from: classes.dex */
public final class g implements n {

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8431a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f8431a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8431a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8431a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8431a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8431a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8431a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8431a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8431a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8431a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8431a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8431a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8431a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8431a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        n kVar;
        switch (a.f8431a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new com.google.zxing.oned.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new com.google.zxing.oned.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new com.google.zxing.u.b();
                break;
            case 6:
                kVar = new com.google.zxing.oned.e();
                break;
            case 7:
                kVar = new com.google.zxing.oned.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new com.google.zxing.oned.n();
                break;
            case 10:
                kVar = new com.google.zxing.t.d();
                break;
            case 11:
                kVar = new com.google.zxing.oned.b();
                break;
            case 12:
                kVar = new com.google.zxing.q.b();
                break;
            case 13:
                kVar = new com.google.zxing.o.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.a(str, barcodeFormat, i2, i3, map);
    }

    @Override // com.google.zxing.n
    public com.google.zxing.common.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
