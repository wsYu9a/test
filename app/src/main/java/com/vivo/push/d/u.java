package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class u extends z {
    u(com.vivo.push.o oVar) {
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
    protected final void a(com.vivo.push.o oVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
        InsideNotificationItem f2 = pVar.f();
        if (f2 == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a2 = com.vivo.push.util.q.a(f2);
        boolean equals = this.f31028a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f31028a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put(com.heytap.mcssdk.n.d.n, String.valueOf(pVar.e()));
            hashMap.put("platform", this.f31028a.getPackageName());
            Context context = this.f31028a;
            String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a2.getSkipType() + "]");
            int skipType = a2.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new v(this, this.f31028a, a2.getParams())).start();
                a(a2);
                return;
            }
            if (skipType == 2) {
                String skipContent = a2.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    b(intent, a2.getParams());
                    try {
                        this.f31028a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                }
                a(a2);
                return;
            }
            if (skipType == 3) {
                a(a2);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a2.getSkipType());
                return;
            }
            String skipContent2 = a2.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e2) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f31028a.getPackageName().equals(str)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f31028a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f31028a.getPackageName().equals(packageName)) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f31028a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f31028a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a2.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f31028a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f31028a.startActivity(parseUri);
                a(a2);
                return;
            }
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a2 + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.m.c(new w(this, uPSNotificationMessage));
    }
}
