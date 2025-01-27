package l9;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;

/* loaded from: classes3.dex */
public class r0 {
    public static void a(Context context, int i10, Class<? extends Service> cls) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(3, SystemClock.elapsedRealtime(), 1000 * i10, PendingIntent.getService(context, 0, new Intent(context, cls), 134217728));
    }

    public static void b(Context context, Class<? extends Service> cls) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(context, 0, new Intent(context, cls), 134217728));
    }
}
