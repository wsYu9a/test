package androidx.media3.session;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
/* loaded from: classes.dex */
public class MediaStyleNotificationHelper {
    public static final String EXTRA_MEDIA3_SESSION = "androidx.media3.session";

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Notification.MediaStyle createMediaStyle() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        public static Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle, @Nullable int[] iArr, MediaSession mediaSession) {
            Assertions.checkNotNull(mediaStyle);
            Assertions.checkNotNull(mediaSession);
            if (iArr != null) {
                setShowActionsInCompactView(mediaStyle, iArr);
            }
            mediaStyle.setMediaSession((MediaSession.Token) mediaSession.getSessionCompatToken().getToken());
            return mediaStyle;
        }

        @DoNotInline
        public static void setMediaStyle(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        public static void setShowActionsInCompactView(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Notification.DecoratedMediaCustomViewStyle createDecoratedMediaCustomViewStyle() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle(MediaSession mediaSession) {
            super(mediaSession);
        }

        private void setBackgroundColor(RemoteViews remoteViews) {
            remoteViews.setInt(androidx.media.R.id.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(androidx.media.R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24) {
                super.apply(notificationBuilderWithBuilderAccessor);
                return;
            }
            Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api24Impl.createDecoratedMediaCustomViewStyle(), this.actionsToShowInCompact, this.session));
            Bundle bundle = new Bundle();
            bundle.putBundle("androidx.media3.session", this.session.getToken().toBundle());
            notificationBuilderWithBuilderAccessor.getBuilder().addExtras(bundle);
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        public int getBigContentViewLayoutResource(int i10) {
            return i10 <= 3 ? androidx.media.R.layout.notification_template_big_media_narrow_custom : androidx.media.R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        public int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? androidx.media.R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        @Nullable
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, bigContentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        @Nullable
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z10 = this.mBuilder.getContentView() != null;
            if (!z10 && this.mBuilder.getBigContentView() == null) {
                return null;
            }
            RemoteViews generateContentView = generateContentView();
            if (z10) {
                buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
            }
            setBackgroundColor(generateContentView);
            return generateContentView;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @Nullable
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, headsUpContentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] actionsToShowInCompact;

        @Nullable
        PendingIntent cancelButtonIntent;
        MediaSession session;
        boolean showCancelButton;

        public MediaStyle(MediaSession mediaSession) {
            this.session = mediaSession;
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z10 = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), androidx.media.R.layout.notification_media_action);
            remoteViews.setImageViewResource(androidx.media.R.id.action0, action.getIcon());
            if (!z10) {
                remoteViews.setOnClickPendingIntent(androidx.media.R.id.action0, action.getActionIntent());
            }
            remoteViews.setContentDescription(androidx.media.R.id.action0, action.getTitle());
            return remoteViews;
        }

        @Nullable
        public static SessionToken getSessionToken(Notification notification) {
            Bundle bundle;
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null || (bundle = extras.getBundle("androidx.media3.session")) == null) {
                return null;
            }
            return SessionToken.CREATOR.fromBundle(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api21Impl.createMediaStyle(), this.actionsToShowInCompact, this.session));
            Bundle bundle = new Bundle();
            bundle.putBundle("androidx.media3.session", this.session.getToken().toBundle());
            notificationBuilderWithBuilderAccessor.getBuilder().addExtras(bundle);
        }

        public RemoteViews generateBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
            if (min > 0) {
                for (int i10 = 0; i10 < min; i10++) {
                    applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i10)));
                }
            }
            if (this.showCancelButton) {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 0);
                applyStandardTemplate.setInt(androidx.media.R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(androidx.media.R.id.cancel_action, this.cancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public RemoteViews generateContentView() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.actionsToShowInCompact;
            if (iArr != null) {
                int min = Math.min(iArr.length, 3);
                applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
                if (min > 0) {
                    for (int i10 = 0; i10 < min; i10++) {
                        if (i10 >= size) {
                            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i10), Integer.valueOf(size - 1)));
                        }
                        applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(iArr[i10])));
                    }
                }
            }
            if (this.showCancelButton) {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 8);
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 0);
                applyStandardTemplate.setOnClickPendingIntent(androidx.media.R.id.cancel_action, this.cancelButtonIntent);
                applyStandardTemplate.setInt(androidx.media.R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public int getBigContentViewLayoutResource(int i10) {
            return i10 <= 3 ? androidx.media.R.layout.notification_template_big_media_narrow : androidx.media.R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return androidx.media.R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @Nullable
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @Nullable
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @CanIgnoreReturnValue
        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.cancelButtonIntent = pendingIntent;
            return this;
        }

        @CanIgnoreReturnValue
        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.actionsToShowInCompact = iArr;
            return this;
        }

        @CanIgnoreReturnValue
        public MediaStyle setShowCancelButton(boolean z10) {
            return this;
        }
    }

    private MediaStyleNotificationHelper() {
    }
}
