package w6;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.gyf.immersionbar.NavigationBarType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class d extends ContentObserver {

    /* renamed from: a */
    public ArrayList<j> f31639a;

    /* renamed from: b */
    public Application f31640b;

    /* renamed from: c */
    public Boolean f31641c;

    public static class b {

        /* renamed from: a */
        public static final d f31642a = new d();
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return b.f31642a;
    }

    public void a(j jVar) {
        if (jVar == null) {
            return;
        }
        if (this.f31639a == null) {
            this.f31639a = new ArrayList<>();
        }
        if (this.f31639a.contains(jVar)) {
            return;
        }
        this.f31639a.add(jVar);
    }

    public void c(Application application) {
        Uri uriFor;
        this.f31640b = application;
        if (application == null || application.getContentResolver() == null || this.f31641c.booleanValue() || (uriFor = Settings.System.getUriFor(com.gyf.immersionbar.b.f10644i)) == null) {
            return;
        }
        this.f31640b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f31641c = Boolean.TRUE;
    }

    public void d(j jVar) {
        ArrayList<j> arrayList;
        if (jVar == null || (arrayList = this.f31639a) == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        ArrayList<j> arrayList;
        super.onChange(z10);
        Application application = this.f31640b;
        if (application == null || application.getContentResolver() == null || (arrayList = this.f31639a) == null || arrayList.isEmpty()) {
            return;
        }
        int i10 = Settings.System.getInt(this.f31640b.getContentResolver(), com.gyf.immersionbar.b.f10644i, 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i10 == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator<j> it = this.f31639a.iterator();
        while (it.hasNext()) {
            it.next().a(i10 == 0, navigationBarType);
        }
    }

    public d() {
        super(new Handler(Looper.getMainLooper()));
        this.f31641c = Boolean.FALSE;
    }
}
