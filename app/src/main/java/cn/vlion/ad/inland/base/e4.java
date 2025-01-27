package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.network.VlionHttpNetCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* loaded from: classes.dex */
public final class e4 implements VlionHttpNetCallBack {

    /* renamed from: a */
    public final /* synthetic */ String f2763a;

    /* renamed from: b */
    public final /* synthetic */ HttpCallBack f2764b;

    public e4(String str, HttpCallBack httpCallBack) {
        this.f2763a = str;
        this.f2764b = httpCallBack;
    }

    @Override // cn.vlion.ad.inland.base.network.VlionHttpNetCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError, VlionADNetBodyParameter vlionADNetBodyParameter) {
        StringBuilder a10 = l1.a("VlionCustomNetWorkProxy onFailure: ");
        a10.append(vlionAdBaseError.getErrorMessage());
        LogVlion.e(a10.toString());
        HttpCallBack httpCallBack = this.f2764b;
        if (httpCallBack != null) {
            httpCallBack.onFail(vlionAdBaseError);
        }
        if (vlionADNetBodyParameter != null) {
            VlionADEventManager.uploadNetEvent(vlionADNetBodyParameter);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.VlionHttpNetCallBack
    public final void onSuccess(String str, VlionADNetBodyParameter vlionADNetBodyParameter) {
        LogVlion.e("VlionCustomNetWorkProxy onSuccess: ");
        try {
            VlionCustomParseAdData vlionCustomParseAdData = (VlionCustomParseAdData) new Gson().fromJson(str, VlionCustomParseAdData.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionCustomNetWorkProxy (null == vlionCustomParseAdData)=:");
            sb2.append(vlionCustomParseAdData == null);
            LogVlion.e(sb2.toString());
            LogVlion.e("VlionCustomNetWorkProxy 接口url=:" + this.f2763a);
            LogVlion.e("VlionCustomNetWorkProxy 接口返回数据=:" + str);
            if (vlionCustomParseAdData == null) {
                HttpCallBack httpCallBack = this.f2764b;
                if (httpCallBack != null) {
                    httpCallBack.onFail(VlionAdBaseError.SERVER_DATA_JSON_IS_NULL);
                }
                if (vlionADNetBodyParameter != null) {
                    vlionADNetBodyParameter.setStatus(VlionAdBaseError.SERVER_DATA_JSON_IS_NULL.getErrorCode());
                    VlionADEventManager.uploadNetEvent(vlionADNetBodyParameter);
                    return;
                }
                return;
            }
            int code = vlionCustomParseAdData.getCode();
            LogVlion.e("VlionCustomNetWorkProxy code=:" + code);
            if (code == 0) {
                HttpCallBack httpCallBack2 = this.f2764b;
                if (httpCallBack2 != null) {
                    httpCallBack2.onSuccess(vlionCustomParseAdData);
                }
                try {
                    if (vlionCustomParseAdData.isVideo()) {
                        if (!TextUtils.isEmpty(vlionCustomParseAdData.getVideoUrl())) {
                            if (!vlionCustomParseAdData.getVideoUrl().startsWith("http")) {
                            }
                        }
                        VlionSDkManager.getInstance().upLoadCatchException(new Throwable("VideoUrl Exception" + str));
                    }
                } catch (Throwable unused) {
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("VlionCustomNetWorkProxy (null != callBack)=:");
                sb3.append(this.f2764b != null);
                LogVlion.e(sb3.toString());
                HttpCallBack httpCallBack3 = this.f2764b;
                if (httpCallBack3 != null) {
                    httpCallBack3.onFail(new VlionAdBaseError(code, "不采买"));
                }
            }
            if (vlionADNetBodyParameter != null) {
                vlionADNetBodyParameter.setStatus(code);
                VlionADEventManager.uploadNetEvent(vlionADNetBodyParameter);
            }
        } catch (JsonSyntaxException e10) {
            VlionSDkManager.getInstance().upLoadCatchException(new Throwable(str + "--adx--" + e10.getMessage()));
            StringBuilder sb4 = new StringBuilder();
            sb4.append("VlionCustomNetWorkProxy JsonSyntaxException: ");
            sb4.append(e10);
            LogVlion.e(sb4.toString());
            HttpCallBack httpCallBack4 = this.f2764b;
            if (httpCallBack4 != null) {
                httpCallBack4.onFail(new VlionAdBaseError(10002, e10.getMessage()));
            }
            if (vlionADNetBodyParameter != null) {
                vlionADNetBodyParameter.setStatus(10002);
                VlionADEventManager.uploadNetEvent(vlionADNetBodyParameter);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
