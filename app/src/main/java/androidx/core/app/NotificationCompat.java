package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";

    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;

        /* renamed from: a */
        static final String f1451a = "android.support.action.showsUserInterface";

        /* renamed from: b */
        static final String f1452b = "android.support.action.semanticAction";
        public PendingIntent actionIntent;

        /* renamed from: c */
        final Bundle f1453c;

        /* renamed from: d */
        @Nullable
        private IconCompat f1454d;

        /* renamed from: e */
        private final RemoteInput[] f1455e;

        /* renamed from: f */
        private final RemoteInput[] f1456f;

        /* renamed from: g */
        private boolean f1457g;

        /* renamed from: h */
        boolean f1458h;

        /* renamed from: i */
        private final int f1459i;

        @Deprecated
        public int icon;

        /* renamed from: j */
        private final boolean f1460j;
        public CharSequence title;

        public static final class Builder {

            /* renamed from: a */
            private final IconCompat f1461a;

            /* renamed from: b */
            private final CharSequence f1462b;

            /* renamed from: c */
            private final PendingIntent f1463c;

            /* renamed from: d */
            private boolean f1464d;

            /* renamed from: e */
            private final Bundle f1465e;

            /* renamed from: f */
            private ArrayList<RemoteInput> f1466f;

            /* renamed from: g */
            private int f1467g;

            /* renamed from: h */
            private boolean f1468h;

            /* renamed from: i */
            private boolean f1469i;

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            private void a() {
                if (this.f1469i && this.f1463c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.f1465e.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f1466f == null) {
                    this.f1466f = new ArrayList<>();
                }
                this.f1466f.add(remoteInput);
                return this;
            }

            public Action build() {
                a();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.f1466f;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                return new Action(this.f1461a, this.f1462b, this.f1463c, this.f1465e, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.f1464d, this.f1467g, this.f1468h, this.f1469i);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.f1465e;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.f1464d = z;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean z) {
                this.f1469i = z;
                return this;
            }

            public Builder setSemanticAction(int i2) {
                this.f1467g = i2;
                return this;
            }

            public Builder setShowsUserInterface(boolean z) {
                this.f1468h = z;
                return this;
            }

            public Builder(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.f1453c), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.f1458h, action.isContextual());
            }

            private Builder(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2, boolean z3) {
                this.f1464d = true;
                this.f1468h = true;
                this.f1461a = iconCompat;
                this.f1462b = Builder.a(charSequence);
                this.f1463c = pendingIntent;
                this.f1465e = bundle;
                this.f1466f = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.f1464d = z;
                this.f1467g = i2;
                this.f1468h = z2;
                this.f1469i = z3;
            }
        }

        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {

            /* renamed from: a */
            private static final String f1470a = "android.wearable.EXTENSIONS";

            /* renamed from: b */
            private static final String f1471b = "flags";

            /* renamed from: c */
            private static final String f1472c = "inProgressLabel";

            /* renamed from: d */
            private static final String f1473d = "confirmLabel";

            /* renamed from: e */
            private static final String f1474e = "cancelLabel";

            /* renamed from: f */
            private static final int f1475f = 1;

            /* renamed from: g */
            private static final int f1476g = 2;

            /* renamed from: h */
            private static final int f1477h = 4;

            /* renamed from: i */
            private static final int f1478i = 1;

            /* renamed from: j */
            private int f1479j;
            private CharSequence k;
            private CharSequence l;
            private CharSequence m;

            public WearableExtender() {
                this.f1479j = 1;
            }

            private void a(int i2, boolean z) {
                if (z) {
                    this.f1479j = i2 | this.f1479j;
                } else {
                    this.f1479j = (i2 ^ (-1)) & this.f1479j;
                }
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i2 = this.f1479j;
                if (i2 != 1) {
                    bundle.putInt(f1471b, i2);
                }
                CharSequence charSequence = this.k;
                if (charSequence != null) {
                    bundle.putCharSequence(f1472c, charSequence);
                }
                CharSequence charSequence2 = this.l;
                if (charSequence2 != null) {
                    bundle.putCharSequence(f1473d, charSequence2);
                }
                CharSequence charSequence3 = this.m;
                if (charSequence3 != null) {
                    bundle.putCharSequence(f1474e, charSequence3);
                }
                builder.getExtras().putBundle(f1470a, bundle);
                return builder;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.m;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.l;
            }

            public boolean getHintDisplayActionInline() {
                return (this.f1479j & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.f1479j & 2) != 0;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.k;
            }

            public boolean isAvailableOffline() {
                return (this.f1479j & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                a(1, z);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.m = charSequence;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.l = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                a(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                a(2, z);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.k = charSequence;
                return this;
            }

            /* renamed from: clone */
            public WearableExtender m33clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f1479j = this.f1479j;
                wearableExtender.k = this.k;
                wearableExtender.l = this.l;
                wearableExtender.m = this.m;
                return wearableExtender;
            }

            public WearableExtender(Action action) {
                this.f1479j = 1;
                Bundle bundle = action.getExtras().getBundle(f1470a);
                if (bundle != null) {
                    this.f1479j = bundle.getInt(f1471b, 1);
                    this.k = bundle.getCharSequence(f1472c);
                    this.l = bundle.getCharSequence(f1473d);
                    this.m = bundle.getCharSequence(f1474e);
                }
            }
        }

        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f1457g;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.f1456f;
        }

        public Bundle getExtras() {
            return this.f1453c;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            int i2;
            if (this.f1454d == null && (i2 = this.icon) != 0) {
                this.f1454d = IconCompat.createWithResource(null, "", i2);
            }
            return this.f1454d;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.f1455e;
        }

        public int getSemanticAction() {
            return this.f1459i;
        }

        public boolean getShowsUserInterface() {
            return this.f1458h;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.f1460j;
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false);
        }

        Action(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i3, boolean z2, boolean z3) {
            this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i3, z2, z3);
        }

        Action(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f1458h = true;
            this.f1454d = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.a(charSequence);
            this.actionIntent = pendingIntent;
            this.f1453c = bundle == null ? new Bundle() : bundle;
            this.f1455e = remoteInputArr;
            this.f1456f = remoteInputArr2;
            this.f1457g = z;
            this.f1459i = i2;
            this.f1458h = z2;
            this.f1460j = z3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {

        /* renamed from: e */
        private Bitmap f1480e;

        /* renamed from: f */
        private Bitmap f1481f;

        /* renamed from: g */
        private boolean f1482g;

        public BigPictureStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f1547b).bigPicture(this.f1480e);
                if (this.f1482g) {
                    bigPicture.bigLargeIcon(this.f1481f);
                }
                if (this.f1549d) {
                    bigPicture.setSummaryText(this.f1548c);
                }
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.f1481f = bitmap;
            this.f1482g = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.f1480e = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.f1547b = Builder.a(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.f1548c = Builder.a(charSequence);
            this.f1549d = true;
            return this;
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: e */
        private CharSequence f1483e;

        public BigTextStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f1547b).bigText(this.f1483e);
                if (this.f1549d) {
                    bigText.setSummaryText(this.f1548c);
                }
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.f1483e = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.f1547b = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.f1548c = Builder.a(charSequence);
            this.f1549d = true;
            return this;
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static final class BubbleMetadata {

        /* renamed from: a */
        private static final int f1484a = 1;

        /* renamed from: b */
        private static final int f1485b = 2;

        /* renamed from: c */
        private PendingIntent f1486c;

        /* renamed from: d */
        private PendingIntent f1487d;

        /* renamed from: e */
        private IconCompat f1488e;

        /* renamed from: f */
        private int f1489f;

        /* renamed from: g */
        @DimenRes
        private int f1490g;

        /* renamed from: h */
        private int f1491h;

        public static final class Builder {

            /* renamed from: a */
            private PendingIntent f1492a;

            /* renamed from: b */
            private IconCompat f1493b;

            /* renamed from: c */
            private int f1494c;

            /* renamed from: d */
            @DimenRes
            private int f1495d;

            /* renamed from: e */
            private int f1496e;

            /* renamed from: f */
            private PendingIntent f1497f;

            private Builder a(int i2, boolean z) {
                if (z) {
                    this.f1496e = i2 | this.f1496e;
                } else {
                    this.f1496e = (i2 ^ (-1)) & this.f1496e;
                }
                return this;
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                PendingIntent pendingIntent = this.f1492a;
                if (pendingIntent == null) {
                    throw new IllegalStateException("Must supply pending intent to bubble");
                }
                IconCompat iconCompat = this.f1493b;
                if (iconCompat != null) {
                    return new BubbleMetadata(pendingIntent, this.f1497f, iconCompat, this.f1494c, this.f1495d, this.f1496e);
                }
                throw new IllegalStateException("Must supply an icon for the bubble");
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z) {
                a(1, z);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                this.f1497f = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i2) {
                this.f1494c = Math.max(i2, 0);
                this.f1495d = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i2) {
                this.f1495d = i2;
                this.f1494c = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                if (iconCompat == null) {
                    throw new IllegalArgumentException("Bubbles require non-null icon");
                }
                if (iconCompat.getType() == 1) {
                    throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
                }
                this.f1493b = iconCompat;
                return this;
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                if (pendingIntent == null) {
                    throw new IllegalArgumentException("Bubble requires non-null pending intent");
                }
                this.f1492a = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setSuppressNotification(boolean z) {
                a(2, z);
                return this;
            }
        }

        /* synthetic */ BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i2, int i3, int i4, AnonymousClass1 anonymousClass1) {
            this(pendingIntent, pendingIntent2, iconCompat, i2, i3, i4);
        }

        @Nullable
        @RequiresApi(29)
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Builder suppressNotification = new Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(bubbleMetadata.getIcon())).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        @Nullable
        @RequiresApi(29)
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        public boolean getAutoExpandBubble() {
            return (this.f1491h & 1) != 0;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.f1487d;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.f1489f;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.f1490g;
        }

        @NonNull
        public IconCompat getIcon() {
            return this.f1488e;
        }

        @NonNull
        public PendingIntent getIntent() {
            return this.f1486c;
        }

        public boolean isNotificationSuppressed() {
            return (this.f1491h & 2) != 0;
        }

        private BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i2, @DimenRes int i3, int i4) {
            this.f1486c = pendingIntent;
            this.f1488e = iconCompat;
            this.f1489f = i2;
            this.f1490g = i3;
            this.f1487d = pendingIntent2;
            this.f1491h = i4;
        }
    }

    public static class Builder {

        /* renamed from: a */
        private static final int f1498a = 5120;
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        BubbleMetadata O;
        Notification P;
        boolean Q;

        /* renamed from: b */
        ArrayList<Action> f1499b;

        /* renamed from: c */
        CharSequence f1500c;

        /* renamed from: d */
        CharSequence f1501d;

        /* renamed from: e */
        PendingIntent f1502e;

        /* renamed from: f */
        PendingIntent f1503f;

        /* renamed from: g */
        RemoteViews f1504g;

        /* renamed from: h */
        Bitmap f1505h;

        /* renamed from: i */
        CharSequence f1506i;

        /* renamed from: j */
        int f1507j;
        int k;
        boolean l;
        boolean m;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;

        @Deprecated
        public ArrayList<String> mPeople;
        boolean n;
        Style o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.f1499b = new ArrayList<>();
            this.l = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            Notification notification = new Notification();
            this.P = notification;
            this.mContext = context;
            this.I = str;
            notification.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.k = 0;
            this.mPeople = new ArrayList<>();
            this.N = true;
        }

        protected static CharSequence a(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > f1498a) ? charSequence.subSequence(0, f1498a) : charSequence;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = dimensionPixelSize;
            double max = Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = dimensionPixelSize2;
            double max2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int ceil = (int) Math.ceil(width * min);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * min), true);
        }

        private void c(int i2, boolean z) {
            if (z) {
                Notification notification = this.P;
                notification.flags = i2 | notification.flags;
            } else {
                Notification notification2 = this.P;
                notification2.flags = (i2 ^ (-1)) & notification2.flags;
            }
        }

        public Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.B;
                if (bundle2 == null) {
                    this.B = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return addInvisibleAction(new Action(i2, charSequence, pendingIntent));
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.G;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.O;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.C;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.F;
        }

        public Bundle getExtras() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.H;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.k;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.l) {
                return this.P.when;
            }
            return 0L;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z) {
            this.N = z;
            return this;
        }

        public Builder setAutoCancel(boolean z) {
            c(16, z);
            return this;
        }

        public Builder setBadgeIconType(int i2) {
            this.J = i2;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            this.O = bubbleMetadata;
            return this;
        }

        public Builder setCategory(String str) {
            this.A = str;
            return this;
        }

        public Builder setChannelId(@NonNull String str) {
            this.I = str;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean z) {
            this.n = z;
            this.B.putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
            return this;
        }

        public Builder setColor(@ColorInt int i2) {
            this.C = i2;
            return this;
        }

        public Builder setColorized(boolean z) {
            this.y = z;
            this.z = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.P.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.f1506i = a(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.f1502e = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.f1501d = a(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.f1500c = a(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.G = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.F = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.H = remoteViews;
            return this;
        }

        public Builder setDefaults(int i2) {
            Notification notification = this.P;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.B = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.f1503f = pendingIntent;
            c(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.u = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i2) {
            this.M = i2;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.v = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.f1505h = b(bitmap);
            return this;
        }

        public Builder setLights(@ColorInt int i2, int i3, int i4) {
            Notification notification = this.P;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.x = z;
            return this;
        }

        @NonNull
        public Builder setNotificationSilent() {
            this.Q = true;
            return this;
        }

        public Builder setNumber(int i2) {
            this.f1507j = i2;
            return this;
        }

        public Builder setOngoing(boolean z) {
            c(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            c(8, z);
            return this;
        }

        public Builder setPriority(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setProgress(int i2, int i3, boolean z) {
            this.r = i2;
            this.s = i3;
            this.t = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.E = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.q = charSequenceArr;
            return this;
        }

        public Builder setShortcutId(String str) {
            this.K = str;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setSmallIcon(int i2) {
            this.P.icon = i2;
            return this;
        }

        public Builder setSortKey(String str) {
            this.w = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.o != style) {
                this.o = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.p = a(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.P.tickerText = a(charSequence);
            return this;
        }

        public Builder setTimeoutAfter(long j2) {
            this.L = j2;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.P.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i2) {
            this.D = i2;
            return this;
        }

        public Builder setWhen(long j2) {
            this.P.when = j2;
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(Action action) {
            this.f1499b.add(action);
            return this;
        }

        public Builder setSmallIcon(int i2, int i3) {
            Notification notification = this.P;
            notification.icon = i2;
            notification.iconLevel = i3;
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.P.tickerText = a(charSequence);
            this.f1504g = remoteViews;
            return this;
        }

        public Builder setSound(Uri uri, int i2) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = i2;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i2).build();
            }
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }
    }

    public static class DecoratedCustomViewStyle extends Style {

        /* renamed from: e */
        private static final int f1530e = 3;

        private RemoteViews i(RemoteViews remoteViews, boolean z) {
            int min;
            boolean z2 = true;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(R.id.actions);
            List<Action> k = k(this.f1546a.mActions);
            if (!z || k == null || (min = Math.min(k.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i2 = 0; i2 < min; i2++) {
                    applyStandardTemplate.addView(R.id.actions, j(k.get(i2)));
                }
            }
            int i3 = z2 ? 0 : 8;
            applyStandardTemplate.setViewVisibility(R.id.actions, i3);
            applyStandardTemplate.setViewVisibility(R.id.action_divider, i3);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private RemoteViews j(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.f1546a.mContext.getPackageName(), z ? R.layout.notification_action_tombstone : R.layout.notification_action);
            remoteViews.setImageViewBitmap(R.id.action_image, d(action.getIconCompat(), this.f1546a.mContext.getResources().getColor(R.color.notification_action_color_filter)));
            remoteViews.setTextViewText(R.id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.action_container, action.title);
            }
            return remoteViews;
        }

        private static List<Action> k(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action action : list) {
                if (!action.isContextual()) {
                    arrayList.add(action);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.f1546a.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.f1546a.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return i(bigContentView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.f1546a.getContentView() != null) {
                return i(this.f1546a.getContentView(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.f1546a.getHeadsUpContentView();
            RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.f1546a.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            return i(contentView, true);
        }
    }

    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StreamType {
    }

    public static abstract class Style {

        /* renamed from: a */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder f1546a;

        /* renamed from: b */
        CharSequence f1547b;

        /* renamed from: c */
        CharSequence f1548c;

        /* renamed from: d */
        boolean f1549d = false;

        private int a() {
            Resources resources = this.f1546a.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float b2 = (b(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - b2) * dimensionPixelSize) + (b2 * dimensionPixelSize2));
        }

        private static float b(float f2, float f3, float f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }

        private Bitmap c(int i2, int i3, int i4) {
            return e(IconCompat.createWithResource(this.f1546a.mContext, i2), i3, i4);
        }

        private Bitmap e(IconCompat iconCompat, int i2, int i3) {
            Drawable loadDrawable = iconCompat.loadDrawable(this.f1546a.mContext);
            int intrinsicWidth = i3 == 0 ? loadDrawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        private Bitmap f(int i2, int i3, int i4, int i5) {
            int i6 = R.drawable.notification_icon_background;
            if (i5 == 0) {
                i5 = 0;
            }
            Bitmap c2 = c(i6, i5, i3);
            Canvas canvas = new Canvas(c2);
            Drawable mutate = this.f1546a.mContext.getResources().getDrawable(i2).mutate();
            mutate.setFilterBitmap(true);
            int i7 = (i3 - i4) / 2;
            int i8 = i4 + i7;
            mutate.setBounds(i7, i7, i8, i8);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return c2;
        }

        private void g(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0189 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01fc  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0181  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.widget.RemoteViews applyStandardTemplate(boolean r17, int r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 524
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Notification build() {
            Builder builder = this.f1546a;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            g(remoteViews);
            int i2 = R.id.notification_main_column;
            remoteViews.removeAllViews(i2);
            remoteViews.addView(i2, remoteViews2.clone());
            remoteViews.setViewVisibility(i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(R.id.notification_main_column_container, 0, a(), 0, 0);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i2, int i3) {
            return c(i2, i3, 0);
        }

        Bitmap d(IconCompat iconCompat, int i2) {
            return e(iconCompat, i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void h(Bundle bundle) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void setBuilder(Builder builder) {
            if (this.f1546a != builder) {
                this.f1546a = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    public static final class WearableExtender implements Extender {

        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;

        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;

        @Deprecated
        public static final int SIZE_DEFAULT = 0;

        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;

        @Deprecated
        public static final int SIZE_LARGE = 4;

        @Deprecated
        public static final int SIZE_MEDIUM = 3;

        @Deprecated
        public static final int SIZE_SMALL = 2;

        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a */
        private static final String f1550a = "android.wearable.EXTENSIONS";

        /* renamed from: b */
        private static final String f1551b = "actions";

        /* renamed from: c */
        private static final String f1552c = "flags";

        /* renamed from: d */
        private static final String f1553d = "displayIntent";

        /* renamed from: e */
        private static final String f1554e = "pages";

        /* renamed from: f */
        private static final String f1555f = "background";

        /* renamed from: g */
        private static final String f1556g = "contentIcon";

        /* renamed from: h */
        private static final String f1557h = "contentIconGravity";

        /* renamed from: i */
        private static final String f1558i = "contentActionIndex";

        /* renamed from: j */
        private static final String f1559j = "customSizePreset";
        private static final String k = "customContentHeight";
        private static final String l = "gravity";
        private static final String m = "hintScreenTimeout";
        private static final String n = "dismissalId";
        private static final String o = "bridgeTag";
        private static final int p = 1;
        private static final int q = 2;
        private static final int r = 4;
        private static final int s = 8;
        private static final int t = 16;
        private static final int u = 32;
        private static final int v = 64;
        private static final int w = 1;
        private static final int x = 8388613;
        private static final int y = 80;
        private int A;
        private PendingIntent B;
        private ArrayList<Notification> C;
        private Bitmap D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private int K;
        private String L;
        private String M;
        private ArrayList<Action> z;

        public WearableExtender() {
            this.z = new ArrayList<>();
            this.A = 1;
            this.C = new ArrayList<>();
            this.F = 8388613;
            this.G = -1;
            this.H = 0;
            this.J = 80;
        }

        @RequiresApi(20)
        private static Notification.Action a(Action action) {
            Notification.Action.Builder builder;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                IconCompat iconCompat = action.getIconCompat();
                builder = new Notification.Action.Builder(iconCompat == null ? null : iconCompat.toIcon(), action.getTitle(), action.getActionIntent());
            } else {
                IconCompat iconCompat2 = action.getIconCompat();
                builder = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), action.getTitle(), action.getActionIntent());
            }
            Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (i2 >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (android.app.RemoteInput remoteInput : RemoteInput.b(remoteInputs)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            return builder.build();
        }

        private void b(int i2, boolean z) {
            if (z) {
                this.A = i2 | this.A;
            } else {
                this.A = (i2 ^ (-1)) & this.A;
            }
        }

        public WearableExtender addAction(Action action) {
            this.z.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.z.addAll(list);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification notification) {
            this.C.add(notification);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> list) {
            this.C.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.z.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.C.clear();
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.z.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 16) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.z.size());
                    Iterator<Action> it = this.z.iterator();
                    while (it.hasNext()) {
                        Action next = it.next();
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 20) {
                            arrayList.add(a(next));
                        } else if (i2 >= 16) {
                            arrayList.add(NotificationCompatJellybean.g(next));
                        }
                    }
                    bundle.putParcelableArrayList(f1551b, arrayList);
                } else {
                    bundle.putParcelableArrayList(f1551b, null);
                }
            }
            int i3 = this.A;
            if (i3 != 1) {
                bundle.putInt(f1552c, i3);
            }
            PendingIntent pendingIntent = this.B;
            if (pendingIntent != null) {
                bundle.putParcelable(f1553d, pendingIntent);
            }
            if (!this.C.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.C;
                bundle.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.D;
            if (bitmap != null) {
                bundle.putParcelable(f1555f, bitmap);
            }
            int i4 = this.E;
            if (i4 != 0) {
                bundle.putInt(f1556g, i4);
            }
            int i5 = this.F;
            if (i5 != 8388613) {
                bundle.putInt(f1557h, i5);
            }
            int i6 = this.G;
            if (i6 != -1) {
                bundle.putInt(f1558i, i6);
            }
            int i7 = this.H;
            if (i7 != 0) {
                bundle.putInt(f1559j, i7);
            }
            int i8 = this.I;
            if (i8 != 0) {
                bundle.putInt(k, i8);
            }
            int i9 = this.J;
            if (i9 != 80) {
                bundle.putInt(l, i9);
            }
            int i10 = this.K;
            if (i10 != 0) {
                bundle.putInt(m, i10);
            }
            String str = this.L;
            if (str != null) {
                bundle.putString(n, str);
            }
            String str2 = this.M;
            if (str2 != null) {
                bundle.putString(o, str2);
            }
            builder.getExtras().putBundle(f1550a, bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.z;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.D;
        }

        public String getBridgeTag() {
            return this.M;
        }

        public int getContentAction() {
            return this.G;
        }

        @Deprecated
        public int getContentIcon() {
            return this.E;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.F;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.A & 1) != 0;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.I;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.H;
        }

        public String getDismissalId() {
            return this.L;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.B;
        }

        @Deprecated
        public int getGravity() {
            return this.J;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.A & 32) != 0;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.A & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.A & 64) != 0;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.A & 2) != 0;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.K;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.A & 4) != 0;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.C;
        }

        public boolean getStartScrollBottom() {
            return (this.A & 8) != 0;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap bitmap) {
            this.D = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.M = str;
            return this;
        }

        public WearableExtender setContentAction(int i2) {
            this.G = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int i2) {
            this.E = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int i2) {
            this.F = i2;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            b(1, z);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int i2) {
            this.I = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int i2) {
            this.H = i2;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.L = str;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.B = pendingIntent;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int i2) {
            this.J = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            b(32, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            b(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            b(64, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            b(2, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int i2) {
            this.K = i2;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            b(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            b(8, z);
            return this;
        }

        /* renamed from: clone */
        public WearableExtender m34clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.z = new ArrayList<>(this.z);
            wearableExtender.A = this.A;
            wearableExtender.B = this.B;
            wearableExtender.C = new ArrayList<>(this.C);
            wearableExtender.D = this.D;
            wearableExtender.E = this.E;
            wearableExtender.F = this.F;
            wearableExtender.G = this.G;
            wearableExtender.H = this.H;
            wearableExtender.I = this.I;
            wearableExtender.J = this.J;
            wearableExtender.K = this.K;
            wearableExtender.L = this.L;
            wearableExtender.M = this.M;
            return wearableExtender;
        }

        public WearableExtender(Notification notification) {
            this.z = new ArrayList<>();
            this.A = 1;
            this.C = new ArrayList<>();
            this.F = 8388613;
            this.G = -1;
            this.H = 0;
            this.J = 80;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle(f1550a) : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(f1551b);
                if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 >= 20) {
                            actionArr[i2] = NotificationCompat.a((Notification.Action) parcelableArrayList.get(i2));
                        } else if (i3 >= 16) {
                            actionArr[i2] = NotificationCompatJellybean.d((Bundle) parcelableArrayList.get(i2));
                        }
                    }
                    Collections.addAll(this.z, actionArr);
                }
                this.A = bundle.getInt(f1552c, 1);
                this.B = (PendingIntent) bundle.getParcelable(f1553d);
                Notification[] b2 = NotificationCompat.b(bundle, "pages");
                if (b2 != null) {
                    Collections.addAll(this.C, b2);
                }
                this.D = (Bitmap) bundle.getParcelable(f1555f);
                this.E = bundle.getInt(f1556g);
                this.F = bundle.getInt(f1557h, 8388613);
                this.G = bundle.getInt(f1558i, -1);
                this.H = bundle.getInt(f1559j, 0);
                this.I = bundle.getInt(k);
                this.J = bundle.getInt(l, 80);
                this.K = bundle.getInt(m);
                this.L = bundle.getString(n);
                this.M = bundle.getString(o);
            }
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    @RequiresApi(20)
    static Action a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        int i2;
        android.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i3 = 0; i3 < remoteInputs.length; i3++) {
                android.app.RemoteInput remoteInput = remoteInputs[i3];
                remoteInputArr2[i3] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i4 = Build.VERSION.SDK_INT;
        boolean z = i4 >= 24 ? action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies() : action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        boolean z2 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int semanticAction = i4 >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0);
        boolean isContextual = i4 >= 29 ? action.isContextual() : false;
        if (i4 < 23) {
            return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
        }
        if (action.getIcon() != null || (i2 = action.icon) == 0) {
            return new Action(action.getIcon() != null ? IconCompat.createFromIconOrNullIfZeroResId(action.getIcon()) : null, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
        }
        return new Action(i2, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
    }

    static Notification[] b(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i2 = 0; i2 < parcelableArray.length; i2++) {
            notificationArr[i2] = (Notification) parcelableArray[i2];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static Action getAction(Notification notification, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 20) {
            return a(notification.actions[i2]);
        }
        if (i3 >= 19) {
            Notification.Action action = notification.actions[i2];
            SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, sparseParcelableArray != null ? (Bundle) sparseParcelableArray.get(i2) : null);
        }
        if (i3 >= 16) {
            return NotificationCompatJellybean.getAction(notification, i2);
        }
        return null;
    }

    public static int getActionCount(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            if (i2 >= 16) {
                return NotificationCompatJellybean.getActionCount(notification);
            }
            return 0;
        }
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    @RequiresApi(19)
    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static String getGroup(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return notification.getGroup();
        }
        if (i2 >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    @RequiresApi(21)
    public static List<Action> getInvisibleActions(Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle2 != null && (bundle = bundle2.getBundle("invisible_actions")) != null) {
            for (int i2 = 0; i2 < bundle.size(); i2++) {
                arrayList.add(NotificationCompatJellybean.d(bundle.getBundle(Integer.toString(i2))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return (notification.flags & 256) != 0;
        }
        if (i2 >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        return false;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static String getSortKey(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return notification.getSortKey();
        }
        if (i2 >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    public static boolean isGroupSummary(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return (notification.flags & 512) != 0;
        }
        if (i2 >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        return false;
    }

    public static final class CarExtender implements Extender {

        /* renamed from: a */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String f1508a = "android.car.EXTENSIONS";

        /* renamed from: b */
        private static final String f1509b = "large_icon";

        /* renamed from: c */
        private static final String f1510c = "car_conversation";

        /* renamed from: d */
        private static final String f1511d = "app_color";

        /* renamed from: e */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String f1512e = "invisible_actions";

        /* renamed from: f */
        private static final String f1513f = "author";

        /* renamed from: g */
        private static final String f1514g = "text";

        /* renamed from: h */
        private static final String f1515h = "messages";

        /* renamed from: i */
        private static final String f1516i = "remote_input";

        /* renamed from: j */
        private static final String f1517j = "on_reply";
        private static final String k = "on_read";
        private static final String l = "participants";
        private static final String m = "timestamp";
        private Bitmap n;
        private UnreadConversation o;
        private int p;

        @Deprecated
        public static class UnreadConversation {

            /* renamed from: a */
            private final String[] f1518a;

            /* renamed from: b */
            private final RemoteInput f1519b;

            /* renamed from: c */
            private final PendingIntent f1520c;

            /* renamed from: d */
            private final PendingIntent f1521d;

            /* renamed from: e */
            private final String[] f1522e;

            /* renamed from: f */
            private final long f1523f;

            public static class Builder {

                /* renamed from: a */
                private final List<String> f1524a = new ArrayList();

                /* renamed from: b */
                private final String f1525b;

                /* renamed from: c */
                private RemoteInput f1526c;

                /* renamed from: d */
                private PendingIntent f1527d;

                /* renamed from: e */
                private PendingIntent f1528e;

                /* renamed from: f */
                private long f1529f;

                public Builder(String str) {
                    this.f1525b = str;
                }

                public Builder addMessage(String str) {
                    this.f1524a.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.f1524a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.f1526c, this.f1528e, this.f1527d, new String[]{this.f1525b}, this.f1529f);
                }

                public Builder setLatestTimestamp(long j2) {
                    this.f1529f = j2;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.f1527d = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.f1526c = remoteInput;
                    this.f1528e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j2) {
                this.f1518a = strArr;
                this.f1519b = remoteInput;
                this.f1521d = pendingIntent2;
                this.f1520c = pendingIntent;
                this.f1522e = strArr2;
                this.f1523f = j2;
            }

            public long getLatestTimestamp() {
                return this.f1523f;
            }

            public String[] getMessages() {
                return this.f1518a;
            }

            public String getParticipant() {
                String[] strArr = this.f1522e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.f1522e;
            }

            public PendingIntent getReadPendingIntent() {
                return this.f1521d;
            }

            public RemoteInput getRemoteInput() {
                return this.f1519b;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.f1520c;
            }
        }

        public CarExtender() {
            this.p = 0;
        }

        @RequiresApi(21)
        private static Bundle a(@NonNull UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            int length = unreadConversation.getMessages().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i2 = 0; i2 < length; i2++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i2]);
                bundle2.putString(f1513f, str);
                parcelableArr[i2] = bundle2;
            }
            bundle.putParcelableArray(f1515h, parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable(f1516i, new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable(f1517j, unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(k, unreadConversation.getReadPendingIntent());
            bundle.putStringArray(l, unreadConversation.getParticipants());
            bundle.putLong(m, unreadConversation.getLatestTimestamp());
            return bundle;
        }

        @RequiresApi(21)
        private static UnreadConversation b(@Nullable Bundle bundle) {
            String[] strArr;
            boolean z;
            if (bundle == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(f1515h);
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    if (parcelableArray[i2] instanceof Bundle) {
                        strArr2[i2] = ((Bundle) parcelableArray[i2]).getString("text");
                        if (strArr2[i2] != null) {
                        }
                    }
                    z = false;
                    break;
                }
                z = true;
                if (!z) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(k);
            PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(f1517j);
            android.app.RemoteInput remoteInput = (android.app.RemoteInput) bundle.getParcelable(f1516i);
            String[] stringArray = bundle.getStringArray(l);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            return new UnreadConversation(strArr, remoteInput != null ? new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null) : null, pendingIntent2, pendingIntent, stringArray, bundle.getLong(m));
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.n;
            if (bitmap != null) {
                bundle.putParcelable(f1509b, bitmap);
            }
            int i2 = this.p;
            if (i2 != 0) {
                bundle.putInt(f1511d, i2);
            }
            UnreadConversation unreadConversation = this.o;
            if (unreadConversation != null) {
                bundle.putBundle(f1510c, a(unreadConversation));
            }
            builder.getExtras().putBundle(f1508a, bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.p;
        }

        public Bitmap getLargeIcon() {
            return this.n;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.o;
        }

        public CarExtender setColor(@ColorInt int i2) {
            this.p = i2;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.n = bitmap;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.o = unreadConversation;
            return this;
        }

        public CarExtender(Notification notification) {
            this.p = 0;
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle(f1508a);
            if (bundle != null) {
                this.n = (Bitmap) bundle.getParcelable(f1509b);
                this.p = bundle.getInt(f1511d, 0);
                this.o = b(bundle.getBundle(f1510c));
            }
        }
    }

    public static class InboxStyle extends Style {

        /* renamed from: e */
        private ArrayList<CharSequence> f1531e = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.f1531e.add(Builder.a(charSequence));
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f1547b);
                if (this.f1549d) {
                    bigContentTitle.setSummaryText(this.f1548c);
                }
                Iterator<CharSequence> it = this.f1531e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.f1547b = Builder.a(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.f1548c = Builder.a(charSequence);
            this.f1549d = true;
            return this;
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;

        /* renamed from: e */
        private final List<Message> f1532e = new ArrayList();

        /* renamed from: f */
        private Person f1533f;

        /* renamed from: g */
        @Nullable
        private CharSequence f1534g;

        /* renamed from: h */
        @Nullable
        private Boolean f1535h;

        private MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) && !extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                return null;
            }
            try {
                MessagingStyle messagingStyle = new MessagingStyle();
                messagingStyle.h(extras);
                return messagingStyle;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @Nullable
        private Message i() {
            for (int size = this.f1532e.size() - 1; size >= 0; size--) {
                Message message = this.f1532e.get(size);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (this.f1532e.isEmpty()) {
                return null;
            }
            return this.f1532e.get(r0.size() - 1);
        }

        private boolean j() {
            for (int size = this.f1532e.size() - 1; size >= 0; size--) {
                Message message = this.f1532e.get(size);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        private TextAppearanceSpan k(int i2) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i2), null);
        }

        private CharSequence l(Message message) {
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = Build.VERSION.SDK_INT >= 21;
            int i2 = z ? -16777216 : -1;
            CharSequence name = message.getPerson() == null ? "" : message.getPerson().getName();
            if (TextUtils.isEmpty(name)) {
                name = this.f1533f.getName();
                if (z && this.f1546a.getColor() != 0) {
                    i2 = this.f1546a.getColor();
                }
            }
            CharSequence unicodeWrap = bidiFormatter.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(k(i2), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() != null ? message.getText() : ""));
            return spannableStringBuilder;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.f1533f.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.f1533f.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.f1534g);
            if (this.f1534g != null && this.f1535h.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.f1534g);
            }
            if (!this.f1532e.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.a(this.f1532e));
            }
            Boolean bool = this.f1535h;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long j2, CharSequence charSequence2) {
            this.f1532e.add(new Message(charSequence, j2, new Person.Builder().setName(charSequence2).build()));
            if (this.f1532e.size() > 25) {
                this.f1532e.remove(0);
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.MessagingStyle.Message message;
            setGroupConversation(isGroupConversation());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                Notification.MessagingStyle messagingStyle = i2 >= 28 ? new Notification.MessagingStyle(this.f1533f.toAndroidPerson()) : new Notification.MessagingStyle(this.f1533f.getName());
                if (this.f1535h.booleanValue() || i2 >= 28) {
                    messagingStyle.setConversationTitle(this.f1534g);
                }
                if (i2 >= 28) {
                    messagingStyle.setGroupConversation(this.f1535h.booleanValue());
                }
                for (Message message2 : this.f1532e) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        Person person = message2.getPerson();
                        message = new Notification.MessagingStyle.Message(message2.getText(), message2.getTimestamp(), person == null ? null : person.toAndroidPerson());
                    } else {
                        message = new Notification.MessagingStyle.Message(message2.getText(), message2.getTimestamp(), message2.getPerson() != null ? message2.getPerson().getName() : null);
                    }
                    if (message2.getDataMimeType() != null) {
                        message.setData(message2.getDataMimeType(), message2.getDataUri());
                    }
                    messagingStyle.addMessage(message);
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message i3 = i();
            if (this.f1534g != null && this.f1535h.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.f1534g);
            } else if (i3 != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (i3.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(i3.getPerson().getName());
                }
            }
            if (i3 != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.f1534g != null ? l(i3) : i3.getText());
            }
            if (i2 >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = this.f1534g != null || j();
                for (int size = this.f1532e.size() - 1; size >= 0; size--) {
                    Message message3 = this.f1532e.get(size);
                    CharSequence l = z ? l(message3) : message3.getText();
                    if (size != this.f1532e.size() - 1) {
                        spannableStringBuilder.insert(0, (CharSequence) "\n");
                    }
                    spannableStringBuilder.insert(0, l);
                }
                new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.f1534g;
        }

        public List<Message> getMessages() {
            return this.f1532e;
        }

        public Person getUser() {
            return this.f1533f;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.f1533f.getName();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void h(Bundle bundle) {
            this.f1532e.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.f1533f = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.f1533f = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.f1534g = charSequence;
            if (charSequence == null) {
                this.f1534g = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.f1532e.addAll(Message.c(parcelableArray));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.f1535h = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        public boolean isGroupConversation() {
            Builder builder = this.f1546a;
            if (builder != null && builder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.f1535h == null) {
                return this.f1534g != null;
            }
            Boolean bool = this.f1535h;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            this.f1534g = charSequence;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean z) {
            this.f1535h = Boolean.valueOf(z);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.f1533f = new Person.Builder().setName(charSequence).build();
        }

        public static final class Message {

            /* renamed from: a */
            static final String f1536a = "text";

            /* renamed from: b */
            static final String f1537b = "time";

            /* renamed from: c */
            static final String f1538c = "sender";

            /* renamed from: d */
            static final String f1539d = "type";

            /* renamed from: e */
            static final String f1540e = "uri";

            /* renamed from: f */
            static final String f1541f = "extras";

            /* renamed from: g */
            static final String f1542g = "person";

            /* renamed from: h */
            static final String f1543h = "sender_person";

            /* renamed from: i */
            private final CharSequence f1544i;

            /* renamed from: j */
            private final long f1545j;

            @Nullable
            private final Person k;
            private Bundle l;

            @Nullable
            private String m;

            @Nullable
            private Uri n;

            public Message(CharSequence charSequence, long j2, @Nullable Person person) {
                this.l = new Bundle();
                this.f1544i = charSequence;
                this.f1545j = j2;
                this.k = person;
            }

            @NonNull
            static Bundle[] a(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bundleArr[i2] = list.get(i2).d();
                }
                return bundleArr;
            }

            @Nullable
            static Message b(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey(f1542g) ? Person.fromBundle(bundle.getBundle(f1542g)) : (!bundle.containsKey(f1543h) || Build.VERSION.SDK_INT < 28) ? bundle.containsKey(f1538c) ? new Person.Builder().setName(bundle.getCharSequence(f1538c)).build() : null : Person.fromAndroidPerson((android.app.Person) bundle.getParcelable(f1543h)));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            message.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey(f1541f)) {
                            message.getExtras().putAll(bundle.getBundle(f1541f));
                        }
                        return message;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @NonNull
            static List<Message> c(Parcelable[] parcelableArr) {
                Message b2;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i2 = 0; i2 < parcelableArr.length; i2++) {
                    if ((parcelableArr[i2] instanceof Bundle) && (b2 = b((Bundle) parcelableArr[i2])) != null) {
                        arrayList.add(b2);
                    }
                }
                return arrayList;
            }

            private Bundle d() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f1544i;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f1545j);
                Person person = this.k;
                if (person != null) {
                    bundle.putCharSequence(f1538c, person.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(f1543h, this.k.toAndroidPerson());
                    } else {
                        bundle.putBundle(f1542g, this.k.toBundle());
                    }
                }
                String str = this.m;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.n;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.l;
                if (bundle2 != null) {
                    bundle.putBundle(f1541f, bundle2);
                }
                return bundle;
            }

            @Nullable
            public String getDataMimeType() {
                return this.m;
            }

            @Nullable
            public Uri getDataUri() {
                return this.n;
            }

            @NonNull
            public Bundle getExtras() {
                return this.l;
            }

            @Nullable
            public Person getPerson() {
                return this.k;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                Person person = this.k;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @NonNull
            public CharSequence getText() {
                return this.f1544i;
            }

            public long getTimestamp() {
                return this.f1545j;
            }

            public Message setData(String str, Uri uri) {
                this.m = str;
                this.n = uri;
                return this;
            }

            @Deprecated
            public Message(CharSequence charSequence, long j2, CharSequence charSequence2) {
                this(charSequence, j2, new Person.Builder().setName(charSequence2).build());
            }
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.getName())) {
                this.f1533f = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j2, Person person) {
            addMessage(new Message(charSequence, j2, person));
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            this.f1532e.add(message);
            if (this.f1532e.size() > 25) {
                this.f1532e.remove(0);
            }
            return this;
        }
    }
}
