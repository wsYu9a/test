package androidx.media3.session;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@UnstableApi
/* loaded from: classes.dex */
public class DefaultMediaNotificationProvider implements MediaNotification.Provider {
    public static final String COMMAND_KEY_COMPACT_VIEW_INDEX = "androidx.media3.session.command.COMPACT_VIEW_INDEX";
    public static final String DEFAULT_CHANNEL_ID = "default_channel_id";

    @StringRes
    public static final int DEFAULT_CHANNEL_NAME_RESOURCE_ID = R.string.default_notification_channel_name;
    public static final int DEFAULT_NOTIFICATION_ID = 1001;
    private static final String TAG = "NotificationProvider";
    private final String channelId;

    @StringRes
    private final int channelNameResourceId;
    private final Context context;
    private final NotificationIdProvider notificationIdProvider;
    private final NotificationManager notificationManager;
    private OnBitmapLoadedFutureCallback pendingOnBitmapLoadedFutureCallback;

    @DrawableRes
    private int smallIconResourceId;

    @RequiresApi(26)
    public static class Api26 {
        private Api26() {
        }

        @DoNotInline
        public static void createNotificationChannel(NotificationManager notificationManager, String str, String str2) {
            NotificationChannel a10 = q.z.a(str, str2, 2);
            if (Util.SDK_INT <= 27) {
                a10.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(a10);
        }
    }

    public static final class Builder {
        private boolean built;
        private final Context context;
        private NotificationIdProvider notificationIdProvider = new NotificationIdProvider() { // from class: p0.d
            @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
            public final int getNotificationId(MediaSession mediaSession) {
                int lambda$new$0;
                lambda$new$0 = DefaultMediaNotificationProvider.Builder.lambda$new$0(mediaSession);
                return lambda$new$0;
            }
        };
        private String channelId = DefaultMediaNotificationProvider.DEFAULT_CHANNEL_ID;

        @StringRes
        private int channelNameResourceId = DefaultMediaNotificationProvider.DEFAULT_CHANNEL_NAME_RESOURCE_ID;

        public Builder(Context context) {
            this.context = context;
        }

        public static /* synthetic */ int lambda$new$0(MediaSession mediaSession) {
            return 1001;
        }

        public static /* synthetic */ int lambda$setNotificationId$1(int i10, MediaSession mediaSession) {
            return i10;
        }

        public DefaultMediaNotificationProvider build() {
            Assertions.checkState(!this.built);
            DefaultMediaNotificationProvider defaultMediaNotificationProvider = new DefaultMediaNotificationProvider(this);
            this.built = true;
            return defaultMediaNotificationProvider;
        }

        @CanIgnoreReturnValue
        public Builder setChannelId(String str) {
            this.channelId = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setChannelName(@StringRes int i10) {
            this.channelNameResourceId = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNotificationId(int i10) {
            this.notificationIdProvider = new NotificationIdProvider() { // from class: p0.e

                /* renamed from: a */
                public final /* synthetic */ int f29663a;

                public /* synthetic */ e(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
                public final int getNotificationId(MediaSession mediaSession) {
                    int lambda$setNotificationId$1;
                    lambda$setNotificationId$1 = DefaultMediaNotificationProvider.Builder.lambda$setNotificationId$1(i10, mediaSession);
                    return lambda$setNotificationId$1;
                }
            };
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNotificationIdProvider(NotificationIdProvider notificationIdProvider) {
            this.notificationIdProvider = notificationIdProvider;
            return this;
        }
    }

    public interface NotificationIdProvider {
        int getNotificationId(MediaSession mediaSession);
    }

    public static class OnBitmapLoadedFutureCallback implements p5.x<Bitmap> {
        private final NotificationCompat.Builder builder;
        private boolean discarded;
        private final int notificationId;
        private final MediaNotification.Provider.Callback onNotificationChangedCallback;

        public OnBitmapLoadedFutureCallback(int i10, NotificationCompat.Builder builder, MediaNotification.Provider.Callback callback) {
            this.notificationId = i10;
            this.builder = builder;
            this.onNotificationChangedCallback = callback;
        }

        public void discardIfPending() {
            this.discarded = true;
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
            if (this.discarded) {
                return;
            }
            Log.w(DefaultMediaNotificationProvider.TAG, DefaultMediaNotificationProvider.getBitmapLoadErrorMessage(th2));
        }

        @Override // p5.x
        public void onSuccess(Bitmap bitmap) {
            if (this.discarded) {
                return;
            }
            this.builder.setLargeIcon(bitmap);
            this.onNotificationChangedCallback.onNotificationChanged(new MediaNotification(this.notificationId, this.builder.build()));
        }
    }

    public /* synthetic */ DefaultMediaNotificationProvider(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void ensureNotificationChannel() {
        NotificationChannel notificationChannel;
        if (Util.SDK_INT >= 26) {
            notificationChannel = this.notificationManager.getNotificationChannel(this.channelId);
            if (notificationChannel != null) {
                return;
            }
            Api26.createNotificationChannel(this.notificationManager, this.channelId, this.context.getString(this.channelNameResourceId));
        }
    }

    public static String getBitmapLoadErrorMessage(Throwable th2) {
        return "Failed to load bitmap: " + th2.getMessage();
    }

    private static long getPlaybackStartTimeEpochMs(Player player) {
        return (Util.SDK_INT < 21 || !player.isPlaying() || player.isPlayingAd() || player.isCurrentMediaItemDynamic() || player.getPlaybackParameters().speed != 1.0f) ? C.TIME_UNSET : System.currentTimeMillis() - player.getContentPosition();
    }

    public static /* synthetic */ int lambda$new$0(MediaSession mediaSession) {
        return 1001;
    }

    public int[] addNotificationActions(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, NotificationCompat.Builder builder, MediaNotification.ActionFactory actionFactory) {
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        Arrays.fill(iArr, -1);
        Arrays.fill(iArr2, -1);
        int i10 = 0;
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            CommandButton commandButton = immutableList.get(i11);
            if (commandButton.sessionCommand != null) {
                builder.addAction(actionFactory.createCustomActionFromCustomCommandButton(mediaSession, commandButton));
            } else {
                Assertions.checkState(commandButton.playerCommand != -1);
                builder.addAction(actionFactory.createMediaAction(mediaSession, IconCompat.createWithResource(this.context, commandButton.iconResId), commandButton.displayName, commandButton.playerCommand));
            }
            if (i10 != 3) {
                int i12 = commandButton.extras.getInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
                if (i12 < 0 || i12 >= 3) {
                    int i13 = commandButton.playerCommand;
                    if (i13 == 7 || i13 == 6) {
                        iArr2[0] = i11;
                    } else if (i13 == 1) {
                        iArr2[1] = i11;
                    } else if (i13 == 9 || i13 == 8) {
                        iArr2[2] = i11;
                    }
                } else {
                    i10++;
                    iArr[i12] = i11;
                }
            }
        }
        if (i10 == 0) {
            int i14 = 0;
            for (int i15 = 0; i15 < 3; i15++) {
                int i16 = iArr2[i15];
                if (i16 != -1) {
                    iArr[i14] = i16;
                    i14++;
                }
            }
        }
        for (int i17 = 0; i17 < 3; i17++) {
            if (iArr[i17] == -1) {
                return Arrays.copyOf(iArr, i17);
            }
        }
        return iArr;
    }

    @Override // androidx.media3.session.MediaNotification.Provider
    public final MediaNotification createNotification(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, MediaNotification.ActionFactory actionFactory, MediaNotification.Provider.Callback callback) {
        ImmutableList<CommandButton> immutableList2;
        boolean z10;
        ensureNotificationChannel();
        Player player = mediaSession.getPlayer();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context, this.channelId);
        int notificationId = this.notificationIdProvider.getNotificationId(mediaSession);
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
        Player.Commands availableCommands = player.getAvailableCommands();
        if (!player.getPlayWhenReady() || player.getPlaybackState() == 4) {
            immutableList2 = immutableList;
            z10 = false;
        } else {
            immutableList2 = immutableList;
            z10 = true;
        }
        mediaStyle.setShowActionsInCompactView(addNotificationActions(mediaSession, getMediaButtons(mediaSession, availableCommands, immutableList2, z10), builder, actionFactory));
        if (player.isCommandAvailable(18)) {
            MediaMetadata mediaMetadata = player.getMediaMetadata();
            builder.setContentTitle(getNotificationContentTitle(mediaMetadata)).setContentText(getNotificationContentText(mediaMetadata));
            p5.c0<Bitmap> loadBitmapFromMetadata = mediaSession.getBitmapLoader().loadBitmapFromMetadata(mediaMetadata);
            if (loadBitmapFromMetadata != null) {
                OnBitmapLoadedFutureCallback onBitmapLoadedFutureCallback = this.pendingOnBitmapLoadedFutureCallback;
                if (onBitmapLoadedFutureCallback != null) {
                    onBitmapLoadedFutureCallback.discardIfPending();
                }
                if (loadBitmapFromMetadata.isDone()) {
                    try {
                        builder.setLargeIcon((Bitmap) com.google.common.util.concurrent.l.h(loadBitmapFromMetadata));
                    } catch (ExecutionException e10) {
                        Log.w(TAG, getBitmapLoadErrorMessage(e10));
                    }
                } else {
                    OnBitmapLoadedFutureCallback onBitmapLoadedFutureCallback2 = new OnBitmapLoadedFutureCallback(notificationId, builder, callback);
                    this.pendingOnBitmapLoadedFutureCallback = onBitmapLoadedFutureCallback2;
                    Handler applicationHandler = mediaSession.getImpl().getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    com.google.common.util.concurrent.l.a(loadBitmapFromMetadata, onBitmapLoadedFutureCallback2, new g0.a(applicationHandler));
                }
            }
        }
        if (player.isCommandAvailable(3) || Util.SDK_INT < 21) {
            mediaStyle.setCancelButtonIntent(actionFactory.createMediaActionPendingIntent(mediaSession, 3L));
        }
        long playbackStartTimeEpochMs = getPlaybackStartTimeEpochMs(player);
        boolean z11 = playbackStartTimeEpochMs != C.TIME_UNSET;
        builder.setWhen(playbackStartTimeEpochMs).setShowWhen(z11).setUsesChronometer(z11);
        return new MediaNotification(notificationId, builder.setContentIntent(mediaSession.getSessionActivity()).setDeleteIntent(actionFactory.createMediaActionPendingIntent(mediaSession, 3L)).setOnlyAlertOnce(true).setSmallIcon(this.smallIconResourceId).setStyle(mediaStyle).setVisibility(1).setOngoing(false).build());
    }

    public ImmutableList<CommandButton> getMediaButtons(MediaSession mediaSession, Player.Commands commands, ImmutableList<CommandButton> immutableList, boolean z10) {
        ImmutableList.a aVar = new ImmutableList.a();
        if (commands.containsAny(7, 6)) {
            Bundle bundle = new Bundle();
            bundle.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            aVar.a(new CommandButton.Builder().setPlayerCommand(6).setIconResId(R.drawable.media3_notification_seek_to_previous).setDisplayName(this.context.getString(R.string.media3_controls_seek_to_previous_description)).setExtras(bundle).build());
        }
        if (commands.contains(1)) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            aVar.a(new CommandButton.Builder().setPlayerCommand(1).setIconResId(z10 ? R.drawable.media3_notification_pause : R.drawable.media3_notification_play).setExtras(bundle2).setDisplayName(z10 ? this.context.getString(R.string.media3_controls_pause_description) : this.context.getString(R.string.media3_controls_play_description)).build());
        }
        if (commands.containsAny(9, 8)) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            aVar.a(new CommandButton.Builder().setPlayerCommand(8).setIconResId(R.drawable.media3_notification_seek_to_next).setExtras(bundle3).setDisplayName(this.context.getString(R.string.media3_controls_seek_to_next_description)).build());
        }
        for (int i10 = 0; i10 < immutableList.size(); i10++) {
            CommandButton commandButton = immutableList.get(i10);
            SessionCommand sessionCommand = commandButton.sessionCommand;
            if (sessionCommand != null && sessionCommand.commandCode == 0) {
                aVar.a(commandButton);
            }
        }
        return aVar.e();
    }

    @Nullable
    public CharSequence getNotificationContentText(MediaMetadata mediaMetadata) {
        return mediaMetadata.artist;
    }

    @Nullable
    public CharSequence getNotificationContentTitle(MediaMetadata mediaMetadata) {
        return mediaMetadata.title;
    }

    @Override // androidx.media3.session.MediaNotification.Provider
    public final boolean handleCustomCommand(MediaSession mediaSession, String str, Bundle bundle) {
        return false;
    }

    public final void setSmallIcon(@DrawableRes int i10) {
        this.smallIconResourceId = i10;
    }

    public DefaultMediaNotificationProvider(Context context) {
        this(context, new NotificationIdProvider() { // from class: p0.c
            @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
            public final int getNotificationId(MediaSession mediaSession) {
                int lambda$new$0;
                lambda$new$0 = DefaultMediaNotificationProvider.lambda$new$0(mediaSession);
                return lambda$new$0;
            }
        }, DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME_RESOURCE_ID);
    }

    public DefaultMediaNotificationProvider(Context context, NotificationIdProvider notificationIdProvider, String str, int i10) {
        this.context = context;
        this.notificationIdProvider = notificationIdProvider;
        this.channelId = str;
        this.channelNameResourceId = i10;
        this.notificationManager = (NotificationManager) Assertions.checkStateNotNull((NotificationManager) context.getSystemService("notification"));
        this.smallIconResourceId = R.drawable.media3_notification_small_icon;
    }

    private DefaultMediaNotificationProvider(Builder builder) {
        this(builder.context, builder.notificationIdProvider, builder.channelId, builder.channelNameResourceId);
    }
}
