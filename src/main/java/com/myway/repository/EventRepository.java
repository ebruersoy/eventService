package com.myway.repository;

import com.myway.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author Ebru Göksal
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEmployeeUuidOrderByEventDateAsc(UUID employeeUuid);
}
