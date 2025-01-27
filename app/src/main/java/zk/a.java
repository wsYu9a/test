package zk;

import android.database.ContentObserver;
import jh.c;

/* loaded from: classes5.dex */
public final class a extends ContentObserver {

    /* renamed from: a */
    public String f33869a;

    /* renamed from: b */
    public int f33870b;

    /* renamed from: c */
    public b f33871c;

    public a(b bVar, int i10, String str) {
        super(null);
        this.f33871c = bVar;
        this.f33870b = i10;
        this.f33869a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        b bVar = this.f33871c;
        if (bVar != null) {
            bVar.b(this.f33870b, this.f33869a);
        } else {
            c.g(i3.c.f26873d, "mIdentifierIdClient is null");
        }
    }
}
