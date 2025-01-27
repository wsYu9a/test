package com.google.thirdparty.publicsuffix;

import a5.a;
import a5.b;
import m5.d;

@b
@a
/* loaded from: classes2.dex */
public enum PublicSuffixType {
    PRIVATE(d.f28378d, ','),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c10, char c11) {
        this.innerNodeCode = c10;
        this.leafNodeCode = c11;
    }

    public static PublicSuffixType fromCode(char c10) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c10 || publicSuffixType.getLeafNodeCode() == c10) {
                return publicSuffixType;
            }
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("No enum corresponding to given code: ");
        sb2.append(c10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
