package com.season.nevends.model;

import lombok.Getter;


@Getter
public enum Notification {

    PROMOTION("Promotion"),
    DRAFT("Draft"),
    ANNOUNCEMENT("Announcement"),
    INVITATION("Invitation");

    private final String type;

    Notification(String type) {
        this.type = type;
    }

}