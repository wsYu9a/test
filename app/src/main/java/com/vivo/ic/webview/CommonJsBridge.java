package com.vivo.ic.webview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.a;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.vivo.ic.dm.Downloads;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.f1.b;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class CommonJsBridge implements JsInterface {
    public static final String CLIP_KEY = "LIB_CLIP_KEY_MAIN";
    private static final String COM_ANDROID_BROWSER = "com.android.browser";
    private static final String COM_VIVO_BROWSER = "com.vivo.browser";
    private static final String TAG = "CommonJsBridge";
    private IBridge mBridge;
    private ArrayList<String> mCallBackList = new ArrayList<>();
    private Context mContext;
    private InputMethodManager mInputMethodManager;
    private CommonWebView mWebView;

    /* renamed from: com.vivo.ic.webview.CommonJsBridge$1 */
    class AnonymousClass1 extends b {
        AnonymousClass1() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (CommonJsBridge.this.mContext instanceof Activity) {
                ((Activity) CommonJsBridge.this.mContext).onBackPressed();
            }
        }
    }

    /* renamed from: com.vivo.ic.webview.CommonJsBridge$2 */
    class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (CommonJsBridge.this.mInputMethodManager != null) {
                CommonJsBridge.this.mInputMethodManager.hideSoftInputFromWindow(CommonJsBridge.this.mWebView.getWindowToken(), 0);
            }
        }
    }

    private void checkNull(Object obj) {
        if (obj == null || ((obj instanceof String) && TextUtils.isEmpty((String) obj))) {
            throw new RuntimeException("object can't be null");
        }
    }

    public static String generateJsCallBack(String str, String... strArr) {
        Log.d(TAG, "funName " + str + " args " + strArr);
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append(str);
        StringBuffer stringBuffer = new StringBuffer(sb.toString());
        if (strArr == null || strArr.length == 0) {
            stringBuffer.append("()");
        } else {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 == 0) {
                    stringBuffer.append("('" + strArr[i2]);
                } else {
                    stringBuffer.append("', '" + strArr[i2]);
                }
                if (i2 == length - 1) {
                    stringBuffer.append("')");
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Log.d(TAG, "jsCallBack " + stringBuffer2);
        return stringBuffer2;
    }

    public static String getConnectionTypeName(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
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
            VOpenLog.w(TAG, "" + e2.getMessage());
            return "";
        }
    }

    boolean backToJs() {
        if (this.mCallBackList.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.mCallBackList.size(); i2++) {
            String str = this.mCallBackList.get(i2);
            this.mWebView.loadUrl("javascript:" + str + "()");
        }
        Log.i(TAG, "back is consumed by js");
        return true;
    }

    public void callJs(boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
            jSONObject.put(Downloads.RequestHeaders.COLUMN_VALUE, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mBridge.callJs(str2, null, jSONObject.toString());
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void copy(String str, String str2) throws Exception {
        checkNull(str);
        try {
            ((ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(CLIP_KEY, new JSONObject(str).getString(a.f5473b)));
        } catch (Exception e2) {
            VOpenLog.w(TAG, "" + e2.getMessage());
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void download(String str, String str2) throws Exception {
        checkNull(str);
        String string = new JSONObject(str).getString("url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(string));
                intent.setPackage(COM_VIVO_BROWSER);
                this.mContext.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage(COM_ANDROID_BROWSER);
                this.mContext.startActivity(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(string));
                this.mContext.startActivity(intent2);
            } catch (ActivityNotFoundException unused2) {
                Log.i(TAG, "this phone don't has any brower");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void enableSoftInputHiden(String str, String str2) throws Exception {
        checkNull(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ("true".equals(new JSONObject(str).getString("enable"))) {
                this.mWebView.enableHideSoftInputWhenScroll(true);
            } else {
                this.mWebView.enableHideSoftInputWhenScroll(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void exit(String str, String str2) throws Exception {
        checkNull(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                CallBack javaHandlerCallBack = this.mBridge.getJavaHandlerCallBack(jSONObject.getString("funName"));
                if (javaHandlerCallBack != null) {
                    javaHandlerCallBack.onCallBack(jSONObject.getJSONObject(com.alipay.sdk.authjs.a.f5379f).toString(), str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void getNetType(String str, String str2) {
        callJs(true, getConnectionTypeName(this.mContext), str2);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void hideSoftKeyBoard(String str, String str2) {
        if (this.mInputMethodManager == null) {
            try {
                this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            } catch (Exception e2) {
                VOpenLog.w(TAG, "" + e2.getMessage());
            }
        }
        this.mWebView.post(new b() { // from class: com.vivo.ic.webview.CommonJsBridge.2
            AnonymousClass2() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (CommonJsBridge.this.mInputMethodManager != null) {
                    CommonJsBridge.this.mInputMethodManager.hideSoftInputFromWindow(CommonJsBridge.this.mWebView.getWindowToken(), 0);
                }
            }
        });
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void isPackageInstall(String str, String str2) throws Exception {
        PackageInfo packageInfo;
        checkNull(str);
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(new JSONObject(str).getString(DBDefinition.PACKAGE_NAME), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        if (!(packageInfo != null)) {
            callJs(false, "", str2);
            return;
        }
        callJs(true, packageInfo.versionCode + "_" + packageInfo.versionName, str2);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void openAppByDeepLink(String str, String str2) throws Exception {
        checkNull(str);
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("deepLink");
        String string2 = JsonParserUtil.getString(DBDefinition.PACKAGE_NAME, jSONObject);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(string));
        if (!TextUtils.isEmpty(string2)) {
            intent.setPackage(string2);
        }
        try {
            this.mContext.startActivity(intent);
            callJs(true, str, str2);
        } catch (Exception e2) {
            callJs(false, e2.getMessage(), str2);
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void openAppByPackage(String str, String str2) throws Exception {
        checkNull(str);
        JSONObject jSONObject = new JSONObject(str);
        String string = JsonParserUtil.getString("mainClass", jSONObject);
        String string2 = jSONObject.getString(DBDefinition.PACKAGE_NAME);
        if (TextUtils.isEmpty(string)) {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(string2);
            if (launchIntentForPackage != null) {
                this.mContext.startActivity(launchIntentForPackage);
                callJs(true, str, str2);
                return;
            } else {
                Log.e(TAG, "app not found");
                callJs(false, "app not found", str2);
                return;
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(string2, string2 + "." + string));
        this.mContext.startActivity(intent);
        callJs(true, str, str2);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void registerBack(String str, String str2) throws Exception {
        checkNull(str);
        String string = new JSONObject(str).getString("backPressCallback");
        if (this.mCallBackList.contains(string)) {
            return;
        }
        this.mCallBackList.add(string);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void requestedOrientation(String str, String str2) throws Exception {
        checkNull(str);
        String string = new JSONObject(str).getString("orientation");
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            Log.w(TAG, "requestedOrientation err context");
            return;
        }
        Activity activity = (Activity) context;
        try {
            int parseInt = Integer.parseInt(string);
            if (parseInt >= 0 || parseInt <= 1) {
                activity.setRequestedOrientation(parseInt);
            } else {
                Log.w(TAG, "requestedOrientation orientation err");
            }
        } catch (Exception e2) {
            Log.e(TAG, "requestedOrientation err", e2);
        }
    }

    public void setBridgeImpl(IBridge iBridge) {
        this.mBridge = iBridge;
    }

    public void setContext(Context context, CommonWebView commonWebView) {
        this.mContext = context;
        this.mWebView = commonWebView;
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void toast(String str, String str2) throws Exception {
        checkNull(str);
        JSONObject jSONObject = new JSONObject(str);
        String string = JsonParserUtil.getString("tips", jSONObject);
        String string2 = JsonParserUtil.getString("sec", jSONObject);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            Toast.makeText(this.mContext, string, 0).show();
            return;
        }
        try {
            Toast.makeText(this.mContext, string, Integer.valueOf(string2).intValue()).show();
        } catch (Exception e2) {
            VOpenLog.w(TAG, "toast: " + e2.getMessage());
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void unregisterBack(String str, String str2) throws Exception {
        checkNull(str);
        String string = new JSONObject(str).getString("backPressCallback");
        Log.d(TAG, "unregisterBack " + string);
        this.mCallBackList.remove(string);
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void webBackPress(String str, String str2) {
        if (this.mCallBackList.size() <= 0) {
            this.mWebView.post(new b() { // from class: com.vivo.ic.webview.CommonJsBridge.1
                AnonymousClass1() {
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    if (CommonJsBridge.this.mContext instanceof Activity) {
                        ((Activity) CommonJsBridge.this.mContext).onBackPressed();
                    }
                }
            });
            return;
        }
        for (int i2 = 0; i2 < this.mCallBackList.size(); i2++) {
            String str3 = this.mCallBackList.get(i2);
            this.mWebView.loadUrl("javascript:" + str3 + "()");
        }
    }

    @Override // com.vivo.ic.webview.JsInterface
    public void webViewFull(String str, String str2) {
        checkNull(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ("true".equals(new JSONObject(str).getString("full"))) {
                HtmlWebChromeClient.fullScreen((Activity) this.mContext, true, null);
            } else {
                HtmlWebChromeClient.fullScreen((Activity) this.mContext, false, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
