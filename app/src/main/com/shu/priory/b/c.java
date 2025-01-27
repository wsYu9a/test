package com.shu.priory.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.shu.priory.b.c;
import com.shu.priory.bean.AdImage;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.DialogListener;
import com.shu.priory.param.AdParam;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    protected com.shu.priory.g.a mAdData;
    protected Context mContext;
    protected DialogListener mListener;
    protected AdParam mParams;
    protected com.shu.priory.g.b mRespData;
    protected String mSessionId;
    protected com.shu.priory.download.d timerInterface;
    protected boolean isExposures = false;
    protected boolean isClicked = false;

    /* renamed from: com.shu.priory.b.c$1 */
    public class AnonymousClass1 implements a {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.b.c.a
        public void a() {
            c.this.startDeepLink();
        }

        @Override // com.shu.priory.b.c.a
        public void b() {
        }
    }

    public interface a {
        void a();

        void b();
    }

    public c(Context context, com.shu.priory.g.b bVar, AdParam adParam, DialogListener dialogListener) {
        this.mContext = context;
        this.mRespData = bVar;
        this.mAdData = bVar.f17105f;
        this.mSessionId = bVar.f17102c;
        this.mParams = adParam;
        this.mListener = dialogListener;
    }

    private void DeepLinkHintDialog(String str, Activity activity, a aVar) {
        if (activity == null) {
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton("跳转", new DialogInterface.OnClickListener() { // from class: com.shu.priory.b.d
                public /* synthetic */ d() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    c.lambda$DeepLinkHintDialog$1(c.a.this, dialogInterface, i10);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.shu.priory.b.e
                public /* synthetic */ e() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    c.lambda$DeepLinkHintDialog$2(c.a.this, dialogInterface, i10);
                }
            });
            builder.create().show();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "DeepLinkHintDialog error " + th2.toString());
        }
    }

    private void clickIsNotDeepLink(String str) {
        if (!URLUtil.isValidUrl(str) || str.equals("about:blank")) {
            h.a(SDKConstants.TAG, "Invalid click url: " + str);
            return;
        }
        if (getActionType() == 3) {
            startDownload("");
            return;
        }
        JSONObject jSONObject = this.mAdData.J;
        String jSONArray = (jSONObject == null || !jSONObject.has("general_monitor_urls")) ? null : this.mAdData.J.optJSONArray("general_monitor_urls").toString();
        JSONObject jSONObject2 = this.mRespData.f17108i;
        com.shu.priory.request.d.a(this.mContext, str, this.mParams, this.mRespData.f17102c, this.mAdData.I, jSONArray, jSONObject2 != null ? jSONObject2.toString() : null);
        j.b(com.shu.priory.param.b.f17178c + "type=H5Open&sid=" + this.mSessionId);
    }

    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void handleLandingUrl() {
        String str;
        JSONArray a10;
        JSONObject jSONObject = this.mRespData.f17108i;
        boolean optBoolean = (jSONObject == null || !jSONObject.has("j")) ? false : this.mRespData.f17108i.optBoolean("j");
        com.shu.priory.g.a aVar = this.mAdData;
        String str2 = aVar.L;
        if (TextUtils.isEmpty(aVar.K) || optBoolean) {
            clickIsNotDeepLink(str2);
            return;
        }
        String str3 = this.mAdData.K;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
        if (com.shu.priory.utils.b.a(str3) && com.shu.priory.utils.b.a(this.mContext.getApplicationContext(), intent)) {
            if (this.mParams.getBooleanParam(AdKeys.DEEPLINK_CONTORL)) {
                Activity findActivity = findActivity(this.mContext);
                if (findActivity != null) {
                    h.a(SDKConstants.TAG, "mContext is Activity , dialog  work");
                    findActivity.runOnUiThread(new Runnable() { // from class: wf.a

                        /* renamed from: c */
                        public final /* synthetic */ Activity f31712c;

                        public /* synthetic */ a(Activity findActivity2) {
                            findActivity = findActivity2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.lambda$handleLandingUrl$0(findActivity);
                        }
                    });
                    a10 = j.a(this.mAdData.J.optJSONArray("app_installed_urls"));
                    str = "10003";
                } else {
                    h.d(SDKConstants.TAG, "mContext is not Activity , dialog doesnot work");
                }
            } else {
                h.a(SDKConstants.TAG, "no deeplink , dialog doesnot work");
            }
            startDeepLink();
            a10 = j.a(this.mAdData.J.optJSONArray("app_installed_urls"));
            str = "10003";
        } else {
            clickIsNotDeepLink(str2);
            str = "10001";
            j.a(this.mAdData.J.optJSONArray("general_monitor_urls"), "10001", true);
            a10 = j.a(this.mAdData.J.optJSONArray("app_uninstalled_urls"));
        }
        j.a(a10, str, true);
    }

    public static /* synthetic */ void lambda$DeepLinkHintDialog$1(a aVar, DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.a();
        }
    }

    public static /* synthetic */ void lambda$DeepLinkHintDialog$2(a aVar, DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.b();
        }
    }

    public /* synthetic */ void lambda$handleLandingUrl$0(Activity activity) {
        DeepLinkHintDialog("即将跳转到第三方应用，是否继续跳转？", activity, new a() { // from class: com.shu.priory.b.c.1
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.b.c.a
            public void a() {
                c.this.startDeepLink();
            }

            @Override // com.shu.priory.b.c.a
            public void b() {
            }
        });
    }

    public void startDeepLink() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.mAdData.K));
            intent.addFlags(32768);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            this.mContext.startActivity(intent);
            j.a(this.mAdData.J.optJSONArray("general_monitor_urls"), "10000", true);
            j.a(j.a(this.mAdData.J.optJSONArray("app_invoke_success_urls")), "10000", true);
        } catch (Exception e10) {
            j.a(this.mAdData.J.optJSONArray("general_monitor_urls"), "10002", true);
            j.a(j.a(this.mAdData.J.optJSONArray("app_invoke_failed_urls")), "10002", true);
            h.d(SDKConstants.TAG, "native deep" + e10.getMessage());
        }
    }

    public void downloadApp() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.f17093t)) {
            return;
        }
        startDownload(this.mAdData.f17093t);
    }

    public int getActionType() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null) {
            return 0;
        }
        return aVar.M;
    }

    public AdImage getAdIcon() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || aVar.f17087n == null) {
            return null;
        }
        AdImage adImage = new AdImage();
        adImage.setUrl(this.mAdData.f17087n.optString("url"));
        adImage.setWidth(this.mAdData.f17087n.optInt("width"));
        adImage.setHeight(this.mAdData.f17087n.optInt("height"));
        return adImage;
    }

    public AdImage getAdImg() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || aVar.f17079f == null) {
            return null;
        }
        AdImage adImage = new AdImage();
        adImage.setUrl(this.mAdData.f17079f.optString("url"));
        adImage.setWidth(this.mAdData.f17079f.optInt("width"));
        adImage.setHeight(this.mAdData.f17079f.optInt("height"));
        return adImage;
    }

    public String getAdSourceMark() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.N;
    }

    public String getBrand() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.F;
    }

    public String getContent() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17088o;
    }

    public String getCtatext() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17089p;
    }

    public String getDesc() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17086m;
    }

    public String getIconUrl() {
        JSONObject jSONObject;
        com.shu.priory.g.a aVar = this.mAdData;
        return (aVar == null || (jSONObject = aVar.f17087n) == null || !jSONObject.has("url")) ? "" : this.mAdData.f17087n.optString("url");
    }

    public String getImgUrl() {
        JSONObject jSONObject;
        com.shu.priory.g.a aVar = this.mAdData;
        return (aVar == null || (jSONObject = aVar.f17079f) == null || !jSONObject.has("url")) ? "" : this.mAdData.f17079f.optString("url");
    }

    public double getPrice() {
        return this.mAdData.f17076c;
    }

    public String getRequestID() {
        return this.mRespData.f17101b;
    }

    public int getTemplateID() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null) {
            return 0;
        }
        return aVar.f17074a;
    }

    public String getTitle() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17085l;
    }

    public String getWinNoticeUrl() {
        return this.mAdData.O;
    }

    public boolean isExposured() {
        return this.isExposures;
    }

    public void onBiddingFailure(int i10, String str) {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.O)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "unkonwn";
        }
        String replace = this.mAdData.O.replace("__TYPE__", Integer.toString(i10)).replace("__REASON__", str);
        h.a(SDKConstants.TAG, "竞价成功");
        j.a(replace, this.mContext, 1);
    }

    public void onBiddingSuccess() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.O)) {
            return;
        }
        h.a(SDKConstants.TAG, "竞价成功");
        j.a(this.mAdData.O.replace("__TYPE__", "0"), this.mContext, 1);
    }

    public boolean onClick(View view, Object... objArr) {
        String str;
        handleLandingUrl();
        if (this.isClicked) {
            return true;
        }
        JSONObject jSONObject = this.mRespData.f17105f.J;
        if (jSONObject == null) {
            str = "monitor null";
        } else {
            if (jSONObject.has("click_urls")) {
                try {
                    if (this.isExposures) {
                        JSONArray a10 = j.a(((Integer) objArr[0]).intValue(), this.mAdData.J.optJSONArray("click_urls"));
                        if (objArr.length == 6) {
                            a10 = j.a(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue(), ((Float) objArr[2]).floatValue(), ((Float) objArr[3]).floatValue(), ((Float) objArr[4]).floatValue(), (int[]) objArr[5], a10);
                        }
                        h.a(SDKConstants.TAG, "repack click " + a10.toString());
                        j.a(a10, this.mContext, 2);
                        this.isClicked = true;
                        return true;
                    }
                } catch (Exception e10) {
                    h.d(SDKConstants.TAG, "native clk urls" + e10.getMessage());
                }
                return false;
            }
            str = "monitor no click";
        }
        h.a(SDKConstants.TAG, str);
        return false;
    }

    public boolean onExposure(View view) {
        if (this.isExposures) {
            h.a(SDKConstants.TAG, "已曝光");
            return true;
        }
        JSONObject jSONObject = this.mRespData.f17105f.J;
        if (jSONObject == null) {
            h.a(SDKConstants.TAG, "monitor null");
            return false;
        }
        if (!jSONObject.has("impress_urls")) {
            h.a(SDKConstants.TAG, "monitor no imp");
            return false;
        }
        boolean a10 = com.shu.priory.utils.b.a(this.mContext);
        boolean b10 = com.shu.priory.utils.b.b(this.mContext);
        boolean z10 = view.getVisibility() == 0;
        boolean isShown = view.isShown();
        boolean a11 = com.shu.priory.utils.b.a(this.mContext, view);
        if (a10 || b10 || !z10 || !isShown || !a11) {
            h.a(SDKConstants.TAG, "曝光失败-: B:" + a10 + " L:" + b10 + " V:" + z10 + " S:" + isShown + " I:" + a11);
            return false;
        }
        try {
            JSONArray a12 = j.a(this.mParams.getDoubleParam(AdKeys.AUCTION_PRICE), this.mAdData.J.optJSONArray("impress_urls"));
            if (a12 == null) {
                h.a(SDKConstants.TAG, "impArray null");
                return false;
            }
            this.isExposures = true;
            h.a(SDKConstants.TAG, "曝光成功");
            j.a(a12, this.mContext, 1);
            return true;
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "imp urls" + th2.getMessage());
            return false;
        }
    }

    public void setTimerInterface(com.shu.priory.download.d dVar) {
        this.timerInterface = dVar;
    }

    public void showIntroduce() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.f17094u)) {
            return;
        }
        JSONObject jSONObject = this.mAdData.J;
        String jSONArray = (jSONObject == null || !jSONObject.has("general_monitor_urls")) ? null : this.mAdData.J.optJSONArray("general_monitor_urls").toString();
        JSONObject jSONObject2 = this.mRespData.f17108i;
        String jSONObject3 = jSONObject2 != null ? jSONObject2.toString() : null;
        Context context = this.mContext;
        com.shu.priory.g.a aVar2 = this.mAdData;
        com.shu.priory.request.d.a(context, aVar2.f17094u, this.mParams, this.mRespData.f17102c, aVar2.I, jSONArray, jSONObject3);
    }

    public void startDownload(String str) {
        String str2;
        com.shu.priory.download.c a10 = com.shu.priory.download.c.a(this.mContext.getApplicationContext());
        a10.a(this.mListener);
        com.shu.priory.download.d dVar = this.timerInterface;
        if (dVar != null) {
            a10.a(dVar);
        }
        a10.a(this.mParams.getBooleanParam(AdKeys.DOWNLOAD_ALERT));
        if (TextUtils.isEmpty(str)) {
            a10.a(this.mContext, this.mAdData, new Object[0]);
            str2 = "startNativeDownload";
        } else {
            a10.a(this.mContext, this.mAdData, str);
            str2 = "startNativeDownload with url";
        }
        h.a(SDKConstants.TAG, str2);
    }
}
