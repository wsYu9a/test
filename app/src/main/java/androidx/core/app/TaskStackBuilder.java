package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a */
    private static final String f1665a = "TaskStackBuilder";

    /* renamed from: b */
    private final ArrayList<Intent> f1666b = new ArrayList<>();

    /* renamed from: c */
    private final Context f1667c;

    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context context) {
        this.f1667c = context;
    }

    @NonNull
    public static TaskStackBuilder create(@NonNull Context context) {
        return new TaskStackBuilder(context);
    }

    @Deprecated
    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    @NonNull
    public TaskStackBuilder addNextIntent(@NonNull Intent intent) {
        this.f1666b.add(intent);
        return this;
    }

    @NonNull
    public TaskStackBuilder addNextIntentWithParentStack(@NonNull Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f1667c.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Activity activity) {
        Intent supportParentActivityIntent = activity instanceof SupportParentable ? ((SupportParentable) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.getParentActivityIntent(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1667c.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(supportParentActivityIntent);
        }
        return this;
    }

    @Nullable
    public Intent editIntentAt(int i2) {
        return this.f1666b.get(i2);
    }

    @Deprecated
    public Intent getIntent(int i2) {
        return editIntentAt(i2);
    }

    public int getIntentCount() {
        return this.f1666b.size();
    }

    @NonNull
    public Intent[] getIntents() {
        int size = this.f1666b.size();
        Intent[] intentArr = new Intent[size];
        if (size == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.f1666b.get(0)).addFlags(268484608);
        for (int i2 = 1; i2 < size; i2++) {
            intentArr[i2] = new Intent(this.f1666b.get(i2));
        }
        return intentArr;
    }

    @Nullable
    public PendingIntent getPendingIntent(int i2, int i3) {
        return getPendingIntent(i2, i3, null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1666b.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    @Nullable
    public PendingIntent getPendingIntent(int i2, int i3, @Nullable Bundle bundle) {
        if (this.f1666b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        ArrayList<Intent> arrayList = this.f1666b;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return Build.VERSION.SDK_INT >= 16 ? PendingIntent.getActivities(this.f1667c, i2, intentArr, i3, bundle) : PendingIntent.getActivities(this.f1667c, i2, intentArr, i3);
    }

    public void startActivities(@Nullable Bundle bundle) {
        if (this.f1666b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f1666b;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.f1667c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        this.f1667c.startActivity(intent);
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Class<?> cls) {
        return addParentStack(new ComponentName(this.f1667c, cls));
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        int size = this.f1666b.size();
        try {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.f1667c, componentName);
            while (parentActivityIntent != null) {
                this.f1666b.add(size, parentActivityIntent);
                parentActivityIntent = NavUtils.getParentActivityIntent(this.f1667c, parentActivityIntent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f1665a, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }
}
