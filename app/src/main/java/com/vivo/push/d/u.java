package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class u extends z {
    public u(com.vivo.push.o oVar) {
        super(oVar);
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
        InsideNotificationItem f10 = pVar.f();
        if (f10 == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a10 = com.vivo.push.util.q.a(f10);
        boolean equals = this.f25064a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f25064a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.e()));
            hashMap.put("platform", this.f25064a.getPackageName());
            Context context = this.f25064a;
            String b10 = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("remoteAppId", b10);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a10.getSkipType() + "]");
            int skipType = a10.getSkipType();
            if (skipType == 1) {
                new Thread(new v(this, this.f25064a, a10.getParams())).start();
                a(a10);
                return;
            }
            if (skipType == 2) {
                String skipContent = a10.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                } else {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a10.getParams());
                    try {
                        this.f25064a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                }
                a(a10);
                return;
            }
            if (skipType == 3) {
                a(a10);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a10.getSkipType());
                return;
            }
            String skipContent2 = a10.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e10) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e10);
            }
            if (!TextUtils.isEmpty(str) && !this.f25064a.getPackageName().equals(str)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f25064a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f25064a.getPackageName().equals(packageName)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f25064a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f25064a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a10.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f25064a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f25064a.startActivity(parseUri);
                a(a10);
                return;
            }
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a10 + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.m.c(new w(this, uPSNotificationMessage));
    }
}
