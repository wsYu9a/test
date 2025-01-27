package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import hf.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a */
    private static final i f7695a = i.a();

    /* renamed from: com.bytedance.pangle.plugin.b$1 */
    public static class AnonymousClass1 implements a.InterfaceC0226a {

        /* renamed from: a */
        final /* synthetic */ File f7696a;

        /* renamed from: b */
        final /* synthetic */ String f7697b;

        /* renamed from: c */
        final /* synthetic */ int f7698c;

        /* renamed from: d */
        final /* synthetic */ StringBuffer f7699d;

        public AnonymousClass1(File file, String str, int i10, StringBuffer stringBuffer) {
            file = file;
            str = str;
            i10 = i10;
            stringBuffer = stringBuffer;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0226a
        public final void a() {
            b.a(file, str, i10, stringBuffer);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.b$2 */
    public static class AnonymousClass2 implements a.InterfaceC0226a {

        /* renamed from: a */
        final /* synthetic */ File f7700a;

        /* renamed from: b */
        final /* synthetic */ String f7701b;

        /* renamed from: c */
        final /* synthetic */ int f7702c;

        /* renamed from: d */
        final /* synthetic */ StringBuffer f7703d;

        /* renamed from: e */
        final /* synthetic */ boolean[] f7704e;

        /* renamed from: com.bytedance.pangle.plugin.b$2$1 */
        public class AnonymousClass1 implements a.InterfaceC0226a {

            /* renamed from: a */
            final /* synthetic */ Map f7705a;

            public AnonymousClass1(Map map) {
                f10 = map;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0226a
            public final void a() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                b.a(str, i10, f10, stringBuffer);
            }
        }

        /* renamed from: com.bytedance.pangle.plugin.b$2$2 */
        public class C02322 implements a.InterfaceC0226a {

            /* renamed from: a */
            final /* synthetic */ boolean[] f7707a;

            public C02322(boolean[] zArr) {
                zArr2 = zArr;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0226a
            public final void a() {
                boolean[] zArr = zArr2;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                zArr[0] = b.h(file, str, i10, stringBuffer);
            }
        }

        public AnonymousClass2(File file, String str, int i10, StringBuffer stringBuffer, boolean[] zArr) {
            file = file;
            str = str;
            i10 = i10;
            stringBuffer = stringBuffer;
            zArr = zArr;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0226a
        public final void a() {
            Map f10 = b.f(file, str, i10, stringBuffer);
            b.c(file, str, i10, stringBuffer);
            b.a(b.g(file, str, i10, stringBuffer), str, i10, stringBuffer);
            if (com.bytedance.pangle.util.i.f() || com.bytedance.pangle.util.i.b()) {
                boolean[] zArr = {false};
                com.bytedance.pangle.a.a.a(new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.2.1

                    /* renamed from: a */
                    final /* synthetic */ Map f7705a;

                    public AnonymousClass1(Map f102) {
                        f10 = f102;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                    public final void a() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.a(str, i10, f10, stringBuffer);
                    }
                }, new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.2.2

                    /* renamed from: a */
                    final /* synthetic */ boolean[] f7707a;

                    public C02322(boolean[] zArr2) {
                        zArr2 = zArr2;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                    public final void a() {
                        boolean[] zArr2 = zArr2;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.h(file, str, i10, stringBuffer);
                    }
                });
                zArr[0] = b.a(str, i10, zArr2[0], stringBuffer);
            } else {
                b.a(str, i10, f102, stringBuffer);
                zArr[0] = b.a(str, i10, false, stringBuffer);
                b.a(str, i10);
            }
        }
    }

    public static class a extends IOException {
        public /* synthetic */ a(String str, byte b10) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th2, byte b10) {
            this(str, th2);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static boolean a(File file, String str, int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        boolean[] zArr = {false};
        try {
            i iVar = f7695a;
            iVar.a(1000, 0, str, i10, null);
            com.bytedance.pangle.log.a a10 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f7486e, b.a.f7512r, str, i10, -1L, null);
            int b10 = l.a().b(str, i10, "install");
            int b11 = l.a().b(str, i10, "load");
            int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (b10 > 3 || b11 > 3) {
                removeApkEntryFlag = 0;
            }
            SharedPreferences.Editor edit = l.a().f7862a.edit();
            edit.putInt("remove_entry_flag_" + str + e.f26694a + i10, removeApkEntryFlag);
            edit.apply();
            l.a().c(str, i10, false);
            g.a(com.bytedance.pangle.d.c.a(str, i10));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.1

                /* renamed from: a */
                final /* synthetic */ File f7696a;

                /* renamed from: b */
                final /* synthetic */ String f7697b;

                /* renamed from: c */
                final /* synthetic */ int f7698c;

                /* renamed from: d */
                final /* synthetic */ StringBuffer f7699d;

                public AnonymousClass1(File file2, String str2, int i102, StringBuffer stringBuffer2) {
                    file = file2;
                    str = str2;
                    i10 = i102;
                    stringBuffer = stringBuffer2;
                }

                @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                public final void a() {
                    b.a(file, str, i10, stringBuffer);
                }
            }, new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.2

                /* renamed from: a */
                final /* synthetic */ File f7700a;

                /* renamed from: b */
                final /* synthetic */ String f7701b;

                /* renamed from: c */
                final /* synthetic */ int f7702c;

                /* renamed from: d */
                final /* synthetic */ StringBuffer f7703d;

                /* renamed from: e */
                final /* synthetic */ boolean[] f7704e;

                /* renamed from: com.bytedance.pangle.plugin.b$2$1 */
                public class AnonymousClass1 implements a.InterfaceC0226a {

                    /* renamed from: a */
                    final /* synthetic */ Map f7705a;

                    public AnonymousClass1(Map f102) {
                        f10 = f102;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                    public final void a() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.a(str, i10, f10, stringBuffer);
                    }
                }

                /* renamed from: com.bytedance.pangle.plugin.b$2$2 */
                public class C02322 implements a.InterfaceC0226a {

                    /* renamed from: a */
                    final /* synthetic */ boolean[] f7707a;

                    public C02322(boolean[] zArr2) {
                        zArr2 = zArr2;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                    public final void a() {
                        boolean[] zArr2 = zArr2;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.h(file, str, i10, stringBuffer);
                    }
                }

                public AnonymousClass2(File file2, String str2, int i102, StringBuffer stringBuffer2, boolean[] zArr2) {
                    file = file2;
                    str = str2;
                    i10 = i102;
                    stringBuffer = stringBuffer2;
                    zArr = zArr2;
                }

                @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                public final void a() {
                    Map f102 = b.f(file, str, i10, stringBuffer);
                    b.c(file, str, i10, stringBuffer);
                    b.a(b.g(file, str, i10, stringBuffer), str, i10, stringBuffer);
                    if (com.bytedance.pangle.util.i.f() || com.bytedance.pangle.util.i.b()) {
                        boolean[] zArr2 = {false};
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.2.1

                            /* renamed from: a */
                            final /* synthetic */ Map f7705a;

                            public AnonymousClass1(Map f1022) {
                                f10 = f1022;
                            }

                            @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i10, f10, stringBuffer);
                            }
                        }, new a.InterfaceC0226a() { // from class: com.bytedance.pangle.plugin.b.2.2

                            /* renamed from: a */
                            final /* synthetic */ boolean[] f7707a;

                            public C02322(boolean[] zArr22) {
                                zArr2 = zArr22;
                            }

                            @Override // com.bytedance.pangle.a.a.InterfaceC0226a
                            public final void a() {
                                boolean[] zArr22 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr22[0] = b.h(file, str, i10, stringBuffer);
                            }
                        });
                        zArr[0] = b.a(str, i10, zArr22[0], stringBuffer);
                    } else {
                        b.a(str, i10, f1022, stringBuffer);
                        zArr[0] = b.a(str, i10, false, stringBuffer);
                        b.a(str, i10);
                    }
                }
            });
            g.a(file2);
            a(com.bytedance.pangle.c.b.f7487f, b.a.f7513s, str2, i102, a10.a(), stringBuffer2.toString());
            a10.a("success");
            iVar.a(1100, 0, str2, i102, null);
            return true;
        } catch (Throwable th2) {
            if (th2 instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed.", th2);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed unknown error.", th2);
                a(com.bytedance.pangle.c.b.f7487f, b.a.f7514t, str2, i102, -1L, stringBuffer2.toString());
                f7695a.a(1100, -1, str2, i102, th2);
            }
            if (zArr2[0]) {
                l.a().a(str2, i102, "install");
            }
            return false;
        }
    }

    public static /* synthetic */ void c(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                        }
                    }
                }
            } catch (Exception e10) {
                a(com.bytedance.pangle.c.b.f7487f, b.a.f7516v, str, i10, -1L, null);
                f7695a.a(1100, -4, str, i10, e10);
                throw new a("安装包权限校验失败", e10, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static Map<String, List<ZipEntry>> f(File file, String str, int i10, StringBuffer stringBuffer) {
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> a10 = com.bytedance.pangle.d.b.a(file);
                boolean booleanValue = a10.f7853a.booleanValue();
                Map<String, List<ZipEntry>> map = a10.f7854b;
                if (booleanValue) {
                    return map;
                }
                throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
            } catch (Exception e10) {
                a(com.bytedance.pangle.c.b.f7487f, b.a.A, str, i10, -1L, null);
                f7695a.a(1100, -5, str, i10, e10);
                throw new a("插件包包含so不符合宿主ABI类型", e10, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static String g(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b10 = com.bytedance.pangle.d.c.b(str, i10);
        try {
            try {
                h.a(file.getAbsolutePath(), b10);
                return b10;
            } catch (Exception e10) {
                a(com.bytedance.pangle.c.b.f7487f, b.a.f7517w, str, i10, -1L, null);
                f7695a.a(1100, -6, str, i10, e10);
                throw new a("安装包拷贝失败", e10, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01ab: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:102:0x01ab */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01b0: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:100:0x01b0 */
    public static boolean h(File file, String str, int i10, StringBuffer stringBuffer) {
        String str2;
        String str3;
        String str4;
        String str5;
        ZipEntry zipEntry;
        String str6 = ".dex";
        String str7 = "classes";
        String str8 = ";";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                int i11 = 1;
                try {
                    if (com.bytedance.pangle.util.i.b()) {
                        try {
                            if (!file.exists() || str == null) {
                                throw new IOException("Could not check apk info " + file.getAbsolutePath());
                            }
                            ZipFile zipFile = null;
                            try {
                                ZipFile zipFile2 = new ZipFile(file);
                                try {
                                    ArrayList arrayList = new ArrayList();
                                    File file2 = new File(com.bytedance.pangle.d.c.i(str, i10));
                                    com.bytedance.pangle.e.g.a(file2);
                                    int i12 = 1;
                                    while (true) {
                                        StringBuilder sb2 = new StringBuilder(str7);
                                        sb2.append(i12 == i11 ? "" : Integer.valueOf(i12));
                                        sb2.append(str6);
                                        ZipEntry entry = zipFile2.getEntry(sb2.toString());
                                        if (entry == null) {
                                            str4 = str8;
                                            file.getName();
                                            SharedPreferences.Editor edit = com.bytedance.pangle.e.g.a().edit();
                                            edit.putInt((str + "-" + i10) + ".dex.number", arrayList.size());
                                            edit.commit();
                                            g.a(zipFile2);
                                            com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i10).apply();
                                            f.a();
                                            break;
                                        }
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(str7);
                                        String str9 = str8;
                                        try {
                                            sb3.append(i12 != 1 ? Integer.valueOf(i12) : "");
                                            sb3.append(str6);
                                            g.a aVar = new g.a(file2, sb3.toString());
                                            String str10 = str6;
                                            int i13 = 0;
                                            boolean z10 = false;
                                            while (i13 < 3 && !z10) {
                                                try {
                                                    com.bytedance.pangle.e.g.a(zipFile2, entry, aVar, str7);
                                                    str5 = str7;
                                                    zipEntry = entry;
                                                    z10 = true;
                                                } catch (IOException e10) {
                                                    str5 = str7;
                                                    zipEntry = entry;
                                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + aVar.getAbsolutePath(), e10);
                                                }
                                                int i14 = i13 + 1;
                                                StringBuilder sb4 = new StringBuilder("Plugin-MultiDex Extraction ");
                                                sb4.append(z10 ? "succeeded" : p3.e.f29726i);
                                                sb4.append(" '");
                                                sb4.append(aVar.getAbsolutePath());
                                                sb4.append("': length ");
                                                sb4.append(aVar.length());
                                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb4.toString());
                                                if (!z10) {
                                                    aVar.delete();
                                                    if (aVar.exists()) {
                                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                                                    }
                                                }
                                                i13 = i14;
                                                str7 = str5;
                                                entry = zipEntry;
                                            }
                                            String str11 = str7;
                                            if (!z10) {
                                                throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i12 + ")");
                                            }
                                            arrayList.add(aVar);
                                            i12++;
                                            str6 = str10;
                                            str8 = str9;
                                            str7 = str11;
                                            i11 = 1;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zipFile = zipFile2;
                                            com.bytedance.pangle.util.g.a(zipFile);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            a(com.bytedance.pangle.c.b.f7487f, b.a.f7520z, str, i10, -1L, null);
                            throw new a("dexOpt1失败", e, (byte) 0);
                        } catch (Throwable th5) {
                            th = th5;
                            stringBuffer.append("dexOpt1 cost:");
                            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                            stringBuffer.append(str8);
                            throw th;
                        }
                    } else {
                        str4 = ";";
                        if (com.bytedance.pangle.util.i.f()) {
                            String c10 = com.bytedance.pangle.d.c.c(str, i10);
                            String b10 = com.bytedance.pangle.d.c.b(str, i10);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(c10);
                            String str12 = File.separator;
                            sb5.append(str12);
                            sb5.append(com.bytedance.pangle.e.b.a(b10));
                            String sb6 = sb5.toString();
                            if (com.bytedance.pangle.e.b.a(b10, c10 + str12 + com.bytedance.pangle.e.b.a(b10)) && com.bytedance.pangle.e.b.a(sb6)) {
                                stringBuffer.append("dexOpt1 cost:");
                                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                                stringBuffer.append(str4);
                                return true;
                            }
                        }
                    }
                    String str13 = str4;
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(str13);
                    return false;
                } catch (Exception e12) {
                    e = e12;
                    str8 = str3;
                } catch (Throwable th6) {
                    th = th6;
                    str8 = str2;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    private static void a(String str, int i10, @NonNull String str2, int i11, long j10, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i10)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i11)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j10))));
            jSONObject2.putOpt(b7.d.f1362o, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static /* synthetic */ void a(File file, String str, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e10) {
                a(com.bytedance.pangle.c.b.f7487f, b.a.f7515u, str, i10, -1L, null);
                f7695a.a(1100, -3, str, i10, e10);
                throw new a(e10.getMessage(), e10, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static /* synthetic */ void a(String str, String str2, int i10, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        int a10 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb2);
        stringBuffer.append(a10 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (a10 == 100 || a10 == 200) {
            return;
        }
        String sb3 = sb2.toString();
        a(com.bytedance.pangle.c.b.f7487f, b.a.B, str2, i10, -1L, sb3);
        f7695a.a(1100, -2, str2, i10, null);
        throw new a("modifyRes failed. result = " + a10 + ", errorLog = " + sb3, (byte) 0);
    }

    public static /* synthetic */ void a(String str, int i10, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i10)), new File(com.bytedance.pangle.d.c.d(str, i10)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e10) {
                a(com.bytedance.pangle.c.b.f7487f, b.a.f7518x, str, i10, -1L, com.bytedance.pangle.log.b.a((Object) e10));
                f7695a.a(1100, -7, str, i10, e10);
                throw new a("安装包动态库拷贝失败", e10, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static /* synthetic */ boolean a(String str, int i10, boolean z10, StringBuffer stringBuffer) {
        int b10 = l.a().b(str, i10);
        boolean z11 = (b10 & 1) != 0;
        boolean z12 = (b10 & 2) != 0;
        if (!z11 && !z12) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z13 = z10 && z11;
        String b11 = com.bytedance.pangle.d.c.b(str, i10);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a10 = com.bytedance.pangle.util.b.b.a(b11, z13, z12, str, i10, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return a10;
    }

    public static /* synthetic */ void a(String str, int i10) {
        try {
            if (!com.bytedance.pangle.util.i.e() && !com.bytedance.pangle.util.i.g()) {
                return;
            }
            l.a().b(str, i10, false);
            com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i10).apply();
            f.a();
        } catch (Exception e10) {
            a(com.bytedance.pangle.c.b.f7487f, b.a.f7520z, str, i10, -1L, null);
            throw new a("dexOpt2失败", e10, (byte) 0);
        }
    }
}
