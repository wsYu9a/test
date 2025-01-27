package com.jd.ad.sdk.bl.video;

import android.view.View;
import com.jd.ad.sdk.bl.video.VideoSkipView;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;

/* loaded from: classes2.dex */
public class jad_dq implements View.OnClickListener {
    public final /* synthetic */ VideoSkipView jad_an;

    public jad_dq(VideoSkipView videoSkipView) {
        this.jad_an = videoSkipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoSkipView.jad_bo jad_boVar = this.jad_an.jad_bo;
        if (jad_boVar != null) {
            jad_bo jad_boVar2 = (jad_bo) jad_boVar;
            VideoInteractionListener videoInteractionListener = jad_boVar2.jad_an.jad_qd;
            if (videoInteractionListener != null) {
                videoInteractionListener.onAdSkip(view);
            }
            VideoSkipView videoSkipView = jad_boVar2.jad_an.jad_it;
            if (videoSkipView != null) {
                videoSkipView.removeCallbacks(null);
            }
        }
    }
}
