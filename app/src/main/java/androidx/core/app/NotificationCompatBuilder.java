package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a */
    private final Notification.Builder f1560a;

    /* renamed from: b */
    private final NotificationCompat.Builder f1561b;

    /* renamed from: c */
    private RemoteViews f1562c;

    /* renamed from: d */
    private RemoteViews f1563d;

    /* renamed from: e */
    private final List<Bundle> f1564e = new ArrayList();

    /* renamed from: f */
    private final Bundle f1565f = new Bundle();

    /* renamed from: g */
    private int f1566g;

    /* renamed from: h */
    private RemoteViews f1567h;

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        ArrayList<String> arrayList;
        this.f1561b = builder;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1560a = new Notification.Builder(builder.mContext, builder.I);
        } else {
            this.f1560a = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.P;
        this.f1560a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f1504g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f1500c).setContentText(builder.f1501d).setContentInfo(builder.f1506i).setContentIntent(builder.f1502e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f1503f, (notification.flags & 128) != 0).setLargeIcon(builder.f1505h).setNumber(builder.f1507j).setProgress(builder.r, builder.s, builder.t);
        if (i2 < 21) {
            this.f1560a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i2 >= 16) {
            this.f1560a.setSubText(builder.p).setUsesChronometer(builder.m).setPriority(builder.k);
            Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = builder.B;
            if (bundle != null) {
                this.f1565f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.x) {
                    this.f1565f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                String str = builder.u;
                if (str != null) {
                    this.f1565f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                    if (builder.v) {
                        this.f1565f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f1565f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                String str2 = builder.w;
                if (str2 != null) {
                    this.f1565f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
                }
            }
            this.f1562c = builder.F;
            this.f1563d = builder.G;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            this.f1560a.setShowWhen(builder.l);
            if (i3 < 21 && (arrayList = builder.mPeople) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f1565f;
                ArrayList<String> arrayList2 = builder.mPeople;
                bundle2.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (i3 >= 20) {
            this.f1560a.setLocalOnly(builder.x).setGroup(builder.u).setGroupSummary(builder.v).setSortKey(builder.w);
            this.f1566g = builder.M;
        }
        if (i3 >= 21) {
            this.f1560a.setCategory(builder.A).setColor(builder.C).setVisibility(builder.D).setPublicVersion(builder.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = builder.mPeople.iterator();
            while (it2.hasNext()) {
                this.f1560a.addPerson(it2.next());
            }
            this.f1567h = builder.H;
            if (builder.f1499b.size() > 0) {
                Bundle bundle3 = builder.getExtras().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i4 = 0; i4 < builder.f1499b.size(); i4++) {
                    bundle4.putBundle(Integer.toString(i4), NotificationCompatJellybean.g(builder.f1499b.get(i4)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                builder.getExtras().putBundle("android.car.EXTENSIONS", bundle3);
                this.f1565f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 24) {
            this.f1560a.setExtras(builder.B).setRemoteInputHistory(builder.q);
            RemoteViews remoteViews = builder.F;
            if (remoteViews != null) {
                this.f1560a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.G;
            if (remoteViews2 != null) {
                this.f1560a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.H;
            if (remoteViews3 != null) {
                this.f1560a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i5 >= 26) {
            this.f1560a.setBadgeIconType(builder.J).setShortcutId(builder.K).setTimeoutAfter(builder.L).setGroupAlertBehavior(builder.M);
            if (builder.z) {
                this.f1560a.setColorized(builder.y);
            }
            if (!TextUtils.isEmpty(builder.I)) {
                this.f1560a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i5 >= 29) {
            this.f1560a.setAllowSystemGeneratedContextualActions(builder.N);
            this.f1560a.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(builder.O));
        }
        if (builder.Q) {
            if (this.f1561b.v) {
                this.f1566g = 2;
            } else {
                this.f1566g = 1;
            }
            this.f1560a.setVibrate(null);
            this.f1560a.setSound(null);
            int i6 = notification.defaults & (-2);
            notification.defaults = i6;
            int i7 = i6 & (-3);
            notification.defaults = i7;
            this.f1560a.setDefaults(i7);
            if (i5 >= 26) {
                if (TextUtils.isEmpty(this.f1561b.u)) {
                    this.f1560a.setGroup(NotificationCompat.GROUP_KEY_SILENT);
                }
                this.f1560a.setGroupAlertBehavior(this.f1566g);
            }
        }
    }

    private void a(NotificationCompat.Action action) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f1564e.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f1560a, action));
                return;
            }
            return;
        }
        IconCompat iconCompat = action.getIconCompat();
        Notification.Action.Builder builder = i2 >= 23 ? new Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent()) : new Notification.Action.Builder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.b(action.getRemoteInputs())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i3 >= 28) {
            builder.setSemanticAction(action.getSemanticAction());
        }
        if (i3 >= 29) {
            builder.setContextual(action.isContextual());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        builder.addExtras(bundle);
        this.f1560a.addAction(builder.build());
    }

    private void c(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & (-2);
        notification.defaults = i2;
        notification.defaults = i2 & (-3);
    }

    protected Notification b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f1560a.build();
        }
        if (i2 >= 24) {
            Notification build = this.f1560a.build();
            if (this.f1566g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f1566g == 2) {
                    c(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1566g == 1) {
                    c(build);
                }
            }
            return build;
        }
        if (i2 >= 21) {
            this.f1560a.setExtras(this.f1565f);
            Notification build2 = this.f1560a.build();
            RemoteViews remoteViews = this.f1562c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1563d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1567h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1566g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f1566g == 2) {
                    c(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1566g == 1) {
                    c(build2);
                }
            }
            return build2;
        }
        if (i2 >= 20) {
            this.f1560a.setExtras(this.f1565f);
            Notification build3 = this.f1560a.build();
            RemoteViews remoteViews4 = this.f1562c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1563d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1566g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f1566g == 2) {
                    c(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1566g == 1) {
                    c(build3);
                }
            }
            return build3;
        }
        if (i2 >= 19) {
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.f1564e);
            if (buildActionExtrasMap != null) {
                this.f1565f.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            this.f1560a.setExtras(this.f1565f);
            Notification build4 = this.f1560a.build();
            RemoteViews remoteViews6 = this.f1562c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1563d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (i2 < 16) {
            return this.f1560a.getNotification();
        }
        Notification build5 = this.f1560a.build();
        Bundle extras = NotificationCompat.getExtras(build5);
        Bundle bundle = new Bundle(this.f1565f);
        for (String str : this.f1565f.keySet()) {
            if (extras.containsKey(str)) {
                bundle.remove(str);
            }
        }
        extras.putAll(bundle);
        SparseArray<Bundle> buildActionExtrasMap2 = NotificationCompatJellybean.buildActionExtrasMap(this.f1564e);
        if (buildActionExtrasMap2 != null) {
            NotificationCompat.getExtras(build5).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap2);
        }
        RemoteViews remoteViews8 = this.f1562c;
        if (remoteViews8 != null) {
            build5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.f1563d;
        if (remoteViews9 != null) {
            build5.bigContentView = remoteViews9;
        }
        return build5;
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.f1561b.o;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification b2 = b();
        if (makeContentView != null) {
            b2.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.f1561b.F;
            if (remoteViews != null) {
                b2.contentView = remoteViews;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            b2.bigContentView = makeBigContentView;
        }
        if (i2 >= 21 && style != null && (makeHeadsUpContentView = this.f1561b.o.makeHeadsUpContentView(this)) != null) {
            b2.headsUpContentView = makeHeadsUpContentView;
        }
        if (i2 >= 16 && style != null && (extras = NotificationCompat.getExtras(b2)) != null) {
            style.addCompatExtras(extras);
        }
        return b2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.f1560a;
    }
}
