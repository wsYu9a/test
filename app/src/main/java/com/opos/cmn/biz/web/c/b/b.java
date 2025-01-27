package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.bj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.cmn.an.b.d;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.umeng.analytics.pro.am;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: e */
    private final Handler f16902e;

    /* renamed from: f */
    private String f16903f;

    /* renamed from: com.opos.cmn.biz.web.c.b.b$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16904a;

        /* renamed from: b */
        final /* synthetic */ boolean f16905b;

        AnonymousClass1(String str, boolean z) {
            str = str;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Toast.makeText(b.this.f16898a, str, !z ? 1 : 0).show();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
    }

    public b(Context context, c cVar) {
        super(context, cVar != null ? cVar.f16909c : "", cVar != null ? cVar.f16908b : true);
        this.f16902e = new Handler(Looper.getMainLooper());
        this.f16898a = context.getApplicationContext();
        this.f16903f = cVar != null ? cVar.f16907a : "";
    }

    private String a() {
        try {
            return !com.opos.cmn.an.f.a.b(this.f16898a) ? StStrategyManager.getInstance(this.f16898a).getAnId(this.f16898a) : "";
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            return "";
        }
    }

    @JavascriptInterface
    public String getAllInstalledPkgName() {
        String str = "";
        if (this.f16899b) {
            try {
                List<String> b2 = com.opos.cmn.an.h.d.a.b(this.f16898a);
                if (b2 != null && b2.size() > 0) {
                    String[] strArr = new String[b2.size()];
                    b2.toArray(strArr);
                    str = Arrays.toString(strArr);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAllInstalledPkgName=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getAndroidInfo() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = this.f16898a.getPackageName();
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f16898a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f16898a, packageName));
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.b.c.c());
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, com.opos.cmn.biz.web.c.a.a.a.a(this.f16898a));
                jSONObject.put("opt", com.opos.cmn.an.h.e.a.c(this.f16898a));
                jSONObject.put("ori", com.opos.cmn.an.h.f.a.i(this.f16898a));
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f16898a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f16898a));
                jSONObject.put("density", com.opos.cmn.an.h.f.a.f(this.f16898a));
                jSONObject.put(bj.f5604i, com.opos.cmn.an.b.c.a());
                jSONObject.put(bj.f5605j, com.opos.cmn.biz.a.b.a(this.f16898a));
                jSONObject.put("lang", com.opos.cmn.an.b.b.a());
                jSONObject.put(am.O, com.opos.cmn.an.b.b.b());
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getAndroidInfo = " + str);
        return str;
    }

    @JavascriptInterface
    public String getBrand() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.biz.a.b.a(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getBrand=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getBuildInfo() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bj.f5604i, com.opos.cmn.an.b.c.a());
                jSONObject.put(bj.f5605j, com.opos.cmn.biz.a.b.a(this.f16898a));
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getBuildInfo=" + str);
        return str;
    }

    @JavascriptInterface
    public String getBusinessType() {
        return this.f16903f;
    }

    @JavascriptInterface
    public int getCommonApiVer() {
        int a2 = com.opos.cmn.biz.web.c.a.a.a.a();
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getCommonApiVer=" + a2);
        return a2;
    }

    @JavascriptInterface
    public String getDevId() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevId=" + str);
        return str;
    }

    @JavascriptInterface
    public String getDevOS() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.b.c.c());
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevOS=" + str);
        return str;
    }

    @JavascriptInterface
    public String getDuId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.g.a.b.b(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getGuId() {
        String str = "";
        if (this.f16899b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f16898a)) {
                    str = StStrategyManager.getInstance(this.f16898a).getGUID();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.f16899b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f16898a)) {
                    str = StStrategyManager.getInstance(this.f16898a).getImei();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getLocal() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lang", com.opos.cmn.an.b.b.a());
                jSONObject.put(am.O, com.opos.cmn.an.b.b.b());
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocal=" + str);
        return str;
    }

    @JavascriptInterface
    public String getLocalId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.g.a.c.c(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocalId=" + str);
        return str;
    }

    @JavascriptInterface
    public String getNetType() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.biz.web.c.a.a.a.a(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getNetType=" + str);
        return str;
    }

    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean h2;
        if (this.f16899b) {
            try {
                h2 = com.opos.cmn.g.a.b.h(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + h2);
            return h2;
        }
        h2 = false;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + h2);
        return h2;
    }

    @JavascriptInterface
    public String getOperator() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.an.h.e.a.c(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOperator=" + str);
        return str;
    }

    @JavascriptInterface
    public int getOri() {
        int i2;
        if (this.f16899b) {
            try {
                i2 = com.opos.cmn.an.h.f.a.i(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i2);
            return i2;
        }
        i2 = 0;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i2);
        return i2;
    }

    @JavascriptInterface
    public String getOuId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.g.a.b.a(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOUID=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getPkgInfo(String str) {
        String str2 = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = com.opos.cmn.an.c.a.a(str) ? this.f16898a.getPackageName() : str;
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f16898a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f16898a, packageName));
                str2 = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPkgInfo pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(str2);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str2;
    }

    @JavascriptInterface
    public String getRegion() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.cmn.biz.a.d.a(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRegion=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getScreen() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f16898a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f16898a));
                jSONObject.put("density", com.opos.cmn.an.h.f.a.f(this.f16898a));
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getScreen=" + str);
        return str;
    }

    @JavascriptInterface
    public boolean getTouristModeSwitch() {
        boolean b2;
        if (this.f16899b) {
            try {
                b2 = com.opos.cmn.an.f.a.b(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + b2);
            return b2;
        }
        b2 = false;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + b2);
        return b2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasPkgInstalled(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.f16899b
            java.lang.String r1 = "JSCommonEngine"
            if (r0 == 0) goto L13
            android.content.Context r0 = r4.f16898a     // Catch: java.lang.Exception -> Ld
            boolean r0 = com.opos.cmn.an.h.d.a.d(r0, r5)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r1, r2, r0)
        L13:
            r0 = 0
        L14:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "hasPkgInstalled pkgName="
            r2.append(r3)
            if (r5 == 0) goto L21
            goto L23
        L21:
            java.lang.String r5 = "null"
        L23:
            r2.append(r5)
            java.lang.String r5 = ",result="
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.c.b.b.hasPkgInstalled(java.lang.String):boolean");
    }

    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String str2 = "";
        if (this.f16899b) {
            try {
                if (!com.opos.cmn.an.c.a.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("JSCommonEngine", "pkgList=" + str);
                    String substring = str.substring(1, str.length() - 1);
                    if (substring.length() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        StringTokenizer stringTokenizer = new StringTokenizer(substring, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            if (!com.opos.cmn.an.c.a.a(nextToken)) {
                                jSONObject.put(nextToken, com.opos.cmn.an.h.d.a.d(this.f16898a, nextToken));
                            }
                        }
                        str2 = jSONObject.toString();
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(str2 != null ? str2 : "null");
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean installApk(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.f16899b
            java.lang.String r1 = "JSCommonEngine"
            if (r0 == 0) goto L13
            android.content.Context r0 = r4.f16898a     // Catch: java.lang.Exception -> Ld
            boolean r0 = com.opos.cmn.biz.web.c.a.a.a.a(r0, r5)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r1, r2, r0)
        L13:
            r0 = 0
        L14:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "installApk url="
            r2.append(r3)
            if (r5 == 0) goto L21
            goto L23
        L21:
            java.lang.String r5 = "null"
        L23:
            r2.append(r5)
            java.lang.String r5 = ",result="
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.c.b.b.installApk(java.lang.String):boolean");
    }

    @JavascriptInterface
    public void showToast(String str, boolean z) {
        if (this.f16899b) {
            this.f16902e.post(new Runnable() { // from class: com.opos.cmn.biz.web.c.b.b.1

                /* renamed from: a */
                final /* synthetic */ String f16904a;

                /* renamed from: b */
                final /* synthetic */ boolean f16905b;

                AnonymousClass1(String str2, boolean z2) {
                    str = str2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(b.this.f16898a, str, !z ? 1 : 0).show();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("JSCommonEngine", "", e2);
                    }
                }
            });
        }
    }
}
