package com.sigmob.sdk.videoAd;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.VideoView;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class b extends VideoView {

    /* renamed from: d */
    public static final int f20411d = 1;

    /* renamed from: e */
    public static final int f20412e = Integer.MIN_VALUE;

    /* renamed from: a */
    public final MediaMetadataRetriever f20413a;

    /* renamed from: b */
    public int f20414b;

    /* renamed from: c */
    public int f20415c;

    public b(Context context) {
        super(context);
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        this.f20413a = new MediaMetadataRetriever();
    }

    public final void a() {
        try {
            setOnClickListener(null);
            setOnCompletionListener(null);
            setOnErrorListener(null);
            setOnPreparedListener(null);
            Field declaredField = View.class.getDeclaredField("mContext");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public void b() {
        SigmobLog.d("BaseVideoView onDestroy() called");
        suspend();
        stopPlayback();
        com.sigmob.sdk.base.utils.e.e(this);
        a();
        super.destroyDrawingCache();
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        int defaultSize = View.getDefaultSize(0, i10);
        int defaultSize2 = View.getDefaultSize(0, i11);
        int i12 = this.f20415c;
        int i13 = this.f20414b;
        if (defaultSize2 > defaultSize) {
            if (i12 <= i13) {
                defaultSize2 = (int) (defaultSize * (i12 / i13));
            }
        } else if (i12 > i13) {
            defaultSize = (int) (defaultSize2 * (i13 / i12));
        }
        int i14 = this.f20415c;
        if (i14 != this.f20414b) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else if (i14 == -1) {
            setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        } else {
            super.onMeasure(i10, i11);
        }
    }

    public void setVolume(float f10) {
        try {
            Field declaredField = VideoView.class.getDeclaredField("mMediaPlayer");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                ((MediaPlayer) declaredField.get(this)).setVolume(f10, f10);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public final void a(MediaPlayer mediaPlayer, Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("android.media.MediaTimeProvider");
                Class<?> cls2 = Class.forName("android.media.SubtitleController");
                Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
                Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(context, null, null);
                Field declaredField = cls2.getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
            } catch (Throwable th2) {
                SigmobLog.e("setSubtitleController error: ", th2);
            }
        }
    }

    public void a(int i10, int i11) {
        this.f20414b = i10;
        this.f20415c = i11;
    }
}
