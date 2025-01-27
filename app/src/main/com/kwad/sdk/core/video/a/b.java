package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.media3.common.MimeTypes;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.k;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private boolean aFA;
    private final MediaPlayer aFu;
    private final a aFv;
    private String aFw;
    private MediaDataSource aFx;
    private final Object aFy;
    private boolean aFz;

    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        public a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i10);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i10, i11);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i10 != 3) {
                return bVar.notifyOnInfo(i10, i11);
            }
            if (bVar.aFA) {
                return false;
            }
            b.a(bVar, true);
            return bVar.notifyOnInfo(i10, i11);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.w(i10, i11);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aFy = obj;
        this.aFA = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aFu = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aFv = new a(this);
        HP();
        setLooping(false);
    }

    private void HN() {
        MediaDataSource mediaDataSource = this.aFx;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.aFx = null;
        }
    }

    private void HP() {
        this.aFu.setOnPreparedListener(this.aFv);
        this.aFu.setOnBufferingUpdateListener(this.aFv);
        this.aFu.setOnCompletionListener(this.aFv);
        this.aFu.setOnSeekCompleteListener(this.aFv);
        this.aFu.setOnVideoSizeChangedListener(this.aFv);
        this.aFu.setOnErrorListener(this.aFv);
        this.aFu.setOnInfoListener(this.aFv);
        this.aFu.setOnTimedTextListener(this.aFv);
    }

    private void HQ() {
        this.aFu.setOnPreparedListener(null);
        this.aFu.setOnBufferingUpdateListener(null);
        this.aFu.setOnCompletionListener(null);
        this.aFu.setOnSeekCompleteListener(null);
        this.aFu.setOnVideoSizeChangedListener(null);
        this.aFu.setOnErrorListener(null);
        this.aFu.setOnInfoListener(null);
        this.aFu.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean HO() {
        this.aFu.prepareAsync();
        HM();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aFu.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aFu.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aFw;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aFu.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aFu.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aFu.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aFu.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aFu.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aFu.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aFu.prepareAsync();
        HM();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.aFz = true;
            this.aFu.release();
            HN();
            resetListeners();
            HQ();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aFu.reset();
            this.aFA = false;
        } catch (IllegalStateException unused) {
        }
        HN();
        resetListeners();
        HP();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aFu.seekTo((int) j10, 3);
        } else {
            this.aFu.seekTo((int) j10);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i10) {
        this.aFu.setAudioStreamType(i10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
        this.aFu.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aFy) {
            try {
                if (!this.aFz) {
                    this.aFu.setDisplay(surfaceHolder);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z10) {
        this.aFu.setLooping(z10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z10) {
        this.aFu.setScreenOnWhilePlaying(z10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f10) {
        PlaybackParams playbackParams;
        if (Build.VERSION.SDK_INT >= 23) {
            playbackParams = this.aFu.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = t7.d.a();
            }
            playbackParams.setSpeed(f10);
            this.aFu.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aFu.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f10, float f11) {
        this.aFu.setVolume(f10, f11);
        com.kwad.sdk.core.video.a.a.h(f10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aFu.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aFu.stop();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z10) {
        bVar.aFA = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.aFu.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (bVar.isNoCache) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", MimeTypes.VIDEO_MP4);
            hashMap.put("Accept-Ranges", "bytes");
            hashMap.put("Status", "206");
            hashMap.put("Cache-control", "no-cache");
            setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
            return;
        }
        setDataSource(bVar.videoUrl);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.aFu.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        this.aFw = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(k.f18193y)) {
            this.aFu.setDataSource(parse.getPath());
        } else {
            this.aFu.setDataSource(str);
        }
    }
}
