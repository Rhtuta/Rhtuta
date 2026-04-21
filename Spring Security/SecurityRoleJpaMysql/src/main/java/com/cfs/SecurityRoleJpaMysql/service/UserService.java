package com.cfs.SecurityRoleJpaMysql.service;

import com.cfs.SecurityRoleJpaMysql.Entity.AppUser;
import com.cfs.SecurityRoleJpaMysql.Entity.Role;
import com.cfs.SecurityRoleJpaMysql.controller.ListUserRequests;
import com.cfs.SecurityRoleJpaMysql.controller.UserRequest;
import com.cfs.SecurityRoleJpaMysql.repo.roleRepository;
import com.cfs.SecurityRoleJpaMysql.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private userRepository userRepo;

    @Autowired
    private roleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void saveUser(List<UserRequest> userRequests)
    {
        for (UserRequest req : userRequests)
        {
            AppUser user = new AppUser();
            user.setUsername(req.getUsername());
            user.setPassword(encoder.encode(req.getPassword()));
            user.setEnabled(true);

            Set<Role> roleSet = new HashSet<>();
            for (String roleName : req.getRoles())
            {
                Role role = roleRepo.findByName(roleName)
                        .orElseGet(()->{
                            Role newRole = new Role();
                            newRole.setName(roleName);
                            return roleRepo.save(newRole);
                        });

                roleSet.add(role);
            }
            user.setRoles(roleSet);
            userRepo.save(user);


        }
    }

}
