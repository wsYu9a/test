package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.sigmob.sdk.base.common.f0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public final class aa {
    private static aa aTB;
    private static final Object mLock = new Object();
    private final Context aTx;

    /* renamed from: hf, reason: collision with root package name */
    private final Handler f11980hf;
    private final HashMap<BroadcastReceiver, ArrayList<b>> aTy = new HashMap<>();
    private final HashMap<String, ArrayList<b>> aTz = new HashMap<>();
    private final ArrayList<a> aTA = new ArrayList<>();

    public static final class a {
        final ArrayList<b> aTD;
        final Intent intent;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.aTD = arrayList;
        }
    }

    public static final class b {
        final BroadcastReceiver aTE;
        boolean aTF;
        boolean aTG;
        final IntentFilter filter;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.aTE = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.aTE);
            sb2.append(" filter=");
            sb2.append(this.filter);
            if (this.aTG) {
                sb2.append(" DEAD");
            }
            sb2.append(p3.f.f29748d);
            return sb2.toString();
        }
    }

    private aa(Context context) {
        this.aTx = context;
        this.f11980hf = new Handler(context.getMainLooper()) { // from class: com.kwad.sdk.utils.aa.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    aa.this.Ng();
                }
            }
        };
    }

    public static aa cn(Context context) {
        aa aaVar;
        synchronized (mLock) {
            try {
                if (aTB == null) {
                    aTB = new aa(context.getApplicationContext());
                }
                aaVar = aTB;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aaVar;
    }

    public final void Ng() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.aTy) {
                try {
                    size = this.aTA.size();
                    if (size <= 0) {
                        return;
                    }
                    aVarArr = new a[size];
                    this.aTA.toArray(aVarArr);
                    this.aTA.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                a aVar = aVarArr[i10];
                int size2 = aVar.aTD.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    b bVar = aVar.aTD.get(i11);
                    if (!bVar.aTG) {
                        bVar.aTE.onReceive(this.aTx, aVar.intent);
                    }
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.aTy) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.aTy.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.aTy.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList<b> arrayList2 = this.aTz.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.aTz.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean i(Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.aTy) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.aTx.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z10 = (intent.getFlags() & 8) != 0;
                if (z10) {
                    Log.v("KsLocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<b> arrayList3 = this.aTz.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z10) {
                        Log.v("KsLocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i11 = 0;
                    while (i11 < arrayList3.size()) {
                        b bVar = arrayList3.get(i11);
                        if (z10) {
                            Log.v("KsLocalBroadcastManager", "Matching against filter " + bVar.filter);
                        }
                        if (bVar.aTF) {
                            if (z10) {
                                Log.v("KsLocalBroadcastManager", "  Filter's target already added");
                            }
                            i10 = i11;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i10 = i11;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, f0.f17743g);
                            if (match >= 0) {
                                if (z10) {
                                    Log.v("KsLocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(bVar);
                                bVar.aTF = true;
                                i11 = i10 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z10) {
                                Log.v("KsLocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : h3.e.f26408m : "action" : "category"));
                            }
                        }
                        arrayList4 = arrayList;
                        i11 = i10 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                            ((b) arrayList5.get(i12)).aTF = false;
                        }
                        this.aTA.add(new a(intent, arrayList5));
                        if (!this.f11980hf.hasMessages(1)) {
                            this.f11980hf.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.aTy) {
            try {
                ArrayList<b> remove = this.aTy.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    b bVar = remove.get(size);
                    bVar.aTG = true;
                    for (int i10 = 0; i10 < bVar.filter.countActions(); i10++) {
                        String action = bVar.filter.getAction(i10);
                        ArrayList<b> arrayList = this.aTz.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.aTE == broadcastReceiver) {
                                    bVar2.aTG = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.aTz.remove(action);
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
