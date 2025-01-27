package i3;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes.dex */
public class c extends ContentObserver {

    /* renamed from: d */
    public static final String f26873d = "VMS_IDLG_SDK_Observer";

    /* renamed from: a */
    public String f26874a;

    /* renamed from: b */
    public int f26875b;

    /* renamed from: c */
    public b f26876c;

    public c(b bVar, int i10, String str) {
        super(null);
        this.f26876c = bVar;
        this.f26875b = i10;
        this.f26874a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        b bVar = this.f26876c;
        if (bVar != null) {
            bVar.e(this.f26875b, this.f26874a);
        } else {
            Log.e(f26873d, "mIdentifierIdClient is null");
        }
    }
}
