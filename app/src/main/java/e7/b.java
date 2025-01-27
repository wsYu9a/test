package e7;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class b extends jj.a {

    /* renamed from: d */
    public final Context f25758d;

    /* renamed from: e */
    public final String f25759e;

    public b(Context context, String str) {
        this.f25758d = context;
        this.f25759e = str;
    }

    @Override // jj.a
    public void b() {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f25758d.getAssets().open(this.f25759e);
                org.threeten.bp.zone.a aVar = new org.threeten.bp.zone.a(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                jj.b.j(aVar);
            } catch (IOException e10) {
                throw new IllegalStateException(this.f25759e + " missing from assets", e10);
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }
}
