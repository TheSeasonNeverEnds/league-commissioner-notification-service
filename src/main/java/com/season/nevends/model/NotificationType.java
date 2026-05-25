package com.season.nevends.model;

import lombok.Getter;


@Getter
public enum NotificationType {

    // User Events
    PASSWORD_RESET("password-reset", "Reset Your Password"),

    // League Events
    PROMOTION("Promotion", ""),
    DRAFT("Draft", ""),
    ANNOUNCEMENT("Announcement", ""),
    LEAGUE_INVITATION("league-invite", "Fantasy League Invite"),

    // Venue Communications
    VENUE_ONBOARDING("Venue Onboarding", ""),
    VENUE_BILLING_RECEIPT("Venue Billing Receipt", "");

    private final String emailTemplateName;
    private final String emailSubject;


    NotificationType(String emailTemplateName, String emailSubject){
        this.emailTemplateName = emailTemplateName;
        this.emailSubject = emailSubject;
    }

}