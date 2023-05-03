package com.hour14.pyropro.pyroproauthservice.model;

import com.hour14.pyropro.pyroproauthservice.util.Transformer;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRole implements Transformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;

}
