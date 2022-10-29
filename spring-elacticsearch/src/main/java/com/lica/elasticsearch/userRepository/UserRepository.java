package com.lica.elasticsearch.userRepository;

import com.lica.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"firstName\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    List<User> findByFirstNameLikeOrLastNameLike(String firstName,String lastName );
}
