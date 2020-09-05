/**
 * 
 */
package com.example.venu.springlearning.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author venugopal
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
