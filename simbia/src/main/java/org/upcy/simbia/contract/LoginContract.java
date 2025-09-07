package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.LoginDto;
import org.upcy.simbia.model.Login;

import java.util.Optional;

@RequestMapping("/logins")
public interface LoginContract {

    @PostMapping
    ResponseEntity<Login> create(@RequestBody LoginDto dto);

    @GetMapping("/{id}")
    ResponseEntity<Optional<Login>> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Optional<Login>> update(@PathVariable Long id, @RequestBody LoginDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @PatchMapping("/{id}/last-login")
    ResponseEntity<Void> updateLastLogin(@PathVariable Long id);
}
