package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.vivo.advv.virtualview.common.ExprCommon;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static final short[] f22023a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};

    /* renamed from: b */
    private static final byte[] f22024b = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_MUL_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR, ExprCommon.OPCODE_OR};

    /* renamed from: com.opos.mobad.n.c.d$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f22025a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f22025a = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22025a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22025a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22025a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i2, float f2, float f3) {
        if (context != null && bitmap != null) {
            try {
                int width = (bitmap.getWidth() * i2) / 100;
                int height = (bitmap.getHeight() * i2) / 100;
                Bitmap b2 = b(a(bitmap, (bitmap.getWidth() - width) / 2, (bitmap.getHeight() - height) / 2, width, height), f2);
                if (b2 != null) {
                    return a(b2, f3);
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("GaussianBlur", "", th);
            }
        }
        return null;
    }

    private static Bitmap a(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = (int) f2;
        a(iArr, width, height, i2, 1, 0, 1);
        a(iArr, width, height, i2, 1, 0, 2);
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    private static Bitmap a(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (i2 < 0 || i3 < 0 || i4 < 1 || i5 < 1 || (i6 = i2 + i4) > bitmap.getWidth() || (i7 = i3 + i5) > bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 != null) {
            int i8 = AnonymousClass1.f22025a[config2.ordinal()];
            config = i8 != 1 ? i8 != 2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ALPHA_8 : Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config);
        createBitmap.setDensity(bitmap.getDensity());
        Rect rect = new Rect(i2, i3, i6, i7);
        RectF rectF = new RectF(0.0f, 0.0f, i4, i5);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
        canvas.setBitmap(null);
        return createBitmap;
    }

    private static void a(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i2;
        int i11 = i4;
        int i12 = i10 - 1;
        int i13 = i3 - 1;
        int i14 = (i11 * 2) + 1;
        short s = f22023a[i11];
        byte b2 = f22024b[i11];
        int[] iArr2 = new int[i14];
        int i15 = 8;
        if (i7 == 1) {
            int i16 = (i6 * i3) / i5;
            int i17 = ((i6 + 1) * i3) / i5;
            while (i16 < i17) {
                int i18 = i10 * i16;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                int i19 = 0;
                while (i19 <= i11) {
                    iArr2[i19] = iArr[i18];
                    i19++;
                    j2 += ((iArr[i18] >>> 16) & 255) * i19;
                    j3 += ((iArr[i18] >>> i15) & 255) * i19;
                    j4 += (iArr[i18] & 255) * i19;
                    j5 += (iArr[i18] >>> 16) & 255;
                    j6 += (iArr[i18] >>> i15) & 255;
                    j7 += iArr[i18] & 255;
                }
                int i20 = i18;
                long j8 = 0;
                long j9 = 0;
                long j10 = 0;
                int i21 = 1;
                while (i21 <= i11) {
                    if (i21 <= i12) {
                        i20++;
                    }
                    iArr2[i21 + i11] = iArr[i20];
                    int i22 = (i11 + 1) - i21;
                    j2 += ((iArr[i20] >>> 16) & 255) * i22;
                    j3 += ((iArr[i20] >>> i15) & 255) * i22;
                    j4 += (iArr[i20] & 255) * i22;
                    j10 += (iArr[i20] >>> 16) & 255;
                    j9 += (iArr[i20] >>> i15) & 255;
                    j8 += iArr[i20] & 255;
                    i21++;
                    iArr2 = iArr2;
                }
                int[] iArr3 = iArr2;
                int i23 = i11 > i12 ? i12 : i11;
                int i24 = i18 + i23;
                int i25 = i11;
                int i26 = 0;
                while (i26 < i10) {
                    long j11 = j8;
                    int i27 = i24;
                    int i28 = i26;
                    long j12 = s;
                    iArr[i18] = (int) ((((j12 * j4) >>> b2) & 255) | (iArr[i18] & (-16777216)) | ((((j12 * j2) >>> b2) & 255) << 16) | ((((j12 * j3) >>> b2) & 255) << 8));
                    int i29 = i18 + 1;
                    int i30 = (i25 + i14) - i11;
                    if (i30 >= i14) {
                        i30 -= i14;
                    }
                    long j13 = (iArr3[i30] >>> 16) & 255;
                    short s2 = s;
                    byte b3 = b2;
                    long j14 = (iArr3[i30] >>> 8) & 255;
                    long j15 = iArr3[i30] & 255;
                    if (i23 < i12) {
                        i9 = i27 + 1;
                        i23++;
                    } else {
                        i9 = i27;
                    }
                    iArr3[i30] = iArr[i9];
                    int i31 = i12;
                    int i32 = i17;
                    long j16 = j10 + ((iArr[i9] >>> 16) & 255);
                    long j17 = j9 + ((iArr[i9] >>> 8) & 255);
                    long j18 = j11 + (iArr[i9] & 255);
                    j2 = (j2 - j5) + j16;
                    j3 = (j3 - j6) + j17;
                    j4 = (j4 - j7) + j18;
                    i25++;
                    if (i25 >= i14) {
                        i25 = 0;
                    }
                    j5 = (j5 - j13) + ((iArr3[i25] >>> 16) & 255);
                    j6 = (j6 - j14) + ((iArr3[i25] >>> 8) & 255);
                    j7 = (j7 - j15) + (iArr3[i25] & 255);
                    j10 = j16 - ((iArr3[i25] >>> 16) & 255);
                    j9 = j17 - ((iArr3[i25] >>> 8) & 255);
                    j8 = j18 - (iArr3[i25] & 255);
                    i17 = i32;
                    i11 = i4;
                    i24 = i9;
                    s = s2;
                    b2 = b3;
                    i12 = i31;
                    i26 = i28 + 1;
                    i18 = i29;
                }
                i16++;
                i11 = i4;
                iArr2 = iArr3;
                i15 = 8;
            }
            return;
        }
        short s3 = s;
        if (i7 == 2) {
            int i33 = (i6 * i10) / i5;
            int i34 = ((i6 + 1) * i10) / i5;
            while (i33 < i34) {
                long j19 = 0;
                long j20 = 0;
                long j21 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                int i35 = 0;
                while (i35 <= i4) {
                    iArr2[i35] = iArr[i33];
                    long j25 = j19 + (((iArr[i33] >>> 16) & 255) * r7);
                    j21 += ((iArr[i33] >>> 8) & 255) * r7;
                    long j26 = j20 + ((iArr[i33] & 255) * r7);
                    j22 += (iArr[i33] >>> 16) & 255;
                    j23 += (iArr[i33] >>> 8) & 255;
                    j24 += iArr[i33] & 255;
                    i35++;
                    j19 = j25;
                    j20 = j26;
                }
                int i36 = i33;
                long j27 = 0;
                long j28 = 0;
                int i37 = 1;
                long j29 = 0;
                while (i37 <= i4) {
                    if (i37 <= i13) {
                        i36 += i10;
                    }
                    iArr2[i37 + i4] = iArr[i36];
                    int i38 = (i4 + 1) - i37;
                    j19 += ((iArr[i36] >>> 16) & 255) * i38;
                    j21 += ((iArr[i36] >>> 8) & 255) * i38;
                    j20 += (iArr[i36] & 255) * i38;
                    j28 += (iArr[i36] >>> 16) & 255;
                    j27 += (iArr[i36] >>> 8) & 255;
                    j29 += iArr[i36] & 255;
                    i37++;
                    i33 = i33;
                }
                int i39 = i33;
                int i40 = i4 > i13 ? i13 : i4;
                int i41 = (i40 * i10) + i39;
                int i42 = i3;
                int i43 = i4;
                int i44 = i39;
                int i45 = 0;
                while (i45 < i42) {
                    int i46 = i34;
                    int i47 = i41;
                    short s4 = s3;
                    int i48 = i13;
                    long j30 = s4;
                    iArr[i44] = (int) ((iArr[i44] & (-16777216)) | ((((j30 * j19) >>> b2) & 255) << 16) | ((((j30 * j21) >>> b2) & 255) << 8) | (((j30 * j20) >>> b2) & 255));
                    i44 += i10;
                    int i49 = (i43 + i14) - i4;
                    if (i49 >= i14) {
                        i49 -= i14;
                    }
                    long j31 = (iArr2[i49] >>> 16) & 255;
                    long j32 = (iArr2[i49] >>> 8) & 255;
                    long j33 = iArr2[i49] & 255;
                    i13 = i48;
                    if (i40 < i13) {
                        i8 = i47 + i10;
                        i40++;
                    } else {
                        i8 = i47;
                    }
                    iArr2[i49] = iArr[i8];
                    int i50 = i40;
                    long j34 = j28 + ((iArr[i8] >>> 16) & 255);
                    long j35 = j27 + ((iArr[i8] >>> 8) & 255);
                    long j36 = j29 + (iArr[i8] & 255);
                    j19 = (j19 - j22) + j34;
                    j21 = (j21 - j23) + j35;
                    j20 = (j20 - j24) + j36;
                    int i51 = i43 + 1;
                    i43 = i51 >= i14 ? 0 : i51;
                    j22 = (j22 - j31) + ((iArr2[i43] >>> 16) & 255);
                    j23 = (j23 - j32) + ((iArr2[i43] >>> 8) & 255);
                    j24 = (j24 - j33) + (iArr2[i43] & 255);
                    j28 = j34 - ((iArr2[i43] >>> 16) & 255);
                    j27 = j35 - ((iArr2[i43] >>> 8) & 255);
                    j29 = j36 - (iArr2[i43] & 255);
                    i45++;
                    i10 = i2;
                    i34 = i46;
                    i40 = i50;
                    i41 = i8;
                    s3 = s4;
                    i42 = i3;
                }
                i33 = i39 + 1;
                i10 = i2;
            }
        }
    }

    private static Bitmap b(Bitmap bitmap, float f2) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            try {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f2), Math.round(bitmap.getHeight() * f2), true);
                if (bitmap != bitmap2) {
                    com.opos.cmn.an.f.a.b("GaussianBlur", "src != dst,src.recycle()");
                    bitmap.recycle();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("GaussianBlur", "", (Throwable) e2);
            }
        }
        return bitmap2;
    }
}
