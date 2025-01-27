package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private static final h f6188a = h.a();

    /* renamed from: com.bytedance.pangle.plugin.b$1 */
    static class AnonymousClass1 implements a.InterfaceC0067a {

        /* renamed from: a */
        final /* synthetic */ File f6189a;

        /* renamed from: b */
        final /* synthetic */ String f6190b;

        /* renamed from: c */
        final /* synthetic */ int f6191c;

        /* renamed from: d */
        final /* synthetic */ StringBuffer f6192d;

        AnonymousClass1(File file, String str, int i2, StringBuffer stringBuffer) {
            file = file;
            str = str;
            i2 = i2;
            stringBuffer = stringBuffer;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0067a
        public final void a() {
            b.a(file, str, i2, stringBuffer);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.b$2 */
    static class AnonymousClass2 implements a.InterfaceC0067a {

        /* renamed from: a */
        final /* synthetic */ File f6193a;

        /* renamed from: b */
        final /* synthetic */ String f6194b;

        /* renamed from: c */
        final /* synthetic */ int f6195c;

        /* renamed from: d */
        final /* synthetic */ StringBuffer f6196d;

        /* renamed from: e */
        final /* synthetic */ boolean[] f6197e;

        /* renamed from: com.bytedance.pangle.plugin.b$2$1 */
        final class AnonymousClass1 implements a.InterfaceC0067a {

            /* renamed from: a */
            final /* synthetic */ Map f6198a;

            AnonymousClass1(Map map) {
                f2 = map;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0067a
            public final void a() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                b.a(str, i2, f2, stringBuffer);
            }
        }

        /* renamed from: com.bytedance.pangle.plugin.b$2$2 */
        final class C00722 implements a.InterfaceC0067a {

            /* renamed from: a */
            final /* synthetic */ boolean[] f6200a;

            C00722(boolean[] zArr) {
                zArr2 = zArr;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0067a
            public final void a() {
                boolean[] zArr = zArr2;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                zArr[0] = b.h(file, str, i2, stringBuffer);
            }
        }

        AnonymousClass2(File file, String str, int i2, StringBuffer stringBuffer, boolean[] zArr) {
            file = file;
            str = str;
            i2 = i2;
            stringBuffer = stringBuffer;
            zArr = zArr;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0067a
        public final void a() {
            Map f2 = b.f(file, str, i2, stringBuffer);
            b.c(file, str, i2, stringBuffer);
            b.a(b.g(file, str, i2, stringBuffer), str, i2, stringBuffer);
            if (i.f() || i.b()) {
                boolean[] zArr = {false};
                com.bytedance.pangle.a.a.a(new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.2.1

                    /* renamed from: a */
                    final /* synthetic */ Map f6198a;

                    AnonymousClass1(Map f22) {
                        f2 = f22;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                    public final void a() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.a(str, i2, f2, stringBuffer);
                    }
                }, new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.2.2

                    /* renamed from: a */
                    final /* synthetic */ boolean[] f6200a;

                    C00722(boolean[] zArr2) {
                        zArr2 = zArr2;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                    public final void a() {
                        boolean[] zArr2 = zArr2;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.h(file, str, i2, stringBuffer);
                    }
                });
                zArr[0] = b.a(str, i2, zArr2[0], stringBuffer);
            } else {
                b.a(str, i2, f22, stringBuffer);
                zArr[0] = b.a(str, i2, false, stringBuffer);
                b.a(str, i2);
            }
        }
    }

    public static class a extends IOException {
        /* synthetic */ a(String str, byte b2) {
            this(str);
        }

        /* synthetic */ a(String str, Throwable th, byte b2) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    static boolean a(File file, String str, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        boolean[] zArr = {false};
        try {
            h hVar = f6188a;
            hVar.a(1000, 0, str, i2, null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f6009e, b.a.r, str, i2, -1L, null);
            int b2 = l.a().b(str, i2, "install");
            int b3 = l.a().b(str, i2, "load");
            int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (b2 > 3 || b3 > 3) {
                removeApkEntryFlag = 0;
            }
            SharedPreferences.Editor edit = l.a().f6339a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i2, removeApkEntryFlag);
            edit.apply();
            l.a().c(str, i2, false);
            g.a(com.bytedance.pangle.d.c.a(str, i2));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.1

                /* renamed from: a */
                final /* synthetic */ File f6189a;

                /* renamed from: b */
                final /* synthetic */ String f6190b;

                /* renamed from: c */
                final /* synthetic */ int f6191c;

                /* renamed from: d */
                final /* synthetic */ StringBuffer f6192d;

                AnonymousClass1(File file2, String str2, int i22, StringBuffer stringBuffer2) {
                    file = file2;
                    str = str2;
                    i2 = i22;
                    stringBuffer = stringBuffer2;
                }

                @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                public final void a() {
                    b.a(file, str, i2, stringBuffer);
                }
            }, new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.2

                /* renamed from: a */
                final /* synthetic */ File f6193a;

                /* renamed from: b */
                final /* synthetic */ String f6194b;

                /* renamed from: c */
                final /* synthetic */ int f6195c;

                /* renamed from: d */
                final /* synthetic */ StringBuffer f6196d;

                /* renamed from: e */
                final /* synthetic */ boolean[] f6197e;

                /* renamed from: com.bytedance.pangle.plugin.b$2$1 */
                final class AnonymousClass1 implements a.InterfaceC0067a {

                    /* renamed from: a */
                    final /* synthetic */ Map f6198a;

                    AnonymousClass1(Map f22) {
                        f2 = f22;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                    public final void a() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.a(str, i2, f2, stringBuffer);
                    }
                }

                /* renamed from: com.bytedance.pangle.plugin.b$2$2 */
                final class C00722 implements a.InterfaceC0067a {

                    /* renamed from: a */
                    final /* synthetic */ boolean[] f6200a;

                    C00722(boolean[] zArr2) {
                        zArr2 = zArr2;
                    }

                    @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                    public final void a() {
                        boolean[] zArr2 = zArr2;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.h(file, str, i2, stringBuffer);
                    }
                }

                AnonymousClass2(File file2, String str2, int i22, StringBuffer stringBuffer2, boolean[] zArr2) {
                    file = file2;
                    str = str2;
                    i2 = i22;
                    stringBuffer = stringBuffer2;
                    zArr = zArr2;
                }

                @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                public final void a() {
                    Map f22 = b.f(file, str, i2, stringBuffer);
                    b.c(file, str, i2, stringBuffer);
                    b.a(b.g(file, str, i2, stringBuffer), str, i2, stringBuffer);
                    if (i.f() || i.b()) {
                        boolean[] zArr2 = {false};
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.2.1

                            /* renamed from: a */
                            final /* synthetic */ Map f6198a;

                            AnonymousClass1(Map f222) {
                                f2 = f222;
                            }

                            @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i2, f2, stringBuffer);
                            }
                        }, new a.InterfaceC0067a() { // from class: com.bytedance.pangle.plugin.b.2.2

                            /* renamed from: a */
                            final /* synthetic */ boolean[] f6200a;

                            C00722(boolean[] zArr22) {
                                zArr2 = zArr22;
                            }

                            @Override // com.bytedance.pangle.a.a.InterfaceC0067a
                            public final void a() {
                                boolean[] zArr22 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr22[0] = b.h(file, str, i2, stringBuffer);
                            }
                        });
                        zArr[0] = b.a(str, i2, zArr22[0], stringBuffer);
                    } else {
                        b.a(str, i2, f222, stringBuffer);
                        zArr[0] = b.a(str, i2, false, stringBuffer);
                        b.a(str, i2);
                    }
                }
            });
            g.a(file2);
            a(com.bytedance.pangle.c.b.f6010f, b.a.s, str2, i22, a2.a(), stringBuffer2.toString());
            a2.a(bw.o);
            hVar.a(1100, 0, str2, i22, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f6010f, b.a.t, str2, i22, -1L, stringBuffer2.toString());
                f6188a.a(1100, -1, str2, i22, th);
            }
            if (zArr2[0]) {
                l.a().a(str2, i22, "install");
            }
            return false;
        }
    }

    static /* synthetic */ void c(File file, String str, int i2, StringBuffer stringBuffer) {
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
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f6010f, b.a.v, str, i2, -1L, null);
                f6188a.a(1100, -4, str, i2, e2);
                throw new a("安装包权限校验失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static Map<String, List<ZipEntry>> f(File file, String str, int i2, StringBuffer stringBuffer) {
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                e<Boolean, Map<String, List<ZipEntry>>> a2 = com.bytedance.pangle.d.b.a(file);
                boolean booleanValue = a2.f6330a.booleanValue();
                Map<String, List<ZipEntry>> map = a2.f6331b;
                if (booleanValue) {
                    return map;
                }
                throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f6010f, b.a.A, str, i2, -1L, null);
                f6188a.a(1100, -5, str, i2, e2);
                throw new a("插件包包含so不符合宿主ABI类型", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static String g(File file, String str, int i2, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b2 = com.bytedance.pangle.d.c.b(str, i2);
        try {
            try {
                com.bytedance.pangle.util.h.a(file.getAbsolutePath(), b2);
                return b2;
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f6010f, b.a.w, str, i2, -1L, null);
                f6188a.a(1100, -6, str, i2, e2);
                throw new a("安装包拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023e: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:92:0x023e */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0242: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:88:0x0242 */
    public static boolean h(java.io.File r21, java.lang.String r22, int r23, java.lang.StringBuffer r24) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.b.h(java.io.File, java.lang.String, int, java.lang.StringBuffer):boolean");
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j2))));
            jSONObject2.putOpt(com.heytap.mcssdk.n.d.l, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    static /* synthetic */ void a(File file, String str, int i2, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f6010f, b.a.u, str, i2, -1L, null);
                f6188a.a(1100, -3, str, i2, e2);
                throw new a(e2.getMessage(), e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    static /* synthetic */ void a(String str, String str2, int i2, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int a2 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(a2 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (a2 == 100 || a2 == 200) {
            return;
        }
        String sb2 = sb.toString();
        a(com.bytedance.pangle.c.b.f6010f, b.a.B, str2, i2, -1L, sb2);
        f6188a.a(1100, -2, str2, i2, null);
        throw new a("modifyRes failed. result = " + a2 + ", errorLog = " + sb2, (byte) 0);
    }

    static /* synthetic */ void a(String str, int i2, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i2)), new File(com.bytedance.pangle.d.c.d(str, i2)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f6010f, b.a.x, str, i2, -1L, null);
                f6188a.a(1100, -7, str, i2, e2);
                throw new a("安装包动态库拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    static /* synthetic */ boolean a(String str, int i2, boolean z, StringBuffer stringBuffer) {
        int b2 = l.a().b(str, i2);
        boolean z2 = (b2 & 1) != 0;
        boolean z3 = (b2 & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String b3 = com.bytedance.pangle.d.c.b(str, i2);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = com.bytedance.pangle.util.b.b.a(b3, z4, z3, str, i2, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return a2;
    }

    static /* synthetic */ void a(String str, int i2) {
        try {
            if (i.e() || i.g()) {
                l.a().b(str, i2, false);
                com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i2).apply();
                f.a();
            }
        } catch (Exception e2) {
            a(com.bytedance.pangle.c.b.f6010f, b.a.z, str, i2, -1L, null);
            throw new a("dexOpt2失败", e2, (byte) 0);
        }
    }
}
