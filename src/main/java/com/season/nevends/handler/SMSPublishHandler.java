package com.season.nevends.handler;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SMSPublishHandler {

    /*
        This class will handle sending SMS Notifications, subscribing and unsubscribing from SMS topics.
        Still need to figure out if SMS

     */

    public void sendSMSMessage(){
        // Find your Account SID and Auth Token at twilio.com/console
        // and set the environment variables. See http://twil.io/secure

        String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
        String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new com.twilio.type.PhoneNumber("+18777804236"),
                        new com.twilio.type.PhoneNumber("+15017122661"),
                        "This is the ship that made the Kessel Run in fourteen parsecs?")
                .create();


        System.out.println(message.getBody());

    }


    // Add method to publish SMS to subscribers
    public void pushSMSNotifications() {

    }

    // Add method to subscribe users to an SMS topic for notifications
    public void subcribeToSMSNotifications() {

    }

    // Add method to unsubscribe users from an SMS topic for notifications
    public void unsubscribeFromSMSNotifications() {

    }

}
