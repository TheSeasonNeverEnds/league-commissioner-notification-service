package com.season.nevends.service;

import com.season.nevends.handler.EmailPublishHandler;
import com.season.nevends.model.NotificationRequest;
import com.season.nevends.model.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceV1 {

    @Autowired
    private EmailPublishHandler emailPublishHandler;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmail(NotificationRequest request) {


//        Map<String, Object> variables = new HashMap<>(Map.of(
//                "leagueId", request.getLeagueId(),
//                "leagueName", request.getLeagueName(),
//                "leagueCode", request.getLeagueCode(),
//                "leagueJoinUrl", request.getLeagueJoinUrl(),
//                "venueId", request.getVenueId(),
//                "oneTimeToken", request.getOneTimeToken()
//        ));

        Map<String, Object> variables = new HashMap<>();
        variables.put("leagueId", request.getLeagueId());
        variables.put("leagueName", request.getLeagueName());
        variables.put("leagueCode", request.getLeagueCode());
        variables.put("leagueJoinUrl", request.getLeagueJoinUrl());
        variables.put("venueId", request.getVenueId());
        variables.put("oneTimeToken", request.getOneTimeToken());

        try {

            if (request.getNotificationType() == (NotificationType.PASSWORD_RESET)){
                variables.put("recipient", request.getEmailRecipients().getFirst());
            }

            // 1. Prepare Thymeleaf Context
            Context context = new Context();
            context.setVariables(variables);

            // 2. Process Template into HTML String
            String htmlContent = templateEngine.process(request.getNotificationType().getEmailTemplateName(), context);

            // 3. Create and Send Email
            emailPublishHandler.sendEmailNotificationV1(request, htmlContent);

        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public boolean validateEmailNotificationRequest(NotificationRequest request) {
        log.info("Validating email notification v1 request for {}", request.getNotificationType());


        if (request.getNotificationType() == (NotificationType.PASSWORD_RESET)){
            return StringUtils.isNotBlank(request.getOneTimeToken());
        }
        if (request.getNotificationType() == (NotificationType.LEAGUE_INVITATION)){
            return ( StringUtils.isNotBlank(request.getLeagueCode()) && StringUtils.isNotBlank(request.getLeagueJoinUrl())
                && StringUtils.isNotBlank(request.getLeagueName()) );
        }
        return false;
    }

    /*
    If you have a String (like from an API or user input) and want to see if
    it's a valid member of your Enum without crashing the app:
    public static boolean isValid(String value) {
        return Arrays.stream(MyEnum.values())
                .anyMatch(e -> e.name().equals(value));
    }
    */

}