package com.as.fuyue.bean;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class ThirdBean {
    private String titleThird;//作品

    private String content; //内容

    public ThirdBean(String titleThird, String content) {
        this.titleThird = titleThird;
        this.content = content;
    }

    public String getTitleThird() {
        return titleThird;
    }

    public void setTitleThird(String titleThird) {
        this.titleThird = titleThird;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
