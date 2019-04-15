package com.myway.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ebru Göksal
 */

@Entity
@Table(name = "event")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Event {

    @ApiModelProperty(value = "The ID for event")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
    @SequenceGenerator(name = "seq_event", sequenceName = "seq_event", allocationSize = 1)
    private Long id;

    @ApiModelProperty(value = "The UUID for event")
    @Column(name = "EMPLOYEE_UUID")
    private UUID employeeUuid;

    @Column(name = "TOPIC")
    private String topic;

    @Column(name = "EVENT_DATE")
    private LocalDate eventDate;

    @Type(type = "jsonb")
    @Column(name = "employee_json",columnDefinition = "jsonb",unique = true)
    private String employeeJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getEmployeeUuid() {
        return employeeUuid;
    }

    public void setEmployeeUuid(UUID employeeUuid) {
        this.employeeUuid = employeeUuid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEmployeeJson() {
        return employeeJson;
    }

    public void setEmployeeJson(String employeeJson) {
        this.employeeJson = employeeJson;
    }
}
