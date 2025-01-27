package com.vivo.push.d;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InsideNotificationItem f25012a;

    /* renamed from: b */
    final /* synthetic */ com.vivo.push.b.q f25013b;

    /* renamed from: c */
    final /* synthetic */ r f25014c;

    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f25014c = rVar;
        this.f25012a = insideNotificationItem;
        this.f25013b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        int type;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        r rVar = this.f25014c;
        PushMessageCallback pushMessageCallback = ((z) rVar).f25023b;
        context = ((com.vivo.push.l) rVar).f25064a;
        if (pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f25012a))) {
            StringBuilder sb2 = new StringBuilder("pkg name : ");
            context11 = ((com.vivo.push.l) this.f25014c).f25064a;
            sb2.append(context11.getPackageName());
            sb2.append(" 应用主动拦截通知");
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb2.toString());
            context12 = ((com.vivo.push.l) this.f25014c).f25064a;
            com.vivo.push.util.p.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.f25013b.f()));
            context13 = ((com.vivo.push.l) this.f25014c).f25064a;
            context14 = ((com.vivo.push.l) this.f25014c).f25064a;
            String b10 = com.vivo.push.util.z.b(context13, context14.getPackageName());
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("remoteAppId", b10);
            }
            com.vivo.push.util.e.a(2120L, hashMap);
            return;
        }
        int b11 = this.f25014c.b();
        if (b11 > 0) {
            StringBuilder sb3 = new StringBuilder("pkg name : ");
            context7 = ((com.vivo.push.l) this.f25014c).f25064a;
            sb3.append(context7.getPackageName());
            sb3.append(" notify channel switch is ");
            sb3.append(b11);
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb3.toString());
            context8 = ((com.vivo.push.l) this.f25014c).f25064a;
            com.vivo.push.util.p.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b11)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("messageID", String.valueOf(this.f25013b.f()));
            context9 = ((com.vivo.push.l) this.f25014c).f25064a;
            context10 = ((com.vivo.push.l) this.f25014c).f25064a;
            String b12 = com.vivo.push.util.z.b(context9, context10.getPackageName());
            if (!TextUtils.isEmpty(b12)) {
                hashMap2.put("remoteAppId", b12);
            }
            com.vivo.push.util.e.a(b11, hashMap2);
            return;
        }
        context2 = ((com.vivo.push.l) this.f25014c).f25064a;
        InsideNotificationItem insideNotificationItem = this.f25012a;
        long f10 = this.f25013b.f();
        r rVar2 = this.f25014c;
        PushMessageCallback pushMessageCallback2 = ((z) rVar2).f25023b;
        context3 = ((com.vivo.push.l) rVar2).f25064a;
        com.vivo.push.util.k kVar = new com.vivo.push.util.k(context2, insideNotificationItem, f10, pushMessageCallback2.isAllowNet(context3), new t(this));
        boolean isShowBigPicOnMobileNet = this.f25012a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f25012a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f25012a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = ((com.vivo.push.l) this.f25014c).f25064a;
                com.vivo.push.util.p.a(context4, "mobile net show");
            } else {
                context5 = ((com.vivo.push.l) this.f25014c).f25064a;
                com.vivo.push.util.p.a(context5, "mobile net unshow");
                context6 = ((com.vivo.push.l) this.f25014c).f25064a;
                NetworkInfo a10 = com.vivo.push.util.r.a(context6);
                if (a10 != null && a10.getState() == NetworkInfo.State.CONNECTED && (type = a10.getType()) != 1 && type == 0) {
                    this.f25012a.clearCoverUrl();
                    this.f25012a.clearPurePicUrl();
                    purePicUrl = null;
                }
            }
        }
        kVar.execute(this.f25012a.getIconUrl(), purePicUrl);
    }
}
