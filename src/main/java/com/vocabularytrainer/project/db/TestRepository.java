package com.vocabularytrainer.project.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// with this, we can make the connection to the database - "connection layer"
// JPA = Java Persistence API for managing relational data (=Database)
// We use JPQL (="SQL" queries in Java) to make queries
public interface TestRepository extends JpaRepository<TestingMode, Integer> {

    /* Queries */

    @Query(value="SELECT u FROM TestingMode u")
    List<TestingMode> showAllVocabulary();

    @Query(value="SELECT x FROM TestingMode x WHERE x.user = :paruser AND x.test_number = 1 ")
    // using <List> Java Template we save everything in there ad use as Data Type the table
    List<TestingMode> showTestFromUserX(
            @Param("paruser") String paruser // Parameter Handling for JPQL-Style queries
    );

    @Query(value="DELETE FROM TestingMode x WHERE x.user = :paruser")
    void deleteTable(
            @Param("paruser") String paruser // Parameter Handling for JPQL-Style queries
    );

    @Query(value="SELECT i FROM TestingMode i WHERE i.id = :parid")
    TestingMode getEntryBasedOnId(
            @Param("parid") int parid
    );

    @Query(value="SELECT j FROM TestingMode j WHERE j.user = :paruser AND j.id IN :ids")
    List<TestingMode> getSelectedIdsFromUserX(
            @Param("paruser") String paruser,
            @Param("ids") List<Integer> ids
    );
}
