package com.martian.mibook.data.book;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Comment {
    private String bookId;
    private String chapterName;
    private Integer cid;
    private String content;
    private Long createdOn;
    private String cuid;
    private Boolean hasUp;
    private String header;
    private Long modifiedOn;
    private String nickname;
    private Integer readDuration;
    private List<CommentReply> replyList;
    private Integer score;
    private Long siftTime;
    private Long topTime;
    private String uid;
    private Boolean vip;
    private Integer upCount = 0;
    private Integer downCount = 0;
    private Integer replyCount = 0;

    public String getBookId() {
        return this.bookId;
    }

    public String getChapterName() {
        return this.chapterName;
    }

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

    public Integer getDownCount() {
        return this.downCount;
    }

    public boolean getHasUp() {
        Boolean bool = this.hasUp;
        return bool != null && bool.booleanValue();
    }

    public String getHeader() {
        return this.header;
    }

    public Long getModifiedOn() {
        return this.modifiedOn;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getReadDuration() {
        Integer num = this.readDuration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getReplyCount() {
        Integer num = this.replyCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public List<CommentReply> getReplyList() {
        if (this.replyList == null) {
            this.replyList = new ArrayList();
        }
        return this.replyList;
    }

    public int getScore() {
        Integer num = this.score;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public long getSiftTime() {
        Long l = this.siftTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public long getTopTime() {
        Long l = this.topTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getUid() {
        return this.uid;
    }

    public int getUpCount() {
        Integer num = this.upCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getVip() {
        Boolean bool = this.vip;
        return bool != null && bool.booleanValue();
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
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

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public void setHasUp(Boolean hasUp) {
        this.hasUp = hasUp;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setReadDuration(Integer readDuration) {
        this.readDuration = readDuration;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public void setReplyList(List<CommentReply> replyList) {
        this.replyList = replyList;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setSiftTime(Long siftTime) {
        this.siftTime = siftTime;
    }

    public void setTopTime(Long topTime) {
        this.topTime = topTime;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }
}
