CREATE DATABASE employement_portal;

USE employement_portal;

CREATE  TABLE employee (

  `emp_code` INT AUTO_INCREMENT NOT NULL ,

  `first_name` VARCHAR(20) NOT NULL ,

  `middle_name` VARCHAR(20) ,

  `last_name` VARCHAR(20) NOT NULL ,

  `dob` DATE NOT NULL ,

  `gender` VARCHAR(1) NOT NULL ,

  `email` VARCHAR(30) NOT NULL ,

  `primary_contact` VARCHAR(10) NOT NULL ,

  `secondary_contact` VARCHAR(10) NOT NULL ,

  `skype_id` VARCHAR(30) NOT NULL ,

  `profile_picture` VARCHAR(100) DEFAULT 'default_img.jpg',

  `password` VARCHAR(30) NOT NULL DEFAULT '123456' ,

  `enabled`  BOOLEAN NOT NULL DEFAULT true,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`emp_code`) );
  
  
  CREATE  TABLE `job_title` (

  `job_code` INT NOT NULL ,

  `job_title` VARCHAR(30) NOT NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`job_code`) );
 
 
  CREATE  TABLE `user_roles` (

  `user_role_id` INT NOT NULL AUTO_INCREMENT ,

  `username` VARCHAR(30) NOT NULL ,

  `role` VARCHAR(30) NOT NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`user_role_id`) );
  
   
  CREATE  TABLE `skill_master` (

  `skill_id` INT NOT NULL AUTO_INCREMENT ,

  `skill_name` VARCHAR(100) NOT NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`skill_id`) );
  
  
   CREATE  TABLE `employee_skills` (

  `emp_skill_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,

  `emp_code` INT NOT NULL ,

  `skill_code` INT NOT NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON DELETE CASCADE,
  
  FOREIGN KEY (skill_code) REFERENCES skill_master(skill_id) ON DELETE CASCADE
  
 );

  
  
  CREATE  TABLE `project_master` (

  `project_id` INT NOT NULL AUTO_INCREMENT ,

  `description` VARCHAR(45) NOT NULL ,

  `start_date` DATE NOT NULL ,

  `end_date` DATE NULL ,

  `project_logo` VARCHAR(45) NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`project_id`) );
  
  
  CREATE  TABLE `address` (

  `address_id` INT NOT NULL AUTO_INCREMENT ,

  `emp_code` INT NOT NULL ,

  `add_line_1` VARCHAR(45) NOT NULL ,

  `add_line_2` VARCHAR(45) NULL ,

  `city` VARCHAR(20) NOT NULL ,

  `state` VARCHAR(20) NOT NULL ,

  `pincode` VARCHAR(6) NOT NULL ,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 

  PRIMARY KEY (`address_id`) ,
  
    FOREIGN KEY(emp_code) REFERENCES employee(emp_code) ON DELETE CASCADE
 
   );
   
   
   CREATE  TABLE `job_details` (

  `job_detail_id` INT AUTO_INCREMENT PRIMARY KEY ,

  `emp_code` INT NOT NULL ,

  `date_of_joining` DATE NOT NULL ,

  `total_exp` INT NOT NULL ,

  `job_code` INT NOT NULL ,

  `reporting_manager` INT NOT NULL,

  `team_lead` INT NOT NULL,

  `current_project_id` INT,
  
  `active`  BOOLEAN NOT NULL DEFAULT true, 
  
   FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON DELETE CASCADE ,
   
    FOREIGN KEY (job_code) REFERENCES job_title(job_code) ON DELETE CASCADE ,
    
    FOREIGN KEY (reporting_manager) REFERENCES employee(emp_code) ON DELETE CASCADE ,
     
    FOREIGN KEY (team_lead) REFERENCES employee(emp_code) ON DELETE CASCADE ,
      
   FOREIGN KEY (current_project_id) REFERENCES project_master(project_id) ON DELETE CASCADE 
  
  );