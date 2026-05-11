package com.season.nevends.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class NotificationRequest {

    @NotBlank
    private String leagueId;
    private String leagueCode;
    private String leagueName;
    private Long venueId;
    //private Notification notificationType;
    private List<String> emailRecipients;

}


