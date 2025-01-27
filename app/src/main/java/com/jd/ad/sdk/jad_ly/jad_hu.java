package com.jd.ad.sdk.jad_ly;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* loaded from: classes2.dex */
public class jad_hu extends ShakeListener {
    public final /* synthetic */ VideoRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_hu(VideoRenderView videoRenderView, Context context, float f10, float f11, float f12) {
        super(context, f10, f11, f12);
        this.jad_na = videoRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        VideoRenderView videoRenderView = this.jad_na;
        if (VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_tg)) {
            VideoRenderView videoRenderView2 = this.jad_na;
            if (videoRenderView2.jad_qd != null) {
                float f10 = videoRenderView2.jad_jw;
                float f11 = videoRenderView2.jad_ly;
                float f12 = videoRenderView2.jad_mz;
                CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
                int ordinal = adTriggerSourceType.ordinal();
                if (f12 > 0.0f) {
                    if (f10 > 0.0f && f11 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                    } else if (f10 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                    } else if (f11 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                    }
                } else if (f10 > 0.0f && f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
                } else if (f10 > 0.0f) {
                    ordinal = adTriggerSourceType.ordinal();
                } else if (f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
                }
                VideoRenderView videoRenderView3 = this.jad_na;
                videoRenderView3.jad_qd.onAdClicked(videoRenderView3.jad_pc, ordinal);
            }
        }
    }
}
