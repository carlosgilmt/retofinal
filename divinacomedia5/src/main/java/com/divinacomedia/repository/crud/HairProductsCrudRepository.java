package com.divinacomedia.repository.crud;

import com.divinacomedia.model.HairProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

/**
 *
 * @author Carlos A. Gil
 */
public interface HairProductsCrudRepository extends MongoRepository<HairProducts, String> {
    public List<HairProducts> findByPriceLessThanEqual(double precio);
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<HairProducts> findByDescriptionLike(String description);
}

