package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADVideoRenderService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_kx implements JADVideoRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public VideoRenderView createVideoRendView(Context context, @NonNull String str, @NonNull JADSlot jADSlot, long j10, OnVideoRenderListener onVideoRenderListener, VideoLoadListener videoLoadListener) {
        try {
            int dip2px = (int) ScreenUtils.dip2px(context, jADSlot.getWidth());
            int dip2px2 = (int) ScreenUtils.dip2px(context, jADSlot.getHeight());
            List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
            if (jADMaterialDataList != null && jADMaterialDataList.size() > 0) {
                String str2 = JADYunSdk.getAppId() + jADSlot.getSlotID();
                JADMaterialData jADMaterialData = JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0);
                if (jADMaterialData == null) {
                    return null;
                }
                String videoUrl = jADMaterialData.getVideoUrl();
                int muted = jADMaterialData.getMuted();
                List<String> imageUrls = jADMaterialData.getImageUrls();
                String str3 = (imageUrls == null || imageUrls.size() <= 0) ? "" : imageUrls.get(0);
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(videoUrl)) {
                    return null;
                }
                VideoRenderView.jad_iv jad_ivVar = new VideoRenderView.jad_iv();
                jad_ivVar.jad_an = dip2px;
                jad_ivVar.jad_bo = dip2px2;
                jad_ivVar.jad_ly = str;
                jad_ivVar.jad_fs = str3;
                jad_ivVar.jad_jw = videoUrl;
                jad_ivVar.jad_jt = jADSlot.getSkipTime();
                jad_ivVar.jad_cp = onVideoRenderListener;
                jad_ivVar.jad_dq = jADSlot.getEventInteractionType();
                jad_ivVar.jad_er = jADSlot.getModelClickAreaType();
                jad_ivVar.jad_hu = jADSlot.isHideSkip();
                jad_ivVar.jad_kx = str2;
                jad_ivVar.jad_ob = muted;
                jad_ivVar.jad_pc = jADMaterialData.getVideoDuration();
                jad_ivVar.jad_na = j10;
                jad_ivVar.jad_iv = jADSlot.isHidePreloadLabel();
                jad_ivVar.jad_mz = videoLoadListener;
                VideoRenderView videoRenderView = new VideoRenderView(context, jad_ivVar);
                Exception videoRenderException = videoRenderView.getVideoRenderException();
                if (videoRenderException == null) {
                    return videoRenderView;
                }
                throw videoRenderException;
            }
            return null;
        } catch (Throwable th2) {
            int sen = jADSlot != null ? jADSlot.getSen() : 0;
            Exception exc = new Exception("video render view init error", th2);
            JSONObject jSONObject = new JSONObject();
            String message = exc.getMessage();
            int i10 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_OTHER_ERROR.jad_an;
            try {
                try {
                    for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                        String message2 = cause.getMessage();
                        if (TextUtils.isEmpty(message2) || !message2.startsWith("40")) {
                            message = message + "|" + message2;
                        } else {
                            String[] split = message2.split("-");
                            i10 = Integer.parseInt(split[0]);
                            message = message + "|" + split[1];
                        }
                    }
                    jSONObject.put("code", i10);
                    jSONObject.put("msg", message);
                } catch (Exception unused) {
                    Logger.d("错误信息拼接异常");
                    jSONObject.put("code", i10);
                    jSONObject.put("msg", message);
                }
                int optInt = jSONObject.optInt("code");
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt, jSONObject.optString("msg"), sen);
                Logger.w(optInt + ": video render view error：" + Log.getStackTraceString(exc), new Object[0]);
                return null;
            } catch (Throwable th3) {
                jSONObject.put("code", i10);
                jSONObject.put("msg", message);
                throw th3;
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public void registerAdViewClick(Context context, VideoRenderView videoRenderView, VideoInteractionListener videoInteractionListener) {
        videoRenderView.setVideoInteractionListener(videoInteractionListener);
    }
}
