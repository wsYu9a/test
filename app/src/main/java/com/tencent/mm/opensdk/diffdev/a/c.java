package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: classes4.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f25347a;

    /* renamed from: b */
    private String f25348b;

    /* renamed from: c */
    private OAuthListener f25349c;

    /* renamed from: d */
    private int f25350d;

    static class a {

        /* renamed from: a */
        public OAuthErrCode f25351a;

        /* renamed from: b */
        public String f25352b;

        /* renamed from: c */
        public int f25353c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f25347a = str;
        this.f25349c = oAuthListener;
        this.f25348b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f25349c.onAuthFinish(aVar2.f25351a, aVar2.f25352b);
    }
}
