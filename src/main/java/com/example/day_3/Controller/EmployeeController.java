package com.example.day_3.Controller;

import com.example.day_3.Model.EmployeeModel;
import com.example.day_3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "root/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


 @GetMapping("/doShow")
    public String doShow(){
        return "test successfUl";
    }

    @GetMapping("/list")
    public List<String> getList()
    {
        List<String> list = Arrays.asList("one","two");
        return list;
    }

    @GetMapping("/object")
    public List<EmployeeModel> getDetails()
    {
        List<EmployeeModel> listOne = Arrays.asList(new EmployeeModel(1,"hello","bye","not available","hii"),
                new EmployeeModel(2,"bye","tata","available","bye"));
        return listOne;
    }

    @GetMapping("/callService")
    public List<EmployeeModel> showService()
    {
        return employeeService.getAllItems();
    }


    @PostMapping(path = "posting1")
    public ArrayList<String> addDetails(@RequestBody ArrayList<EmployeeModel> employeeModel)
    {
        ArrayList<String> msg = new ArrayList<String>();

        for(int i =0;i<employeeModel.size();i++)
        {
            employeeService.addItems(employeeModel.get(i));
          msg.add(employeeModel.get(i).getMessage());
            //return msg;

        }
        System.out.println(employeeModel);

        return msg;
    }
    @DeleteMapping("/deleteId/{id}")
    public void deleteEmployee(@PathVariable Integer id)
    {
        employeeService.deleteEmployeeFast(id);
    }

}
