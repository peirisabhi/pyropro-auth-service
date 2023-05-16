package com.hour14.pyropro.pyroproauthservice.model;

import com.hour14.pyropro.pyroproauthservice.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 09:44
 */

@Entity
@Table(name = "device")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Device implements Transformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "device_id")
    private String deviceId;

    private int lat;


    private int lan;


    private String district;


    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;
}
