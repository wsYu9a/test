package com.bytedance.pangle.res.a;

import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    public final int a(File file, boolean z, StringBuilder sb) {
        ZipFile zipFile;
        String byteArrayOutputStream;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            ZipEntry entry = zipFile.getEntry("assets/ZeusResMapping");
            if (entry == null) {
                com.bytedance.pangle.util.g.a(zipFile);
                return 200;
            }
            if (z) {
                File file2 = new File(file.getParentFile(), "resMappingBak");
                if (!file2.exists()) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                    sb.append("resMappingBakFile is not exists. ");
                    sb.append(file2.getAbsolutePath());
                    com.bytedance.pangle.util.g.a(zipFile);
                    return 300;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileChannel channel = fileInputStream.getChannel();
                byteArrayOutputStream = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                channel.close();
                fileInputStream.close();
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                InputStream inputStream = zipFile.getInputStream(entry);
                if (inputStream != null) {
                    ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                    WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream2);
                    com.bytedance.pangle.util.h.a(newChannel, newChannel2);
                    newChannel.close();
                    newChannel2.close();
                }
                byteArrayOutputStream = byteArrayOutputStream2.toString();
            }
            if (TextUtils.isEmpty(byteArrayOutputStream)) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z)));
                sb.append("zeusResMappingContent isEmpty. useBakFile:");
                sb.append(z);
                com.bytedance.pangle.util.g.a(zipFile);
                return 300;
            }
            JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
            JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
            JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add((String) jSONArray.get(i2));
            }
            int[] iArr = {0};
            a(file, (HashSet<String>) hashSet, new h() { // from class: com.bytedance.pangle.res.a.c.1

                /* renamed from: a */
                final /* synthetic */ JSONObject f6264a;

                /* renamed from: b */
                final /* synthetic */ JSONObject f6265b;

                /* renamed from: c */
                final /* synthetic */ int[] f6266c;

                /* renamed from: d */
                final /* synthetic */ HashSet f6267d;

                AnonymousClass1(JSONObject jSONObject3, JSONObject jSONObject4, int[] iArr2, HashSet hashSet2) {
                    jSONObject3 = jSONObject3;
                    jSONObject4 = jSONObject4;
                    iArr = iArr2;
                    hashSet = hashSet2;
                }

                @Override // com.bytedance.pangle.res.a.h
                public final int a(int i3) {
                    String str = "0x" + Integer.toHexString(i3);
                    String str2 = (String) jSONObject3.opt(str);
                    if (str2 == null) {
                        return i3;
                    }
                    int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    if (identifier == 0) {
                        identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    }
                    if (identifier == 0) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                        return i3;
                    }
                    String str3 = "0x" + Integer.toHexString(identifier);
                    if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                        jSONObject4.remove(str);
                    }
                    try {
                        jSONObject4.put(str3, str2);
                    } catch (Throwable th2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th2);
                    }
                    if (identifier != i3) {
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 1;
                    }
                    return identifier;
                }

                @Override // com.bytedance.pangle.res.a.h
                public final boolean a(String str) {
                    return hashSet.contains(str);
                }
            });
            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr2[0]);
            if (com.bytedance.pangle.util.h.a(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                com.bytedance.pangle.util.g.a(zipFile);
                return 100;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
            sb.append("writeText failed.");
            com.bytedance.pangle.util.g.a(zipFile);
            return 300;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                sb.append("modifyRes failed. catch: ");
                sb.append(th.getMessage());
                return 300;
            } finally {
                if (zipFile2 != null) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                }
            }
        }
    }

    /* renamed from: com.bytedance.pangle.res.a.c$1 */
    final class AnonymousClass1 implements h {

        /* renamed from: a */
        final /* synthetic */ JSONObject f6264a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f6265b;

        /* renamed from: c */
        final /* synthetic */ int[] f6266c;

        /* renamed from: d */
        final /* synthetic */ HashSet f6267d;

        AnonymousClass1(JSONObject jSONObject3, JSONObject jSONObject4, int[] iArr2, HashSet hashSet2) {
            jSONObject3 = jSONObject3;
            jSONObject4 = jSONObject4;
            iArr = iArr2;
            hashSet = hashSet2;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final int a(int i3) {
            String str = "0x" + Integer.toHexString(i3);
            String str2 = (String) jSONObject3.opt(str);
            if (str2 == null) {
                return i3;
            }
            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
            if (identifier == 0) {
                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
            }
            if (identifier == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                return i3;
            }
            String str3 = "0x" + Integer.toHexString(identifier);
            if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                jSONObject4.remove(str);
            }
            try {
                jSONObject4.put(str3, str2);
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th2);
            }
            if (identifier != i3) {
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
            }
            return identifier;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final boolean a(String str) {
            return hashSet.contains(str);
        }
    }

    private static void a(File file, HashSet<String> hashSet, h hVar) {
        int i2;
        MappedByteBuffer a2 = a(file);
        int capacity = a2.capacity();
        if (capacity >= 22) {
            int i3 = capacity - 22;
            int min = Math.min(i3, 65535);
            for (int i4 = 0; i4 < min; i4++) {
                i2 = i3 - i4;
                if (a2.getInt(i2) == 101010256 && a2.getShort(i2 + 20) == i4) {
                    break;
                }
            }
        }
        i2 = -1;
        if (i2 != -1) {
            int i5 = a2.getInt(i2 + 12);
            int i6 = a2.getInt(i2 + 16);
            int i7 = i5 + i6;
            while (i6 < i7) {
                if (a2.getInt(i6) == 33639248) {
                    int i8 = a2.getShort(i6 + 28);
                    short s = a2.getShort(i6 + 30);
                    byte[] bArr = new byte[i8];
                    for (int i9 = 0; i9 < i8; i9++) {
                        bArr[i9] = a2.get(i6 + 46 + i9);
                    }
                    String str = new String(bArr);
                    int i10 = a2.getInt(i6 + 20);
                    int i11 = a2.getInt(i6 + 24);
                    if (hashSet.contains(str)) {
                        if (i10 == i11) {
                            com.bytedance.pangle.util.e<Integer, byte[]> a3 = a(a2, a2.getInt(i6 + 42), str);
                            try {
                                byte[] bArr2 = a3.f6331b;
                                if (!TextUtils.isEmpty(str) && hVar.a(str)) {
                                    if (str.equals("AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if (str.equals("resources.arsc")) {
                                        new a(bArr2, hVar).a();
                                    }
                                }
                                for (int i12 = 0; i12 < a3.f6331b.length; i12++) {
                                    a2.put(a3.f6330a.intValue() + i12, a3.f6331b[i12]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i6 += i8 + 46 + s;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + a2.getInt(i6));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.bytedance.pangle.util.e<Integer, byte[]> a(MappedByteBuffer mappedByteBuffer, int i2, String str) {
        if (mappedByteBuffer.getInt(i2) == 67324752) {
            int i3 = mappedByteBuffer.getInt(i2 + 18);
            int i4 = mappedByteBuffer.getInt(i2 + 22);
            if (i3 == i4) {
                byte[] bArr = new byte[i4];
                int i5 = i2 + 30 + mappedByteBuffer.getShort(i2 + 26) + mappedByteBuffer.getShort(i2 + 28);
                for (int i6 = 0; i6 < i4; i6++) {
                    bArr[i6] = mappedByteBuffer.get(i5 + i6);
                }
                return new com.bytedance.pangle.util.e<>(Integer.valueOf(i5), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i3 + " size:" + i4);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i2) + " FileName:" + str);
    }

    private static MappedByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
            byte[] bArr = new byte[4194304];
            long j2 = size / 4194304;
            int i2 = (int) (size % 4194304);
            for (int i3 = 0; i3 < j2; i3++) {
                map.get(bArr);
            }
            if (i2 > 0) {
                map.get(new byte[i2]);
            }
            map.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.close();
            return map;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }
}
