package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f6326a;
        if (aVar == null || (list = aVar.f6313a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.f6326a.f6313a) {
            c cVar2 = dVar.f6328c;
            if (cVar == null) {
                throw new IOException("input parameters is null, cannot write local file header");
            }
            byte[] bArr = {0, 0};
            cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, cVar.f6316a);
            cVar2.a(byteArrayOutputStream, 2081);
            cVar2.a(byteArrayOutputStream, 545);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6317b);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6318c);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6319d);
            byte[] bArr2 = new byte[0];
            String str = cVar.f6323h;
            if (str != null && str.trim().length() > 0) {
                bArr2 = cVar.f6323h.getBytes(Charset.forName("UTF-8"));
            }
            cVar2.a(byteArrayOutputStream, bArr2.length);
            int i2 = cVar.f6321f;
            cVar2.a(byteArrayOutputStream, i2);
            cVar2.a(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f6324i);
            if (bArr2.length > 0) {
                byteArrayOutputStream.write(bArr2);
            }
            if (i2 > 0) {
                byteArrayOutputStream.write(new byte[i2]);
            }
        }
    }
}
