package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2700a = "LocalBroadcastManager";

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f2701b = false;

    /* renamed from: c, reason: collision with root package name */
    static final int f2702c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f2703d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static LocalBroadcastManager f2704e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f2705f;

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> f2706g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, ArrayList<ReceiverRecord>> f2707h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<BroadcastRecord> f2708i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private final Handler f2709j;

    private static final class BroadcastRecord {

        /* renamed from: a, reason: collision with root package name */
        final Intent f2711a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<ReceiverRecord> f2712b;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f2711a = intent;
            this.f2712b = arrayList;
        }
    }

    private static final class ReceiverRecord {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f2713a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f2714b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2715c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2716d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f2713a = intentFilter;
            this.f2714b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f2714b);
            sb.append(" filter=");
            sb.append(this.f2713a);
            if (this.f2716d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f2705f = context;
        this.f2709j = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f2703d) {
            if (f2704e == null) {
                f2704e = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f2704e;
        }
        return localBroadcastManager;
    }

    void a() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f2706g) {
                size = this.f2708i.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.f2708i.toArray(broadcastRecordArr);
                this.f2708i.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i2];
                int size2 = broadcastRecord.f2712b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ReceiverRecord receiverRecord = broadcastRecord.f2712b.get(i3);
                    if (!receiverRecord.f2716d) {
                        receiverRecord.f2714b.onReceive(this.f2705f, broadcastRecord.f2711a);
                    }
                }
            }
        }
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f2706g) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList = this.f2706g.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f2706g.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<ReceiverRecord> arrayList2 = this.f2707h.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f2707h.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(@NonNull Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<ReceiverRecord> arrayList2;
        String str2;
        synchronized (this.f2706g) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f2705f.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(f2700a, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<ReceiverRecord> arrayList3 = this.f2707h.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v(f2700a, "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    ReceiverRecord receiverRecord = arrayList3.get(i3);
                    if (z) {
                        Log.v(f2700a, "Matching against filter " + receiverRecord.f2713a);
                    }
                    if (receiverRecord.f2715c) {
                        if (z) {
                            Log.v(f2700a, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = receiverRecord.f2713a.match(action, resolveTypeIfNeeded, scheme, data, categories, f2700a);
                        if (match >= 0) {
                            if (z) {
                                Log.v(f2700a, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(receiverRecord);
                            receiverRecord.f2715c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v(f2700a, "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : MiConfigSingleton.t0 : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((ReceiverRecord) arrayList5.get(i4)).f2715c = false;
                    }
                    this.f2708i.add(new BroadcastRecord(intent, arrayList5));
                    if (!this.f2709j.hasMessages(1)) {
                        this.f2709j.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            a();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f2706g) {
            ArrayList<ReceiverRecord> remove = this.f2706g.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = remove.get(size);
                receiverRecord.f2716d = true;
                for (int i2 = 0; i2 < receiverRecord.f2713a.countActions(); i2++) {
                    String action = receiverRecord.f2713a.getAction(i2);
                    ArrayList<ReceiverRecord> arrayList = this.f2707h.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            ReceiverRecord receiverRecord2 = arrayList.get(size2);
                            if (receiverRecord2.f2714b == broadcastReceiver) {
                                receiverRecord2.f2716d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f2707h.remove(action);
                        }
                    }
                }
            }
        }
    }
}
