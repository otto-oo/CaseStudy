package com.pureenergy.casestudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="movies")
public class Movie extends BaseEntity{

    private String movieName;
    private String movieDetails;
    private int movieYear;
    private String director;
    private String movieUrl;

}
