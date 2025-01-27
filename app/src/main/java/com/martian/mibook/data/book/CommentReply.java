package com.martian.mibook.data.book;

/* loaded from: classes3.dex */
public class CommentReply {
    private Integer cid;
    private String content;
    private Long createdOn;
    private String cuid;
    private Boolean hasUp;
    private String header;
    private String nickname;
    private Comment refComment;
    private CommentReply refReply;
    private Integer refRid;
    private Integer rid;
    private String toNickname;
    private String toUid;
    private Integer upCount;
    private Boolean vip;

    public Integer getCid() {
        return this.cid;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public String getCuid() {
        return this.cuid;
    }

    public Boolean getHasUp() {
        return this.hasUp;
    }

    public String getHeader() {
        return this.header;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Comment getRefComment() {
        return this.refComment;
    }

    public CommentReply getRefReply() {
        return this.refReply;
    }

    public Integer getRefRid() {
        return this.refRid;
    }

    public Integer getRid() {
        return this.rid;
    }

    public String getToNickname() {
        return this.toNickname;
    }

    public String getToUid() {
        return this.toUid;
    }

    public Integer getUpCount() {
        return this.upCount;
    }

    public Boolean getVip() {
        return this.vip;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public void setHasUp(Boolean hasUp) {
        this.hasUp = hasUp;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRefComment(Comment refComment) {
        this.refComment = refComment;
    }

    public void setRefReply(CommentReply refReply) {
        this.refReply = refReply;
    }

    public void setRefRid(Integer refRid) {
        this.refRid = refRid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public void setToNickname(String toNickname) {
        this.toNickname = toNickname;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }
}
