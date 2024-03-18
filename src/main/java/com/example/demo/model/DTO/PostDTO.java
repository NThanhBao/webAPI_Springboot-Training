package com.example.demo.model.DTO;

public class PostDTO {
    private String content;
    private String title;
    private Long id;
    private Long UserId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getUserId() {
        return UserId;
    }
}
