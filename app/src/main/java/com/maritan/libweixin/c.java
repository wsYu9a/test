package com.maritan.libweixin;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import com.maritan.libweixin.dao.WXPaymentDao;
import com.maritan.libweixin.f;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static c f9550a;

    /* renamed from: b */
    private g f9551b;

    /* renamed from: c */
    public IWXAPI f9552c;

    /* renamed from: d */
    private Context f9553d;

    /* renamed from: e */
    private final Map<String, f> f9554e;

    /* renamed from: f */
    private d f9555f;

    /* renamed from: g */
    private InterfaceC0253c f9556g;

    /* loaded from: classes2.dex */
    class a implements f.a {

        /* renamed from: a */
        final /* synthetic */ h f9557a;

        a(final h val$product) {
            this.f9557a = val$product;
        }

        @Override // com.maritan.libweixin.f.a
        public void a(Map<String, String> result) {
            c.this.o(this.f9557a.f9583d, String.format(Locale.getDefault(), "%.2f", Float.valueOf((this.f9557a.f9585f * 1.0f) / 100.0f)));
            PayReq f2 = i.f(result, c.this.f9551b);
            c cVar = c.this;
            IWXAPI iwxapi = cVar.f9552c;
            if (iwxapi != null) {
                iwxapi.registerApp(cVar.f9551b.f9577a);
                c.this.f9552c.sendReq(f2);
            }
        }

        @Override // com.maritan.libweixin.f.a
        public void onError(String errStr) {
            c.this.n(this.f9557a.f9583d, errStr);
        }
    }

    /* loaded from: classes2.dex */
    class b extends com.maritan.libweixin.e {

        /* renamed from: c */
        final /* synthetic */ com.maritan.libweixin.dao.a f9559c;

        /* renamed from: d */
        final /* synthetic */ e f9560d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.maritan.libweixin.dao.a payment, g wxKey, final com.maritan.libweixin.dao.a val$listener, final e val$payment) {
            super(payment, wxKey);
            this.f9559c = val$listener;
            this.f9560d = val$payment;
        }

        @Override // com.maritan.libweixin.e
        protected void b(Integer status) {
            if (status.intValue() == 1) {
                c.this.p(this.f9559c.f9566e);
                this.f9560d.b(this.f9559c.f9566e);
            } else if (status.intValue() == -1) {
                c.this.n(this.f9559c.f9566e, "payment status -1.");
                this.f9560d.a(this.f9559c.f9566e);
            } else if (System.currentTimeMillis() - this.f9559c.f9568g.longValue() <= 1200000) {
                this.f9560d.c(this.f9559c.f9566e);
            } else {
                c.this.n(this.f9559c.f9566e, "payment status -1.");
                this.f9560d.a(this.f9559c.f9566e);
            }
        }
    }

    /* renamed from: com.maritan.libweixin.c$c */
    /* loaded from: classes2.dex */
    public interface InterfaceC0253c {
        void a(String authorizationCode);

        void b(String errStr);

        void onLoginCancelled();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(String errStr);

        void b(String out_trade_no, String fee_value);

        void c();

        void d();
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(String out_trade_no);

        void b(String out_trade_no);

        void c(String out_trade_no);
    }

    public interface f {
        void a();

        void b();

        void c(String errMsg);

        void d();
    }

    public c() {
        this.f9554e = new Hashtable();
    }

    private void F(String title, String content, String url, int imgResId, boolean isCircle, f listener) {
        G(title, content, url, BitmapFactory.decodeResource(this.f9553d.getResources(), imgResId), isCircle, listener);
    }

    private void G(String str, String str2, String str3, Bitmap bitmap, boolean z, f fVar) {
        if (fVar != null) {
            fVar.d();
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject(str3);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.thumbData = d(bitmap, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        String e2 = e("webpage");
        req.transaction = e2;
        t(e2, fVar);
        req.message = wXMediaMessage;
        req.scene = z ? 1 : 0;
        IWXAPI iwxapi = this.f9552c;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public static byte[] c(Bitmap bmp) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] d(Bitmap bmp, final boolean needRecycle) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bmp, 120, 120, true);
        bmp.recycle();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!createScaledBitmap.isRecycled()) {
            createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        }
        if (needRecycle) {
            createScaledBitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    private String e(final String type) {
        if (type == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return type + System.currentTimeMillis();
    }

    public static c g() {
        if (f9550a == null) {
            f9550a = new c();
        }
        return f9550a;
    }

    private void t(String transaction, f listener) {
        if (listener != null) {
            this.f9554e.put(transaction, listener);
        }
    }

    public void A(Bitmap bitmap, boolean z, f fVar) {
        if (fVar != null) {
            fVar.d();
        }
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = d(Bitmap.createScaledBitmap(bitmap, 120, 120, true), true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        String e2 = e(SocialConstants.PARAM_IMG_URL);
        req.transaction = e2;
        t(e2, fVar);
        req.message = wXMediaMessage;
        req.scene = z ? 1 : 0;
        IWXAPI iwxapi = this.f9552c;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public void B(InterfaceC0253c listener) {
        this.f9556g = listener;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "martian_weixin_login";
        IWXAPI iwxapi = this.f9552c;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public void C(String appId, String miniProgramId, String jumpurl) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f9553d, appId);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = miniProgramId;
        req.path = jumpurl;
        req.miniprogramType = 0;
        createWXAPI.sendReq(req);
    }

    public void D(Activity activity, final h product, final d listener) {
        this.f9555f = listener;
        new com.maritan.libweixin.f(activity, product, this.f9551b, new a(product)).execute(new Void[0]);
    }

    public void E(String wxAppid, PayReq req, d listener) {
        this.f9555f = listener;
        o("", "");
        if (req != null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f9553d, wxAppid, true);
            createWXAPI.registerApp(wxAppid);
            createWXAPI.sendReq(req);
        } else {
            d dVar = this.f9555f;
            if (dVar != null) {
                dVar.a("请求失败");
            }
        }
    }

    public void b(String withdrawWxappid, InterfaceC0253c listener) {
        this.f9556g = listener;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "withdraw_weixin_login";
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f9553d, withdrawWxappid, true);
        createWXAPI.registerApp(withdrawWxappid);
        createWXAPI.sendReq(req);
    }

    public void f(final e listener) {
        com.maritan.libweixin.dao.a a2 = new WXPaymentDao(this.f9553d).a();
        if (a2 != null) {
            new b(a2, this.f9551b, a2, listener).execute(new Void[0]);
        }
    }

    public g h() {
        return this.f9551b;
    }

    public void i(Context context, g wxKey) {
        this.f9553d = context;
        this.f9551b = wxKey;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, wxKey.f9577a, true);
        this.f9552c = createWXAPI;
        createWXAPI.registerApp(wxKey.f9577a);
    }

    public void j() {
        InterfaceC0253c interfaceC0253c = this.f9556g;
        if (interfaceC0253c != null) {
            interfaceC0253c.onLoginCancelled();
        }
    }

    public void k(String errStr) {
        InterfaceC0253c interfaceC0253c = this.f9556g;
        if (interfaceC0253c != null) {
            interfaceC0253c.b(errStr);
        }
    }

    public void l(String authorizationCode) {
        InterfaceC0253c interfaceC0253c = this.f9556g;
        if (interfaceC0253c != null) {
            interfaceC0253c.a(authorizationCode);
        }
    }

    public void m(String out_trade_no) {
        new WXPaymentDao(this.f9553d).updatePaymentFail(out_trade_no);
        d dVar = this.f9555f;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void n(String out_trade_no, String errStr) {
        new WXPaymentDao(this.f9553d).updatePaymentFail(out_trade_no);
        d dVar = this.f9555f;
        if (dVar != null) {
            dVar.a(errStr);
        }
    }

    public void o(String out_trade_no, String fee_value) {
        new WXPaymentDao(this.f9553d).insert(out_trade_no, fee_value);
        d dVar = this.f9555f;
        if (dVar != null) {
            dVar.b(out_trade_no, fee_value);
        }
    }

    public void p(String out_trade_no) {
        new WXPaymentDao(this.f9553d).updatePaymentSuccess(out_trade_no);
        d dVar = this.f9555f;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void q(String transaction) {
        f fVar = this.f9554e.get(transaction);
        if (fVar != null) {
            fVar.a();
            this.f9554e.remove(transaction);
        }
    }

    public void r(String transaction, String errorMsg) {
        f fVar = this.f9554e.get(transaction);
        if (fVar != null) {
            fVar.c(errorMsg);
            this.f9554e.remove(transaction);
        }
    }

    public void s(String transaction) {
        f fVar = this.f9554e.get(transaction);
        if (fVar != null) {
            fVar.b();
            this.f9554e.remove(transaction);
        }
    }

    public boolean u(Activity activity, String content, List<String> imgFiles) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.setType("image/*");
        intent.putExtra("Kdescription", content);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (String str : imgFiles) {
            if (str != null) {
                if (!str.startsWith("file:///")) {
                    str = "file:///" + str;
                }
                Uri parse = Uri.parse(str);
                Log.e("CIRCLE_IMAGE", parse.toString());
                arrayList.add(parse);
            }
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        try {
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public void v(String title, String content, String url, int imgResId, f listener) {
        F(title, content, url, imgResId, true, listener);
    }

    public void w(String title, String content, String url, Bitmap thumb, f listener) {
        G(title, content, url, thumb, true, listener);
    }

    public void x(String content, String imageUrl, Bitmap bitmap) {
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        wXImageObject.imagePath = imageUrl;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = content;
        wXMediaMessage.description = content;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 144, 144, true);
        bitmap.recycle();
        wXMediaMessage.thumbData = c(createScaledBitmap);
        createScaledBitmap.recycle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = e(SocialConstants.PARAM_IMG_URL);
        req.message = wXMediaMessage;
        req.scene = 0;
        IWXAPI iwxapi = this.f9552c;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }

    public void y(String title, String content, String url, int imgResId, f listener) {
        F(title, content, url, imgResId, false, listener);
    }

    public void z(String title, String content, String url, Bitmap thumb, f listener) {
        G(title, content, url, thumb, false, listener);
    }

    public c(Context context, String appid, String appKey, String mchId) {
        this(context, new g(appid, appKey, mchId));
    }

    public c(Context context, g loginWxKey) {
        this.f9554e = new Hashtable();
        i(context, loginWxKey);
    }
}
