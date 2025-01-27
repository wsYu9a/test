package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.a.a;
import com.opos.cmn.biz.requeststatistic.a.c;
import com.opos.cmn.biz.requeststatistic.a.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RequestStatisticManager {

    /* renamed from: a */
    private static final String f16754a = "RequestStatisticManager";

    /* renamed from: b */
    private static RequestStatisticManager f16755b;

    /* renamed from: c */
    private Context f16756c;

    /* renamed from: d */
    private InitParams f16757d;

    /* renamed from: com.opos.cmn.biz.requeststatistic.RequestStatisticManager$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ StatisticEvent f16758a;

        /* renamed from: com.opos.cmn.biz.requeststatistic.RequestStatisticManager$1$1 */
        class C03791 implements a.InterfaceC0380a {

            /* renamed from: a */
            final /* synthetic */ c f16760a;

            C03791(c cVar) {
                cVar = cVar;
            }

            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
            public void onFail() {
                com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "report request fail");
            }

            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
            public void onSuccess() {
                d a2 = d.a();
                c cVar = cVar;
                String str = d.f16787a;
                com.opos.cmn.an.f.a.b(str, "delete cache with id:" + cVar.f16784a);
                if (!a2.f16791d.remove(cVar)) {
                    com.opos.cmn.an.f.a.b(str, "remove from db:" + cVar.f16784a);
                    com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.4

                        /* renamed from: a */
                        final /* synthetic */ c f16799a;

                        public AnonymousClass4(c cVar2) {
                            r2 = cVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.f16794h.writeLock().lock();
                            try {
                                try {
                                    b bVar = d.this.f16790c;
                                    c cVar2 = r2;
                                    long j2 = cVar2.f16784a;
                                    if (j2 < 0) {
                                        com.opos.cmn.an.f.a.c(b.f16783a, "delete data by id had not init");
                                        bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar2.f16785b});
                                    } else {
                                        bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j2)});
                                    }
                                } catch (Exception e2) {
                                    com.opos.cmn.an.f.a.b(d.f16787a, "delete fail", e2);
                                }
                            } finally {
                                d.this.f16794h.writeLock().unlock();
                            }
                        }
                    });
                }
                d.a().b();
            }
        }

        AnonymousClass1(StatisticEvent statisticEvent) {
            statisticEvent = statisticEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject a2 = RequestStatisticManager.a(RequestStatisticManager.this, statisticEvent);
                String jSONObject = a2.toString();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a2);
                String jSONArray2 = jSONArray.toString();
                com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "send data:".concat(String.valueOf(jSONArray2)));
                c cVar = new c(jSONObject, System.currentTimeMillis());
                d a3 = d.a();
                com.opos.cmn.an.f.a.b(d.f16787a, "add cache with data:" + cVar.f16785b);
                a3.f16791d.offer(cVar);
                com.opos.cmn.biz.requeststatistic.a.a aVar = a3.f16792e;
                if (aVar != null) {
                    aVar.a();
                }
                a.a(RequestStatisticManager.this.f16756c, jSONArray2, new a.InterfaceC0380a() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1.1

                    /* renamed from: a */
                    final /* synthetic */ c f16760a;

                    C03791(c cVar2) {
                        cVar = cVar2;
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                    public void onFail() {
                        com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "report request fail");
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                    public void onSuccess() {
                        d a22 = d.a();
                        c cVar2 = cVar;
                        String str = d.f16787a;
                        com.opos.cmn.an.f.a.b(str, "delete cache with id:" + cVar2.f16784a);
                        if (!a22.f16791d.remove(cVar2)) {
                            com.opos.cmn.an.f.a.b(str, "remove from db:" + cVar2.f16784a);
                            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.4

                                /* renamed from: a */
                                final /* synthetic */ c f16799a;

                                public AnonymousClass4(c cVar22) {
                                    r2 = cVar22;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    d.this.f16794h.writeLock().lock();
                                    try {
                                        try {
                                            b bVar = d.this.f16790c;
                                            c cVar22 = r2;
                                            long j2 = cVar22.f16784a;
                                            if (j2 < 0) {
                                                com.opos.cmn.an.f.a.c(b.f16783a, "delete data by id had not init");
                                                bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar22.f16785b});
                                            } else {
                                                bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j2)});
                                            }
                                        } catch (Exception e2) {
                                            com.opos.cmn.an.f.a.b(d.f16787a, "delete fail", e2);
                                        }
                                    } finally {
                                        d.this.f16794h.writeLock().unlock();
                                    }
                                }
                            });
                        }
                        d.a().b();
                    }
                });
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.d(RequestStatisticManager.f16754a, "request parse json fail", e2);
            }
        }
    }

    private RequestStatisticManager() {
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        String str = "";
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && !TextUtils.isEmpty(activeNetworkInfo.getTypeName())) {
                    if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                        str = activeNetworkInfo.getTypeName();
                    } else if (!TextUtils.isEmpty(activeNetworkInfo.getSubtypeName())) {
                        str = activeNetworkInfo.getSubtypeName();
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b(f16754a, "net access fail", e2);
            }
        }
        return str;
    }

    static /* synthetic */ JSONObject a(RequestStatisticManager requestStatisticManager, StatisticEvent statisticEvent) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chn", statisticEvent.channel);
        jSONObject2.put("imei", "");
        jSONObject2.put("pkg", requestStatisticManager.f16756c.getPackageName());
        jSONObject2.put("svc", TextUtils.isEmpty(statisticEvent.sdkVersion) ? 202 : statisticEvent.sdkVersion);
        jSONObject2.put("evtId", statisticEvent.eventId);
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        jSONObject2.put(bj.f5604i, str);
        jSONObject2.put(TKDownloadReason.KSAD_TK_NET, a(requestStatisticManager.f16756c));
        boolean a2 = com.opos.cmn.biz.c.b.a.a();
        com.opos.cmn.an.f.a.b("Utils", "isOverseas=".concat(String.valueOf(a2)));
        if (a2) {
            jSONObject2.put("gaId", com.opos.cmn.g.a.b.g(requestStatisticManager.f16756c));
        }
        jSONObject2.put("bd", com.opos.cmn.biz.a.b.a(requestStatisticManager.f16756c));
        jSONObject2.put("rn", com.opos.cmn.biz.a.d.a(requestStatisticManager.f16756c));
        jSONObject2.put("duId", "");
        jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(requestStatisticManager.f16756c));
        jSONObject2.put("guId", "");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ct", statisticEvent.currentTime);
        jSONObject3.put("url", statisticEvent.url);
        jSONObject3.put("ret", statisticEvent.ret);
        jSONObject3.put("rt", statisticEvent.resolveTime);
        jSONObject3.put("mt", statisticEvent.maxResolveTime);
        jSONObject3.put("ext", statisticEvent.ext);
        jSONObject.put("h", jSONObject2);
        jSONObject.put("b", jSONObject3);
        return jSONObject;
    }

    private boolean b() {
        return (this.f16756c == null || this.f16757d == null) ? false : true;
    }

    public static RequestStatisticManager getInstance() {
        RequestStatisticManager requestStatisticManager = f16755b;
        if (requestStatisticManager == null) {
            synchronized (RequestStatisticManager.class) {
                if (f16755b == null) {
                    f16755b = new RequestStatisticManager();
                }
                requestStatisticManager = f16755b;
            }
        }
        return requestStatisticManager;
    }

    public void init(Context context, InitParams initParams) {
        this.f16756c = context.getApplicationContext();
        d a2 = d.a();
        if (a2.f16789b == null) {
            a2.f16789b = context;
            a2.f16790c = new com.opos.cmn.biz.requeststatistic.a.b(context);
            a2.f16792e = new com.opos.cmn.biz.requeststatistic.a.a(new a.b() { // from class: com.opos.cmn.biz.requeststatistic.a.d.1
                public AnonymousClass1() {
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.b
                public final void a(a.InterfaceC0381a interfaceC0381a) {
                    d.a(d.this, interfaceC0381a);
                }
            });
            a2.f16793f = new com.opos.cmn.biz.requeststatistic.a.a(new a.b() { // from class: com.opos.cmn.biz.requeststatistic.a.d.2
                public AnonymousClass2() {
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.b
                public final void a(a.InterfaceC0381a interfaceC0381a) {
                    d.b(d.this, interfaceC0381a);
                }
            }, 1800000);
        }
        this.f16757d = initParams;
    }

    public void report(StatisticEvent statisticEvent) {
        String str = f16754a;
        com.opos.cmn.an.f.a.b(str, "report:".concat(String.valueOf(statisticEvent)));
        if (!b()) {
            throw new IllegalStateException("had not init yet ");
        }
        if (statisticEvent == null) {
            throw new IllegalArgumentException("event can not be null");
        }
        if (com.opos.cmn.an.f.a.a(this.f16756c)) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1

                /* renamed from: a */
                final /* synthetic */ StatisticEvent f16758a;

                /* renamed from: com.opos.cmn.biz.requeststatistic.RequestStatisticManager$1$1 */
                class C03791 implements a.InterfaceC0380a {

                    /* renamed from: a */
                    final /* synthetic */ c f16760a;

                    C03791(c cVar2) {
                        cVar = cVar2;
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                    public void onFail() {
                        com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "report request fail");
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                    public void onSuccess() {
                        d a22 = d.a();
                        c cVar22 = cVar;
                        String str = d.f16787a;
                        com.opos.cmn.an.f.a.b(str, "delete cache with id:" + cVar22.f16784a);
                        if (!a22.f16791d.remove(cVar22)) {
                            com.opos.cmn.an.f.a.b(str, "remove from db:" + cVar22.f16784a);
                            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.4

                                /* renamed from: a */
                                final /* synthetic */ c f16799a;

                                public AnonymousClass4(c cVar222) {
                                    r2 = cVar222;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    d.this.f16794h.writeLock().lock();
                                    try {
                                        try {
                                            b bVar = d.this.f16790c;
                                            c cVar222 = r2;
                                            long j2 = cVar222.f16784a;
                                            if (j2 < 0) {
                                                com.opos.cmn.an.f.a.c(b.f16783a, "delete data by id had not init");
                                                bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar222.f16785b});
                                            } else {
                                                bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j2)});
                                            }
                                        } catch (Exception e2) {
                                            com.opos.cmn.an.f.a.b(d.f16787a, "delete fail", e2);
                                        }
                                    } finally {
                                        d.this.f16794h.writeLock().unlock();
                                    }
                                }
                            });
                        }
                        d.a().b();
                    }
                }

                AnonymousClass1(StatisticEvent statisticEvent2) {
                    statisticEvent = statisticEvent2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject a2 = RequestStatisticManager.a(RequestStatisticManager.this, statisticEvent);
                        String jSONObject = a2.toString();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(a2);
                        String jSONArray2 = jSONArray.toString();
                        com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "send data:".concat(String.valueOf(jSONArray2)));
                        c cVar2 = new c(jSONObject, System.currentTimeMillis());
                        d a3 = d.a();
                        com.opos.cmn.an.f.a.b(d.f16787a, "add cache with data:" + cVar2.f16785b);
                        a3.f16791d.offer(cVar2);
                        com.opos.cmn.biz.requeststatistic.a.a aVar = a3.f16792e;
                        if (aVar != null) {
                            aVar.a();
                        }
                        a.a(RequestStatisticManager.this.f16756c, jSONArray2, new a.InterfaceC0380a() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1.1

                            /* renamed from: a */
                            final /* synthetic */ c f16760a;

                            C03791(c cVar22) {
                                cVar = cVar22;
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                            public void onFail() {
                                com.opos.cmn.an.f.a.b(RequestStatisticManager.f16754a, "report request fail");
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
                            public void onSuccess() {
                                d a22 = d.a();
                                c cVar222 = cVar;
                                String str2 = d.f16787a;
                                com.opos.cmn.an.f.a.b(str2, "delete cache with id:" + cVar222.f16784a);
                                if (!a22.f16791d.remove(cVar222)) {
                                    com.opos.cmn.an.f.a.b(str2, "remove from db:" + cVar222.f16784a);
                                    com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.4

                                        /* renamed from: a */
                                        final /* synthetic */ c f16799a;

                                        public AnonymousClass4(c cVar2222) {
                                            r2 = cVar2222;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            d.this.f16794h.writeLock().lock();
                                            try {
                                                try {
                                                    b bVar = d.this.f16790c;
                                                    c cVar2222 = r2;
                                                    long j2 = cVar2222.f16784a;
                                                    if (j2 < 0) {
                                                        com.opos.cmn.an.f.a.c(b.f16783a, "delete data by id had not init");
                                                        bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar2222.f16785b});
                                                    } else {
                                                        bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j2)});
                                                    }
                                                } catch (Exception e2) {
                                                    com.opos.cmn.an.f.a.b(d.f16787a, "delete fail", e2);
                                                }
                                            } finally {
                                                d.this.f16794h.writeLock().unlock();
                                            }
                                        }
                                    });
                                }
                                d.a().b();
                            }
                        });
                    } catch (JSONException e2) {
                        com.opos.cmn.an.f.a.d(RequestStatisticManager.f16754a, "request parse json fail", e2);
                    }
                }
            });
        } else {
            com.opos.cmn.an.f.a.b(str, "log buried point switch is closed, cannot upload log buried point");
        }
    }

    public void reportCacheIfNeed() {
        String str;
        String str2;
        if (!b()) {
            str = f16754a;
            str2 = "reportCacheIfNeed, but had not init yet";
        } else if (com.opos.cmn.an.f.a.a(this.f16756c)) {
            d.a().b();
            return;
        } else {
            str = f16754a;
            str2 = "log buried point switch is closed, cannot upload log buried point";
        }
        com.opos.cmn.an.f.a.b(str, str2);
    }
}
