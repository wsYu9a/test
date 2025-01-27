package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    /* renamed from: a */
    private static final String f1579a = "NotifManCompat";

    /* renamed from: b */
    private static final String f1580b = "checkOpNoThrow";

    /* renamed from: c */
    private static final String f1581c = "OP_POST_NOTIFICATION";

    /* renamed from: d */
    static final int f1582d = 19;

    /* renamed from: e */
    private static final int f1583e = 1000;

    /* renamed from: f */
    private static final int f1584f = 6;

    /* renamed from: g */
    private static final String f1585g = "enabled_notification_listeners";

    /* renamed from: i */
    @GuardedBy("sEnabledNotificationListenersLock")
    private static String f1587i;

    @GuardedBy("sLock")
    private static SideChannelManager l;
    private final Context m;
    private final NotificationManager n;

    /* renamed from: h */
    private static final Object f1586h = new Object();

    /* renamed from: j */
    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> f1588j = new HashSet();
    private static final Object k = new Object();

    private static class NotifyTask implements Task {

        /* renamed from: a */
        final String f1593a;

        /* renamed from: b */
        final int f1594b;

        /* renamed from: c */
        final String f1595c;

        /* renamed from: d */
        final Notification f1596d;

        NotifyTask(String str, int i2, String str2, Notification notification) {
            this.f1593a = str;
            this.f1594b = i2;
            this.f1595c = str2;
            this.f1596d = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f1593a, this.f1594b, this.f1595c, this.f1596d);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[packageName:" + this.f1593a + ", id:" + this.f1594b + ", tag:" + this.f1595c + "]";
        }
    }

    private static class ServiceConnectedEvent {

        /* renamed from: a */
        final ComponentName f1597a;

        /* renamed from: b */
        final IBinder f1598b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f1597a = componentName;
            this.f1598b = iBinder;
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        private static final int f1599a = 0;

        /* renamed from: b */
        private static final int f1600b = 1;

        /* renamed from: c */
        private static final int f1601c = 2;

        /* renamed from: d */
        private static final int f1602d = 3;

        /* renamed from: e */
        private final Context f1603e;

        /* renamed from: f */
        private final HandlerThread f1604f;

        /* renamed from: g */
        private final Handler f1605g;

        /* renamed from: h */
        private final Map<ComponentName, ListenerRecord> f1606h = new HashMap();

        /* renamed from: i */
        private Set<String> f1607i = new HashSet();

        private static class ListenerRecord {

            /* renamed from: a */
            final ComponentName f1608a;

            /* renamed from: c */
            INotificationSideChannel f1610c;

            /* renamed from: b */
            boolean f1609b = false;

            /* renamed from: d */
            ArrayDeque<Task> f1611d = new ArrayDeque<>();

            /* renamed from: e */
            int f1612e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f1608a = componentName;
            }
        }

        SideChannelManager(Context context) {
            this.f1603e = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1604f = handlerThread;
            handlerThread.start();
            this.f1605g = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.f1609b) {
                return true;
            }
            boolean bindService = this.f1603e.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.f1608a), this, 33);
            listenerRecord.f1609b = bindService;
            if (bindService) {
                listenerRecord.f1612e = 0;
            } else {
                Log.w(NotificationManagerCompat.f1579a, "Unable to bind to listener " + listenerRecord.f1608a);
                this.f1603e.unbindService(this);
            }
            return listenerRecord.f1609b;
        }

        private void b(ListenerRecord listenerRecord) {
            if (listenerRecord.f1609b) {
                this.f1603e.unbindService(this);
                listenerRecord.f1609b = false;
            }
            listenerRecord.f1610c = null;
        }

        private void c(Task task) {
            i();
            for (ListenerRecord listenerRecord : this.f1606h.values()) {
                listenerRecord.f1611d.add(task);
                g(listenerRecord);
            }
        }

        private void d(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1606h.get(componentName);
            if (listenerRecord != null) {
                g(listenerRecord);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.f1606h.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f1610c = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.f1612e = 0;
                g(listenerRecord);
            }
        }

        private void f(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1606h.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        private void g(ListenerRecord listenerRecord) {
            if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                Log.d(NotificationManagerCompat.f1579a, "Processing component " + listenerRecord.f1608a + ", " + listenerRecord.f1611d.size() + " queued tasks");
            }
            if (listenerRecord.f1611d.isEmpty()) {
                return;
            }
            if (!a(listenerRecord) || listenerRecord.f1610c == null) {
                h(listenerRecord);
                return;
            }
            while (true) {
                Task peek = listenerRecord.f1611d.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                        Log.d(NotificationManagerCompat.f1579a, "Sending task " + peek);
                    }
                    peek.send(listenerRecord.f1610c);
                    listenerRecord.f1611d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                        Log.d(NotificationManagerCompat.f1579a, "Remote service has died: " + listenerRecord.f1608a);
                    }
                } catch (RemoteException e2) {
                    Log.w(NotificationManagerCompat.f1579a, "RemoteException communicating with " + listenerRecord.f1608a, e2);
                }
            }
            if (listenerRecord.f1611d.isEmpty()) {
                return;
            }
            h(listenerRecord);
        }

        private void h(ListenerRecord listenerRecord) {
            if (this.f1605g.hasMessages(3, listenerRecord.f1608a)) {
                return;
            }
            int i2 = listenerRecord.f1612e + 1;
            listenerRecord.f1612e = i2;
            if (i2 <= 6) {
                int i3 = (1 << (i2 - 1)) * 1000;
                if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                    Log.d(NotificationManagerCompat.f1579a, "Scheduling retry for " + i3 + " ms");
                }
                this.f1605g.sendMessageDelayed(this.f1605g.obtainMessage(3, listenerRecord.f1608a), i3);
                return;
            }
            Log.w(NotificationManagerCompat.f1579a, "Giving up on delivering " + listenerRecord.f1611d.size() + " tasks to " + listenerRecord.f1608a + " after " + listenerRecord.f1612e + " retries");
            listenerRecord.f1611d.clear();
        }

        private void i() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f1603e);
            if (enabledListenerPackages.equals(this.f1607i)) {
                return;
            }
            this.f1607i = enabledListenerPackages;
            List<ResolveInfo> queryIntentServices = this.f1603e.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w(NotificationManagerCompat.f1579a, "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f1606h.containsKey(componentName2)) {
                    if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                        Log.d(NotificationManagerCompat.f1579a, "Adding listener record for " + componentName2);
                    }
                    this.f1606h.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.f1606h.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                        Log.d(NotificationManagerCompat.f1579a, "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c((Task) message.obj);
                return true;
            }
            if (i2 == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                e(serviceConnectedEvent.f1597a, serviceConnectedEvent.f1598b);
                return true;
            }
            if (i2 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i2 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                Log.d(NotificationManagerCompat.f1579a, "Connected to service " + componentName);
            }
            this.f1605g.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.f1579a, 3)) {
                Log.d(NotificationManagerCompat.f1579a, "Disconnected from service " + componentName);
            }
            this.f1605g.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.f1605g.obtainMessage(0, task).sendToTarget();
        }
    }

    private interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private NotificationManagerCompat(Context context) {
        this.m = context;
        this.n = (NotificationManager) context.getSystemService("notification");
    }

    private void a(Task task) {
        synchronized (k) {
            if (l == null) {
                l = new SideChannelManager(this.m.getApplicationContext());
            }
            l.queueTask(task);
        }
    }

    private static boolean b(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), f1585g);
        synchronized (f1586h) {
            if (string != null) {
                if (!string.equals(f1587i)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f1588j = hashSet;
                    f1587i = string;
                }
            }
            set = f1588j;
        }
        return set;
    }

    public boolean areNotificationsEnabled() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return this.n.areNotificationsEnabled();
        }
        if (i2 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.m.getSystemService("appops");
        ApplicationInfo applicationInfo = this.m.getApplicationInfo();
        String packageName = this.m.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod(f1580b, cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i2) {
        cancel(null, i2);
    }

    public void cancelAll() {
        this.n.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.m.getPackageName()));
        }
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.createNotificationChannels(list);
        }
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.n.deleteNotificationChannelGroup(str);
        }
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.n.getImportance();
        }
        return -1000;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.n.getNotificationChannel(str);
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return this.n.getNotificationChannelGroup(str);
        }
        if (i2 >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
                if (notificationChannelGroup.getId().equals(str)) {
                    return notificationChannelGroup;
                }
            }
        }
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return Build.VERSION.SDK_INT >= 26 ? this.n.getNotificationChannelGroups() : Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        return Build.VERSION.SDK_INT >= 26 ? this.n.getNotificationChannels() : Collections.emptyList();
    }

    public void notify(int i2, @NonNull Notification notification) {
        notify(null, i2, notification);
    }

    public void cancel(@Nullable String str, int i2) {
        this.n.cancel(str, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.m.getPackageName(), i2, str));
        }
    }

    public void notify(@Nullable String str, int i2, @NonNull Notification notification) {
        if (!b(notification)) {
            this.n.notify(str, i2, notification);
        } else {
            a(new NotifyTask(this.m.getPackageName(), i2, str, notification));
            this.n.cancel(str, i2);
        }
    }

    private static class CancelTask implements Task {

        /* renamed from: a */
        final String f1589a;

        /* renamed from: b */
        final int f1590b;

        /* renamed from: c */
        final String f1591c;

        /* renamed from: d */
        final boolean f1592d;

        CancelTask(String str) {
            this.f1589a = str;
            this.f1590b = 0;
            this.f1591c = null;
            this.f1592d = true;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f1592d) {
                iNotificationSideChannel.cancelAll(this.f1589a);
            } else {
                iNotificationSideChannel.cancel(this.f1589a, this.f1590b, this.f1591c);
            }
        }

        @NonNull
        public String toString() {
            return "CancelTask[packageName:" + this.f1589a + ", id:" + this.f1590b + ", tag:" + this.f1591c + ", all:" + this.f1592d + "]";
        }

        CancelTask(String str, int i2, String str2) {
            this.f1589a = str;
            this.f1590b = i2;
            this.f1591c = str2;
            this.f1592d = false;
        }
    }
}
