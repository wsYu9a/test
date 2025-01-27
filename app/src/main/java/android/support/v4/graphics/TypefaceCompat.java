package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.LruCache;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public class TypefaceCompat {
    private static final String TAG;
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    /* renamed from: short */
    private static final short[] f5short;

    static {
        Object[] objArr = {new Integer(559139), new Integer(1477106)};
        short[] sArr = new short[((Integer) objArr[1]).intValue() ^ 1477117];
        sArr[0] = 1975;
        sArr[1] = 1946;
        sArr[2] = 1939;
        sArr[3] = 1926;
        sArr[4] = 1925;
        sArr[5] = 1922;
        sArr[6] = 1920;
        sArr[7] = 1926;
        sArr[8] = 1952;
        sArr[9] = 1932;
        sArr[10] = 1934;
        sArr[11] = 1939;
        sArr[12] = 1922;
        sArr[13] = 1943;
        sArr[14] = 1838;
        f5short = sArr;
        TAG = C0005.m17(f5short, 1750755 ^ C0008.m27((Object) "ۣۦۦ"), 1753481 ^ C0008.m27((Object) "ۦۡۢ"), C0008.m27((Object) "۟ۨ۠") ^ 1748980);
        if (Build.VERSION.SDK_INT >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (Build.VERSION.SDK_INT >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
        }
        sTypefaceCache = new LruCache<>(((Integer) objArr[0]).intValue() ^ 559155);
    }

    private TypefaceCompat() {
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i2);
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i2, int i3, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typeface;
        boolean z2 = true;
        Integer num = new Integer(-737879);
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            if (!z ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0) {
                z2 = false;
            }
            typeface = FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), fontCallback, handler, z2, z ? providerResourceEntry.getTimeout() : -1, i3);
        } else {
            Typeface createFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
            if (fontCallback == null) {
                typeface = createFromFontFamilyFilesResourceEntry;
            } else if (createFromFontFamilyFilesResourceEntry != null) {
                fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                typeface = createFromFontFamilyFilesResourceEntry;
            } else {
                fontCallback.callbackFailAsync(((Integer) new Object[]{num}[0]).intValue() ^ 737876, handler);
                typeface = createFromFontFamilyFilesResourceEntry;
            }
        }
        if (typeface != null) {
            sTypefaceCache.put(createResourceUid(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i2, String str, int i3) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i2, str, i3);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i2, i3), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    private static String createResourceUid(Resources resources, int i2, int i3) {
        StringBuilder append = new StringBuilder().append(resources.getResourcePackageName(i2));
        String m77 = C0523.m77(f5short, 56437 ^ C0008.m27((Object) "ۤ۟"), 1753546 ^ C0008.m27((Object) "ۦۣۨ"), C0008.m27((Object) "ۣۤ۠") ^ 1752804);
        return append.append(m77).append(i2).append(m77).append(i3).toString();
    }

    public static Typeface findFromCache(Resources resources, int i2, int i3) {
        return (Typeface) sTypefaceCache.get(createResourceUid(resources, i2, i3));
    }
}
