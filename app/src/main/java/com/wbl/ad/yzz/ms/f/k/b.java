package com.wbl.ad.yzz.ms.f.k;

import android.app.Activity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.f.k.e;
import com.wbl.ad.yzz.ms.f.m.m;
import com.wbl.ad.yzz.ms.supporter.ad.InfoType;
import com.wbl.ad.yzz.ms.supporter.domain.SelfAdInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public abstract class b<T extends e> implements f {

    /* renamed from: h */
    public static Map<String, String> f33211h;

    /* renamed from: i */
    public static AtomicLong f33212i;

    /* renamed from: j */
    public static Map<InfoType, AtomicLong> f33213j;
    public static String[] k;

    /* renamed from: a */
    public Activity f33214a;

    /* renamed from: b */
    public String f33215b;

    /* renamed from: c */
    public T f33216c;

    /* renamed from: d */
    public g f33217d;

    /* renamed from: e */
    public String f33218e;

    /* renamed from: f */
    public Integer f33219f;

    /* renamed from: g */
    public Integer f33220g;

    public class a implements com.wbl.ad.yzz.ms.f.m.g<m> {

        /* renamed from: a */
        public final /* synthetic */ Map f33221a;

        public a(Map map) {
            this.f33221a = map;
        }

        /* renamed from: a */
        public void a2(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12282, this, mVar);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public void a(IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12281, this, iOException);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public /* bridge */ /* synthetic */ void a(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12284, this, mVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.ms.f.k.b$b */
    public class C0765b implements com.wbl.ad.yzz.ms.f.m.g<m> {

        /* renamed from: a */
        public final /* synthetic */ SelfAdInfo f33223a;

        /* renamed from: b */
        public final /* synthetic */ Map f33224b;

        public C0765b(SelfAdInfo selfAdInfo, Map map) {
            this.f33223a = selfAdInfo;
            this.f33224b = map;
        }

        /* renamed from: a */
        public void a2(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12283, this, mVar);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public void a(IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12278, this, iOException);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public /* bridge */ /* synthetic */ void a(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12277, this, mVar);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SelfAdInfo f33226a;

        /* renamed from: b */
        public final /* synthetic */ Map f33227b;

        public c(SelfAdInfo selfAdInfo, Map map) {
            this.f33226a = selfAdInfo;
            this.f33227b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12280, this, null);
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f33229a;

        public d(String str) {
            this.f33229a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12279, this, null);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f33211h = hashMap;
        hashMap.put("device_imei", "");
        f33212i = new AtomicLong();
        f33213j = new HashMap();
        for (InfoType infoType : InfoType.valuesCustom()) {
            f33213j.put(infoType, new AtomicLong());
        }
        k = new String[]{"app_id", "pid", "accept_ad_type", "sdk_version", "sdk_version_code", "device_os"};
    }

    public b(Activity activity, String str, T t) {
        this.f33214a = activity;
        this.f33215b = str;
        this.f33216c = t;
    }

    public static /* synthetic */ String a(b bVar, String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12169, null, bVar, str);
    }

    public abstract g a(Activity activity, SelfAdInfo selfAdInfo);

    public abstract g a(com.wbl.ad.yzz.ms.f.i.b bVar, SelfAdInfo selfAdInfo);

    @Override // com.wbl.ad.yzz.ms.f.k.f
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12166, this, null);
    }

    public final void a(m mVar, Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12165, this, mVar, map);
    }

    public final void a(SelfAdInfo selfAdInfo, Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12168, this, selfAdInfo, map);
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12167, this, str);
    }

    public final Map<String, String> b(Map<String, String> map) {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12162, this, map);
    }

    public void b(g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12161, this, gVar);
    }

    public final void b(SelfAdInfo selfAdInfo, Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12164, this, selfAdInfo, map);
    }

    public void c(Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12163, this, map);
    }

    public final Map<String, String> d(Map<String, String> map) {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12190, this, map);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12189, this, null);
    }

    public InfoType f() {
        return (InfoType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12192, this, null);
    }

    public T g() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12191, this, null);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.f
    public Activity getActivity() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12186, this, null);
    }
}
