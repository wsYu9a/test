package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
final class a {

    /* renamed from: com.kwai.library.ipneigh.a$a, reason: collision with other inner class name */
    public static class C0520a extends Thread {
        private final InputStream aZf;

        public C0520a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.aZf = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            Throwable th2;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.aZf));
                do {
                    try {
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th3) {
                        th2 = th3;
                        a.closeQuietly(bufferedReader);
                        throw th2;
                    }
                } while (bufferedReader.readLine() != null);
                a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                bufferedReader = null;
                th2 = th4;
            }
        }
    }

    public interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    private static <T> T a(String str, b<T> bVar) {
        BufferedReader bufferedReader;
        Process exec;
        C0520a c0520a;
        Process process = null;
        try {
            exec = Runtime.getRuntime().exec(str);
            try {
                c0520a = new C0520a(exec.getErrorStream());
                c0520a.start();
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            T b10 = bVar.b(bufferedReader);
            c0520a.join();
            exec.waitFor();
            exec.destroy();
            closeQuietly(bufferedReader);
            return b10;
        } catch (Throwable th4) {
            th = th4;
            process = exec;
            if (process != null) {
                process.destroy();
            }
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String hC(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                private static String a(BufferedReader bufferedReader) {
                    String readLine = bufferedReader.readLine();
                    while (bufferedReader.readLine() != null) {
                    }
                    return readLine;
                }

                @Override // com.kwai.library.ipneigh.a.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }
}
