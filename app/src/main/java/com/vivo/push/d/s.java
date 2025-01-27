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
    final /* synthetic */ InsideNotificationItem f30985a;

    /* renamed from: b */
    final /* synthetic */ com.vivo.push.b.q f30986b;

    /* renamed from: c */
    final /* synthetic */ r f30987c;

    s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f30987c = rVar;
        this.f30985a = insideNotificationItem;
        this.f30986b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c2;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        r rVar = this.f30987c;
        PushMessageCallback pushMessageCallback = ((z) rVar).f30996b;
        context = ((com.vivo.push.l) rVar).f31028a;
        if (pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f30985a))) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context11 = ((com.vivo.push.l) this.f30987c).f31028a;
            sb.append(context11.getPackageName());
            sb.append(" 应用主动拦截通知");
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb.toString());
            context12 = ((com.vivo.push.l) this.f30987c).f31028a;
            com.vivo.push.util.p.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put(com.heytap.mcssdk.n.d.n, String.valueOf(this.f30986b.f()));
            context13 = ((com.vivo.push.l) this.f30987c).f31028a;
            context14 = ((com.vivo.push.l) this.f30987c).f31028a;
            String b2 = com.vivo.push.util.z.b(context13, context14.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            com.vivo.push.util.e.a(2120L, hashMap);
            return;
        }
        int b3 = this.f30987c.b();
        if (b3 > 0) {
            StringBuilder sb2 = new StringBuilder("pkg name : ");
            context7 = ((com.vivo.push.l) this.f30987c).f31028a;
            sb2.append(context7.getPackageName());
            sb2.append(" notify channel switch is ");
            sb2.append(b3);
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb2.toString());
            context8 = ((com.vivo.push.l) this.f30987c).f31028a;
            com.vivo.push.util.p.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b3)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(com.heytap.mcssdk.n.d.n, String.valueOf(this.f30986b.f()));
            context9 = ((com.vivo.push.l) this.f30987c).f31028a;
            context10 = ((com.vivo.push.l) this.f30987c).f31028a;
            String b4 = com.vivo.push.util.z.b(context9, context10.getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap2.put("remoteAppId", b4);
            }
            com.vivo.push.util.e.a(b3, hashMap2);
            return;
        }
        context2 = ((com.vivo.push.l) this.f30987c).f31028a;
        InsideNotificationItem insideNotificationItem = this.f30985a;
        long f2 = this.f30986b.f();
        r rVar2 = this.f30987c;
        PushMessageCallback pushMessageCallback2 = ((z) rVar2).f30996b;
        context3 = ((com.vivo.push.l) rVar2).f31028a;
        com.vivo.push.util.k kVar = new com.vivo.push.util.k(context2, insideNotificationItem, f2, pushMessageCallback2.isAllowNet(context3), new t(this));
        boolean isShowBigPicOnMobileNet = this.f30985a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f30985a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f30985a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = ((com.vivo.push.l) this.f30987c).f31028a;
                com.vivo.push.util.p.a(context4, "mobile net show");
            } else {
                context5 = ((com.vivo.push.l) this.f30987c).f31028a;
                com.vivo.push.util.p.a(context5, "mobile net unshow");
                context6 = ((com.vivo.push.l) this.f30987c).f31028a;
                NetworkInfo a2 = com.vivo.push.util.r.a(context6);
                if (a2 != null && a2.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a2.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.f30985a.clearCoverUrl();
                    this.f30985a.clearPurePicUrl();
                }
            }
        }
        kVar.execute(this.f30985a.getIconUrl(), purePicUrl);
    }
}
