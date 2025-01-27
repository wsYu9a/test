package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;

    /* renamed from: a, reason: collision with root package name */
    static final boolean f638a = false;

    /* renamed from: c, reason: collision with root package name */
    static final String f640c = "historical-records";

    /* renamed from: d, reason: collision with root package name */
    static final String f641d = "historical-record";

    /* renamed from: e, reason: collision with root package name */
    static final String f642e = "activity";

    /* renamed from: f, reason: collision with root package name */
    static final String f643f = "time";

    /* renamed from: g, reason: collision with root package name */
    static final String f644g = "weight";

    /* renamed from: h, reason: collision with root package name */
    private static final int f645h = 5;

    /* renamed from: i, reason: collision with root package name */
    private static final float f646i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private static final String f647j = ".xml";
    private static final int k = -1;
    final Context q;
    final String r;
    private Intent s;
    private OnChooseActivityListener z;

    /* renamed from: b, reason: collision with root package name */
    static final String f639b = ActivityChooserModel.class.getSimpleName();
    private static final Object l = new Object();
    private static final Map<String, ActivityChooserModel> m = new HashMap();
    private final Object n = new Object();
    private final List<ActivityResolveInfo> o = new ArrayList();
    private final List<HistoricalRecord> p = new ArrayList();
    private ActivitySorter t = new DefaultSorter();
    private int u = 50;
    boolean v = true;
    private boolean w = false;
    private boolean x = true;
    private boolean y = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    private static final class DefaultSorter implements ActivitySorter {

        /* renamed from: a, reason: collision with root package name */
        private static final float f648a = 0.95f;

        /* renamed from: b, reason: collision with root package name */
        private final Map<ComponentName, ActivityResolveInfo> f649b = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.f649b;
            map.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActivityResolveInfo activityResolveInfo = list.get(i2);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f2;
                    f2 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j2, float f2) {
            this(ComponentName.unflattenFromString(str), j2, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j2 = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j2, float f2) {
            this.activity = componentName;
            this.time = j2;
            this.weight = f2;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
        
            if (r15 != null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d0, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
        
            if (r15 == null) goto L30;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instructions count: 244
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.q = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(f647j)) {
            this.r = str;
            return;
        }
        this.r = str + f647j;
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.p.add(historicalRecord);
        if (add) {
            this.x = true;
            e();
            d();
            h();
            notifyChanged();
        }
        return add;
    }

    private void b() {
        boolean c2 = c() | f();
        e();
        if (c2) {
            h();
            notifyChanged();
        }
    }

    private boolean c() {
        if (!this.y || this.s == null) {
            return false;
        }
        this.y = false;
        this.o.clear();
        List<ResolveInfo> queryIntentActivities = this.q.getPackageManager().queryIntentActivities(this.s, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.add(new ActivityResolveInfo(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private void d() {
        if (!this.w) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.x) {
            this.x = false;
            if (TextUtils.isEmpty(this.r)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.p), this.r);
        }
    }

    private void e() {
        int size = this.p.size() - this.u;
        if (size <= 0) {
            return;
        }
        this.x = true;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.remove(0);
        }
    }

    private boolean f() {
        if (!this.v || !this.x || TextUtils.isEmpty(this.r)) {
            return false;
        }
        this.v = false;
        this.w = true;
        g();
        return true;
    }

    private void g() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.q.openFileInput(this.r);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i2 = 0; i2 != 1 && i2 != 2; i2 = newPullParser.next()) {
                        }
                    } catch (XmlPullParserException e2) {
                        Log.e(f639b, "Error reading historical recrod file: " + this.r, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (IOException e3) {
                    Log.e(f639b, "Error reading historical recrod file: " + this.r, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!f640c.equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.p;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!f641d.equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, f644g))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (l) {
            Map<String, ActivityChooserModel> map = m;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean h() {
        if (this.t == null || this.s == null || this.o.isEmpty() || this.p.isEmpty()) {
            return false;
        }
        this.t.sort(this.s, this.o, Collections.unmodifiableList(this.p));
        return true;
    }

    public Intent chooseActivity(int i2) {
        synchronized (this.n) {
            if (this.s == null) {
                return null;
            }
            b();
            ActivityInfo activityInfo = this.o.get(i2).resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.s);
            intent.setComponent(componentName);
            if (this.z != null) {
                if (this.z.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.n) {
            b();
            resolveInfo = this.o.get(i2).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.n) {
            b();
            size = this.o.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.n) {
            b();
            List<ActivityResolveInfo> list = this.o;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).resolveInfo == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.n) {
            b();
            if (this.o.isEmpty()) {
                return null;
            }
            return this.o.get(0).resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i2;
        synchronized (this.n) {
            i2 = this.u;
        }
        return i2;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.n) {
            b();
            size = this.p.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.n) {
            intent = this.s;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.n) {
            if (this.t == activitySorter) {
                return;
            }
            this.t = activitySorter;
            if (h()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i2) {
        synchronized (this.n) {
            b();
            ActivityResolveInfo activityResolveInfo = this.o.get(i2);
            ActivityResolveInfo activityResolveInfo2 = this.o.get(0);
            float f2 = activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f;
            ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
            a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f2));
        }
    }

    public void setHistoryMaxSize(int i2) {
        synchronized (this.n) {
            if (this.u == i2) {
                return;
            }
            this.u = i2;
            e();
            if (h()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.n) {
            if (this.s == intent) {
                return;
            }
            this.s = intent;
            this.y = true;
            b();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.n) {
            this.z = onChooseActivityListener;
        }
    }
}
