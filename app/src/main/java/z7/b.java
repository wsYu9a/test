package z7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.open.SocialConstants;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: e */
    public static b f33700e;

    /* renamed from: a */
    public IWXAPI f33701a;

    /* renamed from: b */
    public final Map<String, InterfaceC0852b> f33702b;

    /* renamed from: c */
    public c f33703c;

    /* renamed from: d */
    public a f33704d;

    public interface a {
        void a(String str);

        void b(String str);

        void onLoginCancelled();
    }

    /* renamed from: z7.b$b */
    public interface InterfaceC0852b {
        void a();

        void b();

        void c(String str);

        void d();
    }

    public interface c {
        void a(String str);

        void b(String str, String str2);

        void c();

        void d();
    }

    public b() {
        this.f33702b = new Hashtable();
    }

    public static byte[] b(Bitmap bitmap, boolean z10) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
        bitmap.recycle();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!createScaledBitmap.isRecycled()) {
            createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        }
        if (z10) {
            createScaledBitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e10) {
            System.out.println(e10.getMessage());
        }
        return byteArray;
    }

    public static b d() {
        if (f33700e == null) {
            f33700e = new b();
        }
        return f33700e;
    }

    public void a(Context context, String str, a aVar) {
        this.f33704d = aVar;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "withdraw_weixin_login";
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, str, true);
        createWXAPI.registerApp(str);
        createWXAPI.sendReq(req);
    }

    public final String c(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public IWXAPI e() {
        return this.f33701a;
    }

    public void f(Context context, z7.c cVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, cVar.f33705a, true);
        this.f33701a = createWXAPI;
        createWXAPI.registerApp(cVar.f33705a);
    }

    public void g() {
        a aVar = this.f33704d;
        if (aVar != null) {
            aVar.onLoginCancelled();
        }
    }

    public void h(String str) {
        a aVar = this.f33704d;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public void i(String str) {
        a aVar = this.f33704d;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void j() {
        c cVar = this.f33703c;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void k(String str) {
        c cVar = this.f33703c;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void l(String str, String str2) {
        c cVar = this.f33703c;
        if (cVar != null) {
            cVar.b(str, str2);
        }
    }

    public void m() {
        c cVar = this.f33703c;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void n(String str) {
        InterfaceC0852b interfaceC0852b = this.f33702b.get(str);
        if (interfaceC0852b != null) {
            interfaceC0852b.a();
            this.f33702b.remove(str);
        }
    }

    public void o(String str, String str2) {
        InterfaceC0852b interfaceC0852b = this.f33702b.get(str);
        if (interfaceC0852b != null) {
            interfaceC0852b.c(str2);
            this.f33702b.remove(str);
        }
    }

    public void p(String str) {
        InterfaceC0852b interfaceC0852b = this.f33702b.get(str);
        if (interfaceC0852b != null) {
            interfaceC0852b.b();
            this.f33702b.remove(str);
        }
    }

    public final void q(String str, InterfaceC0852b interfaceC0852b) {
        if (interfaceC0852b != null) {
            this.f33702b.put(str, interfaceC0852b);
        }
    }

    public void r(Context context, String str, String str2, String str3, int i10, InterfaceC0852b interfaceC0852b) {
        y(context, str, str2, str3, i10, true, interfaceC0852b);
    }

    public void s(String str, String str2, String str3, Bitmap bitmap, InterfaceC0852b interfaceC0852b) {
        z(str, str2, str3, bitmap, true, interfaceC0852b);
    }

    public void t(Context context, String str, String str2, String str3, int i10, InterfaceC0852b interfaceC0852b) {
        y(context, str, str2, str3, i10, false, interfaceC0852b);
    }

    public void u(String str, String str2, String str3, Bitmap bitmap, InterfaceC0852b interfaceC0852b) {
        z(str, str2, str3, bitmap, false, interfaceC0852b);
    }

    public void v(Bitmap bitmap, boolean z10, InterfaceC0852b interfaceC0852b) {
        if (interfaceC0852b != null) {
            interfaceC0852b.d();
        }
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = b(Bitmap.createScaledBitmap(bitmap, 120, 120, true), true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        String c10 = c(SocialConstants.PARAM_IMG_URL);
        req.transaction = c10;
        q(c10, interfaceC0852b);
        req.message = wXMediaMessage;
        req.scene = z10 ? 1 : 0;
        IWXAPI iwxapi = this.f33701a;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public void w(a aVar) {
        this.f33704d = aVar;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "martian_weixin_login";
        IWXAPI iwxapi = this.f33701a;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public void x(Context context, String str, String str2, PayReq payReq, c cVar) {
        this.f33703c = cVar;
        if (payReq == null) {
            if (cVar != null) {
                cVar.a("请求失败");
            }
        } else {
            l(payReq.prepayId, str2);
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, str, true);
            createWXAPI.registerApp(str);
            createWXAPI.sendReq(payReq);
        }
    }

    public final void y(Context context, String str, String str2, String str3, int i10, boolean z10, InterfaceC0852b interfaceC0852b) {
        z(str, str2, str3, BitmapFactory.decodeResource(context.getResources(), i10), z10, interfaceC0852b);
    }

    public final void z(String str, String str2, String str3, Bitmap bitmap, boolean z10, InterfaceC0852b interfaceC0852b) {
        if (interfaceC0852b != null) {
            interfaceC0852b.d();
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject(str3);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.thumbData = b(bitmap, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        String c10 = c("webpage");
        req.transaction = c10;
        q(c10, interfaceC0852b);
        req.message = wXMediaMessage;
        req.scene = z10 ? 1 : 0;
        IWXAPI iwxapi = this.f33701a;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public b(Context context, String str, String str2, String str3) {
        this(context, new z7.c(str, str2, str3));
    }

    public b(Context context, z7.c cVar) {
        this.f33702b = new Hashtable();
        f(context, cVar);
    }
}
