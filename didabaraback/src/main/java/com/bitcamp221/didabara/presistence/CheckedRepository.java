package com.bitcamp221.didabara.presistence;

import com.bitcamp221.didabara.model.CategoryItemEntity;
import com.bitcamp221.didabara.model.CheckedEntity;
import com.bitcamp221.didabara.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckedRepository extends JpaRepository<CheckedEntity, Long> {

    void deleteByCategoryItem(@Param("categoryItemId") final Long categoryItemId);

    @Query("SELECT u.nickname, ui.profileImageUrl FROM CheckedEntity c INNER JOIN UserEntity u " +
            "INNER JOIN UserInfoEntity ui ON c.categoryItem = :categoryItemId")
    List<UserEntity> checkUserList(@Param("categoryItemId") final Long categoryItemId);

    @Query("SELECT ci.title, ci.preview FROM SubscriberEntity s INNER JOIN CategoryItemEntity ci " +
            "LEFT OUTER JOIN CheckedEntity c ON s.category = :categoryItemId WHERE s.user = :user AND c IS NULL")
    List<CategoryItemEntity> findUnCheckUserList(@Param("categoryItemId") final Long categoryItemId, @Param("user") final Long user);

    @Query("SELECT ci.id, ci.category, ci.title FROM CategoryItemEntity ci LEFT OUTER JOIN CheckedEntity ch ON ci.id = ch.categoryItem WHERE ch.user = :user")
    List<CategoryItemEntity> findMyCheckList(@Param("user") final Long user);

    @Query("SELECT c FROM CheckedEntity c WHERE c.id = :userId")
    List<UserEntity> findMyUnCheckList(@Param("userId") final Long userId);

    boolean existsByUser(@Param("user") final Long user);
}