package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* loaded from: classes3.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i10, boolean z10) {
        Bitmap copy;
        int[] iArr;
        int i11 = i10;
        if (z10) {
            copy = bitmap;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            copy = bitmap.copy(config, true);
        }
        if (i11 <= 0) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i12 = width * height;
        int[] iArr2 = new int[i12];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11;
        int i16 = i15 + 1;
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[i12];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i15 + 2) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i20 = 0; i20 < i19; i20++) {
            iArr7[i20] = i20 / i18;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, 3);
        int i21 = i11 + 1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < height) {
            Bitmap bitmap2 = copy;
            int i25 = height;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = -i11;
            int i35 = 0;
            while (i34 <= i11) {
                int i36 = i14;
                int[] iArr9 = iArr6;
                int i37 = iArr2[i23 + Math.min(i13, Math.max(i34, 0))];
                int[] iArr10 = iArr8[i34 + i11];
                iArr10[0] = (i37 & 16711680) >> 16;
                iArr10[1] = (i37 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i37 & 255;
                int abs = i21 - Math.abs(i34);
                int i38 = iArr10[0];
                i35 += i38 * abs;
                int i39 = iArr10[1];
                i26 += i39 * abs;
                int i40 = iArr10[2];
                i27 += abs * i40;
                if (i34 > 0) {
                    i31 += i38;
                    i32 += i39;
                    i33 += i40;
                } else {
                    i28 += i38;
                    i29 += i39;
                    i30 += i40;
                }
                i34++;
                i14 = i36;
                iArr6 = iArr9;
            }
            int i41 = i14;
            int[] iArr11 = iArr6;
            int i42 = i11;
            int i43 = i35;
            int i44 = 0;
            while (i44 < width) {
                iArr3[i23] = iArr7[i43];
                iArr4[i23] = iArr7[i26];
                iArr5[i23] = iArr7[i27];
                int i45 = i43 - i28;
                int i46 = i26 - i29;
                int i47 = i27 - i30;
                int[] iArr12 = iArr8[((i42 - i11) + i16) % i16];
                int i48 = i28 - iArr12[0];
                int i49 = i29 - iArr12[1];
                int i50 = i30 - iArr12[2];
                if (i22 == 0) {
                    iArr = iArr7;
                    iArr11[i44] = Math.min(i44 + i11 + 1, i13);
                } else {
                    iArr = iArr7;
                }
                int i51 = iArr2[i24 + iArr11[i44]];
                int i52 = (i51 & 16711680) >> 16;
                iArr12[0] = i52;
                int i53 = (i51 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i53;
                int i54 = i51 & 255;
                iArr12[2] = i54;
                int i55 = i31 + i52;
                int i56 = i32 + i53;
                int i57 = i33 + i54;
                i43 = i45 + i55;
                i26 = i46 + i56;
                i27 = i47 + i57;
                i42 = (i42 + 1) % i16;
                int[] iArr13 = iArr8[i42 % i16];
                int i58 = iArr13[0];
                i28 = i48 + i58;
                int i59 = iArr13[1];
                i29 = i49 + i59;
                int i60 = iArr13[2];
                i30 = i50 + i60;
                i31 = i55 - i58;
                i32 = i56 - i59;
                i33 = i57 - i60;
                i23++;
                i44++;
                iArr7 = iArr;
            }
            i24 += width;
            i22++;
            copy = bitmap2;
            height = i25;
            i14 = i41;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i61 = i14;
        int[] iArr15 = iArr6;
        int i62 = height;
        int i63 = 0;
        while (i63 < width) {
            int i64 = -i11;
            int i65 = i16;
            int[] iArr16 = iArr2;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = i64;
            int i74 = i64 * width;
            int i75 = 0;
            int i76 = 0;
            while (i73 <= i11) {
                int i77 = width;
                int max = Math.max(0, i74) + i63;
                int[] iArr17 = iArr8[i73 + i11];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i21 - Math.abs(i73);
                i75 += iArr3[max] * abs2;
                i76 += iArr4[max] * abs2;
                i66 += iArr5[max] * abs2;
                if (i73 > 0) {
                    i70 += iArr17[0];
                    i71 += iArr17[1];
                    i72 += iArr17[2];
                } else {
                    i67 += iArr17[0];
                    i68 += iArr17[1];
                    i69 += iArr17[2];
                }
                int i78 = i61;
                if (i73 < i78) {
                    i74 += i77;
                }
                i73++;
                i61 = i78;
                width = i77;
            }
            int i79 = width;
            int i80 = i61;
            int i81 = i11;
            int i82 = i63;
            int i83 = i62;
            int i84 = 0;
            while (i84 < i83) {
                iArr16[i82] = (iArr16[i82] & (-16777216)) | (iArr14[i75] << 16) | (iArr14[i76] << 8) | iArr14[i66];
                int i85 = i75 - i67;
                int i86 = i76 - i68;
                int i87 = i66 - i69;
                int[] iArr18 = iArr8[((i81 - i11) + i65) % i65];
                int i88 = i67 - iArr18[0];
                int i89 = i68 - iArr18[1];
                int i90 = i69 - iArr18[2];
                if (i63 == 0) {
                    iArr15[i84] = Math.min(i84 + i21, i80) * i79;
                }
                int i91 = iArr15[i84] + i63;
                int i92 = iArr3[i91];
                iArr18[0] = i92;
                int i93 = iArr4[i91];
                iArr18[1] = i93;
                int i94 = iArr5[i91];
                iArr18[2] = i94;
                int i95 = i70 + i92;
                int i96 = i71 + i93;
                int i97 = i72 + i94;
                i75 = i85 + i95;
                i76 = i86 + i96;
                i66 = i87 + i97;
                i81 = (i81 + 1) % i65;
                int[] iArr19 = iArr8[i81];
                int i98 = iArr19[0];
                i67 = i88 + i98;
                int i99 = iArr19[1];
                i68 = i89 + i99;
                int i100 = iArr19[2];
                i69 = i90 + i100;
                i70 = i95 - i98;
                i71 = i96 - i99;
                i72 = i97 - i100;
                i82 += i79;
                i84++;
                i11 = i10;
            }
            i63++;
            i11 = i10;
            i61 = i80;
            i62 = i83;
            i16 = i65;
            iArr2 = iArr16;
            width = i79;
        }
        int i101 = width;
        bitmap3.setPixels(iArr2, 0, i101, 0, 0, i101, i62);
        return bitmap3;
    }
}
