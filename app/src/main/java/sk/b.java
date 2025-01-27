package sk;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public static String f30677a = null;

    /* renamed from: b */
    public static String f30678b = "AN_A4";

    /* renamed from: c */
    public static rh.a f30679c;

    /* renamed from: d */
    public static rh.b f30680d;

    /* renamed from: e */
    public static final byte[] f30681e = Arrays.copyOf("x04VOtkJ".getBytes(), 16);

    /* renamed from: f */
    public static String f30682f = null;

    public static String a(Context context) {
        String str = f30682f;
        if (str != null) {
            return str;
        }
        try {
            File file = new File(context.getFilesDir(), "snc_did.data");
            r0 = file.exists() ? a.a(file.getPath()) : null;
            if (TextUtils.isEmpty(r0)) {
                r0 = d.a(UUID.randomUUID().toString().getBytes());
                FileWriter fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(r0);
                    fileWriter.close();
                } finally {
                }
            }
            f30682f = r0;
        } catch (Exception unused) {
        }
        return r0;
    }
}
