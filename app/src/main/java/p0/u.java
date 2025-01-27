package p0;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.session.LibraryResult;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionCommands;

/* loaded from: classes.dex */
public final /* synthetic */ class u {
    public static MediaSession.ConnectionResult a(MediaLibraryService.MediaLibrarySession.Callback callback, MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo) {
        return MediaSession.ConnectionResult.accept(new SessionCommands.Builder().addAllLibraryCommands().addAllSessionCommands().build(), new Player.Commands.Builder().addAllCommands().build());
    }

    public static p5.c0 b(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 c(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 d(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 e(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 f(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 g(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }

    public static p5.c0 h(MediaLibraryService.MediaLibrarySession.Callback callback, MediaLibraryService.MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str) {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6));
    }
}
