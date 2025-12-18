package org.example.apitestingwitherrorthrowing.Services;

import org.example.apitestingwitherrorthrowing.Exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {
    public void doWork(String fail){
        if(fail.equals("fail")){
            System.out.println("exception is working properly");
            throw new BusinessException("fail");

        }
    }
}
