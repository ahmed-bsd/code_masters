package com.example.immomicroservice.Repository;

import com.example.immomicroservice.entities.Investissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestissmentRepository extends JpaRepository<Investissement,Long> {
    @Query(value = "SELECT * FROM investissement e WHERE e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type", nativeQuery = true)
    List<Investissement> findInvestissementByCategoryAndCityAndRegion(@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);

    //  @Query(value = "SELECT * FROM investisment e WHERE e.category =:category AND e.city =:city AND e.region =:region AND e.type =:type",nativeQuery = true)
    // List<Investisment> findInvestismentByCategoryAndCityAndRegion(@Param("category") String category,@Param("city") String city,@Param("region") String region,@Param("type") String type);
    @Query(value = "Select * FROM investissement i WHERE i.type LIKE 'À Vendre' ",nativeQuery = true)
    List<Investissement> findByTypeVente();
    @Query(value = "Select * FROM investissement i WHERE i.type LIKE 'À Louer' ",nativeQuery = true)
    List<Investissement> findByTypeVLocation();

    @Query(value = "SELECT DISTINCT * FROM investissement i WHERE " +
            "i.price < :price AND (i.category='Appartements' OR i.category='Maisons et Villas') " +
            "GROUP BY i.id ORDER BY price desc LIMIT 3",nativeQuery = true)
    List<Investissement> findLessPrices(@Param("price") float price);

    @Query(value="SELECT MAX(price) FROM investissement e WHERE e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float findMaxInvest(@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);
    @Query(value="SELECT MIN(price) FROM investissement e WHERE e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float findMinInvest(@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);

    @Query(value="SELECT AVG(price) FROM investissement e WHERE e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float average(@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);

    // **************Appart :

    @Query(value="SELECT MAX(price) FROM investissement e WHERE e.roomsCount = :roomsCount AND e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float findMaxInvestA(@Param("roomsCount") String roomsCount,@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);

    @Query(value="SELECT MIN(price) FROM investissement e WHERE e.roomsCount = :roomsCount AND e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float findMinInvestA(@Param("roomsCount") String roomsCount,@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);

    @Query(value="SELECT AVG(price) FROM investissement e WHERE e.roomsCount = :roomsCount AND e.category = :category AND e.city = :city AND e.region = :region AND e.type = :type ",nativeQuery = true)
    Float averageA(@Param("roomsCount") String roomsCount,@Param("category") String category, @Param("city") String city, @Param("region") String region, @Param("type") String type);


}
