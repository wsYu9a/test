package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.opos.cmn.biz.web.a.b.a;
import com.opos.cmn.biz.web.a.b.b;
import com.opos.cmn.func.b.b.d;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class u {

    /* renamed from: com.opos.mobad.model.d.u$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21669a;

        /* renamed from: b */
        final /* synthetic */ Context f21670b;

        AnonymousClass1(String str, Context context) {
            str = str;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                URI create = URI.create(str);
                String str = create.getScheme() + "://" + create.getHost();
                if (create.getPort() > 0) {
                    str = str + ":" + create.getPort();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(context, new d.a().a(hashMap).a("GET").b(str).a());
                com.opos.cmn.an.f.a.b("WebPrepare", "get code:" + a2.f17168a);
                if (200 == a2.f17168a) {
                    String a3 = com.opos.mobad.model.e.c.a(a2.f17170c);
                    com.opos.cmn.an.f.a.b("WebPrepare", "get data:" + a3);
                    JSONArray jSONArray = new JSONArray(a3);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            arrayList.add(new a.C0383a().a(u.b(jSONObject.getString(OapsWrapper.KEY_PATH), str)).b(jSONObject.getString("md5")).a());
                        }
                        u.b(arrayList);
                    }
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("WebPrepare", "get resouce fail:", th);
            }
        }
    }

    private static final void a(Context context, String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.u.1

            /* renamed from: a */
            final /* synthetic */ String f21669a;

            /* renamed from: b */
            final /* synthetic */ Context f21670b;

            AnonymousClass1(String str2, Context context2) {
                str = str2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    URI create = URI.create(str);
                    String str2 = create.getScheme() + "://" + create.getHost();
                    if (create.getPort() > 0) {
                        str2 = str2 + ":" + create.getPort();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                    com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(context, new d.a().a(hashMap).a("GET").b(str).a());
                    com.opos.cmn.an.f.a.b("WebPrepare", "get code:" + a2.f17168a);
                    if (200 == a2.f17168a) {
                        String a3 = com.opos.mobad.model.e.c.a(a2.f17170c);
                        com.opos.cmn.an.f.a.b("WebPrepare", "get data:" + a3);
                        JSONArray jSONArray = new JSONArray(a3);
                        if (jSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList(jSONArray.length());
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                arrayList.add(new a.C0383a().a(u.b(jSONObject.getString(OapsWrapper.KEY_PATH), str2)).b(jSONObject.getString("md5")).a());
                            }
                            u.b(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("WebPrepare", "get resouce fail:", th);
                }
            }
        });
    }

    public static final void a(Context context, String str, List<String> list) {
        ArrayList arrayList;
        com.opos.cmn.biz.web.a.b.c.a().a(context, new b.a().a());
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new a.C0383a().a(it.next()).a());
            }
        }
        b(arrayList);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, str);
    }

    public static final String b(String str, String str2) {
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith(b.b.a.b.b.f4198a)) {
            return str;
        }
        return str2 + "/" + str;
    }

    public static final void b(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b("WebPrepare", "cache size:" + list.size());
        com.opos.cmn.biz.web.a.b.c.a().a(list);
    }
}
