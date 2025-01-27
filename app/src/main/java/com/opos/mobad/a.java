package com.opos.mobad;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.cmn.a.d {

    /* renamed from: com.opos.mobad.a$1 */
    class AnonymousClass1 extends Callback {

        /* renamed from: a */
        final /* synthetic */ d.a f19330a;

        AnonymousClass1(d.a aVar) {
            aVar = aVar;
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            if (response.getCode() == 1) {
                com.opos.cmn.an.f.a.a("", "instant jump success");
                d.a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            com.opos.cmn.an.f.a.a("", "instant jump fail" + response.getCode());
            d.a aVar2 = aVar;
            if (aVar2 != null) {
                aVar2.a(response.getCode(), response.getMsg());
            }
        }
    }

    @Override // com.opos.mobad.cmn.a.d
    public void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription) {
        AdActivity.a(context, str, str2, adItemData, str3, eventDescription);
    }

    @Override // com.opos.mobad.cmn.a.d
    public void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription, String str4) {
        AdActivity.a(context, str, str2, adItemData, str3, eventDescription, str4);
    }

    @Override // com.opos.mobad.cmn.a.d
    public void a(Context context, String str, String str2, String str3, d.a aVar, String str4) {
        boolean b2 = com.opos.mobad.cmn.a.b.c.b(context);
        com.opos.cmn.an.f.a.a("", "instant origin =" + str + ",secret =" + str2 + ",url =" + str3 + ",traceId =" + str4);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && b2) {
            com.opos.mobad.cmn.a.b.f.a(context, str, str2, str3, new Callback() { // from class: com.opos.mobad.a.1

                /* renamed from: a */
                final /* synthetic */ d.a f19330a;

                AnonymousClass1(d.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.oplus.instant.router.callback.Callback
                public void onResponse(Callback.Response response) {
                    if (response.getCode() == 1) {
                        com.opos.cmn.an.f.a.a("", "instant jump success");
                        d.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.a("", "instant jump fail" + response.getCode());
                    d.a aVar22 = aVar;
                    if (aVar22 != null) {
                        aVar22.a(response.getCode(), response.getMsg());
                    }
                }
            }, str4);
            return;
        }
        if (aVar2 != null) {
            int i2 = 0;
            String str5 = !b2 ? "instant not install" : "";
            try {
                i2 = Integer.valueOf("0").intValue();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
            }
            aVar2.a(i2, str5);
        }
        com.opos.cmn.an.f.a.a("", "executeInstant but fail");
    }

    @Override // com.opos.mobad.cmn.a.d
    public void a(Context context, String str, String str2, String str3, String str4) {
        com.opos.mobad.cmn.a.b.f.a(context, str, str2, str3, str4);
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean a(Context context, String str) {
        return com.opos.mobad.cmn.a.b.f.a(context, str);
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean a(Context context, String str, String str2, String str3) {
        return com.opos.mobad.cmn.a.b.h.a(context, str, str2, str3);
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleDLApk pkgName=");
        sb.append(str);
        sb.append(",posId=");
        sb.append(str2);
        sb.append(",channelPkg=");
        sb.append(str3 != null ? str3 : "null");
        sb.append(",trackContent=");
        sb.append(str5 != null ? str5 : "null");
        sb.append(",trackReference=");
        sb.append(str6 != null ? str6 : "null");
        com.opos.cmn.an.f.a.a("", sb.toString());
        boolean a2 = com.opos.cmn.g.c.a.a(context, str, str2, str3, str4, str5, str6);
        com.opos.cmn.an.f.a.a("", "executeDownloadApp result = " + a2);
        return a2;
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean b(Context context, String str) {
        return com.opos.mobad.cmn.a.b.f.b(context, str);
    }

    @Override // com.opos.mobad.cmn.a.d
    public void c(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "open browser =" + str);
        com.opos.cmn.biz.b.a.a(context, str);
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean d(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.mobad.cmn.a.b.f.f(context, str);
    }

    @Override // com.opos.mobad.cmn.a.d
    public boolean e(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.cmn.g.b.b.a.a(context, str);
    }
}
