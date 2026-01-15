package com.season.nevends.handler;

public class PushNotificationHandler {
// In-App/Mobile Communications

    /*
        This class will handle sending Mobile App Push Notifications, subscribing and unsubscribing from Notification topics.
        As of now, the Topics will be configured in AWS SNS. Once a message/payload is sent to a topic,
        SNS will take care of distributing the message to the subscribers in the topic.

        It can be HTTP/S based.
     */

    // Add method to publish In-App Push Notifications to subscribers
    public void sendPushNotification() {}

    // Add method to subscribe users to In-App Push Notifications
    public void subscribeToPushNotification() {}

    // Add method to unsubscribe users from an email topic for notifications
    public void unsubscribeFromPushNotification() {}

}
