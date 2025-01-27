package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class U implements Runnable {

    /* renamed from: a */
    public int f25004a;

    /* renamed from: b */
    public int f25005b;

    /* renamed from: c */
    private final Context f25006c;

    /* renamed from: d */
    private final int f25007d;

    /* renamed from: e */
    private final byte[] f25008e;

    /* renamed from: f */
    private final com.tencent.bugly.crashreport.common.info.a f25009f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.strategy.c f25010g;

    /* renamed from: h */
    private final O f25011h;

    /* renamed from: i */
    private final T f25012i;

    /* renamed from: j */
    private final int f25013j;
    private final P k;
    private final P l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    protected int p;
    protected long q;
    protected long r;
    private boolean s;

    public U(Context context, int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, p, z, 2, 30000, z2, null);
    }

    protected void a() {
        this.f25012i.a(this.f25013j, System.currentTimeMillis());
        P p = this.k;
        if (p != null) {
            p.a(this.f25007d);
        }
        P p2 = this.l;
        if (p2 != null) {
            p2.a(this.f25007d);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.crashreport.common.strategy.c cVar;
        int i2 = 0;
        try {
            this.p = 0;
            this.q = 0L;
            this.r = 0L;
            byte[] bArr = this.f25008e;
            if (com.tencent.bugly.crashreport.common.info.b.c(this.f25006c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr == null || bArr.length == 0) {
                a(null, false, 0, "request package is empty!", 0);
                return;
            }
            X.a("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f25007d));
            if (this.f25006c != null && this.f25009f != null && (cVar = this.f25010g) != null && this.f25011h != null) {
                StrategyBean c2 = cVar.c();
                if (c2 == null) {
                    a(null, false, 0, "illegal local strategy", 0);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tls", "1");
                hashMap.put("prodId", this.f25009f.e());
                hashMap.put("bundleId", this.f25009f.f24754g);
                hashMap.put("appVer", this.f25009f.E);
                Map<String, String> map = this.o;
                if (map != null) {
                    hashMap.putAll(map);
                }
                hashMap.put("cmd", Integer.toString(this.f25007d));
                hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
                hashMap.put("sdkVer", this.f25009f.l);
                hashMap.put("strategylastUpdateTime", Long.toString(c2.o));
                byte[] b2 = ca.b(bArr, 2);
                if (b2 == null) {
                    a(null, false, 0, "failed to zip request body", 0);
                    return;
                }
                a();
                String str = this.m;
                int i3 = 0;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 >= this.f25004a) {
                        a(null, false, i3, "failed after many attempts", 0);
                        return;
                    }
                    if (i6 > 1) {
                        X.e("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                        ca.c(this.f25005b);
                        if (i6 == this.f25004a) {
                            X.e("[Upload] Use the back-up url at the last time: %s", this.n);
                            str = this.n;
                        }
                    }
                    X.a("[Upload] Send %d bytes", Integer.valueOf(b2.length));
                    str = a(str);
                    X.a("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str, Integer.valueOf(this.f25007d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a2 = this.f25011h.a(str, b2, this, hashMap);
                    if (a2 == null) {
                        a(1, "Failed to upload for no response!");
                    } else {
                        Map<String, String> map2 = this.f25011h.f24988c;
                        if (a(map2)) {
                            try {
                                int parseInt = Integer.parseInt(map2.get("status"));
                                X.a("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(parseInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (parseInt != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("status of server is ");
                                    sb.append(parseInt);
                                    a(null, false, 1, sb.toString(), parseInt);
                                    return;
                                }
                                X.a("[Upload] Received %d bytes", Integer.valueOf(a2.length));
                                if (a2.length == 0) {
                                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                                        X.a("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                                    }
                                    a(null, false, 1, "response data from server is empty", 0);
                                    return;
                                }
                                byte[] a3 = ca.a(a2, 2);
                                if (a3 != null) {
                                    a2 = a3;
                                }
                                qa a4 = M.a(a2, c2, true);
                                if (a4 == null) {
                                    a(null, false, 1, "failed to decode response package", 0);
                                    return;
                                }
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(a4.f25127d);
                                byte[] bArr2 = a4.f25128e;
                                if (bArr2 != null) {
                                    i2 = bArr2.length;
                                }
                                objArr[1] = Integer.valueOf(i2);
                                X.a("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                if (a(a4, this.f25009f, this.f25010g)) {
                                    a(a4, true, 2, "successfully uploaded", 0);
                                    return;
                                } else {
                                    a(a4, false, 2, "failed to process response package", 0);
                                    return;
                                }
                            } catch (Throwable unused) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[Upload] Failed to upload for format of status header is invalid: ");
                                sb2.append(Integer.toString(i4));
                                a(1, sb2.toString());
                            }
                        } else {
                            X.a("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            a(1, "[Upload] Failed to upload for no status header.");
                            if (map2 != null) {
                                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                                    X.a(String.format("[key]: %s, [value]: %s", entry2.getKey(), entry2.getValue()), new Object[0]);
                                }
                            }
                            X.a("[Upload] Failed to upload for no status header.", new Object[0]);
                        }
                    }
                    i5 = i6;
                    i3 = 1;
                }
            }
            a(null, false, 0, "illegal access error", 0);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public U(Context context, int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.f25004a = 2;
        this.f25005b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.f25006c = context;
        this.f25009f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f25008e = bArr;
        this.f25010g = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f25011h = O.a(context);
        T a2 = T.a();
        this.f25012i = a2;
        this.f25013j = i2;
        this.m = str;
        this.n = str2;
        this.k = p;
        this.l = a2.f24997d;
        this.f25007d = i3;
        if (i4 > 0) {
            this.f25004a = i4;
        }
        if (i5 > 0) {
            this.f25005b = i5;
        }
        this.s = z2;
        this.o = map;
    }

    protected void a(int i2, String str) {
        X.b("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(com.tencent.bugly.proguard.qa r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            int r1 = r0.f25007d
            r2 = 630(0x276, float:8.83E-43)
            if (r1 == r2) goto L1b
            r2 = 640(0x280, float:8.97E-43)
            if (r1 == r2) goto L18
            r2 = 830(0x33e, float:1.163E-42)
            if (r1 == r2) goto L1b
            r2 = 840(0x348, float:1.177E-42)
            if (r1 == r2) goto L18
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L1d
        L18:
            java.lang.String r1 = "userinfo"
            goto L1d
        L1b:
            java.lang.String r1 = "crash"
        L1d:
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            java.lang.String r1 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.X.c(r1, r2)
            goto L3e
        L2b:
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4[r3] = r5
            r4[r2] = r1
            r1 = 2
            r4[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.X.b(r1, r4)
        L3e:
            long r1 = r0.q
            long r3 = r0.r
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L5e
            com.tencent.bugly.proguard.T r1 = r0.f25012i
            boolean r2 = r0.s
            long r1 = r1.a(r2)
            long r3 = r0.q
            long r1 = r1 + r3
            long r3 = r0.r
            long r1 = r1 + r3
            com.tencent.bugly.proguard.T r3 = r0.f25012i
            boolean r4 = r0.s
            r3.a(r1, r4)
        L5e:
            com.tencent.bugly.proguard.P r4 = r0.k
            if (r4 == 0) goto L6f
            int r5 = r0.f25007d
            long r7 = r0.q
            long r9 = r0.r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L6f:
            com.tencent.bugly.proguard.P r4 = r0.l
            if (r4 == 0) goto L80
            int r5 = r0.f25007d
            long r7 = r0.q
            long r9 = r0.r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.U.a(com.tencent.bugly.proguard.qa, boolean, int, java.lang.String, int):void");
    }

    protected boolean a(qa qaVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        if (qaVar == null) {
            X.e("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = qaVar.f25126c;
        if (b2 != 0) {
            X.b("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!ca.b(qaVar.f25132i) && !com.tencent.bugly.crashreport.common.info.a.m().q().equals(qaVar.f25132i)) {
                J.a().a(com.tencent.bugly.crashreport.common.strategy.c.f24774a, "device", qaVar.f25132i.getBytes("UTF-8"), (I) null, true);
                aVar.f(qaVar.f25132i);
            }
        } catch (Throwable th) {
            X.b(th);
        }
        aVar.u = qaVar.f25130g;
        int i2 = qaVar.f25127d;
        if (i2 == 510) {
            byte[] bArr = qaVar.f25128e;
            if (bArr == null) {
                X.b("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            sa saVar = (sa) M.a(bArr, sa.class);
            if (saVar == null) {
                X.b("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(qaVar.f25127d));
                return false;
            }
            cVar.a(saVar);
        }
        return true;
    }

    public void a(String str, long j2, String str2) {
        this.p++;
        this.q += j2;
    }

    public void a(long j2) {
        this.r += j2;
    }

    private static String a(String str) {
        if (ca.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            X.b(th);
            return str;
        }
    }

    private static boolean a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (!map.containsKey("status")) {
                X.e("[Upload] Headers does not contain %s", "status");
                return false;
            }
            if (!map.containsKey("Bugly-Version")) {
                X.e("[Upload] Headers does not contain %s", "Bugly-Version");
                return false;
            }
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                X.e("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            X.a("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
        X.e("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
