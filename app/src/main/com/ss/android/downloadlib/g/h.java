package com.ss.android.downloadlib.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private static final String f21648a = "h";

    /* renamed from: com.ss.android.downloadlib.g.h$1 */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.k.d().a(8, com.ss.android.downloadlib.addownload.k.a(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21649a;

        /* renamed from: b */
        final /* synthetic */ Intent f21650b;

        public AnonymousClass2(Context context, Intent intent) {
            context = context;
            intent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            context.startActivity(intent);
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$3 */
    public static class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.k.d().a(12, com.ss.android.downloadlib.addownload.k.a(), null, "正在前往浏览器下载", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21651a;

        /* renamed from: b */
        final /* synthetic */ Intent f21652b;

        public AnonymousClass4(Context context, Intent intent) {
            context = context;
            intent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            context.startActivity(intent);
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$5 */
    public static class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21653a;

        /* renamed from: b */
        final /* synthetic */ String f21654b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21655c;

        public AnonymousClass5(Context context, String str, com.ss.android.downloadlib.addownload.b.e eVar) {
            context = context;
            str = str;
            eVar = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
                Thread.sleep(j10.optInt("m2_delay_millis", 1000));
                com.ss.android.downloadlib.a.a.a.a().a(context, true);
                com.ss.android.downloadlib.a.a.b bVar = new com.ss.android.downloadlib.a.a.b();
                bVar.f21114a = 1;
                bVar.f21115b = 0;
                String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("v"), j10.optString("s"));
                bVar.f21116c = String.format(a10, str);
                com.ss.android.downloadlib.a.a.a.a().a(bVar, (com.ss.android.downloadlib.a.a.d) null);
                com.ss.android.downloadlib.a.a.a.a().b();
                h.b(eVar, jSONObject, -1, 2, String.format(a10, str));
            } catch (Throwable th2) {
                th2.printStackTrace();
                h.b(eVar, jSONObject, 1, 2, "market://details?id=" + str);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$7 */
    public static class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21661a;

        /* renamed from: b */
        final /* synthetic */ Context f21662b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21663c;

        /* renamed from: com.ss.android.downloadlib.g.h$7$1 */
        public class AnonymousClass1 implements r {

            /* renamed from: a */
            final /* synthetic */ JSONObject f21664a;

            public AnonymousClass1(JSONObject jSONObject) {
                jSONObject = jSONObject;
            }

            @Override // com.ss.android.download.api.config.r
            public void a(String str) {
                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                h.b(context, str, str, eVar, jSONObject);
            }

            @Override // com.ss.android.download.api.config.r
            public void a(Throwable th2) {
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                h.b(eVar, jSONObject, 7, 5, "market://details?id=" + str);
            }
        }

        public AnonymousClass7(String str, Context context, com.ss.android.downloadlib.addownload.b.e eVar) {
            str = str;
            context = context;
            eVar = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
            String optString = j10.optString("s");
            JSONObject jSONObject = new JSONObject();
            String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("x"), optString);
            JSONObject jSONObject2 = new JSONObject();
            m.a(jSONObject2, bt.aO, "v");
            m.a(jSONObject2, "p", str);
            byte[] bytes = jSONObject2.toString().getBytes();
            com.ss.android.downloadlib.addownload.k.e().a(a10, com.ss.android.downloadlib.addownload.k.s().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new r() { // from class: com.ss.android.downloadlib.g.h.7.1

                /* renamed from: a */
                final /* synthetic */ JSONObject f21664a;

                public AnonymousClass1(JSONObject jSONObject3) {
                    jSONObject = jSONObject3;
                }

                @Override // com.ss.android.download.api.config.r
                public void a(String str) {
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    h.b(context, str, str, eVar, jSONObject);
                }

                @Override // com.ss.android.download.api.config.r
                public void a(Throwable th2) {
                    com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                    m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                    h.b(eVar, jSONObject, 7, 5, "market://details?id=" + str);
                }
            });
        }
    }

    private static void c(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(context, str, eVar.f21216a);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            b(eVar, jSONObject, 14, 11, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g d(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 14);
        }
    }

    private static void e(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.5

            /* renamed from: a */
            final /* synthetic */ Context f21653a;

            /* renamed from: b */
            final /* synthetic */ String f21654b;

            /* renamed from: c */
            final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21655c;

            public AnonymousClass5(Context context2, String str2, com.ss.android.downloadlib.addownload.b.e eVar2) {
                context = context2;
                str = str2;
                eVar = eVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
                    Thread.sleep(j10.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.a.a.a.a().a(context, true);
                    com.ss.android.downloadlib.a.a.b bVar = new com.ss.android.downloadlib.a.a.b();
                    bVar.f21114a = 1;
                    bVar.f21115b = 0;
                    String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("v"), j10.optString("s"));
                    bVar.f21116c = String.format(a10, str);
                    com.ss.android.downloadlib.a.a.a.a().a(bVar, (com.ss.android.downloadlib.a.a.d) null);
                    com.ss.android.downloadlib.a.a.a.a().b();
                    h.b(eVar, jSONObject, -1, 2, String.format(a10, str));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    h.b(eVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    private static void f(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.6

            /* renamed from: a */
            final /* synthetic */ String f21656a;

            /* renamed from: b */
            final /* synthetic */ Context f21657b;

            /* renamed from: c */
            final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21658c;

            public AnonymousClass6(String str2, Context context2, com.ss.android.downloadlib.addownload.b.e eVar2) {
                str = str2;
                context = context2;
                eVar = eVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
                JSONObject jSONObject = new JSONObject();
                try {
                    String optString = j10.optString("s");
                    String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("bw"), optString);
                    String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("bx"), optString);
                    String a12 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(a10).appendPath(a11).appendQueryParameter(a12, str);
                    com.ss.android.downloadlib.addownload.k.e().a("GET", builder.build().toString(), null, new r() { // from class: com.ss.android.downloadlib.g.h.6.1

                        /* renamed from: a */
                        final /* synthetic */ JSONObject f21659a;

                        public AnonymousClass1(JSONObject jSONObject2) {
                            jSONObject = jSONObject2;
                        }

                        @Override // com.ss.android.download.api.config.r
                        public void a(String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                String c10 = h.c(str2);
                                if (!TextUtils.isEmpty(c10)) {
                                    String d10 = h.d(c10);
                                    if (!TextUtils.isEmpty(d10)) {
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        h.b(context, eVar, str, d10);
                                        return;
                                    }
                                }
                            }
                            com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                            h.b(eVar, jSONObject, 10, 9, "market://details?id=" + str);
                        }

                        @Override // com.ss.android.download.api.config.r
                        public void a(Throwable th2) {
                            com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                            m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                            h.b(eVar, jSONObject, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e10) {
                    e10.printStackTrace();
                    h.b(eVar, jSONObject2, 4, 9, "market://details?id=" + str);
                }
            }

            /* renamed from: com.ss.android.downloadlib.g.h$6$1 */
            public class AnonymousClass1 implements r {

                /* renamed from: a */
                final /* synthetic */ JSONObject f21659a;

                public AnonymousClass1(JSONObject jSONObject2) {
                    jSONObject = jSONObject2;
                }

                @Override // com.ss.android.download.api.config.r
                public void a(String str2) {
                    if (!TextUtils.isEmpty(str2)) {
                        String c10 = h.c(str2);
                        if (!TextUtils.isEmpty(c10)) {
                            String d10 = h.d(c10);
                            if (!TextUtils.isEmpty(d10)) {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                h.b(context, eVar, str, d10);
                                return;
                            }
                        }
                    }
                    com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                    h.b(eVar, jSONObject, 10, 9, "market://details?id=" + str);
                }

                @Override // com.ss.android.download.api.config.r
                public void a(Throwable th2) {
                    com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                    m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                    h.b(eVar, jSONObject, 11, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static void g(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(str, eVar.f21216a);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            b(eVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void h(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.7

            /* renamed from: a */
            final /* synthetic */ String f21661a;

            /* renamed from: b */
            final /* synthetic */ Context f21662b;

            /* renamed from: c */
            final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21663c;

            /* renamed from: com.ss.android.downloadlib.g.h$7$1 */
            public class AnonymousClass1 implements r {

                /* renamed from: a */
                final /* synthetic */ JSONObject f21664a;

                public AnonymousClass1(JSONObject jSONObject3) {
                    jSONObject = jSONObject3;
                }

                @Override // com.ss.android.download.api.config.r
                public void a(String str) {
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    h.b(context, str, str, eVar, jSONObject);
                }

                @Override // com.ss.android.download.api.config.r
                public void a(Throwable th2) {
                    com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                    m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                    h.b(eVar, jSONObject, 7, 5, "market://details?id=" + str);
                }
            }

            public AnonymousClass7(String str2, Context context2, com.ss.android.downloadlib.addownload.b.e eVar2) {
                str = str2;
                context = context2;
                eVar = eVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
                String optString = j10.optString("s");
                JSONObject jSONObject3 = new JSONObject();
                String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                m.a(jSONObject2, bt.aO, "v");
                m.a(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.k.e().a(a10, com.ss.android.downloadlib.addownload.k.s().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new r() { // from class: com.ss.android.downloadlib.g.h.7.1

                    /* renamed from: a */
                    final /* synthetic */ JSONObject f21664a;

                    public AnonymousClass1(JSONObject jSONObject32) {
                        jSONObject = jSONObject32;
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        h.b(context, str, str2, eVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(Throwable th2) {
                        com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                        m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                        h.b(eVar, jSONObject, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static void i(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(str, eVar.f21216a, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            b(eVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g b(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", eVar.f21216a);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk2");
        } catch (Throwable unused) {
            b(eVar, jSONObject, 1, 3, "market://details?id=" + str);
            return a(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.f.e.c() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 12);
        }
        try {
            String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
            if (com.ss.android.socialbase.appdownloader.f.e.q() && (TextUtils.isEmpty(j10) || !m.e(context, j10))) {
                j10 = "com.huawei.appmarket";
                Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!m.a(context, intent)) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 13);
            }
            if (m.e(context, j10) && !com.ss.android.socialbase.appdownloader.f.e.g()) {
                intent.setPackage(j10);
            }
            if (DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.e.c.a().a(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.b.g(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 14);
        }
    }

    public static boolean c(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j10)) {
            intent.setPackage(j10);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "start HM2");
            return false;
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.h$6 */
    public static class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21656a;

        /* renamed from: b */
        final /* synthetic */ Context f21657b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21658c;

        public AnonymousClass6(String str2, Context context2, com.ss.android.downloadlib.addownload.b.e eVar2) {
            str = str2;
            context = context2;
            eVar = eVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject j10 = com.ss.android.downloadlib.addownload.k.j();
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = j10.optString("s");
                String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("bw"), optString);
                String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("bx"), optString);
                String a12 = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("by"), optString);
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https").authority(a10).appendPath(a11).appendQueryParameter(a12, str);
                com.ss.android.downloadlib.addownload.k.e().a("GET", builder.build().toString(), null, new r() { // from class: com.ss.android.downloadlib.g.h.6.1

                    /* renamed from: a */
                    final /* synthetic */ JSONObject f21659a;

                    public AnonymousClass1(JSONObject jSONObject22) {
                        jSONObject = jSONObject22;
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            String c10 = h.c(str2);
                            if (!TextUtils.isEmpty(c10)) {
                                String d10 = h.d(c10);
                                if (!TextUtils.isEmpty(d10)) {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    h.b(context, eVar, str, d10);
                                    return;
                                }
                            }
                        }
                        com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                        h.b(eVar, jSONObject, 10, 9, "market://details?id=" + str);
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(Throwable th2) {
                        com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                        m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                        h.b(eVar, jSONObject, 11, 9, "market://details?id=" + str);
                    }
                });
            } catch (Exception e10) {
                e10.printStackTrace();
                h.b(eVar, jSONObject22, 4, 9, "market://details?id=" + str);
            }
        }

        /* renamed from: com.ss.android.downloadlib.g.h$6$1 */
        public class AnonymousClass1 implements r {

            /* renamed from: a */
            final /* synthetic */ JSONObject f21659a;

            public AnonymousClass1(JSONObject jSONObject22) {
                jSONObject = jSONObject22;
            }

            @Override // com.ss.android.download.api.config.r
            public void a(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    String c10 = h.c(str2);
                    if (!TextUtils.isEmpty(c10)) {
                        String d10 = h.d(c10);
                        if (!TextUtils.isEmpty(d10)) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            h.b(context, eVar, str, d10);
                            return;
                        }
                    }
                }
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                h.b(eVar, jSONObject, 10, 9, "market://details?id=" + str);
            }

            @Override // com.ss.android.download.api.config.r
            public void a(Throwable th2) {
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                m.a(jSONObject, "ttdownloader_message", th2 != null ? th2.getMessage() : "null");
                h.b(eVar, jSONObject, 11, 9, "market://details?id=" + str);
            }
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g d(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", eVar.f21216a);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (m.e(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (m.e(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return a(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk3");
        } catch (Throwable unused) {
            b(eVar, jSONObject, 1, 3, "market://details?id=" + str);
            return a(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject) {
        m.a(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String a10 = com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(a10)) {
                TTDelegateActivity.a(str, eVar.f21216a, a10, jSONObject);
            } else {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
                b(eVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            b(eVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean b(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j10)) {
            intent.setPackage(j10);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "start HM1");
            return false;
        }
    }

    public static String c(String str) {
        String str2;
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        if (matcher.find()) {
            str2 = matcher.group();
        } else {
            str2 = "";
        }
        if (!str2.equals(null) && str2.length() > 0) {
            for (String str3 : str2.split("\\n")) {
                if (str3.startsWith("<input")) {
                    for (String str4 : str3.split("\\s")) {
                        if (str4.startsWith("value")) {
                            return str4.substring(7, str4.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadad.api.a.b bVar;
        if (context != null && com.ss.android.downloadlib.b.j.a(uri)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!m.a(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.b.g(6, 13);
                }
                String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
                if (m.e(context, j10)) {
                    intent.setPackage(j10);
                }
                intent.addFlags(335544320);
                if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.k.k().f20981c)) {
                    com.ss.android.downloadlib.e.c.a().a(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.b.g(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && eVar != null && (bVar = eVar.f21220e) != null && !bVar.ae()) {
                    com.ss.android.downloadlib.g.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.g.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.k.d().a(8, com.ss.android.downloadlib.addownload.k.a(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.2

                    /* renamed from: a */
                    final /* synthetic */ Context f21649a;

                    /* renamed from: b */
                    final /* synthetic */ Intent f21650b;

                    public AnonymousClass2(Context context2, Intent intent2) {
                        context = context2;
                        intent = intent2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new com.ss.android.downloadlib.addownload.b.g(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 12);
    }

    public static String d(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    public static void b(com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject, int i10, int i11, String str) {
        m.a(jSONObject, "error_code", Integer.valueOf(i10));
        m.a(jSONObject, "ttdownloader_type", Integer.valueOf(i11));
        m.a(jSONObject, "rmu", str);
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j(), Integer.valueOf(m.b(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j())));
        com.ss.android.downloadlib.d.a.a().b("am_result", jSONObject, eVar);
    }

    public static com.ss.android.downloadlib.addownload.b.g b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        Intent g10 = m.g(context, str);
        if (g10 == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        g10.putExtra("start_only_for_android", true);
        try {
            context.startActivity(g10);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent intent;
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(2, 21);
        }
        Context a10 = com.ss.android.downloadlib.addownload.k.a();
        String packageName = aVar.u().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            intent = null;
        } else {
            l.a().a(f21648a, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            intent = a(a10, aVar, packageName, 2, str);
            if (intent != null) {
                com.ss.android.downloadlib.addownload.b.g a11 = a(a10, intent, aVar, true, str);
                if (a11.a() == 1) {
                    return a11;
                }
            }
        }
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra("start_only_for_android", true);
        if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        return a(a10, intent, aVar, false, str);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.e.g() && m.e(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            return a(context, com.ss.android.download.api.c.a.a(str));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.e.g() && m.e(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            if (eVar.f21217b.isAd() && eVar.f21219d.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.k.j().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.f.e.e() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_3")) {
                    return b(context, eVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.f.e.f() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_2")) {
                    e(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.f.e.d() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_5")) {
                    h(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.f.e.e() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_7")) {
                    DownloadController downloadController = eVar.f21219d;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return d(context, eVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.f.e.d() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_8") && m.a(m.c(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                    i(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.f.e.a() || com.ss.android.socialbase.appdownloader.f.e.b()) && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_9")) {
                    f(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.f.e.a() || com.ss.android.socialbase.appdownloader.f.e.b()) && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_10")) {
                    g(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_hr2");
                }
                DownloadController downloadController2 = eVar.f21219d;
                if ((downloadController2 instanceof AdDownloadController) && ((AdDownloadController) downloadController2).enableOppoAutoDownload() && ((AdDownloadController) eVar.f21219d).getDownloadMarketInterceptor() != null && eVar.f21217b.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
                    c(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk4");
                }
                return a(context, Uri.parse("market://details?id=" + str));
            }
            return a(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    public static void b(Context context, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.b(str, eVar.f21216a, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar, true);
            b(eVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void b(@NonNull Activity activity, String str, long j10, String str2) {
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
        String optString = j11.optString("s");
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bz"), optString);
        String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("ca"), optString);
        String a12 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(a10)) {
            builder.appendQueryParameter(a10, str2);
        }
        if (!TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12)) {
            builder.appendQueryParameter(a11, a12);
        }
        if (b(activity, builder.build())) {
            b(e10, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.b.a.a("am_hr", jSONObject, e10, true);
            return;
        }
        b(e10, jSONObject, 2, 9, "market://details?id=" + str);
        com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse("market://details?id=" + str)), e10, true);
    }

    public static void b(@NonNull Activity activity, String str, long j10) {
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        JSONObject jSONObject = new JSONObject();
        boolean enableOppoAutoDownload = ((AdDownloadController) e10.f21219d).enableOppoAutoDownload();
        HashMap hashMap = new HashMap();
        hashMap.put("is_button", Boolean.valueOf(enableOppoAutoDownload));
        m.a(jSONObject, "is_button", Boolean.valueOf(enableOppoAutoDownload));
        Map<String, Object> interceptObmMarket = ((AdDownloadController) e10.f21219d).getDownloadMarketInterceptor().interceptObmMarket(hashMap);
        if (interceptObmMarket != null && interceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(interceptObmMarket.get("convert_result").toString())) {
            b(e10, jSONObject, -1, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.b.a.a("am_kllk4", jSONObject, e10, true);
            return;
        }
        b(e10, jSONObject, 15, 11, "market://details?id=" + str);
        com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse("market://details?id=" + str)), e10, true);
    }

    public static boolean a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str, JSONObject jSONObject, boolean z10, int i10) {
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g a10 = a(context, Uri.parse(str));
        String a11 = m.a(a10.c(), PointCategory.OPEN_MARKET);
        int a12 = a10.a();
        if (a12 == 5) {
            com.ss.android.downloadlib.b.a.a(a11, jSONObject, eVar, true);
        } else {
            if (a12 == 6) {
                m.a(jSONObject, "error_code", Integer.valueOf(a10.b()));
                m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            }
            if (a12 != 7) {
                return false;
            }
        }
        if (z10) {
            com.ss.android.downloadlib.d.a.a().a(eVar.f21216a, i10);
        }
        return true;
    }

    public static void a(Context context, String str, long j10, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        try {
            JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
            String optString = j11.optString("s");
            String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("aa"), optString);
            String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("ac"), optString);
            String a12 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("af"), optString);
            boolean a13 = com.ss.android.socialbase.appdownloader.f.a.a(j11, context, a11);
            StringBuilder sb2 = new StringBuilder(String.format(a10, str, a12, a11));
            Intent intent = new Intent("android.intent.action.VIEW");
            String j12 = com.ss.android.socialbase.appdownloader.f.e.j();
            if (m.e(context, j12)) {
                intent.setPackage(j12);
            }
            if (z10) {
                sb2.append(com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            m.a(jSONObject, "mf", Boolean.valueOf(a13));
            m.a(jSONObject, "if", Boolean.valueOf(z10));
            intent.setData(Uri.parse(sb2.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.b.a.a("am_kllk2", jSONObject, e10, true);
            if (a13) {
                b(e10, jSONObject, -1, 3, sb2.toString());
            } else {
                b(e10, jSONObject, 3, 3, sb2.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse("market://details?id=" + str)), e10, true);
            b(e10, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void a(Context context, String str, long j10, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        try {
            JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
            String optString = j11.optString("s");
            String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("br"), optString);
            String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bs_1"), optString);
            String a12 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bs_2"), optString);
            String a13 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bs_3"), optString);
            String a14 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bt"), optString);
            String a15 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bu"), optString);
            StringBuilder sb2 = new StringBuilder(String.format("https://", new Object[0]));
            sb2.append(a10);
            sb2.append(a11);
            sb2.append(a12);
            sb2.append(a13);
            sb2.append(a14);
            sb2.append(a15);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z10) {
                sb2.append("pkg=" + str);
                sb2.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            m.a(jSONObject, "dl", Boolean.valueOf(z10));
            intent.setData(Uri.parse(sb2.toString()));
            intent.putExtra("start_only_for_android", true);
            long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.g.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.g.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.k.d().a(12, com.ss.android.downloadlib.addownload.k.a(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.4

                /* renamed from: a */
                final /* synthetic */ Context f21651a;

                /* renamed from: b */
                final /* synthetic */ Intent f21652b;

                public AnonymousClass4(Context context2, Intent intent2) {
                    context = context2;
                    intent = intent2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            com.ss.android.downloadad.api.a.b bVar = e10.f21220e;
            if (bVar != null) {
                bVar.v(true);
            }
            com.ss.android.downloadlib.b.a.a("am_kllk3", jSONObject, e10, true);
            b(e10, jSONObject, -1, 7, sb2.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.a.b bVar2 = e10.f21220e;
            if (bVar2 != null) {
                bVar2.v(false);
            }
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse("market://details?id=" + str), e10), e10, true);
            b(e10, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean a(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", hashMap);
        String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j10)) {
            intent.setPackage(j10);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "start v1");
            return false;
        }
    }

    public static void a(@NonNull Activity activity, String str, long j10, String str2, String str3) {
        JSONObject jSONObject;
        int i10;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        try {
            JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
            boolean a10 = com.ss.android.socialbase.appdownloader.f.a.a(j11, activity, com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bg"), j11.optString("s")));
            HashMap<String, String> b10 = m.b(new JSONObject(str2));
            if (!a10 || b10.isEmpty() || !a(activity, str, b10)) {
                if (a10) {
                    i10 = b10.isEmpty() ? 1 : 2;
                } else {
                    i10 = 3;
                }
                b(e10, jSONObject, i10, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse("market://details?id=" + str)), e10, true);
                return;
            }
            b(e10, jSONObject, -1, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.b.a.a("am_v1", jSONObject, e10, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse("market://details?id=" + str)), e10, true);
            b(e10, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void a(@NonNull Activity activity, String str, long j10, String str2) {
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("bv"), j11.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(a10)) {
            builder.appendQueryParameter(a10, str2);
        }
        if (a(activity, builder.build())) {
            b(e10, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.b.a.a("am_v2", jSONObject, e10, true);
            return;
        }
        b(e10, jSONObject, 2, 8, "market://details?id=" + str);
        com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse("market://details?id=" + str)), e10, true);
    }

    public static boolean a(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String j10 = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j10)) {
            intent.setPackage(j10);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "start v2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent a10 = a(context, aVar, str, 1, (String) null);
        if (a10 != null) {
            l.a().a(f21648a, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.b.g a11 = a(a10, true, context, str, aVar);
            if (a11.a() == 3) {
                return a11;
            }
        }
        Intent g10 = m.g(context, str);
        if (g10 == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        return a(g10, false, context, str, aVar);
    }

    private static com.ss.android.downloadlib.addownload.b.g a(Intent intent, boolean z10, Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.k.j().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.k.m() != null && com.ss.android.downloadlib.addownload.k.m().a() && aVar.q() && !z10) {
            TTDelegateActivity.b(str, aVar);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        }
        intent.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception e10) {
            if (z10) {
                l.a().b(f21648a, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e10.getMessage());
                return new com.ss.android.downloadlib.addownload.b.g(8, 23);
            }
            l.a().b(f21648a, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e10.getMessage());
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(String str, com.ss.android.downloadad.api.a.a aVar) {
        return a(com.ss.android.downloadlib.addownload.k.a(), str, aVar);
    }

    private static com.ss.android.downloadlib.addownload.b.g a(Context context, Intent intent, com.ss.android.downloadad.api.a.a aVar, boolean z10, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        if (m.b(context, intent)) {
            if (com.ss.android.downloadlib.addownload.k.j().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.k.m() != null && com.ss.android.downloadlib.addownload.k.m().a() && Build.VERSION.SDK_INT >= 26 && aVar.q() && !z10) {
                TTDelegateActivity.a(str, aVar);
                return new com.ss.android.downloadlib.addownload.b.g(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.b.g(1);
            } catch (Exception e10) {
                if (z10) {
                    l.a().b(f21648a, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e10.getMessage());
                    return new com.ss.android.downloadlib.addownload.b.g(9);
                }
                l.a().b(f21648a, "realTryOpenByUrl", "url调起失败了，抛出异常" + e10.getMessage());
                return new com.ss.android.downloadlib.addownload.b.g(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.b.g(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(@NonNull com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.b.g b10 = b(str, bVar);
        return (com.ss.android.downloadlib.b.f.a(bVar) && b10.a() == 2) ? a(str2, bVar) : b10;
    }

    public static void a(@NonNull Activity activity, String str, long j10) {
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        JSONObject jSONObject = new JSONObject();
        JSONObject j11 = com.ss.android.downloadlib.addownload.k.j();
        String optString = j11.optString("s");
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString("ca"), optString);
        String a11 = com.ss.android.socialbase.appdownloader.f.c.a(j11.optString(com.umeng.ccg.a.f24224a), optString);
        StringBuilder sb2 = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11)) {
            sb2.append(str);
            sb2.append("&");
            sb2.append(a10);
            sb2.append("=");
            sb2.append(a11);
        }
        if (c(activity, Uri.parse(sb2.toString()))) {
            b(e10, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.b.a.a("am_hr2", jSONObject, e10, true);
            return;
        }
        b(e10, jSONObject, 2, 10, "market://details?id=" + str);
        com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse("market://details?id=" + str)), e10, true);
    }

    private static Intent a(Context context, com.ss.android.downloadad.api.a.a aVar, String str, int i10, String str2) {
        if (!aVar.c() || aVar.w() == null || aVar.w().getDownloadMode() != 2 || aVar.u() == null || e.a(aVar).optInt("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String c10 = com.ss.android.downloadlib.addownload.i.c(aVar.u());
        String d10 = com.ss.android.downloadlib.addownload.i.d(aVar.u());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(c10) || resolveActivity == null) {
            return null;
        }
        intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, c10);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(d10)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, d10);
        }
        if (i10 == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
