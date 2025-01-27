package com.jd.ad.sdk.jad_s_an;

import android.util.Log;
import android.view.View;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplashVideoListener;

/* loaded from: classes2.dex */
public class jad_s_cp implements OnVideoRenderListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_cp(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderFailed(int i10, String str) {
        try {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            JADError jADError = JADError.RENDER_VIDEO_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_an.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new String[0])), this.jad_s_an.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, jADError.getCode(), jADError.getMessage(new String[0]));
        } catch (Exception e10) {
            Logger.d(Log.getStackTraceString(e10));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderSuccess(View view) {
        try {
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (view != null) {
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
                if (jad_s_anVar.jad_s_bo != null) {
                    jad_s_anVar.jad_s_iv = view;
                    jad_s_anVar.jad_s_an(view, 1);
                    return;
                }
            }
            JADEventService eventService = JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.jad_s_an;
            eventService.reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, code, message);
        } catch (Exception e10) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar3 = this.jad_s_an;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar3, jADError2.getCode(), jADError2.getMessage(e10.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void updateMaterialMetaPreload(boolean z10) {
        this.jad_s_an.jad_s_na = z10;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerError(int i10, int i11, int i12, int i13, String str) {
        JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerError(i10, str);
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        if (jad_s_anVar.jad_s_pc == null) {
            jad_s_anVar.jad_s_pc = new jad_s_jw(jad_s_anVar.jad_s_bo);
        }
        jad_s_anVar.jad_s_pc.reportVideoError(com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i13), i11, i12);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerStatusChanged(int i10, int i11) {
        JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerStatusChanged(i10);
        }
        if (i10 != 0) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            if (jad_s_anVar.jad_s_pc == null) {
                jad_s_anVar.jad_s_pc = new jad_s_jw(jad_s_anVar.jad_s_bo);
            }
            jad_s_jw jad_s_jwVar = jad_s_anVar.jad_s_pc;
            float jad_s_an = com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i11);
            jad_s_jwVar.getClass();
            switch (i10) {
                case 1:
                    jad_s_jwVar.reportVideoWillStart();
                    break;
                case 2:
                    jad_s_jwVar.reportVideoPreloadCompleted();
                    break;
                case 3:
                    jad_s_jwVar.jad_s_an(3, jad_s_an);
                    break;
                case 4:
                    jad_s_jwVar.jad_s_an(5, jad_s_an);
                    break;
                case 5:
                    jad_s_jwVar.jad_s_an(4, jad_s_an);
                    break;
                case 6:
                    jad_s_jwVar.jad_s_an(6, jad_s_an);
                    break;
            }
        }
    }
}
