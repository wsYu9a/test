package cn.vlion.ad.inland.core;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    public static HashMap f3702a;

    /* renamed from: b */
    public static HashMap f3703b;

    /* renamed from: c */
    public static HashMap f3704c;

    /* renamed from: d */
    public static HashMap f3705d;

    /* renamed from: e */
    public static HashMap f3706e;

    /* renamed from: f */
    public static HashMap f3707f;

    public static synchronized a a(int i10, String str) {
        a a10;
        synchronized (n.class) {
            a10 = a(i10, str, null, false, 0);
        }
        return a10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static synchronized a a(int i10, String str, a aVar, boolean z10, int i11) {
        HashMap hashMap;
        ?? r42;
        synchronized (n.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                long cacheAdTime = VlionServiceConfigParse.getInstance().getCacheAdTime();
                if (cacheAdTime <= 0) {
                    cacheAdTime = 30;
                }
                switch (i10) {
                    case 1:
                        if (f3702a == null) {
                            f3702a = new HashMap();
                        }
                        hashMap = f3702a;
                        r42 = (List) hashMap.get(str);
                        break;
                    case 2:
                        if (f3704c == null) {
                            f3704c = new HashMap();
                        }
                        hashMap = f3704c;
                        r42 = (List) hashMap.get(str);
                        break;
                    case 3:
                        if (f3705d == null) {
                            f3705d = new HashMap();
                        }
                        hashMap = f3705d;
                        r42 = (List) hashMap.get(str);
                        break;
                    case 4:
                        if (f3703b == null) {
                            f3703b = new HashMap();
                        }
                        hashMap = f3703b;
                        r42 = (List) hashMap.get(str);
                        break;
                    case 5:
                        if (f3706e == null) {
                            f3706e = new HashMap();
                        }
                        hashMap = f3706e;
                        r42 = (List) hashMap.get(str);
                        break;
                    case 6:
                        if (f3707f == null) {
                            f3707f = new HashMap();
                        }
                        hashMap = f3707f;
                        r42 = (List) hashMap.get(str);
                        break;
                    default:
                        hashMap = null;
                        r42 = 0;
                        break;
                }
                if (!z10) {
                    return a((List<a>) r42, str, hashMap, cacheAdTime);
                }
                if (r42 == 0) {
                    r42 = new ArrayList();
                    if (aVar != null) {
                        LogVlion.e("VlionCacheUtils insertList newList.add adapterCacheList is null********  baseAdAdapterCache=" + aVar.c());
                        r42.add(aVar);
                    }
                } else if (aVar != null) {
                    r42 = a((List<a>) r42, aVar, cacheAdTime, i11);
                }
                if (hashMap != null) {
                    hashMap.put(str, r42);
                }
                return null;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return null;
            }
        }
    }

    public static synchronized a a(List<a> list, String str, Map<String, List<a>> map, long j10) {
        a aVar;
        int i10;
        synchronized (n.class) {
            aVar = null;
            try {
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    int i11 = 0;
                    while (i11 < list.size()) {
                        a aVar2 = list.get(i11);
                        if (aVar2 != null) {
                            long currentTimeMillis = System.currentTimeMillis() - aVar2.d();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("VlionCacheUtils getList interval=");
                            i10 = i11;
                            sb2.append(currentTimeMillis / 60000);
                            sb2.append("  expirationTime=");
                            sb2.append(j10);
                            LogVlion.e(sb2.toString());
                            if (currentTimeMillis / 60000 < j10) {
                                if (aVar == null) {
                                    aVar = aVar2;
                                } else {
                                    arrayList.add(aVar2);
                                }
                            }
                        } else {
                            i10 = i11;
                        }
                        i11 = i10 + 1;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("VlionCacheUtils getList newList.size()=");
                sb3.append(arrayList.size());
                sb3.append("  (null!=baseAdAdapterCacheData)=");
                sb3.append(aVar != null);
                LogVlion.e(sb3.toString());
                if (map != null) {
                    map.put(str, arrayList);
                }
            } finally {
                return aVar;
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0211 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:6:0x0010, B:9:0x001f, B:12:0x002c, B:18:0x003c, B:22:0x005a, B:25:0x006d, B:27:0x007d, B:29:0x0085, B:32:0x00b7, B:35:0x00ca, B:37:0x00da, B:38:0x00ef, B:39:0x018f, B:44:0x00f7, B:46:0x0103, B:48:0x0124, B:49:0x013e, B:52:0x015d, B:55:0x0169, B:58:0x0186, B:41:0x0192, B:64:0x0198, B:66:0x019e, B:67:0x01b6, B:69:0x01ef, B:71:0x0211, B:73:0x0217, B:75:0x0220, B:76:0x022b, B:78:0x0231, B:87:0x01bc, B:88:0x01d5), top: B:5:0x0010, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0231 A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #0 {all -> 0x00f4, blocks: (B:6:0x0010, B:9:0x001f, B:12:0x002c, B:18:0x003c, B:22:0x005a, B:25:0x006d, B:27:0x007d, B:29:0x0085, B:32:0x00b7, B:35:0x00ca, B:37:0x00da, B:38:0x00ef, B:39:0x018f, B:44:0x00f7, B:46:0x0103, B:48:0x0124, B:49:0x013e, B:52:0x015d, B:55:0x0169, B:58:0x0186, B:41:0x0192, B:64:0x0198, B:66:0x019e, B:67:0x01b6, B:69:0x01ef, B:71:0x0211, B:73:0x0217, B:75:0x0220, B:76:0x022b, B:78:0x0231, B:87:0x01bc, B:88:0x01d5), top: B:5:0x0010, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.util.List<cn.vlion.ad.inland.core.a> a(java.util.List<cn.vlion.ad.inland.core.a> r19, cn.vlion.ad.inland.core.a r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.core.n.a(java.util.List, cn.vlion.ad.inland.core.a, long, int):java.util.List");
    }

    public static synchronized void a(b bVar, a aVar) {
        synchronized (n.class) {
            if (bVar == null) {
                return;
            }
            try {
                a(bVar.b(), bVar.l(), aVar, true, bVar.d());
            } finally {
            }
        }
    }
}
