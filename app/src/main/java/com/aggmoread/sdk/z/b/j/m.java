package com.aggmoread.sdk.z.b.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class m extends i {

    /* renamed from: b */
    private i f4607b;

    /* renamed from: c */
    private k f4608c;

    /* renamed from: d */
    private int f4609d;

    /* renamed from: e */
    private Handler f4610e = new Handler(Looper.getMainLooper(), new a());

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                int i11 = message.arg1;
                int i12 = message.arg2;
                Object obj = message.obj;
                if (m.this.f4608c != null) {
                    m.this.f4608c.a(i11);
                }
                m.this.f4607b.a(i11, i12, obj != null ? Long.valueOf(obj.toString()).longValue() : 0L);
                return false;
            }
            if (i10 == 2) {
                if (m.this.f4608c != null) {
                    m.this.f4608c.a(o.f4640b);
                }
                m.this.f4607b.b();
                return false;
            }
            if (i10 == 3) {
                Object obj2 = message.obj;
                if (m.this.f4608c != null) {
                    m.this.f4608c.a(o.f4642d);
                }
                m.this.f4607b.a((File) obj2);
                return false;
            }
            if (i10 == 4) {
                int i13 = message.arg1;
                Object obj3 = message.obj;
                if (m.this.f4608c != null) {
                    m.this.f4608c.a(o.f4643e);
                }
                m.this.f4607b.a(i13, obj3 != null ? obj3.toString() : "null msg");
                return false;
            }
            if (i10 == 7) {
                String str = (String) message.obj;
                if (m.this.f4608c == null || TextUtils.isEmpty(str)) {
                    return false;
                }
                m.this.f4608c.a(str);
                return false;
            }
            if (i10 == 5) {
                m.this.f4607b.a();
                return false;
            }
            if (i10 != 6) {
                return false;
            }
            m.this.f4607b.c();
            return false;
        }
    }

    public m(i iVar, k kVar) {
        this.f4607b = iVar == null ? i.f4593a : iVar;
        this.f4608c = kVar;
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void c() {
        this.f4610e.sendMessage(Message.obtain(this.f4610e, 6));
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void a() {
        this.f4610e.sendMessage(Message.obtain(this.f4610e, 5));
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void b() {
        this.f4610e.sendMessage(Message.obtain(this.f4610e, 2));
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void a(int i10, long j10, long j11) {
        if (i10 != this.f4609d) {
            Message obtain = Message.obtain(this.f4610e, 1, i10, (int) j10);
            obtain.obj = Long.valueOf(j11);
            this.f4610e.sendMessage(obtain);
            this.f4609d = i10;
        }
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void a(int i10, String str) {
        this.f4610e.sendMessage(Message.obtain(this.f4610e, 4));
    }

    @Override // com.aggmoread.sdk.z.b.j.i
    public void a(File file) {
        this.f4610e.sendMessage(Message.obtain(this.f4610e, 3, file));
    }
}
