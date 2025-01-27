package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.media.VolumeProviderCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ForwardingPlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.PlayerWrapper;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes.dex */
class PlayerWrapper extends ForwardingPlayer {
    private static final int STATUS_CODE_SUCCESS_COMPAT = -1;
    private ImmutableList<CommandButton> customLayout;

    @Nullable
    private Bundle legacyErrorExtras;

    @Nullable
    private String legacyErrorMessage;
    private int legacyStatusCode;

    /* renamed from: androidx.media3.session.PlayerWrapper$1 */
    public class AnonymousClass1 extends VolumeProviderCompat {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ int val$legacyVolumeFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i10, int i11, int i12, String str, Handler handler, int i13) {
            super(i10, i11, i12, str);
            this.val$handler = handler;
            this.val$legacyVolumeFlag = i13;
        }

        public /* synthetic */ void lambda$onAdjustVolume$1(int i10, int i11) {
            if (PlayerWrapper.this.isCommandAvailable(26) || PlayerWrapper.this.isCommandAvailable(34)) {
                if (i10 == -100) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.setDeviceMuted(true, i11);
                        return;
                    } else {
                        PlayerWrapper.this.setDeviceMuted(true);
                        return;
                    }
                }
                if (i10 == -1) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.decreaseDeviceVolume(i11);
                        return;
                    } else {
                        PlayerWrapper.this.decreaseDeviceVolume();
                        return;
                    }
                }
                if (i10 == 1) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.increaseDeviceVolume(i11);
                        return;
                    } else {
                        PlayerWrapper.this.increaseDeviceVolume();
                        return;
                    }
                }
                if (i10 == 100) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.setDeviceMuted(false, i11);
                        return;
                    } else {
                        PlayerWrapper.this.setDeviceMuted(false);
                        return;
                    }
                }
                if (i10 != 101) {
                    Log.w("VolumeProviderCompat", "onAdjustVolume: Ignoring unknown direction: " + i10);
                    return;
                }
                if (PlayerWrapper.this.isCommandAvailable(34)) {
                    PlayerWrapper.this.setDeviceMuted(!r4.isDeviceMutedWithCommandCheck(), i11);
                } else {
                    PlayerWrapper.this.setDeviceMuted(!r4.isDeviceMutedWithCommandCheck());
                }
            }
        }

        public /* synthetic */ void lambda$onSetVolumeTo$0(int i10, int i11) {
            if (PlayerWrapper.this.isCommandAvailable(25) || PlayerWrapper.this.isCommandAvailable(33)) {
                if (PlayerWrapper.this.isCommandAvailable(33)) {
                    PlayerWrapper.this.setDeviceVolume(i10, i11);
                } else {
                    PlayerWrapper.this.setDeviceVolume(i10);
                }
            }
        }

        @Override // androidx.media.VolumeProviderCompat
        public void onAdjustVolume(int i10) {
            Util.postOrRun(this.val$handler, new Runnable() { // from class: androidx.media3.session.vd

                /* renamed from: c */
                public final /* synthetic */ int f988c;

                /* renamed from: d */
                public final /* synthetic */ int f989d;

                public /* synthetic */ vd(int i102, int i11) {
                    i10 = i102;
                    i11 = i11;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    PlayerWrapper.AnonymousClass1.this.lambda$onAdjustVolume$1(i10, i11);
                }
            });
        }

        @Override // androidx.media.VolumeProviderCompat
        public void onSetVolumeTo(int i10) {
            Util.postOrRun(this.val$handler, new Runnable() { // from class: androidx.media3.session.ud

                /* renamed from: c */
                public final /* synthetic */ int f962c;

                /* renamed from: d */
                public final /* synthetic */ int f963d;

                public /* synthetic */ ud(int i102, int i11) {
                    i10 = i102;
                    i11 = i11;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    PlayerWrapper.AnonymousClass1.this.lambda$onSetVolumeTo$0(i10, i11);
                }
            });
        }
    }

    public static final class CurrentMediaItemOnlyTimeline extends Timeline {
        private static final Object UID = new Object();
        private final long durationUs;
        private final boolean isDynamic;
        private final boolean isSeekable;

        @Nullable
        private final MediaItem.LiveConfiguration liveConfiguration;

        @Nullable
        private final MediaItem mediaItem;

        public CurrentMediaItemOnlyTimeline(PlayerWrapper playerWrapper) {
            this.mediaItem = playerWrapper.getCurrentMediaItem();
            this.isSeekable = playerWrapper.isCurrentMediaItemSeekable();
            this.isDynamic = playerWrapper.isCurrentMediaItemDynamic();
            this.liveConfiguration = playerWrapper.isCurrentMediaItemLive() ? MediaItem.LiveConfiguration.UNSET : null;
            this.durationUs = Util.msToUs(playerWrapper.getContentDuration());
        }

        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            return UID.equals(obj) ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z10) {
            Object obj = UID;
            period.set(obj, obj, 0, this.durationUs, 0L);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i10) {
            return UID;
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Window getWindow(int i10, Timeline.Window window, long j10) {
            window.set(UID, this.mediaItem, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.isSeekable, this.isDynamic, this.liveConfiguration, 0L, this.durationUs, 0, 0, 0L);
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public PlayerWrapper(Player player) {
        super(player);
        this.legacyStatusCode = -1;
        this.customLayout = ImmutableList.of();
    }

    private static long convertCommandToPlaybackStateActions(int i10) {
        if (i10 == 1) {
            return 518L;
        }
        if (i10 == 2) {
            return 16384L;
        }
        if (i10 == 3) {
            return 1L;
        }
        if (i10 == 31) {
            return 240640L;
        }
        switch (i10) {
            case 5:
                return 256L;
            case 6:
            case 7:
                return 16L;
            case 8:
            case 9:
                return 32L;
            case 10:
                return 4096L;
            case 11:
                return 8L;
            case 12:
                return 64L;
            case 13:
                return PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
            case 14:
                return 2621440L;
            case 15:
                return PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            default:
                return 0L;
        }
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addListener(Player.Listener listener) {
        verifyApplicationThread();
        super.addListener(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        super.addMediaItem(mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        super.addMediaItems(list);
    }

    public void clearLegacyErrorStatus() {
        this.legacyStatusCode = -1;
        this.legacyErrorMessage = null;
        this.legacyErrorExtras = null;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearMediaItems() {
        verifyApplicationThread();
        super.clearMediaItems();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurface() {
        verifyApplicationThread();
        super.clearVideoSurface();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        super.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        super.clearVideoSurfaceView(surfaceView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        super.clearVideoTextureView(textureView);
    }

    public PlaybackStateCompat createPlaybackStateCompat() {
        if (this.legacyStatusCode != -1) {
            return new PlaybackStateCompat.Builder().setState(7, -1L, 0.0f, SystemClock.elapsedRealtime()).setActions(0L).setBufferedPosition(0L).setErrorMessage(this.legacyStatusCode, (CharSequence) Assertions.checkNotNull(this.legacyErrorMessage)).setExtras((Bundle) Assertions.checkNotNull(this.legacyErrorExtras)).build();
        }
        PlaybackException playerError = getPlayerError();
        int convertToPlaybackStateCompatState = MediaUtils.convertToPlaybackStateCompatState(playerError, getPlaybackState(), getPlayWhenReady());
        Player.Commands availableCommands = getAvailableCommands();
        long j10 = 128;
        for (int i10 = 0; i10 < availableCommands.size(); i10++) {
            j10 |= convertCommandToPlaybackStateActions(availableCommands.get(i10));
        }
        long convertToQueueItemId = isCommandAvailable(17) ? MediaUtils.convertToQueueItemId(getCurrentMediaItemIndex()) : -1L;
        float f10 = getPlaybackParameters().speed;
        float f11 = isPlaying() ? f10 : 0.0f;
        Bundle bundle = new Bundle();
        bundle.putFloat(MediaConstants.EXTRAS_KEY_PLAYBACK_SPEED_COMPAT, f10);
        MediaItem currentMediaItemWithCommandCheck = getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck != null && !"".equals(currentMediaItemWithCommandCheck.mediaId)) {
            bundle.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", currentMediaItemWithCommandCheck.mediaId);
        }
        boolean isCommandAvailable = isCommandAvailable(16);
        PlaybackStateCompat.Builder extras = new PlaybackStateCompat.Builder().setState(convertToPlaybackStateCompatState, isCommandAvailable ? getCurrentPosition() : -1L, f11, SystemClock.elapsedRealtime()).setActions(j10).setActiveQueueItemId(convertToQueueItemId).setBufferedPosition(isCommandAvailable ? getBufferedPosition() : 0L).setExtras(bundle);
        for (int i11 = 0; i11 < this.customLayout.size(); i11++) {
            CommandButton commandButton = this.customLayout.get(i11);
            SessionCommand sessionCommand = commandButton.sessionCommand;
            if (sessionCommand != null && sessionCommand.commandCode == 0) {
                extras.addCustomAction(new PlaybackStateCompat.CustomAction.Builder(sessionCommand.customAction, commandButton.displayName, commandButton.iconResId).setExtras(sessionCommand.customExtras).build());
            }
        }
        if (playerError != null) {
            extras.setErrorMessage(0, (CharSequence) Util.castNonNull(playerError.getMessage()));
        }
        return extras.build();
    }

    public PlayerInfo createPlayerInfoForBundling() {
        return new PlayerInfo(getPlayerError(), 0, createSessionPositionInfoForBundling(), createPositionInfoForBundling(), createPositionInfoForBundling(), 0, getPlaybackParameters(), getRepeatMode(), getShuffleModeEnabled(), getVideoSize(), getCurrentTimelineWithCommandCheck(), getPlaylistMetadataWithCommandCheck(), getVolumeWithCommandCheck(), getAudioAttributesWithCommandCheck(), getCurrentCuesWithCommandCheck(), getDeviceInfo(), getDeviceVolumeWithCommandCheck(), isDeviceMutedWithCommandCheck(), getPlayWhenReady(), 1, getPlaybackSuppressionReason(), getPlaybackState(), isPlaying(), isLoading(), getMediaMetadataWithCommandCheck(), getSeekBackIncrement(), getSeekForwardIncrement(), getMaxSeekToPreviousPosition(), getCurrentTracksWithCommandCheck(), getTrackSelectionParameters());
    }

    public Player.PositionInfo createPositionInfoForBundling() {
        boolean isCommandAvailable = isCommandAvailable(16);
        boolean isCommandAvailable2 = isCommandAvailable(17);
        return new Player.PositionInfo(null, isCommandAvailable2 ? getCurrentMediaItemIndex() : 0, isCommandAvailable ? getCurrentMediaItem() : null, null, isCommandAvailable2 ? getCurrentPeriodIndex() : 0, isCommandAvailable ? getCurrentPosition() : 0L, isCommandAvailable ? getContentPosition() : 0L, isCommandAvailable ? getCurrentAdGroupIndex() : -1, isCommandAvailable ? getCurrentAdIndexInAdGroup() : -1);
    }

    public SessionPositionInfo createSessionPositionInfoForBundling() {
        boolean isCommandAvailable = isCommandAvailable(16);
        Player.PositionInfo createPositionInfoForBundling = createPositionInfoForBundling();
        boolean z10 = isCommandAvailable && isPlayingAd();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = C.TIME_UNSET;
        long duration = isCommandAvailable ? getDuration() : -9223372036854775807L;
        long bufferedPosition = isCommandAvailable ? getBufferedPosition() : 0L;
        int bufferedPercentage = isCommandAvailable ? getBufferedPercentage() : 0;
        long totalBufferedDuration = isCommandAvailable ? getTotalBufferedDuration() : 0L;
        long currentLiveOffset = isCommandAvailable ? getCurrentLiveOffset() : -9223372036854775807L;
        if (isCommandAvailable) {
            j10 = getContentDuration();
        }
        return new SessionPositionInfo(createPositionInfoForBundling, z10, elapsedRealtime, duration, bufferedPosition, bufferedPercentage, totalBufferedDuration, currentLiveOffset, j10, isCommandAvailable ? getContentBufferedPosition() : 0L);
    }

    @Nullable
    public VolumeProviderCompat createVolumeProviderCompat() {
        if (getDeviceInfo().playbackType == 0) {
            return null;
        }
        Player.Commands availableCommands = getAvailableCommands();
        int i10 = availableCommands.contains(26) ? availableCommands.contains(25) ? 2 : 1 : 0;
        Handler handler = new Handler(getApplicationLooper());
        int deviceVolumeWithCommandCheck = getDeviceVolumeWithCommandCheck();
        DeviceInfo deviceInfo = getDeviceInfo();
        return new AnonymousClass1(i10, deviceInfo.maxVolume, deviceVolumeWithCommandCheck, deviceInfo.routingControllerId, handler, 1);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        super.decreaseDeviceVolume();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return super.getAudioAttributes();
    }

    public AudioAttributes getAudioAttributesWithCommandCheck() {
        return isCommandAvailable(21) ? getAudioAttributes() : AudioAttributes.DEFAULT;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return super.getAvailableCommands();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getBufferedPercentage() {
        verifyApplicationThread();
        return super.getBufferedPercentage();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getBufferedPosition() {
        verifyApplicationThread();
        return super.getBufferedPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return super.getContentBufferedPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentDuration() {
        verifyApplicationThread();
        return super.getContentDuration();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return super.getContentPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return super.getCurrentAdGroupIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return super.getCurrentAdIndexInAdGroup();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public CueGroup getCurrentCues() {
        verifyApplicationThread();
        return super.getCurrentCues();
    }

    public CueGroup getCurrentCuesWithCommandCheck() {
        return isCommandAvailable(28) ? getCurrentCues() : CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getCurrentLiveOffset() {
        verifyApplicationThread();
        return super.getCurrentLiveOffset();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Nullable
    public Object getCurrentManifest() {
        verifyApplicationThread();
        return super.getCurrentManifest();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Nullable
    public MediaItem getCurrentMediaItem() {
        verifyApplicationThread();
        return super.getCurrentMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        return super.getCurrentMediaItemIndex();
    }

    @Nullable
    public MediaItem getCurrentMediaItemWithCommandCheck() {
        if (isCommandAvailable(16)) {
            return getCurrentMediaItem();
        }
        return null;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return super.getCurrentPeriodIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getCurrentPosition() {
        verifyApplicationThread();
        return super.getCurrentPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return super.getCurrentTimeline();
    }

    public Timeline getCurrentTimelineWithCommandCheck() {
        return isCommandAvailable(17) ? getCurrentTimeline() : isCommandAvailable(16) ? new CurrentMediaItemOnlyTimeline(this) : Timeline.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Tracks getCurrentTracks() {
        verifyApplicationThread();
        return super.getCurrentTracks();
    }

    public Tracks getCurrentTracksWithCommandCheck() {
        return isCommandAvailable(30) ? getCurrentTracks() : Tracks.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return super.getCurrentWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return super.getDeviceInfo();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getDeviceVolume() {
        verifyApplicationThread();
        return super.getDeviceVolume();
    }

    public int getDeviceVolumeWithCommandCheck() {
        if (isCommandAvailable(23)) {
            return getDeviceVolume();
        }
        return 0;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getDuration() {
        verifyApplicationThread();
        return super.getDuration();
    }

    public long getDurationWithCommandCheck() {
        return isCommandAvailable(16) ? getDuration() : C.TIME_UNSET;
    }

    public int getLegacyStatusCode() {
        return this.legacyStatusCode;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        return super.getMaxSeekToPreviousPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaItem getMediaItemAt(int i10) {
        verifyApplicationThread();
        return super.getMediaItemAt(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getMediaItemCount() {
        verifyApplicationThread();
        return super.getMediaItemCount();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return super.getMediaMetadata();
    }

    public MediaMetadata getMediaMetadataWithCommandCheck() {
        return isCommandAvailable(18) ? getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getNextMediaItemIndex() {
        verifyApplicationThread();
        return super.getNextMediaItemIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getNextWindowIndex() {
        verifyApplicationThread();
        return super.getNextWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return super.getPlayWhenReady();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return super.getPlaybackParameters();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return super.getPlaybackState();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return super.getPlaybackSuppressionReason();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Nullable
    public PlaybackException getPlayerError() {
        verifyApplicationThread();
        return super.getPlayerError();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return super.getPlaylistMetadata();
    }

    public MediaMetadata getPlaylistMetadataWithCommandCheck() {
        return isCommandAvailable(18) ? getPlaylistMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPreviousMediaItemIndex() {
        verifyApplicationThread();
        return super.getPreviousMediaItemIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getPreviousWindowIndex() {
        verifyApplicationThread();
        return super.getPreviousWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return super.getRepeatMode();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getSeekBackIncrement() {
        verifyApplicationThread();
        return super.getSeekBackIncrement();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getSeekForwardIncrement() {
        verifyApplicationThread();
        return super.getSeekForwardIncrement();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return super.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Size getSurfaceSize() {
        verifyApplicationThread();
        return super.getSurfaceSize();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return super.getTotalBufferedDuration();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return super.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public VideoSize getVideoSize() {
        verifyApplicationThread();
        return super.getVideoSize();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public float getVolume() {
        verifyApplicationThread();
        return super.getVolume();
    }

    public float getVolumeWithCommandCheck() {
        if (isCommandAvailable(22)) {
            return getVolume();
        }
        return 0.0f;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasNext() {
        verifyApplicationThread();
        return super.hasNext();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean hasNextMediaItem() {
        verifyApplicationThread();
        return super.hasNextMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasNextWindow() {
        verifyApplicationThread();
        return super.hasNextWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasPrevious() {
        verifyApplicationThread();
        return super.hasPrevious();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean hasPreviousMediaItem() {
        verifyApplicationThread();
        return super.hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasPreviousWindow() {
        verifyApplicationThread();
        return super.hasPreviousWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void increaseDeviceVolume() {
        verifyApplicationThread();
        super.increaseDeviceVolume();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCommandAvailable(int i10) {
        verifyApplicationThread();
        return super.isCommandAvailable(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread();
        return super.isCurrentMediaItemDynamic();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemLive() {
        verifyApplicationThread();
        return super.isCurrentMediaItemLive();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread();
        return super.isCurrentMediaItemSeekable();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return super.isDeviceMuted();
    }

    public boolean isDeviceMutedWithCommandCheck() {
        return isCommandAvailable(23) && isDeviceMuted();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isLoading() {
        verifyApplicationThread();
        return super.isLoading();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isPlaying() {
        verifyApplicationThread();
        return super.isPlaying();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return super.isPlayingAd();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void moveMediaItem(int i10, int i11) {
        verifyApplicationThread();
        super.moveMediaItem(i10, i11);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void moveMediaItems(int i10, int i11, int i12) {
        verifyApplicationThread();
        super.moveMediaItems(i10, i11, i12);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void next() {
        verifyApplicationThread();
        super.next();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void pause() {
        verifyApplicationThread();
        super.pause();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void play() {
        verifyApplicationThread();
        super.play();
    }

    public void playIfCommandAvailable() {
        if (isCommandAvailable(1)) {
            play();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void prepare() {
        verifyApplicationThread();
        super.prepare();
    }

    public void prepareIfCommandAvailable() {
        if (isCommandAvailable(2)) {
            prepare();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void previous() {
        verifyApplicationThread();
        super.previous();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void release() {
        verifyApplicationThread();
        super.release();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        super.removeListener(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeMediaItem(int i10) {
        verifyApplicationThread();
        super.removeMediaItem(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeMediaItems(int i10, int i11) {
        verifyApplicationThread();
        super.removeMediaItems(i10, i11);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void replaceMediaItem(int i10, MediaItem mediaItem) {
        verifyApplicationThread();
        super.replaceMediaItem(i10, mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void replaceMediaItems(int i10, int i11, List<MediaItem> list) {
        verifyApplicationThread();
        super.replaceMediaItems(i10, i11, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekBack() {
        verifyApplicationThread();
        super.seekBack();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekForward() {
        verifyApplicationThread();
        super.seekForward();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekTo(long j10) {
        verifyApplicationThread();
        super.seekTo(j10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToDefaultPosition(int i10) {
        verifyApplicationThread();
        super.seekToDefaultPosition(i10);
    }

    public void seekToDefaultPositionIfCommandAvailable() {
        if (isCommandAvailable(4)) {
            seekToDefaultPosition();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToNext() {
        verifyApplicationThread();
        super.seekToNext();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToNextMediaItem() {
        verifyApplicationThread();
        super.seekToNextMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void seekToNextWindow() {
        verifyApplicationThread();
        super.seekToNextWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToPrevious() {
        verifyApplicationThread();
        super.seekToPrevious();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToPreviousMediaItem() {
        verifyApplicationThread();
        super.seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void seekToPreviousWindow() {
        verifyApplicationThread();
        super.seekToPreviousWindow();
    }

    public void setCustomLayout(ImmutableList<CommandButton> immutableList) {
        this.customLayout = immutableList;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void setDeviceMuted(boolean z10) {
        verifyApplicationThread();
        super.setDeviceMuted(z10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void setDeviceVolume(int i10) {
        verifyApplicationThread();
        super.setDeviceVolume(i10);
    }

    public void setLegacyErrorStatus(int i10, String str, Bundle bundle) {
        Assertions.checkState(i10 != -1);
        this.legacyStatusCode = i10;
        this.legacyErrorMessage = str;
        this.legacyErrorExtras = bundle;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        super.setMediaItems(list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlayWhenReady(boolean z10) {
        verifyApplicationThread();
        super.setPlayWhenReady(z10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        super.setPlaybackParameters(playbackParameters);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaybackSpeed(float f10) {
        verifyApplicationThread();
        super.setPlaybackSpeed(f10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread();
        super.setPlaylistMetadata(mediaMetadata);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setRepeatMode(int i10) {
        verifyApplicationThread();
        super.setRepeatMode(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setShuffleModeEnabled(boolean z10) {
        verifyApplicationThread();
        super.setShuffleModeEnabled(z10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        super.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        super.setVideoSurface(surface);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        super.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        super.setVideoSurfaceView(surfaceView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        super.setVideoTextureView(textureView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVolume(float f10) {
        verifyApplicationThread();
        super.setVolume(f10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void stop() {
        verifyApplicationThread();
        super.stop();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItem(int i10, MediaItem mediaItem) {
        verifyApplicationThread();
        super.addMediaItem(i10, mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItems(int i10, List<MediaItem> list) {
        verifyApplicationThread();
        super.addMediaItems(i10, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        super.clearVideoSurface(surface);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void decreaseDeviceVolume(int i10) {
        verifyApplicationThread();
        super.decreaseDeviceVolume(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void increaseDeviceVolume(int i10) {
        verifyApplicationThread();
        super.increaseDeviceVolume(i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekTo(int i10, long j10) {
        verifyApplicationThread();
        super.seekTo(i10, j10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToDefaultPosition() {
        verifyApplicationThread();
        super.seekToDefaultPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setDeviceMuted(boolean z10, int i10) {
        verifyApplicationThread();
        super.setDeviceMuted(z10, i10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setDeviceVolume(int i10, int i11) {
        verifyApplicationThread();
        super.setDeviceVolume(i10, i11);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem, long j10) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem, j10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list, boolean z10) {
        verifyApplicationThread();
        super.setMediaItems(list, z10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem, boolean z10) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem, z10);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list, int i10, long j10) {
        verifyApplicationThread();
        super.setMediaItems(list, i10, j10);
    }
}
