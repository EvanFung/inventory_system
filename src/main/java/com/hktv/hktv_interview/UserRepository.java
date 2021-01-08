package com.hktv.hktv_interview;

import org.springframework.data.repository.CrudRepository;

import com.hktv.hktv_interview.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}