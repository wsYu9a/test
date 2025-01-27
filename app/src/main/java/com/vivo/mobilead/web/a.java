package com.vivo.mobilead.web;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.webview.CallBack;
import com.vivo.ic.webview.CommonJsBridge;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.HtmlWebChromeClient;
import com.vivo.ic.webview.IBridge;
import com.vivo.ic.webview.JsInterface;
import com.vivo.ic.webview.JsonParserUtil;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.x0;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a implements JsInterface {

    /* renamed from: a */
    private Context f30839a;

    /* renamed from: b */
    private IBridge f30840b;

    /* renamed from: c */
    private ArrayList<String> f30841c = new ArrayList<>();

    /* renamed from: d */
    private CommonWebView f30842d;

    /* renamed from: e */
    private InputMethodManager f30843e;

    /* renamed from: com.vivo.mobilead.web.a$a */
    class C0674a extends com.vivo.mobilead.util.f1.b {
        C0674a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (a.this.f30839a instanceof Activity) {
                ((Activity) a.this.f30839a).onBackPressed();
            }
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {
        b() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (a.this.f30843e != null) {
                a.this.f30843e.hideSoftInputFromWindow(a.this.f30842d.getWindowToken(), 0);
            }
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void copy(String str, String str2) throws Exception {
        a(str);
        try {
            String string = new JSONObject(str).getString(com.baidu.mobads.sdk.internal.a.f5473b);
            ClipboardManager clipboardManager = (ClipboardManager) this.f30839a.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText(CommonJsBridge.CLIP_KEY, string);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
        } catch (Exception e2) {
            VOpenLog.w("CommonJsBridge", "" + e2.getMessage());
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void download(String str, String str2) throws Exception {
        a(str);
        String string = new JSONObject(str).getString("url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(string));
                intent.setPackage("com.vivo.browser");
                this.f30839a.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage("com.android.browser");
                this.f30839a.startActivity(intent);
            }
        } catch (Exception e2) {
            x0.b("CommonJsBridge", "download Exception error " + e2);
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(string));
                this.f30839a.startActivity(intent2);
            } catch (ActivityNotFoundException e3) {
                x0.b("CommonJsBridge", "download ActivityNotFoundException error " + e3);
            } catch (Exception e4) {
                x0.b("CommonJsBridge", "download final Exception error " + e4);
            }
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void enableSoftInputHiden(String str, String str2) throws Exception {
        a(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ("true".equals(new JSONObject(str).getString("enable"))) {
                this.f30842d.enableHideSoftInputWhenScroll(true);
            } else {
                this.f30842d.enableHideSoftInputWhenScroll(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void exit(String str, String str2) throws Exception {
        a(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                CallBack javaHandlerCallBack = this.f30840b.getJavaHandlerCallBack(jSONObject.getString("funName"));
                if (javaHandlerCallBack != null) {
                    javaHandlerCallBack.onCallBack(jSONObject.getJSONObject(com.alipay.sdk.authjs.a.f5379f).toString(), str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Context context = this.f30839a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void getNetType(String str, String str2) {
        a(true, a(this.f30839a), str2);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void hideSoftKeyBoard(String str, String str2) {
        if (this.f30843e == null) {
            try {
                this.f30843e = (InputMethodManager) this.f30839a.getSystemService("input_method");
            } catch (Exception e2) {
                VOpenLog.w("CommonJsBridge", "" + e2.getMessage());
            }
        }
        this.f30842d.post(new b());
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void isPackageInstall(String str, String str2) throws Exception {
        PackageInfo packageInfo;
        a(str);
        try {
            packageInfo = this.f30839a.getPackageManager().getPackageInfo(new JSONObject(str).getString(DBDefinition.PACKAGE_NAME), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        if (!(packageInfo != null)) {
            a(false, "", str2);
            return;
        }
        a(true, packageInfo.versionCode + "_" + packageInfo.versionName, str2);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void openAppByDeepLink(String str, String str2) throws Exception {
        a(str);
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("deepLink");
        String string2 = JsonParserUtil.getString(DBDefinition.PACKAGE_NAME, jSONObject);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(string));
        if (!TextUtils.isEmpty(string2)) {
            intent.setPackage(string2);
        }
        try {
            this.f30839a.startActivity(intent);
            a(true, str, str2);
        } catch (Exception e2) {
            a(false, e2.getMessage(), str2);
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void openAppByPackage(String str, String str2) throws Exception {
        a(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = JsonParserUtil.getString("mainClass", jSONObject);
            String string2 = jSONObject.getString(DBDefinition.PACKAGE_NAME);
            if (TextUtils.isEmpty(string)) {
                Intent launchIntentForPackage = this.f30839a.getPackageManager().getLaunchIntentForPackage(string2);
                if (launchIntentForPackage != null) {
                    this.f30839a.startActivity(launchIntentForPackage);
                    a(true, str, str2);
                } else {
                    Log.e("CommonJsBridge", "app not found");
                    a(false, "app not found", str2);
                }
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(string2, string2 + "." + string));
                this.f30839a.startActivity(intent);
                a(true, str, str2);
            }
        } catch (Exception e2) {
            VOpenLog.w("CommonJsBridge", "" + e2.getMessage());
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void registerBack(String str, String str2) throws Exception {
        a(str);
        String string = new JSONObject(str).getString("backPressCallback");
        if (this.f30841c.contains(string)) {
            return;
        }
        this.f30841c.add(string);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void requestedOrientation(String str, String str2) throws Exception {
        a(str);
        String string = new JSONObject(str).getString("orientation");
        Context context = this.f30839a;
        if (!(context instanceof Activity)) {
            x0.e("CommonJsBridge", "requestedOrientation err context");
            return;
        }
        Activity activity = (Activity) context;
        try {
            int parseInt = Integer.parseInt(string);
            if (parseInt >= 0 && parseInt <= 1) {
                activity.setRequestedOrientation(parseInt);
            }
            x0.e("CommonJsBridge", "requestedOrientation orientation err");
        } catch (Exception e2) {
            x0.b("CommonJsBridge", "requestedOrientation Exception", e2);
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void toast(String str, String str2) throws Exception {
        a(str);
        JSONObject jSONObject = new JSONObject(str);
        String string = JsonParserUtil.getString("tips", jSONObject);
        String string2 = JsonParserUtil.getString("sec", jSONObject);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            Toast.makeText(this.f30839a, string, 0).show();
            return;
        }
        try {
            Toast.makeText(this.f30839a, string, Integer.valueOf(string2).intValue()).show();
        } catch (Exception e2) {
            VOpenLog.w("CommonJsBridge", "toast: " + e2.getMessage());
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void unregisterBack(String str, String str2) throws Exception {
        a(str);
        String string = new JSONObject(str).getString("backPressCallback");
        x0.a("CommonJsBridge", "unregisterBack " + string);
        this.f30841c.remove(string);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void webBackPress(String str, String str2) {
        if (this.f30841c.size() <= 0) {
            this.f30842d.post(new C0674a());
            return;
        }
        for (int i2 = 0; i2 < this.f30841c.size(); i2++) {
            String str3 = this.f30841c.get(i2);
            this.f30842d.loadUrl("javascript:" + str3 + "()");
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void webViewFull(String str, String str2) {
        a(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ("true".equals(new JSONObject(str).getString("full"))) {
                HtmlWebChromeClient.fullScreen((Activity) this.f30839a, true, null);
            } else {
                HtmlWebChromeClient.fullScreen((Activity) this.f30839a, false, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, CommonWebView commonWebView) {
        this.f30839a = context;
        this.f30842d = commonWebView;
    }

    public void a(IBridge iBridge) {
        this.f30840b = iBridge;
    }

    private void a(Object obj) {
        if (obj == null || ((obj instanceof String) && TextUtils.isEmpty((String) obj))) {
            throw new RuntimeException("object can't be null");
        }
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return "";
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return activeNetworkInfo.getTypeName();
            }
            if (type != 0) {
                return "";
            }
            return activeNetworkInfo.getExtraInfo() + "_" + activeNetworkInfo.getSubtypeName();
        } catch (Exception e2) {
            VOpenLog.w("CommonJsBridge", "" + e2.getMessage());
            return "";
        }
    }

    public void a(boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
            jSONObject.put(Downloads.RequestHeaders.COLUMN_VALUE, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f30840b.callJs(str2, null, jSONObject.toString());
    }

    boolean a() {
        if (this.f30841c.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f30841c.size(); i2++) {
            String str = this.f30841c.get(i2);
            this.f30842d.loadUrl("javascript:" + str + "()");
        }
        x0.c("CommonJsBridge", "back is consumed by js");
        return true;
    }
}
