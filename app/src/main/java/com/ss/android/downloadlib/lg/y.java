package com.ss.android.downloadlib.lg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.authjs.a;
import com.cdo.oaps.ad.OapsKey;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: com.ss.android.downloadlib.lg.y$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24337i;

        /* renamed from: j */
        final /* synthetic */ String f24338j;
        final /* synthetic */ Context zx;

        /* renamed from: com.ss.android.downloadlib.lg.y$1$1 */
        class C05021 implements e {

            /* renamed from: i */
            final /* synthetic */ String f24340i;

            /* renamed from: j */
            final /* synthetic */ JSONObject f24341j;
            final /* synthetic */ JSONObject zx;

            C05021(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                jSONObject = jSONObject;
                k = jSONObject2;
                optString = str;
            }

            @Override // com.ss.android.download.api.config.e
            public void j(String str) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                y.zx(context, str, str, qVar, jSONObject, k, optString);
            }

            @Override // com.ss.android.download.api.config.e
            public void j(Throwable th) {
                com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                y.zx(qVar, jSONObject, 4, 1, BaseConstants.MARKET_PREFIX + str);
            }
        }

        AnonymousClass1(String str, Context context, com.ss.android.downloadlib.addownload.zx.q qVar) {
            str = str;
            context = context;
            qVar = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
            String optString = k.optString("s");
            JSONObject jSONObject = new JSONObject();
            String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("x"), optString);
            JSONObject jSONObject2 = new JSONObject();
            nt.j(jSONObject2, "p", str);
            nt.j(jSONObject2, "i", Build.VERSION.INCREMENTAL);
            nt.j(jSONObject2, "m", Build.MODEL);
            nt.j(jSONObject2, "im", com.ss.android.downloadlib.j.j.zx.j(context));
            nt.j(jSONObject2, "d", com.ss.android.downloadlib.j.j.zx.zx(context));
            nt.j(jSONObject2, "t", "m");
            byte[] bytes = jSONObject2.toString().getBytes();
            com.ss.android.downloadlib.addownload.pa.g().j(j2, com.ss.android.downloadlib.addownload.pa.ei().j(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new e() { // from class: com.ss.android.downloadlib.lg.y.1.1

                /* renamed from: i */
                final /* synthetic */ String f24340i;

                /* renamed from: j */
                final /* synthetic */ JSONObject f24341j;
                final /* synthetic */ JSONObject zx;

                C05021(JSONObject jSONObject3, JSONObject k2, String optString2) {
                    jSONObject = jSONObject3;
                    k = k2;
                    optString = optString2;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    y.zx(context, str, str, qVar, jSONObject, k, optString);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                    nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    y.zx(qVar, jSONObject, 4, 1, BaseConstants.MARKET_PREFIX + str);
                }
            });
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg.y$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24342i;

        /* renamed from: j */
        final /* synthetic */ Context f24343j;
        final /* synthetic */ String zx;

        AnonymousClass2(Context context, String str, com.ss.android.downloadlib.addownload.zx.q qVar) {
            context = context;
            str = str;
            qVar = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
                Thread.sleep(k.optInt("m2_delay_millis", 1000));
                com.ss.android.downloadlib.j.zx.j.j().j(context, true);
                com.ss.android.downloadlib.j.zx.zx zxVar = new com.ss.android.downloadlib.j.zx.zx();
                zxVar.f24313j = 1;
                zxVar.zx = 0;
                String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("v"), k.optString("s"));
                zxVar.f24312i = String.format(j2, str);
                com.ss.android.downloadlib.j.zx.j.j().j(zxVar, (com.ss.android.downloadlib.j.zx.g) null);
                com.ss.android.downloadlib.j.zx.j.j().zx();
                y.zx(qVar, jSONObject, -1, 2, String.format(j2, str));
            } catch (Throwable th) {
                th.printStackTrace();
                y.zx(qVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg.y$3 */
    static class AnonymousClass3 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24344i;

        /* renamed from: j */
        final /* synthetic */ String f24345j;
        final /* synthetic */ Context zx;

        /* renamed from: com.ss.android.downloadlib.lg.y$3$1 */
        class AnonymousClass1 implements e {

            /* renamed from: j */
            final /* synthetic */ JSONObject f24346j;

            AnonymousClass1(JSONObject jSONObject) {
                jSONObject = jSONObject;
            }

            @Override // com.ss.android.download.api.config.e
            public void j(String str) {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                y.zx(context, str, str, qVar, jSONObject);
            }

            @Override // com.ss.android.download.api.config.e
            public void j(Throwable th) {
                com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                y.zx(qVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
            }
        }

        AnonymousClass3(String str, Context context, com.ss.android.downloadlib.addownload.zx.q qVar) {
            str = str;
            context = context;
            qVar = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
            String optString = k.optString("s");
            JSONObject jSONObject = new JSONObject();
            String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("x"), optString);
            JSONObject jSONObject2 = new JSONObject();
            nt.j(jSONObject2, "t", "v");
            nt.j(jSONObject2, "p", str);
            byte[] bytes = jSONObject2.toString().getBytes();
            com.ss.android.downloadlib.addownload.pa.g().j(j2, com.ss.android.downloadlib.addownload.pa.ei().j(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new e() { // from class: com.ss.android.downloadlib.lg.y.3.1

                /* renamed from: j */
                final /* synthetic */ JSONObject f24346j;

                AnonymousClass1(JSONObject jSONObject3) {
                    jSONObject = jSONObject3;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str) {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    y.zx(context, str, str, qVar, jSONObject);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                    nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    y.zx(qVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                }
            });
        }
    }

    private static com.ss.android.downloadlib.addownload.zx.lg g(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.zx.lg(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.zx.lg(6, 14);
        }
    }

    private static com.ss.android.downloadlib.addownload.zx.lg i(Context context, com.ss.android.downloadlib.addownload.zx.q qVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("p", str);
        intent.putExtra("id", qVar.f24240j);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.zx.lg(7, "am_kllk2");
        } catch (Throwable unused) {
            zx(qVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    private static boolean q(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pa.getContext();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String k = com.ss.android.socialbase.appdownloader.gv.q.k();
        if (nt.g(com.ss.android.downloadlib.addownload.pa.getContext(), k)) {
            intent.setPackage(k);
        }
        if (!nt.j(com.ss.android.downloadlib.addownload.pa.getContext(), intent)) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void zx(Context context, com.ss.android.downloadlib.addownload.zx.q qVar, String str) {
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.lg.y.1

            /* renamed from: i */
            final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24337i;

            /* renamed from: j */
            final /* synthetic */ String f24338j;
            final /* synthetic */ Context zx;

            /* renamed from: com.ss.android.downloadlib.lg.y$1$1 */
            class C05021 implements e {

                /* renamed from: i */
                final /* synthetic */ String f24340i;

                /* renamed from: j */
                final /* synthetic */ JSONObject f24341j;
                final /* synthetic */ JSONObject zx;

                C05021(JSONObject jSONObject3, JSONObject k2, String optString2) {
                    jSONObject = jSONObject3;
                    k = k2;
                    optString = optString2;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    y.zx(context, str, str, qVar, jSONObject, k, optString);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                    nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    y.zx(qVar, jSONObject, 4, 1, BaseConstants.MARKET_PREFIX + str);
                }
            }

            AnonymousClass1(String str2, Context context2, com.ss.android.downloadlib.addownload.zx.q qVar2) {
                str = str2;
                context = context2;
                qVar = qVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject k2 = com.ss.android.downloadlib.addownload.pa.k();
                String optString2 = k2.optString("s");
                JSONObject jSONObject3 = new JSONObject();
                String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k2.optString("x"), optString2);
                JSONObject jSONObject2 = new JSONObject();
                nt.j(jSONObject2, "p", str);
                nt.j(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                nt.j(jSONObject2, "m", Build.MODEL);
                nt.j(jSONObject2, "im", com.ss.android.downloadlib.j.j.zx.j(context));
                nt.j(jSONObject2, "d", com.ss.android.downloadlib.j.j.zx.zx(context));
                nt.j(jSONObject2, "t", "m");
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.pa.g().j(j2, com.ss.android.downloadlib.addownload.pa.ei().j(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new e() { // from class: com.ss.android.downloadlib.lg.y.1.1

                    /* renamed from: i */
                    final /* synthetic */ String f24340i;

                    /* renamed from: j */
                    final /* synthetic */ JSONObject f24341j;
                    final /* synthetic */ JSONObject zx;

                    C05021(JSONObject jSONObject32, JSONObject k22, String optString22) {
                        jSONObject = jSONObject32;
                        k = k22;
                        optString = optString22;
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(String str2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        y.zx(context, str, str2, qVar, jSONObject, k, optString);
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(Throwable th) {
                        com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                        nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        y.zx(qVar, jSONObject, 4, 1, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    public static void zx(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.zx.q qVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
        nt.j(jSONObject, "ttdownloader_type", (Object) 1);
        try {
            String j2 = j(com.ss.android.socialbase.appdownloader.gv.i.j(new JSONObject(str2).optString("a")), jSONObject2, str3);
            nt.j(jSONObject, "open_url", j2);
            if (q(context, j2)) {
                zx(qVar, jSONObject, -1, 1, j2);
                com.ss.android.downloadlib.zx.j.j("am_m1", jSONObject, qVar, true);
            } else {
                com.ss.android.downloadlib.zx.j.j(j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                zx(qVar, jSONObject, 2, 1, BaseConstants.MARKET_PREFIX + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.zx.j.j(j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
            zx(qVar, jSONObject, 3, 1, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static com.ss.android.downloadlib.addownload.zx.lg j(Context context, Uri uri) {
        if (context != null && uri != null && BaseConstants.SCHEME_MARKET.equals(uri.getScheme())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!nt.j(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.zx.lg(6, 13);
                }
                String k = com.ss.android.socialbase.appdownloader.gv.q.k();
                if (nt.g(context, k) && !com.ss.android.socialbase.appdownloader.gv.q.gv()) {
                    intent.setPackage(k);
                }
                if (DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                }
                if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                    com.ss.android.downloadlib.q.i.j().j(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.zx.lg(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.zx.lg(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.zx.lg(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.zx.lg(6, 12);
    }

    private static void g(Context context, com.ss.android.downloadlib.addownload.zx.q qVar, String str) {
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.lg.y.2

            /* renamed from: i */
            final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24342i;

            /* renamed from: j */
            final /* synthetic */ Context f24343j;
            final /* synthetic */ String zx;

            AnonymousClass2(Context context2, String str2, com.ss.android.downloadlib.addownload.zx.q qVar2) {
                context = context2;
                str = str2;
                qVar = qVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
                    Thread.sleep(k.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.j.zx.j.j().j(context, true);
                    com.ss.android.downloadlib.j.zx.zx zxVar = new com.ss.android.downloadlib.j.zx.zx();
                    zxVar.f24313j = 1;
                    zxVar.zx = 0;
                    String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("v"), k.optString("s"));
                    zxVar.f24312i = String.format(j2, str);
                    com.ss.android.downloadlib.j.zx.j.j().j(zxVar, (com.ss.android.downloadlib.j.zx.g) null);
                    com.ss.android.downloadlib.j.zx.j.j().zx();
                    y.zx(qVar, jSONObject, -1, 2, String.format(j2, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    y.zx(qVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    static boolean i(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("open_url", str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void q(Context context, com.ss.android.downloadlib.addownload.zx.q qVar, String str) {
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.lg.y.3

            /* renamed from: i */
            final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q f24344i;

            /* renamed from: j */
            final /* synthetic */ String f24345j;
            final /* synthetic */ Context zx;

            /* renamed from: com.ss.android.downloadlib.lg.y$3$1 */
            class AnonymousClass1 implements e {

                /* renamed from: j */
                final /* synthetic */ JSONObject f24346j;

                AnonymousClass1(JSONObject jSONObject3) {
                    jSONObject = jSONObject3;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str) {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    y.zx(context, str, str, qVar, jSONObject);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                    nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                    y.zx(qVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                }
            }

            AnonymousClass3(String str2, Context context2, com.ss.android.downloadlib.addownload.zx.q qVar2) {
                str = str2;
                context = context2;
                qVar = qVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
                String optString = k.optString("s");
                JSONObject jSONObject3 = new JSONObject();
                String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                nt.j(jSONObject2, "t", "v");
                nt.j(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.pa.g().j(j2, com.ss.android.downloadlib.addownload.pa.ei().j(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new e() { // from class: com.ss.android.downloadlib.lg.y.3.1

                    /* renamed from: j */
                    final /* synthetic */ JSONObject f24346j;

                    AnonymousClass1(JSONObject jSONObject32) {
                        jSONObject = jSONObject32;
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(String str2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        y.zx(context, str, str2, qVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(Throwable th) {
                        com.ss.android.downloadlib.zx.j.j(y.j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                        nt.j(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        y.zx(qVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    public static void zx(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.zx.q qVar, @NonNull JSONObject jSONObject) {
        nt.j(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(j2)) {
                TTDelegateActivity.j(str, qVar.f24240j, j2, jSONObject);
            } else {
                com.ss.android.downloadlib.zx.j.j(j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
                zx(qVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.zx.j.j(j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), qVar, true);
            zx(qVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static com.ss.android.downloadlib.addownload.zx.lg j(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.gv.q.gv() && nt.g(context, "com.sec.android.app.samsungapps")) {
                return g(context, str);
            }
            return j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.zx.lg(6, 11);
    }

    public static void zx(com.ss.android.downloadlib.addownload.zx.q qVar, JSONObject jSONObject, int i2, int i3, String str) {
        nt.j(jSONObject, "error_code", Integer.valueOf(i2));
        nt.j(jSONObject, "ttdownloader_type", Integer.valueOf(i3));
        nt.j(jSONObject, "rmu", str);
        nt.j(jSONObject, com.ss.android.socialbase.appdownloader.gv.q.k(), Integer.valueOf(nt.zx(com.ss.android.downloadlib.addownload.pa.getContext(), com.ss.android.socialbase.appdownloader.gv.q.k())));
        com.ss.android.downloadlib.g.j.j().zx("am_result", jSONObject, qVar);
    }

    public static com.ss.android.downloadlib.addownload.zx.lg j(Context context, com.ss.android.downloadlib.addownload.zx.q qVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.gv.q.gv() && nt.g(context, "com.sec.android.app.samsungapps")) {
                return g(context, str);
            }
            if (qVar.zx.isAd() && qVar.f24238g.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.pa.k().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.gv.q.zx() && com.ss.android.socialbase.appdownloader.gv.j.j(optJSONArray, "am_0")) {
                    zx(context, qVar, str);
                    return new com.ss.android.downloadlib.addownload.zx.lg(7, "am_m1");
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.g() && com.ss.android.socialbase.appdownloader.gv.j.j(optJSONArray, "am_3")) {
                    return i(context, qVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.q() && com.ss.android.socialbase.appdownloader.gv.j.j(optJSONArray, "am_2")) {
                    g(context, qVar, str);
                    return new com.ss.android.downloadlib.addownload.zx.lg(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.zx() && com.ss.android.socialbase.appdownloader.gv.j.j(optJSONArray, "am_6")) {
                    return j(context, j(qVar));
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.i() && com.ss.android.socialbase.appdownloader.gv.j.j(optJSONArray, "am_5")) {
                    q(context, qVar, str);
                    return new com.ss.android.downloadlib.addownload.zx.lg(7, "am_v1");
                }
                return j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
            return j(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.zx.lg(6, 11);
    }

    static com.ss.android.downloadlib.addownload.zx.lg zx(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.zx.lg(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pa.getContext();
        }
        Intent gv = nt.gv(context, str);
        if (gv == null) {
            return new com.ss.android.downloadlib.addownload.zx.lg(4, 22);
        }
        gv.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(gv);
            return new com.ss.android.downloadlib.addownload.zx.lg(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.zx.lg(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.zx.lg zx(String str, @NonNull com.ss.android.downloadad.api.j.j jVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.zx.lg(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.pa.getContext();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("open_url", str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (nt.zx(context, intent)) {
            if (com.ss.android.downloadlib.addownload.pa.k().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.pa.t() != null && com.ss.android.downloadlib.addownload.pa.t().j() && Build.VERSION.SDK_INT >= 26 && jVar.ei()) {
                TTDelegateActivity.j(str, jVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.pa.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.zx.lg(2);
                }
            }
            return new com.ss.android.downloadlib.addownload.zx.lg(1);
        }
        return new com.ss.android.downloadlib.addownload.zx.lg(2, 24);
    }

    private static String j(String str, @NonNull JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(jSONObject.optString(OapsKey.KEY_GRADE), str2);
        String j3 = com.ss.android.socialbase.appdownloader.gv.i.j(jSONObject.optString("h"), str2);
        return (TextUtils.isEmpty(j2) || TextUtils.isEmpty(j3)) ? str : str.replace(j2, j3);
    }

    public static void j(Context context, String str, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.zx.q q = com.ss.android.downloadlib.addownload.zx.gv.j().q(j2);
        try {
            JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
            String optString = k.optString("s");
            String j3 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("aa"), optString);
            String j4 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString(OapsKey.KEY_ACTIVE_CODE), optString);
            String j5 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("af"), optString);
            boolean j6 = com.ss.android.socialbase.appdownloader.gv.j.j(k, context, j4);
            StringBuilder sb = new StringBuilder(String.format(j3, str, j5, j4));
            Intent intent = new Intent("android.intent.action.VIEW");
            String k2 = com.ss.android.socialbase.appdownloader.gv.q.k();
            if (nt.g(context, k2)) {
                intent.setPackage(k2);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            nt.j(jSONObject, "mf", Boolean.valueOf(j6));
            nt.j(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.zx.j.j("am_kllk2", jSONObject, q, true);
            if (j6) {
                zx(q, jSONObject, -1, 3, sb.toString());
            } else {
                zx(q, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.zx.j.j(j(com.ss.android.downloadlib.addownload.pa.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), q, true);
            zx(q, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean j(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra(a.f5379f, hashMap);
        String k = com.ss.android.socialbase.appdownloader.gv.q.k();
        if (nt.g(com.ss.android.downloadlib.addownload.pa.getContext(), k)) {
            intent.setPackage(k);
        }
        if (!nt.j(com.ss.android.downloadlib.addownload.pa.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.q.i.j().j(e2, "start v1");
            return false;
        }
    }

    public static void j(@NonNull Activity activity, String str, long j2, String str2, String str3) {
        JSONObject jSONObject;
        int i2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.zx.q q = com.ss.android.downloadlib.addownload.zx.gv.j().q(j2);
        try {
            JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
            boolean j3 = com.ss.android.socialbase.appdownloader.gv.j.j(k, activity, com.ss.android.socialbase.appdownloader.gv.i.j(k.optString(OapsKey.KEY_BG), k.optString("s")));
            HashMap<String, String> zx = nt.zx(new JSONObject(str2));
            if (j3 && !zx.isEmpty() && j(activity, str, zx)) {
                zx(q, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.zx.j.j("am_v1", jSONObject, q, true);
                return;
            }
            if (j3) {
                i2 = zx.isEmpty() ? 1 : 2;
            } else {
                i2 = 3;
            }
            zx(q, jSONObject, i2, 5, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.zx.j.j(j(activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), q, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.zx.j.j(j(com.ss.android.downloadlib.addownload.pa.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), q, true);
            zx(q, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    static com.ss.android.downloadlib.addownload.zx.lg j(Context context, String str, com.ss.android.downloadad.api.j.j jVar) {
        Intent gv = nt.gv(context, str);
        if (gv == null) {
            return new com.ss.android.downloadlib.addownload.zx.lg(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.pa.k().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.pa.t() != null && com.ss.android.downloadlib.addownload.pa.t().j() && jVar.ei()) {
            TTDelegateActivity.zx(str, jVar);
            return new com.ss.android.downloadlib.addownload.zx.lg(3);
        }
        gv.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(gv);
            return new com.ss.android.downloadlib.addownload.zx.lg(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.zx.lg(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.zx.lg j(String str, com.ss.android.downloadad.api.j.j jVar) {
        return j(com.ss.android.downloadlib.addownload.pa.getContext(), str, jVar);
    }

    static com.ss.android.downloadlib.addownload.zx.lg j(@NonNull com.ss.android.downloadad.api.j.zx zxVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.zx.lg zx = zx(str, zxVar);
        return (com.ss.android.downloadlib.zx.gv.j(zxVar) && zx.getType() == 2) ? j(str2, zxVar) : zx;
    }

    public static Uri j(com.ss.android.downloadlib.addownload.zx.q qVar) {
        String q = qVar.q();
        Uri.Builder builder = new Uri.Builder();
        JSONObject jSONObject = new JSONObject();
        JSONObject k = com.ss.android.downloadlib.addownload.pa.k();
        String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("bl"), k.optString("s"));
        builder.scheme(BaseConstants.SCHEME_MARKET).authority("details").appendQueryParameter("id", q);
        if (!TextUtils.isEmpty(j2)) {
            builder.appendPath(j2);
        }
        Uri build = builder.build();
        zx(qVar, jSONObject, -1, 6, build.toString());
        return build;
    }
}
