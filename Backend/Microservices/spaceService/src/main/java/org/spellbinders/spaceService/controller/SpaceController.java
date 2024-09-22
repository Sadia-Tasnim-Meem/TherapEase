package org.spellbinders.spaceService.controller;


import org.spellbinders.spaceService.entities.Space;
import org.spellbinders.spaceService.services.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @PostMapping("/create")
    public ResponseEntity<Space> createGroup(@RequestParam String spaceName, @RequestParam Long adminId) {
        Space group = spaceService.createGroup(spaceName, adminId);
        return ResponseEntity.ok(group);
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinGroup(@RequestParam String joinCode, @RequestParam Long userId) {
        Optional<Space> group = spaceService.joinGroup(joinCode, userId);
        if (group.isPresent()) {
            return ResponseEntity.ok("Joined group successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid join code.");
        }
    }
}

