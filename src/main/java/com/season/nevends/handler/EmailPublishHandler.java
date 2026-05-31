package com.season.nevends.handler;
//import com.season.nevends.model.EmailDetails;
import com.season.nevends.model.NotificationRequest;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class EmailPublishHandler {

    @Value("${twilio.sendgrid.fromEmail:sampleEmail}")
    private String fromEmail;

    @Value("${twilio.sendgrid.sgApikey:sampleKey}")
    private String sgApiKey;

    
    public void publishEmailNotification(NotificationRequest notificationRequest) throws IOException {
        log.info("Preparing email notification(s).");

        Mail mail = buildEmailMessage(notificationRequest);

        SendGrid sg = new SendGrid(sgApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            throw ex;
        }


    }

    // Add method to subscribe users to an email topic for notifications
    public void subscribeToEmailTopic() {

    }

    // Add method to unsubscribe users from an email topic for notifications
    public void unsubscribeFromEmailTopic() {
    }


    private Mail buildEmailMessage(NotificationRequest notificationRequest) {
        log.info("Building Email Notification Messages.");

        // TODO: Build subject, content, attachments
//        EmailDetails emailDetails = buildEmailDetails(notificationRequest);

        Email from = new Email(fromEmail);
        String subject = "Sending with Twilio SendGrid is Fun - hidden emails";
        Content content = new Content("text/html", "Welcome to the Twilio SendGrid world where you can send <strong>bulk emails</strong>!");

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);

        notificationRequest.getEmailRecipients().forEach(recipient -> {
            Personalization personalization = new Personalization();
            personalization.addTo(new Email(recipient));
            mail.addPersonalization(personalization);
        });

        return mail;
    }

    // TODO: Need a method to draft email contents
//    private EmailDetails buildEmailDetails(NotificationRequest notificationRequest) {
//        log.info("Building email details");
//        EmailDetails emailDetails = new EmailDetails();
//        emailDetails.setSubject("");
//
//        return emailDetails;
//    }


    public void sendEmailNotificationV1(NotificationRequest notificationRequest, String htmlContent) throws IOException {
        log.info("Building email notification - V1");

        Email from = new Email(fromEmail);
        String subject = notificationRequest.getNotificationType().getEmailSubject();
        Content content = new Content("text/html", htmlContent);

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);

        notificationRequest.getEmailRecipients().forEach(recipient -> {
            Personalization personalization = new Personalization();
            personalization.addTo(new Email(recipient));
            mail.addPersonalization(personalization);
        });

        SendGrid sg = new SendGrid(sgApiKey);
        Request request = new Request();
        try {
            log.info("Sending Email Notification - V1");
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            throw ex;
        }


    }

}
