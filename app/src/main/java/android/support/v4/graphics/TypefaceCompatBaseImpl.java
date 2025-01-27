package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.view.C0008;
import com.google.gason.C0107;
import com.tencent.a.C0522;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
class TypefaceCompatBaseImpl {
    private static final String CACHE_FILE_PREFIX;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f10short;

    /* renamed from: android.support.v4.graphics.TypefaceCompatBaseImpl$1 */
    class AnonymousClass1 implements StyleExtractor<FontsContractCompat.FontInfo> {
        AnonymousClass1() {
        }

        @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public int getWeight(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.getWeight();
        }

        @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.isItalic();
        }
    }

    /* renamed from: android.support.v4.graphics.TypefaceCompatBaseImpl$2 */
    class AnonymousClass2 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        AnonymousClass2() {
        }

        @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }
    }

    private interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(7832700)}[0]).intValue() ^ 7832670];
        sArr[0] = 3000;
        sArr[1] = 3002;
        sArr[2] = 3000;
        sArr[3] = 2995;
        sArr[4] = 3006;
        sArr[5] = 3007;
        sArr[6] = 2948;
        sArr[7] = 3005;
        sArr[8] = 2996;
        sArr[9] = 2997;
        sArr[10] = 2991;
        sArr[11] = 2948;
        sArr[12] = 2836;
        sArr[13] = 2873;
        sArr[14] = 2864;
        sArr[15] = 2853;
        sArr[16] = 2854;
        sArr[17] = 2849;
        sArr[18] = 2851;
        sArr[19] = 2853;
        sArr[20] = 2819;
        sArr[21] = 2863;
        sArr[22] = 2861;
        sArr[23] = 2864;
        sArr[24] = 2849;
        sArr[25] = 2868;
        sArr[26] = 2818;
        sArr[27] = 2849;
        sArr[28] = 2867;
        sArr[29] = 2853;
        sArr[30] = 2825;
        sArr[31] = 2861;
        sArr[32] = 2864;
        sArr[33] = 2860;
        f10short = sArr;
        CACHE_FILE_PREFIX = C0522.m72(f10short, 56356 ^ C0008.m27((Object) "ۡۥ"), 1748745 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۣۢۧ") ^ 1751325);
        TAG = C0107.m50(f10short, 1747761 ^ C0008.m27((Object) "ۣ۠۠"), 1746710 ^ C0008.m27((Object) "۟۟۠"), C0008.m27((Object) "ۢ۠ۥ") ^ 1751335);
    }

    TypefaceCompatBaseImpl() {
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i2) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i2, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.2
            AnonymousClass2() {
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] tArr, int i2, StyleExtractor<T> styleExtractor) {
        T t;
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t2 = null;
        int i4 = Integer.MAX_VALUE;
        int length = tArr.length;
        int i5 = 0;
        while (i5 < length) {
            T t3 = tArr[i5];
            int abs = (styleExtractor.isItalic(t3) == z ? 0 : 1) + (Math.abs(styleExtractor.getWeight(t3) - i3) * 2);
            if (t2 == null || i4 > abs) {
                i4 = abs;
                t = t3;
            } else {
                t = t2;
            }
            i5++;
            t2 = t;
        }
        return t2;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i2);
        if (findBestEntry == null) {
            return null;
        }
        return TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i2);
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InputStream inputStream;
        Throwable th;
        Typeface typeface = null;
        if (fontInfoArr.length >= 1) {
            try {
                inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i2).getUri());
                try {
                    typeface = createFromInputStream(context, inputStream);
                    TypefaceCompatUtil.closeQuietly(inputStream);
                } catch (IOException e2) {
                    TypefaceCompatUtil.closeQuietly(inputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    TypefaceCompatUtil.closeQuietly(inputStream);
                    throw th;
                }
            } catch (IOException e3) {
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        }
        return typeface;
    }

    protected Typeface createFromInputStream(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile != null) {
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                    typeface = Typeface.createFromFile(tempFile.getPath());
                }
            } catch (RuntimeException e2) {
            } finally {
                tempFile.delete();
            }
        }
        return typeface;
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i2, String str, int i3) {
        Typeface typeface = null;
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile != null) {
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, resources, i2)) {
                    typeface = Typeface.createFromFile(tempFile.getPath());
                }
            } catch (RuntimeException e2) {
            } finally {
                tempFile.delete();
            }
        }
        return typeface;
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i2, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.1
            AnonymousClass1() {
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }
}
