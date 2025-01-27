package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: classes2.dex */
public interface c {

    public interface a {
        void ax(int i2);
    }

    public interface b {
        void nU();
    }

    /* renamed from: com.kwad.sdk.core.video.kwai.c$c */
    public interface InterfaceC0220c {
        boolean j(int i2, int i3);
    }

    public interface d {
        boolean k(int i2, int i3);
    }

    public interface e {
        void a(c cVar);
    }

    public interface f {
        void nV();
    }

    public interface g {
        void a(TimedText timedText);
    }

    public interface h {
        void i(int i2, int i3);
    }

    void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar);

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0220c interfaceC0220c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void b(e eVar);

    void c(d dVar);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j2);

    void setAudioStreamType(int i2);

    void setDataSource(Context context, Uri uri);

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();
}
