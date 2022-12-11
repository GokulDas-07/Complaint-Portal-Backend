package com.nest.complaintportal_backend.dao;

import com.nest.complaintportal_backend.model.Complaint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<Complaint,Integer> {

    @Query(value = "SELECT u.`address`, u.`mail`, u.`name`, u.`phone`, c.complaint, c.user_id FROM `user`u JOIN complaint c ON c.user_id= u.id",nativeQuery = true)
    List<Map<String,String>> viewAllComplaints();

    @Query(value = "SELECT `id`, `complaint`, `user_id` FROM `complaint` WHERE `user_id`=:user_id",nativeQuery = true)
    List<Complaint> viewComplaints(@Param("user_id")Integer user_id);


}
