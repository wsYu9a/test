package com.ss.android.downloadlib.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.martian.mibook.application.MiConfigSingleton;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f21526a = "a";

    /* renamed from: com.ss.android.downloadlib.b.a$1 */
    public static class AnonymousClass1 implements d {

        /* renamed from: a */
        final /* synthetic */ JSONObject f21527a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.a f21528b;

        public AnonymousClass1(JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
            jSONObject = jSONObject;
            aVar = aVar;
        }

        @Override // com.ss.android.downloadlib.b.d
        public void a(boolean z10) {
            com.ss.android.downloadlib.d.a.a().b(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
            if (z10) {
                k.v().a(k.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.b.a$2 */
    public static class AnonymousClass2 implements d {

        /* renamed from: a */
        final /* synthetic */ JSONObject f21529a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.a f21530b;

        public AnonymousClass2(JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
            jSONObject = jSONObject;
            aVar = aVar;
        }

        @Override // com.ss.android.downloadlib.b.d
        public void a(boolean z10) {
            com.ss.android.downloadlib.d.a.a().b(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
            if (z10) {
                k.v().a(k.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.b.a$3 */
    public static class AnonymousClass3 implements d {

        /* renamed from: a */
        final /* synthetic */ String f21531a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21532b;

        /* renamed from: c */
        final /* synthetic */ JSONObject f21533c;

        public AnonymousClass3(String str, com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject) {
            str = str;
            eVar = eVar;
            jSONObject = jSONObject;
        }

        @Override // com.ss.android.downloadlib.b.d
        public void a(boolean z10) {
            if (!z10 && !PointCategory.OPEN_MARKET.equals(str)) {
                a.a(com.ss.android.downloadlib.g.i.a(k.a(), Uri.parse("market://details?id=" + eVar.e())), eVar, false);
            }
            com.ss.android.downloadlib.d.a.a().a(z10 ? "market_delay_success" : "market_delay_failed", jSONObject, eVar);
            if (z10) {
                s v10 = k.v();
                Context a10 = k.a();
                com.ss.android.downloadlib.addownload.b.e eVar = eVar;
                DownloadModel downloadModel = eVar.f21217b;
                v10.a(a10, downloadModel, eVar.f21219d, eVar.f21218c, downloadModel.getPackageName(), 2);
            }
        }
    }

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        boolean z10;
        DeepLink deepLink = eVar.f21217b.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject a10 = com.ss.android.downloadlib.g.f.a(new JSONObject(), eVar);
        m.a(a10, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a10, eVar);
        com.ss.android.downloadlib.addownload.b.g a11 = com.ss.android.downloadlib.g.i.a(openUrl, eVar);
        if (a11.a() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                b("by_url", a11, a10, eVar);
            }
            a11 = com.ss.android.downloadlib.g.i.a(k.a(), eVar.f21217b.getPackageName(), eVar);
        }
        boolean z11 = false;
        if (a(eVar.f21216a) && k.j().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = eVar.f21217b;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.d.a.a().a(eVar.f21216a, 0);
            z10 = true;
        } else {
            z10 = false;
        }
        int a12 = a11.a();
        if (a12 == 1) {
            b("by_url", a10, eVar);
        } else {
            if (a12 != 3) {
                if (a12 != 4) {
                    com.ss.android.downloadlib.e.c.a().b("AppLinkClick default");
                } else {
                    a("by_package", a11, a10, eVar);
                }
                if (z11 && !z10 && ((com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(eVar.f21216a, eVar.f21217b.getLogExtra())) || com.ss.android.downloadlib.d.c.a().c())) {
                    com.ss.android.downloadlib.d.a.a().a(eVar.f21216a, 2);
                }
                return z11;
            }
            a("by_package", a10, eVar);
        }
        z11 = true;
        if (z11) {
            com.ss.android.downloadlib.d.a.a().a(eVar.f21216a, 2);
        }
        return z11;
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String f10 = DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 ? bVar.f() : null;
        JSONObject a10 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        m.a(a10, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a10, bVar);
        com.ss.android.downloadlib.addownload.b.g a11 = com.ss.android.downloadlib.g.i.a(f10, bVar);
        if (a11.a() == 2) {
            if (!TextUtils.isEmpty(f10)) {
                b("dialog_by_url", a11, a10, bVar);
            }
            a11 = com.ss.android.downloadlib.g.i.a(k.a(), bVar.e(), bVar);
        }
        int a12 = a11.a();
        if (a12 == 1) {
            b("dialog_by_url", a10, bVar);
            return;
        }
        if (a12 == 3) {
            a("dialog_by_package", a10, bVar);
        } else if (a12 != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickDialog default");
        } else {
            a("dialog_by_package", a11, a10, bVar);
        }
    }

    public static void b(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open", jSONObject, aVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((k.j().optInt("check_applink_mode") & 1) != 0) {
                    m.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.2

                        /* renamed from: a */
                        final /* synthetic */ JSONObject f21529a;

                        /* renamed from: b */
                        final /* synthetic */ com.ss.android.downloadad.api.a.a f21530b;

                        public AnonymousClass2(JSONObject jSONObject2, com.ss.android.downloadad.api.a.a aVar2) {
                            jSONObject = jSONObject2;
                            aVar = aVar2;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z10) {
                            com.ss.android.downloadlib.d.a.a().b(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z10) {
                                k.v().a(k.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    k.c().a(k.a(), aVar2.u(), aVar2.w(), aVar2.v(), aVar2.e(), str);
                    break;
                }
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        String f10 = bVar.f();
        JSONObject a10 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        m.a(a10, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a10, bVar);
        com.ss.android.downloadlib.addownload.b.g a11 = com.ss.android.downloadlib.g.i.a(f10, bVar);
        if (a11.a() == 2) {
            if (!TextUtils.isEmpty(f10)) {
                b("notify_by_url", a11, a10, bVar);
            }
            a11 = com.ss.android.downloadlib.g.i.a(k.a(), bVar.e(), bVar);
        }
        int a12 = a11.a();
        if (a12 == 1) {
            b("notify_by_url", a10, bVar);
            return;
        }
        if (a12 == 3) {
            a("notify_by_package", a10, bVar);
        } else if (a12 != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickNotification default");
        } else {
            a("notify_by_package", a11, a10, bVar);
        }
    }

    public static void b(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open_fail", jSONObject, aVar);
    }

    public static boolean a(String str, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        if (!com.ss.android.downloadlib.addownload.i.b(bVar.O())) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
            return false;
        }
        DownloadNotificationManager.getInstance().cancelNotification(bVar.s());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.g.f.a(jSONObject, bVar);
        m.a(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.d.a.a().b("applink_click", bVar);
        com.ss.android.downloadlib.addownload.b.g a10 = com.ss.android.downloadlib.g.i.a(bVar, bVar.f(), bVar.e());
        int a11 = a10.a();
        if (a11 == 1) {
            b("auto_by_url", jSONObject, bVar);
            return true;
        }
        if (a11 == 2) {
            b("auto_by_url", a10, jSONObject, bVar);
            return false;
        }
        if (a11 == 3) {
            a("auto_by_package", jSONObject, bVar);
            return true;
        }
        if (a11 != 4) {
            return false;
        }
        a("auto_by_package", a10, jSONObject, bVar);
        return false;
    }

    public static void a(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open", jSONObject, aVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((k.j().optInt("check_applink_mode") & 1) != 0) {
                    m.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.1

                        /* renamed from: a */
                        final /* synthetic */ JSONObject f21527a;

                        /* renamed from: b */
                        final /* synthetic */ com.ss.android.downloadad.api.a.a f21528b;

                        public AnonymousClass1(JSONObject jSONObject2, com.ss.android.downloadad.api.a.a aVar2) {
                            jSONObject = jSONObject2;
                            aVar = aVar2;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z10) {
                            com.ss.android.downloadlib.d.a.a().b(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z10) {
                                k.v().a(k.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    k.c().a(k.a(), aVar2.u(), aVar2.w(), aVar2.v(), aVar2.e(), str);
                    break;
                }
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open_fail", jSONObject, aVar);
    }

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, int i10) {
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g a10 = com.ss.android.downloadlib.g.i.a(k.a(), eVar, eVar.f21217b.getPackageName());
        String a11 = m.a(a10.c(), PointCategory.OPEN_MARKET);
        int a12 = a10.a();
        if (a12 == 5) {
            a(a11, jSONObject, eVar, true);
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
        com.ss.android.downloadlib.d.a.a().a(eVar.f21216a, i10);
        return true;
    }

    public static void a(String str, @Nullable JSONObject jSONObject, com.ss.android.downloadlib.addownload.b.e eVar, boolean z10) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e10) {
                com.ss.android.downloadlib.e.c.a().a(e10, "onMarketSuccess");
                return;
            }
        }
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        if (z10) {
            com.ss.android.downloadlib.d.a.a().b("market_open_success", jSONObject, eVar);
        }
        if ((k.j().optInt("check_applink_mode") & 4) != 0) {
            e.a().b(new d() { // from class: com.ss.android.downloadlib.b.a.3

                /* renamed from: a */
                final /* synthetic */ String f21531a;

                /* renamed from: b */
                final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21532b;

                /* renamed from: c */
                final /* synthetic */ JSONObject f21533c;

                public AnonymousClass3(String str2, com.ss.android.downloadlib.addownload.b.e eVar2, JSONObject jSONObject2) {
                    str = str2;
                    eVar = eVar2;
                    jSONObject = jSONObject2;
                }

                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z102) {
                    if (!z102 && !PointCategory.OPEN_MARKET.equals(str)) {
                        a.a(com.ss.android.downloadlib.g.i.a(k.a(), Uri.parse("market://details?id=" + eVar.e())), eVar, false);
                    }
                    com.ss.android.downloadlib.d.a.a().a(z102 ? "market_delay_success" : "market_delay_failed", jSONObject, eVar);
                    if (z102) {
                        s v10 = k.v();
                        Context a10 = k.a();
                        com.ss.android.downloadlib.addownload.b.e eVar2 = eVar;
                        DownloadModel downloadModel = eVar2.f21217b;
                        v10.a(a10, downloadModel, eVar2.f21219d, eVar2.f21218c, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.c c10 = k.c();
            Context a10 = k.a();
            DownloadModel downloadModel = eVar2.f21217b;
            c10.a(a10, downloadModel, eVar2.f21219d, eVar2.f21218c, downloadModel.getPackageName(), str2);
        }
        com.ss.android.downloadad.api.a.b a11 = com.ss.android.downloadlib.addownload.b.f.a().a(eVar2.f21217b.getPackageName());
        if (a11 != null) {
            l.a().a(f21526a, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            l.a().a(f21526a, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            a11 = new com.ss.android.downloadad.api.a.b(eVar2.f21217b, eVar2.f21218c, eVar2.f21219d);
        }
        a11.e(2);
        a11.f(System.currentTimeMillis());
        a11.h(4);
        a11.i(2);
        com.ss.android.downloadlib.addownload.b.f.a().a(a11);
        l.a().a(f21526a, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.h.a().a(eVar2, a11);
    }

    public static void a(com.ss.android.downloadlib.addownload.b.g gVar, com.ss.android.downloadlib.addownload.b.e eVar, boolean z10) {
        String a10 = m.a(gVar.c(), PointCategory.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "ttdownloader_type", MiConfigSingleton.Q0);
        int a11 = gVar.a();
        if (a11 == 5) {
            a(a10, jSONObject, eVar, z10);
        } else {
            if (a11 != 6) {
                return;
            }
            m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
            m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
            com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
        }
    }

    public static boolean a(long j10) {
        return com.ss.android.downloadlib.addownload.b.f.a().d(j10) == null;
    }
}
