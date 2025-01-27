package com.vivo.mobilead.manager;

import android.content.Context;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.vivo.mobilead.util.e0;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: d */
    private static volatile g f29547d;

    /* renamed from: a */
    private Context f29548a;

    /* renamed from: b */
    private IWXAPI f29549b;

    /* renamed from: c */
    private Boolean f29550c;

    public g(Context context) {
        if (context != null) {
            this.f29548a = context.getApplicationContext();
        }
    }

    private void b(String str) {
        try {
            if (this.f29549b == null && b()) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f29548a, str, true);
                this.f29549b = createWXAPI;
                createWXAPI.registerApp(str);
            }
        } catch (Exception e2) {
            x0.b("WeChatUtil", e2.getMessage());
        }
    }

    public boolean a(String str) {
        if (this.f29549b == null) {
            b(str);
        }
        try {
            if (this.f29550c == null) {
                IWXAPI iwxapi = this.f29549b;
                if (iwxapi != null && iwxapi.getWXAppSupportAPI() >= 620756993) {
                    this.f29550c = Boolean.TRUE;
                }
                this.f29550c = Boolean.FALSE;
            }
        } catch (Exception e2) {
            x0.b("WeChatUtil", e2.getMessage());
            this.f29550c = Boolean.FALSE;
        }
        return this.f29550c.booleanValue();
    }

    public boolean b() {
        Boolean valueOf = Boolean.valueOf(e0.k());
        this.f29550c = valueOf;
        return valueOf.booleanValue();
    }

    public static g a(Context context) {
        if (f29547d == null) {
            synchronized (g.class) {
                if (f29547d == null) {
                    f29547d = new g(context);
                }
            }
        }
        return f29547d;
    }

    public boolean a() {
        try {
            IWXAPI iwxapi = this.f29549b;
            if (iwxapi != null) {
                return iwxapi.isWXAppInstalled();
            }
            return false;
        } catch (Exception e2) {
            x0.b("WeChatUtil", e2.getMessage());
            return false;
        }
    }

    public boolean a(com.vivo.ad.model.g gVar) {
        try {
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = gVar.f26892a;
            req.path = gVar.f26893b;
            req.miniprogramType = 0;
            IWXAPI iwxapi = this.f29549b;
            if (iwxapi != null) {
                return iwxapi.sendReq(req);
            }
        } catch (Exception e2) {
            x0.b("WeChatUtil", e2.getMessage());
        }
        return false;
    }
}
