package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes4.dex */
public class f0 {

    /* renamed from: f, reason: collision with root package name */
    public static final int f17742f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final String f17743g = "LocalBroadcastManager";

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f17744h = false;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f17745i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static f0 f17746j;

    /* renamed from: a, reason: collision with root package name */
    public final Context f17747a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f17748b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f17749c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f17750d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f17751e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                f0.this.a();
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f17753a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f17754b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f17753a = intent;
            this.f17754b = arrayList;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f17755a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f17756b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f17757c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f17758d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f17755a = intentFilter;
            this.f17756b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f17756b);
            sb2.append(" filter=");
            sb2.append(this.f17755a);
            if (this.f17758d) {
                sb2.append(" DEAD");
            }
            sb2.append(p3.f.f29748d);
            return sb2.toString();
        }
    }

    public f0(Context context) {
        this.f17747a = context;
        this.f17751e = new a(context.getMainLooper());
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f17748b) {
                try {
                    size = this.f17750d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f17750d.toArray(bVarArr);
                    this.f17750d.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f17754b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f17754b.get(i11);
                    if (!cVar.f17758d) {
                        cVar.f17756b.onReceive(this.f17747a, bVar.f17753a);
                    }
                }
            }
        }
    }

    public void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    public static f0 a(Context context) {
        f0 f0Var;
        synchronized (f17745i) {
            try {
                if (f17746j == null) {
                    f17746j = new f0(context.getApplicationContext());
                }
                f0Var = f17746j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f0Var;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f17748b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<c> arrayList = this.f17748b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f17748b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList<c> arrayList2 = this.f17749c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f17749c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean a(Intent intent) {
        return a(intent, 0);
    }

    public boolean a(Intent intent, int i10) {
        boolean z10;
        int i11;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        Uri uri;
        String str3;
        synchronized (this.f17748b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f17747a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z11 = (intent.getFlags() & 8) != 0;
                if (z11) {
                    Log.v(f17743g, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList3 = this.f17749c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z11) {
                        Log.v(f17743g, "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i12 = 0;
                    while (i12 < arrayList3.size()) {
                        c cVar = arrayList3.get(i12);
                        if (z11) {
                            Log.v(f17743g, "Matching against filter " + cVar.f17755a);
                        }
                        if (!cVar.f17757c) {
                            i11 = i12;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            uri = data;
                            int match = cVar.f17755a.match(action, resolveTypeIfNeeded, scheme, data, categories, f17743g);
                            if (match >= 0) {
                                if (z11) {
                                    Log.v(f17743g, "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f17757c = true;
                            } else {
                                if (z11) {
                                    str3 = "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : h3.e.f26408m : "action" : "category");
                                    Log.v(f17743g, str3);
                                }
                                arrayList4 = arrayList;
                            }
                        } else if (z11) {
                            str3 = "  Filter's target already added";
                            i11 = i12;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            uri = data;
                            arrayList = arrayList4;
                            Log.v(f17743g, str3);
                            arrayList4 = arrayList;
                        } else {
                            i11 = i12;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            uri = data;
                            arrayList = arrayList4;
                            arrayList4 = arrayList;
                        }
                        i12 = i11 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                        data = uri;
                    }
                    ArrayList arrayList5 = arrayList4;
                    z10 = false;
                    if (arrayList5 != null) {
                        for (int i13 = 0; i13 < arrayList5.size(); i13++) {
                            ((c) arrayList5.get(i13)).f17757c = false;
                        }
                        this.f17750d.add(new b(intent, arrayList5));
                        if (!this.f17751e.hasMessages(1)) {
                            if (i10 > 0) {
                                this.f17751e.sendEmptyMessageDelayed(1, i10);
                            } else {
                                this.f17751e.sendEmptyMessage(1);
                            }
                        }
                        return true;
                    }
                } else {
                    z10 = false;
                }
                return z10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f17748b) {
            try {
                ArrayList<c> remove = this.f17748b.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.f17758d = true;
                    for (int i10 = 0; i10 < cVar.f17755a.countActions(); i10++) {
                        String action = cVar.f17755a.getAction(i10);
                        ArrayList<c> arrayList = this.f17749c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f17756b == broadcastReceiver) {
                                    cVar2.f17758d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f17749c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
