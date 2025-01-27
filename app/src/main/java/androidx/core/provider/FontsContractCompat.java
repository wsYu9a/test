package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.util.Preconditions;
import com.umeng.commonsdk.config.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class FontsContractCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";

    /* renamed from: a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int f1842a = -1;

    /* renamed from: b */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int f1843b = -2;

    /* renamed from: d */
    private static final int f1845d = 10000;

    /* renamed from: c */
    static final LruCache<String, Typeface> f1844c = new LruCache<>(16);

    /* renamed from: e */
    private static final SelfDestructiveThread f1846e = new SelfDestructiveThread("fonts", 10, 10000);

    /* renamed from: f */
    static final Object f1847f = new Object();

    /* renamed from: g */
    @GuardedBy("sLock")
    static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> f1848g = new SimpleArrayMap<>();

    /* renamed from: h */
    private static final Comparator<byte[]> f1849h = new Comparator<byte[]>() { // from class: androidx.core.provider.FontsContractCompat.5
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            if (bArr.length == bArr2.length) {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (bArr[i4] != bArr2[i4]) {
                        i2 = bArr[i4];
                        i3 = bArr2[i4];
                    }
                }
                return 0;
            }
            i2 = bArr.length;
            i3 = bArr2.length;
            return i2 - i3;
        }
    };

    /* renamed from: androidx.core.provider.FontsContractCompat$1 */
    class AnonymousClass1 implements Callable<TypefaceResult> {

        /* renamed from: a */
        final /* synthetic */ Context f1850a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f1851b;

        /* renamed from: c */
        final /* synthetic */ int f1852c;

        /* renamed from: d */
        final /* synthetic */ String f1853d;

        AnonymousClass1(Context context, FontRequest fontRequest, int i2, String str) {
            context = context;
            fontRequest = fontRequest;
            i3 = i2;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        public TypefaceResult call() throws Exception {
            TypefaceResult e2 = FontsContractCompat.e(context, fontRequest, i3);
            Typeface typeface = e2.f1879a;
            if (typeface != null) {
                FontsContractCompat.f1844c.put(str, typeface);
            }
            return e2;
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$2 */
    class AnonymousClass2 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {

        /* renamed from: b */
        final /* synthetic */ Handler f1855b;

        AnonymousClass2(Handler handler) {
            handler = handler;
        }

        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typefaceResult) {
            if (typefaceResult == null) {
                ResourcesCompat.FontCallback.this.callbackFailAsync(1, handler);
                return;
            }
            int i2 = typefaceResult.f1880b;
            if (i2 == 0) {
                ResourcesCompat.FontCallback.this.callbackSuccessAsync(typefaceResult.f1879a, handler);
            } else {
                ResourcesCompat.FontCallback.this.callbackFailAsync(i2, handler);
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$3 */
    class AnonymousClass3 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {

        /* renamed from: a */
        final /* synthetic */ String f1856a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typefaceResult) {
            synchronized (FontsContractCompat.f1847f) {
                SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> simpleArrayMap = FontsContractCompat.f1848g;
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = simpleArrayMap.get(str);
                if (arrayList == null) {
                    return;
                }
                simpleArrayMap.remove(str);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).onReply(typefaceResult);
                }
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1857a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f1858b;

        /* renamed from: c */
        final /* synthetic */ Handler f1859c;

        /* renamed from: d */
        final /* synthetic */ FontRequestCallback f1860d;

        /* renamed from: androidx.core.provider.FontsContractCompat$4$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$2 */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-2);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$3 */
        class AnonymousClass3 implements Runnable {
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$4 */
        class RunnableC00094 implements Runnable {
            RunnableC00094() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$5 */
        class AnonymousClass5 implements Runnable {
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$6 */
        class AnonymousClass6 implements Runnable {
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$7 */
        class AnonymousClass7 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1867a;

            AnonymousClass7(int i2) {
                resultCode = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(resultCode);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$8 */
        class AnonymousClass8 implements Runnable {
            AnonymousClass8() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$9 */
        class AnonymousClass9 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Typeface f1870a;

            AnonymousClass9(Typeface typeface) {
                buildTypeface = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(buildTypeface);
            }
        }

        AnonymousClass4(Context context, FontRequest fontRequest, Handler handler, FontRequestCallback fontRequestCallback) {
            context = context;
            fontRequest = fontRequest;
            handler2 = handler;
            fontRequestCallback = fontRequestCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(context, null, fontRequest);
                if (fetchFonts.getStatusCode() != 0) {
                    int statusCode = fetchFonts.getStatusCode();
                    if (statusCode == 1) {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.2
                            AnonymousClass2() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-2);
                            }
                        });
                        return;
                    } else if (statusCode != 2) {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.4
                            RunnableC00094() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    } else {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.3
                            AnonymousClass3() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    }
                }
                FontInfo[] fonts = fetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.5
                        AnonymousClass5() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(1);
                        }
                    });
                    return;
                }
                for (FontInfo fontInfo : fonts) {
                    if (fontInfo.getResultCode() != 0) {
                        int resultCode = fontInfo.getResultCode();
                        if (resultCode < 0) {
                            handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.6
                                AnonymousClass6() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.7

                                /* renamed from: a */
                                final /* synthetic */ int f1867a;

                                AnonymousClass7(int resultCode2) {
                                    resultCode = resultCode2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(resultCode);
                                }
                            });
                            return;
                        }
                    }
                }
                Typeface buildTypeface = FontsContractCompat.buildTypeface(context, null, fonts);
                if (buildTypeface == null) {
                    handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.8
                        AnonymousClass8() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-3);
                        }
                    });
                } else {
                    handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.9

                        /* renamed from: a */
                        final /* synthetic */ Typeface f1870a;

                        AnonymousClass9(Typeface buildTypeface2) {
                            buildTypeface = buildTypeface2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                        }
                    });
                }
            } catch (PackageManager.NameNotFoundException unused) {
                handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        fontRequestCallback.onTypefaceRequestFailed(-1);
                    }
                });
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$5 */
    class AnonymousClass5 implements Comparator<byte[]> {
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            if (bArr.length == bArr2.length) {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (bArr[i4] != bArr2[i4]) {
                        i2 = bArr[i4];
                        i3 = bArr2[i4];
                    }
                }
                return 0;
            }
            i2 = bArr.length;
            i3 = bArr2.length;
            return i2 - i3;
        }
    }

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;

        /* renamed from: a */
        private final int f1872a;

        /* renamed from: b */
        private final FontInfo[] f1873b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i2, @Nullable FontInfo[] fontInfoArr) {
            this.f1872a = i2;
            this.f1873b = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.f1873b;
        }

        public int getStatusCode() {
            return this.f1872a;
        }
    }

    public static class FontInfo {

        /* renamed from: a */
        private final Uri f1874a;

        /* renamed from: b */
        private final int f1875b;

        /* renamed from: c */
        private final int f1876c;

        /* renamed from: d */
        private final boolean f1877d;

        /* renamed from: e */
        private final int f1878e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z, int i4) {
            this.f1874a = (Uri) Preconditions.checkNotNull(uri);
            this.f1875b = i2;
            this.f1876c = i3;
            this.f1877d = z;
            this.f1878e = i4;
        }

        public int getResultCode() {
            return this.f1878e;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.f1875b;
        }

        @NonNull
        public Uri getUri() {
            return this.f1874a;
        }

        @IntRange(from = 1, to = d.f26117a)
        public int getWeight() {
            return this.f1876c;
        }

        public boolean isItalic() {
            return this.f1877d;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i2) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    private static final class TypefaceResult {

        /* renamed from: a */
        final Typeface f1879a;

        /* renamed from: b */
        final int f1880b;

        TypefaceResult(@Nullable Typeface typeface, int i2) {
            this.f1879a = typeface;
            this.f1880b = i2;
        }
    }

    private FontsContractCompat() {
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    private static List<List<byte[]>> c(FontRequest fontRequest, Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x013a  */
    @androidx.annotation.NonNull
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.core.provider.FontsContractCompat.FontInfo[] d(android.content.Context r23, androidx.core.provider.FontRequest r24, java.lang.String r25, android.os.CancellationSignal r26) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontsContractCompat.d(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }

    @NonNull
    static TypefaceResult e(Context context, FontRequest fontRequest, int i2) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
            if (fetchFonts.getStatusCode() != 0) {
                return new TypefaceResult(null, fetchFonts.getStatusCode() == 1 ? -2 : -3);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fetchFonts.getFonts(), i2);
            return new TypefaceResult(createFromFontInfo, createFromFontInfo != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(null, -1);
        }
    }

    private static void f(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4

            /* renamed from: a */
            final /* synthetic */ Context f1857a;

            /* renamed from: b */
            final /* synthetic */ FontRequest f1858b;

            /* renamed from: c */
            final /* synthetic */ Handler f1859c;

            /* renamed from: d */
            final /* synthetic */ FontRequestCallback f1860d;

            /* renamed from: androidx.core.provider.FontsContractCompat$4$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-1);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$2 */
            class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-2);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$3 */
            class AnonymousClass3 implements Runnable {
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$4 */
            class RunnableC00094 implements Runnable {
                RunnableC00094() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$5 */
            class AnonymousClass5 implements Runnable {
                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(1);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$6 */
            class AnonymousClass6 implements Runnable {
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$7 */
            class AnonymousClass7 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ int f1867a;

                AnonymousClass7(int resultCode2) {
                    resultCode = resultCode2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(resultCode);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$8 */
            class AnonymousClass8 implements Runnable {
                AnonymousClass8() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$9 */
            class AnonymousClass9 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Typeface f1870a;

                AnonymousClass9(Typeface buildTypeface2) {
                    buildTypeface = buildTypeface2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                }
            }

            AnonymousClass4(Context context2, FontRequest fontRequest2, Handler handler2, FontRequestCallback fontRequestCallback2) {
                context = context2;
                fontRequest = fontRequest2;
                handler2 = handler2;
                fontRequestCallback = fontRequestCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(context, null, fontRequest);
                    if (fetchFonts.getStatusCode() != 0) {
                        int statusCode = fetchFonts.getStatusCode();
                        if (statusCode == 1) {
                            handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.2
                                AnonymousClass2() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-2);
                                }
                            });
                            return;
                        } else if (statusCode != 2) {
                            handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.4
                                RunnableC00094() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.3
                                AnonymousClass3() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        }
                    }
                    FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts == null || fonts.length == 0) {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.5
                            AnonymousClass5() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(1);
                            }
                        });
                        return;
                    }
                    for (FontInfo fontInfo : fonts) {
                        if (fontInfo.getResultCode() != 0) {
                            int resultCode2 = fontInfo.getResultCode();
                            if (resultCode2 < 0) {
                                handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.6
                                    AnonymousClass6() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                return;
                            } else {
                                handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.7

                                    /* renamed from: a */
                                    final /* synthetic */ int f1867a;

                                    AnonymousClass7(int resultCode22) {
                                        resultCode = resultCode22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(resultCode);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    Typeface buildTypeface2 = FontsContractCompat.buildTypeface(context, null, fonts);
                    if (buildTypeface2 == null) {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.8
                            AnonymousClass8() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                    } else {
                        handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.9

                            /* renamed from: a */
                            final /* synthetic */ Typeface f1870a;

                            AnonymousClass9(Typeface buildTypeface22) {
                                buildTypeface = buildTypeface22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                            }
                        });
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    handler2.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-1);
                        }
                    });
                }
            }
        });
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        return provider == null ? new FontFamilyResult(1, null) : new FontFamilyResult(0, d(context, fontRequest, provider.authority, cancellationSignal));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFontSync(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z, int i2, int i3) {
        String str = fontRequest.getIdentifier() + "-" + i3;
        Typeface typeface = f1844c.get(str);
        if (typeface != null) {
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
            return typeface;
        }
        if (z && i2 == -1) {
            TypefaceResult e2 = e(context, fontRequest, i3);
            if (fontCallback != null) {
                int i4 = e2.f1880b;
                if (i4 == 0) {
                    fontCallback.callbackSuccessAsync(e2.f1879a, handler);
                } else {
                    fontCallback.callbackFailAsync(i4, handler);
                }
            }
            return e2.f1879a;
        }
        AnonymousClass1 anonymousClass1 = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.1

            /* renamed from: a */
            final /* synthetic */ Context f1850a;

            /* renamed from: b */
            final /* synthetic */ FontRequest f1851b;

            /* renamed from: c */
            final /* synthetic */ int f1852c;

            /* renamed from: d */
            final /* synthetic */ String f1853d;

            AnonymousClass1(Context context2, FontRequest fontRequest2, int i32, String str2) {
                context = context2;
                fontRequest = fontRequest2;
                i3 = i32;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            public TypefaceResult call() throws Exception {
                TypefaceResult e22 = FontsContractCompat.e(context, fontRequest, i3);
                Typeface typeface2 = e22.f1879a;
                if (typeface2 != null) {
                    FontsContractCompat.f1844c.put(str, typeface2);
                }
                return e22;
            }
        };
        if (z) {
            try {
                return ((TypefaceResult) f1846e.postAndWait(anonymousClass1, i2)).f1879a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        AnonymousClass2 anonymousClass2 = fontCallback == null ? null : new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.2

            /* renamed from: b */
            final /* synthetic */ Handler f1855b;

            AnonymousClass2(Handler handler2) {
                handler = handler2;
            }

            @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
            public void onReply(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    ResourcesCompat.FontCallback.this.callbackFailAsync(1, handler);
                    return;
                }
                int i22 = typefaceResult.f1880b;
                if (i22 == 0) {
                    ResourcesCompat.FontCallback.this.callbackSuccessAsync(typefaceResult.f1879a, handler);
                } else {
                    ResourcesCompat.FontCallback.this.callbackFailAsync(i22, handler);
                }
            }
        };
        synchronized (f1847f) {
            SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> simpleArrayMap = f1848g;
            ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = simpleArrayMap.get(str2);
            if (arrayList != null) {
                if (anonymousClass2 != null) {
                    arrayList.add(anonymousClass2);
                }
                return null;
            }
            if (anonymousClass2 != null) {
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList2 = new ArrayList<>();
                arrayList2.add(anonymousClass2);
                simpleArrayMap.put(str2, arrayList2);
            }
            f1846e.postAndReply(anonymousClass1, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.3

                /* renamed from: a */
                final /* synthetic */ String f1856a;

                AnonymousClass3(String str2) {
                    str = str2;
                }

                @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                public void onReply(TypefaceResult typefaceResult) {
                    synchronized (FontsContractCompat.f1847f) {
                        SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> simpleArrayMap2 = FontsContractCompat.f1848g;
                        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList3 = simpleArrayMap2.get(str);
                        if (arrayList3 == null) {
                            return;
                        }
                        simpleArrayMap2.remove(str);
                        for (int i22 = 0; i22 < arrayList3.size(); i22++) {
                            arrayList3.get(i22).onReply(typefaceResult);
                        }
                    }
                }
            });
            return null;
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(a2, f1849h);
        List<List<byte[]>> c2 = c(fontRequest, resources);
        for (int i2 = 0; i2 < c2.size(); i2++) {
            ArrayList arrayList = new ArrayList(c2.get(i2));
            Collections.sort(arrayList, f1849h);
            if (b(a2, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        f(context.getApplicationContext(), fontRequest, fontRequestCallback, handler);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        f1844c.evictAll();
    }
}
