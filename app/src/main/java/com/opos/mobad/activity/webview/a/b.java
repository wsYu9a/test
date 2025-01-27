package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.opos.cmn.biz.web.c.b.c;
import com.opos.cmn.func.b.b.d;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends com.opos.cmn.biz.web.c.b.b {

    /* renamed from: e */
    private com.opos.mobad.activity.webview.b.b f19403e;

    /* renamed from: com.opos.mobad.activity.webview.a.b$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.f19403e != null) {
                    b.this.f19403e.c();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.a.b$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f19405a;

        /* renamed from: b */
        final /* synthetic */ String f19406b;

        AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.opos.cmn.func.b.b.b.a().a(((com.opos.cmn.biz.web.c.b.a) b.this).f16898a, new d.a().b(str).a(str2.getBytes()).a("POST").a());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("MixAdJsEngine", "request fail", e2);
            }
        }
    }

    public b(Context context, c cVar, com.opos.mobad.activity.webview.b.b bVar) {
        super(context, cVar);
        this.f19403e = bVar;
    }

    public void a() {
        this.f19403e = null;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i2) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.a(str, str2, str3, str4, i2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
    }

    @JavascriptInterface
    public void closeWebview() {
        if (this.f16899b) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.f19403e != null) {
                            b.this.f19403e.c();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public int getApiVer() {
        int a2 = com.opos.mobad.activity.webview.a.a.a.a();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getApiVer=" + a2);
        return a2;
    }

    @JavascriptInterface
    public String getDownloaderStatus(String str, String str2) {
        String str3 = "";
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    str3 = bVar.c(str, str2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getDownloaderStatus url=" + str + ",pkgName:" + str2 + ",downloadStatus:" + str3);
        return str3;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getDuId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.e.a.a().g();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getGps() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                double[] c2 = com.opos.cmn.an.e.c.a().c();
                jSONObject.put("lt", String.valueOf(c2[0]));
                jSONObject.put("lg", String.valueOf(c2[1]));
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getGps=" + str);
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getGuId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.e.a.a().h();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.e.a.a().k();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getInstantSdkVer() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.f.a.a().b();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantSdkVer=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getInstantVer() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.f.a.a().d();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantVer=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean j2;
        if (this.f16899b) {
            try {
                j2 = com.opos.mobad.service.e.a.a().j();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e2);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + j2);
            return j2;
        }
        j2 = false;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + j2);
        return j2;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public int getOri() {
        int i2;
        if (this.f16899b) {
            try {
                i2 = com.opos.cmn.an.h.f.a.i(this.f16898a);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i2);
            return i2;
        }
        i2 = 0;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i2);
        return i2;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getOuId() {
        String str = "";
        if (this.f16899b) {
            try {
                str = com.opos.mobad.service.e.a.a().f();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOuId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getPosId() {
        String str = "";
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    str = bVar.d();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPosId=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getSdkInfo() {
        String str = "";
        if (this.f16899b) {
            try {
                JSONObject jSONObject = new JSONObject();
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                jSONObject.put("verName", bVar != null ? bVar.b() : "");
                com.opos.mobad.activity.webview.b.b bVar2 = this.f19403e;
                jSONObject.put("verCode", bVar2 != null ? bVar2.a() : 0);
                str = jSONObject.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getSdkInfo=" + str);
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String str2 = "";
        if (this.f16899b) {
            try {
                if (!com.opos.cmn.an.c.a.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("MixAdJsEngine", "pkgList=" + str);
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
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(str2 != null ? str2 : "null");
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchAppHomePage(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.f16899b
            java.lang.String r1 = "MixAdJsEngine"
            if (r0 == 0) goto L15
            com.opos.mobad.activity.webview.b.b r0 = r4.f19403e     // Catch: java.lang.Exception -> Lf
            if (r0 == 0) goto L15
            boolean r0 = r0.b(r5)     // Catch: java.lang.Exception -> Lf
            goto L16
        Lf:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r1, r2, r0)
        L15:
            r0 = 0
        L16:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launchAppHomePage pkgName="
            r2.append(r3)
            if (r5 == 0) goto L23
            goto L25
        L23:
            java.lang.String r5 = "null"
        L25:
            r2.append(r5)
            java.lang.String r5 = ",result="
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchAppHomePage(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchAppPage(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.f16899b
            java.lang.String r1 = "MixAdJsEngine"
            if (r0 == 0) goto L13
            android.content.Context r0 = r4.f16898a     // Catch: java.lang.Exception -> Ld
            boolean r0 = com.opos.mobad.activity.webview.a.a.a.b(r0, r5)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r1, r2, r0)
        L13:
            r0 = 0
        L14:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launchAppPage url="
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
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchAppPage(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchBrowserViewPage(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.f16899b
            java.lang.String r1 = "MixAdJsEngine"
            if (r0 == 0) goto L13
            android.content.Context r0 = r4.f16898a     // Catch: java.lang.Exception -> Ld
            boolean r0 = com.opos.mobad.activity.webview.a.a.a.a(r0, r5)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r1, r2, r0)
        L13:
            r0 = 0
        L14:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launchBrowserViewPage url="
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
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchBrowserViewPage(java.lang.String):boolean");
    }

    @JavascriptInterface
    public void launchInstant(String str, String str2, String str3, String str4, String str5) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.b(str, str5);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchInstant instantUrl=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.a(str, z);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.a(str, z, str5, str6);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        sb.append(",trackContent=");
        sb.append(str5);
        sb.append(",trackReference=");
        sb.append(str6);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.d(str, str2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApk url=" + str + ",pkgName:" + str2);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2) {
        if (this.f16899b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.f19403e;
                if (bVar != null) {
                    bVar.e(str, str2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApkForSafe url=" + str + ",pkgName:" + str2);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2) {
        boolean a2;
        if (this.f16899b) {
            try {
                a2 = this.f19403e.a(str, str2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e2);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + a2);
            return a2;
        }
        a2 = false;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + a2);
        return a2;
    }

    @JavascriptInterface
    public void request(String str, String str2) {
        if (this.f16899b) {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.2

                /* renamed from: a */
                final /* synthetic */ String f19405a;

                /* renamed from: b */
                final /* synthetic */ String f19406b;

                AnonymousClass2(String str3, String str22) {
                    str = str3;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.opos.cmn.func.b.b.b.a().a(((com.opos.cmn.biz.web.c.b.a) b.this).f16898a, new d.a().b(str).a(str2.getBytes()).a("POST").a());
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request fail", e2);
                    }
                }
            });
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request url=" + str3 + ",data:" + str22);
    }
}
