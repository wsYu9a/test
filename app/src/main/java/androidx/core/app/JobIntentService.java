package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: a, reason: collision with root package name */
    static final String f1419a = "JobIntentService";

    /* renamed from: b, reason: collision with root package name */
    static final boolean f1420b = false;

    /* renamed from: c, reason: collision with root package name */
    static final Object f1421c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final HashMap<ComponentName, WorkEnqueuer> f1422d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    CompatJobEngine f1423e;

    /* renamed from: f, reason: collision with root package name */
    WorkEnqueuer f1424f;

    /* renamed from: g, reason: collision with root package name */
    CommandProcessor f1425g;

    /* renamed from: h, reason: collision with root package name */
    boolean f1426h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f1427i = false;

    /* renamed from: j, reason: collision with root package name */
    boolean f1428j = false;
    final ArrayList<CompatWorkItem> k;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.e(a2.getIntent());
                a2.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.f();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d, reason: collision with root package name */
        private final Context f1430d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f1431e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f1432f;

        /* renamed from: g, reason: collision with root package name */
        boolean f1433g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1434h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f1430d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f1431e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f1432f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f1447a);
            if (this.f1430d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f1433g) {
                        this.f1433g = true;
                        if (!this.f1434h) {
                            this.f1431e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.f1434h) {
                    if (this.f1433g) {
                        this.f1431e.acquire(60000L);
                    }
                    this.f1434h = false;
                    this.f1432f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.f1434h) {
                    this.f1434h = true;
                    this.f1432f.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
                    this.f1431e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.f1433g = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a, reason: collision with root package name */
        final Intent f1435a;

        /* renamed from: b, reason: collision with root package name */
        final int f1436b;

        CompatWorkItem(Intent intent, int i2) {
            this.f1435a = intent;
            this.f1436b = i2;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.f1436b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f1435a;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a, reason: collision with root package name */
        static final String f1438a = "JobServiceEngineImpl";

        /* renamed from: b, reason: collision with root package name */
        static final boolean f1439b = false;

        /* renamed from: c, reason: collision with root package name */
        final JobIntentService f1440c;

        /* renamed from: d, reason: collision with root package name */
        final Object f1441d;

        /* renamed from: e, reason: collision with root package name */
        JobParameters f1442e;

        final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f1443a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f1443a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.f1441d) {
                    JobParameters jobParameters = JobServiceEngineImpl.this.f1442e;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f1443a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.f1443a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f1441d = new Object();
            this.f1440c = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.f1441d) {
                JobParameters jobParameters = this.f1442e;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.f1440c.getClassLoader());
                return new WrapperWorkItem(dequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f1442e = jobParameters;
            this.f1440c.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f1440c.b();
            synchronized (this.f1441d) {
                this.f1442e = null;
            }
            return b2;
        }
    }

    @RequiresApi(26)
    static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f1445d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f1446e;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i2) {
            super(componentName);
            b(i2);
            this.f1445d = new JobInfo.Builder(i2, this.f1447a).setOverrideDeadline(0L).build();
            this.f1446e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            this.f1446e.enqueue(this.f1445d, new JobWorkItem(intent));
        }
    }

    static abstract class WorkEnqueuer {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f1447a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1448b;

        /* renamed from: c, reason: collision with root package name */
        int f1449c;

        WorkEnqueuer(ComponentName componentName) {
            this.f1447a = componentName;
        }

        abstract void a(Intent intent);

        void b(int i2) {
            if (!this.f1448b) {
                this.f1448b = true;
                this.f1449c = i2;
            } else {
                if (this.f1449c == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f1449c);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.k = null;
        } else {
            this.k = new ArrayList<>();
        }
    }

    static WorkEnqueuer d(Context context, ComponentName componentName, boolean z, int i2) {
        WorkEnqueuer compatWorkEnqueuer;
        HashMap<ComponentName, WorkEnqueuer> hashMap = f1422d;
        WorkEnqueuer workEnqueuer = hashMap.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (Build.VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
        }
        WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
        hashMap.put(componentName, workEnqueuer2);
        return workEnqueuer2;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i2, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i2, intent);
    }

    GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.f1423e;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.k) {
            if (this.k.size() <= 0) {
                return null;
            }
            return this.k.remove(0);
        }
    }

    boolean b() {
        CommandProcessor commandProcessor = this.f1425g;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f1426h);
        }
        this.f1427i = true;
        return onStopCurrentWork();
    }

    void c(boolean z) {
        if (this.f1425g == null) {
            this.f1425g = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f1424f;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.f1425g.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(@NonNull Intent intent);

    void f() {
        ArrayList<CompatWorkItem> arrayList = this.k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1425g = null;
                ArrayList<CompatWorkItem> arrayList2 = this.k;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    c(false);
                } else if (!this.f1428j) {
                    this.f1424f.serviceProcessingFinished();
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f1427i;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        CompatJobEngine compatJobEngine = this.f1423e;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1423e = new JobServiceEngineImpl(this);
            this.f1424f = null;
        } else {
            this.f1423e = null;
            this.f1424f = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1428j = true;
                this.f1424f.serviceProcessingFinished();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.k == null) {
            return 2;
        }
        this.f1424f.serviceStartReceived();
        synchronized (this.k) {
            ArrayList<CompatWorkItem> arrayList = this.k;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            c(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.f1426h = z;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f1421c) {
            WorkEnqueuer d2 = d(context, componentName, true, i2);
            d2.b(i2);
            d2.a(intent);
        }
    }
}
