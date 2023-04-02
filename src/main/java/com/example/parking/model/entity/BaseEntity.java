package com.example.parking.model.entity;

import com.example.parking.constant.EntityStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Column (name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    @Generated (value = GenerationTime.ALWAYS)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column (name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Type(type = "com.parking.constant.EntityStatus")
    @Column(name = "status")
    private EntityStatus.Type entityStatus = EntityStatus.Type.ACTIVE;
}

