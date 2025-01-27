package com.kwad.sdk.api.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: classes2.dex */
public class KsNotificationCompat {

    @KsAdSdkApi
    @Keep
    public static final class Builder {
        private NotificationCompat.Builder mBuilder;

        @KsAdSdkApi
        @Keep
        public Builder(Context context) {
            this(context, null);
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            try {
                this.mBuilder = new NotificationCompat.Builder(context, str);
            } catch (Throwable unused) {
                this.mBuilder = new NotificationCompat.Builder(context);
            }
        }

        @KsAdSdkApi
        @Keep
        public final Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.addAction(i2, charSequence, pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder addExtras(Bundle bundle) {
            this.mBuilder.addExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder addPerson(String str) {
            this.mBuilder.addPerson(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Notification build() {
            return this.mBuilder.build();
        }

        @KsAdSdkApi
        @Keep
        public final Bundle getExtras() {
            return this.mBuilder.getExtras();
        }

        @KsAdSdkApi
        @Keep
        public final Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        @Keep
        public final Builder setAutoCancel(boolean z) {
            this.mBuilder.setAutoCancel(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setBadgeIconType(int i2) {
            this.mBuilder.setBadgeIconType(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCategory(String str) {
            this.mBuilder.setCategory(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setChannelId(@NonNull String str) {
            this.mBuilder.setChannelId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setColor(@ColorInt int i2) {
            this.mBuilder.setColor(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setColorized(boolean z) {
            this.mBuilder.setColorized(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.setContent(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentInfo(CharSequence charSequence) {
            this.mBuilder.setContentInfo(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.setContentIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentText(CharSequence charSequence) {
            this.mBuilder.setContentText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setContentTitle(CharSequence charSequence) {
            this.mBuilder.setContentTitle(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomBigContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setDefaults(int i2) {
            this.mBuilder.setDefaults(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.setDeleteIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setExtras(Bundle bundle) {
            this.mBuilder.setExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mBuilder.setFullScreenIntent(pendingIntent, z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroup(String str) {
            this.mBuilder.setGroup(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroupAlertBehavior(int i2) {
            this.mBuilder.setGroupAlertBehavior(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setGroupSummary(boolean z) {
            this.mBuilder.setGroupSummary(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.setLargeIcon(bitmap);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLights(@ColorInt int i2, int i3, int i4) {
            this.mBuilder.setLights(i2, i3, i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setLocalOnly(boolean z) {
            this.mBuilder.setLocalOnly(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setNumber(int i2) {
            this.mBuilder.setNumber(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setOngoing(boolean z) {
            this.mBuilder.setOngoing(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setOnlyAlertOnce(boolean z) {
            this.mBuilder.setOnlyAlertOnce(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setPriority(int i2) {
            this.mBuilder.setPriority(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setProgress(int i2, int i3, boolean z) {
            this.mBuilder.setProgress(i2, i3, z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setPublicVersion(Notification notification) {
            this.mBuilder.setPublicVersion(notification);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.setRemoteInputHistory(charSequenceArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setShortcutId(String str) {
            this.mBuilder.setShortcutId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setShowWhen(boolean z) {
            this.mBuilder.setShowWhen(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSmallIcon(int i2) {
            this.mBuilder.setSmallIcon(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSmallIcon(int i2, int i3) {
            this.mBuilder.setSmallIcon(i2, i3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSortKey(String str) {
            this.mBuilder.setSortKey(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSound(Uri uri) {
            this.mBuilder.setSound(uri);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSound(Uri uri, int i2) {
            this.mBuilder.setSound(uri, i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setSubText(CharSequence charSequence) {
            this.mBuilder.setSubText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTicker(CharSequence charSequence) {
            this.mBuilder.setTicker(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mBuilder.setTicker(charSequence, remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setTimeoutAfter(long j2) {
            this.mBuilder.setTimeoutAfter(j2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setUsesChronometer(boolean z) {
            this.mBuilder.setUsesChronometer(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setVibrate(long[] jArr) {
            this.mBuilder.setVibrate(jArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setVisibility(int i2) {
            this.mBuilder.setVisibility(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public final Builder setWhen(long j2) {
            this.mBuilder.setWhen(j2);
            return this;
        }
    }
}
