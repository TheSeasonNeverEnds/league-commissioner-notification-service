package com.season.nevends.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class NotificationRequest {


    @NotBlank
    private NotificationType notificationType;

    @NotEmpty
    private List<String> emailRecipients;

    private String leagueId;
    private String leagueCode;
    private String leagueName;
    private String leagueJoinUrl;
    private Long venueId;
    private String oneTimeToken;


}


