package com.opos.mobad.model.e;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public class c {
    public static final String a(InputStream inputStream) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        return new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                    }
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            } finally {
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
