package p0;

import android.os.Bundle;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.SessionResult;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class y {
    public static p5.c0 a(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((MediaItem) it.next()).localConfiguration == null) {
                return com.google.common.util.concurrent.l.l(new UnsupportedOperationException());
            }
        }
        return com.google.common.util.concurrent.l.m(list);
    }

    public static MediaSession.ConnectionResult b(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo) {
        return MediaSession.ConnectionResult.accept(new SessionCommands.Builder().addAllSessionCommands().build(), new Player.Commands.Builder().addAllCommands().build());
    }

    public static p5.c0 c(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return com.google.common.util.concurrent.l.m(new SessionResult(-6));
    }

    @UnstableApi
    public static p5.c0 e(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo) {
        return com.google.common.util.concurrent.l.l(new UnsupportedOperationException());
    }

    @Deprecated
    public static int f(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, int i10) {
        return 0;
    }

    @UnstableApi
    public static p5.c0 h(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, List list, int i10, long j10) {
        return Util.transformFutureAsync(callback.onAddMediaItems(mediaSession, controllerInfo, list), new p5.f() { // from class: p0.x

            /* renamed from: a */
            public final /* synthetic */ int f29676a;

            /* renamed from: b */
            public final /* synthetic */ long f29677b;

            public /* synthetic */ x(int i102, long j102) {
                i10 = i102;
                j10 = j102;
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 m10;
                m10 = com.google.common.util.concurrent.l.m(new MediaSession.MediaItemsWithStartPosition((List) obj, i10, j10));
                return m10;
            }
        });
    }

    public static p5.c0 i(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, Rating rating) {
        return com.google.common.util.concurrent.l.m(new SessionResult(-6));
    }

    public static p5.c0 j(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo, String str, Rating rating) {
        return com.google.common.util.concurrent.l.m(new SessionResult(-6));
    }

    public static void d(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo) {
    }

    public static void g(MediaSession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo) {
    }
}
