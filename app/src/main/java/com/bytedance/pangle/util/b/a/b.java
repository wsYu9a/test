package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f7849a;
        if (aVar == null || (list = aVar.f7836a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.f7849a.f7836a) {
            c cVar2 = dVar.f7851c;
            if (cVar == null) {
                throw new IOException("input parameters is null, cannot write local file header");
            }
            byte[] bArr = {0, 0};
            cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, cVar.f7839a);
            cVar2.a(byteArrayOutputStream, 2081);
            cVar2.a(byteArrayOutputStream, 545);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f7840b);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f7841c);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f7842d);
            byte[] bArr2 = new byte[0];
            String str = cVar.f7846h;
            if (str != null && str.trim().length() > 0) {
                bArr2 = cVar.f7846h.getBytes(Charset.forName("UTF-8"));
            }
            cVar2.a(byteArrayOutputStream, bArr2.length);
            int i10 = cVar.f7844f;
            cVar2.a(byteArrayOutputStream, i10);
            cVar2.a(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f7847i);
            if (bArr2.length > 0) {
                byteArrayOutputStream.write(bArr2);
            }
            if (i10 > 0) {
                byteArrayOutputStream.write(new byte[i10]);
            }
        }
    }
}
