package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class FontRequestWorker {
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    static final Object LOCK = new Object();

    @GuardedBy("LOCK")
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();

    /* renamed from: androidx.core.provider.FontRequestWorker$1 */
    public class AnonymousClass1 implements Callable<TypefaceResult> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$id;
        final /* synthetic */ FontRequest val$request;
        final /* synthetic */ int val$style;

        public AnonymousClass1(String str, Context context, FontRequest fontRequest, int i10) {
            createCacheId = str;
            context = context;
            fontRequest = fontRequest;
            i10 = i10;
        }

        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            return FontRequestWorker.getFontSync(createCacheId, context, fontRequest, i10);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$2 */
    public class AnonymousClass2 implements Consumer<TypefaceResult> {
        public AnonymousClass2() {
        }

        @Override // androidx.core.util.Consumer
        public void accept(TypefaceResult typefaceResult) {
            if (typefaceResult == null) {
                typefaceResult = new TypefaceResult(-3);
            }
            CallbackWithHandler.this.onTypefaceResult(typefaceResult);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$3 */
    public class AnonymousClass3 implements Callable<TypefaceResult> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$id;
        final /* synthetic */ FontRequest val$request;
        final /* synthetic */ int val$style;

        public AnonymousClass3(String str, Context context, FontRequest fontRequest, int i10) {
            createCacheId = str;
            context = context;
            fontRequest = fontRequest;
            i10 = i10;
        }

        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            try {
                return FontRequestWorker.getFontSync(createCacheId, context, fontRequest, i10);
            } catch (Throwable unused) {
                return new TypefaceResult(-3);
            }
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$4 */
    public class AnonymousClass4 implements Consumer<TypefaceResult> {
        final /* synthetic */ String val$id;

        public AnonymousClass4(String str) {
            createCacheId = str;
        }

        @Override // androidx.core.util.Consumer
        public void accept(TypefaceResult typefaceResult) {
            synchronized (FontRequestWorker.LOCK) {
                try {
                    SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                    ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(createCacheId);
                    if (arrayList == null) {
                        return;
                    }
                    simpleArrayMap.remove(createCacheId);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        arrayList.get(i10).accept(typefaceResult);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(@NonNull FontRequest fontRequest, int i10) {
        return fontRequest.getId() + "-" + i10;
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i10 = 1;
        if (fontFamilyResult.getStatusCode() != 0) {
            return fontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts != null && fonts.length != 0) {
            i10 = 0;
            for (FontsContractCompat.FontInfo fontInfo : fonts) {
                int resultCode = fontInfo.getResultCode();
                if (resultCode != 0) {
                    if (resultCode < 0) {
                        return -3;
                    }
                    return resultCode;
                }
            }
        }
        return i10;
    }

    @NonNull
    public static TypefaceResult getFontSync(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i10) {
        LruCache<String, Typeface> lruCache = sTypefaceCache;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i10);
            if (createFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, createFromFontInfo);
            return new TypefaceResult(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    public static Typeface requestFontAsync(@NonNull Context context, @NonNull FontRequest fontRequest, int i10, @Nullable Executor executor, @NonNull CallbackWithHandler callbackWithHandler) {
        String createCacheId = createCacheId(fontRequest, i10);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        AnonymousClass2 anonymousClass2 = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            public AnonymousClass2() {
            }

            @Override // androidx.core.util.Consumer
            public void accept(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    typefaceResult = new TypefaceResult(-3);
                }
                CallbackWithHandler.this.onTypefaceResult(typefaceResult);
            }
        };
        synchronized (LOCK) {
            try {
                SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = PENDING_REPLIES;
                ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(createCacheId);
                if (arrayList != null) {
                    arrayList.add(anonymousClass2);
                    return null;
                }
                ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
                arrayList2.add(anonymousClass2);
                simpleArrayMap.put(createCacheId, arrayList2);
                AnonymousClass3 anonymousClass3 = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ String val$id;
                    final /* synthetic */ FontRequest val$request;
                    final /* synthetic */ int val$style;

                    public AnonymousClass3(String createCacheId2, Context context2, FontRequest fontRequest2, int i102) {
                        createCacheId = createCacheId2;
                        context = context2;
                        fontRequest = fontRequest2;
                        i10 = i102;
                    }

                    @Override // java.util.concurrent.Callable
                    public TypefaceResult call() {
                        try {
                            return FontRequestWorker.getFontSync(createCacheId, context, fontRequest, i10);
                        } catch (Throwable unused) {
                            return new TypefaceResult(-3);
                        }
                    }
                };
                if (executor == null) {
                    executor = DEFAULT_EXECUTOR_SERVICE;
                }
                RequestExecutor.execute(executor, anonymousClass3, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                    final /* synthetic */ String val$id;

                    public AnonymousClass4(String createCacheId2) {
                        createCacheId = createCacheId2;
                    }

                    @Override // androidx.core.util.Consumer
                    public void accept(TypefaceResult typefaceResult) {
                        synchronized (FontRequestWorker.LOCK) {
                            try {
                                SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap2 = FontRequestWorker.PENDING_REPLIES;
                                ArrayList<Consumer<TypefaceResult>> arrayList3 = simpleArrayMap2.get(createCacheId);
                                if (arrayList3 == null) {
                                    return;
                                }
                                simpleArrayMap2.remove(createCacheId);
                                for (int i102 = 0; i102 < arrayList3.size(); i102++) {
                                    arrayList3.get(i102).accept(typefaceResult);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                });
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Typeface requestFontSync(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, int i10, int i11) {
        String createCacheId = createCacheId(fontRequest, i10);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (i11 == -1) {
            TypefaceResult fontSync = getFontSync(createCacheId, context, fontRequest, i10);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                final /* synthetic */ Context val$context;
                final /* synthetic */ String val$id;
                final /* synthetic */ FontRequest val$request;
                final /* synthetic */ int val$style;

                public AnonymousClass1(String createCacheId2, Context context2, FontRequest fontRequest2, int i102) {
                    createCacheId = createCacheId2;
                    context = context2;
                    fontRequest = fontRequest2;
                    i10 = i102;
                }

                @Override // java.util.concurrent.Callable
                public TypefaceResult call() {
                    return FontRequestWorker.getFontSync(createCacheId, context, fontRequest, i10);
                }
            }, i11);
            callbackWithHandler.onTypefaceResult(typefaceResult);
            return typefaceResult.mTypeface;
        } catch (InterruptedException unused) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        public TypefaceResult(int i10) {
            this.mTypeface = null;
            this.mResult = i10;
        }

        @SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            return this.mResult == 0;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(@NonNull Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
