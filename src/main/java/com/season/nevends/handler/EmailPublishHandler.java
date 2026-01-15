package com.season.nevends.handler;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailPublishHandler {

    /*
        This class will handle sending emails, subscribing and unsubscribing from Emails topics.
        As of now, the Topics will be configured in AWS SES.
        Once a message/payload is sent to a topic,
        SES will take care of distributing the message to the subscribers in the topic.
    */

    // Add method to publish email to subscribers
    public void sendEmailNotification() {

        Email from = new Email("test@example.com");
        String subject = "Sending with Twilio SendGrid is Fun";
        Email to = new Email("test@example.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {

            throw new RuntimeException();

        }
    }

    // Add method to subscribe users to an email topic for notifications
    public void subscribeToEmailTopic() {

    }

    // Add method to unsubscribe users from an email topic for notifications
    public void unsubscribeFromEmailTopic() {

    }


    public void buildEmailMessage() {}

}
