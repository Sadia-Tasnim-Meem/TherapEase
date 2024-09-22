package org.spellbinders.spaceService.repository;

import org.spellbinders.spaceService.entities.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpaceRepository extends JpaRepository<Space, Long> {
    Optional<Space> findByJoinCode(String joinCode);
}
