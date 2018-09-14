package com.metacube.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;

/**
 * It will done email related work
 * @author Shubham Jain
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * It will send email to employee of his passowrd
     * 
     * @param employee
     */
    public void sendEmail(Employee employee) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(employee.getEmail());
        mail.setSubject("Password");
        mail.setText("Hello " + " Your Password is : " + employee.getPassword());
        javaMailSender.send(mail);
    }
}