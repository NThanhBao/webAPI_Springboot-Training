package com.example.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.Users;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add roles to authorities
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public Users save(UserDTO user) {
        // Kiểm tra xem username đã tồn tại hay chưa
        if (userDao.findByUsername(user.getUsername()) != null) {
            // Nếu đã tồn tại, ném một ngoại lệ hoặc trả về một thông báo lỗi
            throw new RuntimeException("Username đã tồn tại");
        }

        Users newUser = new Users();
        Role role = roleRepo.findById(user.getRoleId()).orElse(null);

        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
//        newUser.setPhone(user.getPhone());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setGender(user.getGender());
        newUser.setBirthDay(user.getBirthDay());
        newUser.setAdress(user.getAdress());
        newUser.setJob(user.getJob());
        newUser.setRole(role);

        return userDao.save(newUser);
    }
}