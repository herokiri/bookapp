package ru.dstu.bookapp.services;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dstu.bookapp.entities.Role;
import ru.dstu.bookapp.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getUserRole(String name) {
        return roleRepository.findRoleByName(name).get();
    }
}
