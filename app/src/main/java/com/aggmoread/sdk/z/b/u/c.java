package com.aggmoread.sdk.z.b.u;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f5042a = "com.aggmoread.sdk.a.adcomm.amsdk.AmCustomWebviewActivity";

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5043a = new C0100a();

        /* renamed from: com.aggmoread.sdk.z.b.u.c$a$a, reason: collision with other inner class name */
        public static class C0100a implements a {
            @Override // com.aggmoread.sdk.z.b.u.c.a
            public void onShow() {
            }
        }

        void onShow();
    }

    public interface b extends a {
        void a(String str);
    }

    public static void a(Context context, String str, String str2, a aVar) {
        try {
            Class<?> cls = Class.forName(f5042a);
            cls.getDeclaredMethod("setWebViewStateListener", a.class).invoke(cls, aVar);
            Intent intent = new Intent(context, cls);
            intent.putExtra("mClickUrl", str2);
            intent.putExtra("title", str);
            intent.addFlags(268435456);
            context.getApplicationContext().startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
            if (aVar instanceof b) {
                ((b) aVar).a("err_" + e10.getMessage());
            }
        }
    }
}
