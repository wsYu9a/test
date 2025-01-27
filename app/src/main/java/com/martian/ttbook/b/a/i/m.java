package com.martian.ttbook.b.a.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class m extends i {

    /* renamed from: b */
    private i f15006b;

    /* renamed from: c */
    private k f15007c;

    /* renamed from: d */
    private int f15008d;

    /* renamed from: e */
    private Handler f15009e = new Handler(Looper.getMainLooper(), new a());

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                int i3 = message.arg1;
                int i4 = message.arg2;
                Object obj = message.obj;
                if (m.this.f15007c != null) {
                    m.this.f15007c.a(i3);
                }
                m.this.f15006b.b(i3, i4, obj != null ? Long.valueOf(obj.toString()).longValue() : 0L);
                return false;
            }
            if (i2 == 2) {
                if (m.this.f15007c != null) {
                    m.this.f15007c.c(o.f15031b);
                }
                m.this.f15006b.e();
                return false;
            }
            if (i2 == 3) {
                Object obj2 = message.obj;
                if (m.this.f15007c != null) {
                    m.this.f15007c.c(o.f15033d);
                }
                m.this.f15006b.d((File) obj2);
                return false;
            }
            if (i2 == 4) {
                int i5 = message.arg1;
                Object obj3 = message.obj;
                if (m.this.f15007c != null) {
                    m.this.f15007c.c(o.f15034e);
                }
                m.this.f15006b.c(i5, obj3 != null ? obj3.toString() : "null msg");
                return false;
            }
            if (i2 == 7) {
                String str = (String) message.obj;
                if (m.this.f15007c == null || TextUtils.isEmpty(str)) {
                    return false;
                }
                m.this.f15007c.d(str);
                return false;
            }
            if (i2 == 5) {
                m.this.f15006b.a();
                return false;
            }
            if (i2 != 6) {
                return false;
            }
            m.this.f15006b.f();
            return false;
        }
    }

    public m(i iVar, k kVar) {
        this.f15006b = iVar == null ? i.f14992a : iVar;
        this.f15007c = kVar;
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void a() {
        this.f15009e.sendMessage(Message.obtain(this.f15009e, 5));
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void b(int i2, long j2, long j3) {
        if (i2 != this.f15008d) {
            Message obtain = Message.obtain(this.f15009e, 1, i2, (int) j2);
            obtain.obj = Long.valueOf(j3);
            this.f15009e.sendMessage(obtain);
            this.f15008d = i2;
        }
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void c(int i2, String str) {
        this.f15009e.sendMessage(Message.obtain(this.f15009e, 4));
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void d(File file) {
        this.f15009e.sendMessage(Message.obtain(this.f15009e, 3, file));
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void e() {
        this.f15009e.sendMessage(Message.obtain(this.f15009e, 2));
    }

    @Override // com.martian.ttbook.b.a.i.i
    public void f() {
        this.f15009e.sendMessage(Message.obtain(this.f15009e, 6));
    }
}
