package com.maritan.libweixin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import androidx.core.provider.FontsContractCompat;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public class f extends AsyncTask<Void, Void, Map<String, String>> {

    /* renamed from: a */
    private ProgressDialog f9571a;

    /* renamed from: b */
    private final WeakReference<Activity> f9572b;

    /* renamed from: c */
    private final a f9573c;

    /* renamed from: d */
    private final h f9574d;

    /* renamed from: e */
    private final g f9575e;

    /* renamed from: f */
    private String f9576f;

    public interface a {
        void a(Map<String, String> result);

        void onError(String errStr);
    }

    public f(Activity activity, h product, g wxKey, a listener) {
        this.f9572b = new WeakReference<>(activity);
        this.f9574d = product;
        this.f9575e = wxKey;
        this.f9573c = listener;
    }

    /* renamed from: b */
    public /* synthetic */ void c(DialogInterface dialog) {
        cancel(false);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Map<String, String> doInBackground(Void... params) {
        byte[] k = i.k("https://api.mch.weixin.qq.com/pay/unifiedorder", i.h(this.f9574d, this.f9575e));
        if (k == null) {
            return null;
        }
        String str = new String(k);
        this.f9576f = str;
        return i.a(str);
    }

    @Override // android.os.AsyncTask
    /* renamed from: d */
    public void onPostExecute(Map<String, String> result) {
        String str;
        ProgressDialog progressDialog = this.f9571a;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        if (isCancelled()) {
            return;
        }
        if (result == null) {
            a aVar = this.f9573c;
            if (aVar != null) {
                aVar.onError(this.f9576f);
                return;
            }
            return;
        }
        String str2 = result.get("return_code");
        if (str2 != null && str2.equalsIgnoreCase("SUCCESS") && (str = result.get(FontsContractCompat.Columns.RESULT_CODE)) != null && str.equalsIgnoreCase("SUCCESS")) {
            a aVar2 = this.f9573c;
            if (aVar2 != null) {
                aVar2.a(result);
                return;
            }
            return;
        }
        String str3 = result.get("return_msg");
        if (str3 == null) {
            str3 = result.get("err_code_des");
        }
        if (str3 == null) {
            str3 = this.f9576f;
        }
        a aVar3 = this.f9573c;
        if (aVar3 != null) {
            aVar3.onError(str3);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Activity activity = this.f9572b.get();
        if (activity != null) {
            this.f9571a = ProgressDialog.show(activity, "加载中", "正在获取订单号");
        }
        this.f9571a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.maritan.libweixin.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                f.this.c(dialogInterface);
            }
        });
    }
}
