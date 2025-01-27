package com.ss.android.downloadlib.zx;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.martian.mibook.application.MiConfigSingleton;
import com.ss.android.download.api.config.v;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: com.ss.android.downloadlib.zx.j$1 */
    static class AnonymousClass1 implements g {

        /* renamed from: j */
        final /* synthetic */ JSONObject f24390j;
        final /* synthetic */ com.ss.android.downloadad.api.j.j zx;

        AnonymousClass1(JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
            jSONObject = jSONObject;
            jVar = jVar;
        }

        @Override // com.ss.android.downloadlib.zx.g
        public void j(boolean z) {
            com.ss.android.downloadlib.g.j.j().zx(z ? "deeplink_success" : "deeplink_failed", jSONObject, jVar);
            if (z) {
                com.ss.android.downloadlib.addownload.pa.gm().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar.hm(), jVar.z(), jVar.f(), jVar.q(), 0);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.zx.j$2 */
    static class AnonymousClass2 implements g {

        /* renamed from: j */
        final /* synthetic */ JSONObject f24391j;
        final /* synthetic */ com.ss.android.downloadad.api.j.j zx;

        AnonymousClass2(JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
            jSONObject = jSONObject;
            jVar = jVar;
        }

        @Override // com.ss.android.downloadlib.zx.g
        public void j(boolean z) {
            com.ss.android.downloadlib.g.j.j().zx(z ? "deeplink_success" : "deeplink_failed", jSONObject, jVar);
            if (z) {
                com.ss.android.downloadlib.addownload.pa.gm().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar.hm(), jVar.z(), jVar.f(), jVar.q(), 0);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.zx.j$3 */
    static class AnonymousClass3 implements g {

        /* renamed from: i */
        final /* synthetic */ JSONObject f24392i;

        /* renamed from: j */
        final /* synthetic */ String f24393j;
        final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q zx;

        AnonymousClass3(String str, com.ss.android.downloadlib.addownload.zx.q qVar, JSONObject jSONObject) {
            str = str;
            qVar = qVar;
            jSONObject = jSONObject;
        }

        @Override // com.ss.android.downloadlib.zx.g
        public void j(boolean z) {
            if (!z && !"open_market".equals(str)) {
                j.j(com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + qVar.q())), qVar, false);
            }
            com.ss.android.downloadlib.g.j.j().j(z ? "market_delay_success" : "market_delay_failed", jSONObject, qVar);
            if (z) {
                v gm = com.ss.android.downloadlib.addownload.pa.gm();
                Context context = com.ss.android.downloadlib.addownload.pa.getContext();
                com.ss.android.downloadlib.addownload.zx.q qVar = qVar;
                DownloadModel downloadModel = qVar.zx;
                gm.j(context, downloadModel, qVar.f24238g, qVar.f24239i, downloadModel.getPackageName(), 2);
            }
        }
    }

    public static boolean j(@NonNull com.ss.android.downloadlib.addownload.zx.q qVar) {
        boolean z;
        DeepLink deepLink = qVar.zx.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject j2 = com.ss.android.downloadlib.lg.gv.j(new JSONObject(), qVar);
        nt.j(j2, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.g.j.j().zx("applink_click", j2, qVar);
        com.ss.android.downloadlib.addownload.zx.lg j3 = com.ss.android.downloadlib.lg.k.j(openUrl, qVar);
        if (j3.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                zx("by_url", j3, j2, qVar);
            }
            j3 = com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), qVar.zx.getPackageName(), qVar);
        }
        boolean z2 = false;
        if (j(qVar.f24240j) && com.ss.android.downloadlib.addownload.pa.k().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = qVar.zx;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.g.j.j().j(qVar.f24240j, 0);
            z = true;
        } else {
            z = false;
        }
        int type = j3.getType();
        if (type == 1) {
            zx("by_url", j2, qVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.q.i.j().zx("AppLinkClick default");
                } else {
                    j("by_package", j3, j2, qVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.g.i.j().zx() && !com.ss.android.downloadlib.g.i.j().zx(qVar.f24240j, qVar.zx.getLogExtra())) || com.ss.android.downloadlib.g.i.j().i())) {
                    com.ss.android.downloadlib.g.j.j().j(qVar.f24240j, 2);
                }
                return z2;
            }
            j("by_package", j2, qVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.g.j.j().j(qVar.f24240j, 2);
        }
        return z2;
    }

    public static void zx(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        String gv = DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 ? zxVar.gv() : null;
        JSONObject j2 = com.ss.android.downloadlib.lg.gv.j(new JSONObject(), zxVar);
        nt.j(j2, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.g.j.j().zx("applink_click", j2, zxVar);
        com.ss.android.downloadlib.addownload.zx.lg j3 = com.ss.android.downloadlib.lg.k.j(gv, zxVar);
        if (j3.getType() == 2) {
            if (!TextUtils.isEmpty(gv)) {
                zx("dialog_by_url", j3, j2, zxVar);
            }
            j3 = com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), zxVar.q(), zxVar);
        }
        int type = j3.getType();
        if (type == 1) {
            zx("dialog_by_url", j2, zxVar);
            return;
        }
        if (type == 3) {
            j("dialog_by_package", j2, zxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.q.i.j().zx("AppLinkClickDialog default");
        } else {
            j("dialog_by_package", j3, j2, zxVar);
        }
    }

    public static void zx(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, "applink_source", str);
        nt.j(jSONObject, "download_scene", Integer.valueOf(jVar.gm()));
        com.ss.android.downloadlib.g.j.j().zx("deeplink_url_open", jSONObject, jVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((com.ss.android.downloadlib.addownload.pa.k().optInt("check_applink_mode") & 1) != 0) {
                    nt.j(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    q.j().j(new g() { // from class: com.ss.android.downloadlib.zx.j.2

                        /* renamed from: j */
                        final /* synthetic */ JSONObject f24391j;
                        final /* synthetic */ com.ss.android.downloadad.api.j.j zx;

                        AnonymousClass2(JSONObject jSONObject2, com.ss.android.downloadad.api.j.j jVar2) {
                            jSONObject = jSONObject2;
                            jVar = jVar2;
                        }

                        @Override // com.ss.android.downloadlib.zx.g
                        public void j(boolean z) {
                            com.ss.android.downloadlib.g.j.j().zx(z ? "deeplink_success" : "deeplink_failed", jSONObject, jVar);
                            if (z) {
                                com.ss.android.downloadlib.addownload.pa.gm().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar.hm(), jVar.z(), jVar.f(), jVar.q(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    com.ss.android.downloadlib.addownload.pa.zx().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar2.hm(), jVar2.z(), jVar2.f(), jVar2.q(), str);
                    break;
                }
        }
    }

    public static void j(@NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        String gv = zxVar.gv();
        JSONObject j2 = com.ss.android.downloadlib.lg.gv.j(new JSONObject(), zxVar);
        nt.j(j2, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.g.j.j().zx("applink_click", j2, zxVar);
        com.ss.android.downloadlib.addownload.zx.lg j3 = com.ss.android.downloadlib.lg.k.j(gv, zxVar);
        if (j3.getType() == 2) {
            if (!TextUtils.isEmpty(gv)) {
                zx("notify_by_url", j3, j2, zxVar);
            }
            j3 = com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), zxVar.q(), zxVar);
        }
        int type = j3.getType();
        if (type == 1) {
            zx("notify_by_url", j2, zxVar);
            return;
        }
        if (type == 3) {
            j("notify_by_package", j2, zxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.q.i.j().zx("AppLinkClickNotification default");
        } else {
            j("notify_by_package", j3, j2, zxVar);
        }
    }

    public static void zx(String str, @NonNull com.ss.android.downloadlib.addownload.zx.lg lgVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, "applink_source", str);
        nt.j(jSONObject, "error_code", Integer.valueOf(lgVar.j()));
        nt.j(jSONObject, "download_scene", Integer.valueOf(jVar.gm()));
        com.ss.android.downloadlib.g.j.j().zx("deeplink_url_open_fail", jSONObject, jVar);
    }

    public static boolean j(String str, @NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        if (!com.ss.android.downloadlib.addownload.y.zx(zxVar.bl())) {
            return false;
        }
        if (TextUtils.isEmpty(zxVar.gv()) && TextUtils.isEmpty(str)) {
            return false;
        }
        DownloadNotificationManager.getInstance().cancelNotification(zxVar.v());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.lg.gv.j(jSONObject, zxVar);
        nt.j(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.g.j.j().zx("applink_click", zxVar);
        com.ss.android.downloadlib.addownload.zx.lg j2 = com.ss.android.downloadlib.lg.k.j(zxVar, zxVar.gv(), zxVar.q());
        int type = j2.getType();
        if (type == 1) {
            zx("auto_by_url", jSONObject, zxVar);
            return true;
        }
        if (type == 2) {
            zx("auto_by_url", j2, jSONObject, zxVar);
            return false;
        }
        if (type == 3) {
            j("auto_by_package", jSONObject, zxVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        j("auto_by_package", j2, jSONObject, zxVar);
        return false;
    }

    public static void j(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, "applink_source", str);
        nt.j(jSONObject, "download_scene", Integer.valueOf(jVar.gm()));
        com.ss.android.downloadlib.g.j.j().zx("deeplink_app_open", jSONObject, jVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((com.ss.android.downloadlib.addownload.pa.k().optInt("check_applink_mode") & 1) != 0) {
                    nt.j(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    q.j().j(new g() { // from class: com.ss.android.downloadlib.zx.j.1

                        /* renamed from: j */
                        final /* synthetic */ JSONObject f24390j;
                        final /* synthetic */ com.ss.android.downloadad.api.j.j zx;

                        AnonymousClass1(JSONObject jSONObject2, com.ss.android.downloadad.api.j.j jVar2) {
                            jSONObject = jSONObject2;
                            jVar = jVar2;
                        }

                        @Override // com.ss.android.downloadlib.zx.g
                        public void j(boolean z) {
                            com.ss.android.downloadlib.g.j.j().zx(z ? "deeplink_success" : "deeplink_failed", jSONObject, jVar);
                            if (z) {
                                com.ss.android.downloadlib.addownload.pa.gm().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar.hm(), jVar.z(), jVar.f(), jVar.q(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    com.ss.android.downloadlib.addownload.pa.zx().j(com.ss.android.downloadlib.addownload.pa.getContext(), jVar2.hm(), jVar2.z(), jVar2.f(), jVar2.q(), str);
                    break;
                }
        }
    }

    public static void j(String str, @NonNull com.ss.android.downloadlib.addownload.zx.lg lgVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, "applink_source", str);
        nt.j(jSONObject, "error_code", Integer.valueOf(lgVar.j()));
        nt.j(jSONObject, "download_scene", Integer.valueOf(jVar.gm()));
        com.ss.android.downloadlib.g.j.j().zx("deeplink_app_open_fail", jSONObject, jVar);
    }

    public static boolean j(@NonNull com.ss.android.downloadlib.addownload.zx.q qVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "download_scene", Integer.valueOf(qVar.gm()));
        com.ss.android.downloadlib.g.j.j().zx("market_click_open", jSONObject, qVar);
        com.ss.android.downloadlib.addownload.zx.lg j2 = com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), qVar, qVar.zx.getPackageName());
        String j3 = nt.j(j2.zx(), "open_market");
        int type = j2.getType();
        if (type == 5) {
            j(j3, jSONObject, qVar, true);
        } else {
            if (type == 6) {
                nt.j(jSONObject, "error_code", Integer.valueOf(j2.j()));
                nt.j(jSONObject, "download_scene", Integer.valueOf(qVar.gm()));
                com.ss.android.downloadlib.g.j.j().zx("market_open_failed", jSONObject, qVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.g.j.j().j(qVar.f24240j, i2);
        return true;
    }

    public static void j(String str, @Nullable JSONObject jSONObject, com.ss.android.downloadlib.addownload.zx.q qVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                com.ss.android.downloadlib.q.i.j().j(e2, "onMarketSuccess");
                return;
            }
        }
        nt.j(jSONObject, "applink_source", str);
        nt.j(jSONObject, "download_scene", Integer.valueOf(qVar.gm()));
        if (z) {
            com.ss.android.downloadlib.g.j.j().zx("market_open_success", jSONObject, qVar);
        }
        if ((com.ss.android.downloadlib.addownload.pa.k().optInt("check_applink_mode") & 4) != 0) {
            q.j().zx(new g() { // from class: com.ss.android.downloadlib.zx.j.3

                /* renamed from: i */
                final /* synthetic */ JSONObject f24392i;

                /* renamed from: j */
                final /* synthetic */ String f24393j;
                final /* synthetic */ com.ss.android.downloadlib.addownload.zx.q zx;

                AnonymousClass3(String str2, com.ss.android.downloadlib.addownload.zx.q qVar2, JSONObject jSONObject2) {
                    str = str2;
                    qVar = qVar2;
                    jSONObject = jSONObject2;
                }

                @Override // com.ss.android.downloadlib.zx.g
                public void j(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        j.j(com.ss.android.downloadlib.lg.k.j(com.ss.android.downloadlib.addownload.pa.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + qVar.q())), qVar, false);
                    }
                    com.ss.android.downloadlib.g.j.j().j(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, qVar);
                    if (z2) {
                        v gm = com.ss.android.downloadlib.addownload.pa.gm();
                        Context context = com.ss.android.downloadlib.addownload.pa.getContext();
                        com.ss.android.downloadlib.addownload.zx.q qVar2 = qVar;
                        DownloadModel downloadModel = qVar2.zx;
                        gm.j(context, downloadModel, qVar2.f24238g, qVar2.f24239i, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.i zx = com.ss.android.downloadlib.addownload.pa.zx();
            Context context = com.ss.android.downloadlib.addownload.pa.getContext();
            DownloadModel downloadModel = qVar2.zx;
            zx.j(context, downloadModel, qVar2.f24238g, qVar2.f24239i, downloadModel.getPackageName(), str2);
        }
        com.ss.android.downloadad.api.j.zx zxVar = new com.ss.android.downloadad.api.j.zx(qVar2.zx, qVar2.f24239i, qVar2.f24238g);
        zxVar.q(2);
        zxVar.gv(System.currentTimeMillis());
        zxVar.y(4);
        zxVar.k(2);
        com.ss.android.downloadlib.addownload.zx.gv.j().j(zxVar);
    }

    public static void j(com.ss.android.downloadlib.addownload.zx.lg lgVar, com.ss.android.downloadlib.addownload.zx.q qVar, boolean z) {
        String j2 = nt.j(lgVar.zx(), "open_market");
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "ttdownloader_type", MiConfigSingleton.v0);
        int type = lgVar.getType();
        if (type == 5) {
            j(j2, jSONObject, qVar, z);
        } else {
            if (type != 6) {
                return;
            }
            nt.j(jSONObject, "error_code", Integer.valueOf(lgVar.j()));
            nt.j(jSONObject, "download_scene", Integer.valueOf(qVar.gm()));
            com.ss.android.downloadlib.g.j.j().zx("market_open_failed", jSONObject, qVar);
        }
    }

    public static boolean j(long j2) {
        return com.ss.android.downloadlib.addownload.zx.gv.j().g(j2) == null;
    }
}
