package com.martian.ttbook.b.a.q;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f15144a = "com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkWebViewActivity";

    /* renamed from: com.martian.ttbook.b.a.q.a$a */
    public interface InterfaceC0286a {

        /* renamed from: a */
        public static final InterfaceC0286a f15145a = new C0287a();

        /* renamed from: com.martian.ttbook.b.a.q.a$a$a */
        static class C0287a implements InterfaceC0286a {
            C0287a() {
            }

            @Override // com.martian.ttbook.b.a.q.a.InterfaceC0286a
            public void onShow() {
            }
        }

        void onShow();
    }

    public static void a(Context context, String str, String str2, InterfaceC0286a interfaceC0286a) {
        try {
            Class<?> cls = Class.forName(f15144a);
            cls.getDeclaredMethod("setWebViewStateListener", InterfaceC0286a.class).invoke(cls, interfaceC0286a);
            Intent intent = new Intent(context, cls);
            intent.putExtra("mClickUrl", str2);
            intent.putExtra("title", str);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.getApplicationContext().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
