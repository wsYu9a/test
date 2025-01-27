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
    public int f22655a;

    /* renamed from: b */
    public int f22656b;

    /* renamed from: c */
    private final Context f22657c;

    /* renamed from: d */
    private final int f22658d;

    /* renamed from: e */
    private final byte[] f22659e;

    /* renamed from: f */
    private final com.tencent.bugly.crashreport.common.info.a f22660f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.strategy.c f22661g;

    /* renamed from: h */
    private final O f22662h;

    /* renamed from: i */
    private final T f22663i;

    /* renamed from: j */
    private final int f22664j;

    /* renamed from: k */
    private final P f22665k;

    /* renamed from: l */
    private final P f22666l;

    /* renamed from: m */
    private String f22667m;

    /* renamed from: n */
    private final String f22668n;

    /* renamed from: o */
    private final Map<String, String> f22669o;

    /* renamed from: p */
    protected int f22670p;

    /* renamed from: q */
    protected long f22671q;

    /* renamed from: r */
    protected long f22672r;

    /* renamed from: s */
    private boolean f22673s;

    public U(Context context, int i10, int i11, byte[] bArr, String str, String str2, P p10, boolean z10, boolean z11) {
        this(context, i10, i11, bArr, str, str2, p10, z10, 2, 30000, z11, null);
    }

    public void a() {
        this.f22663i.a(this.f22664j, System.currentTimeMillis());
        P p10 = this.f22665k;
        if (p10 != null) {
            p10.a(this.f22658d);
        }
        P p11 = this.f22666l;
        if (p11 != null) {
            p11.a(this.f22658d);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.crashreport.common.strategy.c cVar;
        int i10 = 2;
        int i11 = 1;
        try {
            this.f22670p = 0;
            this.f22671q = 0L;
            this.f22672r = 0L;
            byte[] bArr = this.f22659e;
            if (com.tencent.bugly.crashreport.common.info.b.c(this.f22657c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr == null || bArr.length == 0) {
                a(null, false, 0, "request package is empty!", 0);
                return;
            }
            X.a("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f22658d));
            if (this.f22657c != null && this.f22660f != null && (cVar = this.f22661g) != null && this.f22662h != null) {
                StrategyBean c10 = cVar.c();
                if (c10 == null) {
                    a(null, false, 0, "illegal local strategy", 0);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tls", "1");
                hashMap.put("prodId", this.f22660f.e());
                hashMap.put("bundleId", this.f22660f.f22294g);
                hashMap.put("appVer", this.f22660f.E);
                Map<String, String> map = this.f22669o;
                if (map != null) {
                    hashMap.putAll(map);
                }
                hashMap.put("cmd", Integer.toString(this.f22658d));
                hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
                hashMap.put("sdkVer", this.f22660f.f22304l);
                hashMap.put("strategylastUpdateTime", Long.toString(c10.f22351o));
                byte[] b10 = ca.b(bArr, 2);
                if (b10 == null) {
                    a(null, false, 0, "failed to zip request body", 0);
                    return;
                }
                a();
                String str = this.f22667m;
                int i12 = 0;
                int i13 = -1;
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    if (i14 >= this.f22655a) {
                        a(null, false, i12, "failed after many attempts", 0);
                        return;
                    }
                    if (i15 > i11) {
                        Object[] objArr = new Object[i11];
                        objArr[0] = Integer.valueOf(i15);
                        X.e("[Upload] Failed to upload last time, wait and try(%d) again.", objArr);
                        ca.c(this.f22656b);
                        if (i15 == this.f22655a) {
                            Object[] objArr2 = new Object[i11];
                            objArr2[0] = this.f22668n;
                            X.e("[Upload] Use the back-up url at the last time: %s", objArr2);
                            str = this.f22668n;
                        }
                    }
                    Object[] objArr3 = new Object[i11];
                    objArr3[0] = Integer.valueOf(b10.length);
                    X.a("[Upload] Send %d bytes", objArr3);
                    str = a(str);
                    Integer valueOf = Integer.valueOf(this.f22658d);
                    Integer valueOf2 = Integer.valueOf(Process.myPid());
                    Integer valueOf3 = Integer.valueOf(Process.myTid());
                    Object[] objArr4 = new Object[4];
                    objArr4[0] = str;
                    objArr4[i11] = valueOf;
                    objArr4[i10] = valueOf2;
                    objArr4[3] = valueOf3;
                    X.a("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", objArr4);
                    byte[] a10 = this.f22662h.a(str, b10, this, hashMap);
                    if (a10 == null) {
                        a(i11, "Failed to upload for no response!");
                    } else {
                        Map<String, String> map2 = this.f22662h.f22637c;
                        if (a(map2)) {
                            try {
                                i13 = Integer.parseInt(map2.get("status"));
                            } catch (Throwable unused) {
                            }
                            try {
                                X.a("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i13), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (i13 != 0) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("status of server is ");
                                    sb2.append(i13);
                                    a(null, false, 1, sb2.toString(), i13);
                                    return;
                                }
                                X.a("[Upload] Received %d bytes", Integer.valueOf(a10.length));
                                if (a10.length == 0) {
                                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                                        X.a("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                                    }
                                    a(null, false, 1, "response data from server is empty", 0);
                                    return;
                                }
                                byte[] a11 = ca.a(a10, 2);
                                if (a11 != null) {
                                    a10 = a11;
                                }
                                qa a12 = M.a(a10, c10, true);
                                if (a12 == null) {
                                    a(null, false, 1, "failed to decode response package", 0);
                                    return;
                                }
                                Integer valueOf4 = Integer.valueOf(a12.f22831d);
                                byte[] bArr2 = a12.f22832e;
                                X.a("[Upload] Response cmd is: %d, length of sBuffer is: %d", valueOf4, Integer.valueOf(bArr2 == null ? 0 : bArr2.length));
                                if (a(a12, this.f22660f, this.f22661g)) {
                                    a(a12, true, 2, "successfully uploaded", 0);
                                    return;
                                } else {
                                    a(a12, false, 2, "failed to process response package", 0);
                                    return;
                                }
                            } catch (Throwable unused2) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("[Upload] Failed to upload for format of status header is invalid: ");
                                sb3.append(Integer.toString(i13));
                                i11 = 1;
                                a(1, sb3.toString());
                                i14 = i15;
                                i10 = 2;
                                i12 = 1;
                            }
                        } else {
                            Integer valueOf5 = Integer.valueOf(Process.myPid());
                            Integer valueOf6 = Integer.valueOf(Process.myTid());
                            Object[] objArr5 = new Object[i10];
                            objArr5[0] = valueOf5;
                            objArr5[i11] = valueOf6;
                            X.a("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", objArr5);
                            a(i11, "[Upload] Failed to upload for no status header.");
                            if (map2 != null) {
                                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                                    String key = entry2.getKey();
                                    String value = entry2.getValue();
                                    Object[] objArr6 = new Object[i10];
                                    objArr6[0] = key;
                                    objArr6[i11] = value;
                                    X.a(String.format("[key]: %s, [value]: %s", objArr6), new Object[0]);
                                }
                            }
                            X.a("[Upload] Failed to upload for no status header.", new Object[0]);
                        }
                    }
                    i14 = i15;
                    i12 = 1;
                }
            }
            a(null, false, 0, "illegal access error", 0);
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public U(Context context, int i10, int i11, byte[] bArr, String str, String str2, P p10, boolean z10, int i12, int i13, boolean z11, Map<String, String> map) {
        this.f22655a = 2;
        this.f22656b = 30000;
        this.f22667m = null;
        this.f22670p = 0;
        this.f22671q = 0L;
        this.f22672r = 0L;
        this.f22673s = false;
        this.f22657c = context;
        this.f22660f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f22659e = bArr;
        this.f22661g = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f22662h = O.a(context);
        T a10 = T.a();
        this.f22663i = a10;
        this.f22664j = i10;
        this.f22667m = str;
        this.f22668n = str2;
        this.f22665k = p10;
        this.f22666l = a10.f22646d;
        this.f22658d = i11;
        if (i12 > 0) {
            this.f22655a = i12;
        }
        if (i13 > 0) {
            this.f22656b = i13;
        }
        this.f22673s = z11;
        this.f22669o = map;
    }

    public void a(int i10, String str) {
        X.b("[Upload] Failed to upload(%d): %s", Integer.valueOf(i10), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tencent.bugly.proguard.qa r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            r1 = 0
            r2 = 1
            int r3 = r0.f22658d
            r4 = 630(0x276, float:8.83E-43)
            if (r3 == r4) goto L1d
            r4 = 640(0x280, float:8.97E-43)
            if (r3 == r4) goto L1a
            r4 = 830(0x33e, float:1.163E-42)
            if (r3 == r4) goto L1d
            r4 = 840(0x348, float:1.177E-42)
            if (r3 == r4) goto L1a
            java.lang.String r3 = java.lang.String.valueOf(r3)
            goto L1f
        L1a:
            java.lang.String r3 = "userinfo"
            goto L1f
        L1d:
            java.lang.String r3 = "crash"
        L1f:
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r3
            java.lang.String r1 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.X.c(r1, r2)
            goto L3e
        L2b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r4
            r5[r2] = r3
            r1 = 2
            r5[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.X.b(r1, r5)
        L3e:
            long r1 = r0.f22671q
            long r3 = r0.f22672r
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L5e
            com.tencent.bugly.proguard.T r1 = r0.f22663i
            boolean r2 = r0.f22673s
            long r1 = r1.a(r2)
            long r3 = r0.f22671q
            long r1 = r1 + r3
            long r3 = r0.f22672r
            long r1 = r1 + r3
            com.tencent.bugly.proguard.T r3 = r0.f22663i
            boolean r4 = r0.f22673s
            r3.a(r1, r4)
        L5e:
            com.tencent.bugly.proguard.P r4 = r0.f22665k
            if (r4 == 0) goto L6f
            int r5 = r0.f22658d
            long r7 = r0.f22671q
            long r9 = r0.f22672r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L6f:
            com.tencent.bugly.proguard.P r4 = r0.f22666l
            if (r4 == 0) goto L80
            int r5 = r0.f22658d
            long r7 = r0.f22671q
            long r9 = r0.f22672r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.U.a(com.tencent.bugly.proguard.qa, boolean, int, java.lang.String, int):void");
    }

    public boolean a(qa qaVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        if (qaVar == null) {
            X.e("resp == null!", new Object[0]);
            return false;
        }
        byte b10 = qaVar.f22830c;
        if (b10 != 0) {
            X.b("resp result error %d", Byte.valueOf(b10));
            return false;
        }
        try {
            if (!ca.b(qaVar.f22836i) && !com.tencent.bugly.crashreport.common.info.a.m().q().equals(qaVar.f22836i)) {
                J.a().a(com.tencent.bugly.crashreport.common.strategy.c.f22361a, h3.e.f26411p, qaVar.f22836i.getBytes("UTF-8"), (I) null, true);
                aVar.f(qaVar.f22836i);
            }
        } catch (Throwable th2) {
            X.b(th2);
        }
        aVar.f22322u = qaVar.f22834g;
        int i10 = qaVar.f22831d;
        if (i10 == 510) {
            byte[] bArr = qaVar.f22832e;
            if (bArr == null) {
                X.b("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i10));
                return false;
            }
            sa saVar = (sa) M.a(bArr, sa.class);
            if (saVar == null) {
                X.b("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(qaVar.f22831d));
                return false;
            }
            cVar.a(saVar);
        }
        return true;
    }

    public void a(String str, long j10, String str2) {
        this.f22670p++;
        this.f22671q += j10;
    }

    public void a(long j10) {
        this.f22672r += j10;
    }

    private static String a(String str) {
        if (ca.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th2) {
            X.b(th2);
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
