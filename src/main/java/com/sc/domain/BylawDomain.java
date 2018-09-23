package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_bylaws")
public class BylawDomain extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String bylawsName;

    /**
     * 编号
     */
    private String bylawsNo;

    /**
     * 发文文号
     */
    private String articleNo;

    /**
     * 发文时间
     */
    private Date articleTime;

    /**
     * （如果不直接保存内容，则以文件或页面的形式保存）
     */
    private String fileUrl;

    private String bylawsCategory;

    /**
     * 规章制度内容
     */
    private String bylawsContent;

    public String getBylawsName() {
        return bylawsName;
    }

    public void setBylawsName(String bylawsName) {
        this.bylawsName = bylawsName == null ? null : bylawsName.trim();
    }

    public String getBylawsNo() {
        return bylawsNo;
    }

    public void setBylawsNo(String bylawsNo) {
        this.bylawsNo = bylawsNo == null ? null : bylawsNo.trim();
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo == null ? null : articleNo.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getBylawsCategory() {
        return bylawsCategory;
    }

    public void setBylawsCategory(String bylawsCategory) {
        this.bylawsCategory = bylawsCategory == null ? null : bylawsCategory.trim();
    }

    public String getBylawsContent() {
        return bylawsContent;
    }

    public void setBylawsContent(String bylawsContent) {
        this.bylawsContent = bylawsContent == null ? null : bylawsContent.trim();
    }
    
}