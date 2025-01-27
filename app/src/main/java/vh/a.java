package vh;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public class a {
    public static Bitmap a(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        int[] iArr;
        int i10 = radius;
        Bitmap copy = canReuseInBitmap ? sentBitmap : sentBitmap.copy(sentBitmap.getConfig(), true);
        if (i10 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i11 = width * height;
        int[] iArr2 = new int[i11];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i12 = width - 1;
        int i13 = height - 1;
        int i14 = i10 + i10;
        int i15 = i14 + 1;
        int[] iArr3 = new int[i11];
        int[] iArr4 = new int[i11];
        int[] iArr5 = new int[i11];
        int[] iArr6 = new int[Math.max(width, height)];
        int i16 = (i14 + 2) >> 1;
        int i17 = i16 * i16;
        int i18 = i17 * 256;
        int[] iArr7 = new int[i18];
        for (int i19 = 0; i19 < i18; i19++) {
            iArr7[i19] = i19 / i17;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i15, 3);
        int i20 = i10 + 1;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i21 < height) {
            Bitmap bitmap = copy;
            int i24 = height;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = -i10;
            int i34 = 0;
            while (i33 <= i10) {
                int i35 = i13;
                int[] iArr9 = iArr6;
                int i36 = iArr2[i22 + Math.min(i12, Math.max(i33, 0))];
                int[] iArr10 = iArr8[i33 + i10];
                iArr10[0] = (i36 & 16711680) >> 16;
                iArr10[1] = (i36 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i36 & 255;
                int abs = i20 - Math.abs(i33);
                int i37 = iArr10[0];
                i34 += i37 * abs;
                int i38 = iArr10[1];
                i25 += i38 * abs;
                int i39 = iArr10[2];
                i26 += abs * i39;
                if (i33 > 0) {
                    i30 += i37;
                    i31 += i38;
                    i32 += i39;
                } else {
                    i27 += i37;
                    i28 += i38;
                    i29 += i39;
                }
                i33++;
                i13 = i35;
                iArr6 = iArr9;
            }
            int i40 = i13;
            int[] iArr11 = iArr6;
            int i41 = i10;
            int i42 = i34;
            int i43 = 0;
            while (i43 < width) {
                iArr3[i22] = iArr7[i42];
                iArr4[i22] = iArr7[i25];
                iArr5[i22] = iArr7[i26];
                int i44 = i42 - i27;
                int i45 = i25 - i28;
                int i46 = i26 - i29;
                int[] iArr12 = iArr8[((i41 - i10) + i15) % i15];
                int i47 = i27 - iArr12[0];
                int i48 = i28 - iArr12[1];
                int i49 = i29 - iArr12[2];
                if (i21 == 0) {
                    iArr = iArr7;
                    iArr11[i43] = Math.min(i43 + i10 + 1, i12);
                } else {
                    iArr = iArr7;
                }
                int i50 = iArr2[i23 + iArr11[i43]];
                int i51 = (i50 & 16711680) >> 16;
                iArr12[0] = i51;
                int i52 = (i50 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i52;
                int i53 = i50 & 255;
                iArr12[2] = i53;
                int i54 = i30 + i51;
                int i55 = i31 + i52;
                int i56 = i32 + i53;
                i42 = i44 + i54;
                i25 = i45 + i55;
                i26 = i46 + i56;
                i41 = (i41 + 1) % i15;
                int[] iArr13 = iArr8[i41 % i15];
                int i57 = iArr13[0];
                i27 = i47 + i57;
                int i58 = iArr13[1];
                i28 = i48 + i58;
                int i59 = iArr13[2];
                i29 = i49 + i59;
                i30 = i54 - i57;
                i31 = i55 - i58;
                i32 = i56 - i59;
                i22++;
                i43++;
                iArr7 = iArr;
            }
            i23 += width;
            i21++;
            copy = bitmap;
            height = i24;
            i13 = i40;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap2 = copy;
        int i60 = i13;
        int[] iArr15 = iArr6;
        int i61 = height;
        int i62 = 0;
        while (i62 < width) {
            int i63 = -i10;
            int i64 = i15;
            int[] iArr16 = iArr2;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = i63;
            int i73 = i63 * width;
            int i74 = 0;
            int i75 = 0;
            while (i72 <= i10) {
                int i76 = width;
                int max = Math.max(0, i73) + i62;
                int[] iArr17 = iArr8[i72 + i10];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i20 - Math.abs(i72);
                i74 += iArr3[max] * abs2;
                i75 += iArr4[max] * abs2;
                i65 += iArr5[max] * abs2;
                if (i72 > 0) {
                    i69 += iArr17[0];
                    i70 += iArr17[1];
                    i71 += iArr17[2];
                } else {
                    i66 += iArr17[0];
                    i67 += iArr17[1];
                    i68 += iArr17[2];
                }
                int i77 = i60;
                if (i72 < i77) {
                    i73 += i76;
                }
                i72++;
                i60 = i77;
                width = i76;
            }
            int i78 = width;
            int i79 = i60;
            int i80 = i10;
            int i81 = i62;
            int i82 = i61;
            int i83 = 0;
            while (i83 < i82) {
                iArr16[i81] = (iArr16[i81] & (-16777216)) | (iArr14[i74] << 16) | (iArr14[i75] << 8) | iArr14[i65];
                int i84 = i74 - i66;
                int i85 = i75 - i67;
                int i86 = i65 - i68;
                int[] iArr18 = iArr8[((i80 - i10) + i64) % i64];
                int i87 = i66 - iArr18[0];
                int i88 = i67 - iArr18[1];
                int i89 = i68 - iArr18[2];
                if (i62 == 0) {
                    iArr15[i83] = Math.min(i83 + i20, i79) * i78;
                }
                int i90 = iArr15[i83] + i62;
                int i91 = iArr3[i90];
                iArr18[0] = i91;
                int i92 = iArr4[i90];
                iArr18[1] = i92;
                int i93 = iArr5[i90];
                iArr18[2] = i93;
                int i94 = i69 + i91;
                int i95 = i70 + i92;
                int i96 = i71 + i93;
                i74 = i84 + i94;
                i75 = i85 + i95;
                i65 = i86 + i96;
                i80 = (i80 + 1) % i64;
                int[] iArr19 = iArr8[i80];
                int i97 = iArr19[0];
                i66 = i87 + i97;
                int i98 = iArr19[1];
                i67 = i88 + i98;
                int i99 = iArr19[2];
                i68 = i89 + i99;
                i69 = i94 - i97;
                i70 = i95 - i98;
                i71 = i96 - i99;
                i81 += i78;
                i83++;
                i10 = radius;
            }
            i62++;
            i10 = radius;
            i60 = i79;
            i61 = i82;
            i15 = i64;
            iArr2 = iArr16;
            width = i78;
        }
        int i100 = width;
        bitmap2.setPixels(iArr2, 0, i100, 0, 0, i100, i61);
        return bitmap2;
    }
}
