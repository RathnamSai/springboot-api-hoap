package com.hoap.serviceimpl;

import com.hoap.bean.SignupRequest;
import com.hoap.bean.UserObjectDataBean;
import com.hoap.exception.ErrorDetails;
import com.hoap.exception.GenericStatusBean;
import com.hoap.model.Role;
import com.hoap.model.User;
import com.hoap.repository.UserRepository;
import com.hoap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.hoap.util.IConstants.ERROR_CODE_THREE_DATA_ADD_FAILURE;
import static com.hoap.util.IConstants.USER_NOT_REGISTERED_MSG;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    public User findByEmail(String email){
//        return userRepository.findByEmail(email);
//    }

    public GenericStatusBean save(SignupRequest signupRequest){
        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setCreatedOn(LocalDateTime.now());
        //user.setRoles(Arrays.asList(new Role("ROLE_USER")));

        User userAdded = userRepository.save(user);
        GenericStatusBean gsBean =
                userAdded != null ? new GenericStatusBean(new ErrorDetails(), new UserObjectDataBean(signupRequest))
                        : new GenericStatusBean(new ErrorDetails(ERROR_CODE_THREE_DATA_ADD_FAILURE, USER_NOT_REGISTERED_MSG),
                        new ArrayList<>());
        return gsBean;
    }

    public GenericStatusBean getAllUsers(){
        List<User> user = userRepository.findAll();
        GenericStatusBean gsBean =
                user != null ? new GenericStatusBean(new ErrorDetails(), new UserObjectDataBean(user))
                        : new GenericStatusBean(new ErrorDetails(ERROR_CODE_THREE_DATA_ADD_FAILURE, USER_NOT_REGISTERED_MSG),
                        new ArrayList<>());

        return gsBean;
    }

    public GenericStatusBean findByEmail(String email){
        User user = userRepository.findByEmail(email);
        GenericStatusBean gsBean =
                user != null ? new GenericStatusBean(new ErrorDetails(), new UserObjectDataBean(user))
                        : new GenericStatusBean(new ErrorDetails(ERROR_CODE_THREE_DATA_ADD_FAILURE, USER_NOT_REGISTERED_MSG),
                        new ArrayList<>());

        return gsBean;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//        if (user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));
//    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
}

