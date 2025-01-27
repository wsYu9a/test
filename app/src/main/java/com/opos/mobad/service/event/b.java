package com.opos.mobad.service.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.LruCache;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile b f23600a;

    /* renamed from: b */
    private Context f23601b;

    /* renamed from: d */
    private BroadcastReceiver f23603d;

    /* renamed from: c */
    private Map<String, c> f23602c = new HashMap();

    /* renamed from: e */
    private LruCache<String, a> f23604e = new LruCache<>(15);

    /* renamed from: com.opos.mobad.service.event.b$1 */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("description");
                int intExtra = intent.getIntExtra("code", -1);
                boolean booleanExtra = intent.getBooleanExtra("stick", false);
                byte[] byteArrayExtra = intent.getByteArrayExtra(MiConfigSingleton.t0);
                if (!TextUtils.isEmpty(stringExtra) && -1 != intExtra) {
                    Parcel parcel = null;
                    if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                        parcel = Parcel.obtain();
                        parcel.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                    }
                    b.this.b(stringExtra, intExtra, parcel, booleanExtra);
                    if (parcel != null) {
                        parcel.recycle();
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("eManager", "receiver error", e2);
            }
        }
    }

    private static final class a {

        /* renamed from: a */
        String f23606a;

        /* renamed from: b */
        int f23607b;

        /* renamed from: c */
        Parcel f23608c;

        public a(String str, int i2, Parcel parcel) {
            this.f23606a = str;
            this.f23607b = i2;
            this.f23608c = parcel;
        }
    }

    private b() {
    }

    public static final b a() {
        b bVar = f23600a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f23600a;
                if (bVar == null) {
                    bVar = new b();
                    f23600a = bVar;
                }
            }
        }
        return bVar;
    }

    private void a(Context context, String str, int i2, Parcel parcel, boolean z) {
        if (context == null) {
            return;
        }
        try {
            String str2 = context.getPackageName() + ".heytap.msp.mobad.BROADCAST_PERMISSION";
            Intent intent = new Intent();
            intent.setAction("com.heytap.msp.mobad.EVENT");
            intent.putExtra("description", str);
            intent.putExtra("code", i2);
            intent.putExtra("stick", z);
            intent.setPackage(context.getPackageName());
            if (parcel != null) {
                intent.putExtra(MiConfigSingleton.t0, parcel.marshall());
            }
            context.sendBroadcast(intent, str2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("eManager", "send fail", e2);
        }
    }

    private void b(Context context) {
        synchronized (this) {
            if (this.f23603d == null && context != null) {
                this.f23603d = new BroadcastReceiver() { // from class: com.opos.mobad.service.event.b.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        try {
                            String stringExtra = intent.getStringExtra("description");
                            int intExtra = intent.getIntExtra("code", -1);
                            boolean booleanExtra = intent.getBooleanExtra("stick", false);
                            byte[] byteArrayExtra = intent.getByteArrayExtra(MiConfigSingleton.t0);
                            if (!TextUtils.isEmpty(stringExtra) && -1 != intExtra) {
                                Parcel parcel = null;
                                if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                                    parcel = Parcel.obtain();
                                    parcel.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                                }
                                b.this.b(stringExtra, intExtra, parcel, booleanExtra);
                                if (parcel != null) {
                                    parcel.recycle();
                                }
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("eManager", "receiver error", e2);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.heytap.msp.mobad.EVENT");
                String str = context.getPackageName() + ".heytap.msp.mobad.BROADCAST_PERMISSION";
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(this.f23603d, intentFilter, str, null, 4);
                } else {
                    context.registerReceiver(this.f23603d, intentFilter, str, null);
                }
            }
        }
    }

    public void b(String str, int i2, Parcel parcel, boolean z) {
        c cVar = this.f23602c.get(str);
        if (cVar != null) {
            cVar.a(i2, parcel);
        } else if (z) {
            this.f23604e.put(str, new a(str, i2, parcel));
        }
    }

    public c a(EventDescription eventDescription) {
        if (eventDescription == null) {
            return null;
        }
        return this.f23602c.get(eventDescription.a());
    }

    public void a(Context context) {
        if (context != null) {
            this.f23601b = context;
        }
        b(context);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f23602c.put(cVar.a().a(), cVar);
        a remove = this.f23604e.remove(cVar.a().a());
        if (remove != null) {
            cVar.a(remove.f23607b, remove.f23608c);
        }
    }

    void a(String str, int i2, Parcel parcel) {
        a(this.f23601b, str, i2, parcel, false);
    }

    void a(String str, int i2, Parcel parcel, boolean z) {
        a(this.f23601b, str, i2, parcel, z);
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f23602c.remove(cVar.a().a());
    }
}
