package com.kyho.blog.service;

import com.kyho.blog.entities.Role;
import com.kyho.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repo;

    public Role getRole(String role) { return repo.findByRole(role); }

}
