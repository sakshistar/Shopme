package com.shopme.admin.repository;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void setUserDetails(){
        User user = new User("ski@gmail.com","sakshi","yadav","ski123.");
        User saveUser = userRepository.save(user);
        assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithOneRole() {
        Role role = entityManager.find(Role.class,2);
        User userNamHM = new User("nam@codejava.net", "nam2020", "Nam", "Ha Minh");
        userNamHM.addRoles(role);
        User savedUser = userRepository.save(userNamHM);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRoles() {
        User userRavi = new User("ravi@gmail.com", "ravi2020", "Ravi", "Kumar");
        Role roleEditor = new Role(4);
        Role roleAssistant = new Role(6);

        userRavi.addRoles(roleEditor);
        userRavi.addRoles(roleAssistant);

        User savedUser = userRepository.save(userRavi);

        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = userRepository.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        User userNam = userRepository.findById(1).get();
        System.out.println(userNam);
        Assertions.assertThat(userNam).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User userNam = userRepository.findById(1).get();
        userNam.setEnabled(true);
        userNam.setEmail("namjavaprogrammer@gmail.com");

        userRepository.save(userNam);
    }

    @Test
    public void testUpdateUserRoles() {
        User userRavi = userRepository.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userRavi.getRoles().remove(roleEditor);
        userRavi.addRoles(roleSalesperson);

        userRepository.save(userRavi);
    }

    @Test
    public void testDeleteUser() {
        Integer userId = 2;
        userRepository.deleteById(userId);

    }




}