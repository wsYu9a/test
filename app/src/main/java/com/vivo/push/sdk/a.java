package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import b7.b;
import com.vivo.push.b.x;
import com.vivo.push.c.d;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import h3.e;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class a extends q {

    /* renamed from: c */
    private static a f25093c;

    /* renamed from: e */
    private static final List<Integer> f25094e = Arrays.asList(3);

    /* renamed from: d */
    private String f25095d;

    /* renamed from: f */
    private String f25096f = "";

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f25093c == null) {
                    f25093c = new a();
                }
                aVar = f25093c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private boolean c(Intent intent) {
        String c10 = z.c(this.f25084a, "com.vivo.pushservice");
        p.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c10)));
        if (!TextUtils.equals(c10, "1")) {
            return true;
        }
        String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
        String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        try {
            if (d.a(this.f25084a).a().a("com.vivo.pushservice".getBytes("UTF-8"), u.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                p.d("CommandWorker", " RSA验签通过  ");
                return true;
            }
        } catch (Exception e10) {
            p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e10.getMessage());
        }
        p.d("CommandWorker", " RSA验签 不通过  ");
        return false;
    }

    private int d(Intent intent) {
        if (!TextUtils.isEmpty(this.f25096f) && this.f25096f.contains("CommandService") && (intent == null || !b(intent) || !c(intent))) {
            p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
            return 2151;
        }
        String packageName = this.f25084a.getPackageName();
        try {
            String stringExtra = intent.getStringExtra("command_type");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                int intExtra = intent.getIntExtra(b.X, -1);
                if (intExtra < 0) {
                    intExtra = intent.getIntExtra(e.f26414s, -1);
                }
                if (f25094e.contains(Integer.valueOf(intExtra)) && t.c(this.f25084a, packageName) && !t.c(this.f25084a)) {
                    p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                    return 2153;
                }
                String action = intent.getAction();
                if (!TextUtils.isEmpty(this.f25095d)) {
                    return 0;
                }
                String a10 = a(this.f25084a, packageName, action);
                this.f25095d = a10;
                if (!TextUtils.isEmpty(a10)) {
                    return 0;
                }
                p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                intent.setPackage(packageName);
                this.f25084a.sendBroadcast(intent);
                return 2152;
            }
            p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
            return 2151;
        } catch (Exception e10) {
            p.a("CommandWorker", e10);
            return 0;
        }
    }

    public final void b() {
        this.f25095d = null;
    }

    @Override // com.vivo.push.q
    public final void b(Message message) {
        Context context;
        Intent intent = (Intent) message.obj;
        if (intent == null || (context = this.f25084a) == null) {
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f25084a);
            return;
        }
        String packageName = context.getPackageName();
        int d10 = d(intent);
        if (d10 <= 0) {
            try {
                Class<?> cls = Class.forName(this.f25095d);
                Object newInstance = cls.getConstructor(null).newInstance(null);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.f25095d);
                method.invoke(newInstance, ContextDelegate.getContext(this.f25084a).getApplicationContext(), intent);
                return;
            } catch (Exception e10) {
                p.b("CommandWorker", "reflect e: ", e10);
                return;
            }
        }
        x xVar = new x(d10);
        HashMap<String, String> hashMap = new HashMap<>();
        Bundle extras = intent.getExtras();
        hashMap.put("messageID", String.valueOf(extras != null ? extras.getLong("notify_id", 404000044642424832L) : 404000044642424832L));
        String b10 = z.b(this.f25084a, packageName);
        if (!TextUtils.isEmpty(b10)) {
            hashMap.put("remoteAppId", b10);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
    }

    public final void a(String str) {
        this.f25096f = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f25084a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f25084a);
        }
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e10) {
            p.a("CommandWorker", "error  " + e10.getMessage());
            return null;
        }
    }

    private boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                String b10 = com.vivo.push.util.a.a(this.f25084a).b(stringExtra);
                if ("com.vivo.pushservice".equals(b10)) {
                    return true;
                }
                p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b10)));
                return false;
            } catch (Exception e10) {
                p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e10.getMessage());
                return false;
            }
        }
        p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
        return true;
    }
}
