package com.kwad.sdk.core.video.kwai;

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
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b extends com.kwad.sdk.core.video.kwai.a {
    private final MediaPlayer amQ;
    private final a amR;
    private String amS;
    private MediaDataSource amT;
    private final Object amU;
    private boolean amV;

    static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i2);
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
        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnInfo(i2, i3);
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
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.r(i2, i3);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.amU = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.amQ = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.amR = new a(this);
        yi();
        setLooping(false);
    }

    private void yh() {
        MediaDataSource mediaDataSource = this.amT;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.amT = null;
        }
    }

    private void yi() {
        this.amQ.setOnPreparedListener(this.amR);
        this.amQ.setOnBufferingUpdateListener(this.amR);
        this.amQ.setOnCompletionListener(this.amR);
        this.amQ.setOnSeekCompleteListener(this.amR);
        this.amQ.setOnVideoSizeChangedListener(this.amR);
        this.amQ.setOnErrorListener(this.amR);
        this.amQ.setOnInfoListener(this.amR);
        this.amQ.setOnTimedTextListener(this.amR);
    }

    private void yj() {
        this.amQ.setOnPreparedListener(null);
        this.amQ.setOnBufferingUpdateListener(null);
        this.amQ.setOnCompletionListener(null);
        this.amQ.setOnSeekCompleteListener(null);
        this.amQ.setOnVideoSizeChangedListener(null);
        this.amQ.setOnErrorListener(null);
        this.amQ.setOnInfoListener(null);
        this.amQ.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "video/mp4");
        hashMap.put("Accept-Ranges", "bytes");
        hashMap.put("Status", "206");
        hashMap.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.amQ.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.amQ.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getDataSource() {
        return this.amS;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getDuration() {
        try {
            return this.amQ.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.amQ.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.amQ.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.amQ.isLooping();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.amQ.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.amQ.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        this.amQ.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        try {
            this.amV = true;
            this.amQ.release();
            yh();
            resetListeners();
            yj();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        try {
            this.amQ.reset();
        } catch (IllegalStateException unused) {
        }
        yh();
        resetListeners();
        yi();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.amQ.seekTo((int) j2, 3);
        } else {
            this.amQ.seekTo((int) j2);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i2) {
        this.amQ.setAudioStreamType(i2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) {
        this.amQ.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.amQ.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.amQ.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) {
        this.amS = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.amQ.setDataSource(str);
        } else {
            this.amQ.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.amU) {
            if (!this.amV) {
                this.amQ.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z) {
        this.amQ.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.amQ.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f2) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.amQ.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f2);
            this.amQ.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.amQ.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f2, float f3) {
        this.amQ.setVolume(f2, f3);
        com.kwad.sdk.core.video.kwai.a.f(f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        this.amQ.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.amQ.stop();
    }
}
