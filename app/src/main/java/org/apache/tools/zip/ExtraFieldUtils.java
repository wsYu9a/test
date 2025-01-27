package org.apache.tools.zip;

import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class ExtraFieldUtils {
    static /* synthetic */ Class class$org$apache$tools$zip$AsiExtraField;
    static /* synthetic */ Class class$org$apache$tools$zip$JarMarker;
    private static Hashtable implementations = new Hashtable();

    static {
        Class cls = class$org$apache$tools$zip$AsiExtraField;
        if (cls == null) {
            cls = class$("org.apache.tools.zip.AsiExtraField");
            class$org$apache$tools$zip$AsiExtraField = cls;
        }
        register(cls);
        Class cls2 = class$org$apache$tools$zip$JarMarker;
        if (cls2 == null) {
            cls2 = class$("org.apache.tools.zip.JarMarker");
            class$org$apache$tools$zip$JarMarker = cls2;
        }
        register(cls2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = (Class) implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (int i3 = 0; i3 < zipExtraFieldArr.length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getCentralDirectoryLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i3].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData, 0, bArr, i2 + 4, centralDirectoryData.length);
            i2 += centralDirectoryData.length + 4;
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (int i3 = 0; i3 < zipExtraFieldArr.length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getLocalFileDataLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i3].getLocalFileDataData();
            System.arraycopy(localFileDataData, 0, bArr, i2 + 4, localFileDataData.length);
            i2 += localFileDataData.length + 4;
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        Vector vector = new Vector();
        int i2 = 0;
        while (i2 <= bArr.length - 4) {
            ZipShort zipShort = new ZipShort(bArr, i2);
            int value = new ZipShort(bArr, i2 + 2).getValue();
            int i3 = i2 + 4;
            if (i3 + value > bArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("data starting at ");
                stringBuffer.append(i2);
                stringBuffer.append(" is in unknown format");
                throw new ZipException(stringBuffer.toString());
            }
            try {
                ZipExtraField createExtraField = createExtraField(zipShort);
                createExtraField.parseFromLocalFileData(bArr, i3, value);
                vector.addElement(createExtraField);
                i2 += value + 4;
            } catch (IllegalAccessException e2) {
                throw new ZipException(e2.getMessage());
            } catch (InstantiationException e3) {
                throw new ZipException(e3.getMessage());
            }
        }
        if (i2 == bArr.length) {
            ZipExtraField[] zipExtraFieldArr = new ZipExtraField[vector.size()];
            vector.copyInto(zipExtraFieldArr);
            return zipExtraFieldArr;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("data starting at ");
        stringBuffer2.append(i2);
        stringBuffer2.append(" is in unknown format");
        throw new ZipException(stringBuffer2.toString());
    }

    public static void register(Class cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cls);
            stringBuffer.append(" doesn't implement ZipExtraField");
            throw new RuntimeException(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(cls);
            stringBuffer2.append("'s no-arg constructor is not public");
            throw new RuntimeException(stringBuffer2.toString());
        } catch (InstantiationException unused3) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(cls);
            stringBuffer3.append(" is not a concrete class");
            throw new RuntimeException(stringBuffer3.toString());
        }
    }
}
