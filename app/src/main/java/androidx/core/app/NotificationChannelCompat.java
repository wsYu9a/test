package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import q.a0;
import q.z;

/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;

    @NonNull
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String str, int i10) {
            this.mChannel = new NotificationChannelCompat(str, i10);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.mChannel;
                notificationChannelCompat.mParentId = str;
                notificationChannelCompat.mConversationId = str2;
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mChannel.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.mChannel.mGroupId = str;
            return this;
        }

        @NonNull
        public Builder setImportance(int i10) {
            this.mChannel.mImportance = i10;
            return this;
        }

        @NonNull
        public Builder setLightColor(int i10) {
            this.mChannel.mLightColor = i10;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z10) {
            this.mChannel.mLights = z10;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean z10) {
            this.mChannel.mShowBadge = z10;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mSound = uri;
            notificationChannelCompat.mAudioAttributes = audioAttributes;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z10) {
            this.mChannel.mVibrationEnabled = z10;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mVibrationEnabled = jArr != null && jArr.length > 0;
            notificationChannelCompat.mVibrationPattern = jArr;
            return this;
        }
    }

    public NotificationChannelCompat(@NonNull String str, int i10) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(str);
        this.mImportance = i10;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Nullable
    public String getConversationId() {
        return this.mConversationId;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getGroup() {
        return this.mGroupId;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannel getNotificationChannel() {
        String str;
        String str2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        a0.a();
        NotificationChannel a10 = z.a(this.mId, this.mName, this.mImportance);
        a10.setDescription(this.mDescription);
        a10.setGroup(this.mGroupId);
        a10.setShowBadge(this.mShowBadge);
        a10.setSound(this.mSound, this.mAudioAttributes);
        a10.enableLights(this.mLights);
        a10.setLightColor(this.mLightColor);
        a10.setVibrationPattern(this.mVibrationPattern);
        a10.enableVibration(this.mVibrationEnabled);
        if (i10 >= 30 && (str = this.mParentId) != null && (str2 = this.mConversationId) != null) {
            a10.setConversationId(str, str2);
        }
        return a10;
    }

    @Nullable
    public String getParentChannelId() {
        return this.mParentId;
    }

    @Nullable
    public Uri getSound() {
        return this.mSound;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NotificationChannelCompat(@androidx.annotation.NonNull android.app.NotificationChannel r4) {
        /*
            r3 = this;
            java.lang.String r0 = q.g.a(r4)
            int r1 = q.i0.a(r4)
            r3.<init>(r0, r1)
            java.lang.CharSequence r0 = q.h.a(r4)
            r3.mName = r0
            java.lang.String r0 = q.i.a(r4)
            r3.mDescription = r0
            java.lang.String r0 = q.j.a(r4)
            r3.mGroupId = r0
            boolean r0 = q.k.a(r4)
            r3.mShowBadge = r0
            android.net.Uri r0 = q.l.a(r4)
            r3.mSound = r0
            android.media.AudioAttributes r0 = q.m.a(r4)
            r3.mAudioAttributes = r0
            boolean r0 = q.n.a(r4)
            r3.mLights = r0
            int r0 = q.o.a(r4)
            r3.mLightColor = r0
            boolean r0 = q.r.a(r4)
            r3.mVibrationEnabled = r0
            long[] r0 = q.b0.a(r4)
            r3.mVibrationPattern = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L59
            java.lang.String r2 = q.c0.a(r4)
            r3.mParentId = r2
            java.lang.String r2 = q.d0.a(r4)
            r3.mConversationId = r2
        L59:
            boolean r2 = q.e0.a(r4)
            r3.mBypassDnd = r2
            int r2 = q.f0.a(r4)
            r3.mLockscreenVisibility = r2
            r2 = 29
            if (r0 < r2) goto L6f
            boolean r2 = q.g0.a(r4)
            r3.mCanBubble = r2
        L6f:
            if (r0 < r1) goto L77
            boolean r4 = q.h0.a(r4)
            r3.mImportantConversation = r4
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationChannelCompat.<init>(android.app.NotificationChannel):void");
    }
}
