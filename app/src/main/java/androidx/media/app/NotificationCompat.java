package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

/* loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void o(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", this.f1546a.getColor() != 0 ? this.f1546a.getColor() : this.f1546a.mContext.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(i(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int m(int i2) {
            return i2 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.f1546a.getBigContentView() != null ? this.f1546a.getBigContentView() : this.f1546a.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews j2 = j();
            buildIntoRemoteViews(j2, bigContentView);
            if (i2 >= 21) {
                o(j2);
            }
            return j2;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = this.f1546a.getContentView() != null;
            if (i2 >= 21) {
                if (!z2 && this.f1546a.getBigContentView() == null) {
                    z = false;
                }
                if (z) {
                    RemoteViews k = k();
                    if (z2) {
                        buildIntoRemoteViews(k, this.f1546a.getContentView());
                    }
                    o(k);
                    return k;
                }
            } else {
                RemoteViews k2 = k();
                if (z2) {
                    buildIntoRemoteViews(k2, this.f1546a.getContentView());
                    return k2;
                }
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.f1546a.getHeadsUpContentView() != null ? this.f1546a.getHeadsUpContentView() : this.f1546a.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews j2 = j();
            buildIntoRemoteViews(j2, headsUpContentView);
            if (i2 >= 21) {
                o(j2);
            }
            return j2;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int n() {
            return this.f1546a.getContentView() != null ? R.layout.notification_template_media_custom : super.n();
        }
    }

    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: e */
        private static final int f2877e = 3;

        /* renamed from: f */
        private static final int f2878f = 5;

        /* renamed from: g */
        int[] f2879g = null;

        /* renamed from: h */
        MediaSessionCompat.Token f2880h;

        /* renamed from: i */
        boolean f2881i;

        /* renamed from: j */
        PendingIntent f2882j;

        public MediaStyle() {
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return MediaSessionCompat.Token.fromToken(parcelable);
                }
                return null;
            }
            IBinder binder = BundleCompat.getBinder(extras, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder == null) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.writeStrongBinder(binder);
            obtain.setDataPosition(0);
            MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }

        private RemoteViews l(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.f1546a.mContext.getPackageName(), R.layout.notification_media_action);
            int i2 = R.id.action0;
            remoteViews.setImageViewResource(i2, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(i2, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(i2, action.getTitle());
            }
            return remoteViews;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(i(new Notification.MediaStyle()));
            } else if (this.f2881i) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        @RequiresApi(21)
        Notification.MediaStyle i(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f2879g;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f2880h;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        RemoteViews j() {
            int min = Math.min(this.f1546a.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, m(min), false);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i2 = 0; i2 < min; i2++) {
                    applyStandardTemplate.addView(R.id.media_actions, l(this.f1546a.mActions.get(i2)));
                }
            }
            if (this.f2881i) {
                int i3 = R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i3, 0);
                applyStandardTemplate.setInt(i3, "setAlpha", this.f1546a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(i3, this.f2882j);
            } else {
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        RemoteViews k() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, n(), true);
            int size = this.f1546a.mActions.size();
            int[] iArr = this.f2879g;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i2 = 0; i2 < min; i2++) {
                    if (i2 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    }
                    applyStandardTemplate.addView(R.id.media_actions, l(this.f1546a.mActions.get(this.f2879g[i2])));
                }
            }
            if (this.f2881i) {
                applyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
                int i3 = R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i3, 0);
                applyStandardTemplate.setOnClickPendingIntent(i3, this.f2882j);
                applyStandardTemplate.setInt(i3, "setAlpha", this.f1546a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        int m(int i2) {
            return i2 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return j();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return k();
        }

        int n() {
            return R.layout.notification_template_media;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f2882j = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f2880h = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f2879g = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.f2881i = z;
            }
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
