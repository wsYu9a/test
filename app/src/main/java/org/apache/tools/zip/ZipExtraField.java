package org.apache.tools.zip;

import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromLocalFileData(byte[] bArr, int i2, int i3) throws ZipException;
}
