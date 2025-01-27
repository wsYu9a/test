package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.sigmob.sdk.downloader.core.file.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes4.dex */
public class b implements com.sigmob.sdk.downloader.core.file.a {

    /* renamed from: a */
    public final FileChannel f19272a;

    /* renamed from: b */
    public final ParcelFileDescriptor f19273b;

    /* renamed from: c */
    public final BufferedOutputStream f19274c;

    /* renamed from: d */
    public final FileOutputStream f19275d;

    public static class a implements a.InterfaceC0589a {
        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0589a
        public boolean a() {
            return true;
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0589a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, Uri uri, int i10) throws FileNotFoundException {
            return new b(context, uri, i10);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0589a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, File file, int i10) throws FileNotFoundException {
            return new b(context, Uri.fromFile(file), i10);
        }
    }

    public b(Context context, Uri uri, int i10) throws FileNotFoundException {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.f19273b = openFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
        this.f19275d = fileOutputStream;
        this.f19272a = fileOutputStream.getChannel();
        this.f19274c = new BufferedOutputStream(fileOutputStream, i10);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a() throws IOException {
        this.f19274c.flush();
        this.f19273b.getFileDescriptor().sync();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b(long j10) throws IOException {
        this.f19272a.position(j10);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void close() throws IOException {
        this.f19274c.close();
        this.f19275d.close();
        this.f19273b.close();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f19274c.write(bArr, i10, i11);
    }

    public b(FileChannel fileChannel, ParcelFileDescriptor parcelFileDescriptor, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream) {
        this.f19272a = fileChannel;
        this.f19273b = parcelFileDescriptor;
        this.f19275d = fileOutputStream;
        this.f19274c = bufferedOutputStream;
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(long j10) {
        StringBuilder sb2;
        try {
            Os.posix_fallocate(this.f19273b.getFileDescriptor(), 0L, j10);
        } catch (Throwable th2) {
            th = th2;
            if (th instanceof ErrnoException) {
                int i10 = th.errno;
                if (i10 == OsConstants.ENOSYS || i10 == OsConstants.ENOTSUP) {
                    com.sigmob.sdk.downloader.core.c.c("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                    try {
                        Os.ftruncate(this.f19273b.getFileDescriptor(), j10);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        sb2 = new StringBuilder();
                        sb2.append("It can't pre-allocate length(");
                        sb2.append(j10);
                        sb2.append(") on the sdk version(");
                        sb2.append(Build.VERSION.SDK_INT);
                        sb2.append("), because of ");
                        sb2.append(th);
                        com.sigmob.sdk.downloader.core.c.c("DownloadUriOutputStream", sb2.toString());
                    }
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("It can't pre-allocate length(");
            sb2.append(j10);
            sb2.append(") on the sdk version(");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append("), because of ");
            sb2.append(th);
            com.sigmob.sdk.downloader.core.c.c("DownloadUriOutputStream", sb2.toString());
        }
    }
}
