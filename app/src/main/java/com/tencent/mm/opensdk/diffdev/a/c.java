package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: classes4.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f23071a;

    /* renamed from: b */
    private String f23072b;

    /* renamed from: c */
    private OAuthListener f23073c;

    /* renamed from: d */
    private int f23074d;

    public static class a {

        /* renamed from: a */
        public OAuthErrCode f23075a;

        /* renamed from: b */
        public String f23076b;

        /* renamed from: c */
        public int f23077c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f23071a = str;
        this.f23073c = oAuthListener;
        this.f23072b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016a A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r15) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f23073c.onAuthFinish(aVar2.f23075a, aVar2.f23076b);
    }
}
