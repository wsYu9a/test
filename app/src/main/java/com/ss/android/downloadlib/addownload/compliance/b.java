package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.m;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private SoftReference<Activity> f21288a;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.b$1 */
    public class AnonymousClass1 implements c.a<Boolean, Object> {

        /* renamed from: a */
        final /* synthetic */ long f21289a;

        /* renamed from: b */
        final /* synthetic */ long f21290b;

        public AnonymousClass1(long j10, long j11) {
            j13 = j10;
            j12 = j11;
        }

        @Override // com.ss.android.downloadlib.g.c.a
        public Object a(Boolean bool) {
            if (!bool.booleanValue()) {
                b.this.b(j12);
                return null;
            }
            b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j13, j12));
            g.b("lp_app_dialog_try_show", j12);
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.b$2 */
    public class AnonymousClass2 implements c.a<String, Boolean> {

        /* renamed from: a */
        final /* synthetic */ long f21292a;

        /* renamed from: b */
        final /* synthetic */ long f21293b;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.b$2$1 */
        public class AnonymousClass1 implements r {

            /* renamed from: a */
            final /* synthetic */ boolean[] f21295a;

            public AnonymousClass1(boolean[] zArr) {
                zArr = zArr;
            }

            @Override // com.ss.android.download.api.config.r
            public void a(String str) {
                boolean[] zArr = zArr;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                zArr[0] = b.this.a(j13, j12, str);
            }

            @Override // com.ss.android.download.api.config.r
            public void a(Throwable th2) {
                g.a(2, j12);
                zArr[0] = false;
            }
        }

        public AnonymousClass2(long j10, long j11) {
            j13 = j10;
            j12 = j11;
        }

        @Override // com.ss.android.downloadlib.g.c.a
        public Boolean a(String str) {
            boolean[] zArr = {false};
            k.e().a("GET", str, new HashMap(), new r() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1

                /* renamed from: a */
                final /* synthetic */ boolean[] f21295a;

                public AnonymousClass1(boolean[] zArr2) {
                    zArr = zArr2;
                }

                @Override // com.ss.android.download.api.config.r
                public void a(String str2) {
                    boolean[] zArr2 = zArr;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    zArr2[0] = b.this.a(j13, j12, str2);
                }

                @Override // com.ss.android.download.api.config.r
                public void a(Throwable th2) {
                    g.a(2, j12);
                    zArr[0] = false;
                }
            });
            return Boolean.valueOf(zArr2[0]);
        }
    }

    public static class a {

        /* renamed from: a */
        private static b f21297a = new b();
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(long j10) {
        com.ss.android.downloadlib.addownload.e a10 = com.ss.android.downloadlib.g.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j10).f21217b.getDownloadUrl());
        if (a10 != null) {
            a10.a(true, true);
        } else {
            g.a(11, j10);
            com.ss.android.downloadlib.e.c.a().b("startDownload handler null");
        }
    }

    private b() {
    }

    public static b a() {
        return a.f21297a;
    }

    public void a(long j10) {
        TTDelegateActivity.a(j10);
    }

    public boolean a(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || k.j().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(k.j().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity b() {
        Activity activity = this.f21288a.get();
        this.f21288a = null;
        return activity;
    }

    public boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        long j10;
        long j11;
        if (!TextUtils.isEmpty(eVar.f21217b.getLogExtra())) {
            try {
                j10 = m.a(new JSONObject(eVar.f21217b.getLogExtra()), "convert_id");
            } catch (Exception e10) {
                e10.printStackTrace();
                j10 = 0;
            }
            if (j10 <= 0) {
                g.a(3, eVar);
            }
            j11 = j10;
        } else {
            g.a(9, eVar);
            com.ss.android.downloadlib.e.c.a().a("requestAppInfo getLogExtra null");
            j11 = 0;
        }
        long j12 = eVar.f21216a;
        com.ss.android.downloadlib.addownload.b.b a10 = c.a().a(j11, j12);
        if (a10 != null) {
            d.a().a(a10.a(), j12, a10.f21192d);
            a(a10.a());
            g.a("lp_app_dialog_try_show", eVar);
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        if (j11 > 0) {
            sb2.append("convert_id=");
            sb2.append(j11);
        }
        if (!TextUtils.isEmpty(eVar.f21217b.getPackageName())) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append("package_name=");
            sb2.append(eVar.f21217b.getPackageName());
        }
        if (sb2.length() <= 0) {
            g.a(6, eVar);
            return false;
        }
        long j13 = j11;
        com.ss.android.downloadlib.g.c.a(new c.a<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2

            /* renamed from: a */
            final /* synthetic */ long f21292a;

            /* renamed from: b */
            final /* synthetic */ long f21293b;

            /* renamed from: com.ss.android.downloadlib.addownload.compliance.b$2$1 */
            public class AnonymousClass1 implements r {

                /* renamed from: a */
                final /* synthetic */ boolean[] f21295a;

                public AnonymousClass1(boolean[] zArr2) {
                    zArr = zArr2;
                }

                @Override // com.ss.android.download.api.config.r
                public void a(String str2) {
                    boolean[] zArr2 = zArr;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    zArr2[0] = b.this.a(j13, j12, str2);
                }

                @Override // com.ss.android.download.api.config.r
                public void a(Throwable th2) {
                    g.a(2, j12);
                    zArr[0] = false;
                }
            }

            public AnonymousClass2(long j132, long j122) {
                j13 = j132;
                j12 = j122;
            }

            @Override // com.ss.android.downloadlib.g.c.a
            public Boolean a(String str) {
                boolean[] zArr2 = {false};
                k.e().a("GET", str, new HashMap(), new r() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1

                    /* renamed from: a */
                    final /* synthetic */ boolean[] f21295a;

                    public AnonymousClass1(boolean[] zArr22) {
                        zArr = zArr22;
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(String str2) {
                        boolean[] zArr22 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr22[0] = b.this.a(j13, j12, str2);
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(Throwable th2) {
                        g.a(2, j12);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr22[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb2.toString()).a(new c.a<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.1

            /* renamed from: a */
            final /* synthetic */ long f21289a;

            /* renamed from: b */
            final /* synthetic */ long f21290b;

            public AnonymousClass1(long j132, long j122) {
                j13 = j132;
                j12 = j122;
            }

            @Override // com.ss.android.downloadlib.g.c.a
            public Object a(Boolean bool) {
                if (!bool.booleanValue()) {
                    b.this.b(j12);
                    return null;
                }
                b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j13, j12));
                g.b("lp_app_dialog_try_show", j12);
                return null;
            }
        }).a();
        return true;
    }

    public boolean a(long j10, long j11, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                bVar.f21189a = j10;
                bVar.f21190b = j11;
                bVar.f21192d = optJSONObject.optString("icon_url");
                bVar.f21193e = optJSONObject.optString("app_name");
                bVar.f21191c = optJSONObject.optString("package_name");
                bVar.f21194f = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                bVar.f21195g = optJSONObject.optString("developer_name");
                bVar.f21197i = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i10);
                        bVar.f21196h.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                c.a().a(bVar);
                d.a().a(bVar.a(), j11, bVar.f21192d);
                return true;
            }
            g.a(7, j11);
            return false;
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "AdLpComplianceManager parseResponse");
            g.a(7, j11);
            return false;
        }
    }

    public void a(Activity activity) {
        this.f21288a = new SoftReference<>(activity);
    }
}
