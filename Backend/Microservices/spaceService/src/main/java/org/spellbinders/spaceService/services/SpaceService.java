package org.spellbinders.spaceService.services;

import org.spellbinders.spaceService.entities.Space;
import org.spellbinders.spaceService.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    private SpaceRepository spaceRepository;

    public Space createGroup(String spaceName, Long adminId) {
        Space space = new Space();
        space.setName(spaceName);
        space.setAdminId(adminId);
        return spaceRepository.save(space);
    }

    public Optional<Space> joinGroup(String joinCode, Long userId) {
        Optional<Space> spaceOptional = spaceRepository.findByJoinCode(joinCode);
        if (spaceOptional.isPresent()) {
            Space space = spaceOptional.get();
            space.members.add(userId);
            spaceRepository.save(space);
            return Optional.of(space);
        }
        return Optional.empty();
    }
}
