package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.y5;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class c6 {

    /* renamed from: a */
    public final HashMap<String, b6> f27258a;

    /* renamed from: b */
    public final SparseArray<String> f27259b;

    /* renamed from: c */
    public final e6 f27260c;

    /* renamed from: d */
    public final Cipher f27261d;

    /* renamed from: e */
    public final SecretKeySpec f27262e;

    /* renamed from: f */
    public boolean f27263f;

    /* renamed from: g */
    public r6 f27264g;

    public c6(File file, byte[] bArr) {
        if (bArr != null) {
            g1.a(bArr.length == 16);
            try {
                this.f27261d = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                this.f27262e = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            this.f27261d = null;
            this.f27262e = null;
        }
        this.f27258a = new HashMap<>();
        this.f27259b = new SparseArray<>();
        this.f27260c = new e6(new File(file, "cached_content_index.exi"));
    }

    public b6 a(String str) {
        return this.f27258a.get(str);
    }

    public final b6 a(String str, long j2) {
        SparseArray<String> sparseArray = this.f27259b;
        int size = sparseArray.size();
        int i2 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i2 < size && i2 == sparseArray.keyAt(i2)) {
                i2++;
            }
            keyAt = i2;
        }
        b6 b6Var = new b6(keyAt, str, j2);
        this.f27258a.put(b6Var.f27228b, b6Var);
        this.f27259b.put(b6Var.f27227a, b6Var.f27228b);
        this.f27263f = true;
        return b6Var;
    }

    public final void a(b6 b6Var) {
        this.f27258a.put(b6Var.f27228b, b6Var);
        this.f27259b.put(b6Var.f27227a, b6Var.f27228b);
    }

    public void b() {
        LinkedList linkedList = new LinkedList();
        for (b6 b6Var : this.f27258a.values()) {
            if (b6Var.f27229c.isEmpty()) {
                linkedList.add(b6Var.f27228b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b((String) it.next());
        }
    }

    public void c() {
        DataOutputStream dataOutputStream;
        Throwable th;
        IOException e2;
        if (this.f27263f) {
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream b2 = this.f27260c.b();
                r6 r6Var = this.f27264g;
                if (r6Var == null) {
                    this.f27264g = new r6(b2);
                } else {
                    r6Var.a(b2);
                }
                dataOutputStream = new DataOutputStream(this.f27264g);
                try {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeInt(this.f27261d != null ? 1 : 0);
                    if (this.f27261d != null) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        try {
                            this.f27261d.init(1, this.f27262e, new IvParameterSpec(bArr));
                            dataOutputStream.flush();
                            dataOutputStream = new DataOutputStream(new CipherOutputStream(this.f27264g, this.f27261d));
                        } catch (InvalidAlgorithmParameterException e3) {
                            e = e3;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e4) {
                            e = e4;
                            throw new IllegalStateException(e);
                        }
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    throw new y5.a(e2);
                } catch (Throwable th2) {
                    th = th2;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                dataOutputStream = dataOutputStream2;
                th = th4;
                Util.closeQuietly(dataOutputStream);
                throw th;
            }
            try {
                try {
                    dataOutputStream.writeInt(this.f27258a.size());
                    int i2 = 0;
                    for (b6 b6Var : this.f27258a.values()) {
                        dataOutputStream.writeInt(b6Var.f27227a);
                        dataOutputStream.writeUTF(b6Var.f27228b);
                        dataOutputStream.writeLong(b6Var.f27230d);
                        i2 += b6Var.a();
                    }
                    dataOutputStream.writeInt(i2);
                    e6 e6Var = this.f27260c;
                    e6Var.getClass();
                    dataOutputStream.close();
                    e6Var.f27399b.delete();
                    Util.closeQuietly((Closeable) null);
                    this.f27263f = false;
                } catch (Throwable th5) {
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    th = th5;
                    dataOutputStream2 = dataOutputStream3;
                    Throwable th42 = th;
                    dataOutputStream = dataOutputStream2;
                    th = th42;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (IOException e7) {
                DataOutputStream dataOutputStream4 = dataOutputStream;
                e = e7;
                dataOutputStream2 = dataOutputStream4;
                IOException iOException = e;
                dataOutputStream = dataOutputStream2;
                e2 = iOException;
                throw new y5.a(e2);
            }
        }
    }

    public void b(String str) {
        b6 remove = this.f27258a.remove(str);
        if (remove != null) {
            g1.b(remove.f27229c.isEmpty());
            this.f27259b.remove(remove.f27227a);
            this.f27263f = true;
        }
    }

    public final boolean a() {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f27260c.a());
            dataInputStream = new DataInputStream(bufferedInputStream);
            try {
                if (dataInputStream.readInt() != 1) {
                    Util.closeQuietly(dataInputStream);
                    return false;
                }
                if ((dataInputStream.readInt() & 1) == 0) {
                    if (this.f27261d != null) {
                        this.f27263f = true;
                    }
                    dataInputStream2 = dataInputStream;
                } else {
                    if (this.f27261d == null) {
                        Util.closeQuietly(dataInputStream);
                        return false;
                    }
                    byte[] bArr = new byte[16];
                    dataInputStream.readFully(bArr);
                    try {
                        this.f27261d.init(2, this.f27262e, new IvParameterSpec(bArr));
                        dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f27261d));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                }
                int readInt = dataInputStream2.readInt();
                int i2 = 0;
                for (int i3 = 0; i3 < readInt; i3++) {
                    b6 b6Var = new b6(dataInputStream2.readInt(), dataInputStream2.readUTF(), dataInputStream2.readLong());
                    a(b6Var);
                    i2 += b6Var.a();
                }
                int readInt2 = dataInputStream2.readInt();
                Util.closeQuietly(dataInputStream2);
                return readInt2 == i2;
            } catch (FileNotFoundException unused) {
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (IOException unused2) {
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            dataInputStream = dataInputStream2;
        } catch (IOException unused4) {
            dataInputStream = dataInputStream2;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = dataInputStream2;
        }
    }
}
