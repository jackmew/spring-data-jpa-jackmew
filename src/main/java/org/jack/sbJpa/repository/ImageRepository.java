/**
 * 
 */
package org.jack.sbJpa.repository;

import org.jack.sbJpa.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jackho
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
	
}
