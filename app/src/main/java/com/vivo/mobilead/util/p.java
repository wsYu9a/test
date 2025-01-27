package com.vivo.mobilead.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public class p {

    static class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ Bitmap f30754a;

        /* renamed from: b */
        final /* synthetic */ float f30755b;

        /* renamed from: c */
        final /* synthetic */ int f30756c;

        /* renamed from: d */
        final /* synthetic */ b f30757d;

        /* renamed from: com.vivo.mobilead.util.p$a$a */
        class C0669a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ Bitmap f30758a;

            C0669a(Bitmap bitmap) {
                this.f30758a = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                Bitmap bitmap = this.f30758a;
                if (bitmap != null) {
                    b bVar = a.this.f30757d;
                    if (bVar != null) {
                        bVar.a(bitmap);
                        return;
                    }
                    return;
                }
                b bVar2 = a.this.f30757d;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {
            b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b bVar = a.this.f30757d;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        class c extends com.vivo.mobilead.util.f1.b {
            c() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b bVar = a.this.f30757d;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        a(Bitmap bitmap, float f2, int i2, b bVar) {
            this.f30754a = bitmap;
            this.f30755b = f2;
            this.f30756c = i2;
            this.f30757d = bVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                Bitmap bitmap = this.f30754a;
                if (bitmap == null || bitmap.isRecycled()) {
                    z.b().a(new b());
                } else {
                    z.b().a(new C0669a(p.b(this.f30754a, this.f30755b, this.f30756c)));
                }
            } catch (Throwable th) {
                j.a.b.a(com.vivo.mobilead.util.f1.b.TAG, "fastBlur error " + th.getMessage());
                z.b().a(new c());
            }
        }
    }

    public interface b {
        void a();

        void a(Bitmap bitmap);
    }

    public static Bitmap b(Bitmap bitmap, float f2, int i2) {
        int[] iArr;
        int i3 = i2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f2), Math.round(bitmap.getHeight() * f2), false);
        Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
        if (i3 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (i25 <= i3) {
                int i27 = i6;
                int[] iArr9 = iArr6;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i3];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i12 - Math.abs(i25);
                i18 += iArr10[0] * abs;
                i17 += iArr10[1] * abs;
                i26 += iArr10[2] * abs;
                if (i25 > 0) {
                    i24 += iArr10[0];
                    i23 += iArr10[1];
                    i22 += iArr10[2];
                } else {
                    i21 += iArr10[0];
                    i20 += iArr10[1];
                    i19 += iArr10[2];
                }
                i25++;
                i6 = i27;
                iArr6 = iArr9;
            }
            int i29 = i6;
            int[] iArr11 = iArr6;
            int i30 = i3;
            int i31 = i26;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i18];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i31];
                int i33 = i18 - i21;
                int i34 = i17 - i20;
                int i35 = i31 - i19;
                int[] iArr12 = iArr8[((i30 - i3) + i7) % i7];
                int i36 = i21 - iArr12[0];
                int i37 = i20 - iArr12[1];
                int i38 = i19 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr11[i32]];
                iArr12[0] = (i39 & 16711680) >> 16;
                iArr12[1] = (i39 & 65280) >> 8;
                iArr12[2] = i39 & 255;
                int i40 = i24 + iArr12[0];
                int i41 = i23 + iArr12[1];
                int i42 = i22 + iArr12[2];
                i18 = i33 + i40;
                i17 = i34 + i41;
                i31 = i35 + i42;
                i30 = (i30 + 1) % i7;
                int[] iArr13 = iArr8[i30 % i7];
                i21 = i36 + iArr13[0];
                i20 = i37 + iArr13[1];
                i19 = i38 + iArr13[2];
                i24 = i40 - iArr13[0];
                i23 = i41 - iArr13[1];
                i22 = i42 - iArr13[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i6 = i29;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int[] iArr14 = iArr7;
        int i43 = i6;
        int[] iArr15 = iArr6;
        int i44 = height;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i7;
            int[] iArr16 = iArr2;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (i55 <= i3) {
                int i59 = width;
                int max = Math.max(0, i56) + i45;
                int[] iArr17 = iArr8[i55 + i3];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i55);
                i48 += iArr3[max] * abs2;
                i58 += iArr4[max] * abs2;
                i57 += iArr5[max] * abs2;
                if (i55 > 0) {
                    i54 += iArr17[0];
                    i53 += iArr17[1];
                    i52 += iArr17[2];
                } else {
                    i51 += iArr17[0];
                    i50 += iArr17[1];
                    i49 += iArr17[2];
                }
                int i60 = i43;
                if (i55 < i60) {
                    i56 += i59;
                }
                i55++;
                i43 = i60;
                width = i59;
            }
            int i61 = width;
            int i62 = i43;
            int i63 = i3;
            int i64 = i45;
            int i65 = i48;
            int i66 = i44;
            int i67 = i58;
            int i68 = 0;
            while (i68 < i66) {
                iArr16[i64] = (iArr16[i64] & (-16777216)) | (iArr14[i65] << 16) | (iArr14[i67] << 8) | iArr14[i57];
                int i69 = i65 - i51;
                int i70 = i67 - i50;
                int i71 = i57 - i49;
                int[] iArr18 = iArr8[((i63 - i3) + i47) % i47];
                int i72 = i51 - iArr18[0];
                int i73 = i50 - iArr18[1];
                int i74 = i49 - iArr18[2];
                if (i45 == 0) {
                    iArr15[i68] = Math.min(i68 + i12, i62) * i61;
                }
                int i75 = iArr15[i68] + i45;
                iArr18[0] = iArr3[i75];
                iArr18[1] = iArr4[i75];
                iArr18[2] = iArr5[i75];
                int i76 = i54 + iArr18[0];
                int i77 = i53 + iArr18[1];
                int i78 = i52 + iArr18[2];
                i65 = i69 + i76;
                i67 = i70 + i77;
                i57 = i71 + i78;
                i63 = (i63 + 1) % i47;
                int[] iArr19 = iArr8[i63];
                i51 = i72 + iArr19[0];
                i50 = i73 + iArr19[1];
                i49 = i74 + iArr19[2];
                i54 = i76 - iArr19[0];
                i53 = i77 - iArr19[1];
                i52 = i78 - iArr19[2];
                i64 += i61;
                i68++;
                i3 = i2;
            }
            i45++;
            i3 = i2;
            i43 = i62;
            i44 = i66;
            i7 = i47;
            iArr2 = iArr16;
            width = i61;
        }
        int i79 = width;
        bitmap3.setPixels(iArr2, 0, i79, 0, 0, i79, i44);
        return bitmap3;
    }

    public static void a(Bitmap bitmap, float f2, int i2, b bVar) {
        a1.c(new a(bitmap, f2, i2, bVar));
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i2 && height != i3) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, bitmap.getConfig());
        float f4 = 0.0f;
        if (width * i3 > i2 * height) {
            f2 = i3 / height;
            f4 = (i2 - (width * f2)) * 0.5f;
            f3 = 0.0f;
        } else {
            float f5 = i2 / width;
            float f6 = (i3 - (height * f5)) * 0.5f;
            f2 = f5;
            f3 = f6;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        matrix.postTranslate(Math.round(f4), Math.round(f3));
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, matrix, null);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
