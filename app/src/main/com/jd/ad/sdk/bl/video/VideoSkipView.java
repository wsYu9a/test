package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.R;
import java.util.Locale;

/* loaded from: classes2.dex */
public class VideoSkipView extends FrameLayout {
    public int jad_an;
    public jad_bo jad_bo;
    public TextView jad_cp;
    public boolean jad_dq;
    public final Runnable jad_er;

    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoSkipView videoSkipView = VideoSkipView.this;
            TextView textView = videoSkipView.jad_cp;
            if (textView == null) {
                return;
            }
            if (videoSkipView.jad_an > 5) {
                textView.setText("跳过");
            } else {
                textView.setText(String.format(Locale.getDefault(), "跳过 %d", Integer.valueOf(VideoSkipView.this.jad_an)));
            }
            VideoSkipView videoSkipView2 = VideoSkipView.this;
            if (videoSkipView2.jad_dq) {
                jad_bo jad_boVar = videoSkipView2.jad_bo;
                if (jad_boVar != null) {
                    int i10 = videoSkipView2.jad_an;
                    VideoInteractionListener videoInteractionListener = ((com.jd.ad.sdk.bl.video.jad_bo) jad_boVar).jad_an.jad_qd;
                    if (videoInteractionListener != null) {
                        videoInteractionListener.onAdCountdown(i10);
                    }
                }
                VideoSkipView.this.jad_an--;
            }
            VideoSkipView videoSkipView3 = VideoSkipView.this;
            if (videoSkipView3.jad_an >= 0) {
                videoSkipView3.postDelayed(videoSkipView3.jad_er, 1000L);
                return;
            }
            jad_bo jad_boVar2 = videoSkipView3.jad_bo;
            if (jad_boVar2 != null) {
                com.jd.ad.sdk.bl.video.jad_bo jad_boVar3 = (com.jd.ad.sdk.bl.video.jad_bo) jad_boVar2;
                VideoRenderView videoRenderView = jad_boVar3.jad_an;
                VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_an);
                VideoInteractionListener videoInteractionListener2 = jad_boVar3.jad_an.jad_qd;
                if (videoInteractionListener2 != null) {
                    videoInteractionListener2.onAdTimeOver();
                }
                VideoSkipView videoSkipView4 = jad_boVar3.jad_an.jad_it;
                if (videoSkipView4 != null) {
                    videoSkipView4.removeCallbacks(null);
                }
            }
        }
    }

    public interface jad_bo {
    }

    public VideoSkipView(Context context) {
        super(context);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    public final void jad_an(Context context) {
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.jad_video_skip_btn_layout, (ViewGroup) null);
            this.jad_cp = (TextView) inflate.findViewById(R.id.jad_tv_video_count);
            addView(inflate);
        } catch (Exception e10) {
            Logger.w("Exception while splash video skip init: " + e10, new Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.jad_dq = z10;
    }

    public void setTotalCount(int i10) {
        this.jad_an = i10;
        TextView textView = this.jad_cp;
        if (textView == null) {
            return;
        }
        if (i10 > 5) {
            textView.setText("跳过");
        } else {
            textView.setText(String.format(Locale.getDefault(), "跳过 %d", Integer.valueOf(this.jad_an)));
        }
    }

    public VideoSkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    public VideoSkipView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    @RequiresApi(api = 21)
    public VideoSkipView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }
}
