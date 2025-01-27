package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_na.jad_bo;
import com.jd.ad.sdk.jad_na.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADDynamicRenderService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_er implements JADDynamicRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public DynamicRenderView createDynamicView(Context context, @NonNull String str, @NonNull JADSlot jADSlot, DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback) {
        String str2;
        try {
            str2 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                throw new Exception("dynamic render templateJSON is null");
            }
            int dip2px = (int) ScreenUtils.dip2px(context, jADSlot.getWidth());
            int dip2px2 = (int) ScreenUtils.dip2px(context, jADSlot.getHeight());
            ArrayList arrayList = new ArrayList(Arrays.asList("sdkSkipButton", "sdkSkipArea", "sdkLogo", "sdkStaticSkipButton"));
            ArrayList arrayList2 = new ArrayList(Arrays.asList("sdkLimitClickArea", "sdkSkipInformation", "sdkInteractiveShake", "sdkLimitSlideArea"));
            ArrayList arrayList3 = new ArrayList();
            if (jADSlot.isHideSkip()) {
                arrayList3.add("sdkStaticSkipButton");
                arrayList3.add("sdkSkipButton");
                arrayList3.add("sdkSkipArea");
            }
            if (!jADSlot.isHideSkip() && jADSlot.getSkipTime() <= 5) {
                arrayList3.add("sdkStaticSkipButton");
            }
            List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
            if (jADMaterialDataList == null || jADMaterialDataList.size() <= 0) {
                return null;
            }
            JADMaterialData jADMaterialData = JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0);
            if (jADMaterialData == null) {
                return null;
            }
            List<String> imageUrls = jADMaterialData.getImageUrls();
            if (imageUrls == null || imageUrls.size() <= 0) {
                return null;
            }
            String str3 = imageUrls.get(0);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            String str4 = jad_cp.jad_an.jad_an.jad_an.get(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            com.jd.ad.sdk.jad_na.jad_bo jad_boVar = jad_bo.jad_an.jad_an;
            com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar.jad_cp(str4);
            int i10 = jad_cp == null ? 0 : jad_cp.jad_jt;
            com.jd.ad.sdk.jad_yl.jad_fs jad_cp2 = jad_boVar.jad_cp(str4);
            int i11 = jad_cp2 == null ? 0 : jad_cp2.jad_hu;
            DynamicRenderView.jad_er jad_erVar = new DynamicRenderView.jad_er();
            jad_erVar.jad_bo = dip2px;
            jad_erVar.jad_cp = dip2px2;
            jad_erVar.jad_jw = str3;
            jad_erVar.jad_kx = i10;
            jad_erVar.jad_ly = i11;
            jad_erVar.jad_mz = jADSlot.getSkipTime();
            jad_erVar.jad_dq = arrayList;
            jad_erVar.jad_er = arrayList2;
            jad_erVar.jad_fs = arrayList3;
            jad_erVar.jad_an = str2;
            jad_erVar.jad_jt = iDynamicRenderCallback;
            jad_erVar.jad_hu = jADSlot.getEventInteractionType();
            jad_erVar.jad_iv = jADSlot.getModelClickAreaType();
            DynamicRenderView dynamicRenderView = new DynamicRenderView(context, jad_erVar);
            Exception loadImagesException = dynamicRenderView.getLoadImagesException();
            if (loadImagesException == null) {
                return dynamicRenderView;
            }
            throw loadImagesException;
        } catch (Throwable th3) {
            th = th3;
            int sen = jADSlot != null ? jADSlot.getSen() : 0;
            Exception exc = new Exception("dynamic render view init error", th);
            JSONObject jSONObject = new JSONObject();
            String message = exc.getMessage();
            int code = JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
            try {
                try {
                    for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                        String message2 = cause.getMessage();
                        if (TextUtils.isEmpty(message2) || !message2.startsWith("40")) {
                            message = message + "|" + message2;
                        } else {
                            String[] split = message2.split("-");
                            code = Integer.parseInt(split[0]);
                            message = message + "|" + split[1];
                        }
                    }
                    jSONObject.put("code", code);
                    jSONObject.put("msg", message);
                } catch (Exception unused) {
                    Logger.d("错误信息拼接异常");
                    jSONObject.put("code", code);
                    jSONObject.put("msg", message);
                    int optInt = jSONObject.optInt("code");
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt, jSONObject.optString("msg"), sen);
                    Logger.w(optInt + ": dynamic render view error：" + Log.getStackTraceString(exc), new Object[0]);
                    return null;
                }
                int optInt2 = jSONObject.optInt("code");
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt2, jSONObject.optString("msg"), sen);
                Logger.w(optInt2 + ": dynamic render view error：" + Log.getStackTraceString(exc), new Object[0]);
                return null;
            } catch (Throwable th4) {
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
                throw th4;
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public void registerAdViewClick(Context context, DynamicRenderView dynamicRenderView, IDynamicInteractionListener iDynamicInteractionListener) {
        dynamicRenderView.jad_an("sdkSkipArea", new jad_cp(this, "sdkSkipArea", iDynamicInteractionListener));
        int adAnimationType = dynamicRenderView.getAdAnimationType();
        String str = adAnimationType == 1 ? "sdkMaterialImage" : "sdkLimitClickArea";
        if (adAnimationType == 3) {
            str = "sdkLimitSlideArea";
        }
        if (adAnimationType == 2) {
            str = "sdkInteractiveShake";
        }
        jad_dq jad_dqVar = new jad_dq(this, str, str, adAnimationType, iDynamicInteractionListener);
        dynamicRenderView.jad_xk = str;
        dynamicRenderView.jad_an(str, jad_dqVar);
    }
}
