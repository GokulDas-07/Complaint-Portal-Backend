package com.nest.complaintportal_backend.controller;

import com.nest.complaintportal_backend.dao.ComplaintDao;
import com.nest.complaintportal_backend.model.Complaint;
import com.nest.complaintportal_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {
    @Autowired
    ComplaintDao dao1;

   @CrossOrigin(origins = "*")
   @PostMapping(path = "/addcomplaint",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addComplaints(@RequestBody Complaint c)
   {
       HashMap<String,String> map= new HashMap<>();
       dao1.save(c);
       map.put("status","success");
       return map;
   }

   @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallcomplaints")
    public List<Map<String,String>> viewAllComplaints()
   {
       return (List<Map<String, String>>) dao1.viewAllComplaints();
   }

   @CrossOrigin(origins = "*")
    @PostMapping(path ="/viewcomplaint",consumes ="application/json",produces = "application/json")
    public List<Complaint> viewComplaints(@RequestBody Complaint c)
   {
       System.out.println(c.getUserId());
       return (List<Complaint>) dao1.viewComplaints(c.getUserId());

   }


}
