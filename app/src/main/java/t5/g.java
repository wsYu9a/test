package t5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import j6.a0;
import j6.t;
import java.util.Map;

/* loaded from: classes2.dex */
public final class g implements n {

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f30708a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f30708a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30708a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30708a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30708a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30708a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30708a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30708a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30708a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30708a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30708a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30708a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f30708a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f30708a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // t5.n
    public z5.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        n kVar;
        switch (a.f30708a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new j6.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new j6.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new s6.b();
                break;
            case 6:
                kVar = new j6.e();
                break;
            case 7:
                kVar = new j6.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new j6.n();
                break;
            case 10:
                kVar = new n6.d();
                break;
            case 11:
                kVar = new j6.b();
                break;
            case 12:
                kVar = new c6.b();
                break;
            case 13:
                kVar = new u5.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.a(str, barcodeFormat, i10, i11, map);
    }

    @Override // t5.n
    public z5.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return a(str, barcodeFormat, i10, i11, null);
    }
}
