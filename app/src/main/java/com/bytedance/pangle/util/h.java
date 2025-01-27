package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public final class h {
    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists() && file.isFile() && file.canRead()) {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            FileChannel channel = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.write(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
            channel.close();
            channel2.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static boolean a(String str, File file, StringBuilder sb2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(ByteBuffer.wrap(str.getBytes()));
            channel.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e10) {
            sb2.append(e10.getMessage());
            return false;
        }
    }

    public static void a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4096);
        while (readableByteChannel.read(allocateDirect) != -1) {
            allocateDirect.flip();
            while (allocateDirect.hasRemaining()) {
                writableByteChannel.write(allocateDirect);
            }
            allocateDirect.clear();
        }
    }
}
