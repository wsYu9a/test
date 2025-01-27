package com.maritan.libweixin;

import android.os.AsyncTask;
import android.util.Log;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class e extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a */
    private final com.maritan.libweixin.dao.a f9569a;

    /* renamed from: b */
    private final g f9570b;

    public e(com.maritan.libweixin.dao.a payment, g wxKey) {
        this.f9569a = payment;
        this.f9570b = wxKey;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(Void... params) {
        byte[] k = i.k("https://api.mch.weixin.qq.com/pay/orderquery", i.g(this.f9569a, this.f9570b));
        if (k == null) {
            return null;
        }
        String str = new String(k);
        Log.e("orion", str);
        Map<String, String> a2 = i.a(str);
        String str2 = a2 == null ? null : a2.get("trade_state");
        if (str2 == null) {
            return null;
        }
        if (str2.equalsIgnoreCase("SUCCESS")) {
            return 1;
        }
        return (str2.equalsIgnoreCase("CLOSED") || str2.equalsIgnoreCase("REVOKED") || str2.equalsIgnoreCase("NOTPAY") || str2.equalsIgnoreCase("PAYERROR")) ? -1 : 0;
    }

    protected abstract void b(Integer status);

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(Integer status) {
        if (status != null) {
            b(status);
        }
    }
}
