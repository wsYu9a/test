package androidx.media3.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.HeartRating;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PercentageRating;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.StarRating;
import androidx.media3.common.ThumbRating;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SessionCommands;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class MediaUtils {
    public static final long POSITION_DIFF_TOLERANCE_MS = 100;
    public static final String TAG = "MediaUtils";
    public static final int TRANSACTION_SIZE_LIMIT_IN_BYTES = 262144;
    public static final MediaBrowserServiceCompat.BrowserRoot defaultBrowserRoot = new MediaBrowserServiceCompat.BrowserRoot(MediaLibraryService.SERVICE_INTERFACE, null);

    private MediaUtils() {
    }

    public static boolean areEqualError(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable PlaybackStateCompat playbackStateCompat2) {
        boolean z10 = playbackStateCompat != null && playbackStateCompat.getState() == 7;
        boolean z11 = playbackStateCompat2 != null && playbackStateCompat2.getState() == 7;
        return (z10 && z11) ? ((PlaybackStateCompat) Util.castNonNull(playbackStateCompat)).getErrorCode() == ((PlaybackStateCompat) Util.castNonNull(playbackStateCompat2)).getErrorCode() && TextUtils.equals(((PlaybackStateCompat) Util.castNonNull(playbackStateCompat)).getErrorMessage(), ((PlaybackStateCompat) Util.castNonNull(playbackStateCompat2)).getErrorMessage()) : z10 == z11;
    }

    public static boolean areSessionPositionInfosInSamePeriodOrAd(SessionPositionInfo sessionPositionInfo, SessionPositionInfo sessionPositionInfo2) {
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        int i10 = positionInfo.mediaItemIndex;
        Player.PositionInfo positionInfo2 = sessionPositionInfo2.positionInfo;
        return i10 == positionInfo2.mediaItemIndex && positionInfo.periodIndex == positionInfo2.periodIndex && positionInfo.adGroupIndex == positionInfo2.adGroupIndex && positionInfo.adIndexInAdGroup == positionInfo2.adIndexInAdGroup;
    }

    public static int calculateBufferedPercentage(long j10, long j11) {
        if (j10 == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return 0;
        }
        if (j11 == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((j10 * 100) / j11), 0, 100);
    }

    public static ImmutableList<MediaItem> convertBrowserItemListToMediaItemList(List<MediaBrowserCompat.MediaItem> list) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVar.a(convertToMediaItem(list.get(i10)));
        }
        return aVar.e();
    }

    @SuppressLint({"WrongConstant"})
    public static AudioAttributes convertToAudioAttributes(@Nullable AudioAttributesCompat audioAttributesCompat) {
        return audioAttributesCompat == null ? AudioAttributes.DEFAULT : new AudioAttributes.Builder().setContentType(audioAttributesCompat.getContentType()).setFlags(audioAttributesCompat.getFlags()).setUsage(audioAttributesCompat.getUsage()).build();
    }

    public static AudioAttributesCompat convertToAudioAttributesCompat(AudioAttributes audioAttributes) {
        return new AudioAttributesCompat.Builder().setContentType(audioAttributes.contentType).setFlags(audioAttributes.flags).setUsage(audioAttributes.usage).build();
    }

    public static MediaBrowserCompat.MediaItem convertToBrowserItem(MediaItem mediaItem, @Nullable Bitmap bitmap) {
        MediaDescriptionCompat convertToMediaDescriptionCompat = convertToMediaDescriptionCompat(mediaItem, bitmap);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        Boolean bool = mediaMetadata.isBrowsable;
        int i10 = (bool == null || !bool.booleanValue()) ? 0 : 1;
        Boolean bool2 = mediaMetadata.isPlayable;
        if (bool2 != null && bool2.booleanValue()) {
            i10 |= 2;
        }
        return new MediaBrowserCompat.MediaItem(convertToMediaDescriptionCompat, i10);
    }

    public static int convertToBufferedPercentage(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, long j10) {
        return calculateBufferedPercentage(convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j10), convertToDurationMs(mediaMetadataCompat));
    }

    public static long convertToBufferedPositionMs(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, long j10) {
        long bufferedPosition = playbackStateCompat == null ? 0L : playbackStateCompat.getBufferedPosition();
        long convertToCurrentPositionMs = convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j10);
        long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        return convertToDurationMs == C.TIME_UNSET ? Math.max(convertToCurrentPositionMs, bufferedPosition) : Util.constrainValue(bufferedPosition, convertToCurrentPositionMs, convertToDurationMs);
    }

    private static byte[] convertToByteArray(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static long convertToCurrentPositionMs(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, long j10) {
        if (playbackStateCompat == null) {
            return 0L;
        }
        long currentPosition = playbackStateCompat.getState() == 3 ? getCurrentPosition(playbackStateCompat, j10) : playbackStateCompat.getPosition();
        long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        return convertToDurationMs == C.TIME_UNSET ? Math.max(0L, currentPosition) : Util.constrainValue(currentPosition, 0L, convertToDurationMs);
    }

    public static ImmutableList<CommandButton> convertToCustomLayout(@Nullable PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
            String action = customAction.getAction();
            Bundle extras = customAction.getExtras();
            CommandButton.Builder builder = new CommandButton.Builder();
            if (extras == null) {
                extras = Bundle.EMPTY;
            }
            aVar.a(builder.setSessionCommand(new SessionCommand(action, extras)).setDisplayName(customAction.getName()).setEnabled(true).setIconResId(customAction.getIcon()).build());
        }
        return aVar.e();
    }

    public static DeviceInfo convertToDeviceInfo(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo, @Nullable String str) {
        if (playbackInfo == null) {
            return DeviceInfo.UNKNOWN;
        }
        return new DeviceInfo.Builder(playbackInfo.getPlaybackType() == 2 ? 1 : 0).setMaxVolume(playbackInfo.getMaxVolume()).setRoutingControllerId(str).build();
    }

    public static int convertToDeviceVolume(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return 0;
        }
        return playbackInfo.getCurrentVolume();
    }

    public static long convertToDurationMs(@Nullable MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            return C.TIME_UNSET;
        }
        long j10 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        return j10 <= 0 ? C.TIME_UNSET : j10;
    }

    private static long convertToExtraBtFolderType(int i10) {
        switch (i10) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                throw new IllegalArgumentException("Unrecognized FolderType: " + i10);
        }
    }

    private static int convertToFolderType(long j10) {
        if (j10 == 0) {
            return 0;
        }
        if (j10 == 1) {
            return 1;
        }
        if (j10 == 2) {
            return 2;
        }
        if (j10 == 3) {
            return 3;
        }
        if (j10 == 4) {
            return 4;
        }
        if (j10 == 5) {
            return 5;
        }
        return j10 == 6 ? 6 : 0;
    }

    public static boolean convertToIsDeviceMuted(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo) {
        return playbackInfo != null && playbackInfo.getCurrentVolume() == 0;
    }

    public static boolean convertToIsPlaying(@Nullable PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat != null && playbackStateCompat.getState() == 3;
    }

    public static boolean convertToIsPlayingAd(@Nullable MediaMetadataCompat mediaMetadataCompat) {
        return (mediaMetadataCompat == null || mediaMetadataCompat.getLong("android.media.metadata.ADVERTISEMENT") == 0) ? false : true;
    }

    @Nullable
    public static MediaLibraryService.LibraryParams convertToLibraryParams(Context context, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            int i10 = bundle.getInt(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS, -1);
            if (i10 >= 0) {
                bundle.remove(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS);
                boolean z10 = true;
                if (i10 != 1) {
                    z10 = false;
                }
                bundle.putBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, z10);
            }
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).setRecent(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT)).setOffline(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE)).setSuggested(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED)).build();
        } catch (Exception unused) {
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).build();
        }
    }

    public static MediaDescriptionCompat convertToMediaDescriptionCompat(MediaItem mediaItem, @Nullable Bitmap bitmap) {
        MediaDescriptionCompat.Builder mediaId = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.mediaId.equals("") ? null : mediaItem.mediaId);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (bitmap != null) {
            mediaId.setIconBitmap(bitmap);
        }
        Bundle bundle = mediaMetadata.extras;
        Integer num = mediaMetadata.folderType;
        boolean z10 = (num == null || num.intValue() == -1) ? false : true;
        boolean z11 = mediaMetadata.mediaType != null;
        if (z10 || z11) {
            bundle = bundle == null ? new Bundle() : new Bundle(bundle);
            if (z10) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, convertToExtraBtFolderType(((Integer) Assertions.checkNotNull(mediaMetadata.folderType)).intValue()));
            }
            if (z11) {
                bundle.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, ((Integer) Assertions.checkNotNull(mediaMetadata.mediaType)).intValue());
            }
        }
        MediaDescriptionCompat.Builder title = mediaId.setTitle(mediaMetadata.title);
        CharSequence charSequence = mediaMetadata.artist;
        if (charSequence == null) {
            charSequence = mediaMetadata.subtitle;
        }
        return title.setSubtitle(charSequence).setDescription(mediaMetadata.description).setIconUri(mediaMetadata.artworkUri).setMediaUri(mediaItem.requestMetadata.mediaUri).setExtras(bundle).build();
    }

    public static MediaItem convertToMediaItem(MediaBrowserCompat.MediaItem mediaItem) {
        return convertToMediaItem(mediaItem.getDescription(), mediaItem.isBrowsable(), mediaItem.isPlayable());
    }

    public static List<MediaItem> convertToMediaItemList(Timeline timeline) {
        ArrayList arrayList = new ArrayList();
        Timeline.Window window = new Timeline.Window();
        for (int i10 = 0; i10 < timeline.getWindowCount(); i10++) {
            arrayList.add(timeline.getWindow(i10, window).mediaItem);
        }
        return arrayList;
    }

    public static MediaMetadata convertToMediaMetadata(@Nullable CharSequence charSequence) {
        return charSequence == null ? MediaMetadata.EMPTY : new MediaMetadata.Builder().setTitle(charSequence).build();
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata, String str, @Nullable Uri uri, long j10, @Nullable Bitmap bitmap) {
        MediaMetadataCompat.Builder putString = new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, str);
        CharSequence charSequence = mediaMetadata.title;
        if (charSequence != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_TITLE, charSequence);
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, mediaMetadata.title);
        }
        CharSequence charSequence2 = mediaMetadata.subtitle;
        if (charSequence2 != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, charSequence2);
        }
        CharSequence charSequence3 = mediaMetadata.description;
        if (charSequence3 != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, charSequence3);
        }
        CharSequence charSequence4 = mediaMetadata.artist;
        if (charSequence4 != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ARTIST, charSequence4);
        }
        CharSequence charSequence5 = mediaMetadata.albumTitle;
        if (charSequence5 != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ALBUM, charSequence5);
        }
        CharSequence charSequence6 = mediaMetadata.albumArtist;
        if (charSequence6 != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, charSequence6);
        }
        if (mediaMetadata.recordingYear != null) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_YEAR, r0.intValue());
        }
        if (uri != null) {
            putString.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, uri.toString());
        }
        Uri uri2 = mediaMetadata.artworkUri;
        if (uri2 != null) {
            putString.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, uri2.toString());
            putString.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, mediaMetadata.artworkUri.toString());
        }
        if (bitmap != null) {
            putString.putBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, bitmap);
            putString.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap);
        }
        Integer num = mediaMetadata.folderType;
        if (num != null && num.intValue() != -1) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, convertToExtraBtFolderType(mediaMetadata.folderType.intValue()));
        }
        if (j10 != C.TIME_UNSET) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, j10);
        }
        RatingCompat convertToRatingCompat = convertToRatingCompat(mediaMetadata.userRating);
        if (convertToRatingCompat != null) {
            putString.putRating(MediaMetadataCompat.METADATA_KEY_USER_RATING, convertToRatingCompat);
        }
        RatingCompat convertToRatingCompat2 = convertToRatingCompat(mediaMetadata.overallRating);
        if (convertToRatingCompat2 != null) {
            putString.putRating(MediaMetadataCompat.METADATA_KEY_RATING, convertToRatingCompat2);
        }
        if (mediaMetadata.mediaType != null) {
            putString.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, r3.intValue());
        }
        return putString.build();
    }

    public static Timeline.Period convertToPeriod(int i10) {
        Timeline.Period period = new Timeline.Period();
        period.set(null, null, i10, C.TIME_UNSET, 0L, AdPlaybackState.NONE, true);
        return period;
    }

    public static boolean convertToPlayWhenReady(@Nullable PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return false;
        }
        switch (playbackStateCompat.getState()) {
        }
        return false;
    }

    @Nullable
    public static PlaybackException convertToPlaybackException(@Nullable PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null || playbackStateCompat.getState() != 7) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(playbackStateCompat.getErrorMessage())) {
            sb2.append(playbackStateCompat.getErrorMessage().toString());
            sb2.append(", ");
        }
        sb2.append("code=");
        sb2.append(playbackStateCompat.getErrorCode());
        return new PlaybackException(sb2.toString(), null, 1001);
    }

    public static PlaybackParameters convertToPlaybackParameters(@Nullable PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat == null ? PlaybackParameters.DEFAULT : new PlaybackParameters(playbackStateCompat.getPlaybackSpeed());
    }

    public static int convertToPlaybackState(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, long j10) {
        if (playbackStateCompat == null) {
            return 1;
        }
        switch (playbackStateCompat.getState()) {
            case 0:
            case 1:
            case 7:
            case 8:
                return 1;
            case 2:
                long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
                return (convertToDurationMs != C.TIME_UNSET && convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j10) >= convertToDurationMs) ? 4 : 3;
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                throw new IllegalStateException("Unrecognized PlaybackStateCompat: " + playbackStateCompat.getState());
        }
    }

    public static int convertToPlaybackStateCompatRepeatMode(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("Unrecognized RepeatMode: " + i10);
    }

    public static int convertToPlaybackStateCompatShuffleMode(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static int convertToPlaybackStateCompatState(@Nullable PlaybackException playbackException, int i10, boolean z10) {
        if (playbackException != null) {
            return 7;
        }
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return z10 ? 6 : 2;
        }
        if (i10 == 3) {
            return z10 ? 3 : 2;
        }
        if (i10 == 4) {
            return 1;
        }
        throw new IllegalArgumentException("Unrecognized State: " + i10);
    }

    public static Player.Commands convertToPlayerCommands(@Nullable PlaybackStateCompat playbackStateCompat, int i10, long j10, boolean z10) {
        Player.Commands.Builder builder = new Player.Commands.Builder();
        long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
        if ((hasAction(actions, 4L) && hasAction(actions, 2L)) || hasAction(actions, 512L)) {
            builder.add(1);
        }
        if (hasAction(actions, 16384L)) {
            builder.add(2);
        }
        if ((hasAction(actions, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) && hasAction(actions, 1024L)) || ((hasAction(actions, 65536L) && hasAction(actions, 2048L)) || (hasAction(actions, PlaybackStateCompat.ACTION_PREPARE_FROM_URI) && hasAction(actions, PlaybackStateCompat.ACTION_PLAY_FROM_URI)))) {
            builder.addAll(31, 2);
        }
        if (hasAction(actions, 8L)) {
            builder.add(11);
        }
        if (hasAction(actions, 64L)) {
            builder.add(12);
        }
        if (hasAction(actions, 256L)) {
            builder.addAll(5, 4);
        }
        if (hasAction(actions, 32L)) {
            builder.addAll(9, 8);
        }
        if (hasAction(actions, 16L)) {
            builder.addAll(7, 6);
        }
        if (hasAction(actions, PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED)) {
            builder.add(13);
        }
        if (hasAction(actions, 1L)) {
            builder.add(3);
        }
        if (i10 == 1) {
            builder.addAll(26, 34);
        } else if (i10 == 2) {
            builder.addAll(26, 34, 25, 33);
        }
        builder.addAll(23, 17, 18, 16, 21, 32);
        if ((j10 & 4) != 0) {
            builder.add(20);
            if (hasAction(actions, 4096L)) {
                builder.add(10);
            }
        }
        if (z10) {
            if (hasAction(actions, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
                builder.add(15);
            }
            if (hasAction(actions, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
                builder.add(14);
            }
        }
        return builder.build();
    }

    public static MediaSessionCompat.QueueItem convertToQueueItem(MediaItem mediaItem, int i10, @Nullable Bitmap bitmap) {
        return new MediaSessionCompat.QueueItem(convertToMediaDescriptionCompat(mediaItem, bitmap), convertToQueueItemId(i10));
    }

    public static long convertToQueueItemId(int i10) {
        if (i10 == -1) {
            return -1L;
        }
        return i10;
    }

    @Nullable
    public static Rating convertToRating(@Nullable RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        switch (ratingCompat.getRatingStyle()) {
            case 1:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 3:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 4:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 5:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 6:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
        }
        return null;
    }

    @Nullable
    @SuppressLint({"WrongConstant"})
    public static RatingCompat convertToRatingCompat(@Nullable Rating rating) {
        if (rating == null) {
            return null;
        }
        int ratingCompatStyle = getRatingCompatStyle(rating);
        if (!rating.isRated()) {
            return RatingCompat.newUnratedRating(ratingCompatStyle);
        }
        switch (ratingCompatStyle) {
            case 1:
                return RatingCompat.newHeartRating(((HeartRating) rating).isHeart());
            case 2:
                return RatingCompat.newThumbRating(((ThumbRating) rating).isThumbsUp());
            case 3:
            case 4:
            case 5:
                return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).getStarRating());
            case 6:
                return RatingCompat.newPercentageRating(((PercentageRating) rating).getPercent());
            default:
                return null;
        }
    }

    public static int convertToRepeatMode(int i10) {
        if (i10 == -1 || i10 == 0) {
            return 0;
        }
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException("Unrecognized PlaybackStateCompat.RepeatMode: " + i10);
            }
        }
        return i11;
    }

    @Nullable
    public static Bundle convertToRootHints(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams == null) {
            return null;
        }
        Bundle bundle = new Bundle(libraryParams.extras);
        if (libraryParams.extras.containsKey(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY)) {
            boolean z10 = libraryParams.extras.getBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, false);
            bundle.remove(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY);
            bundle.putInt(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS, z10 ? 1 : 3);
        }
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT, libraryParams.isRecent);
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE, libraryParams.isOffline);
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED, libraryParams.isSuggested);
        return bundle;
    }

    public static SessionCommands convertToSessionCommands(@Nullable PlaybackStateCompat playbackStateCompat, boolean z10) {
        SessionCommands.Builder builder = new SessionCommands.Builder();
        builder.addAllSessionCommands();
        if (!z10) {
            builder.remove(SessionCommand.COMMAND_CODE_SESSION_SET_RATING);
        }
        if (playbackStateCompat != null && playbackStateCompat.getCustomActions() != null) {
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
                String action = customAction.getAction();
                Bundle extras = customAction.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                builder.add(new SessionCommand(action, extras));
            }
        }
        return builder.build();
    }

    public static boolean convertToShuffleModeEnabled(int i10) {
        if (i10 == -1 || i10 == 0) {
            return false;
        }
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized ShuffleMode: " + i10);
    }

    public static long convertToTotalBufferedDurationMs(@Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, long j10) {
        return convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j10) - convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j10);
    }

    public static Timeline.Window convertToWindow(MediaItem mediaItem, int i10) {
        Timeline.Window window = new Timeline.Window();
        window.set(0, mediaItem, null, 0L, 0L, 0L, true, false, null, 0L, C.TIME_UNSET, i10, i10, 0L);
        return window;
    }

    public static Player.Commands createPlayerCommandsWith(int i10) {
        return new Player.Commands.Builder().add(i10).build();
    }

    public static Player.Commands createPlayerCommandsWithout(int i10) {
        return new Player.Commands.Builder().addAllCommands().remove(i10).build();
    }

    public static int[] generateUnshuffledIndices(int i10) {
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = i11;
        }
        return iArr;
    }

    private static long getCurrentPosition(PlaybackStateCompat playbackStateCompat, long j10) {
        return playbackStateCompat.getCurrentPosition(j10 == C.TIME_UNSET ? null : Long.valueOf(j10));
    }

    @Nullable
    private static Bitmap getFirstBitmap(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getBitmap(str);
            }
        }
        return null;
    }

    @Nullable
    private static String getFirstString(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getString(str);
            }
        }
        return null;
    }

    @Nullable
    private static CharSequence getFirstText(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getText(str);
            }
        }
        return null;
    }

    public static <T> T getFutureResult(Future<T> future, long j10) throws ExecutionException, TimeoutException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = false;
        long j11 = j10;
        while (true) {
            try {
                try {
                    return future.get(j11, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    z10 = true;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (elapsedRealtime2 >= j10) {
                        throw new TimeoutException();
                    }
                    j11 = j10 - elapsedRealtime2;
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static int getLegacyStreamType(AudioAttributes audioAttributes) {
        int legacyStreamType = convertToAudioAttributesCompat(audioAttributes).getLegacyStreamType();
        if (legacyStreamType == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    public static int getRatingCompatStyle(@Nullable Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (!(rating instanceof StarRating)) {
            return rating instanceof PercentageRating ? 6 : 0;
        }
        int maxStars = ((StarRating) rating).getMaxStars();
        int i10 = 3;
        if (maxStars != 3) {
            i10 = 4;
            if (maxStars != 4) {
                i10 = 5;
                if (maxStars != 5) {
                    return 0;
                }
            }
        }
        return i10;
    }

    private static boolean hasAction(long j10, long j11) {
        return (j10 & j11) != 0;
    }

    public static Player.Commands intersect(@Nullable Player.Commands commands, @Nullable Player.Commands commands2) {
        if (commands == null || commands2 == null) {
            return Player.Commands.EMPTY;
        }
        Player.Commands.Builder builder = new Player.Commands.Builder();
        for (int i10 = 0; i10 < commands.size(); i10++) {
            if (commands2.contains(commands.get(i10))) {
                builder.add(commands.get(i10));
            }
        }
        return builder.build();
    }

    public static Pair<PlayerInfo, PlayerInfo.BundlingExclusions> mergePlayerInfo(PlayerInfo playerInfo, PlayerInfo.BundlingExclusions bundlingExclusions, PlayerInfo playerInfo2, PlayerInfo.BundlingExclusions bundlingExclusions2, Player.Commands commands) {
        PlayerInfo.BundlingExclusions bundlingExclusions3;
        if (bundlingExclusions2.isTimelineExcluded && commands.contains(17) && !bundlingExclusions.isTimelineExcluded) {
            playerInfo2 = playerInfo2.copyWithTimeline(playerInfo.timeline);
            bundlingExclusions3 = new PlayerInfo.BundlingExclusions(false, bundlingExclusions2.areCurrentTracksExcluded);
        } else {
            bundlingExclusions3 = bundlingExclusions2;
        }
        if (bundlingExclusions2.areCurrentTracksExcluded && commands.contains(30) && !bundlingExclusions.areCurrentTracksExcluded) {
            playerInfo2 = playerInfo2.copyWithCurrentTracks(playerInfo.currentTracks);
            bundlingExclusions3 = new PlayerInfo.BundlingExclusions(bundlingExclusions3.isTimelineExcluded, false);
        }
        return new Pair<>(playerInfo2, bundlingExclusions3);
    }

    public static <T> List<T> removeNullElements(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T t10 : list) {
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static void setMediaItemsWithStartIndexAndPosition(Player player, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        if (mediaItemsWithStartPosition.startIndex == -1) {
            if (player.isCommandAvailable(20)) {
                player.setMediaItems(mediaItemsWithStartPosition.mediaItems, true);
                return;
            } else {
                if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                    return;
                }
                player.setMediaItem(mediaItemsWithStartPosition.mediaItems.get(0), true);
                return;
            }
        }
        if (player.isCommandAvailable(20)) {
            player.setMediaItems(mediaItemsWithStartPosition.mediaItems, mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.startPositionMs);
        } else {
            if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                return;
            }
            player.setMediaItem(mediaItemsWithStartPosition.mediaItems.get(0), mediaItemsWithStartPosition.startPositionMs);
        }
    }

    public static <T extends Parcelable> List<T> truncateListBySize(List<T> list, int i10) {
        ArrayList arrayList = new ArrayList();
        Parcel obtain = Parcel.obtain();
        for (int i11 = 0; i11 < list.size(); i11++) {
            try {
                T t10 = list.get(i11);
                obtain.writeParcelable(t10, 0);
                if (obtain.dataSize() >= i10) {
                    break;
                }
                arrayList.add(t10);
            } finally {
                obtain.recycle();
            }
        }
        return arrayList;
    }

    public static MediaItem convertToMediaItem(MediaSessionCompat.QueueItem queueItem) {
        return convertToMediaItem(queueItem.getDescription());
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Assertions.checkNotNull(mediaDescriptionCompat);
        return convertToMediaItem(mediaDescriptionCompat, false, true);
    }

    public static MediaMetadata convertToMediaMetadata(@Nullable MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        return convertToMediaMetadata(mediaDescriptionCompat, i10, false, true);
    }

    private static MediaMetadata convertToMediaMetadata(@Nullable MediaDescriptionCompat mediaDescriptionCompat, int i10, boolean z10, boolean z11) {
        byte[] bArr;
        if (mediaDescriptionCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setTitle(mediaDescriptionCompat.getTitle()).setSubtitle(mediaDescriptionCompat.getSubtitle()).setDescription(mediaDescriptionCompat.getDescription()).setArtworkUri(mediaDescriptionCompat.getIconUri()).setUserRating(convertToRating(RatingCompat.newUnratedRating(i10)));
        Bitmap iconBitmap = mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null) {
            try {
                bArr = convertToByteArray(iconBitmap);
            } catch (IOException e10) {
                Log.w(TAG, "Failed to convert iconBitmap to artworkData", e10);
                bArr = null;
            }
            builder.setArtworkData(bArr, 3);
        }
        Bundle extras = mediaDescriptionCompat.getExtras();
        Bundle bundle = extras != null ? new Bundle(extras) : null;
        if (bundle != null && bundle.containsKey(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE)) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(bundle.getLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE))));
            bundle.remove(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE);
        }
        builder.setIsBrowsable(Boolean.valueOf(z10));
        if (bundle != null && bundle.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) bundle.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
            bundle.remove(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT);
        }
        if (bundle != null && !bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        builder.setIsPlayable(Boolean.valueOf(z11));
        return builder.build();
    }

    public static MediaItem convertToMediaItem(MediaMetadataCompat mediaMetadataCompat, int i10) {
        return convertToMediaItem(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID), mediaMetadataCompat, i10);
    }

    public static AudioAttributes convertToAudioAttributes(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return AudioAttributes.DEFAULT;
        }
        return convertToAudioAttributes(playbackInfo.getAudioAttributes());
    }

    public static MediaItem convertToMediaItem(@Nullable String str, MediaMetadataCompat mediaMetadataCompat, int i10) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str != null) {
            builder.setMediaId(str);
        }
        String string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI);
        if (string != null) {
            builder.setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(Uri.parse(string)).build());
        }
        builder.setMediaMetadata(convertToMediaMetadata(mediaMetadataCompat, i10));
        return builder.build();
    }

    private static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat, boolean z10, boolean z11) {
        String mediaId = mediaDescriptionCompat.getMediaId();
        MediaItem.Builder builder = new MediaItem.Builder();
        if (mediaId == null) {
            mediaId = "";
        }
        return builder.setMediaId(mediaId).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(mediaDescriptionCompat.getMediaUri()).build()).setMediaMetadata(convertToMediaMetadata(mediaDescriptionCompat, 0, z10, z11)).build();
    }

    public static MediaMetadata convertToMediaMetadata(@Nullable MediaMetadataCompat mediaMetadataCompat, int i10) {
        if (mediaMetadataCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setTitle(getFirstText(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, MediaMetadataCompat.METADATA_KEY_TITLE)).setSubtitle(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE)).setDescription(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION)).setArtist(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ARTIST)).setAlbumTitle(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ALBUM)).setAlbumArtist(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)).setOverallRating(convertToRating(mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_RATING)));
        Rating convertToRating = convertToRating(mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        if (convertToRating != null) {
            builder.setUserRating(convertToRating);
        } else {
            builder.setUserRating(convertToRating(RatingCompat.newUnratedRating(i10)));
        }
        if (mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
            builder.setRecordingYear(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_YEAR)));
        }
        String firstString = getFirstString(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI);
        if (firstString != null) {
            builder.setArtworkUri(Uri.parse(firstString));
        }
        Bitmap firstBitmap = getFirstBitmap(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
        if (firstBitmap != null) {
            try {
                builder.setArtworkData(convertToByteArray(firstBitmap), 3);
            } catch (IOException e10) {
                Log.w(TAG, "Failed to convert artworkBitmap to artworkData", e10);
            }
        }
        boolean containsKey = mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE);
        builder.setIsBrowsable(Boolean.valueOf(containsKey));
        if (containsKey) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE))));
        }
        if (mediaMetadataCompat.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
        }
        builder.setIsPlayable(Boolean.TRUE);
        return builder.build();
    }
}
