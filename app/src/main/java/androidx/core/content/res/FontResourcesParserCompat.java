package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    /* renamed from: a */
    private static final int f1696a = 400;

    /* renamed from: b */
    private static final int f1697b = 1;

    /* renamed from: c */
    private static final int f1698c = 500;

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        @NonNull
        private final FontFileResourceEntry[] f1699a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f1699a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.f1699a;
        }
    }

    public static final class FontFileResourceEntry {

        /* renamed from: a */
        @NonNull
        private final String f1700a;

        /* renamed from: b */
        private int f1701b;

        /* renamed from: c */
        private boolean f1702c;

        /* renamed from: d */
        private String f1703d;

        /* renamed from: e */
        private int f1704e;

        /* renamed from: f */
        private int f1705f;

        public FontFileResourceEntry(@NonNull String str, int i2, boolean z, @Nullable String str2, int i3, int i4) {
            this.f1700a = str;
            this.f1701b = i2;
            this.f1702c = z;
            this.f1703d = str2;
            this.f1704e = i3;
            this.f1705f = i4;
        }

        @NonNull
        public String getFileName() {
            return this.f1700a;
        }

        public int getResourceId() {
            return this.f1705f;
        }

        public int getTtcIndex() {
            return this.f1704e;
        }

        @Nullable
        public String getVariationSettings() {
            return this.f1703d;
        }

        public int getWeight() {
            return this.f1701b;
        }

        public boolean isItalic() {
            return this.f1702c;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        @NonNull
        private final FontRequest f1706a;

        /* renamed from: b */
        private final int f1707b;

        /* renamed from: c */
        private final int f1708c;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i2, int i3) {
            this.f1706a = fontRequest;
            this.f1708c = i2;
            this.f1707b = i3;
        }

        public int getFetchStrategy() {
            return this.f1708c;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.f1706a;
        }

        public int getTimeout() {
            return this.f1707b;
        }
    }

    private FontResourcesParserCompat() {
    }

    @Nullable
    private static FamilyResourceEntry a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return b(xmlPullParser, resources);
        }
        d(xmlPullParser);
        return null;
    }

    @Nullable
    private static FamilyResourceEntry b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                d(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(c(xmlPullParser, resources));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
    }

    private static FontFileResourceEntry c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i2 = R.styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i3 = obtainAttributes.getInt(i2, 400);
        int i4 = R.styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i4, 0);
        int i5 = R.styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i6 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = R.styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            d(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i3, z, string, i7, resourceId);
    }

    private static void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> e(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static int getType(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (getType(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(e(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(e(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }
}
