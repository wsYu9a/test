package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;

/* loaded from: classes.dex */
class ConnectionState implements Bundleable {
    public final int libraryVersion;
    public final Player.Commands playerCommandsFromPlayer;
    public final Player.Commands playerCommandsFromSession;
    public final PlayerInfo playerInfo;

    @Nullable
    public final PendingIntent sessionActivity;
    public final IMediaSession sessionBinder;
    public final SessionCommands sessionCommands;
    public final int sessionInterfaceVersion;
    public final Bundle tokenExtras;
    private static final String FIELD_LIBRARY_VERSION = Util.intToStringMaxRadix(0);
    private static final String FIELD_SESSION_BINDER = Util.intToStringMaxRadix(1);
    private static final String FIELD_SESSION_ACTIVITY = Util.intToStringMaxRadix(2);
    private static final String FIELD_SESSION_COMMANDS = Util.intToStringMaxRadix(3);
    private static final String FIELD_PLAYER_COMMANDS_FROM_SESSION = Util.intToStringMaxRadix(4);
    private static final String FIELD_PLAYER_COMMANDS_FROM_PLAYER = Util.intToStringMaxRadix(5);
    private static final String FIELD_TOKEN_EXTRAS = Util.intToStringMaxRadix(6);
    private static final String FIELD_PLAYER_INFO = Util.intToStringMaxRadix(7);
    private static final String FIELD_SESSION_INTERFACE_VERSION = Util.intToStringMaxRadix(8);
    public static final Bundleable.Creator<ConnectionState> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.e
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            ConnectionState fromBundle;
            fromBundle = ConnectionState.fromBundle(bundle);
            return fromBundle;
        }
    };

    public ConnectionState(int i10, int i11, IMediaSession iMediaSession, @Nullable PendingIntent pendingIntent, SessionCommands sessionCommands, Player.Commands commands, Player.Commands commands2, Bundle bundle, PlayerInfo playerInfo) {
        this.libraryVersion = i10;
        this.sessionInterfaceVersion = i11;
        this.sessionBinder = iMediaSession;
        this.sessionCommands = sessionCommands;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands2;
        this.sessionActivity = pendingIntent;
        this.tokenExtras = bundle;
        this.playerInfo = playerInfo;
    }

    public static ConnectionState fromBundle(Bundle bundle) {
        int i10 = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i11 = bundle.getInt(FIELD_SESSION_INTERFACE_VERSION, 0);
        IBinder iBinder = (IBinder) Assertions.checkNotNull(BundleCompat.getBinder(bundle, FIELD_SESSION_BINDER));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(FIELD_SESSION_ACTIVITY);
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMANDS);
        SessionCommands fromBundle = bundle2 == null ? SessionCommands.EMPTY : SessionCommands.CREATOR.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER);
        Player.Commands fromBundle2 = bundle3 == null ? Player.Commands.EMPTY : Player.Commands.CREATOR.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION);
        Player.Commands fromBundle3 = bundle4 == null ? Player.Commands.EMPTY : Player.Commands.CREATOR.fromBundle(bundle4);
        Bundle bundle5 = bundle.getBundle(FIELD_TOKEN_EXTRAS);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYER_INFO);
        return new ConnectionState(i10, i11, IMediaSession.Stub.asInterface(iBinder), pendingIntent, fromBundle, fromBundle3, fromBundle2, bundle5 == null ? Bundle.EMPTY : bundle5, bundle6 == null ? PlayerInfo.DEFAULT : PlayerInfo.CREATOR.fromBundle(bundle6));
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        BundleCompat.putBinder(bundle, FIELD_SESSION_BINDER, this.sessionBinder.asBinder());
        bundle.putParcelable(FIELD_SESSION_ACTIVITY, this.sessionActivity);
        bundle.putBundle(FIELD_SESSION_COMMANDS, this.sessionCommands.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION, this.playerCommandsFromSession.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER, this.playerCommandsFromPlayer.toBundle());
        bundle.putBundle(FIELD_TOKEN_EXTRAS, this.tokenExtras);
        bundle.putBundle(FIELD_PLAYER_INFO, this.playerInfo.toBundle(MediaUtils.intersect(this.playerCommandsFromSession, this.playerCommandsFromPlayer), false, false));
        bundle.putInt(FIELD_SESSION_INTERFACE_VERSION, this.sessionInterfaceVersion);
        return bundle;
    }
}
