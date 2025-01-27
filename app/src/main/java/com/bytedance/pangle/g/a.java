package com.bytedance.pangle.g;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private static final AtomicReference<byte[]> f7623a = new AtomicReference<>();

    public static o a(String str) {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new q(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] a10 = a(jarFile2, jarEntry);
                    if (com.bytedance.pangle.util.d.a(a10)) {
                        throw new q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] a11 = d.a(a10);
                    Enumeration<JarEntry> entries = jarFile2.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                arrayList.add(nextElement);
                            }
                        }
                    }
                    for (JarEntry jarEntry2 : arrayList) {
                        Certificate[][] a12 = a(jarFile2, jarEntry2);
                        if (com.bytedance.pangle.util.d.a(a12)) {
                            throw new q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                        }
                        if (!o.a(a11, d.a(a12))) {
                            throw new q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                        }
                    }
                    o oVar = new o(a11, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception unused) {
                    }
                    return oVar;
                } catch (IOException e10) {
                    e = e10;
                    throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e11) {
                    e = e11;
                    throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e12) {
                    e = e12;
                    throw new q(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
            } catch (RuntimeException e14) {
                e = e14;
            } catch (GeneralSecurityException e15) {
                e = e15;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static Certificate[][] a(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                try {
                    byte[] andSet = f7623a.getAndSet(null);
                    if (andSet == null) {
                        andSet = new byte[4096];
                    }
                    while (inputStream2.read(andSet, 0, andSet.length) != -1) {
                    }
                    f7623a.set(andSet);
                    Certificate[][] certificateArr = {jarEntry.getCertificates()};
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e10) {
                        throw e10;
                    } catch (Exception unused) {
                    }
                    return certificateArr;
                } catch (IOException e11) {
                    e = e11;
                    throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                } catch (RuntimeException e12) {
                    e = e12;
                    throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (RuntimeException e13) {
                            throw e13;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e14) {
                e = e14;
            } catch (RuntimeException e15) {
                e = e15;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
