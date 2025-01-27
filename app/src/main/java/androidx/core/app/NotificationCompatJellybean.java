package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
/* loaded from: classes.dex */
class NotificationCompatJellybean {
    public static final String TAG = "NotificationCompat";

    /* renamed from: a */
    static final String f1568a = "android.support.dataRemoteInputs";

    /* renamed from: b */
    static final String f1569b = "android.support.allowGeneratedReplies";

    /* renamed from: c */
    private static final String f1570c = "icon";

    /* renamed from: d */
    private static final String f1571d = "title";

    /* renamed from: e */
    private static final String f1572e = "actionIntent";

    /* renamed from: f */
    private static final String f1573f = "extras";

    /* renamed from: g */
    private static final String f1574g = "remoteInputs";

    /* renamed from: h */
    private static final String f1575h = "dataOnlyRemoteInputs";

    /* renamed from: i */
    private static final String f1576i = "resultKey";

    /* renamed from: j */
    private static final String f1577j = "label";
    private static final String k = "choices";
    private static final String l = "allowFreeFormInput";
    private static final String m = "allowedDataTypes";
    private static final String n = "semanticAction";
    private static final String o = "showsUserInterface";
    private static Field q;
    private static boolean r;
    private static Field t;
    private static Field u;
    private static Field v;
    private static Field w;
    private static boolean x;
    private static final Object p = new Object();
    private static final Object s = new Object();

    private NotificationCompatJellybean() {
    }

    private static boolean a() {
        if (x) {
            return false;
        }
        try {
            if (t == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                u = cls.getDeclaredField(f1570c);
                v = cls.getDeclaredField("title");
                w = cls.getDeclaredField(f1572e);
                Field declaredField = Notification.class.getDeclaredField("actions");
                t = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "Unable to access notification actions", e2);
            x = true;
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, "Unable to access notification actions", e3);
            x = true;
        }
        return !x;
    }

    private static RemoteInput b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(m);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString(f1576i), bundle.getCharSequence("label"), bundle.getCharSequenceArray(k), bundle.getBoolean(l), 0, bundle.getBundle(f1573f), hashSet);
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    private static RemoteInput[] c(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i2 = 0; i2 < bundleArr.length; i2++) {
            remoteInputArr[i2] = b(bundleArr[i2]);
        }
        return remoteInputArr;
    }

    static NotificationCompat.Action d(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f1573f);
        return new NotificationCompat.Action(bundle.getInt(f1570c), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(f1572e), bundle.getBundle(f1573f), c(f(bundle, f1574g)), c(f(bundle, f1575h)), bundle2 != null ? bundle2.getBoolean(f1569b, false) : false, bundle.getInt(n), bundle.getBoolean(o), false);
    }

    private static Object[] e(Notification notification) {
        synchronized (s) {
            if (!a()) {
                return null;
            }
            try {
                return (Object[]) t.get(notification);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification actions", e2);
                x = true;
                return null;
            }
        }
    }

    private static Bundle[] f(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    static Bundle g(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        bundle.putInt(f1570c, iconCompat != null ? iconCompat.getResId() : 0);
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable(f1572e, action.getActionIntent());
        Bundle bundle2 = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle2.putBoolean(f1569b, action.getAllowGeneratedReplies());
        bundle.putBundle(f1573f, bundle2);
        bundle.putParcelableArray(f1574g, i(action.getRemoteInputs()));
        bundle.putBoolean(o, action.getShowsUserInterface());
        bundle.putInt(n, action.getSemanticAction());
        return bundle;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i2) {
        SparseArray sparseParcelableArray;
        synchronized (s) {
            try {
                try {
                    Object[] e2 = e(notification);
                    if (e2 != null) {
                        Object obj = e2[i2];
                        Bundle extras = getExtras(notification);
                        return readAction(u.getInt(obj), (CharSequence) v.get(obj), (PendingIntent) w.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) == null) ? null : (Bundle) sparseParcelableArray.get(i2));
                    }
                } catch (IllegalAccessException e3) {
                    Log.e(TAG, "Unable to access notification actions", e3);
                    x = true;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (s) {
            Object[] e2 = e(notification);
            length = e2 != null ? e2.length : 0;
        }
        return length;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (p) {
            if (r) {
                return null;
            }
            try {
                if (q == null) {
                    Field declaredField = Notification.class.getDeclaredField(f1573f);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        r = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    q = declaredField;
                }
                Bundle bundle = (Bundle) q.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    q.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification extras", e2);
                r = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e(TAG, "Unable to access notification extras", e3);
                r = true;
                return null;
            }
        }
    }

    private static Bundle h(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString(f1576i, remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray(k, remoteInput.getChoices());
        bundle.putBoolean(l, remoteInput.getAllowFreeFormInput());
        bundle.putBundle(f1573f, remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
            Iterator<String> it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList(m, arrayList);
        }
        return bundle;
    }

    private static Bundle[] i(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            bundleArr[i2] = h(remoteInputArr[i2]);
        }
        return bundleArr;
    }

    public static NotificationCompat.Action readAction(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        boolean z;
        if (bundle != null) {
            remoteInputArr = c(f(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr2 = c(f(bundle, f1568a));
            z = bundle.getBoolean(f1569b);
        } else {
            remoteInputArr = null;
            remoteInputArr2 = null;
            z = false;
        }
        return new NotificationCompat.Action(i2, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, 0, true, false);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat iconCompat = action.getIconCompat();
        builder.addAction(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, i(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray(f1568a, i(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean(f1569b, action.getAllowGeneratedReplies());
        return bundle;
    }
}
