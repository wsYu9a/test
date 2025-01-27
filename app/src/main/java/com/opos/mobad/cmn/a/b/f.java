package com.opos.mobad.cmn.a.b;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    private static volatile com.opos.cmn.an.d.d.a f20265a;

    /* renamed from: d */
    private static WeakReference<b.InterfaceC0437b> f20268d;

    /* renamed from: b */
    private static final byte[] f20266b = new byte[0];

    /* renamed from: c */
    private static final byte[] f20267c = new byte[0];

    /* renamed from: e */
    private static final String f20269e = com.opos.cmn.an.a.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");

    /* renamed from: com.opos.mobad.cmn.a.b.f$1 */
    static final class AnonymousClass1 implements a.b {

        /* renamed from: a */
        final /* synthetic */ Context f20270a;

        /* renamed from: b */
        final /* synthetic */ View f20271b;

        /* renamed from: c */
        private com.opos.cmn.e.a.b.a f20272c;

        /* renamed from: com.opos.mobad.cmn.a.b.f$1$1 */
        class RunnableC04311 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0429a f20273a;

            /* renamed from: com.opos.mobad.cmn.a.b.f$1$1$1 */
            class C04321 implements com.opos.cmn.e.a.b.c.a {
                C04321() {
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void a(View view, int[] iArr) {
                    interfaceC0429a.a();
                    AnonymousClass1.this.f20272c.a();
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void b(View view, int[] iArr) {
                    interfaceC0429a.b();
                    AnonymousClass1.this.f20272c.a();
                }
            }

            RunnableC04311(a.InterfaceC0429a interfaceC0429a) {
                interfaceC0429a = interfaceC0429a;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                anonymousClass1.f20272c = f.c(anonymousClass1.f20270a, anonymousClass1.f20271b);
                if (AnonymousClass1.this.f20272c == null) {
                    interfaceC0429a.a();
                } else {
                    AnonymousClass1.this.f20272c.a("当前为非Wi-Fi环境，\n是否继续下载？", "下载", "取消", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.cmn.a.b.f.1.1.1
                        C04321() {
                        }

                        @Override // com.opos.cmn.e.a.b.c.a
                        public void a(View view, int[] iArr) {
                            interfaceC0429a.a();
                            AnonymousClass1.this.f20272c.a();
                        }

                        @Override // com.opos.cmn.e.a.b.c.a
                        public void b(View view, int[] iArr) {
                            interfaceC0429a.b();
                            AnonymousClass1.this.f20272c.a();
                        }
                    });
                }
            }
        }

        AnonymousClass1(Context context, View view) {
            this.f20270a = context;
            this.f20271b = view;
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a() {
            com.opos.cmn.e.a.b.a aVar = this.f20272c;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a(a.InterfaceC0429a interfaceC0429a) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.f.1.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0429a f20273a;

                /* renamed from: com.opos.mobad.cmn.a.b.f$1$1$1 */
                class C04321 implements com.opos.cmn.e.a.b.c.a {
                    C04321() {
                    }

                    @Override // com.opos.cmn.e.a.b.c.a
                    public void a(View view, int[] iArr) {
                        interfaceC0429a.a();
                        AnonymousClass1.this.f20272c.a();
                    }

                    @Override // com.opos.cmn.e.a.b.c.a
                    public void b(View view, int[] iArr) {
                        interfaceC0429a.b();
                        AnonymousClass1.this.f20272c.a();
                    }
                }

                RunnableC04311(a.InterfaceC0429a interfaceC0429a2) {
                    interfaceC0429a = interfaceC0429a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.f20272c = f.c(anonymousClass1.f20270a, anonymousClass1.f20271b);
                    if (AnonymousClass1.this.f20272c == null) {
                        interfaceC0429a.a();
                    } else {
                        AnonymousClass1.this.f20272c.a("当前为非Wi-Fi环境，\n是否继续下载？", "下载", "取消", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.cmn.a.b.f.1.1.1
                            C04321() {
                            }

                            @Override // com.opos.cmn.e.a.b.c.a
                            public void a(View view, int[] iArr) {
                                interfaceC0429a.a();
                                AnonymousClass1.this.f20272c.a();
                            }

                            @Override // com.opos.cmn.e.a.b.c.a
                            public void b(View view, int[] iArr) {
                                interfaceC0429a.b();
                                AnonymousClass1.this.f20272c.a();
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.f$2 */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20276a;

        static {
            int[] iArr = new int[a.values().length];
            f20276a = iArr;
            try {
                iArr[a.Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20276a[a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20276a[a.NonClickBt.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20276a[a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20276a[a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(Context context) {
        if (context != null) {
            String e2 = com.opos.cmn.an.h.e.a.e(context);
            e2.hashCode();
            switch (e2) {
                case "telecom":
                    return 2;
                case "mobile":
                    return 1;
                case "unicom":
                    return 3;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.io.File r4) {
        /*
            java.lang.String r0 = "Utils"
            if (r4 == 0) goto L18
            boolean r1 = r4.isDirectory()     // Catch: java.lang.Exception -> L12
            if (r1 == 0) goto L18
            java.io.File[] r1 = r4.listFiles()     // Catch: java.lang.Exception -> L12
            if (r1 == 0) goto L18
            int r1 = r1.length     // Catch: java.lang.Exception -> L12
            goto L19
        L12:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L18:
            r1 = 0
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getFolderFilesCount folderFile="
            r2.append(r3)
            if (r4 == 0) goto L2a
            java.lang.String r4 = r4.getAbsolutePath()
            goto L2c
        L2a:
            java.lang.String r4 = "null"
        L2c:
            r2.append(r4)
            java.lang.String r4 = ",count="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(java.io.File):int");
    }

    private static Activity a(View view) {
        if (view != null) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                com.opos.cmn.an.f.a.b("Utils", "context instanceof ContextWrapper");
                if (context instanceof Activity) {
                    com.opos.cmn.an.f.a.b("Utils", "context instanceof Activity");
                    return (Activity) context;
                }
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivity = null");
        return null;
    }

    public static final ActivityInfo a(Context context, Class cls) {
        if (context != null && cls != null) {
            try {
                return context.getPackageManager().getActivityInfo(new ComponentName(context, (Class<?>) cls), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.opos.cmn.an.f.a.c("Utils", "", e2);
            }
        }
        return null;
    }

    public static a.b a(Context context, View view) {
        return new AnonymousClass1(context, view);
    }

    public static com.opos.mobad.model.b.c a(Context context, String str, int i2, String str2) {
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        com.opos.mobad.model.b.c cVar = new com.opos.mobad.model.b.c();
        cVar.b(a());
        cVar.c(str);
        cVar.c(i2);
        int[] a2 = a(context, i2);
        cVar.d(a2[1]);
        cVar.e(a2[0]);
        cVar.a(str2);
        cVar.b(f());
        cVar.d(com.opos.mobad.service.f.a.a().v());
        return cVar;
    }

    public static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> i2;
        MaterialData materialData;
        List<MaterialFileData> F;
        if (adItemData == null || (i2 = adItemData.i()) == null || i2.size() <= 0 || (materialData = i2.get(0)) == null || (F = materialData.F()) == null || F.size() <= 0) {
            return null;
        }
        return F.get(0);
    }

    public static String a() {
        return b.f20108a;
    }

    public static String a(int i2) {
        switch (i2) {
            case 10402:
                return "no video to play.";
            case 10403:
                return "no net,can't play video.";
            case 10404:
                return "video has expired.";
            case 10405:
                return "reward video only can play on 4.1 android version and above";
            case 10406:
                return "stream video only can be played in wifi net.";
            case 10407:
                return "unsupported play mode.";
            case 10408:
                return "video not cached.";
            case 10409:
                return "unknown creative.";
            case 10410:
                return "source exception.";
            case 10411:
                return "renderer exception.";
            case 10412:
                return "unexcepted exception.";
            default:
                return "";
        }
    }

    public static String a(Context context, String str, int[] iArr, long j2) {
        int indexOf;
        StringBuilder sb = new StringBuilder();
        sb.append("handleMacroInMonitorLinkUrl before=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        if (context != null && !com.opos.cmn.an.c.a.a(str) && str.length() > 0) {
            int indexOf2 = str.indexOf("$");
            StringBuilder sb2 = new StringBuilder();
            if (-1 != indexOf2) {
                int i2 = 0;
                sb2.append(str.substring(0, indexOf2));
                String substring = str.substring(indexOf2);
                do {
                    int i3 = i2 + 1;
                    indexOf = substring.indexOf("$", i3);
                    if (-1 != indexOf) {
                        String b2 = b(context, substring.substring(i3, indexOf), iArr, j2);
                        if (com.opos.cmn.an.c.a.a(b2)) {
                            b2 = substring.substring(i2, indexOf + 1);
                        }
                        sb2.append(b2);
                        int i4 = indexOf + 1;
                        i2 = substring.indexOf("$", i4);
                        sb2.append((-1 == i2 || i2 < indexOf) ? substring.substring(i4) : substring.substring(i4, i2));
                    } else {
                        sb2.append(substring);
                    }
                    if (-1 == i2) {
                        break;
                    }
                } while (-1 != indexOf);
                str = sb2.toString();
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "handleMacroInMonitorLinkUrl after=" + str);
        return str;
    }

    public static final String a(AdItemData adItemData, String str, String str2) {
        String str3 = "";
        if (adItemData != null && !com.opos.cmn.an.c.a.a(str) && adItemData.i() != null && adItemData.i().size() > 0) {
            try {
                String d2 = d(str);
                StringBuilder sb = new StringBuilder();
                sb.append(com.opos.mobad.service.e.a.a().k());
                sb.append(com.opos.cmn.an.a.d.a(d2));
                sb.append(str2);
                sb.append(adItemData.f() != null ? adItemData.f() : "");
                sb.append(adItemData.i().get(0).c() != null ? adItemData.i().get(0).c() : "");
                str3 = com.opos.cmn.an.a.c.a(sb.toString());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "jsSign=" + str3);
        return str3;
    }

    public static void a(Context context, String str, long j2) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                h(context).a(str, Long.valueOf(j2));
                com.opos.cmn.an.f.a.b("Utils", "putRewardTime pkgName=" + str + ",timestamp=" + j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4) {
        try {
            c.a(context, str, str2, str3, callback, "10001", str4);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        c.a(context, str, str2, str3, "10001", str4);
    }

    public static void a(b.InterfaceC0437b interfaceC0437b) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("setCacheInterBaseAd=");
            sb.append(interfaceC0437b != null ? interfaceC0437b : "null");
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (interfaceC0437b != null) {
                f20268d = new WeakReference<>(interfaceC0437b);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(String str) {
        b.f20108a = str;
        StringBuilder sb = new StringBuilder();
        sb.append("setAppId=");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
    }

    public static void a(boolean z) {
        b.f20112e = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if (c(r3).equals(d(r3)) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.app.Activity r3) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "Utils"
            if (r3 == 0) goto L24
            java.lang.String r2 = d(r3)     // Catch: java.lang.Exception -> L20
            boolean r2 = r0.equals(r2)     // Catch: java.lang.Exception -> L20
            if (r2 != 0) goto L1e
            java.lang.String r2 = c(r3)     // Catch: java.lang.Exception -> L20
            java.lang.String r3 = d(r3)     // Catch: java.lang.Exception -> L20
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L20
            if (r3 == 0) goto L24
        L1e:
            r3 = 1
            goto L25
        L20:
            r3 = move-exception
            com.opos.cmn.an.f.a.a(r1, r0, r3)
        L24:
            r3 = 0
        L25:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "isCurrentActivity="
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.opos.cmn.an.f.a.b(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.app.Activity):boolean");
    }

    public static boolean a(Context context, AdItemData adItemData, a aVar) {
        return a(adItemData, aVar) && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(context)) && j();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r12, com.opos.mobad.model.data.AdItemData r13, com.opos.mobad.model.data.MaterialData r14, int[] r15) {
        /*
            java.lang.String r0 = "Utils"
            r1 = 0
            if (r12 == 0) goto L7f
            if (r13 == 0) goto L7f
            if (r14 == 0) goto L7f
            java.lang.String r2 = r14.s()
            java.lang.String r14 = r14.k()
            r3 = 1
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L4b
            if (r4 != 0) goto L36
            boolean r4 = b(r12, r2)     // Catch: java.lang.Exception -> L4b
            if (r4 == 0) goto L36
            java.lang.String r6 = r13.g()     // Catch: java.lang.Exception -> L4b
            java.util.List r4 = r13.i()     // Catch: java.lang.Exception -> L4b
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> L4b
            r8 = r4
            com.opos.mobad.model.data.MaterialData r8 = (com.opos.mobad.model.data.MaterialData) r8     // Catch: java.lang.Exception -> L4b
            r9 = 1
            r11 = 0
            r5 = r12
            r7 = r13
            r10 = r15
            com.opos.mobad.cmn.a.b.d.c(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L4b
            goto L49
        L36:
            boolean r4 = a(r12, r14)     // Catch: java.lang.Exception -> L4b
            if (r4 == 0) goto L51
            java.util.List r4 = r13.i()     // Catch: java.lang.Exception -> L4b
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> L4b
            com.opos.mobad.model.data.MaterialData r4 = (com.opos.mobad.model.data.MaterialData) r4     // Catch: java.lang.Exception -> L4b
            com.opos.mobad.cmn.a.b.d.a(r12, r13, r4, r3, r15)     // Catch: java.lang.Exception -> L4b
        L49:
            r1 = 1
            goto L51
        L4b:
            r12 = move-exception
            java.lang.String r13 = ""
            com.opos.cmn.an.f.a.a(r0, r13, r12)
        L51:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "launchAppPage url="
            r12.append(r13)
            java.lang.String r13 = "null"
            if (r2 == 0) goto L60
            goto L61
        L60:
            r2 = r13
        L61:
            r12.append(r2)
            java.lang.String r15 = ",pkgName="
            r12.append(r15)
            if (r14 == 0) goto L6c
            goto L6d
        L6c:
            r14 = r13
        L6d:
            r12.append(r14)
            java.lang.String r13 = ",result="
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.opos.cmn.an.f.a.a(r0, r12)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.content.Context, com.opos.mobad.model.data.AdItemData, com.opos.mobad.model.data.MaterialData, int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "Utils"
            if (r3 == 0) goto L1b
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L15
            if (r1 != 0) goto L1b
            boolean r1 = com.opos.cmn.an.h.d.a.d(r3, r4)     // Catch: java.lang.Exception -> L15
            if (r1 == 0) goto L1b
            boolean r3 = com.opos.cmn.an.h.d.a.e(r3, r4)     // Catch: java.lang.Exception -> L15
            goto L1c
        L15:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r3)
        L1b:
            r3 = 0
        L1c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "launchAppHomePage pkgName="
            r1.append(r2)
            if (r4 == 0) goto L29
            goto L2b
        L29:
            java.lang.String r4 = "null"
        L2b:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.a(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(AdItemData adItemData, a aVar) {
        int i2;
        boolean z = true;
        if (adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0 || ((i2 = AnonymousClass2.f20276a[aVar.ordinal()]) == 1 ? 2 != adItemData.i().get(0).K() || 2 != adItemData.i().get(0).L() : i2 == 2 ? 2 != adItemData.i().get(0).e() || 2 != adItemData.i().get(0).L() : i2 == 3 ? 2 != adItemData.i().get(0).J() || 2 != adItemData.i().get(0).L() : i2 == 4 ? 2 != adItemData.i().get(0).V() || 2 != adItemData.i().get(0).L() : i2 != 5 || 2 != adItemData.i().get(0).W() || 2 != adItemData.i().get(0).L())) {
            z = false;
        }
        com.opos.cmn.an.f.a.b("Utils", "isDownloaderTypeAd=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if (2 == r4.L()) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.opos.mobad.model.data.MaterialData r4) {
        /*
            java.lang.String r0 = "Utils"
            if (r4 == 0) goto L32
            int r1 = r4.J()     // Catch: java.lang.Exception -> L2c
            r2 = 2
            r3 = 3
            if (r3 != r1) goto L12
            int r1 = r4.L()     // Catch: java.lang.Exception -> L2c
            if (r2 == r1) goto L2a
        L12:
            int r1 = r4.K()     // Catch: java.lang.Exception -> L2c
            if (r3 != r1) goto L1e
            int r1 = r4.L()     // Catch: java.lang.Exception -> L2c
            if (r2 == r1) goto L2a
        L1e:
            int r1 = r4.e()     // Catch: java.lang.Exception -> L2c
            if (r3 != r1) goto L32
            int r4 = r4.L()     // Catch: java.lang.Exception -> L2c
            if (r2 != r4) goto L32
        L2a:
            r4 = 1
            goto L33
        L2c:
            r4 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r4)
        L32:
            r4 = 0
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isMiddleDownloader result:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(com.opos.mobad.model.data.MaterialData):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r6 != 6) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] a(android.content.Context r5, int r6) {
        /*
            r0 = 2
            int[] r1 = new int[r0]
            r1 = {x003e: FILL_ARRAY_DATA , data: [0, 0} // fill-array
            r2 = 1080(0x438, float:1.513E-42)
            r3 = 0
            r4 = 1
            if (r6 == r4) goto L37
            if (r6 == r0) goto L2e
            r0 = 3
            if (r6 == r0) goto L25
            r0 = 5
            if (r6 == r0) goto L18
            r0 = 6
            if (r6 == r0) goto L25
            goto L3d
        L18:
            int r6 = com.opos.cmn.an.h.f.a.b(r5)
            r1[r3] = r6
            int r5 = com.opos.cmn.an.h.f.a.c(r5)
            r1[r4] = r5
            goto L3d
        L25:
            r1[r3] = r2
            int r5 = c(r5)
            r1[r4] = r5
            goto L3d
        L2e:
            r5 = 720(0x2d0, float:1.009E-42)
            r1[r3] = r5
            r5 = 600(0x258, float:8.41E-43)
            r1[r4] = r5
            goto L3d
        L37:
            r1[r3] = r2
            r5 = 171(0xab, float:2.4E-43)
            r1[r4] = r5
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.content.Context, int):int[]");
    }

    public static int b(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                return a(new File(str));
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        return 0;
    }

    public static a.b b(Activity activity) {
        return a(activity, (View) null);
    }

    private static String b(Context context, String str, int[] iArr, long j2) {
        char c2;
        String str2;
        StringBuilder sb;
        StringBuilder sb2;
        String str3 = null;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    switch (str.hashCode()) {
                        case -1001078227:
                            if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                                c2 = '\r';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 99:
                            if (str.equals("c")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 104:
                            if (str.equals("h")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 109:
                            if (str.equals("m")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 119:
                            if (str.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3125:
                            if (str.equals("av")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3138:
                            if (str.equals("bd")) {
                                c2 = 19;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3166:
                            if (str.equals("ca")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3185:
                            if (str.equals("ct")) {
                                c2 = 14;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3220:
                            if (str.equals("dx")) {
                                c2 = 15;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3221:
                            if (str.equals("dy")) {
                                c2 = 16;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3526:
                            if (str.equals("nt")) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3556:
                            if (str.equals(am.x)) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3559:
                            if (str.equals("ov")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3636:
                            if (str.equals(RedirectReqWrapper.KEY_REFER)) {
                                c2 = '\f';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3724:
                            if (str.equals("ua")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3747:
                            if (str.equals("ux")) {
                                c2 = 17;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3748:
                            if (str.equals("uy")) {
                                c2 = 18;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 106905:
                            if (str.equals("lan")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 111052:
                            if (str.equals("pkg")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            str2 = BaseWrapper.BASE_PKG_SYSTEM;
                            str3 = str2;
                            break;
                        case 1:
                            str2 = com.opos.cmn.an.b.c.c();
                            str3 = str2;
                            break;
                        case 2:
                            str2 = com.opos.cmn.an.b.c.a();
                            str3 = str2;
                            break;
                        case 3:
                            str2 = com.opos.cmn.an.b.b.a();
                            str3 = str2;
                            break;
                        case 4:
                            str2 = com.opos.cmn.an.b.b.b();
                            str3 = str2;
                            break;
                        case 5:
                            sb = new StringBuilder();
                            sb.append(com.opos.cmn.an.h.f.a.b(context));
                            sb.append("");
                            str2 = sb.toString();
                            str3 = str2;
                            break;
                        case 6:
                            sb = new StringBuilder();
                            sb.append(com.opos.cmn.an.h.f.a.c(context));
                            sb.append("");
                            str2 = sb.toString();
                            str3 = str2;
                            break;
                        case 7:
                            str2 = context.getPackageName();
                            str3 = str2;
                            break;
                        case '\b':
                            str2 = com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
                            str3 = str2;
                            break;
                        case '\t':
                            str2 = com.opos.cmn.an.h.c.a.h(context);
                            str3 = str2;
                            break;
                        case '\n':
                            sb = new StringBuilder();
                            sb.append(a(context));
                            sb.append("");
                            str2 = sb.toString();
                            str3 = str2;
                            break;
                        case 11:
                            str2 = i();
                            str3 = str2;
                            break;
                        case '\f':
                        case 14:
                            str3 = "";
                            break;
                        case '\r':
                            sb2 = new StringBuilder();
                            sb2.append(j2);
                            sb2.append("");
                            str2 = sb2.toString();
                            str3 = str2;
                            break;
                        case 15:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[0]);
                                sb2.append("");
                                str2 = sb2.toString();
                                str3 = str2;
                                break;
                            }
                            str3 = "-999";
                            break;
                        case 16:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[1]);
                                sb2.append("");
                                str2 = sb2.toString();
                                str3 = str2;
                                break;
                            }
                            str3 = "-999";
                            break;
                        case 17:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[2]);
                                sb2.append("");
                                str2 = sb2.toString();
                                str3 = str2;
                                break;
                            }
                            str3 = "-999";
                            break;
                        case 18:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[3]);
                                sb2.append("");
                                str2 = sb2.toString();
                                str3 = str2;
                                break;
                            }
                            str3 = "-999";
                            break;
                        case 19:
                            str2 = com.opos.cmn.an.b.a.a(context);
                            str3 = str2;
                            break;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("key=");
        if (str == null) {
            str = "null";
        }
        sb3.append(str);
        sb3.append(",value=");
        sb3.append(str3 != null ? str3 : "null");
        com.opos.cmn.an.f.a.b("Utils", sb3.toString());
        return str3 != null ? str3 : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Long> b(android.content.Context r3) {
        /*
            java.lang.String r0 = "Utils"
            if (r3 == 0) goto L13
            com.opos.cmn.an.d.d.a r3 = h(r3)     // Catch: java.lang.Exception -> Ld
            java.util.Map r3 = r3.a()     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r3)
        L13:
            r3 = 0
        L14:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAllRewardTime size="
            r1.append(r2)
            if (r3 == 0) goto L29
            int r2 = r3.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L2b
        L29:
            java.lang.String r2 = "null"
        L2b:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.b(android.content.Context):java.util.Map");
    }

    public static void b() {
        b.f20109b = true;
        com.opos.cmn.an.f.a.b("Utils", "setSdkInitSuccess");
    }

    public static boolean b(Context context, Class cls) {
        ActivityInfo a2 = a(context, cls);
        if (a2 != null) {
            com.opos.cmn.an.f.a.b("Utils", "is standard launch mode" + a2.launchMode);
            if (a2.launchMode == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "Utils"
            if (r4 == 0) goto L34
            boolean r1 = com.opos.cmn.an.c.a.a(r5)
            if (r1 != 0) goto L34
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L2e
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = "android.intent.category.BROWSABLE"
            r1.addCategory(r2)     // Catch: java.lang.Exception -> L2e
            r2 = 0
            r1.setComponent(r2)     // Catch: java.lang.Exception -> L2e
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> L2e
            boolean r2 = com.opos.cmn.an.h.d.a.a(r4, r1)     // Catch: java.lang.Exception -> L2e
            if (r2 == 0) goto L34
            r4.startActivity(r1)     // Catch: java.lang.Exception -> L2e
            r4 = 1
            goto L35
        L2e:
            r4 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r4)
        L34:
            r4 = 0
        L35:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "launchAppDetailPage url="
            r1.append(r2)
            if (r5 == 0) goto L42
            goto L44
        L42:
            java.lang.String r5 = "null"
        L44:
            r1.append(r5)
            java.lang.String r5 = "result="
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = r1.toString()
            com.opos.cmn.an.f.a.a(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.b(android.content.Context, java.lang.String):boolean");
    }

    private static int c(Context context) {
        com.opos.cmn.an.h.f.a.l(context);
        if (f(context) || e(context)) {
            return 1872;
        }
        return g(context) ? 1752 : 1512;
    }

    public static final int c(String str) {
        int i2;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            i2 = str.lastIndexOf(f20269e);
            com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + i2);
            return i2;
        }
        i2 = -1;
        com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + i2);
        return i2;
    }

    public static com.opos.cmn.e.a.b.a c(Context context, View view) {
        Activity a2 = context instanceof Activity ? (Activity) context : view != null ? a(view.getRootView().findViewById(R.id.content)) : null;
        if (a2 == null) {
            return null;
        }
        return new com.opos.cmn.e.a.b.a(a2);
    }

    private static String c(Activity activity) {
        String str = "";
        try {
            str = activity.getClass().getName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivityClassName=" + str);
        return str;
    }

    public static String c(Context context, String str) {
        String str2;
        String str3 = "";
        if (context != null) {
            try {
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            if (!com.opos.cmn.an.c.a.a(str)) {
                str2 = com.opos.cmn.an.h.d.a.g(context, str);
                try {
                    if (!com.opos.cmn.an.c.a.a(str2) && str2.length() > 0) {
                        int indexOf = str2.indexOf("(");
                        int indexOf2 = str2.indexOf(")");
                        com.opos.cmn.an.f.a.b("Utils", "english first=" + indexOf + ",english last=" + indexOf2);
                        if (-1 == indexOf || -1 == indexOf2) {
                            indexOf = str2.indexOf("（");
                            indexOf2 = str2.indexOf("）");
                            com.opos.cmn.an.f.a.b("Utils", "chinese first=" + indexOf + ",chinese last=" + indexOf2);
                        }
                        if (-1 != indexOf && -1 != indexOf2 && indexOf2 > indexOf) {
                            str2 = str2.substring(0, indexOf) + str2.substring(indexOf2 + 1, str2.length());
                        }
                        int indexOf3 = str2.indexOf("-");
                        com.opos.cmn.an.f.a.b("Utils", "english - =" + indexOf3);
                        if (-1 == indexOf3) {
                            indexOf3 = str2.indexOf("—");
                            com.opos.cmn.an.f.a.b("Utils", "chinese — =" + indexOf3);
                        }
                        if (-1 != indexOf3) {
                            str3 = str2.substring(0, indexOf3);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
                    str3 = str2;
                    com.opos.cmn.an.f.a.b("Utils", "getAppDefaultTitle=" + str3);
                    return str3;
                }
                str3 = str2;
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getAppDefaultTitle=" + str3);
        return str3;
    }

    public static boolean c() {
        return b.f20109b;
    }

    public static long d(Context context, String str) {
        long j2 = 0;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    j2 = h(context).a(str, 0L);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRewardTime pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",timestamp=");
        sb.append(j2);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return j2;
    }

    private static String d(Context context) {
        String str = "";
        try {
            str = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getCurrentActivityName=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return str;
    }

    private static final String d(String str) {
        try {
            int c2 = c(str);
            if (-1 != c2) {
                str = str.substring(0, c2 - 1);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "result=" + str);
        return str;
    }

    public static boolean d() {
        return com.opos.cmn.an.b.c.b() >= 19;
    }

    public static void e(Context context, String str) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                h(context).a(str);
                com.opos.cmn.an.f.a.b("Utils", "removeRewardTime pkgName=" + str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static boolean e() {
        String str;
        if (!d()) {
            str = "sdk not support android sdk version <19";
        } else {
            if (c()) {
                return true;
            }
            str = "init sdk failed!do nothing.";
        }
        com.opos.cmn.an.f.a.d("Utils", str);
        return false;
    }

    private static boolean e(Context context) {
        boolean z = 2.1666667f <= com.opos.cmn.an.h.f.a.l(context);
        com.opos.cmn.an.f.a.b("Utils", "isCurvedScreenAspectRatio=" + z);
        return z;
    }

    public static int f() {
        return TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK;
    }

    private static boolean f(Context context) {
        boolean z = 2.1111112f == com.opos.cmn.an.h.f.a.l(context);
        com.opos.cmn.an.f.a.b("Utils", "isShapedScreenAspectRatio=" + z);
        return z;
    }

    public static boolean f(Context context, String str) {
        Intent intent;
        String a2;
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                a2 = com.opos.cmn.biz.a.c.a(context);
                com.opos.cmn.an.f.a.b("Utils", "getMarketName=" + a2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
            if (!g(context, a2)) {
                com.opos.cmn.an.f.a.a("Utils", " unsupport Market");
                return z;
            }
            intent.setPackage(a2);
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
            } else {
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            }
            z = true;
        }
        com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp result = " + z);
        return z;
    }

    public static String g() {
        return "opos_mobad_v481004_2022_09_22_release";
    }

    private static boolean g(Context context) {
        float l = com.opos.cmn.an.h.f.a.l(context);
        boolean z = 2.0f == l || 2.0370371f == l;
        com.opos.cmn.an.f.a.b("Utils", "isFullScreenAspectRatio=" + z);
        return z;
    }

    private static boolean g(Context context, String str) {
        boolean z;
        if (context != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
            if (com.opos.cmn.an.h.d.a.d(context, str)) {
                if (h(context, str)) {
                    z = true;
                    com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
        return z;
    }

    public static int h() {
        return 481004;
    }

    private static com.opos.cmn.an.d.d.a h(Context context) {
        com.opos.cmn.an.d.d.a aVar = f20265a;
        if (aVar == null) {
            synchronized (f20266b) {
                aVar = f20265a;
                if (aVar == null) {
                    aVar = new com.opos.cmn.an.d.d.a(context, "mobad.reward.prefs", 0);
                    f20265a = aVar;
                }
            }
        }
        return aVar;
    }

    private static boolean h(Context context, String str) {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (com.opos.cmn.an.h.d.a.h(context, str) != null) {
            if (com.opos.cmn.an.h.d.a.h(context, str).enabled) {
                z = true;
                com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
        return z;
    }

    public static String i() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getUserAgent=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return str;
    }

    public static boolean j() {
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular before=" + b.f20112e);
        boolean z = false;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (b.f20112e) {
            if (!com.opos.mobad.service.f.b().f()) {
                b.f20112e = false;
            }
            z = true;
        }
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b k() {
        /*
            java.lang.String r0 = "Utils"
            java.lang.ref.WeakReference<com.opos.mobad.cmn.service.pkginstall.b$b> r1 = com.opos.mobad.cmn.a.b.f.f20268d     // Catch: java.lang.Exception -> L15
            if (r1 == 0) goto L1b
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Exception -> L15
            if (r1 == 0) goto L1b
            java.lang.ref.WeakReference<com.opos.mobad.cmn.service.pkginstall.b$b> r1 = com.opos.mobad.cmn.a.b.f.f20268d     // Catch: java.lang.Exception -> L15
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Exception -> L15
            com.opos.mobad.cmn.service.pkginstall.b$b r1 = (com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b) r1     // Catch: java.lang.Exception -> L15
            goto L1c
        L15:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L1b:
            r1 = 0
        L1c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getCacheInterBaseAd="
            r2.append(r3)
            if (r1 == 0) goto L2a
            r3 = r1
            goto L2c
        L2a:
            java.lang.String r3 = "null"
        L2c:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.k():com.opos.mobad.cmn.service.pkginstall.b$b");
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT <= 29;
    }
}
