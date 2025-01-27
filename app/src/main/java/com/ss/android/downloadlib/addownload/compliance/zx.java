package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.downloadlib.lg;
import com.ss.android.downloadlib.lg.i;
import com.ss.android.downloadlib.lg.nt;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: j */
    private SoftReference<Activity> f24131j;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.zx$1 */
    class AnonymousClass1 implements i.j<Boolean, Object> {

        /* renamed from: j */
        final /* synthetic */ long f24133j;
        final /* synthetic */ long zx;

        AnonymousClass1(long j2, long j3) {
            j6 = j2;
            j4 = j3;
        }

        @Override // com.ss.android.downloadlib.lg.i.j
        public Object j(Boolean bool) {
            if (!bool.booleanValue()) {
                zx.this.zx(j4);
                return null;
            }
            zx.this.j(com.ss.android.downloadlib.addownload.zx.zx.j(j6, j4));
            q.zx("lp_app_dialog_try_show", j4);
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.zx$2 */
    class AnonymousClass2 implements i.j<String, Boolean> {

        /* renamed from: j */
        final /* synthetic */ long f24135j;
        final /* synthetic */ long zx;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.zx$2$1 */
        class AnonymousClass1 implements e {

            /* renamed from: j */
            final /* synthetic */ boolean[] f24136j;

            AnonymousClass1(boolean[] zArr) {
                zArr = zArr;
            }

            @Override // com.ss.android.download.api.config.e
            public void j(String str) {
                boolean[] zArr = zArr;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                zArr[0] = zx.this.j(j6, j4, str);
            }

            @Override // com.ss.android.download.api.config.e
            public void j(Throwable th) {
                q.j(2, j4);
                zArr[0] = false;
            }
        }

        AnonymousClass2(long j2, long j3) {
            j6 = j2;
            j4 = j3;
        }

        @Override // com.ss.android.downloadlib.lg.i.j
        public Boolean j(String str) {
            boolean[] zArr = {false};
            pa.g().j("GET", str, new HashMap(), new e() { // from class: com.ss.android.downloadlib.addownload.compliance.zx.2.1

                /* renamed from: j */
                final /* synthetic */ boolean[] f24136j;

                AnonymousClass1(boolean[] zArr2) {
                    zArr = zArr2;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str2) {
                    boolean[] zArr2 = zArr;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    zArr2[0] = zx.this.j(j6, j4, str2);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    q.j(2, j4);
                    zArr[0] = false;
                }
            });
            return Boolean.valueOf(zArr2[0]);
        }
    }

    private static class j {

        /* renamed from: j */
        private static zx f24137j = new zx();
    }

    /* synthetic */ zx(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void zx(long j2) {
        com.ss.android.downloadlib.addownload.q j3 = lg.j().j(gv.j().q(j2).zx.getDownloadUrl());
        if (j3 != null) {
            j3.j(true, true);
        } else {
            q.j(11, j2);
            com.ss.android.downloadlib.q.i.j().zx("startDownload handler null");
        }
    }

    private zx() {
    }

    public static zx j() {
        return j.f24137j;
    }

    public void j(long j2) {
        TTDelegateActivity.j(j2);
    }

    public boolean j(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || pa.k().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(pa.k().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity zx() {
        Activity activity = this.f24131j.get();
        this.f24131j = null;
        return activity;
    }

    public boolean j(@NonNull com.ss.android.downloadlib.addownload.zx.q qVar) {
        long j2;
        long j3;
        if (!TextUtils.isEmpty(qVar.zx.getLogExtra())) {
            try {
                j2 = nt.j(new JSONObject(qVar.zx.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (j2 <= 0) {
                q.j(3, qVar);
            }
            j3 = j2;
        } else {
            q.j(9, qVar);
            com.ss.android.downloadlib.q.i.j().j("requestAppInfo getLogExtra null");
            j3 = 0;
        }
        long j4 = qVar.f24240j;
        com.ss.android.downloadlib.addownload.zx.zx j5 = i.j().j(j3, j4);
        if (j5 != null) {
            g.j().j(j5.j(), j4, j5.f24242g);
            j(j5.j());
            q.j("lp_app_dialog_try_show", qVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j3 > 0) {
            sb.append("convert_id=");
            sb.append(j3);
        }
        if (!TextUtils.isEmpty(qVar.zx.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(qVar.zx.getPackageName());
        }
        if (sb.length() <= 0) {
            q.j(6, qVar);
            return false;
        }
        long j6 = j3;
        com.ss.android.downloadlib.lg.i.j(new i.j<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.zx.2

            /* renamed from: j */
            final /* synthetic */ long f24135j;
            final /* synthetic */ long zx;

            /* renamed from: com.ss.android.downloadlib.addownload.compliance.zx$2$1 */
            class AnonymousClass1 implements e {

                /* renamed from: j */
                final /* synthetic */ boolean[] f24136j;

                AnonymousClass1(boolean[] zArr2) {
                    zArr = zArr2;
                }

                @Override // com.ss.android.download.api.config.e
                public void j(String str2) {
                    boolean[] zArr2 = zArr;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    zArr2[0] = zx.this.j(j6, j4, str2);
                }

                @Override // com.ss.android.download.api.config.e
                public void j(Throwable th) {
                    q.j(2, j4);
                    zArr[0] = false;
                }
            }

            AnonymousClass2(long j62, long j42) {
                j6 = j62;
                j4 = j42;
            }

            @Override // com.ss.android.downloadlib.lg.i.j
            public Boolean j(String str) {
                boolean[] zArr2 = {false};
                pa.g().j("GET", str, new HashMap(), new e() { // from class: com.ss.android.downloadlib.addownload.compliance.zx.2.1

                    /* renamed from: j */
                    final /* synthetic */ boolean[] f24136j;

                    AnonymousClass1(boolean[] zArr22) {
                        zArr = zArr22;
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(String str2) {
                        boolean[] zArr22 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr22[0] = zx.this.j(j6, j4, str2);
                    }

                    @Override // com.ss.android.download.api.config.e
                    public void j(Throwable th) {
                        q.j(2, j4);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr22[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).j(new i.j<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.zx.1

            /* renamed from: j */
            final /* synthetic */ long f24133j;
            final /* synthetic */ long zx;

            AnonymousClass1(long j62, long j42) {
                j6 = j62;
                j4 = j42;
            }

            @Override // com.ss.android.downloadlib.lg.i.j
            public Object j(Boolean bool) {
                if (!bool.booleanValue()) {
                    zx.this.zx(j4);
                    return null;
                }
                zx.this.j(com.ss.android.downloadlib.addownload.zx.zx.j(j6, j4));
                q.zx("lp_app_dialog_try_show", j4);
                return null;
            }
        }).j();
        return true;
    }

    public boolean j(long j2, long j3, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.zx.zx zxVar = new com.ss.android.downloadlib.addownload.zx.zx();
                zxVar.f24244j = j2;
                zxVar.zx = j3;
                zxVar.f24242g = optJSONObject.optString("icon_url");
                zxVar.q = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
                zxVar.f24243i = optJSONObject.optString("package_name");
                zxVar.gv = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                zxVar.lg = optJSONObject.optString("developer_name");
                zxVar.k = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                        zxVar.y.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                i.j().j(zxVar);
                g.j().j(zxVar.j(), j3, zxVar.f24242g);
                return true;
            }
            q.j(7, j3);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.q.i.j().j(e2, "AdLpComplianceManager parseResponse");
            q.j(7, j3);
            return false;
        }
    }

    public void j(Activity activity) {
        this.f24131j = new SoftReference<>(activity);
    }
}
