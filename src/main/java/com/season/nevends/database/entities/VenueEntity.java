package com.season.nevends.database.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Bars")
public class VenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BarName")
    private String barName;
    @Column(name = "Address1")
    private String address1;
    @Column(name = "Address2")
    private String address2;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "Zip")
    private String zip;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "FacebookPage")
    private String facebookPage;
    @Column(name = "InstagramAccount")
    private String instagramAccount;
    @Column(name = "XUsername")
    private String xUsername;

    @Column(name = "FacebookUsername")
    private String facebookUsername;
    @Column(name = "InstagramUsername")
    private String instagramUsername;
    @Column(name = "LinkedInUsername")
    private String linkedinUsername;
    @Column(name = "TikTokUsername")
    private String tiktokUsername;
    @Column(name = "UserId")
    private String userId;
    @Column(name = "WebsiteURL")
    private String websiteURL;

}
