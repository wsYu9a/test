package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADAdVideoLoadService;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class jad_bo implements JADAdVideoLoadService {
    public final ConcurrentHashMap<String, com.jd.ad.sdk.jad_ly.jad_bo> jad_an = new ConcurrentHashMap<>();

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void loadAdVideo(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull VideoLoadListener videoLoadListener) {
        com.jd.ad.sdk.jad_ly.jad_bo jad_boVar = this.jad_an.get(str);
        if (jad_boVar == null) {
            if (videoLoadListener != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_REGISTER_AD_SERVICE_ERROR;
                videoLoadListener.onLoadFailure(jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
                return;
            }
            return;
        }
        synchronized (jad_boVar) {
            try {
                try {
                } catch (Exception e10) {
                    Logger.d("load video Ad response body is exception:" + e10);
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 23 && i10 < 29 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_AD_SERVICE_PERMISSION_ERROR;
                        jad_boVar.jad_an(videoLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
                    }
                    com.jd.ad.sdk.jad_ep.jad_cp.jad_an.execute(new com.jd.ad.sdk.jad_ly.jad_an(jad_boVar, str2, videoLoadListener, context, str3));
                    return;
                }
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_URL_IS_NULL_ERROR;
                jad_boVar.jad_an(videoLoadListener, jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void registerAd(String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_ly.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void unregisterAd(@NonNull String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }
}
