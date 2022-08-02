package com.glady.user;

import com.glady.db.entity.User;

import java.util.function.Function;

public class UserAdapter implements Function<User, com.glady.user.User> {

    @Override
    public com.glady.user.User apply(User user){
        return new com.glady.user.User(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getDateOfBirth(),
                user.getAddress(),
                user.getPosition(),
                user.getCompagny() != null ? user.getCompagny().getName() : null
        );
    }
}
