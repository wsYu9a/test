package i2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public File f26835a;

    /* renamed from: b */
    public q2.a f26836b;

    public b(String str, q2.a aVar) {
        this.f26835a = null;
        this.f26836b = null;
        this.f26835a = new File(str);
        this.f26836b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void b() {
        new Thread(new c(this)).start();
    }

    public final synchronized void d() {
        try {
            File file = this.f26835a;
            if (file == null) {
                return;
            }
            if (file.exists() && this.f26835a.isDirectory() && this.f26835a.list().length != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f26835a.list()) {
                    arrayList.add(str);
                }
                Collections.sort(arrayList);
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                int size = arrayList.size();
                if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                    if (arrayList.size() < 2) {
                        return;
                    }
                    str2 = (String) arrayList.get(arrayList.size() - 2);
                    size--;
                }
                if (!this.f26836b.logCollect(a(t3.b.a(this.f26835a.getAbsolutePath(), str2)))) {
                    size--;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    new File(this.f26835a, (String) arrayList.get(i10)).delete();
                }
            }
        } finally {
        }
    }
}
