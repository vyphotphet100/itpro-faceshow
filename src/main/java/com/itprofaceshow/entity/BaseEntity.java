package com.itprofaceshow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import static javax.persistence.TemporalType.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {
    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_date")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

}
