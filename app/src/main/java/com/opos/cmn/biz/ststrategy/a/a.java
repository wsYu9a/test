package com.opos.cmn.biz.ststrategy.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.bj;
import com.cdo.oaps.ad.OapsKey;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.b.c;
import com.opos.cmn.an.j.a;
import com.opos.cmn.biz.a.b;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.c.d;
import com.opos.cmn.biz.ststrategy.c.f;
import com.opos.cmn.biz.ststrategy.entity.DataEntity;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.b.b.e;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a implements com.opos.cmn.biz.ststrategy.b.a {

    /* renamed from: a */
    private static final String f16813a = "a";

    /* renamed from: c */
    private static ConcurrentHashMap<String, AtomicBoolean> f16814c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private static com.opos.cmn.an.j.a f16815d = null;

    /* renamed from: e */
    private static final byte[] f16816e = new byte[1];

    /* renamed from: b */
    private Context f16817b;

    /* renamed from: com.opos.cmn.biz.ststrategy.a.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ UpdateParams f16818a;

        /* renamed from: b */
        final /* synthetic */ UpdateSTConfigListener f16819b;

        /* renamed from: c */
        final /* synthetic */ AtomicBoolean f16820c;

        /* renamed from: com.opos.cmn.biz.ststrategy.a.a$1$1 */
        class C03821 implements com.opos.cmn.biz.ststrategy.listener.a {
            C03821() {
            }

            @Override // com.opos.cmn.biz.ststrategy.listener.a
            public void a() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                a.this.a(updateSTConfigListener);
            }

            @Override // com.opos.cmn.biz.ststrategy.listener.a
            public void a(e eVar) {
                long currentTimeMillis = System.currentTimeMillis();
                d.a(a.this.f16817b, updateParams.pkgName, currentTimeMillis);
                com.opos.cmn.an.f.a.b(a.f16813a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + currentTimeMillis);
                JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
                if (a.this.a(a2) != 0 || !com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    a.this.a(updateSTConfigListener);
                    return;
                }
                d.e(a.this.f16817b);
                d.b(a.this.f16817b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, a2));
                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                a.this.b(updateSTConfigListener);
            }
        }

        AnonymousClass1(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener, AtomicBoolean atomicBoolean) {
            updateParams = updateParams;
            updateSTConfigListener = updateSTConfigListener;
            b2 = atomicBoolean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.a(updateParams.pkgName)) {
                    a.this.a(updateParams.pkgName, true, (com.opos.cmn.biz.ststrategy.listener.a) new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.a.a.1.1
                        C03821() {
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.this.a(updateSTConfigListener);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a(e eVar) {
                            long currentTimeMillis = System.currentTimeMillis();
                            d.a(a.this.f16817b, updateParams.pkgName, currentTimeMillis);
                            com.opos.cmn.an.f.a.b(a.f16813a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + currentTimeMillis);
                            JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
                            if (a.this.a(a2) != 0 || !com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                a.this.a(updateSTConfigListener);
                                return;
                            }
                            d.e(a.this.f16817b);
                            d.b(a.this.f16817b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, a2));
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            a.this.b(updateSTConfigListener);
                        }
                    });
                } else {
                    com.opos.cmn.an.f.a.b(a.f16813a, "don't need update st configs.");
                    a.this.c(updateSTConfigListener);
                }
            } finally {
                b2.set(false);
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.ststrategy.a.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16823a;

        /* renamed from: b */
        final /* synthetic */ UpdateSTConfigListener f16824b;

        AnonymousClass2(String str, UpdateSTConfigListener updateSTConfigListener) {
            str = str;
            updateSTConfigListener = updateSTConfigListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(str, updateSTConfigListener);
        }
    }

    /* renamed from: com.opos.cmn.biz.ststrategy.a.a$3 */
    class AnonymousClass3 implements com.opos.cmn.biz.ststrategy.listener.a {

        /* renamed from: a */
        final /* synthetic */ UpdateSTConfigListener f16826a;

        /* renamed from: b */
        final /* synthetic */ String f16827b;

        AnonymousClass3(UpdateSTConfigListener updateSTConfigListener, String str) {
            updateSTConfigListener = updateSTConfigListener;
            str = str;
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.a
        public void a() {
            a.this.a(updateSTConfigListener);
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.a
        public void a(e eVar) {
            JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
            int a3 = a.this.a(a2);
            if (a3 == 0) {
                if (com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                    a.this.b(updateSTConfigListener);
                    return;
                }
            } else if (a3 == -3) {
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = a.this;
                if (aVar.e(aVar.f16817b, str)) {
                    com.opos.cmn.an.f.a.b(a.f16813a, "set first Req dataType:" + str + ",currTime=" + currentTimeMillis);
                    d.c(a.this.f16817b, str, currentTimeMillis);
                }
                d.d(a.this.f16817b, str, currentTimeMillis);
            }
            a.this.a(updateSTConfigListener);
        }
    }

    public a(Context context) {
        this.f16817b = context;
    }

    public int a(JSONObject jSONObject) {
        int i2 = -1;
        if (jSONObject != null && jSONObject.has("code") && !jSONObject.isNull("code")) {
            try {
                int i3 = jSONObject.getInt("code");
                if (i3 == 0) {
                    i2 = 0;
                } else if (-3 == i3) {
                    i2 = -3;
                }
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.c(f16813a, "", e2);
            }
        }
        String str = f16813a;
        StringBuilder sb = new StringBuilder();
        sb.append("isResponseOKByCode result ");
        sb.append(i2 == 0);
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return i2;
    }

    private com.opos.cmn.func.b.b.d a(String str, String str2, boolean z) {
        try {
            return new d.a().b(str2).a(c()).a("POST").a(a(str, z)).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c(f16813a, "getSTConfigNetRequest fail", e2);
            return null;
        }
    }

    public void a(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a6, code lost:
    
        if (r20 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a8, code lost:
    
        r20.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0102, code lost:
    
        if (r20 != null) goto L106;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010a A[Catch: Exception -> 0x010e, TRY_ENTER, TryCatch #1 {Exception -> 0x010e, blocks: (B:6:0x0016, B:18:0x00a8, B:37:0x010a, B:38:0x010d), top: B:5:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r22, boolean r23, com.opos.cmn.biz.ststrategy.listener.a r24) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.a.a.a(java.lang.String, boolean, com.opos.cmn.biz.ststrategy.listener.a):void");
    }

    private boolean a(Context context, String str) {
        boolean z;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f16813a, "", e2);
            }
            if (!b(context, str) && !c(context, str)) {
                if (!d(context, str)) {
                    z = true;
                    com.opos.cmn.an.f.a.b(f16813a, "isLegalReq :" + z + ",dataType :" + str);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f16813a, "isLegalReq :" + z + ",dataType :" + str);
        return z;
    }

    public boolean a(String str) {
        boolean f2 = com.opos.cmn.biz.ststrategy.c.d.f(this.f16817b);
        long b2 = com.opos.cmn.biz.ststrategy.c.d.b(this.f16817b, str);
        long a2 = com.opos.cmn.biz.ststrategy.c.d.a(this.f16817b);
        boolean c2 = com.opos.cmn.biz.ststrategy.c.e.c(this.f16817b);
        String str2 = f16813a;
        com.opos.cmn.an.f.a.b(str2, "isStFileExists=" + c2 + ",ntLimit=" + a2 + ",lastTime=" + b2 + ",nowTime=" + System.currentTimeMillis());
        boolean z = (c2 && 0 != b2 && System.currentTimeMillis() < b2 + (a2 * 60000) && f.c(this.f16817b) && f2) ? false : true;
        com.opos.cmn.an.f.a.b(str2, "needUpdateStConfigs=" + z + ",pkgName =" + str);
        return z;
    }

    private byte[] a(String str, boolean z) {
        String str2;
        String str3 = f16813a;
        com.opos.cmn.an.f.a.b(str3, "getReqConfigContent");
        byte[] bArr = null;
        if (this.f16817b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bj.f5604i, c.a());
            jSONObject2.put("osVersion", com.opos.cmn.an.b.d.a());
            jSONObject2.put("ptoVer", StStrategyManager.getStVerCode());
            jSONObject2.put("region", com.opos.cmn.biz.a.d.a(this.f16817b));
            jSONObject2.put(bj.f5605j, b.a(this.f16817b));
            if (f.b(this.f16817b)) {
                jSONObject2.put("gaid", com.opos.cmn.g.a.b.g(this.f16817b));
            }
            jSONObject2.put("duId", com.opos.cmn.g.a.b.b(this.f16817b));
            jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.f16817b));
            jSONObject2.put("ouIdStatus", com.opos.cmn.g.a.b.h(this.f16817b));
            jSONObject2.put(OapsKey.KEY_FROM, "client");
            JSONObject jSONObject3 = new JSONObject();
            if (z) {
                if (com.opos.cmn.biz.ststrategy.c.a.f16831c.equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.c.a.f16830b;
                } else if (com.opos.cmn.biz.ststrategy.c.a.f16832d.equals(str)) {
                    str2 = "com.android.browser";
                } else if ("com.opos.st.demo".equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.c.a.f16830b;
                } else {
                    jSONObject3.put("pkgName", str);
                }
                jSONObject3.put("pkgName", str2);
            } else {
                jSONObject3.put(STManager.KEY_DATA_TYPE, str);
            }
            if (!f.c(this.f16817b) || !z) {
                jSONObject3.put("currTime", 0);
            } else if (z) {
                jSONObject3.put("currTime", com.opos.cmn.biz.ststrategy.c.d.c(this.f16817b, str));
            }
            jSONObject.put(MonitorConstants.CONNECT_TYPE_HEAD, jSONObject2);
            jSONObject.put("body", jSONObject3);
            bArr = jSONObject.toString().getBytes("UTF-8");
            com.opos.cmn.an.f.a.b(str3, "req st config content=" + jSONObject.toString());
            return bArr;
        } catch (UnsupportedEncodingException | JSONException e2) {
            com.opos.cmn.an.f.a.c(f16813a, "", e2);
            return bArr;
        }
    }

    private AtomicBoolean b(String str) {
        AtomicBoolean atomicBoolean;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                atomicBoolean = null;
            } else if (f16814c.containsKey(str)) {
                atomicBoolean = f16814c.get(str);
            } else {
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                f16814c.put(str, atomicBoolean2);
                atomicBoolean = atomicBoolean2;
            }
        }
        return atomicBoolean;
    }

    public void b(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onSuccess();
        }
    }

    public void b(String str, UpdateSTConfigListener updateSTConfigListener) {
        String str2 = f16813a;
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType begin:" + str);
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b(str2, "updateSTConfigsByDataType Params dataType is null");
            a(updateSTConfigListener);
            return;
        }
        AtomicBoolean b2 = b(str);
        if (b2 != null) {
            if (b2.compareAndSet(false, true)) {
                com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
                try {
                    if (a(this.f16817b, str)) {
                        a(str, false, (com.opos.cmn.biz.ststrategy.listener.a) new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.a.a.3

                            /* renamed from: a */
                            final /* synthetic */ UpdateSTConfigListener f16826a;

                            /* renamed from: b */
                            final /* synthetic */ String f16827b;

                            AnonymousClass3(UpdateSTConfigListener updateSTConfigListener2, String str3) {
                                updateSTConfigListener = updateSTConfigListener2;
                                str = str3;
                            }

                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a() {
                                a.this.a(updateSTConfigListener);
                            }

                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a(e eVar) {
                                JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
                                int a3 = a.this.a(a2);
                                if (a3 == 0) {
                                    if (com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                                        a.this.b(updateSTConfigListener);
                                        return;
                                    }
                                } else if (a3 == -3) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    a aVar = a.this;
                                    if (aVar.e(aVar.f16817b, str)) {
                                        com.opos.cmn.an.f.a.b(a.f16813a, "set first Req dataType:" + str + ",currTime=" + currentTimeMillis);
                                        com.opos.cmn.biz.ststrategy.c.d.c(a.this.f16817b, str, currentTimeMillis);
                                    }
                                    com.opos.cmn.biz.ststrategy.c.d.d(a.this.f16817b, str, currentTimeMillis);
                                }
                                a.this.a(updateSTConfigListener);
                            }
                        });
                    } else {
                        a(updateSTConfigListener2);
                    }
                    com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType end:" + str3);
                } finally {
                    b2.set(false);
                }
            }
        }
        com.opos.cmn.an.f.a.b(str2, "is initing. do nothing!!!");
        c(updateSTConfigListener2);
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType end:" + str3);
    }

    private boolean b(Context context, String str) {
        STConfigEntity a2;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        boolean z = (context == null || TextUtils.isEmpty(str) || (a2 = com.opos.cmn.biz.ststrategy.c.e.a()) == null || (dataEntity = a2.dataEntity) == null || (map = dataEntity.metaEntityMap) == null || !map.containsKey(str)) ? false : true;
        com.opos.cmn.an.f.a.b(f16813a, " dataType:" + str + " is included in strategy result:" + z);
        return z;
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f5520d);
        hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        hashMap.put("Connection", HTTP.CONN_KEEP_ALIVE);
        hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f16817b));
        return hashMap;
    }

    public void c(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onNotNeedUpdate();
        }
    }

    private boolean c(Context context, String str) {
        boolean z;
        if (context != null && !TextUtils.isEmpty(str)) {
            long d2 = com.opos.cmn.biz.ststrategy.c.d.d(context, str);
            if (0 != d2 && System.currentTimeMillis() - d2 > com.opos.cmn.biz.ststrategy.c.d.d(context) * 60000) {
                z = true;
                com.opos.cmn.an.f.a.b(f16813a, "isInBlackList :" + z + ",dataType :" + str);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f16813a, "isInBlackList :" + z + ",dataType :" + str);
        return z;
    }

    private void d() {
        if (f16815d == null) {
            synchronized (f16816e) {
                if (f16815d == null) {
                    f16815d = new a.C0372a().a(1).b(1).a("cmn_strategy_single").a();
                }
            }
        }
    }

    private boolean d(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            long e2 = com.opos.cmn.biz.ststrategy.c.d.e(context, str);
            if (0 != e2 && System.currentTimeMillis() - e2 < com.opos.cmn.biz.ststrategy.c.d.c(context) * 60000) {
                z = true;
            }
            com.opos.cmn.an.f.a.b(f16813a, "isWithinDTLimitTime firstInDTLimit:" + e2 + ", result :" + z);
        }
        return z;
    }

    public boolean e(Context context, String str) {
        boolean z = (context == null || TextUtils.isEmpty(str) || com.opos.cmn.biz.ststrategy.c.d.d(context, str) != 0) ? false : true;
        com.opos.cmn.an.f.a.b(f16813a, "isFirstSupplyReq result:" + z);
        return z;
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public STConfigEntity a() {
        return com.opos.cmn.biz.ststrategy.c.e.a(this.f16817b);
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public void a(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener) {
        String str;
        String str2 = f16813a;
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by PkgName");
        if (updateParams == null) {
            str = "update Params is null";
        } else {
            if (!TextUtils.isEmpty(updateParams.pkgName)) {
                AtomicBoolean b2 = b(updateParams.pkgName);
                if (b2 == null || !b2.compareAndSet(false, true)) {
                    com.opos.cmn.an.f.a.b(str2, "is initing. do nothing!!!");
                    c(updateSTConfigListener);
                    return;
                } else {
                    com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
                    com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.a.a.1

                        /* renamed from: a */
                        final /* synthetic */ UpdateParams f16818a;

                        /* renamed from: b */
                        final /* synthetic */ UpdateSTConfigListener f16819b;

                        /* renamed from: c */
                        final /* synthetic */ AtomicBoolean f16820c;

                        /* renamed from: com.opos.cmn.biz.ststrategy.a.a$1$1 */
                        class C03821 implements com.opos.cmn.biz.ststrategy.listener.a {
                            C03821() {
                            }

                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                a.this.a(updateSTConfigListener);
                            }

                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a(e eVar) {
                                long currentTimeMillis = System.currentTimeMillis();
                                com.opos.cmn.biz.ststrategy.c.d.a(a.this.f16817b, updateParams.pkgName, currentTimeMillis);
                                com.opos.cmn.an.f.a.b(a.f16813a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + currentTimeMillis);
                                JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
                                if (a.this.a(a2) != 0 || !com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    a.this.a(updateSTConfigListener);
                                    return;
                                }
                                com.opos.cmn.biz.ststrategy.c.d.e(a.this.f16817b);
                                com.opos.cmn.biz.ststrategy.c.d.b(a.this.f16817b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, a2));
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                a.this.b(updateSTConfigListener);
                            }
                        }

                        AnonymousClass1(UpdateParams updateParams2, UpdateSTConfigListener updateSTConfigListener2, AtomicBoolean b22) {
                            updateParams = updateParams2;
                            updateSTConfigListener = updateSTConfigListener2;
                            b2 = b22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (a.this.a(updateParams.pkgName)) {
                                    a.this.a(updateParams.pkgName, true, (com.opos.cmn.biz.ststrategy.listener.a) new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.a.a.1.1
                                        C03821() {
                                        }

                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            a.this.a(updateSTConfigListener);
                                        }

                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a(e eVar) {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            com.opos.cmn.biz.ststrategy.c.d.a(a.this.f16817b, updateParams.pkgName, currentTimeMillis);
                                            com.opos.cmn.an.f.a.b(a.f16813a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + currentTimeMillis);
                                            JSONObject a2 = com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, eVar);
                                            if (a.this.a(a2) != 0 || !com.opos.cmn.biz.ststrategy.c.e.b(a.this.f16817b, a2)) {
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                a.this.a(updateSTConfigListener);
                                                return;
                                            }
                                            com.opos.cmn.biz.ststrategy.c.d.e(a.this.f16817b);
                                            com.opos.cmn.biz.ststrategy.c.d.b(a.this.f16817b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.c.e.a(a.this.f16817b, a2));
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            a.this.b(updateSTConfigListener);
                                        }
                                    });
                                } else {
                                    com.opos.cmn.an.f.a.b(a.f16813a, "don't need update st configs.");
                                    a.this.c(updateSTConfigListener);
                                }
                            } finally {
                                b2.set(false);
                            }
                        }
                    });
                    return;
                }
            }
            str = "update Params pkgName is null";
        }
        com.opos.cmn.an.f.a.b(str2, str);
        a(updateSTConfigListener2);
    }

    @Override // com.opos.cmn.biz.ststrategy.b.a
    public void a(String str, UpdateSTConfigListener updateSTConfigListener) {
        d();
        com.opos.cmn.an.j.a aVar = f16815d;
        if (aVar != null) {
            try {
                aVar.execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.a.a.2

                    /* renamed from: a */
                    final /* synthetic */ String f16823a;

                    /* renamed from: b */
                    final /* synthetic */ UpdateSTConfigListener f16824b;

                    AnonymousClass2(String str2, UpdateSTConfigListener updateSTConfigListener2) {
                        str = str2;
                        updateSTConfigListener = updateSTConfigListener2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(str, updateSTConfigListener);
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeSingleTask", e2);
            }
        }
    }
}
