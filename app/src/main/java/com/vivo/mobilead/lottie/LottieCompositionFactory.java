package com.vivo.mobilead.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.vivo.mobilead.lottie.e.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$1 */
    static class AnonymousClass1 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ Context f28935a;

        /* renamed from: b */
        final /* synthetic */ String f28936b;

        AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return com.vivo.mobilead.lottie.d.c.a(context, str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$10 */
    static class AnonymousClass10 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ ZipInputStream f28937a;

        /* renamed from: b */
        final /* synthetic */ String f28938b;

        AnonymousClass10(ZipInputStream zipInputStream, String str) {
            zipInputStream = zipInputStream;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$11 */
    static class AnonymousClass11 implements Callable<h<LottieComposition>> {
        AnonymousClass11() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return new h<>(LottieComposition.this);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$2 */
    static class AnonymousClass2 implements LottieListener<LottieComposition> {

        /* renamed from: a */
        final /* synthetic */ String f28940a;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (str != null) {
                com.vivo.mobilead.lottie.c.g.a().a(str, lottieComposition);
            }
            LottieCompositionFactory.taskCache.remove(str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$3 */
    static class AnonymousClass3 implements LottieListener<Throwable> {

        /* renamed from: a */
        final /* synthetic */ String f28941a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            LottieCompositionFactory.taskCache.remove(str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$4 */
    static class AnonymousClass4 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ Context f28942a;

        /* renamed from: b */
        final /* synthetic */ String f28943b;

        AnonymousClass4(Context context, String str) {
            applicationContext = context;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromAssetSync(applicationContext, str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$5 */
    static class AnonymousClass5 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ Context f28944a;

        /* renamed from: b */
        final /* synthetic */ int f28945b;

        AnonymousClass5(Context context, int i2) {
            applicationContext = context;
            i2 = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromRawResSync(applicationContext, i2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$6 */
    static class AnonymousClass6 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ InputStream f28946a;

        /* renamed from: b */
        final /* synthetic */ String f28947b;

        AnonymousClass6(InputStream inputStream, String str) {
            inputStream = inputStream;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$7 */
    static class AnonymousClass7 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ JSONObject f28948a;

        /* renamed from: b */
        final /* synthetic */ String f28949b;

        AnonymousClass7(JSONObject jSONObject, String str) {
            jSONObject = jSONObject;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonSync(jSONObject, str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$8 */
    static class AnonymousClass8 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ String f28950a;

        /* renamed from: b */
        final /* synthetic */ String f28951b;

        AnonymousClass8(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonStringSync(str, str2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieCompositionFactory$9 */
    static class AnonymousClass9 implements Callable<h<LottieComposition>> {

        /* renamed from: a */
        final /* synthetic */ JsonReader f28952a;

        /* renamed from: b */
        final /* synthetic */ String f28953b;

        AnonymousClass9(JsonReader jsonReader, String str) {
            jsonReader = jsonReader;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str);
        }
    }

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(String str, Callable<h<LottieComposition>> callable) {
        LottieComposition a2 = str == null ? null : com.vivo.mobilead.lottie.c.g.a().a(str);
        if (a2 != null) {
            return new LottieTask<>(new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.11
                AnonymousClass11() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public h<LottieComposition> call() {
                    return new h<>(LottieComposition.this);
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        lottieTask.addListener(new LottieListener<LottieComposition>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.2

            /* renamed from: a */
            final /* synthetic */ String f28940a;

            AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                if (str != null) {
                    com.vivo.mobilead.lottie.c.g.a().a(str, lottieComposition);
                }
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        lottieTask.addFailureListener(new LottieListener<Throwable>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.3

            /* renamed from: a */
            final /* synthetic */ String f28941a;

            AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        taskCache.put(str2, lottieTask);
        return lottieTask;
    }

    private static d findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (d dVar : lottieComposition.getImages().values()) {
            if (dVar.d().equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return cache(str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.4

            /* renamed from: a */
            final /* synthetic */ Context f28942a;

            /* renamed from: b */
            final /* synthetic */ String f28943b;

            AnonymousClass4(Context context2, String str2) {
                applicationContext = context2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str);
            }
        });
    }

    public static h<LottieComposition> fromAssetSync(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2) : fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new h<>((Throwable) e2);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, String str) {
        return cache(str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.7

            /* renamed from: a */
            final /* synthetic */ JSONObject f28948a;

            /* renamed from: b */
            final /* synthetic */ String f28949b;

            AnonymousClass7(JSONObject jSONObject2, String str2) {
                jSONObject = jSONObject2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        });
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, String str) {
        return cache(str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.6

            /* renamed from: a */
            final /* synthetic */ InputStream f28946a;

            /* renamed from: b */
            final /* synthetic */ String f28947b;

            AnonymousClass6(InputStream inputStream2, String str2) {
                inputStream = inputStream2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static h<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    private static h<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.vivo.mobilead.lottie.f.h.a(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, String str) {
        return cache(str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.9

            /* renamed from: a */
            final /* synthetic */ JsonReader f28952a;

            /* renamed from: b */
            final /* synthetic */ String f28953b;

            AnonymousClass9(JsonReader jsonReader2, String str2) {
                jsonReader = jsonReader2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str);
            }
        });
    }

    public static h<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static h<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                LottieComposition a2 = t.a(jsonReader);
                com.vivo.mobilead.lottie.c.g.a().a(str, a2);
                h<LottieComposition> hVar = new h<>(a2);
                if (z) {
                    com.vivo.mobilead.lottie.f.h.a(jsonReader);
                }
                return hVar;
            } catch (Exception e2) {
                h<LottieComposition> hVar2 = new h<>(e2);
                if (z) {
                    com.vivo.mobilead.lottie.f.h.a(jsonReader);
                }
                return hVar2;
            }
        } catch (Throwable th) {
            if (z) {
                com.vivo.mobilead.lottie.f.h.a(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, String str2) {
        return cache(str2, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.8

            /* renamed from: a */
            final /* synthetic */ String f28950a;

            /* renamed from: b */
            final /* synthetic */ String f28951b;

            AnonymousClass8(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static h<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(new JsonReader(new StringReader(str)), str2);
    }

    @Deprecated
    public static h<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i2) {
        return cache(rawResCacheKey(i2), new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.5

            /* renamed from: a */
            final /* synthetic */ Context f28944a;

            /* renamed from: b */
            final /* synthetic */ int f28945b;

            AnonymousClass5(Context context2, int i22) {
                applicationContext = context2;
                i2 = i22;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromRawResSync(applicationContext, i2);
            }
        });
    }

    public static h<LottieComposition> fromRawResSync(Context context, int i2) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i2), rawResCacheKey(i2));
        } catch (Resources.NotFoundException e2) {
            return new h<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return cache("url_" + str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.1

            /* renamed from: a */
            final /* synthetic */ Context f28935a;

            /* renamed from: b */
            final /* synthetic */ String f28936b;

            AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return com.vivo.mobilead.lottie.d.c.a(context, str);
            }
        });
    }

    public static h<LottieComposition> fromUrlSync(Context context, String str) {
        return com.vivo.mobilead.lottie.d.c.a(context, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str) {
        return cache(str, new Callable<h<LottieComposition>>() { // from class: com.vivo.mobilead.lottie.LottieCompositionFactory.10

            /* renamed from: a */
            final /* synthetic */ ZipInputStream f28937a;

            /* renamed from: b */
            final /* synthetic */ String f28938b;

            AnonymousClass10(ZipInputStream zipInputStream2, String str2) {
                zipInputStream = zipInputStream2;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public h<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static h<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            com.vivo.mobilead.lottie.f.h.a(zipInputStream);
        }
    }

    private static h<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.contains("__MACOSX")) {
                    if (name.contains(".json")) {
                        lottieComposition = fromJsonReaderSyncInternal(new JsonReader(new InputStreamReader(zipInputStream)), null, false).a();
                    } else {
                        if (!name.contains(".png")) {
                            if (name.contains(".webp")) {
                            }
                        }
                        hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new h<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                d findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.a(com.vivo.mobilead.lottie.f.h.a((Bitmap) entry.getValue(), findImageAssetForFileName.a(), findImageAssetForFileName.b()));
                }
            }
            for (Map.Entry<String, d> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().e() == null) {
                    return new h<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().d()));
                }
            }
            com.vivo.mobilead.lottie.c.g.a().a(str, lottieComposition);
            return new h<>(lottieComposition);
        } catch (IOException e2) {
            return new h<>((Throwable) e2);
        }
    }

    private static String rawResCacheKey(int i2) {
        return "rawRes_" + i2;
    }

    public static void setMaxCacheSize(int i2) {
        com.vivo.mobilead.lottie.c.g.a().a(i2);
    }
}
